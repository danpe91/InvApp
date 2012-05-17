package invapp.business;

import invapp.data.DAOSell;
import invapp.dto.DTOSell;

public class LogicSell {
    
    public void insertSell(DTOSell sell) {
        new DAOSell().insertSell(sell);
    }
}
