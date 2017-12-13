package com.testapi.until;

import java.awt.List;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.regexp.internal.recompile;

import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException;  
public class ParesExcel {  
     
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象  
    public ArrayList<String> readExcel(File file) throws IOException {  
    	 String baseurl = null ;
    	 String path=null;
    	 String param=null;
    	 String yuqi=null;
    	 String meth=null;
    	 ArrayList<String> arl = new ArrayList<String>();
        try {  
            // 创建输入流，读取Exscel  
            InputStream is = new FileInputStream(file.getAbsolutePath());  
            // jxl提供的Workbook类  
            Workbook wb = Workbook.getWorkbook(is);  
            // Excel的页签数量  
            int sheet_size = wb.getNumberOfSheets();  
            for (int index = 0; index < sheet_size; index++) {  
                // 每个页签创建一个Sheet对象  
                Sheet sheet = wb.getSheet(index);  
                // sheet.getRows()返回该页的总行数  
//                for (int i = 1; i < sheet.getRows(); i++) {  
                    // sheet.getColumns()返回该页的总列数  
                    for (int j = 1; j < sheet.getRows()-1; j++) {  
                    	baseurl=sheet.getCell(2,j).getContents();
                    	path=sheet.getCell(3,j).getContents();
                    	meth=sheet.getCell(4,j).getContents();
                    	param=sheet.getCell(5,j).getContents();
                    	yuqi=sheet.getCell(6,j).getContents();
                    	arl.add(baseurl);
                    	arl.add(path);
                    	arl.add(meth);
                    	arl.add(param);
                    	arl.add(yuqi);
                }
            } return arl;  
        } catch (FileNotFoundException e) {  
            
        } catch (BiffException e) {  
              
        } catch (IOException e) {  
            
        }  catch(ArrayIndexOutOfBoundsException e) {
        	
        }
		return arl;
    }
    public static void main(String[] args) throws IOException {  
        ParesExcel obj = new ParesExcel();  
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下  
        File file = new File("casedata/casedata.xls");  
        obj.readExcel(file);  
    } 
}  