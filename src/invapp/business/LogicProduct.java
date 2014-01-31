package invapp.business;

import invapp.dto.DTOProduct;
import java.util.List;

public class LogicProduct {
    
    public List<DTOProduct> readInventory() {
        
        return new java.util.ArrayList(); // new DAOProduct().readInventory();
    }
    
    public void insertProduct(DTOProduct product) {
        
        // new DAOProduct().insertProduct(product);
    }
    
    public void editProduct(DTOProduct product) {
        
        // new DAOProduct().editProduct(product);
    }

    public List<DTOProduct> readProducts() {
        
        return new java.util.ArrayList(); // new DAOProduct().readProducts();
    }
    
    public List<DTOProduct> readDataForProduct(String accesoryname) {
        
        return new java.util.ArrayList(); // new DAOProduct().readDataForProduct(accesoryname);
    }
    
    public DTOProduct readDataForProduct(String accesoryname, String size) {
        
        return new DTOProduct(); // new DAOProduct().readDataForProduct(accesoryname, size);
    }
    
    public List<String> getListOfCodes() {
        
        return new java.util.ArrayList(); // new DAOProduct().getListOfCodes();
    }

    public DTOProduct readProductByCode(String code) {
        
        return new DTOProduct(); // new DAOProduct().readProductByCode(code);
    }

}
