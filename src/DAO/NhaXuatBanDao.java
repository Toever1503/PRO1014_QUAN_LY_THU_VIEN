/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhaXuatBan;
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
public class NhaXuatBanDao implements DAO<NhaXuatBan, BigInteger> {

    private String sqlGetByID = "SELECT * FROM nha_xuat_ban WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `nha_xuat_ban` (`ID`, `TenNhaXuatBan`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenNhaXuatBan=VALUES(TenNhaXuatBan)";
    private String sqlGetAll = "SELECT * FROM nha_xuat_ban";
    private String sqlGetByPage = "SELECT * FROM nha_xuat_ban LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM nha_xuat_ban WHERE ID = ?";
    private static NhaXuatBanDao nhaXuatBanDao;

    private NhaXuatBanDao() {
    }

    public static NhaXuatBanDao getInstance() {
        if (nhaXuatBanDao == null) {
            nhaXuatBanDao = new NhaXuatBanDao();
        }
        return nhaXuatBanDao;
    }

    @Override
    public NhaXuatBan getById(BigInteger id) {
        Connection con = CONNECTION.getConnection();
        NhaXuatBan nhaXuatBan = null;
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByID);
            prepare.setObject(1, id);
            prepare.execute();

            ResultSet result = prepare.getResultSet();
            while (result.next()) {
                nhaXuatBan = new NhaXuatBan(result.getObject("ID", BigInteger.class), result.getNString("TenNhaXuatBan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Get Publisher failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }

        return nhaXuatBan == null ? null : nhaXuatBan;
    }

    @Override
    public List<NhaXuatBan> getALL() {
        Connection con = CONNECTION.getConnection();
        List<NhaXuatBan> listNhaXuatBan = new ArrayList<NhaXuatBan>();
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetAll);
            prepare.execute();

            ResultSet result = prepare.getResultSet();
            while (result.next()) {
                listNhaXuatBan.add(new NhaXuatBan(result.getObject("ID", BigInteger.class), result.getNString("TenNhaXuatBan")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Get Publisher failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return listNhaXuatBan.size() == 0 ? null : listNhaXuatBan;
    }

    @Override
    public int save(NhaXuatBan obj) {
        Connection con = CONNECTION.getConnection();
        int check = 0;

        try {
            PreparedStatement prepare = con.prepareStatement(sqlSaveOnUpdate);
            prepare.setObject(1, obj.getId());
            prepare.setObject(2, obj.getTenNhaXuatBan());
            check = prepare.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Save Publisher failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
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
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Delete Publisher failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return check;
    }

    @Override
    public List<NhaXuatBan> getListByPage(BigInteger page) {
        Connection con = CONNECTION.getConnection();
        List<NhaXuatBan> listNhaXuatBan = new ArrayList<NhaXuatBan>();
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByPage);
            prepare.setObject(1, BigInteger.valueOf(15).multiply(page));
            prepare.execute();

            ResultSet result = prepare.getResultSet();
            while (result.next()) {
                listNhaXuatBan.add(new NhaXuatBan(result.getObject("ID", BigInteger.class), result.getNString("TenNhaXuatBan")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Get Publisher failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return listNhaXuatBan.size() == 0 ? null : listNhaXuatBan;
    }
}
