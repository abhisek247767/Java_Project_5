package com.first.demo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class ExcelController {

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportToExcel() throws IOException {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        
        // Create a new sheet
        Sheet sheet = workbook.createSheet("Product Data");

        // Create headers
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ID");
        headerCell.setCellStyle(headerCellStyle);

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerCellStyle);

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Price");
        headerCell.setCellStyle(headerCellStyle);

        // Add data to the sheet
        // Replace this with your own logic to fetch data from the database or any other source
        // and populate the rows accordingly
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(100);
        dataRow.createCell(1).setCellValue("Mouse");
        dataRow.createCell(2).setCellValue(2000.0);

        // Auto-size the columns
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Convert workbook to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        // Set response headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=product_data.xlsx");

        // Return the Excel file as a byte array in the response
        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }
}
