/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TacGia;
import java.math.BigInteger;
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
public class TacGiaDao implements DAO<TacGia, BigInteger> {

    private String sqlGetByID = "SELECT * FROM tac_gia WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `tac_gia` (`ID`, `TenTacGia`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTacGia=VALUES(TenTacGia)";
    private String sqlGetAll = "SELECT * FROM tac_gia";
    private String sqlGetByPage = "SELECT * FROM tac_gia LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM tac_gia WHERE ID = ?";
    private static TacGiaDao tacGiaDao;

    private TacGiaDao() {
    }

    public static TacGiaDao getInstance() {
        if (tacGiaDao == null) {
            tacGiaDao = new TacGiaDao();
        }
        return tacGiaDao;
    }

    @Override
    public TacGia getById(BigInteger id) {
        Connection con = CONNECTION.getConnection();
        TacGia tacGia = null;
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByID);
            prepare.setObject(1, id);
            prepare.execute();
            ResultSet resultSet = prepare.getResultSet();

            while (resultSet.next()) {
                tacGia = new TacGia(resultSet.getObject("ID", BigInteger.class), resultSet.getNString("TenTacGia"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Get author failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Close connection failed", ex);
            }
        }

        return tacGia == null ? null : tacGia;
    }

    @Override
    public List<TacGia> getALL() {
        Connection con = CONNECTION.getConnection();
        List<TacGia> tacGiaList = new ArrayList<TacGia>();
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetAll);
            prepare.execute();
            ResultSet resultSet = prepare.getResultSet();

            while (resultSet.next()) {
                tacGiaList.add(new TacGia(resultSet.getObject("ID", BigInteger.class), resultSet.getNString("TenTacGia")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Get List auhor failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Close connection failed", ex);
            }
        }
        return tacGiaList.size() == 0 ? null : tacGiaList;
    }

    @Override
    public int save(TacGia obj) {
        Connection con = CONNECTION.getConnection();
        TacGia tacGia = null;
        int check = 0;
        try {
            con.setAutoCommit(false);
            PreparedStatement prepare = con.prepareStatement(sqlSaveOnUpdate);
            prepare.setObject(1, obj.getId());
            prepare.setObject(2, obj.getTenTacGia());
            check = prepare.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Rollback trans failed", ex1);
            }
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Save obj failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Close connection failed", ex);
            }
        }
        return check;
    }

    @Override
    public int deleteById(BigInteger id) {
        int check = 0;
        Connection con = CONNECTION.getConnection();

        try {
            con.setAutoCommit(false);
            PreparedStatement prepare = con.prepareStatement(sqlDeleteByID);
            prepare.setObject(1, id);
            check = prepare.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Rollback trans failed", ex1);
            }
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Delete obj failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Close connection failed", ex);
            }
        }
        return check;
    }

    @Override
    public List<TacGia> getListByPage(BigInteger page
    ) {
        Connection con = CONNECTION.getConnection();
        List<TacGia> tacGiaList = new ArrayList<TacGia>();
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByPage);
            prepare.setObject(1, BigInteger.valueOf(30l).multiply(page));
            prepare.execute();
            ResultSet resultSet = prepare.getResultSet();

            while (resultSet.next()) {
                tacGiaList.add(new TacGia(resultSet.getObject("ID", BigInteger.class), resultSet.getNString("TenTacGia")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Get List auhor failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, "Close connection failed", ex);
            }
        }
        return tacGiaList.size() == 0 ? null : tacGiaList;
    }

}
