package invapp.data;

import invapp.dto.DTOProduct;
import invapp.helper.MySQLConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOProduct {
    
    public DAOProduct() {
        
    }

    public List<DTOProduct> readInventory() {
        
        List<DTOProduct> lista = new LinkedList<DTOProduct>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call ReadInventory()");
            rs = cs.executeQuery();
            
            while(rs.next()) {
                lista.add(new DTOProduct(rs.getInt("idproduct"), rs.getString("accesoryname"), rs.getInt("stock"),
                        rs.getInt("sold"), rs.getDouble("unitprice"), rs.getString("size"), rs.getString("code"),
                        rs.getString("color"), rs.getString("brand"), rs.getString("model")));
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
    
    public void insertProduct(DTOProduct prod) {
        
        Connection conn = null;
        CallableStatement cs;
        
        try {
            
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call InsertProduct(?,?,?,?,?,?,?,?)");
            cs.setString("p_accesoryname", prod.getAccesory());
            cs.setInt("p_stock", prod.getStock());
            cs.setDouble("p_unitprice", prod.getUnitPrice());
            cs.setString("p_size", prod.getSize());
            cs.setString("p_code", prod.getCode());
            cs.setString("p_color", prod.getColor());
            cs.setString("p_brand", prod.getBrand());
            cs.setString("p_model", prod.getModel());
            
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
    
    public void editProduct(DTOProduct prod) {
        
        Connection conn = null;
        CallableStatement cs;
        
        try {
            
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call UpdateProduct(?,?,?,?,?,?,?,?,?)");
            cs.setInt("p_idproduct", prod.getIdAccesory());
            cs.setString("p_accesoryname", prod.getAccesory());
            cs.setInt("p_stock", prod.getStock());
            cs.setDouble("p_unitprice", prod.getUnitPrice());
            cs.setString("p_size", prod.getSize());
            cs.setString("p_code", prod.getCode());
            cs.setString("p_color", prod.getColor());
            cs.setString("p_brand", prod.getBrand());
            cs.setString("p_model", prod.getModel());
            
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

    public List<DTOProduct> readProducts() {
        
        List<DTOProduct> lista = new LinkedList<DTOProduct>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call readProducts()");
            rs = cs.executeQuery();
            
            while(rs.next()) {
                lista.add(new DTOProduct(rs.getInt("idproduct"), rs.getString("accesoryname"), rs.getInt("stock"),
                        rs.getInt("sold"), rs.getDouble("unitprice"), rs.getString("size"), rs.getString("code"),
                        rs.getString("color"), rs.getString("brand"), rs.getString("model")));
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
    
    public List<DTOProduct> readDataForProduct(String accesoryname) {
        
        List<DTOProduct> lista = new LinkedList<DTOProduct>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call GetDataByName(?)");
            cs.setString("p_accesoryname", accesoryname);
            rs = cs.executeQuery();
            
            while(rs.next()) {
                lista.add(new DTOProduct(rs.getInt("idproduct"), rs.getString("accesoryname"), rs.getInt("stock"),
                        rs.getInt("sold"), rs.getDouble("unitprice"), rs.getString("size"), rs.getString("code"),
                        rs.getString("color"), rs.getString("brand"), rs.getString("model")));
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
    
    public DTOProduct readDataForProduct(String accesoryname, String size) {
        
        DTOProduct lista = new DTOProduct();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call GetDataByNameandsize(?,?)");
            cs.setString("p_accesoryname", accesoryname);
            cs.setString("p_size", size);
            rs = cs.executeQuery();
            
            if(rs.next()) {
                lista = (new DTOProduct(rs.getInt("idproduct"), rs.getString("accesoryname"), rs.getInt("stock"),
                        rs.getInt("sold"), rs.getDouble("unitprice"), rs.getString("size"), rs.getString("code"),
                        rs.getString("color"), rs.getString("brand"), rs.getString("model")));
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
    
    public List<String> getListOfCodes() {
        
        List<String> list = new LinkedList<String>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call ReadCodes()");
            rs = cs.executeQuery();
            
            while(rs.next()) {
                list.add(rs.getString("code"));
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
        return list;
    }

    public DTOProduct readProductByCode(String code) {
        DTOProduct product = new DTOProduct();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call ReadProductByCode(?)");
            cs.setString("p_code", code);
            rs = cs.executeQuery();
            
            if(rs.next()) {
                product = new DTOProduct(rs.getInt("idproduct"), rs.getString("accesoryname"), rs.getInt("stock"),
                        rs.getInt("sold"), rs.getDouble("unitprice"), rs.getString("size"), code,
                        rs.getString("color"), rs.getString("brand"), rs.getString("model"));
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
        return product;
    }
}
