package invapp.data;

import invapp.dto.DTOSale;
import invapp.helper.MySQLConnector;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class DAOSale {
    
    public void insertSale(DTOSale sale) {
        Connection conn = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call InsertSale(?,?,?,?,?)");
            cs.setString("p_code", sale.getProduct().getCode());
            cs.setInt("p_salenumber", sale.getSaleNumber());
            cs.setInt("p_quantity", sale.getQuantity());
            cs.setDouble("p_total", sale.getProduct().getUnitPrice() * sale.getQuantity());
            cs.setTimestamp("p_date", (Timestamp)sale.getDate());
            cs.execute();
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException sqe) {
                sqe.printStackTrace();
            }
        }
    }

    public int getNewSaleNumber() {
        Connection conn = null;
        CallableStatement cs;
        ResultSet rs = null;
        int saleNumber = 0;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call GetNewsaleNumber()");
            rs = cs.executeQuery();
            
            if(rs.next())
                saleNumber = rs.getInt("salenumber");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException sqe) {
                sqe.printStackTrace();
            }
        }
        
        return saleNumber;
    }
    
}
