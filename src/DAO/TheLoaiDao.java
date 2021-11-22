/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TheLoai;
import java.math.BigInteger;
import java.util.List;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class TheLoaiDao implements DAO<TheLoai, BigInteger> {
    
    private String sqlGetByID = "SELECT * FROM the_loai WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `the_loai` (`ID`, `TenTheLoai`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTheLoai=VALUES(TenTheLoai)";
    private String sqlGetAll = "SELECT * FROM the_loai";
    private String sqlGetByPage = "SELECT * FROM the_loai LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM the_loai WHERE ID = ?";
    private static TheLoaiDao theLoaiDao;
    
    private TheLoaiDao() {
    }
    
    public static TheLoaiDao getInstance() {
        if (theLoaiDao == null) {
            theLoaiDao = new TheLoaiDao();
        }
        return theLoaiDao;
    }
    
    @Override
    public TheLoai getById(BigInteger id) {
        Connection con = CONNECTION.getConnection();
        TheLoai theLoai = null;
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByPage);
            prepare.setObject(1, id);
            prepare.execute();
            ResultSet result = prepare.getResultSet();
            
            while (result.next()) {
                theLoai = new TheLoai(result.getObject("ID", BigInteger.class), result.getNString("TenTheLoai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Get Cat failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return theLoai == null ? null : theLoai;
    }
    
    @Override
    public List<TheLoai> getALL() {
        Connection con = CONNECTION.getConnection();
        List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetAll);
            prepare.execute();
            ResultSet result = prepare.getResultSet();
            
            while (result.next()) {
                listTheLoai.add(new TheLoai(result.getObject("ID", BigInteger.class), result.getNString("TenTheLoai")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Get Cat failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return listTheLoai.size() == 0 ? null : listTheLoai;
    }
    
    @Override
    public int save(TheLoai obj) {
        Connection con = CONNECTION.getConnection();
        int check = 0;
        try {
            PreparedStatement prepare = con.prepareStatement(sqlSaveOnUpdate);
            prepare.setObject(1, obj.getId());
            prepare.setObject(2, obj.getTenTheLoai());
            check = prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Save Cat failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return check;
    }
    
    @Override
    public int deleteById(BigInteger id) {
        Connection con = CONNECTION.getConnection();
        int check = 0;
        try {
            PreparedStatement prepare = con.prepareStatement(sqlDeleteByID);
            prepare.setObject(1, id);
            check = prepare.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Delete Cat failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return check;
    }
    
    @Override
    public List<TheLoai> getListByPage(BigInteger page) {
        Connection con = CONNECTION.getConnection();
        List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByPage);
            prepare.setObject(1, BigInteger.valueOf(15).multiply(page));
            prepare.execute();
            ResultSet result = prepare.getResultSet();
            while (result.next()) {
                listTheLoai.add(new TheLoai(result.getObject("ID", BigInteger.class), result.getNString("TenTheLoai")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Get Cat failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return listTheLoai.size() == 0 ? null : listTheLoai;
    }
    
}
