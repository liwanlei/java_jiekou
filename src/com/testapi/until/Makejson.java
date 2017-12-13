package com.testapi.until;
import java.util.HashMap;
import com.google.gson.Gson;
public class Makejson {
	/*
	 * 传入字符串，转成json格式
	 */
	public static String makejson(String map) {
		Gson gson=new Gson();
		String param1=gson.toJson(map);
		return param1;
	}
}
