package invapp.dto;

public class DTOInventario {
    
    private Integer idAccesorio;
    private String accesorio;
    private Integer existencia;
    private Integer vendidas;
    private Double precioUnitario;
    private String talla;

    public DTOInventario() {
        
    }
    
    public DTOInventario(Integer idAccesorio, String accesorio, Integer existencia, 
                        Integer vendidas, Double precioUnitario, String talla) {
        this.idAccesorio = idAccesorio;
        this.accesorio = accesorio;
        this.existencia = existencia;
        this.vendidas = vendidas;
        this.precioUnitario = precioUnitario;
        this.talla = talla;
    }
    
    public String getAccesorio() {
        return accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getVendidas() {
        return vendidas;
    }

    public void setVendidas(Integer vendidas) {
        this.vendidas = vendidas;
    }
    
    public String getTalla() {
        return talla;
    }
    
    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getIdAccesorio() {
        return idAccesorio;
    }

    public void setIdAccesorio(Integer idAccesorio) {
        this.idAccesorio = idAccesorio;
    }
    
}
