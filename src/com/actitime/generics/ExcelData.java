package com.actitime.generics;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
      public static String getData(String filepath,String sheetName,int rn,int cn)
      {
    	  try
    	  {
    		  FileInputStream fis=new FileInputStream(new File(filepath));
    		  Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
    		  String data=sh.getRow(rn).getCell(cn).getStringCellValue();
    		  return data;
    	  }
    	  catch(Exception e)
    	  {
    		  return "";
    	  }
      }
      public static int getRowCount(String filepath,String sheetName)
      {
    	  try
    	  {
    		  FileInputStream fis=new FileInputStream(new File(filepath));
    		  Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
    		  int rc=sh.getLastRowNum();
    		  return rc;
    	  }
    	  catch(Exception e)
    	  {
    		  return 0;
    	  }
      }
      public static int getCellCount(String filepath,String sheetName,int rn)
      {
    	  try
    	  {
    		  FileInputStream fis=new FileInputStream(new File(filepath));
    		  Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
    		  int cn = sh.getRow(rn).getLastCellNum();
    		  return cn;
    	  }
    	  catch(Exception e)
    	  {
    		  return 0;
    	  }
      }
}
