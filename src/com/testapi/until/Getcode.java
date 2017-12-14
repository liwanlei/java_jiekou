/**
 * 
 */
package com.testapi.until;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.SortingFocusTraversalPolicy;
import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
		} catch (Exception e) {
			
		}
		return resulst;
	}
}
