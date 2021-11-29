package utilities;

import lombok.SneakyThrows;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelMaganer {
    public static final String       testDataExcelFileName = "magazalar.xlsx";
    public static final String       currentDir            = System.getProperty("user.dir");
    public static       String       testDataExcelPath     = null;
    private static      XSSFWorkbook excelWBook;
    private static      XSSFSheet    excelWSheet;
    private static      XSSFCell     cell;
    @SneakyThrows
    public static void setExcelFileSheet(String sheetName) {

            testDataExcelPath = currentDir + "\\src\\main\\resources\\";

        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        System.out.println(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
    }
    @SneakyThrows
    public static void setCellData(ArrayList<String> magazalar) {
        int rowCount = 0;
        XSSFRow newRow = excelWSheet.createRow(rowCount);
            for(int i = 0 ; i<magazalar.size();i++){
                for (int j = 0; j<10;j++){
                    if(i<magazalar.size()){
                        cell = newRow.createCell(j);
                        cell.setCellValue(magazalar.get(i));
                        i++;
                    }
                }
                rowCount += 1;
                newRow = excelWSheet.createRow(rowCount);
            }
        FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}

