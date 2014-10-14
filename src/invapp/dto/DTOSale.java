package invapp.dto;

import invapp.helper.MyTimestamp;

public class DTOSale {
    
    private Integer idSale;
    private DTOProduct product;
    private Integer quantity;
    private Integer saleNumber;
    private String saleer;
    private MyTimestamp date;
    
    public DTOSale() {
        
    }
    
    public DTOSale(Integer idSale, Integer quantity, DTOProduct product,
                    String saleer, java.sql.Timestamp date, Integer saleNumber) {
        this.idSale = idSale;
        this.quantity = quantity;
        this.product = product;
        this.saleer = saleer;
        this.date = new MyTimestamp(date);
        this.saleNumber = saleNumber;
        
    }

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSaleer() {
        return saleer;
    }

    public void setSaleer(String saleer) {
        this.saleer = saleer;
    }

    public Integer getSaleNumber() {
        return saleNumber;
    }
    
    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    public DTOProduct getProduct() {
        return product;
    }

    public void setProduct(DTOProduct product) {
        this.product = product;
    }

    public MyTimestamp getDate() {
        return date;
    }

    public void setDate(MyTimestamp date) {
        this.date = date;
    }

}
