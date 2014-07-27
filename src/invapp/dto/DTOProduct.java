package invapp.dto;

public class DTOProduct {

    private String code;
    private String product;
    private Double unitPrice;
    
    public DTOProduct() {

    }

    public DTOProduct(String code, String product, Double unitPrice) {
        this.code = code;
        this.product = product;
        this.unitPrice = unitPrice;
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

    @Override
    public String toString() {
        return "DTOProduct{" + "code=" + code + ", product=" + product + ", unitPrice=" + unitPrice +  '}';
    }

    
}
