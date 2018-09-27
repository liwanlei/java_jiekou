/*
 * json解析的字段
 */
package com.testapi.until;

import java.util.List;

public class Json {
	public Intents intent;
	public List<Malldata> results;
	public class Malldata{
		public String groupType;
		public String resultType;
		public Text values;
	}
	public class Intents{
		public String code;
	}
	public class Text{
		public String text;
	}
}
