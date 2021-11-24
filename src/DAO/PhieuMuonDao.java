/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuMuon;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class PhieuMuonDao extends DAO<PhieuMuon, BigInteger> {

    private final String SELECT_ALL_BY_PAGE_SQL = "SELECT ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE FROM `phieu_muon` LIMIT ?, 30";
    private final String SELECT_BY_ID_SQL = "INSERT INTO `phieu_muon` (`ID`, `HoiVien`, `MaQL`, `NgayMuon`, `NgayHan`, `QR_FILE`) VALUES (?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE HoiVien=VALUES(HoiVien), MaQL=VALUES(MaQL), NgayMuon=VALUES(NgayMuon), NgayHan=VALUES(NgayHan),QR_FILE=VALUES(QR_FILE)";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO gop_y (ID, HoiVien, NgayTao, NoiDung, TrangThai) VALUES (?,?,?,?,?)";
    private final String DELETE_SQL = "DELETE FROM `phieu_muon` WHERE ID = ?";
    
    private static HoaDonDenBuDao instance;

    @Override
    public int save(PhieuMuon entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getNgayMuon(),
                    entity.getHanTra(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Insert PhieuMuon Failed", ex);
        }
        return row;
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhieuMuon selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhieuMuon> selectAllByPage(int page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
