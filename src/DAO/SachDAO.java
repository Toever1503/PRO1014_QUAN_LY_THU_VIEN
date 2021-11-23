/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Sach;
import java.math.BigInteger;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenHoan
 */
public class SachDAO implements DAO<Sach, BigInteger> {

    private String sqlGetByID = "SELECT * FROM sach WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `sach` (`ID`, `MaQL`, `TenSach`, `ViTri`, `NgayTao`, `NhaXuatBan`, `TrangThai`, `QR_FILE`) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE MaQL=VALUES(MaQL), TenSach=VALUES(TenSach), ViTri=VALUES(ViTri), NgayTao=VALUES(NgayTao), NhaXuatBan=VALUES(NhaXuatBan), TrangThai=VALUES(TrangThai), QR_FILE=VALUES(QR_FILE)";
    private String sqlGetAll = "SELECT * FROM sach";
    private String sqlGetByPage = "SELECT * FROM sach LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM sach WHERE ID = ?";
    private static SachDAO sachDAO;

    private SachDAO() {
    }

    public static SachDAO getInstance() {
        if (sachDAO == null) {
            sachDAO = new SachDAO();
        }
        return sachDAO;
    }

    @Override
    public Sach getById(BigInteger id) {
        Sach sach = null;
        Connection con = CONNECTION.getConnection();
        if (con == null) {
            return null;
        }
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByID);
            prepare.setObject(1, id);
            prepare.execute();

            ResultSet result = prepare.getResultSet();
            while (result.next()) {
                sach = new Sach(result.getObject("ID", BigInteger.class), result.getNString("TenSach"), result.getNString("ViTri"), result.getObject("NgayTao", Date.class),
                        result.getNString("QR_FILE"),
                        result.getObject("NhaXuatBan", BigInteger.class),
                        result.getNString("MaQL"),
                        result.getObject("TrangThai", Boolean.class));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Get Book Faileds", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return sach == null ? null : sach;
    }

    @Override
    public List<Sach> getALL() {
        List<Sach> listSach = new ArrayList<Sach>();
        Connection con = CONNECTION.getConnection();
        if (con == null) {
            return null;
        }
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetAll);
            prepare.execute();

            ResultSet result = prepare.getResultSet();
            while (result.next()) {
                listSach.add(new Sach(result.getObject("ID", BigInteger.class), result.getNString("TenSach"), result.getNString("ViTri"), result.getObject("NgayTao", Date.class),
                        result.getNString("QR_FILE"),
                        result.getObject("NhaXuatBan", BigInteger.class),
                        result.getNString("MaQL"),
                        result.getObject("TrangThai", Boolean.class)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Get Book Failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return listSach.size() == 0 ? null : listSach;
    }

    @Override
    public int save(Sach obj) {
        int check = 0;
        Connection con = CONNECTION.getConnection();
        if (con == null) {
            return check;
        }

        try {
            con.setAutoCommit(false);
            PreparedStatement prepare = con.prepareStatement(sqlSaveOnUpdate);
            prepare.setObject(1, obj.getId());
            prepare.setObject(2, obj.getNguoiTao());
            prepare.setObject(3, obj.getTenSach());
            prepare.setObject(4, obj.getViTri());
            prepare.setObject(5, obj.getNgayTao());
            prepare.setObject(6, obj.getNhaXuatBan());
            prepare.setObject(7, obj.isTrangThai());
            prepare.setObject(8, obj.getQr_code());
            check = prepare.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Rollback save book failed", ex1);
            }
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Save book failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }

        return check;
    }

    @Override
    public int deleteById(BigInteger id) {
        int check = 0;
        Connection con = CONNECTION.getConnection();
        if (con == null) {
            return check;
        }
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
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Rollback save book failed", ex1);
            }
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Delete book failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }

        return check;
    }

    @Override
    public List<Sach> getListByPage(BigInteger page) {
        List<Sach> listSach = new ArrayList<Sach>();
        Connection con = CONNECTION.getConnection();
        if (con == null) {
            return null;
        }
        try {
            PreparedStatement prepare = con.prepareStatement(sqlGetByPage);
            prepare.setObject(1, BigInteger.valueOf(15).multiply(page));
            prepare.execute();

            ResultSet result = prepare.getResultSet();
            while (result.next()) {
                listSach.add(new Sach(result.getObject("ID", BigInteger.class), result.getNString("TenSach"), result.getNString("ViTri"), result.getObject("NgayTao", Date.class),
                        result.getNString("QR_FILE"),
                        result.getObject("NhaXuatBan", BigInteger.class),
                        result.getNString("MaQL"),
                        result.getObject("TrangThai", Boolean.class)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Get Book Failed", ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, "Close connect failed", ex);
            }
        }
        return listSach.size() == 0 ? null : listSach;
    }
    
}
