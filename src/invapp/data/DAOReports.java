package invapp.data;

import invapp.dto.DTOProduct;
import invapp.dto.DTOSell;
import invapp.helper.MySQLConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOReports {
    
    public List<DTOSell> getDailyReport(Integer day, Integer month, Integer year) {
        List<DTOSell> lista = new LinkedList<>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call GetDailyReport(?,?,?)");
            cs.setInt("p_day", day);
            cs.setInt("p_month", month);
            cs.setInt("p_year", year);
            rs = cs.executeQuery();
            
            while(rs.next()) {
                lista.add(new DTOSell(rs.getInt("idsell"), rs.getInt("quantity"), 
                        new DTOProduct(rs.getInt("idproduct"), rs.getString("accesoryname"),
                                rs.getInt("stock"), rs.getInt("sold"),
                                rs.getDouble("unitprice"), rs.getString("size"),
                                rs.getString("code"), rs.getString("color"),
                                rs.getString("brand"), rs.getString("model")),
                        "", rs.getTimestamp("date"), rs.getInt("sellnumber")));
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

    public List<DTOSell> getMonthlyReport(Integer month, Integer year) {
        List<DTOSell> lista = new LinkedList<DTOSell>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;
        
        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call GetMonthlyReport(?,?)");
            cs.setInt("p_month", month);
            cs.setInt("p_year", year);
            rs = cs.executeQuery();
            
            while(rs.next()) {
                lista.add(new DTOSell(rs.getInt("idsell"), rs.getInt("quantity"), 
                        new DTOProduct(rs.getInt("idproduct"), rs.getString("accesoryname"),
                                rs.getInt("stock"), rs.getInt("sold"),
                                rs.getDouble("unitprice"), rs.getString("size"),
                                rs.getString("code"), rs.getString("color"),
                                rs.getString("brand"), rs.getString("model")),
                        "", rs.getTimestamp("date"), rs.getInt("sellnumber")));
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
    
}
