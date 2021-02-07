package framework.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
       
       private static XSSFSheet ExcelWSheet;

       private static XSSFWorkbook ExcelWBook;

       private static XSSFCell Cell;

       private static XSSFRow Row;
       
       static long long_result=0;
       static String string_result=null;

       public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

         String[][] tabArray = null;

         try {

         FileInputStream ExcelFile = new FileInputStream(FilePath);
         
         ExcelWBook = new XSSFWorkbook(ExcelFile);
         ExcelWSheet = ExcelWBook.getSheet(SheetName);
         XSSFRow row = ExcelWSheet.getRow(0);
         
         int totalRowCount = ExcelWSheet.getLastRowNum();
         int totalColCount = row.getLastCellNum();
         
         System.out.println("Total Number of Rows in the excel are : "+totalRowCount);
         System.out.println("Total Number of Columns in the excel are : "+totalColCount);
         System.out.println("||");
         
         //

         int startRow = 0;
         int startCol = 0;
         int ci,cj;
         int totalRows = ExcelWSheet.getLastRowNum();
         int tr = totalRowCount + 1;

         tabArray=new String[tr][totalColCount];
         ci=0;

         for (int i=startRow;i<tr;i++, ci++) {
        	 cj=0;

             for (int j=startCol;j<totalColCount;j++, cj++){
            	 tabArray[i][j]=getCellData(i,j);
            	 System.out.println(tabArray[i][j]);
            	 
             }
             
             System.out.println("||");

         }
         
       }

       catch (FileNotFoundException e){

       System.out.println("Cannot find Excel data file");

       e.printStackTrace();

       }

       catch (IOException e){

       System.out.println("Error while reading/writing in Excel data file");

       e.printStackTrace();

       }

       return(tabArray);

       }

       public static String getCellData(int RowNum, int ColNum) throws Exception {

       try{
       
    // concept of reading cell values, referred from --> toolsqa.com
       Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
       CellType dataType = Cell.getCellType();
       
       switch (ColNum) {
           case 0:
               string_result = Cell.getStringCellValue();
               break;
           case 1: 
        	   string_result = Cell.getStringCellValue();
               break;
           case 2:
        	   string_result = Cell.getStringCellValue();
               break;
           case 3:
               long_result = (long) Cell.getNumericCellValue();	
               string_result = String.valueOf(long_result);
               break;
           default:
               throw new RuntimeException("Invalid value");
           }
       
       }catch (Exception e){

       System.out.println(e.getMessage());

       throw (e);

       }
	   return string_result;
       
       }
              
}
