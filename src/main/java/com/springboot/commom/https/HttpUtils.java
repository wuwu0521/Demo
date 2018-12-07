package com.springboot.commom.https;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import com.springboot.core.CoreResponse;
import com.springboot.core.CoreResponse.StatusInfo;

public class HttpUtils {
	
	public static final int SOCKET_TIMEPOT = 6000;
	
	public static final int CONNECT_TIMEPOT = 6000;
	
	public static final String DEFAULT_CHARSET = "UTF-8";
	
	public static CoreResponse<String> doPostForm(String url, Map<String, String> data) {
		return doPostForm(url, data, SOCKET_TIMEPOT, CONNECT_TIMEPOT, DEFAULT_CHARSET);
	}
	
	public static CoreResponse<String> doPostForm(String url, Map<String, String> data, String defaultCharset) {
		return doPostForm(url, data, SOCKET_TIMEPOT, CONNECT_TIMEPOT, defaultCharset);
	}
	
	public static CoreResponse<String> doPostForm(String url, Map<String, String> data, int socketTimeout, int connectTimeout) {
		return doPostForm(url, data, socketTimeout, connectTimeout, DEFAULT_CHARSET);
	}
	
	/**
	 * Form表单式提交
	 * @param url
	 * @param data
	 * @param socketTimeout
	 * @param connectTimeout
	 * @return
	 */
	public static CoreResponse<String> doPostForm(String url, Map<String, String> data, int socketTimeout, int connectTimeout, String defaultCharset) {
		CoreResponse<String> res = new CoreResponse<String>(StatusInfo.BUSINESS);
		String result = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();

		List<BasicNameValuePair> param = new ArrayList<BasicNameValuePair>();
		if (data != null) {
			for (String key : data.keySet()) {
				param.add(new BasicNameValuePair(key, data.get(key)));
			}
		}

		HttpPost httppost = new HttpPost(url);
		UrlEncodedFormEntity uefEntity;
		
		//设置超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
		httppost.setConfig(requestConfig);
		
		try {
			uefEntity = new UrlEncodedFormEntity(param, defaultCharset);
			httppost.setEntity(uefEntity);
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				if (response.getStatusLine().getStatusCode() == 200) {
					res.setStatusInfo(StatusInfo.SUCCESS);
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity, defaultCharset);
					}
				}
			} finally {
				response.close();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		res.setData(result);
		return res;
	}
	
	public static CoreResponse<String> doPostJson(String url, String jsonStr) {
		return doPostJson(url, jsonStr, SOCKET_TIMEPOT, CONNECT_TIMEPOT, DEFAULT_CHARSET);
	}
	
	public static CoreResponse<String> doPostJson(String url, String jsonStr, String defaultCharset) {
		return doPostJson(url, jsonStr, SOCKET_TIMEPOT, CONNECT_TIMEPOT, defaultCharset);
	}
	
	public static CoreResponse<String> doPostJson(String url, String jsonStr, int socketTimeout, int connectTimeout) {
		return doPostJson(url, jsonStr, socketTimeout, connectTimeout, DEFAULT_CHARSET);
	}

	/**
	 * json格式提交
	 * @param url
	 * @param jsonStr
	 * @param socketTimeout
	 * @param connectTimeout
	 * @return
	 */
	public static CoreResponse<String> doPostJson(String url, String jsonStr, int socketTimeout, int connectTimeout, String defaultCharset) {
		CoreResponse<String> res = new CoreResponse<String>(StatusInfo.BUSINESS);
		String result = null;
		
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httppost = new HttpPost(url);

		StringEntity strEntity = null;
		
		//设置超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
		httppost.setConfig(requestConfig);

		try {
			if (!StringUtils.isEmpty(jsonStr)) {
				strEntity = new StringEntity(jsonStr, defaultCharset);
				strEntity.setContentEncoding(defaultCharset);
				strEntity.setContentType("application/json");
				httppost.setEntity(strEntity);
			}

			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				if (response.getStatusLine().getStatusCode() == 200) {
					res.setStatusInfo(StatusInfo.SUCCESS);
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity, defaultCharset);
					}
				}
			} finally {
				response.close();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		res.setData(result);
		return res;
	}
	
	public static CoreResponse<String> doGet(String url) {
		return doGet(url, SOCKET_TIMEPOT, CONNECT_TIMEPOT, DEFAULT_CHARSET);
	}
	
	public static CoreResponse<String> doGet(String url, String defaultCharset) {
		return doGet(url, SOCKET_TIMEPOT, CONNECT_TIMEPOT, DEFAULT_CHARSET);
	}
	
	public static CoreResponse<String> doGet(String url, Map<String, String> data) {
		return doGet(url, data, SOCKET_TIMEPOT, CONNECT_TIMEPOT, DEFAULT_CHARSET);
	}
	
	public static CoreResponse<String> doGet(String url, int socketTimeout, int connectTimeout) {
		return doGet(url, socketTimeout, connectTimeout, DEFAULT_CHARSET);
	}
	
	public static CoreResponse<String> doGet(String url, Map<String, String> data, int socketTimeout, int connectTimeout) {
		return doGet(url, data, socketTimeout, connectTimeout, DEFAULT_CHARSET);
	}
	
	
	/**
	 * get请求
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public static CoreResponse<String> doGet(String url, Map<String, String> data, int socketTimeout, int connectTimeout ,String defaultCharset) {
		if (data != null) {
			Set<String> keys = data.keySet();
			if (keys != null && !keys.isEmpty()) {
				StringBuilder sb = null;
				for (String key : keys) {
					if (sb == null) {
						sb = new StringBuilder(url);
						sb.append("?");
					} else {
						sb.append("&");
					}
					sb.append(key).append("=").append(data.get(key));
				}
				url = sb.toString();
			}
		}
		return doGet(url, socketTimeout, connectTimeout, defaultCharset);
	}

	/**
	 * get请求
	 * @param url
	 * @param socketTimeout
	 * @param connectTimeout
	 * @param defaultCharset
	 * @return
	 */
	public static CoreResponse<String> doGet(String url, int socketTimeout, int connectTimeout, String defaultCharset) {

		CoreResponse<String> res = new CoreResponse<String>(StatusInfo.BUSINESS);
		String result = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httpget
		HttpGet httpget = new HttpGet(url);
		
		
		//设置超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
		httpget.setConfig(requestConfig);
		
		try {
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			// 获取响应实体
			try {
				if (response.getStatusLine().getStatusCode() == 200) {
					res.setStatusInfo(StatusInfo.SUCCESS);
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						result = EntityUtils.toString(entity, defaultCharset);
					}
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		res.setData(result);
		return res;
	}
	
	/**
	 * 转发请求
	 * @param action
	 * @param paramTemp
	 * @param timeoutConnection     设置连接超时时间（毫秒）
	 * @param timeoutSocket			设置默认的套接字超时（so_timeout毫秒）。这是为了等待数据超时。
	 * @return String 请求返回结果
	 */
	public static String buildRequest(String url,Map<String, String> nameValuePair,int timeoutConnection,int timeoutSocket,
			String charset){
		String response = "";
//		//构造HttpClient的实例  
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();  
// 
//		//根据默认超时限制初始化requestConfig
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeoutSocket).setConnectTimeout(timeoutConnection).build();
		
		try {
			HttpPost httpPost = new HttpPost(url);  
			//设置请求器的配置
	        httpPost.setConfig(requestConfig);
			//设置httpPost请求参数  
			if(null!=charset&&(charset.compareToIgnoreCase("GBK")==0||charset.compareToIgnoreCase("GB3212")==0)){
				//设置httpPost请求参数  
				httpPost.setEntity(new UrlEncodedFormEntity(generatNamePair(nameValuePair),"GBK"));  
			}else{
				//设置httpPost请求参数  
				httpPost.setEntity(new UrlEncodedFormEntity(generatNamePair(nameValuePair),"UTF-8"));  
			}
			
			//使用execute方法发送HTTP Post请求，并返回HttpResponse对象  
			HttpResponse httpResponse = httpClient.execute(httpPost);  
				
			int statusCode = httpResponse.getStatusLine().getStatusCode();  
			if(statusCode==HttpStatus.SC_OK){  
				response = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");  
			}else{  
				response = "{\"error_response\":\"request failed\"}";
			}
		}catch (ClientProtocolException e) {
			e.printStackTrace();
			response = "{\"is_success\":\"F\",\"error_code\":\"ClientProtocolException\"}";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			response = "{\"is_success\":\"F\",\"error_code\":\"IllegalStateException\"}";
		} catch (IOException e) {
			e.printStackTrace();
			response = "{\"is_success\":\"F\",\"error_code\":\"IOException\"}";
		} catch (Exception e) {
			e.printStackTrace();
			response = "{\"is_success\":\"F\",\"error_code\":\""+e.getMessage()+"\"}";
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    return response;
	}
	
	/** 
	 * 使用PSOT方式，必须用NameValuePair数组传递参数  
     * 把Parameter类型集合转换成NameValuePair类型集合 
     * @param params 参数集合 
     * @return List<BasicNameValuePair>
     */  
    private static List<NameValuePair> generatNamePair(Map<String, String> paramTemp){ 
        List<NameValuePair> result = new ArrayList<NameValuePair>(0);  
        if(null!=paramTemp&&paramTemp.size()>0){
        	for(Iterator<String> i = paramTemp.keySet().iterator(); i.hasNext();) {
        		Object obj = i.next();
        		result.add(new BasicNameValuePair(obj.toString(), paramTemp.get(obj)));
        	}
        }
        return result;  
    }
}
