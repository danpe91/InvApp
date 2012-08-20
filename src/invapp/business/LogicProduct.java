package invapp.business;

import invapp.data.DAOProduct;
import invapp.data.DAOSell;
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
    
    public List<DTOProduct> readDataForProduct(String accesoryname) {
        
        return new DAOProduct().readDataForProduct(accesoryname);
    }
    
    public DTOProduct readDataForProduct(String accesoryname, String size) {
        
        return new DAOProduct().readDataForProduct(accesoryname, size);
    }
    
    public List<String> getListOfCodes() {
        
        return new DAOProduct().getListOfCodes();
    }

    public DTOProduct readProductByCode(String code) {
        
        return new DAOProduct().readProductByCode(code);
    }

}
