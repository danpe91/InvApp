package invapp.data;

import invapp.dto.DTOSell;
import invapp.helper.MySQLConnector;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class DAOSell {
    
    public List<DTOSell> sreadSells() {
        List<DTOSell> lista = new LinkedList<>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call ReadSells()");
            rs = cs.executeQuery();
            
            while(rs.next()) {
                lista.add(new DTOSell());
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
    
    public void insertSell(DTOSell sell) {
        Connection conn = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call InsertSell(?,?,?,?,?)");
            cs.setInt("p_idproduct", sell.getProduct().getIdAccesory());
            cs.setInt("p_sellnumber", sell.getSellNumber());
            cs.setInt("p_quantity", sell.getQuantity());
            cs.setDouble("p_total", sell.getProduct().getUnitPrice() * sell.getQuantity());
            cs.setTimestamp("p_date", (Timestamp)sell.getDate());
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

    public int getNewSellNumber() {
        Connection conn = null;
        CallableStatement cs;
        ResultSet rs = null;
        int sellNumber = 0;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call GetNewSellNumber()");
            rs = cs.executeQuery();
            
            if(rs.next())
                sellNumber = rs.getInt("sellnumber");
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
        
        return sellNumber;
    }
    
}
