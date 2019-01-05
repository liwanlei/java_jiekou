/*
 * 濞村鐦悽銊ょ伐鏉╂劘顢戦惃鍕瘜閼存碍婀�
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
 * 鏉╂瑩鍣烽幍宥囨暏娴滃棛缍夋稉濠傜磻濠ф劗娈慾ava tesng閻ㄥ嫭绁寸拠鏇熷Г閸涘﹥膩閸фぜ锟斤拷
 */

@Listeners({ZTestReport.class})
public class Testapi {
	@DataProvider(name="DP1")//閼惧嘲褰囧ù瀣槸閸欏倹鏆�
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
	url=url+path;//閹峰吋甯寸拠閿嬬湴閻ㄥ増rl
	String resulst=getcode.getHttpResponse(param1, url, meth);
	String bnei=ParseJson.Json(resulst);
	assertEquals(bnei,qiwang);
  }
  @BeforeTest//濞村鐦崜宥嗗⒔鐞涘瞼娈戦幙宥勭稊
  public void beforeTest() {
  }
  @AfterTest//濞村鐦崥搴㈠⒔鐞涘瞼娈戦幙宥勭稊
  public void afterTest() {
  }
}