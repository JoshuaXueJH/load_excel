/*
package com.joshua;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class LoadExcel {
    public static void main(String[] args) throws Exception {
        File excelFile = new File("/Users/xuejianhua/Downloads/1.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
        if (wb == null)
            return;
        int numberOfSheets = wb.getNumberOfSheets();

        for (int i = 0; i < numberOfSheets; i++) {
            XSSFSheet sheet = wb.getSheetAt(i);
            if (sheet == null)
                return;
            for (Row row : sheet) {
                String sql = "INSERT INTO \n" +
                        "\tpre_approval(customer_id, source, activity_name, activity_start_time, activity_end_time, product_brand, min_tenure, max_tenure, max_loan_amount, tenure_time_unit, status) \n" +
                        "VALUES \n" +
                        "\t(";
                StringBuilder sb = new StringBuilder();
                sb.append(sql);
                for (int j = 0; j < 5; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null)
                        return;
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String cellContent = cell.getStringCellValue().trim().toUpperCase();
                    if ("".equals(cellContent) || cellContent == null) {
                        break;
                    }
                    if (j == 0) {
                        sb.append(cellContent).append(", '10001', 'Pre-Approval-20190619', '2019-06-19 01:00:00', '2019-06-26 00:59:59', ");
                    }
                    if (j == 1) {
                        sb.append(cellContent).append(",");
                    }
                    if (j == 2) {
                        sb.append(cellContent).append(",").append(cellContent).append(",");
                    }
                    if(j == 3){
                        sb.append(cellContent).append(", 1, 1);");
                    }
                }
                write(sb.toString());
            }
        }
    }

    public static void write(String strs) throws IOException {
        File filename = new File("/Users/xuejianhua/Desktop/preprollist.sql");
        if (!filename.exists()) {
            filename.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(filename, true);
        fileWriter.write(strs + "\n");
        fileWriter.flush();
        fileWriter.close();
    }

}*/
