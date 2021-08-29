
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import java.awt.Desktop;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author siddharthsinghrathour
 */
public class Document {

    public Document(PdfDocument pdfDocument) {
    }
    
    public static void main(String args[]) throws IOException
    {
        String path = "/Users/siddharthsinghrathour/Desktop/sid.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        
        pdfDocument.setDefaultPageSize(PageSize.A4);
        float col = 280f;
        float columnwidth[] = {col , col};
        Table table = new Table(columnwidth);
        table.addCell(new Cell().add("Result"));
        table.addCell(new Cell().add("R.V.C.E\n#3456 Mysure Road"));
        document.add(table);
        
        
        
        
        
        document.close();
        System.out.println("Pdf Created");
        
        
        
        
        
        
        
        
    }

    private void add(Table table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
