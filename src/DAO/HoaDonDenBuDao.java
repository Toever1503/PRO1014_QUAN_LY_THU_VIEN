/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.HoaDonDenBu;
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
public class HoaDonDenBuDao extends LibrarianDAO<HoaDonDenBu, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE FROM hoa_don_den_bu_sach";
    private final String SELECT_BY_ID_SQL = "SELECT ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE FROM hoa_don_den_bu_sach WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO hoa_don_den_bu_sach(ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE) VALUES (?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE hoa_don_den_bu_sach SET HoiVien=?,MaQL=?,TongTien=?,NgayTao=?,QR_FILE=? WHERE ID= ?";
    private final String DELETE_SQL = "DELETE FROM hoa_don_den_bu_sach WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO hoa_don_den_bu_sach (ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE) VALUES (?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE HoiVien=VALUES(HoiVien), MaQL=VALUES(MaQL), TongTien=VALUES(TongTien), NgayTao=VALUES(NgayTao),QR_FILE=VALUES(QR_FILE);";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE FROM hoa_don_den_bu_sach LIMIT ?, 30";

    HoaDonDenBuChiTietDao hoaDonDenBuChiTietDao;
    private static HoaDonDenBuDao instance;

    private HoaDonDenBuDao() {
        hoaDonDenBuChiTietDao = HoaDonDenBuChiTietDao.getInstance();
    }

    public static HoaDonDenBuDao getInstance() {
        if (instance == null) {
            instance = new HoaDonDenBuDao();
        }
        return instance;
    }

    @Override
    public int insert(HoaDonDenBu entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getTongTien(),
                    entity.getNgayTao(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(HoaDonDenBu entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getTongTien(),
                    entity.getNgayTao(),
                    entity.getQr_code(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(HoaDonDenBu entity) {
        int row = 0;
        PreparedStatement ps = null;
        try {
            String sql = this.INSERT_ON_UPDATE_SQL;
            if (entity.getId() == null) {
                sql += " SELECT LAST_INSERT_ID() as ID;";
            } else {

            }
            ps = Helper.Utility.getStm(sql,
                    entity.getId(),
                    entity.getNguoiMuon(),
                    entity.getNguoiXuLy(),
                    entity.getTongTien(),
                    entity.getNgayTao(),
                    entity.getQr_code());
            if (entity.getId() == null) {
                ps.execute();
                ResultSet rs = ps.getResultSet();
                rs.next();
                Long id = rs.getLong("ID");
                entity.setId(id);
                row = id.intValue();
            } else {
                row = ps.executeUpdate();
            }
            hoaDonDenBuChiTietDao.delete(entity.getId());
            entity.getListhBuChiTiets().forEach((hdct) -> {
                hdct.setHoaDonDenBu(entity.getId());
                hoaDonDenBuChiTietDao.insertOnUpdate(hdct);
            });

        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public HoaDonDenBu selectByID(Long id) {
        List<HoaDonDenBu> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonDenBu> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<HoaDonDenBu> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    public int getTotal() {
        int total = 0;
        try {
            java.sql.ResultSet rs = Helper.Utility.query("SELECT COUNT(ID)/30 as total FROM hoa_don_den_bu_sach");
            while (rs.next()) {
                total = (int) rs.getDouble("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    protected List<HoaDonDenBu> selectBySql(String sql, Object... args) {
        List<HoaDonDenBu> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                HoaDonDenBu hddb = new HoaDonDenBu();
                hddb.setId(rs.getLong("ID"));
                hddb.setNguoiMuon(rs.getLong("HoiVien"));
                hddb.setNguoiXuLy(rs.getString("MaQL"));
                hddb.setTongTien(rs.getDouble("TongTien"));
                hddb.setNgayTao(rs.getDate("NgayTao"));
                hddb.setQr_code(rs.getNString("QR_FILE"));
                hddb.setListhBuChiTiets(hoaDonDenBuChiTietDao.selectALLByHoaDonDenBu(hddb.getId()));
                list.add(hddb);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
