package servlet;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import calculator.DataToCoutnInstallments;
import calculator.InstallmentCalc;
import calculator.Installment;
import enums.KindOfReport;
import enums.KindOfInstallment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/harmonogram")
public class CreditSchedule_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final InstallmentCalc installmentCalc = new InstallmentCalc();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	
    	KindOfReport kindOfReport = 
    				 KindOfReport.valueOf(req.getParameter("rodzajRaportu"));

        DataToCoutnInstallments dataToCoutnInstallments = new DataToCoutnInstallments(
                Double.parseDouble(req.getParameter("kwotaKredytu")),
                Integer.parseInt(req.getParameter("iloscRat")),
                Double.parseDouble(req.getParameter("oprocentowanie")),
                Double.parseDouble(req.getParameter("oplataStala")),
                KindOfInstallment.valueOf(req.getParameter("typRaty"))
        );

        List<Installment> raty = installmentCalc.calculate(dataToCoutnInstallments).stream()
                .map(Installment::new)
                .collect(Collectors.toList());
     
        if (kindOfReport == KindOfReport.PDF) {
            generatePDF(resp, raty);
        }

        generateHTML(req, resp, raty);
    }

    private void generateHTML(HttpServletRequest req, HttpServletResponse resp, List<Installment> raty) throws ServletException, IOException {
        req.setAttribute("raty", raty);
        req.getRequestDispatcher("/WEB-INF/harmonogram.jsp").forward(req, resp);
    }

    private void generatePDF(HttpServletResponse resp, List<Installment> raty) {
        resp.setContentType("application/pdf");
        resp.addHeader("Content-Disposition", "attachment; filename=Harmonogram-Rat.pdf");

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, resp.getOutputStream());
            document.open();

            PdfPTable table = new PdfPTable(5);
            table.addCell("Numer raty");
            table.addCell("Kwota kapital‚u");
            table.addCell("Kwota odsetek");
            table.addCell("Oplaty stale");
            table.addCell("Calkowita kwota raty");

            raty.forEach(rata -> {
                table.addCell(rata.getNumberOfInstallment());
                table.addCell(rata.getAmountOfCapital());
                table.addCell(rata.getFixedFeeAmount());
                table.addCell(rata.getFixedFeeAmount());
                table.addCell(rata.getTotalAmountOfInstallment());
            });

            document.add(table);
            document.close();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        
    }
    
}
