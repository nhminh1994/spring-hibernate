package minh.training.springhibernate.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import minh.training.springhibernate.screenmodels.CustomerDetailData;

public class ExcelReportView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=\"Full-report.xls\"");
		List<CustomerDetailData> customerList = (List<CustomerDetailData>) model.get("customerlist");
		Sheet sheet = workbook.createSheet("Student Data");
		Row header = sheet.createRow(0);
		int cellIdx = 0;
		header.createCell(cellIdx++).setCellValue("ID");
		header.createCell(cellIdx++).setCellValue("Name");
		header.createCell(cellIdx++).setCellValue("Date of Birth");
		header.createCell(cellIdx++).setCellValue("Phone");
		header.createCell(cellIdx++).setCellValue("Email");
		header.createCell(cellIdx++).setCellValue("Gender");
		header.createCell(cellIdx++).setCellValue("Address");
		header.createCell(cellIdx++).setCellValue("Title");

		int rowNum = 1;
		for (CustomerDetailData customer : customerList) {
			cellIdx = 0;
			Row row = sheet.createRow(rowNum++);
			row.createCell(cellIdx++).setCellValue(customer.getId());
			row.createCell(cellIdx++).setCellValue(customer.getName());
			row.createCell(cellIdx++).setCellValue(customer.getDateOfBirth().toString());
			row.createCell(cellIdx++).setCellValue(customer.getPhone());
			row.createCell(cellIdx++).setCellValue(customer.getEmail());
			row.createCell(cellIdx++).setCellValue(customer.getGender()?"Male":"Female");
			row.createCell(cellIdx++).setCellValue(customer.getAddressLine());
			row.createCell(cellIdx++).setCellValue(customer.getTitle());
		}
	}
}
