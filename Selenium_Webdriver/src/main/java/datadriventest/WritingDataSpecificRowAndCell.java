package datadriventest;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataSpecificRowAndCell {
	static XSSFCell cell;

	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\testdata\\myFileRandom.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.createRow(3);
		XSSFCell cell = row.createCell(4);
		cell.setCellValue("Welcome");
		workbook.close();
		fileInputStream.close();
		System.out.println("File is created....");

	}

}
