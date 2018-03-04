package com.zaghir.excelPoi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaghir.excelPoi.entities.Commande;
import com.zaghir.excelPoi.entities.DetailCommande;

public class ExcelPoiService implements IExcelPoiService{

	private ICommandeService commandeService = new CommandeService();
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	public void generateCommandeInExcel() {
		List<Commande> commandes = commandeService.retrieveCommandes();
		File file = new File("d:/generateCommandeInExcel.xls");
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet1 = workbook.createSheet("Feuille-1");
		Sheet sheet2 = workbook.createSheet(WorkbookUtil.createSafeSheetName("Feuille-@-2"));
		
		Row row0 = sheet2.createRow(0);
		Cell cell00 = row0.createCell(0);		
		cell00.setCellValue("Id Commande");
		
		CellStyle cellStyleHeader =workbook.createCellStyle();		
		cellStyleHeader.setBorderBottom(BorderStyle.THIN );
		cellStyleHeader.setBorderTop(BorderStyle.THIN );
		cellStyleHeader.setBorderLeft(BorderStyle.THIN );
		cellStyleHeader.setBorderRight(BorderStyle.THIN );
		cellStyleHeader.setFillForegroundColor((short) 22); // IndexedColors.LIGHT_ORANGE.getIndex()
		cellStyleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND );
		cellStyleHeader.setAlignment(HorizontalAlignment.LEFT);
		Font fontHeader = workbook.createFont();
		fontHeader.setBold(true);
		fontHeader.setFontName("Arial");
		fontHeader.setFontHeightInPoints((short)10);
		cellStyleHeader.setFont(fontHeader);
		
		CellStyle cellStylePaire =workbook.createCellStyle();
		CellStyle cellStyleImpaire =workbook.createCellStyle();
		
		Font fontBody = workbook.createFont();
		fontBody.setBold(false);
		fontBody.setItalic(false);
		fontBody.setFontName("Arial");
		fontBody.setFontHeightInPoints((short)10);
		
		cellStylePaire.setBorderBottom(BorderStyle.THIN );
		cellStylePaire.setBorderTop(BorderStyle.THIN );
		cellStylePaire.setBorderLeft(BorderStyle.THIN );
		cellStylePaire.setBorderRight(BorderStyle.THIN );
		cellStylePaire.setFillForegroundColor((short)42); // IndexedColors.ORANGE.getIndex()
		cellStylePaire.setFillPattern(FillPatternType.SOLID_FOREGROUND );
		cellStylePaire.setAlignment(HorizontalAlignment.LEFT);
		cellStylePaire.setFont(fontBody);
		
		cellStyleImpaire.setBorderBottom(BorderStyle.THIN );
		cellStyleImpaire.setBorderTop(BorderStyle.THIN );
		cellStyleImpaire.setBorderLeft(BorderStyle.THIN );
		cellStyleImpaire.setBorderRight(BorderStyle.THIN );
		cellStyleImpaire.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		cellStyleImpaire.setFillPattern(FillPatternType.SOLID_FOREGROUND );
		cellStyleImpaire.setAlignment(HorizontalAlignment.LEFT);
		cellStyleImpaire.setFont(fontBody);
		/*
		 * Entete de fichier
		 */
		Row rowHeader = sheet1.createRow(0); 
		rowHeader.createCell(0).setCellValue("id_Produit");
		rowHeader.getCell(0).setCellStyle(cellStyleHeader);
		rowHeader.createCell(1).setCellValue("Nom_Produit");
		rowHeader.getCell(1).setCellStyle(cellStyleHeader);
		rowHeader.createCell(2).setCellValue("Prix_Unitaire");
		rowHeader.getCell(2).setCellStyle(cellStyleHeader);
		rowHeader.createCell(3).setCellValue("Quantite");
		rowHeader.getCell(3).setCellStyle(cellStyleHeader);
		rowHeader.createCell(4).setCellValue("Montant");
		rowHeader.getCell(4).setCellStyle(cellStyleHeader);
		int indexRow = 0;
		int quantites = 0;
		double montants =0.0;  
		for (Commande commande : commandes) {
			List<DetailCommande> detailCommandes = commande.getDetailCommand();
			for(DetailCommande  detail: detailCommandes){
				indexRow++;
				quantites += detail.getQuantite();
				montants += detail.getMontant() ;
				CellStyle cellStyle;
				if(indexRow % 2> 0){
					cellStyle = cellStylePaire ;
				}else{
					cellStyle = cellStyleImpaire;
				}
				Row row = sheet1.createRow(indexRow);
				row.createCell(0).setCellValue(detail.getProduit().getIdProduit());
				row.getCell(0).setCellStyle(cellStyle);
				row.createCell(1).setCellValue(detail.getProduit().getNomProduit());
				row.getCell(1).setCellStyle(cellStyle);
				row.createCell(2).setCellValue(detail.getProduit().getPrixUnitaire());
				row.getCell(2).setCellStyle(cellStyle);
				row.createCell(3).setCellValue(detail.getQuantite());
				row.getCell(3).setCellStyle(cellStyle);
				row.createCell(4).setCellValue(detail.getMontant());
				row.getCell(4).setCellStyle(cellStyle);
				
			}
		}
		
		Row rowFooter = sheet1.createRow(indexRow+1);
		rowFooter.createCell(2).setCellValue("Montant de la commande");
		rowFooter.createCell(3).setCellValue(quantites); 
		rowFooter.createCell(4).setCellValue(montants); 
		
		/**
		 * pour savoir la liste des codes couleurs 
		 */
		/*
		for(int i =0 ; i< 250; i++){
			Row rowTestColor = sheet1.createRow(indexRow+i+1);
			CellStyle cellStyleTestColor  =workbook.createCellStyle();
			
			cellStyleTestColor.setBorderBottom(BorderStyle.THIN );
			cellStyleTestColor.setBorderTop(BorderStyle.THIN );
			cellStyleTestColor.setBorderLeft(BorderStyle.THIN );
			cellStyleTestColor.setBorderRight(BorderStyle.THIN );
			cellStyleTestColor.setFillForegroundColor((short)i);
			cellStyleTestColor.setFillPattern(FillPatternType.SOLID_FOREGROUND );
			
			rowTestColor.createCell(0).setCellValue("la couleur ="+ i);
			rowTestColor.getCell(0).setCellStyle(cellStyleTestColor);
		}*/
		
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
			logger.info("probleme de generation de fichier excel --> {} ", e.getMessage());			
		}
		
	}

}
