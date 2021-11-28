/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuMuonChiTiet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class PhieuMuonChiTietDao extends LibrarianDAO<PhieuMuonChiTiet, Long> {

    private final String SELECT_ALL_SQL = "SELECT PhieuMuon, Sach, NguoiTiepNhan, NgayTra, TrangThai FROM phieu_muon_chi_tiet Where PhieuMuon = ?";
    private final String SELECT_BY_SACH_SQL = "SELECT PhieuMuon, Sach, NguoiTiepNhan, NgayTra, TrangThai FROM phieu_muon_chi_tiet WHERE Sach = ?";
    private final String INSERT_SQL = "INSERT INTO phieu_muon_chi_tiet(PhieuMuon, Sach, NguoiTiepNhan, NgayTra, TrangThai) VALUES (?,?,?,?,?)";
    private final String UPDATE_BY_PM_SACH_SQL = "UPDATE phieu_muon_chi_tiet SET NguoiTiepNhan=?,NgayTra=?,TrangThai=? WHERE PhieuMuon=? AND Sach=?";
    private final String DELETE_BY_SACH_SQL = "DELETE FROM phieu_muon_chi_tiet WHERE PhieuMuon = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO phieu_muon_chi_tiet (PhieuMuon, Sach, NguoiTiepNhan, NgayTra, TrangThai) VALUES (?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE NguoiTiepNhan=VALUES(NguoiTiepNhan), NgayTra=VALUES(NgayTra), TrangThai=VALUES(TrangThai)";
    private final String SELECT_BY_PAGE_SQL = "SELECT PhieuMuon, Sach, NguoiTiepNhan, NgayTra, TrangThai FROM phieu_muon_chi_tiet LIMIT ?, 30";
    private SachDAO sachDao;
    private static PhieuMuonChiTietDao instance;

    private PhieuMuonChiTietDao() {
        sachDao = SachDAO.getInstance();
    }

    public static PhieuMuonChiTietDao getInstance() {
        if (instance == null) {
            instance = new PhieuMuonChiTietDao();
        }
        return instance;
    }

    @Override
    public int insert(PhieuMuonChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getPhieuMuon(),
                    entity.getSach(),
                    entity.getNguoiXuLy(),
                    entity.getNgayTra(),
                    entity.isTrangThai()
            );
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(PhieuMuonChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_BY_PM_SACH_SQL,
                    entity.getNguoiXuLy(),
                    entity.getNgayTra(),
                    entity.isTrangThai(),
                    entity.getPhieuMuon(),
                    entity.getSach());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(PhieuMuonChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getPhieuMuon(),
                    entity.getSach(),
                    entity.getNguoiXuLy(),
                    entity.getNgayTra(),
                    entity.isTrangThai()
            );
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_BY_SACH_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public PhieuMuonChiTiet selectByID(Long id) {
        List<PhieuMuonChiTiet> list = this.selectBySql(this.SELECT_BY_SACH_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PhieuMuonChiTiet> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<PhieuMuonChiTiet> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PhieuMuonChiTiet> selectALL(Long phieuMuon) {
        return this.selectBySql(this.SELECT_ALL_SQL, phieuMuon);
    }

    @Override
    protected List<PhieuMuonChiTiet> selectBySql(String sql, Object... args) {
        List<PhieuMuonChiTiet> list = new java.util.ArrayList();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                PhieuMuonChiTiet pmct = new PhieuMuonChiTiet();
                pmct.setPhieuMuon(rs.getLong("PhieuMuon"));
                pmct.setSach(rs.getLong("Sach"));
                pmct.setNguoiXuLy(rs.getNString("NguoiTiepNhan"));
                pmct.setNgayTra(rs.getDate("NgayTra"));
                pmct.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(pmct);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonChiTietDao.class.getName()).log(Level.SEVERE, "Phieu MuonChiTietDao", ex);
        }
        return list;
    }

}
