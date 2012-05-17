package invapp.dto;

import java.sql.Timestamp;

public class DTOSell {
    
    private Integer idSell;
    private DTOProduct product;
    private Integer quantity;
    private Integer sellNumber;
    private String seller;
    private Timestamp date;
    
    public DTOSell() {
        
    }
    
    public DTOSell(Integer idSell, Integer quantity, DTOProduct product,
                    String seller, Timestamp date, Integer sellNumber) {
        this.idSell = idSell;
        this.quantity = quantity;
        this.product = product;
        this.seller = seller;
        this.date = date;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

}
