/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuMuon;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author haunv
 */
public class PhieuMuonDao extends DAO<PhieuMuon, BigInteger> {

    private final String SELECT_ALL_BY_PAGE_SQL = "SELECT ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE FROM `phieu_muon` LIMIT ?, 30";
    private final String SELECT_BY_ID_SQL = "SELECT ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE FROM `phieu_muon` WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO `phieu_muon` (`ID`, `HoiVien`, `MaQL`, `NgayMuon`, `NgayHan`, `QR_FILE`) VALUES (?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE HoiVien=VALUES(HoiVien), MaQL=VALUES(MaQL), NgayMuon=VALUES(NgayMuon), NgayHan=VALUES(NgayHan),QR_FILE=VALUES(QR_FILE)";
    private final String DELETE_SQL = "DELETE FROM `phieu_muon` WHERE ID = ?";

    private static PhieuMuonDao instance;

    public static PhieuMuonDao getInstance() {
        if (instance == null) {
            instance = new PhieuMuonDao();
        }
        return instance;
    }

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
        int row = 0;
        try {
            row = Helper.Utility.update(DELETE_SQL, id);

        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public PhieuMuon selectByID(BigInteger id) {
        List<PhieuMuon> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list == null ? null : list.get(0);
    }

    @Override
    public List<PhieuMuon> selectAllByPage(int page) {
        List<PhieuMuon> list = this.selectBySql(SELECT_ALL_BY_PAGE_SQL, page * 30);
        return list == null ? null : list;
    }

    @Override
    protected List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<PhieuMuon>();

        try {
            ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                list.add(new PhieuMuon(
                        rs.getObject("ID", BigInteger.class),
                        rs.getObject("HoiVien", BigInteger.class),
                        rs.getNString("MaQL"),
                        rs.getObject("NgayMuon", Date.class),
                        rs.getObject("NgayHan", Date.class),
                        rs.getNString("QR_FILE")));
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size() == 0 ? null : list;
    }

}
