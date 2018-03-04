package com.zaghir.excelPoi;

import com.zaghir.excelPoi.service.ExcelPoiService;
import com.zaghir.excelPoi.service.IExcelPoiService;

public class App {
	
	public static void main(String[] args){
		IExcelPoiService excelPoiService = new ExcelPoiService();
		excelPoiService.generateCommandeInExcel();
	}

}
