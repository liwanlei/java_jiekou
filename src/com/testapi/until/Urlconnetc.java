/**
 * 
 */
package com.testapi.until;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * @author lileilei
 *Urlconnetc.java
 */
public class Urlconnetc {
	/*
	 * 对http请求的简单的封装
	 */
	 public static HttpURLConnection getConnection(String url,String meth,String param){
	        HttpURLConnection connection = null;
	        try {
	            URL postUrl = new URL(url);
	            DataOutputStream out=null;
	            connection = (HttpURLConnection) postUrl.openConnection();
	            connection.setDoOutput(true);
	            connection.setDoInput(true);
	            connection.setUseCaches(false);
	            connection.setRequestMethod(meth);
	            connection.setInstanceFollowRedirects(true);
	            connection.setRequestProperty("Content-Type","application/json");
	            connection.setRequestProperty("Accept","application/json");
	            connection.setInstanceFollowRedirects(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return connection;
	    }
}
