package invapp.dto;

public class DTOProduct implements Comparable<DTOProduct> {

    private String code;
    private String product;
    private Double unitPrice;
    private Integer stock;
    
    public DTOProduct() {

    }

    public DTOProduct(String code, String product, Double unitPrice, Integer stock) {
        this.code = code;
        this.product = product;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "DTOProduct{" + "code=" + code + ", product=" + product + ", unitPrice=" + unitPrice +  '}';
    }

    @Override
    public int compareTo(DTOProduct o) {
        
        return this.product.compareTo(o.getProduct());
    }

    
}
