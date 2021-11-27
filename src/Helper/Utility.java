/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class Utility {

    private static Connection getConnection() {
        Dotenv sqlConfig = DOTENV.getEnv("config.env"); // get sqlConfig from .env file
        if (sqlConfig == null) { // return null if config null
            return null;
        }

        // get config infor
        String dbName = sqlConfig.get("DB_NAME");
        String dbPort = sqlConfig.get("DB_PORT");
        String dbHost = sqlConfig.get("DB_HOST");
        String dbUser = sqlConfig.get("DB_USERNAME");
        String dbPassword = sqlConfig.get("DB_PASSWORD");
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?noAccessToProcedureBodies=true";

        Connection con = null;
        try {
            Class.forName(sqlConfig.get("DB_DRIVER")); // get driver
            con = DriverManager.getConnection(url, dbUser, dbPassword); // get connection
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con; // return null if connecttion failed else connection object
    }

    private static PreparedStatement getStm(String sql, Object... args) throws Exception {
        PreparedStatement ps = null;
        if (sql.trim().startsWith("{")) {
            ps = new Utility().getConnection().prepareCall(sql);
        } else {
            ps = new Utility().getConnection().prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }

    public static ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement ps = Utility.getStm(sql, args);
        return ps.executeQuery();
    }

    public static int update(String sql, Object... args) throws Exception {
        try {
            PreparedStatement ps = Utility.getStm(sql, args);
            try {
                return ps.executeUpdate();
            } finally {
                ps.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public static Object value(String sql, Object... args) {
//        try {
//            ResultSet rs = Utility.query(sql, args);
//            if (rs.next()) {
//                return rs.getObject(0);
//            }
//            rs.getStatement().getConnection().close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
}
