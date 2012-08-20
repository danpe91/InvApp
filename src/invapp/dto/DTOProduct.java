package invapp.dto;

public class DTOProduct {
    
    private Integer idAccesory;
    private String accesory;
    private Integer stock;
    private Integer sold;
    private Double unitPrice;
    private String size;
    private String code;
    private String color;
    private String brand;
    private String model;
	
    public DTOProduct() {
        
    }
    
    public DTOProduct(Integer idAccesory, String accesory, Integer stock, 
                        Integer sold, Double unitPrice, String size, String code,
                        String color, String brand, String model) {
        this.idAccesory = idAccesory;
        this.accesory = accesory;
        this.stock = stock;
        this.sold = sold;
        this.unitPrice = unitPrice;
        this.size = size;
        this.code = code;
        this.color = color;
        this.brand = brand;
        this.model = model;
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
	 
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
        public String getCode() {
            return code;
        }
        
        public void setCode(String code) {
            this.code = code;
        }
        
        public String toString() {
            return "Código: " + this.code +
                    "\nProducto: " + this.accesory + 
                    "\n Marca: " + this.brand + 
                    "\n Modelo: " + this.model;
        }
}
