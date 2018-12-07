package com.springboot.core.jpush;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class MyJPushClient {
	protected static final Logger LOG = LoggerFactory
			.getLogger(MyJPushClient.class);

	private String title = "";
	private String message;
	private Map<String, String> extras;

	public static final String REGISTRATION_ID = "0900e8d85ef";

	private JPushClient jpushClient;
	
	public MyJPushClient(String appkey,String mastersecret,String title,String message, Map<String, String> map) {
		this.message = message;
		this.extras = map;
		this.title = title;
		jpushClient = new JPushClient(mastersecret, appkey);
	}

	public long sendPushAll() {
		PushPayload payload = buildPushObject_all_all_alert();
		long msgId = 0;
		try {
			PushResult result = jpushClient.sendPush(payload);
			msgId = result.msg_id;
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.info("HTTP Status: " + e.getStatus());
			msgId = e.getMsgId();
		}
		return msgId;

	}

	/**
	 * 向指定别名的客户端发送消息
	 * 
	 * @param alias
	 *            所有别名信息集合，这里表示发送所有学生编号
	 * @return 消息id
	 */
	public long sendPushAlias(Set<String> alias) {
		PushPayload payloadAlias = buildPushObject_android_ios_alias_alertWithTitle(alias);
		long msgId = 0;
		try {
			PushResult result = jpushClient.sendPush(payloadAlias);
			msgId = result.msg_id;

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
			msgId = e.getMsgId();
		}
		return msgId;
	}
	
	public long sendPushTag(String tag) {
		PushPayload payloadAlias = buildPushObject_android_ios_tag_alertWithTitle(tag);
		long msgId = 0;
		try {
			PushResult result = jpushClient.sendPush(payloadAlias);
			msgId = result.msg_id;

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
			msgId = e.getMsgId();
		}
		return msgId;
	}

	/**
	 * 下列封装了三种获得消息推送对象（PushPayload）的方法
	 * buildPushObject_android_alias_alertWithTitle、
	 * buildPushObject_android_tag_alertWithTitle、 buildPushObject_all_all_alert
	 */
	public PushPayload buildPushObject_android_ios_alias_alertWithTitle(
			Set<String> alias) {
		return PushPayload.newBuilder().setPlatform(Platform.android_ios())
				.setAudience(Audience.alias(alias)).setNotification(Notification.newBuilder()
		                .addPlatformNotification(IosNotification.newBuilder()
		                        .setAlert(message)
		                        .incrBadge(1)
		                        .setSound("happy.caf")
		                        .addExtras(extras)
		                        .build())
		                        .addPlatformNotification(AndroidNotification.newBuilder().addExtras(extras).setAlert(message).setTitle(title).build())
		                .build()).setOptions(Options.newBuilder()
		                .setApnsProduction(true)   //true:生产环境   false:开发环境
		                .build()).build();
	}

	public PushPayload buildPushObject_android_ios_tag_alertWithTitle(String tag) {
		return PushPayload.newBuilder()
		.setPlatform(Platform.android_ios())
		.setAudience(Audience.tag(tag))
		.setNotification(Notification.newBuilder()
                .addPlatformNotification(IosNotification.newBuilder()
                        .setAlert(message)
                        .incrBadge(1)
                        .setSound("happy.caf")
                        .addExtras(extras)
                        .build())
                        .addPlatformNotification(AndroidNotification.newBuilder().addExtras(extras).setAlert(message).setTitle(title).build())
                .build()).setOptions(Options.newBuilder()
                .setApnsProduction(true)   //true:生产环境   false:开发环境
                .build()).build();
	}

	public PushPayload buildPushObject_all_all_alert() {
		return PushPayload.alertAll(message);
	}
	
	
}

