/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuMuon;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author haunv
 */
public class PhieuMuonDao extends LibrarianDAO<PhieuMuon, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE From phieu_muon";
    private final String SELECT_BY_ID_SQL = SELECT_ALL_SQL + " WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO phieu_muon(ID, HoiVien, MaQL, NgayMuon, NgayHan, QR_FILE) VALUES (?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE phieu_muon SET HoiVien=?,MaQL=?,NgayMuon=?,NgayHan=?,QR_FILE=? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM phieu_muon WHERE ID =?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO phieu_muon(\n"
            + "    ID,\n"
            + "    HoiVien,\n"
            + "    MaQL,\n"
            + "    NgayMuon,\n"
            + "    NgayHan,\n"
            + "    QR_FILE\n"
            + ")\n"
            + "VALUES(?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY\n"
            + "UPDATE\n"
            + "    HoiVien =\n"
            + "VALUES(HoiVien), MaQL =\n"
            + "VALUES(MaQL), NgayMuon =\n"
            + "VALUES(NgayMuon), NgayHan =\n"
            + "VALUES(NgayHan), QR_FILE =\n"
            + "VALUES(QR_FILE)";
    private final String SELECT_BY_PAGE_SQL = SELECT_ALL_SQL + " ORDER BY NgayMuon DESC LIMIT ?, 30";
    private final String SELECT_ALL_BY_KEY = SELECT_ALL_SQL + " WHERE pm.ID LIKE ? OR hv.HoTen LIKE ? OR pm.MaQL LIKE ?";

    private PhieuMuonChiTietDao phieuMuonChiTietDao;
    private static PhieuMuonDao instance;

    private PhieuMuonDao() {
        phieuMuonChiTietDao = PhieuMuonChiTietDao.getInstance();
    }

    public static PhieuMuonDao getInstance() {
        if (instance == null) {
            instance = new PhieuMuonDao();
        }
        return instance;
    }

    @Override
    public int insert(PhieuMuon entity) {
        int row = 0;
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
        PreparedStatement ps = null;
        try {
            row = 0;

            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getNgayMuon(),
                    entity.getHanTra(),
                    entity.getQr_code());

            if (row > 0) {
                new Thread() {
                    @Override
                    public void run() {
                        phieuMuonChiTietDao.delete(entity.getId());
                    }
                }.start();
                if (entity.getId() == null) {
                    ResultSet rs = Helper.Utility.query("SELECT ID FROM phieu_muon\n"
                            + "ORDER BY ID DESC\n"
                            + "LIMIT 0,?", 1);
                    rs.next();
                    Long id = rs.getLong("ID");
                    entity.setId(id);
                    row = id.intValue();
                }
                phieuMuonChiTietDao.delete(entity.getId());
                entity.getListPhieuMuonChiTiets().forEach((pmct) -> {
                    pmct.setPhieuMuon(entity.getId());
                    phieuMuonChiTietDao.insertOnUpdate(pmct);
                });
            }

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
//                pm.setListPhieuMuonChiTiets(phieuMuonChiTietDao.selectALL(rs.getLong("ID")));
                list.add(pm);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<PhieuMuon> selectALLByKey(String input) {
        return this.selectBySql(this.SELECT_ALL_BY_KEY, input, input, input);
    }

    public int getTotalPage() {
        int total = 0;
        try {
            java.sql.ResultSet rs = Helper.Utility.query("SELECT COUNT(ID)/30 as total FROM phieu_muon");
            while (rs.next()) {
                total = (int) rs.getDouble("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
