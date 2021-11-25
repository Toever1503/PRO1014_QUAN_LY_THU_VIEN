/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.HoaDonNhapSach;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class HoaDonNhapSachDao extends LibrarianDAO<HoaDonNhapSach, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, MaQL, TongTien, NgayThem, QR_FILE FROM hoa_don_nhap_sach";
    private final String SELECT_BY_ID_SQL = "SELECT ID, MaQL, TongTien, NgayThem, QR_FILE FROM hoa_don_nhap_sach WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO hoa_don_nhap_sach(ID, MaQL, TongTien, NgayThem, QR_FILE) VALUES (?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE hoa_don_nhap_sach SET MaQL=?,TongTien=?,NgayThem=?,QR_FILE=? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM hoa_don_nhap_sach WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO hoa_don_nhap_sach (ID, MaQL, TongTien, NgayThem, QR_FILE) VALUES (?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE MaQL=VALUES(MaQL), TongTien=VALUES(TongTien), NgayThem=VALUES(NgayThem), QR_FILE=VALUES(QR_FILE)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, MaQL, TongTien, NgayThem, QR_FILE FROM hoa_don_nhap_sach LIMIT ?, 30";

    @Override
    public int insert(HoaDonNhapSach entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getNguoiXuLy(),
                    entity.getTongTien(),
                    entity.getNgayTao(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(HoaDonNhapSach entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getNguoiXuLy(),
                    entity.getTongTien(),
                    entity.getNgayTao(),
                    entity.getQr_code(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(HoaDonNhapSach entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getNguoiXuLy(),
                    entity.getTongTien(),
                    entity.getNgayTao(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public HoaDonNhapSach selectByID(Long id) {
        List<HoaDonNhapSach> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonNhapSach> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<HoaDonNhapSach> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDonNhapSach> selectBySql(String sql, Object... args) {
        List<HoaDonNhapSach> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                HoaDonNhapSach hdns = new HoaDonNhapSach();
                hdns.setId(rs.getLong("ID"));
                hdns.setNguoiXuLy(rs.getString("MaQL"));
                hdns.setTongTien(rs.getFloat("TongTien"));
                hdns.setNgayTao(rs.getDate("NgayThem"));
                hdns.setQr_code(rs.getString("QR_FILE"));
                list.add(hdns);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
