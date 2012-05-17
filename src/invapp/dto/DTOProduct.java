package invapp.dto;

public class DTOProduct {
    
    private Integer idAccesory;
    private String accesory;
    private Integer stock;
    private Integer sold;
    private Double unitPrice;
    private String size;

    public DTOProduct() {
        
    }
    
    public DTOProduct(Integer idAccesory, String accesory, Integer stock, 
                        Integer sold, Double unitPrice, String size) {
        this.idAccesory = idAccesory;
        this.accesory = accesory;
        this.stock = stock;
        this.sold = sold;
        this.unitPrice = unitPrice;
        this.size = size;
    }

    public DTOProduct(Integer idAccesory, String accesory, Integer stock, 
                        Double unitPrice, String size) {
        this.idAccesory = idAccesory;
        this.accesory = accesory;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.size = size;
    }

    public String getAccesory() {
        return accesory;
    }

    public void setAccesory(String accesory) {
        this.accesory = accesory;
    }

    public Integer getIdAccesory() {
        return idAccesory;
    }

    public void setIdAccesory(Integer idAccesory) {
        this.idAccesory = idAccesory;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
 
    
}
