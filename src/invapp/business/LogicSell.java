package invapp.business;

import invapp.data.DAOSell;
import invapp.dto.DTOSell;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class LogicSell {
    
    public void insertSells(List<DTOSell> sells) {
        
        Timestamp date = new Timestamp(new Date().getTime());
        
        for(DTOSell sell : sells) {
            sell.setDate(date);
            new DAOSell().insertSell(sell);
        }
    }

    public Integer getNewSellNumber() {
        return new DAOSell().getNewSellNumber() + 1;
    }
}
