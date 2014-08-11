package invapp.dto;

public class DTOProduct {

    private String code;
    private String product;
    private Double unitPrice;
    private Boolean saleType;   // 0 for weight and 1 for quantity
    private Double stock;

    public DTOProduct() {

    }

    public DTOProduct(String code, String product, Double unitPrice, Boolean saleType, Double stock) {
        this.code = code;
        this.product = product;
        this.unitPrice = unitPrice;
        this.saleType = saleType;
        this.stock = stock;
    }

    public DTOProduct(String code, String product, Double unitPrice, String saleType, Double stock) {
        this.code = code;
        this.product = product.trim();
        this.unitPrice = unitPrice;
        this.saleType = saleType.trim().equals("1");
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

    public Boolean getSaleType() {
        return saleType;
    }

    public void setSaleType(Boolean saleType) {
        this.saleType = saleType;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "DTOProduct{" + "code=" + code + ", product=" + product + ", unitPrice=" + unitPrice + ", saleType=" + saleType + '}';
    }
    
}
