/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package invapp.data;

import invapp.dto.DTOSell;
import invapp.helper.MySQLConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class DAOSell {
    
    public List<DTOSell> readInventario() {
        List<DTOSell> lista = new LinkedList<DTOSell>();
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
}
