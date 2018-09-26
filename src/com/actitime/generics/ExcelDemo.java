package com.actitime.generics;

public class ExcelDemo
{

	public static void main(String[] args)
	{
		System.out.println("Haii....");
		String data=ExcelData.getData("./data/input.xlsx","Sheet1", 0, 0);
        System.out.println(data);
		int rc=ExcelData.getRowCount("./data/input.xlsx","Sheet1");
		System.out.println(rc);
		int cc=ExcelData.getCellCount("./data/input.xlsx","Sheet1", 0);
		System.out.println(cc);
	}
}
