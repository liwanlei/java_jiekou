/*
 * 测试用例运行的主脚本
 * 
 */
package com.testapi.casev;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testapi.until.ExcelUtils;
import com.testapi.until.Getcode;
import com.testapi.until.Makejson;
import com.testapi.until.ParseJson;
import com.testapi.until.ZTestReport;
/*
 * 这里才用了网上开源的java tesng的测试报告模块。
 */
@Listeners({ZTestReport.class})
public class Testapi {
	@DataProvider(name="DP1")//获取测试参数
    public Object[][] createData() throws Exception {
		ExcelUtils excelUtils=new ExcelUtils();
		String path=System.getProperty("user.dir")+File.separator+"casedata"+File.separator+"casedata.xlsx";
    	Object[][] m = ExcelUtils.getTableArray(path,"Sheet1");
		return m;
    }
  @Test(dataProvider="DP1")
  public void f(String url,String path,String meth,String map,String qiwang) {
	String param1 = Makejson.makejson(map);
	Getcode getcode=new Getcode();
	url=url+path;//拼接请求的url
	String resulst=getcode.getHttpResponse(param1, url, meth);
	String bnei=ParseJson.Json(resulst);
	assertEquals(bnei,qiwang);
  }
  @BeforeTest//测试前执行的操作
  public void beforeTest() {
  }
  @AfterTest//测试后执行的操作
  public void afterTest() {
  }
}