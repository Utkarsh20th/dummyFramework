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

/////////////////////////////////////////////// //home//utkarsh20thgmai//Desktop//TestData.xlsx
       
       private static XSSFSheet ExcelWSheet;

       private static XSSFWorkbook ExcelWBook;

       private static XSSFCell Cell;

       private static XSSFRow Row;
       
       static int i1=0;
       static String s1=null, s2=null, s3=null, s_int=null;

       public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

         String[][] tabArray = null;

         try {

         FileInputStream ExcelFile = new FileInputStream(FilePath);

         // Access the required test data sheet

         ExcelWBook = new XSSFWorkbook(ExcelFile);

         ExcelWSheet = ExcelWBook.getSheet(SheetName);
         
         //
         
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

         // you can write a function as well to get Column count

         //int totalCols = 2;

         tabArray=new String[tr][totalColCount];
         
         // ********* need to start commenting block here
         ci=0;

         for (int i=startRow;i<tr;i++, ci++) {       //////// i<= totalRowCount     

         cj=0;

         for (int j=startCol;j<totalColCount;j++, cj++){        //////// j<= totalColCount

         //tabArray[ci][cj]=getCellData(i,j);

         //System.out.println(tabArray[ci][cj]);  
         tabArray[i][j]=getCellData(i,j);

         System.out.println(tabArray[i][j]);  

         }
         
         System.out.println("||");

         }
         // ********* need to end commenting block here

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
       
       // ***********************************************************************************

       public static String getCellData(int RowNum, int ColNum) throws Exception {

       try{
    	   
       Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

       CellType dataType = Cell.getCellType();
       long result =0;
       String result1=null, result2=null, result3=null;
       
       //
       
       switch (ColNum) {
           case 0: //String value in Excel
               result1 = Cell.getStringCellValue();
               s1 = result1;
               break;
           case 1: //String value in Excel
               result2 = Cell.getStringCellValue();
               s1 = result2;
               break;
           case 2: //String value in Excel
               result3 = Cell.getStringCellValue();
               s1 = result3;
               break;
           case 3: // numeric value in Excel
               result = (long) Cell.getNumericCellValue();
   	           //int i=10;  
   	           //String s=String.valueOf(i);	
               s1 = String.valueOf(result);
               break;
           default:
               throw new RuntimeException("No support for the datatype of this cell");
           }
       

       //if  (i1 == 3) {

       //return "";

       //} else {

       //String CellData = Cell.getStringCellValue();

       //return CellData;

       //}
       
       }catch (Exception e){

       System.out.println(e.getMessage());

       throw (e);

       }
	   return s1;
       
       }
              
}
