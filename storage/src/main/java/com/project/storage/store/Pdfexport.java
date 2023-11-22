package com.project.storage.store;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Pdfexport {

    public Pdfexport() {
    }

    public void listToPdf(List<Storage> list, String filePath) throws IOException, DocumentException {
        List<Storage> l1= list.stream().collect(Collectors.toList());
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        PdfPCell pdfPCell=new PdfPCell();
        PdfPTable table=new PdfPTable(8);
        pdfPCell.setPadding(5);
        pdfPCell.setBackgroundColor(Color.lightGray);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1.0f,1.8f,1.8f,2.5f,2.0f,1.5f,2.0f,3.5f});
        pdfPCell.setPhrase(new Phrase("ID"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("FIRST NAME"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("LAST NAME"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("DOB"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("GENDER"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("QUALIFICATION"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("CONTACT"));
        table.addCell(pdfPCell);
        pdfPCell.setPhrase(new Phrase("EMAIL"));
        table.addCell(pdfPCell);

        for (Storage object:list){
            table.addCell(String.valueOf(object.getId()));
            table.addCell(String.valueOf(object.getFirstname()));
            table.addCell(String.valueOf(object.getLastname()));
            table.addCell(String.valueOf(object.getDob()));
            table.addCell(String.valueOf(object.getGender()));
            table.addCell(String.valueOf(object.getQualification()));
            table.addCell(String.valueOf(object.getContact()));
            table.addCell(String.valueOf(object.getEmail()));
        }
         document.add(table);
         document.close();
    }
}
