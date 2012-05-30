package invapp.business;

import invapp.data.DAOProduct;
import invapp.dto.DTOProduct;
import java.util.List;

public class LogicProduct {
    
    public List<DTOProduct> readInventory() {
        return new DAOProduct().readInventory();
    }
    
    public void insertProduct(DTOProduct product) {
        new DAOProduct().insertProduct(product);
    }
    
    public void editProduct(DTOProduct product) {
        new DAOProduct().editProduct(product);
    }

    public List<DTOProduct> readProducts() {
        return new DAOProduct().readProducts();
    }
}
