package datadriventest;

import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingDataIntoExcel {

	public static void main(String[] args) throws Exception {
		FileOutputStream fileInputStream = new FileOutputStream(
				System.getProperty("user.dir") + "\\testdata\\myfile_dynamic.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DynamicData");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter how many rows");
		int noOfRows = scanner.nextInt();

		System.out.println("Enter how many cells");
		int noOfCells = scanner.nextInt();
		for (int r = 0; r <= noOfRows; r++) {

			XSSFRow currentRow = sheet.createRow(r);
			for (int c = 0; c < noOfCells; c++) {
				XSSFCell cell = currentRow.createCell(c);
				cell.setCellValue(scanner.next());
			}
		}

		workbook.write(fileInputStream);
		workbook.close();
		fileInputStream.close();

		System.out.println("File is created....");
	}

}
