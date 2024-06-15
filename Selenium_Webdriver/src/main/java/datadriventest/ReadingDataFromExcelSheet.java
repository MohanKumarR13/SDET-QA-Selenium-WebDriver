package datadriventest;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcelSheet {
	static XSSFCell cell;

	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();
		System.out.println("Number Of Rows" + totalRows);
		System.out.println("Number Of Cells" + totalCells);

		for (int r = 0; r <= totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c < totalCells; c++) {
				cell = currentRow.getCell(c);
				System.out.println(cell.toString() + "\t");

			}
			System.out.println();
		}
		workbook.close();
		fileInputStream.close();
	}

}
