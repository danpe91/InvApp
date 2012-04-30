package invapp.data;

import invapp.dto.DTOInventario;
import invapp.helper.MySQLConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOInventario {
    
    public DAOInventario() {
        
    }

    public List<DTOInventario> readInventario() {
        List<DTOInventario> lista = new LinkedList<DTOInventario>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call ReadInventory()");
            rs = cs.executeQuery();
            
            while(rs.next()) {
                lista.add(new DTOInventario(rs.getInt("idproduct"), rs.getString("accesoryname"), rs.getInt("stock"),
                        rs.getInt("sold"), rs.getDouble("unitprice"), rs.getString("size")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    conn.close();
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }
    
    public void insertProduct(DTOInventario prod) {
        Connection conn = null;
        CallableStatement cs;
        
        try {
            
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call InsertProduct(?,?,?,?,?)");
            cs.setString("p_accesoryname", prod.getAccesorio());
            cs.setInt("p_stock", prod.getExistencia());
            cs.setInt("p_sold", prod.getVendidas());
            cs.setDouble("p_unitprice", prod.getPrecioUnitario());
            cs.setString("p_size", prod.getTalla());
            
            cs.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void editProduct(DTOInventario prod) {
        Connection conn = null;
        CallableStatement cs;
        
        try {
            
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call UpdateProduct(?,?,?,?,?,?)");
            cs.setInt("p_idproduct", prod.getIdAccesorio());
            cs.setString("p_accesoryname", prod.getAccesorio());
            cs.setInt("p_stock", prod.getExistencia());
            cs.setInt("p_sold", prod.getVendidas());
            cs.setDouble("p_unitprice", prod.getPrecioUnitario());
            cs.setString("p_size", prod.getTalla());
            
            cs.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
