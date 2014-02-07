package invapp.business;

import invapp.data.DAOSale;
import invapp.dto.DTOSale;
import invapp.helper.MyTimestamp;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

public class LogicSale {
    
    public void insertSales(List<DTOSale> sales) {
        
        MyTimestamp date = new MyTimestamp();
        
        for(DTOSale sale : sales) {
            sale.setDate(date);
            new DAOSale().insertSale(sale);
        }
    }

    public Integer getNewSaleNumber() {
        return new DAOSale().getNewSaleNumber() + 1;
    }


    public void DataPrinter(List<DTOSale> sales) {

        PrinterJob job = PrinterJob.getPrinterJob();

        job.setPrintable(new PrinterRenderer());
        boolean doPrint = job.printDialog();

        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
        // The job did not successfully
                // complete
            }
        }

    }

    class PrinterRenderer implements Printable {

        @Override
        public int print(Graphics g, PageFormat pf, int page)
                throws PrinterException {

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
            g.drawString("Hello world!", 100, 100);

            // tell the caller that this page is part
            // of the printed document
            return PAGE_EXISTS;
        }
    }
}
