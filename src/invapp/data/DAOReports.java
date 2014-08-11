package invapp.data;

import invapp.dto.DTOProduct;
import invapp.dto.DTOSale;
import invapp.helper.MySQLConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOReports {

    public List<DTOSale> getDailyReport(Integer day, Integer month, Integer year) {
        List<DTOSale> lista = new LinkedList<>();
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

            while (rs.next()) {
                lista.add(new DTOSale(rs.getInt("idsale"), rs.getDouble("quantity"),
                        new DTOProduct(rs.getString("code"), rs.getString("product"), rs.getDouble("unitprice"), rs.getBoolean("saleType"), rs.getInt("stock")),
                        "", rs.getTimestamp("date"), rs.getInt("salenumber")));
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

    public List<DTOSale> getMonthlyReport(Integer month, Integer year) {
        List<DTOSale> lista = new LinkedList<DTOSale>();
        Connection conn = null;
        ResultSet rs = null;
        CallableStatement cs;

        try {
            conn = MySQLConnector.getMySqlConnection();
            cs = conn.prepareCall("call GetMonthlyReport(?,?)");
            cs.setInt("p_month", month);
            cs.setInt("p_year", year);
            rs = cs.executeQuery();

            while (rs.next()) {
                lista.add(new DTOSale(rs.getInt("idsale"), rs.getDouble("quantity"),
                        new DTOProduct(rs.getString("code"), rs.getString("product"), rs.getDouble("unitprice"), rs.getBoolean("saleType"), rs.getInt("stock")),
                        "", rs.getTimestamp("date"), rs.getInt("salenumber")));
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
