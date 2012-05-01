package invapp.dto;

import java.util.Date;

public class DTOSell {
    
    private Integer idAccesory;
    private Integer idSell;
    private Integer quantity;
    private String accesory;
    private String seller;
    private Date date;

    public String getAccesory() {
        return accesory;
    }

    public void setAccesory(String accesory) {
        this.accesory = accesory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdAccesory() {
        return idAccesory;
    }

    public void setIdAccesory(Integer idAccesory) {
        this.idAccesory = idAccesory;
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
        
}
