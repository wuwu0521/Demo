package com.springboot.core.db;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

	String name() default DataSource.DATASOURCE_A;

	public static final String DATASOURCE_A = "silverbox";

	public static final String DATASOURCE_B = "waimai";

}
