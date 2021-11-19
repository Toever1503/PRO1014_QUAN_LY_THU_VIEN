/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.DOTENV;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class CONNECTION {

    public static Connection getConnection() {
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
        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Connection con = null;
        try {
            Class.forName(sqlConfig.get("DB_DRIVER")); // get driver
            con = DriverManager.getConnection(url, dbUser, dbPassword); // get connection
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CONNECTION.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CONNECTION.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con; // return null if connecttion failed else connection object
    }
    
}
