package com.testapi.casev;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class jiexizifuchuanjson {
	public Map<String, String> asserttodict( String assertstring) {
		String[] list=assertstring.split("&");
		Map<String, String> map=new HashMap<>();
		for(String item:list) {
			map.put(item.split("=")[0], item.split("=")[1]);
		}
		return map;
	}
	public static Map<String, String> Jsonbackparse(String jsStrings,String assertstring) {
		String[] list=assertstring.split("&");
		Map<String, String> result = null;
		Map<String, Object> res = null;
		if(jsStrings==null) {
			result=null;
			return result ;
		}try {
			Gson gson=new Gson();
			for(String item:list) {
				 res=gson.fromJson(jsStrings, new TypeToken<Map<String, Object>>() {
	            }.getType());
				result.put(item.split("=")[0],(String) res.get(item.split("=")[0]));
			}
			return result ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
