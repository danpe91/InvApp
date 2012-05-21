package invapp.business;

import invapp.data.DAOProduct;
import invapp.dto.DTOProduct;
import java.util.List;

public class LogicProduct {
    
    public List<DTOProduct> readProducts() {
        return new DAOProduct().readProducts();
    }
    
    public void insertProduct(DTOProduct product) {
        new DAOProduct().insertProduct(product);
    }
    
    public void editProduct(DTOProduct product) {
        new DAOProduct().editProduct(product);
    }
}