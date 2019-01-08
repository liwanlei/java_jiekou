package com.testapi.casev;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class mss {
	public static Map<String, Object> json2map(String str_json) {
        Map<String, Object> res = null;
        try {
            Gson gson = new Gson();
            res = gson.fromJson(str_json, new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
        }
        return res;
    }
	public static void main(String[] args) {
		mss ms1=new mss();
		Map<String,Object> map=new HashMap<>();
		map=ms1.json2map("{'code':1}");
		System.out.println(map.get("code1").toString());
	}
}
