/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.HoaDonNhapSachChiTiet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class HoaDonNhapSachChiTietDao extends LibrarianDAO<HoaDonNhapSachChiTiet, Long> {

    private final String SELECT_ALL_SQL = "SELECT HD_Sach, Sach, GiaSach, SoLuong, LoaiSach FROM hoa_don_nhap_sach_chi_tiet";
    private final String SELECT_BY_SACH_SQL = "SELECT HD_Sach, Sach, GiaSach, SoLuong, LoaiSach FROM hoa_don_nhap_sach_chi_tiet WHERE Sach = ?";
    private final String INSERT_SQL = "INSERT INTO hoa_don_nhap_sach_chi_tiet(HD_Sach, Sach, GiaSach, SoLuong, LoaiSach) VALUES (?,?,?,?,?)";
    private final String UPDATE_BY_HD_AND_SACH_SQL = "UPDATE hoa_don_nhap_sach_chi_tiet SET GiaSach=?,SoLuong=?,LoaiSach=?  WHERE HD_Sach=? AND Sach=?";
    private final String DELETE_BY_SACH_SQL = "DELETE FROM hoa_don_nhap_sach_chi_tiet WHERE Sach = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO hoa_don_nhap_sach_chi_tiet (HD_Sach, Sach, GiaSach, SoLuong, LoaiSach) VALUES (?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE GiaSach=VALUES(GiaSach), SoLuong=VALUES(SoLuong), LoaiSach=VALUES(LoaiSach)";
    private final String SELECT_BY_PAGE_SQL = "SELECT HD_Sach, Sach, GiaSach, SoLuong, LoaiSach FROM hoa_don_nhap_sach_chi_tiet LIMIT ?, 30";
    private final String SELECT_BY_SACH ="SELECT HD_Sach, Sach, GiaSach, SoLuong, LoaiSach FROM hoa_don_nhap_sach_chi_tiet WHERE Sach = ? LIMIT 1, 1";

    private SachDAO sachDAO;
    private static HoaDonNhapSachChiTietDao instance;

    private HoaDonNhapSachChiTietDao() {
        sachDAO = SachDAO.getInstance();
    }

    public static HoaDonNhapSachChiTietDao getInstance() {
        if (instance == null) {
            instance = new HoaDonNhapSachChiTietDao();
        }
        return instance;
    }

    @Override
    public int insert(HoaDonNhapSachChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getHoaDonNhap(),
                    entity.getSach(),
                    entity.getGia(),
                    entity.getSoLuong(),
                    entity.getLoaiSach());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(HoaDonNhapSachChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_BY_HD_AND_SACH_SQL,
                    entity.getGia(),
                    entity.getSoLuong(),
                    entity.getLoaiSach(),
                    entity.getHoaDonNhap(),
                    entity.getSach());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(HoaDonNhapSachChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getHoaDonNhap(),
                    entity.getSach(),
                    entity.getGia(),
                    entity.getSoLuong(),
                    entity.getLoaiSach());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_BY_SACH_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public HoaDonNhapSachChiTiet selectByID(Long id) {
        List<HoaDonNhapSachChiTiet> list = this.selectBySql(this.SELECT_BY_SACH_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonNhapSachChiTiet> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<HoaDonNhapSachChiTiet> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    public HoaDonNhapSachChiTiet selectBySach(Long sach) {
        List<HoaDonNhapSachChiTiet> list = this.selectBySql(this.SELECT_BY_SACH, sach);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDonNhapSachChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonNhapSachChiTiet> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                HoaDonNhapSachChiTiet hdnsct = new HoaDonNhapSachChiTiet();
                hdnsct.setHoaDonNhap(rs.getLong("HD_Sach"));
                hdnsct.setSach(rs.getLong("Sach"));
                hdnsct.setGia(rs.getFloat("GiaSach"));
                hdnsct.setSoLuong(rs.getInt("SoLuong"));
                hdnsct.setLoaiSach(rs.getBoolean("LoaiSach"));
                list.add(hdnsct);
            }
            rs.getStatement().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonNhapSachChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//      public static void main(String[] args) {
//          System.out.println(HoaDonNhapSachChiTietDao.getInstance().selectALL());
//    }
}
