package com.testapi.casev;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testapi.until.ExcelUtils;
import com.testapi.until.Getcode;
import com.testapi.until.Makejson;
import com.testapi.until.ParseJson;
import com.testapi.until.*;
@Listeners({ZTestReport.class})
public class Testapi {
	@DataProvider(name="DP1")
    public Object[][] createData() throws Exception {
		ExcelUtils excelUtils=new ExcelUtils();
    	Object[][] m = ExcelUtils.getTableArray("casedata\\casedata.xlsx","Sheet1");
		return m;
    }
  @Test(dataProvider="DP1")
  public void f(String url,String path,String meth,String map,String jsonid,String qiwang) {
	String param1 = Makejson.makejson(map);
	Getcode getcode=new Getcode();
	url=url+path;
	String resulst=getcode.getHttpResponse(param1, url,meth.toUpperCase());
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
