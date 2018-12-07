package com.springboot.commom.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

/**
 * 集合工具类
 * 
 * @author YaoXuYang
 * @date 2017年12月18日
 * @description
 */
public class Utils {

	public static boolean isEmpty(String str) {
		if ((str == null) || ("".equals(str)) || ("null".equals(str.toLowerCase()))) {
			return true;
		}
		String pattern = "\\S";
		Pattern p = Pattern.compile(pattern, 34);
		Matcher m = p.matcher(str);
		return !m.find();
	}

	public static boolean isEmpty(Collection<?> col) {
		if ((null == col) || (col.isEmpty())) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Map<?, ?> map) {
		if ((null == map) || (map.isEmpty())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断指定的对象数组是否为空
	 * 
	 * @param objArr
	 *            对象数组
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws
	 *                [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isEmpty(Object[] objArr) {
		if ((null == objArr) || (objArr.length < 1)) {
			return true;
		}
		return false;
	}

	/**
	 * 新订单号生成规则(订单总长度为27位纯数字)，+为连接符 fore=年月日时分秒（14位） shopId=8位，不够前面补0 00009356
	 * rand=5位 base=shopId+rand base1=base>>2 右移两位 base2=base^base1 与右移后按位异或
	 * orderNum=fore+base2
	 * 
	 * @param shopId
	 * @return
	 */
	public synchronized static String createOrderNum(Integer shopId) {
		String fore = CalendarUtil.format2yyyyMMddHHmmss(new Date());
		long rand = 0L;
		while (rand < 10000) {
			rand = (long) (Math.random() * 100000);
		}
		String base = shopId + "" + rand;
		long base1 = Long.valueOf(base) >> 2;
		String base2 = String.format("%0" + 13 + "d", (Long.valueOf(base)) ^ base1);
		String ordernum = fore + base2;
		return ordernum;
	}

	@SuppressWarnings("unchecked")
	public static <T> T deepCloneObject(T obj) {
		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(obj);

			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			return (T) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * json对象转map
	 * 
	 * @param jo
	 * @return
	 */
	public static Map<String, String> jsonToMap(JSONObject jo) {
		Map<String, String> result = new HashMap<String, String>();
		Set<String> keySet = jo.keySet();
		for (String key : keySet) {
			result.put(key, jo.getString(key));
		}
		return result;
	}
	
	/** 
     * 大陆手机号码11位数，匹配格式：前2位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+任意数 
     * 18+任意数 
     * 17+任意数 
     * 14+任意数
     */  
    public static boolean isChinaPhoneLegal(String str){  
        String regExp = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-8])|(14[0-9]))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();
    } 
    
    /**
	 * 记录异常堆栈详情
	 * 
	 * @param e
	 * @return
	 */
	public static String log4jDetail(Throwable e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return sw.toString();
		} catch (Exception e2) {
			e.printStackTrace();
		}
		return "服务忙";
	}
	
	/**
     * 拼接订单序号，不足4位补足
     * @param orderSeq
     * @return
     */
    public static String getOrderSeq(Integer orderSeq) {
		if (null == orderSeq) {
			return "0000";
		} else {
			String orderSeqStr = String.valueOf(orderSeq);
			if (orderSeqStr.length() == 1) {
				return "000" + orderSeqStr;
			} else if (orderSeqStr.length() == 2) {
				return "00" + orderSeqStr;
			} else if (orderSeqStr.length() == 1) {
				return "0" + orderSeqStr;
			} else {
				return orderSeqStr;
			}
		}
	}
}
