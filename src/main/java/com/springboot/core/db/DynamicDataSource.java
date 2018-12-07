package com.springboot.core.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 配置动态数据源，系统使用该数据源
 * @description
 * @author cjx
 * @date 2018年5月25日
 */
@Component("dynamicDataSource")
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {
	
    private ApplicationContext applicationContext;
    private String defaultDataSource = com.springboot.core.db.DataSource.DATASOURCE_A ;
    
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }

    @Override
    protected Object resolveSpecifiedLookupKey(Object lookupKey) {
        return super.resolveSpecifiedLookupKey(lookupKey);
    }

    @Override
    public void afterPropertiesSet() {
    	//从spring环境中获取注册的数据源
        Map<String, DataSource> dataSources = applicationContext.getBeansOfType(DataSource.class);
        if (dataSources.size() == 0) {
            throw new IllegalStateException("Datasource can not found!!!");
        }

        // exclude current datasource
        Map<Object, Object> targetDataSource = excludeCurrentDataSource(dataSources);
        setTargetDataSources(targetDataSource);

        // 默认数据源设置
        setDefaultTargetDataSource(targetDataSource.get(getDefaultDataSource()));

        super.afterPropertiesSet();
    }

    /**
     * 设置多个数据源到map
     * @param dataSources
     * @return
     */
    private Map<Object, Object> excludeCurrentDataSource(Map<String, DataSource> dataSources) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        Iterator<String> keys = dataSources.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!(dataSources.get(key) instanceof DynamicDataSource)) {
                targetDataSource.put(key, dataSources.get(key));
            }
        }
        return targetDataSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getDefaultDataSource() {
        return defaultDataSource;
    }

    public void setDefaultDataSource(String defaultDataSource) {
        this.defaultDataSource = defaultDataSource;
    }
}
