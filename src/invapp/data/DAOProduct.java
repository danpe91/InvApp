package invapp.data;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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

        List<DTOProduct> lista = new LinkedList<>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;

        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call ReadInventory()");
            rs = cs.executeQuery();

            while (rs.next()) {
                lista.add(new DTOProduct(rs.getString("code"), rs.getString("product"), rs.getDouble("unitprice"), rs.getBoolean("saleType")));
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
            cs = conn.prepareCall("call InsertProduct(?,?,?,?)");
            cs.setString("p_code", prod.getCode());
            cs.setString("p_product", prod.getProduct());
            cs.setDouble("p_unitprice", prod.getUnitPrice());
            cs.setBoolean("p_saletype", prod.getSaleType());

            cs.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException e) {
            
            javax.swing.JOptionPane.showMessageDialog(null, "Error: ya se encuentra un producto con "
                    + "esa clave", "Ha ocurrido un error", javax.swing.JOptionPane.ERROR_MESSAGE);
        
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
            cs = conn.prepareCall("call UpdateProduct(?,?,?,?)");
            cs.setString("p_code", prod.getCode());
            cs.setString("p_product", prod.getProduct());
            cs.setDouble("p_unitprice", prod.getUnitPrice());
            cs.setBoolean("p_saletype", prod.getSaleType());

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

            while (rs.next()) {
                lista.add(new DTOProduct(rs.getString("code"), rs.getString("product"), rs.getDouble("unitprice"), rs.getBoolean("saleType")));
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

            while (rs.next()) {
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

            if (rs.next()) {
                product = new DTOProduct(rs.getString("code"), rs.getString("product"), rs.getDouble("unitprice"), rs.getBoolean("saleType"));
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
