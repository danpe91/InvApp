package invapp.dto;

public class DTOProduct {

    private Integer code;
    private String product;
    private Double unitPrice;
    private Boolean saleType;   // 0 for weight and 1 for quantity

    public DTOProduct() {

    }

    public DTOProduct(Integer code, String product, Double unitPrice, Boolean saleType) {
        this.code = code;
        this.product = product;
        this.unitPrice = unitPrice;
        this.saleType = saleType;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

}
