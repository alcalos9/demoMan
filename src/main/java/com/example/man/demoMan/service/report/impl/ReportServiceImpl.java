package com.example.man.demoMan.service.report.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.example.man.demoMan.model.report.ExtIntValidationsDetailResponse;
import com.example.man.demoMan.service.report.ReportService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ReportServiceImpl implements ReportService {

	@Override
	public ByteArrayInputStream getReport(Integer idForm) {

		Document document = new Document(PageSize.A3, 1, 1, 40, 2);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			ExtIntValidationsDetailResponse report = new ExtIntValidationsDetailResponse();

			PdfWriter.getInstance(document, out);
			document.open();

			Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
			Font font = FontFactory.getFont(FontFactory.HELVETICA, 9);
			Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9);

			Paragraph para = new Paragraph("MATRIZ DE RIESGO DE AFILIACIÓN - PERSONA JURÍDICA", fontTitle);
			para.setAlignment(Element.ALIGN_CENTER);

			document.add(para);
			document.add(Chunk.NEWLINE);

			document = generateHeaders(document);
			document.add(Chunk.NEWLINE);
			document = generateSubHeaders(document);
			document.add(Chunk.NEWLINE);
			document = detail(document);
			document.add(Chunk.NEWLINE);
			document = resultado(document);
			
			document.add(Chunk.NEWLINE);
			
			Paragraph para1 = new Paragraph("Nota1 La puntuación obtenida por el comercio se considera hasta 90 días desde la fecha de calificación", font);
			Paragraph para2 = new Paragraph("Si es afiliado después de la misma se deberá realizar un nuevo proceso de evaluación", font);
			document.add(Chunk.NEWLINE);
			Paragraph para3 = new Paragraph("Nota 2.- Si en las demandas judiciales, existe las siguientes: Trata de blanca, Lavado de activos, Narcotráfico, Estafa-Robo. ", font);
			Paragraph para4 = new Paragraph("Automáticamente se niega la afiliación", font);
			
			
			document.add(para1);
			document.add(para2);
			document.add(para3);
			document.add(para4);
	        
			document.close();

		} catch (DocumentException e) {

			e.printStackTrace();

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	private Document resultado(Document document) {
		Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);
		
		float[] columnWidths = { 5, 15 };
		
		PdfPTable pdfPTable = new PdfPTable(columnWidths);
		PdfPCell cel1 = new PdfPCell();
		cel1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel1.setBorderWidth(1);
		cel1.setPhrase(new Phrase("RESULTADO", fontBold));
		
		PdfPCell cel2 = new PdfPCell();
		cel2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel2.setBorderWidth(1);
		cel2.setPhrase(new Phrase("", fontBold));
		
		pdfPTable.addCell(cel1);
		pdfPTable.addCell(cel2);
		try {

			document.add(pdfPTable);

		} catch (DocumentException e) {
			return null;
		}

		return document;
	}

	private Document detail(Document document) {
		float[] columnWidths = {1, 1, 7, 1, 1, 2, 3, 5};
		PdfPTable pdfPTable = new PdfPTable(columnWidths);
		Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9);
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 9);
		
		PdfPCell cel1 = new PdfPCell();
		cel1.setBackgroundColor(BaseColor.ORANGE);
		cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel1.setBorderWidth(1);
		cel1.setPhrase(new Phrase("%", fontBold));
		
		PdfPCell cel2 = new PdfPCell();
		cel2.setBackgroundColor(BaseColor.ORANGE);
		cel2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel2.setBorderWidth(1);
		cel2.setPhrase(new Phrase("N°", fontBold));

		PdfPCell cel3 = new PdfPCell();
		cel3.setBackgroundColor(BaseColor.ORANGE);
		cel3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel3.setBorderWidth(1);
		cel3.setPhrase(new Phrase("Revisión Interna ", fontBold));
		
		PdfPCell cel4 = new PdfPCell();
		cel4.setBackgroundColor(BaseColor.ORANGE);
		cel4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel4.setBorderWidth(1);
		cel4.setPhrase(new Phrase("SI", fontBold));
		
		PdfPCell cel5 = new PdfPCell();
		cel5.setBackgroundColor(BaseColor.ORANGE);
		cel5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel5.setBorderWidth(1);
		cel5.setPhrase(new Phrase("NO", fontBold));
		
		PdfPCell cel6 = new PdfPCell();
		cel6.setBackgroundColor(BaseColor.ORANGE);
		cel6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel6.setBorderWidth(1);
		cel6.setPhrase(new Phrase("Valor", fontBold));
		
		PdfPCell cel7 = new PdfPCell();
		cel7.setBackgroundColor(BaseColor.ORANGE);
		cel7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel7.setBorderWidth(1);
		cel7.setPhrase(new Phrase("Ponderación ", fontBold));
		
		PdfPCell cel8 = new PdfPCell();
		cel8.setBackgroundColor(BaseColor.ORANGE);
		cel8.setHorizontalAlignment(Element.ALIGN_CENTER);
		cel8.setBorderWidth(1);
		cel8.setPhrase(new Phrase("Observación", fontBold));
		
		pdfPTable.addCell(cel1);
		pdfPTable.addCell(cel2);
		pdfPTable.addCell(cel3);
		pdfPTable.addCell(cel4);
		pdfPTable.addCell(cel5);
		pdfPTable.addCell(cel6);
		pdfPTable.addCell(cel7);
		pdfPTable.addCell(cel8);
		
		for (int i=9; i<305; i++) {
			PdfPCell cel = new PdfPCell();
			cel.setBorderWidth(1);
			
			switch (i){
	            case 9:{
	            	cel.setPhrase(new Phrase("15%", fontBold));
	                break;
	            }
	            case 10:{
	            	cel.setPhrase(new Phrase("1", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 11:{
	            	cel.setPhrase(new Phrase("Verificación del MATCH", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 12:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 13:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 14:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 15:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 16:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            //--------------------------------------
	            case 17:{
	            	cel.setPhrase(new Phrase("10%", fontBold));
	                break;
	            }
	            case 18:{
	            	cel.setPhrase(new Phrase("2", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 19:{
	            	cel.setPhrase(new Phrase("Comercios cerrados IFS", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 20:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 21:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 22:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 23:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 24:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            //--------------------------------------
	            case 25:{
	            	cel.setPhrase(new Phrase("10%", font));
	                break;
	            }
	            case 26:{
	            	cel.setPhrase(new Phrase("3", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 27:{
	            	cel.setPhrase(new Phrase("Información Crediticia de la Empresa", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 28:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 29:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 30:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 31:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 32:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            //--------------------------------------
	            case 33:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 34:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 35:{
	            	cel.setPhrase(new Phrase("Endeudamiento en IFI ", fontBold));
	                break;
	            }
	            case 36:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 37:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 38:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 39:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 40:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 41:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 42:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 43:{
	            	cel.setPhrase(new Phrase("Cartera Vencida", font));
	                break;
	            }
	            case 44:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 45:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 46:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 47:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 48:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 49:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 50:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 51:{
	            	cel.setPhrase(new Phrase("1-3 meses", font));
	                break;
	            }
	            case 52:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 53:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 54:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 55:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 56:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 57:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 58:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 59:{
	            	cel.setPhrase(new Phrase("> 3 meses", font));
	                break;
	            }
	            case 60:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 61:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 62:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 63:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 64:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 65:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 66:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 67:{
	            	cel.setPhrase(new Phrase("Cartera Castigada", font));
	                break;
	            }
	            case 68:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 69:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 70:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 71:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 72:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 73:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 74:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 75:{
	            	cel.setPhrase(new Phrase("Demanda Judicial", font));
	                break;
	            }
	            case 76:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 7:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 78:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 79:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 80:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 81:{
	            	cel.setPhrase(new Phrase("32%", fontBold));
	                break;
	            }
	            case 82:{
	            	cel.setPhrase(new Phrase("4", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 83:{
	            	cel.setPhrase(new Phrase("Entidades de control SRI-SC", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 84:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 85:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 86:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 87:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 88:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 89:{
	            	cel.setPhrase(new Phrase("18%", fontBold));
	                break;
	            }
	            case 90:{
	            	cel.setPhrase(new Phrase("4", fontBold));
	                break;
	            }
	            case 91:{
	            	cel.setPhrase(new Phrase("Registrado en la Super de Compañias", fontBold));
	                break;
	            }
	            case 92:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 93:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 94:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 95:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 96:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 97:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 98:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 99:{
	            	cel.setPhrase(new Phrase("Accionistas", fontBold));
	                break;
	            }
	            case 100:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 101:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 102:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 103:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 104:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 105:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 106:{
	            	cel.setPhrase(new Phrase("2%", fontBold));
	                break;
	            }
	            case 107:{
	            	cel.setPhrase(new Phrase("Score promedio Accionistas", font));
	                break;
	            }
	            case 108:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 109:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 110:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 111:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 112:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 113:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 114:{
	            	cel.setPhrase(new Phrase("2%", fontBold));
	                break;
	            }
	            case 115:{
	            	cel.setPhrase(new Phrase("Demanda Judicial (Excluye Nota1)", font));
	                break;
	            }
	            case 116:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 117:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 118:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 119:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 120:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 121:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 122:{
	            	cel.setPhrase(new Phrase("2%", fontBold));
	                break;
	            }
	            case 123:{
	            	cel.setPhrase(new Phrase("Administradores", fontBold));
	                break;
	            }
	            case 124:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 125:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 126:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 127:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 128:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 129:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 130:{
	            	cel.setPhrase(new Phrase("2%", fontBold));
	                break;
	            }
	            case 131:{
	            	cel.setPhrase(new Phrase("Score promedio Administradores", font));
	                break;
	            }
	            case 132:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 133:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 134:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 135:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 136:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 137:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 138:{
	            	cel.setPhrase(new Phrase("2%", fontBold));
	                break;
	            }
	            case 139:{
	            	cel.setPhrase(new Phrase("Demanda Judicial (Excluye Nota1)", font));
	                break;
	            }
	            case 140:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 141:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 142:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 143:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 144:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 145:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 146:{
	            	cel.setPhrase(new Phrase("8%", fontBold));
	                break;
	            }
	            case 147:{
	            	cel.setPhrase(new Phrase("Score Representante Legal", font));
	                break;
	            }
	            case 148:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 149:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 150:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 151:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 152:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 153:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 154:{
	            	cel.setPhrase(new Phrase("2%", fontBold));
	                break;
	            }
	            case 155:{
	            	cel.setPhrase(new Phrase("Demanda Representante Legal", font));
	                break;
	            }
	            case 156:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 157:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 158:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 159:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 160:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 161:{
	            	cel.setPhrase(new Phrase("5%", fontBold));
	                break;
	            }
	            case 162:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 163:{
	            	cel.setPhrase(new Phrase("Activo SRI", fontBold));
	                break;
	            }
	            case 164:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 165:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 166:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 167:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 168:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 169:{
	            	cel.setPhrase(new Phrase("4%", fontBold));
	                break;
	            }
	            case 170:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 171:{
	            	cel.setPhrase(new Phrase("Antigüedad Comercio-SRI", fontBold));
	                break;
	            }
	            case 172:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 173:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 174:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 175:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 176:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 177:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 178:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 179:{
	            	cel.setPhrase(new Phrase("1-3 Años", font));
	                break;
	            }
	            case 180:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 181:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 182:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 183:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 184:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            //--------------------------------------
	            case 185:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 186:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 187:{
	            	cel.setPhrase(new Phrase("3-5 Años", font));
	                break;
	            }
	            case 188:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 189:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 190:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 191:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 192:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            //--------------------------------------
	            case 193:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 194:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 195:{
	            	cel.setPhrase(new Phrase("5-mas Años", font));
	                break;
	            }
	            case 196:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 197:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 198:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 199:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 200:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            //--------------------------------------
	            case 201:{
	            	cel.setPhrase(new Phrase("5%", fontBold));
	                break;
	            }
	            case 202:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 203:{
	            	cel.setPhrase(new Phrase("Validación de Actividad SRI vs Giro", fontBold));
	                break;
	            }
	            case 204:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 205:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 206:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 207:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 208:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 209:{
	            	cel.setPhrase(new Phrase("9%", font));
	                break;
	            }
	            case 210:{
	            	cel.setPhrase(new Phrase("5", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 211:{
	            	cel.setPhrase(new Phrase("Demanda Judicial Empresa (Excluye Nota 2)", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 212:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 213:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 214:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 215:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 216:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 217:{
	            	cel.setPhrase(new Phrase("9%", font));
	                break;
	            }
	            case 218:{
	            	cel.setPhrase(new Phrase("6", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 219:{
	            	cel.setPhrase(new Phrase("Reclamos recibidos del Comercio (> 6 meses)", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 220:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 221:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 222:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 223:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 224:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 225:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 226:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 227:{
	            	cel.setPhrase(new Phrase("0-5 reclamos", font));
	                break;
	            }
	            case 228:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 229:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 230:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 231:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 232:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 233:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 234:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 235:{
	            	cel.setPhrase(new Phrase("6 reclamos en adelante", font));
	                break;
	            }
	            case 236:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 237:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 238:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 239:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 240:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 241:{
	            	cel.setPhrase(new Phrase("15%", font));
	                break;
	            }
	            case 242:{
	            	cel.setPhrase(new Phrase("7", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 243:{
	            	cel.setPhrase(new Phrase("Giro de Alto Riesgo", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 244:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 245:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 246:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 247:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 248:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 249:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 250:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 251:{
	            	cel.setPhrase(new Phrase("4812", font));
	                break;
	            }
	            case 252:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 253:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 254:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 255:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 256:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 257:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 258:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 259:{
	            	cel.setPhrase(new Phrase("5734", font));
	                break;
	            }
	            case 260:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 261:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 262:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 263:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 264:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 265:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 266:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 267:{
	            	cel.setPhrase(new Phrase("5964", font));
	                break;
	            }
	            case 268:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 269:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 270:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 271:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 272:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 273:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 274:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 275:{
	            	cel.setPhrase(new Phrase("8999", font));
	                break;
	            }
	            case 276:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 277:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 278:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 279:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 280:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 281:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 282:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 283:{
	            	cel.setPhrase(new Phrase("7261", font));
	                break;
	            }
	            case 284:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 285:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 286:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 287:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 288:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 289:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 290:{
	            	cel.setPhrase(new Phrase("", fontBold));
	                break;
	            }
	            case 291:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 292:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 293:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 294:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 295:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 296:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 297:{
	            	cel.setPhrase(new Phrase("", font));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 298:{
	            	cel.setPhrase(new Phrase("", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 299:{
	            	cel.setPhrase(new Phrase("CALIFICACIÓN", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 300:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 301:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 302:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 303:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 304:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	          //--------------------------------------
	            case 305:{
	            	cel.setPhrase(new Phrase("", font));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 306:{
	            	cel.setPhrase(new Phrase("", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 307:{
	            	cel.setPhrase(new Phrase("RESULTADO", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 308:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 309:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 310:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 311:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 312:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            //--------------------------------------
	            case 313:{
	            	cel.setPhrase(new Phrase("", font));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 314:{
	            	cel.setPhrase(new Phrase("", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 315:{
	            	cel.setPhrase(new Phrase("RESULTADO", fontBold));
	            	cel.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                break;
	            }
	            case 316:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 317:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 318:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 319:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
	            case 320:{
	            	cel.setPhrase(new Phrase("", font));
	                break;
	            }
			}

			pdfPTable.addCell(cel);
		}

		
		
		
		try {
			
			document.add(pdfPTable);
			
		} catch (DocumentException e) {
			return null;
		}
		
		return document;
	}

	private Document generateSubHeaders(Document document) {
		float[] columnWidths = { 5, 15 };

		PdfPTable pdfPTable = new PdfPTable(columnWidths);
		Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

		PdfPCell cel1 = new PdfPCell();
		cel1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel1.setBorderWidth(0);
		cel1.setPhrase(new Phrase("Resumen- Actividad", fontBold));

		PdfPCell cel2 = new PdfPCell();
		cel2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel2.setBorderWidth(1);
		cel2.setPhrase(new Phrase("", font));

		PdfPCell cel4 = new PdfPCell();
		cel4.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel4.setBorderWidth(0);
		cel4.setPhrase(new Phrase("Comentarios UPF", fontBold));

		PdfPCell cel5 = new PdfPCell();
		cel5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel5.setBorderWidth(1);
		cel5.setPhrase(new Phrase("", font));

		pdfPTable.addCell(cel1);
		pdfPTable.addCell(cel2);
		pdfPTable.addCell(cel4);
		pdfPTable.addCell(cel5);

		try {

			document.add(pdfPTable);

		} catch (DocumentException e) {
			return null;
		}

		return document;
	}

	private Document generateHeaders(Document document) {

		float[] columnWidths = { 3, 5, 3, 5 };

		PdfPTable pdfPTable = new PdfPTable(columnWidths);
		Font fontBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 10);

		PdfPCell cel1 = new PdfPCell();
		cel1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel1.setBorderWidth(0);
		cel1.setPhrase(new Phrase("Fecha-calificación", fontBold));

		PdfPCell cel2 = new PdfPCell();
		cel2.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel2.setBorderWidth(1);
		cel2.setPhrase(new Phrase("", font));

		PdfPCell cel3 = new PdfPCell();
		cel3.setBorderWidth(0);

		PdfPCell cel4 = new PdfPCell();
		cel4.setBorderWidth(0);

		PdfPCell cel5 = new PdfPCell();
		cel5.setBorderWidth(0);
		cel5.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel5.setPhrase(new Phrase("Nombre Comercio", fontBold));

		PdfPCell cel6 = new PdfPCell();
		cel6.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel6.setBorderWidth(1);
		cel6.setPhrase(new Phrase("", font));

		PdfPCell cel7 = new PdfPCell();
		cel7.setBorderWidth(0);
		cel7.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel7.setPhrase(new Phrase("  Afiliación POS", fontBold));

		PdfPCell cel8 = new PdfPCell();
		cel8.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel8.setBorderWidth(1);
		cel8.setPhrase(new Phrase("", font));

		PdfPCell cel9 = new PdfPCell();
		cel9.setBorderWidth(0);
		cel9.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel9.setPhrase(new Phrase("RUC", fontBold));

		PdfPCell cel10 = new PdfPCell();
		cel10.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel10.setBorderWidth(1);
		cel10.setPhrase(new Phrase("", font));

		PdfPCell cel11 = new PdfPCell();
		cel11.setBorderWidth(0);
		cel11.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel11.setPhrase(new Phrase("  MPOS", fontBold));

		PdfPCell cel12 = new PdfPCell();
		cel12.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel12.setBorderWidth(1);
		cel12.setPhrase(new Phrase("", font));

		PdfPCell cel13 = new PdfPCell();
		cel13.setBorderWidth(0);
		cel13.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel13.setPhrase(new Phrase("Giro", fontBold));

		PdfPCell cel14 = new PdfPCell();
		cel14.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel14.setBorderWidth(1);
		cel14.setPhrase(new Phrase("", font));

		PdfPCell cel15 = new PdfPCell();
		cel15.setBorderWidth(0);

		PdfPCell cel16 = new PdfPCell();
		cel16.setBorderWidth(0);

		PdfPCell cel17 = new PdfPCell();
		cel17.setBorderWidth(0);
		cel17.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel17.setPhrase(new Phrase("Representante Legal", fontBold));

		PdfPCell cel18 = new PdfPCell();
		cel18.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel18.setBorderWidth(1);
		cel18.setPhrase(new Phrase("", font));

		PdfPCell cel19 = new PdfPCell();
		cel19.setBorderWidth(0);

		PdfPCell cel20 = new PdfPCell();
		cel20.setBorderWidth(0);

		PdfPCell cel21 = new PdfPCell();
		cel21.setBorderWidth(0);
		cel21.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel21.setPhrase(new Phrase("Asesor comercial", fontBold));

		PdfPCell cel22 = new PdfPCell();
		cel22.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel22.setBorderWidth(1);
		cel22.setPhrase(new Phrase("", font));

		PdfPCell cel23 = new PdfPCell();
		cel23.setBorderWidth(0);
		cel23.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel23.setPhrase(new Phrase("  Analista UPF", fontBold));

		PdfPCell cel24 = new PdfPCell();
		cel24.setHorizontalAlignment(Element.ALIGN_LEFT);
		cel24.setBorderWidth(1);
		cel24.setPhrase(new Phrase("", font));

		pdfPTable.addCell(cel1);
		pdfPTable.addCell(cel2);
		pdfPTable.addCell(cel3);
		pdfPTable.addCell(cel4);
		pdfPTable.addCell(cel5);
		pdfPTable.addCell(cel6);
		pdfPTable.addCell(cel7);
		pdfPTable.addCell(cel8);
		pdfPTable.addCell(cel9);
		pdfPTable.addCell(cel10);
		pdfPTable.addCell(cel11);
		pdfPTable.addCell(cel12);
		pdfPTable.addCell(cel13);
		pdfPTable.addCell(cel14);
		pdfPTable.addCell(cel15);
		pdfPTable.addCell(cel16);
		pdfPTable.addCell(cel17);
		pdfPTable.addCell(cel18);
		pdfPTable.addCell(cel19);
		pdfPTable.addCell(cel20);
		pdfPTable.addCell(cel21);
		pdfPTable.addCell(cel22);
		pdfPTable.addCell(cel23);
		pdfPTable.addCell(cel24);

		try {

			document.add(pdfPTable);

		} catch (DocumentException e) {
			return null;
		}

		return document;
	}

}
