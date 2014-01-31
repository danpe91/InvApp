package invapp.business;

import invapp.dto.DTOSell;
import java.util.List;

public class LogicReport {
    
    public List<DTOSell> getDailyReport(Integer day, Integer month, Integer year) {;
        return new java.util.ArrayList();// new DAOReports().getDailyReport(day, month, year);
    }

    public List<DTOSell> getMonthlyReport(Integer month, Integer year) {
        return new java.util.ArrayList();// new DAOReports().getMonthlyReport(month, year);
    }
}
