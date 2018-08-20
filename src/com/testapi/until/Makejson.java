package com.testapi.until;
import com.google.gson.Gson;
public class Makejson {
	private static String param1;

	/*
	 * 传入字符串，转成json格式，转化异常默认返回null
	 */
	public static String makejson(String map) {
		try {
			Gson gson=new Gson();
			String param1=gson.toJson(map);
		} catch (Exception e) {
			String param1=null;
		}
		
		return param1;
	}
}
