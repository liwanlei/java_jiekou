package com.testapi.cas;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import org.testng.annotations.*;
import com.google.gson.Gson;
import com.testapi.until.Getcode;
import com.testapi.until.Makejson;
import com.testapi.until.ParseJson;
import com.testapi.until.ZTestReport;
@Listeners({ZTestReport.class})
public class NewTest {
	@DataProvider(name="DP1")
    public Object[][] createData(){
        return new Object[][] {
            { "{'key':'你好！'}","http://www.tuling123.com", "/openapi/api", "POST","text" ,"40007"}, { "{'key':'你好！'}","http://www.tuling123.com", "/openapi/api", "POST" ,"text","40007"}, 
            { "{'key':'你好！'}","http://www.tuling123.com", "/openapi/api", "POST" ,"text","40007"},  { "{'key':'你好！'}","http://www.tuling123.com", "/openapi/api", "POST","text","40007"}        
        };
    }
  @Test(dataProvider="DP1")
  public void f(String map,String url,String path,String meth,String jsonid,String qiwang) {
	String param1 = Makejson.makejson(map);
	Getcode getcode=new Getcode();
	String resulst=getcode.getHttpResponse(param1, url, path,meth.toUpperCase());
	String bnei=ParseJson.Json(resulst);
	assertEquals(bnei,qiwang);
  }
  @BeforeTest
  public void beforeTest() {
  }
  @AfterTest
  public void afterTest() {
  }

}
