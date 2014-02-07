package invapp.business;

import invapp.data.DAOReports;
import invapp.dto.DTOSale;
import java.util.List;


public class LogicReport {

    public List<DTOSale> getDailyReport(Integer day, Integer month, Integer year) {
        return new DAOReports().getDailyReport(day, month, year);
    }

    public List<DTOSale> getMonthlyReport(Integer month, Integer year) {
        return new DAOReports().getMonthlyReport(month, year);
    }
}
