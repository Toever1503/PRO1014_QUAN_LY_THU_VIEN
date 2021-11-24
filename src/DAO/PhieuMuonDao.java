/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuMuon;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class PhieuMuonDao extends LibrarianDAO<PhieuMuon, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE FROM phieu_muon";
    private final String SELECT_BY_ID_SQL = "SELECT ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE FROM phieu_muon WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO phieu_muon(ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE) VALUES (?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE phieu_muon SET HoiVien=?,MaQL=?,NgayMuon=?,NgayHan=?,QR_FILE=? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM the_loai WHERE ID =?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO nha_xuat_ban (ID, TenNhaXuatBan) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenNhaXuatBan=VALUES(TenNhaXuatBan)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE FROM phieu_muon LIMIT ?, 30";

    @Override
    public int insert(PhieuMuon entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getNgayMuon(),
                    entity.getHanTra(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(PhieuMuon entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getNgayMuon(),
                    entity.getHanTra(),
                    entity.getQr_code(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(PhieuMuon entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getNgayMuon(),
                    entity.getHanTra(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public PhieuMuon selectByID(Long id) {
        List<PhieuMuon> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PhieuMuon> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<PhieuMuon> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setId(rs.getLong("ID"));
                pm.setNguoiMuon(rs.getLong("HoiVien"));
                pm.setNguoiXuLy(rs.getString("MaQL"));
                pm.setNgayMuon(rs.getDate("NgayMuon"));
                pm.setHanTra(rs.getDate("NgayHan"));
                pm.setQr_code(rs.getString("QR_FILE"));
                list.add(pm);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
