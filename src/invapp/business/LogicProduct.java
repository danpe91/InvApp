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
        
        System.out.println("Read Products!  LogicProduct.java:26");
        return new java.util.ArrayList(); // new DAOProduct().readProducts();
    }
    
    public List<DTOProduct> readDataForProduct(String accesoryname) {
        
        System.out.println("readDataForProduct!  LogicProduct.java:32");
        return new java.util.ArrayList(); // new DAOProduct().readDataForProduct(accesoryname);
    }
    
    public DTOProduct readDataForProduct(String accesoryname, String size) {
        
        System.out.println("readDataForProduct!  LogicProduct.java:38");
        return new DTOProduct(); // new DAOProduct().readDataForProduct(accesoryname, size);
    }
    
    public List<String> getListOfCodes() {

        System.out.println("getListOfCodes!  LogicProduct.java:44");
        return new java.util.ArrayList(); // new DAOProduct().getListOfCodes();
    }

    public DTOProduct readProductByCode(String code) {
        
        System.out.println("readProductByCode!  LogicProduct.java:44");
        return new DTOProduct(); // new DAOProduct().readProductByCode(code);
    }

}
