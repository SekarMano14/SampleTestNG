package org.test.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelData {
	public static void main(String[] args) throws IOException {
		Object[][] data = getData();

		System.out.println(data);
		System.out.println(data[1]);
		System.out.println(data[1][1]);

		for (Object[] x : data) {
			for (Object y : x) {
				System.out.println(y);
			}
		}
	}

	public static Object[][] getData() throws IOException {
		File loc = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Datas.xlsx");

		FileInputStream st = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(st);
		Sheet sheet = w.getSheet("LoginData");
		Row row = sheet.getRow(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = row.getPhysicalNumberOfCells();
		// 7 -1=6 2
		Object[][] obj = new Object[rowCount - 1][cellCount];

		for (int i = 0; i < rowCount - 1; i++) {
			Row rr = sheet.getRow(i + 1);
			for (int j = 0; j < cellCount; j++) {
				Cell cell = rr.getCell(j);
				int type = cell.getCellType();
				// type -0----num ,date
				// type -1---String

				String value = null;
				if (type == 1) {
					value = cell.getStringCellValue();
				} else {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
						value = sf.format(date);
					} else {
						double num = cell.getNumericCellValue();
						long ln = (long) num;
						value = String.valueOf(ln);
					}
				}
				obj[i][j] = value;
			}
		}
		return obj;
	}

	@DataProvider(name = "login",indices= {2,4})
	private Object[][] data() throws IOException {
		Object ob[][] = getData();
		return ob;
	}

	@Test(dataProvider = "login")
	private void test(String user, String pass) {
		System.out.println(user);
		System.out.println(pass);

	}

}
