/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.HoiVien;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author haunv
 */
public class HoiVienDao extends LibrarianDAO<HoiVien, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, MaQL, CCCD, HoTen, DiaChi, NgaySinh, SoDienThoai, Email, NgayTao, NgayHan, QR_FILE FROM hoi_vien";
    private final String SELECT_BY_ID_SQL = "SELECT ID, MaQL, CCCD, HoTen, DiaChi, NgaySinh, SoDienThoai, Email, NgayTao, NgayHan, QR_FILE FROM hoi_vien WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO hoi_vien(ID, MaQL, CCCD, HoTen, DiaChi, NgaySinh, SoDienThoai, Email, NgayTao, NgayHan, QR_FILE) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE hoi_vien SET MaQL=?,CCCD=?,HoTen=?,DiaChi=?,NgaySinh=?,SoDienThoai=?,Email=?,NgayTao=?,NgayHan=?,QR_FILE=? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM hoi_vien WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO hoi_vien (ID, MaQL, CCCD, HoTen, DiaChi, NgaySinh, SoDienThoai, Email, NgayTao, NgayHan, QR_FILE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE MaQL=VALUES(MaQL), CCCD=VALUES(CCCD), HoTen=VALUES(HoTen), DiaChi=VALUES(DiaChi), NgaySinh=VALUES(NgaySinh), SoDienThoai=VALUES(SoDienThoai), Email=VALUES(Email), NgayTao=VALUES(NgayTao), NgayHan=VALUES(NgayHan), QR_FILE=VALUES(QR_FILE)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, MaQL, CCCD, HoTen, DiaChi, NgaySinh, SoDienThoai, Email, NgayTao, NgayHan, QR_FILE FROM hoi_vien LIMIT ?, 30";
    private static HoiVienDao insance;

    public static HoiVienDao getInstance() {
        if (insance == null) {
            insance = new HoiVienDao();
        }
        return insance;
    }

    @Override
    public int insert(HoiVien entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getNguoiTao(),
                    entity.getCccd(),
                    entity.getFullName(),
                    entity.getDiaChi(),
                    entity.getNgaySinh(),
                    entity.getSoDienThoai(),
                    entity.getEmail(),
                    entity.getNgayTao(),
                    entity.getNgayHan(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(HoiVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(HoiVien entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getNguoiTao(),
                    entity.getCccd(),
                    entity.getFullName(),
                    entity.getDiaChi(),
                    entity.getNgaySinh(),
                    entity.getSoDienThoai(),
                    entity.getEmail(),
                    entity.getNgayTao(),
                    entity.getNgayHan(),
                    entity.getQr_code(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(HoiVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(HoiVien entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getNguoiTao(),
                    entity.getCccd(),
                    entity.getFullName(),
                    entity.getDiaChi(),
                    entity.getNgaySinh(),
                    entity.getSoDienThoai(),
                    entity.getEmail(),
                    entity.getNgayTao(),
                    entity.getNgayHan(),
                    entity.getQr_code());
            if (row > 0) {
                if (entity.getId() == null) {
                    ResultSet rs = Helper.Utility.query("SELECT ID FROM hoi_vien\n"
                            + "ORDER BY ID DESC\n"
                            + "LIMIT 0,?", 1);
                    rs.next();
                    Long id = rs.getLong("ID");
                    entity.setId(id);
                    row = id.intValue();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HoiVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(HoiVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public HoiVien selectByID(Long id) {
        List<HoiVien> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoiVien> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<HoiVien> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<HoiVien> selectBySql(String sql, Object... args) {
        List<HoiVien> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                HoiVien hv = new HoiVien();
                hv.setId(rs.getLong("ID"));
                hv.setNguoiTao(rs.getString("MaQL"));
                hv.setCccd(rs.getString("CCCD"));
                hv.setFullName(rs.getString("HoTen"));
                hv.setDiaChi(rs.getString("DiaChi"));
                hv.setNgaySinh(rs.getDate("NgaySinh"));
                hv.setSoDienThoai(rs.getString("SoDienThoai"));
                hv.setEmail(rs.getString("Email"));
                hv.setNgayTao(rs.getDate("NgayTao"));
                hv.setNgayHan(rs.getDate("NgayHan"));
                hv.setQr_code(rs.getString("QR_FILE"));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoiVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotal() {
        int total = 0;
        try {
            java.sql.ResultSet rs = Helper.Utility.query("SELECT COUNT(ID)/30 as total FROM hoi_vien");
            while (rs.next()) {
                total = (int) rs.getDouble("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
