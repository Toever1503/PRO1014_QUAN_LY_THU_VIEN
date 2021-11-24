/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.HoaDonDenBu;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class HoaDonDenBuDao extends LibrarianDAO<HoaDonDenBu, BigInteger> {

    private final String SELECT_ALL_SQL = "SELECT ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE FROM hoa_don_den_bu_sach";
    private final String SELECT_BY_ID_SQL = "SELECT ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE FROM hoa_don_den_bu_sach WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO hoa_don_den_bu_sach(ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE) VALUES (?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE hoa_don_den_bu_sach SET HoiVien=?,MaQL=?,TongTien=?,NgayTao=?,QR_FILE=? WHERE ID= ?";
    private final String DELETE_SQL = "DELETE FROM hoa_don_den_bu_sach WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO hoa_don_den_bu_sach (ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE) VALUES (?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE HoiVien=VALUES(HoiVien), MaQL=VALUES(MaQL), TongTien=VALUES(TongTien), NgayTao=VALUES(NgayTao),QR_FILE=VALUES(QR_FILE)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, HoiVien, MaQL, TongTien, NgayTao, QR_FILE FROM hoa_don_den_bu_sach LIMIT ?, 30";

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
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
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
    public int delete(BigInteger id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public HoaDonDenBu selectByID(BigInteger id) {
        List<HoaDonDenBu> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonDenBu> selectByPage(BigInteger id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<HoaDonDenBu> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDonDenBu> selectBySql(String sql, Object... args) {
        List<HoaDonDenBu> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                HoaDonDenBu hddb = new HoaDonDenBu();
                hddb.setId(rs.getObject("ID", BigInteger.class));
                hddb.setNguoiMuon(rs.getObject("HoiVien", BigInteger.class));
                hddb.setNguoiXuLy(rs.getObject("MaQL", BigInteger.class));
                hddb.setTongTien(rs.getFloat("TongTien"));
                hddb.setNgayTao(rs.getDate("NgayTao"));
                hddb.setQr_code("QR_FILE");
                list.add(hddb);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
