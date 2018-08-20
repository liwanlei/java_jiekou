package com.testapi.until;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
       String[][]tabArray = null;
       try {
           FileInputStream ExcelFile = new FileInputStream(FilePath);
           ExcelWBook = new XSSFWorkbook(ExcelFile);
           ExcelWSheet = ExcelWBook.getSheet(SheetName);
           int startRow = 1;
           int startCol = 1;
           int ci,cj = 0;
           int totalRows = ExcelWSheet.getLastRowNum();
           int totalCols = 2;
           tabArray=new String[totalRows][5];
           ci=0;
           cj=0;
           int cm = 0;int cl = 0;int ch = 0;
           for (int i=startRow;i<=totalRows;i++, ci++) {   
                   tabArray[ci][0]=getCellData(i,2);
                   tabArray[ci][1]=getCellData(i,3);
                   tabArray[ci][2]=getCellData(i,4);
                   tabArray[ci][3]=getCellData(i,5);
                   tabArray[ci][4]=getCellData(i,6);
                } 
            }
        catch (FileNotFoundException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
            }
        catch (IOException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
            }
        return(tabArray);
        }
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            int dataType = Cell.getCellType();
            if  (dataType == 3) {
                return "";
            }
            else{
                String CellData = Cell.getStringCellValue();
                return CellData;
            }
        }
            catch (Exception e){
            	throw (e);
            }
        }
    }
