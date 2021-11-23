/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Sach;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author NguyenHoan
 */
public class SachDAO extends LibrarianDAO<Sach, BigInteger> {

    private String sqlGetByID = "SELECT * FROM sach WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `sach` (`ID`, `MaQL`, `TenSach`, `ViTri`, `NgayTao`, `NhaXuatBan`, `TrangThai`, `QR_FILE`) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE MaQL=VALUES(MaQL), TenSach=VALUES(TenSach), ViTri=VALUES(ViTri), NgayTao=VALUES(NgayTao), NhaXuatBan=VALUES(NhaXuatBan), TrangThai=VALUES(TrangThai), QR_FILE=VALUES(QR_FILE)";
    private String sqlGetAll = "SELECT * FROM sach";
    private String sqlGetByPage = "SELECT * FROM sach LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM sach WHERE ID = ?";

    @Override
    public int insert(Sach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Sach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sach selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sach> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
