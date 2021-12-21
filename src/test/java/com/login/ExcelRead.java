package com.login;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
public static void main(String[] args) throws IOException {
	File f = new File("D:\\New folder\\Sample1.xlsx");
	FileOutputStream str = new FileOutputStream(f);
	Workbook w = new XSSFWorkbook();
	w.createSheet("Sheet1").createRow(0).createCell(0).setCellValue("testing");
	w.write(str);
	
	
}
	
	
}
