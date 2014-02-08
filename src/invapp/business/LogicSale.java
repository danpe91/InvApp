package invapp.business;

import invapp.data.DAOSale;
import invapp.dto.DTOSale;
import invapp.helper.FontReader;
import invapp.helper.MyTimestamp;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogicSale {

    private final String[] HEADERS = {
        "Carniceria   La   Esperanza", "Jose de J. Torres Davalos", "Libertad # 701 Col. del Carmen",
        "CP: 20050", "RFC: TODJ710923U61",
        "Tel:(449)242-28-40"

    };
    private final String[] LABELS = {"Ticket no.: ", "Fecha: ", "Hora: "};

    public void insertSales(List<DTOSale> sales) {

        MyTimestamp date = new MyTimestamp();

        for (DTOSale sale : sales) {
            sale.setDate(date);
            new DAOSale().insertSale(sale);
        }
    }

    public Integer getNewSaleNumber() {
        return new DAOSale().getNewSaleNumber() + 1;
    }

    public void printData(List<DTOSale> sales) {

        Book book = new Book();
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pf = job.defaultPage();
        Paper ticketPaper = pf.getPaper();

        double paperWidth = 2.5;
        // TODO implement method to calculate height
        double paperHeight = 2.5;

        ticketPaper.setSize(paperWidth * 72.0, paperHeight * 72.0);
        ticketPaper.setImageableArea(0, 5, paperWidth * 72d, paperHeight * 72d);

        pf.setPaper(ticketPaper);
        pf.setOrientation(PageFormat.PORTRAIT);

        dump(pf);
        PageFormat validatePage = job.validatePage(pf);
        System.out.println("Valid- " + dump(validatePage));

        book.append(new PrinterRenderer(sales), pf);
        job.setPageable(book);

        try {
            job.print();
        } catch (PrinterException e) {

        }

    }

    protected static String dump(Paper paper) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(paper.getWidth()).append("x").append(paper.getHeight())
                .append("/").append(paper.getImageableX()).append("x").
                append(paper.getImageableY()).append(" - ").append(paper
                        .getImageableWidth()).append("x").append(paper.getImageableHeight());
        return sb.toString();
    }

    protected static String dump(PageFormat pf) {
        Paper paper = pf.getPaper();
        return dump(paper);
    }

    class PrinterRenderer implements Printable {

        List<DTOSale> sales;

        public PrinterRenderer(List<DTOSale> sales) {

            this.sales = sales;
        }

        @Override
        public int print(Graphics g, PageFormat pf, int page)
                throws PrinterException {

            DTOSale sampleSale = sales.get(0);
            DateFormat df = DateFormat.getDateInstance();
            Date date = new Date(sampleSale.getDate().getTime());
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

            String ticketData[] = {
                sampleSale.getSaleNumber().toString(),
                df.format(date),
                format.format(date)

            };
            int height;
            int numberOfHeaders = HEADERS.length;
            int yMargin = 10;
            int xMargin = 0;
            // We have only one page, and 'page'
            // is zero-based
            if (page > 0) {
                return NO_SUCH_PAGE;
            }

            // User (0,0) is typically outside the
            // imageable area, so we must translate
            // by the X and Y values in the PageFormat
            // to avoid clipping.
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pf.getImageableX(), pf.getImageableY());

            // Now we perform our rendering
            String fontName = FontReader.readFontNameFromFile("fontFile");
            int fontSize = FontReader.readFontSizeFromFile("fontFile");
            Font newFont = new Font(fontName, Font.PLAIN, fontSize);
            g.setFont(newFont);
            FontMetrics fm = g.getFontMetrics();
            height = fm.getHeight();

            g.drawString(HEADERS[0], xMargin, yMargin);
            yMargin += height;

            for (int i = 1; i < numberOfHeaders; i++) {

                g.drawString(HEADERS[i], xMargin, yMargin);
                yMargin += height;

            }

            for (int i = 0; i < LABELS.length; i++) {

                g.drawString(LABELS[i] + ticketData[i], xMargin, yMargin);
                yMargin += height;
            }

            g.drawString("PRODUCTO |", xMargin, yMargin);
            g.drawString("CANTIDAD |", xMargin + (11 * 5), yMargin);
            g.drawString("PRECIO |", xMargin + (21 * 5), yMargin);
            g.drawString("IMPORTE", xMargin + (29 * 5), yMargin);
            yMargin += height;

            for (DTOSale sale : sales) {

                yMargin += height;
                String text = "";
                text = sale.getProduct().getProduct();
                if (text.length() > 16) {
                    text = text.substring(0, 16);
                }
                g.drawString(text, xMargin, yMargin);

                text = sale.getQuantity().toString();
                g.drawString(text, xMargin + (17 * 5), yMargin);

                text = sale.getProduct().getUnitPrice().toString();
                g.drawString(text, xMargin + (25 * 5), yMargin);

                Double price = sale.getProduct().getUnitPrice().doubleValue() * sale.getQuantity().doubleValue();
                text = price.toString();
                g.drawString(text, xMargin + (37 * 5), yMargin);
            }

            // tell the caller that this page is part
            // of the printed document
            return PAGE_EXISTS;
        }
    }
}
