/**
 * 发送请求获取相应
 */
package com.testapi.until;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * @author lileilei
 *
 *Getcode.java
 */
public class Getcode {
	private String url="";
	public String geturl() {
		return url;
	}
	public String getHttpResponse(String parm,String url,String meth) {
		String line="";
		String resulst="";
		try {
			HttpURLConnection connection=Urlconnetc.getConnection(url,meth,parm);
			DataOutputStream out=null;
			connection.connect();
			out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(parm.toString());
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
            	resulst = resulst + line.toString();
            }
            reader.close();
            connection.disconnect();
            return resulst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resulst;
	}
}
