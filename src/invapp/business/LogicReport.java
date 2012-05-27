package invapp.business;

import invapp.data.DAOReports;
import invapp.dto.DTOSell;
import java.util.List;

public class LogicReport {
    
    public List<DTOSell> getDailyReport(Integer day, Integer month, Integer year) {
        System.out.println("Dia: " + day + "\nMes: " + month + "\nAño: " + year);
        List<DTOSell> lista = new DAOReports().getDailyReport(day, month, year);
        System.out.println(lista.size());
        return lista;
    }
}
