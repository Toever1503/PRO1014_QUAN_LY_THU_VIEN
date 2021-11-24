/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuMuonChiTiet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author haunv
 */
public class PhieuMuonChiTietDao extends DAO<PhieuMuonChiTiet, BigInteger> {

    private final String SELECT_ALL_BY_PAGE_SQL = "SELECT `PhieuMuon`, `Sach`, `NguoiTiepNhan`, `NgayTra`, `TrangThai` FROM `phieu_muon_chi_tiet` LIMIT ?, 30";
    private final String SELECT_BY_ID_SQL = "SELECT `PhieuMuon`, `Sach`, `NguoiTiepNhan`, `NgayTra`, `TrangThai` FROM `phieu_muon_chi_tiet` WHERE PhieuMuon = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO `phieu_muon_chi_tiet` (`PhieuMuon`, `Sach`, `NguoiTiepNhan`, `NgayTra`, `TrangThai`) VALUES (?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE NguoiTiepNhan=VALUES(NguoiTiepNhan), NgayTra=VALUES(NgayTra), TrangThai=VALUES(TrangThai)";
    private final String DELETE_SQL = "DELETE FROM `phieu_muon_chi_tiet` WHERE PhieuMuon = ? AND Sach = ?";

    private static PhieuMuonChiTietDao instance;

    private PhieuMuonChiTietDao() {
    }

    public static PhieuMuonChiTietDao getInstance() {
        if (instance == null) {
            instance = new PhieuMuonChiTietDao();
        }

        return instance;
    }

    @Override
    public int save(PhieuMuonChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(INSERT_ON_UPDATE_SQL,
                    entity.getPhieuMuon(),
                    entity.getSach(),
                    entity.getNguoiXuLy(),
                    entity.getNgayTra(),
                    entity.isTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Insert PhieuMuonChiTiet Failed", ex);
        }
        return row;
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(BigInteger phieuMuon, BigInteger Sach) {
        int row = 0;
        try {
            row = Helper.Utility.update(DELETE_SQL, phieuMuon, Sach);

        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public PhieuMuonChiTiet selectByID(BigInteger id) {
        List<PhieuMuonChiTiet> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list == null ? null : list.get(0);
    }

    @Override
    public List<PhieuMuonChiTiet> selectAllByPage(int page) {
        List<PhieuMuonChiTiet> list = this.selectBySql(SELECT_ALL_BY_PAGE_SQL, page);
        return list == null ? null : list;
    }

    @Override
    protected List<PhieuMuonChiTiet> selectBySql(String sql, Object... args) {
        List<PhieuMuonChiTiet> list = new ArrayList<PhieuMuonChiTiet>();

        try {
            ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                list.add(new PhieuMuonChiTiet(
                        rs.getObject("PhieuMuon", BigInteger.class),
                        rs.getObject("Sach", BigInteger.class),
                        rs.getNString("NguoiTiepNhan"),
                        rs.getObject("NgayTra", Date.class),
                        rs.getObject("TrangThai", Boolean.class)));
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size() == 0 ? null : list;
    }

}
