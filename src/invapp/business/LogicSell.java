package invapp.business;

import invapp.data.DAOSell;
import invapp.dto.DTOSell;
import invapp.helper.MyTimestamp;
import java.util.List;

public class LogicSell {
    
    public void insertSells(List<DTOSell> sells) {
        
        MyTimestamp date = new MyTimestamp();
        
        for(DTOSell sell : sells) {
            sell.setDate(date);
            new DAOSell().insertSell(sell);
        }
    }

    public Integer getNewSellNumber() {
        return new DAOSell().getNewSellNumber() + 1;
    }

}
