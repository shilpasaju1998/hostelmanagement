package stech.db;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author sherin
 */
public class Database {

    private final Connection _conn;
    private PreparedStatement _stmt;

    public Database() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        _conn = DriverManager.getConnection("jdbc:mysql://"
                + Configurations.HOST + ":3306/" + Configurations.DB, Configurations.USER, Configurations.PWD);
    }

    public int Modify(String sql, String[] param) throws Exception {
        _stmt = _conn.prepareStatement(sql);
        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                _stmt.setString(i + 1, param[i]);
            }
        }
        System.out.println("Modify: " + _stmt);
        return _stmt.executeUpdate();
    }

    public ArrayList<String[]> Select(String sql, String[] param) throws Exception {
        ArrayList<String[]> datas = new ArrayList<String[]>();
        _stmt = _conn.prepareStatement(sql);
        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                _stmt.setString(i + 1, param[i]);
            }
        }
        System.out.println("Select: " + _stmt);
        int colSize = _stmt.getMetaData().getColumnCount();
        ResultSet rs = _stmt.executeQuery();
        while (rs.next()) {
            String[] data = new String[colSize];
            for (int i = 0; i < colSize; i++) {
                data[i] = rs.getString(i + 1);
            }
            datas.add(data);
        }
        return datas;
    }
}
