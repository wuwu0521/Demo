package com.springboot.core.jpush;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JpushUtil {
	//推送类型
	public static enum PushType  
    {  
        TAG, ALIAS  
    };  
	
	//商家APP极光推送配置参数-旧版（个人帐号）
	private static final String APP_APPKEY_OLD = "cfd0ec84efa515da571eb308";
	private static final String APP_MASTERSECRET_OLD = "2d2dfe30b5e63f4a164e7957";
	private static final String APP_TITLE_OLD = "便利宝商家版";
	
	//商家APP极光推送配置参数-旧版（个人帐号）
	private static final String APP_APPKEY = "c2e3c3a2e0eb6acc13044f20";
	private static final String APP_MASTERSECRET = "7f923eb277abe0595404ad72";
	private static final String APP_TITLE = "便利宝商家版";
	
	
	//平板云POS极光推送配置参数
	private static final String TABLET_POS_APPKEY = "f5e09df339cf2ddd11ea16f6";
	private static final String TABLET_POS_MASTERSECRET = "daa94b18a1d7d4f2ad9a6cd7";
	private static final String TABLET_POS_TITLE = "银盒子云POS";
	
	//平板排队系统极光推送配置参数
	private static final String TABLET_LINEUP_APPKEY = "e638e5be4bf4e73c8700e25a";
	private static final String TABLET_LINEUP_MASTERSECRET = "619af4f63b0d2bb0449f8c27";
	private static final String TABLET_LINEUP_TITLE = "银盒子排队系统";
	
	/**
	 * 发送商家APP平板云POS网络订单消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4APPAndTablet(String message ,String uid,Map<String, String> extras) {
		pushMessage4APPAndTabletV2(message, uid, extras);
	}
	
	/**
	 * 发送商家APP平板云POS网络订单消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4APPAndTabletV2(String message ,String uid,Map<String, String> extras) {
		MyJPushClient appJce_old = new MyJPushClient(APP_APPKEY_OLD, APP_MASTERSECRET_OLD, APP_TITLE_OLD, message, extras);
		appJce_old.sendPushTag(uid);
		MyJPushClient appJce = new MyJPushClient(APP_APPKEY, APP_MASTERSECRET, APP_TITLE, message, extras);
		appJce.sendPushTag(uid);
		MyJPushClient tabletJce = new MyJPushClient(TABLET_POS_APPKEY, TABLET_POS_MASTERSECRET, TABLET_POS_TITLE, message, extras);
		tabletJce.sendPushTag(uid);
	}
	
	/**
	 * 发送商家APP网络订单消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4APPV2(String message ,String uid,Map<String, String> extras) {
		MyJPushClient appJce_old = new MyJPushClient(APP_APPKEY_OLD, APP_MASTERSECRET_OLD, APP_TITLE_OLD, message, extras);
		appJce_old.sendPushTag(uid);
		MyJPushClient appJce = new MyJPushClient(APP_APPKEY, APP_MASTERSECRET, APP_TITLE, message, extras);
		appJce.sendPushTag(uid);
	}
	
	
	/**
	 * 发送商家APP平板云POS网络订单消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4APPAndTabletV1(String message ,String uid,Map<String, String> extras) {
		APPJPushClient appJce = new APPJPushClient(message, extras);
		appJce.sendPushTag(uid);
		TabletJPushClient tabletJce = new TabletJPushClient(message, extras);
		tabletJce.sendPushTag(uid);
	}
	
	/**
	 * 只发送平板云POS消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4Tablet(String message ,String uid,Map<String, String> extras) {
		pushMessage4TabletV2(message, uid, extras);
	}
	
	/**
	 * 只发送平板云POS消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4TabletV1(String message ,String uid,Map<String, String> extras) {
		TabletJPushClient tabletJce = new TabletJPushClient(message, extras);
		tabletJce.sendPushTag(uid);
	}
	
	/**
	 * 只发送平板云POS消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4TabletV2(String message ,String uid,Map<String, String> extras) {
		MyJPushClient tabletJce = new MyJPushClient(TABLET_POS_APPKEY, TABLET_POS_MASTERSECRET, TABLET_POS_TITLE, message, extras);
		tabletJce.sendPushTag(uid);
	}
	
	/**
	 * 只发送平板排队系统消息推送
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushMessage4LineUpTablet(String message ,String uid,Map<String, String> extras) {
		MyJPushClient tabletJce = new MyJPushClient(TABLET_LINEUP_APPKEY, TABLET_LINEUP_MASTERSECRET, TABLET_LINEUP_TITLE, message, extras);
		tabletJce.sendPushTag(uid);
	}
	
	/**
	 * 推送扫码下单消息到商家APP
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushSweepOrderMessage4ShopperAPP(PushType pushType,String message ,String uid,Map<String, String> extras) {
		MyJPushClient appJce = new MyJPushClient(APP_APPKEY, APP_MASTERSECRET, APP_TITLE, message, extras);
		if(PushType.ALIAS.equals(pushType)) {
			Set<String> alias = new HashSet<String>();
			alias.add(uid);
			appJce.sendPushAlias(alias);
		} else if(PushType.TAG.equals(pushType)) {
			appJce.sendPushTag(uid);
		}
	}
	
	/**
	 * 推送扫码下单消息到平板POS
	 * @param message
	 * @param uid
	 * @param extras
	 */
	public static void pushSweepOrderMessage4Tablet(PushType pushType,String message ,String uid,Map<String, String> extras) {
		MyJPushClient tabletJce = new MyJPushClient(TABLET_POS_APPKEY, TABLET_POS_MASTERSECRET, TABLET_POS_TITLE, message, extras);
		if(PushType.ALIAS.equals(pushType)) {
			Set<String> alias = new HashSet<String>();
			alias.add(uid);
			tabletJce.sendPushAlias(alias);
		} else if(PushType.TAG.equals(pushType)) {
			tabletJce.sendPushTag(uid);
		}
	}
	
	
	public static void main(String[] args) {
		//此处为客户端要解析的代码
//		Map<String, String> extras = new HashMap<String, String>();
//		extras.put("msg", "您有新订单了4~");
//		extras.put("success", "true");
//		extras.put("orderNum", "1447411775c369f50d");
//		JpushUtil.pushMessage4APPAndTablet("您有新订单了4", "125541", extras);
		
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("tableTypeId", 4+"");
		msg.put("msg",  "手机号：15258828094,顾客已排队");
		msg.put("lineUpInfoId", 5+"");
		msg.put("type", "lineUp");
		
		pushMessage4LineUpTablet("您有新的排队信息", "125541", msg);
		
//		APPJPushClient appJce = new APPJPushClient("您有新订单了", extras);
//		Set<String> alias = new HashSet<String>();
//		alias.add("9052_4922");
//		appJce.sendPushAlias(alias);
	}
	
}
