package invapp.dto;

import invapp.helper.MyTimestamp;

public class DTOSale {
    
    private Integer idSell;
    private DTOProduct product;
    private Integer quantity;
    private Integer sellNumber;
    private String seller;
    private MyTimestamp date;
    
    public DTOSale() {
        
    }
    
    public DTOSale(Integer idSell, Integer quantity, DTOProduct product,
                    String seller, java.sql.Timestamp date, Integer sellNumber) {
        this.idSell = idSell;
        this.quantity = quantity;
        this.product = product;
        this.seller = seller;
        this.date = new MyTimestamp(date);
        this.sellNumber = sellNumber;
        
    }

    public Integer getIdSell() {
        return idSell;
    }

    public void setIdSell(Integer idSell) {
        this.idSell = idSell;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getSellNumber() {
        return sellNumber;
    }
    
    public void setSellNumber(Integer sellNumber) {
        this.sellNumber = sellNumber;
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
