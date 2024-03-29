package com.zlebank.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zlebank.common.exception.MyBusinessRuntimeException;

/**
 * @author Donald
 * @createdate 2016年4月8日
 * @version 1.0 
 * @description :工具类，如有不满足可自行扩展
 */
public class HttpClientUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class); 

	/**
	 * @param url 形如：http://ip:port/xxx/xxx
	 * @param paramMap post提交的参数
	 * @param charset  设置特点字符集，默认为utf-8
	 * @return 返回http 的状态（status）、回执内容(entity-->HttpEntity 可根据自己需求解析HttpEntity对象)
	 */
	public static Map<String, Object> sendPost(String url, Map<String, String> paramMap, String charset){
		
		if(url==null){
			logger.error("url is null ");
			throw new MyBusinessRuntimeException("url is null");
		}		
        // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost(url);  
        // 创建参数队列    
        List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();  
        //处理参数
        for(Entry<String,String> entry:paramMap.entrySet()){
        	String key = entry.getKey();
        	String value = entry.getValue();
            formparams.add(new BasicNameValuePair(key, value));  

        }
        //return map
        Map<String, Object> retMap = new HashMap<String, Object>();
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, charset==null?"UTF-8":charset);  
            httppost.setEntity(uefEntity);  
            logger.info("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                	logger.info("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                }
                retMap.put("status", response.getStatusLine());
                retMap.put("entity", entity);
            } finally {  
                closeConnect(response); 
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
        	closeConnect(httpclient);
        }  
		
		return retMap;
	}
	
	
	/**
	 * @param url 形如：http://ip:port/xxx/xxx?key=value
	 * @param charset  设置特点字符集，默认为utf-8
	 * @return 返回http 的状态（status）、回执内容(entity-->HttpEntity 可根据自己需求解析HttpEntity对象) 
	 * 
	 */
	public static Map<String, Object> sendGet(String url, String charset){
		if(url==null){
			logger.error("url is null ");
			throw new MyBusinessRuntimeException("url is null");
		}	
		
        CloseableHttpClient httpclient = HttpClients.createDefault(); 
        //return map
        Map<String, Object> retMap = new HashMap<String, Object>();

        try {  
            // 创建httpget.    
            HttpGet httpget = new HttpGet(url);  
            logger.info("executing request " + httpget.getURI());  
            // 执行get请求.    
            CloseableHttpResponse response = httpclient.execute(httpget);  
            try {  
                // 获取响应实体    
                HttpEntity entity = response.getEntity();  
                // 打印响应状态    
                logger.info("Response status: " + response.getStatusLine());
                if (entity != null) {  
                    // 打印响应内容    
                	logger.info("Response content: " + EntityUtils.toString(entity));  
                }  
                retMap.put("status", response.getStatusLine());
                retMap.put("entity", entity);

            } finally {  
               closeConnect(response);
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
        	closeConnect(httpclient); 
        }  
        
        return retMap;

	}

		
	/**
	 * @param response
	 * 关闭链接
	 */
	private static void closeConnect(CloseableHttpResponse response){
		
		try {
			response.close();
		} catch (IOException e) {
			logger.error("close connection falure");
			e.printStackTrace();
		}
	}
	
	/**
	 * @param httpclient
	 * 关闭链接
	 */
	private static void closeConnect(CloseableHttpClient httpclient){
		
		try {
			httpclient.close();
		} catch (IOException e) {
			logger.error("close connection falure");
			e.printStackTrace();
		}
	}


}
