package invapp.dto;

import java.util.Date;

public class DTOVenta {
    
    private String accesorio;
    private String vendedor;
    private Integer cantidad;
    private Date fecha;
    
    public String getAccesorio() {
        return this.accesorio;
    }
    
    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }
    
    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
