/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.HoaDonDenBuChiTiet;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class HoaDonDenBuChiTietDao extends LibrarianDAO<HoaDonDenBuChiTiet, BigInteger> {

    private final String SELECT_ALL_SQL = "SELECT HoaDonDenBu, Sach, GiaSach FROM hoa_don_den_bu_sach_chi_tiet";
    private final String SELECT_BY_ID_SQL = "SELECT HoaDonDenBu, Sach, GiaSach FROM hoa_don_den_bu_sach_chi_tiet WHERE HoaDonDenBu = ? AND Sach = ?";
    private final String INSERT_SQL = "INSERT INTO hoa_don_den_bu_sach_chi_tiet(HoaDonDenBu, Sach, GiaSach) VALUES (?,?,?)";
    private final String UPDATE_SQL = "UPDATE hoa_don_den_bu_sach_chi_tiet SET GiaSach= ? WHERE HoaDonDenBu= ? AND Sach= ?";
    private final String DELETE_SQL = "DELETE FROM hoa_don_den_bu_sach_chi_tiet WHERE HoaDonDenBu= ? AND Sach= ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO hoa_don_den_bu_sach_chi_tiet (HoaDonDenBu, Sach, GiaSach) VALUES (?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE HoaDonDenBu=VALUES(HoaDonDenBu), Sach=VALUES(Sach), GiaSach=VALUES(GiaSach)";
    private final String SELECT_BY_PAGE_SQL = "SELECT HoaDonDenBu, Sach, GiaSach FROM hoa_don_den_bu_sach_chi_tiet LIMIT ?, 30";

    @Override
    public int insert(HoaDonDenBuChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getHoaDonDenBu(),
                    entity.getSach(),
                    entity.getGia());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(HoaDonDenBuChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getGia(),
                    entity.getHoaDonDenBu(),
                    entity.getSach());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(HoaDonDenBuChiTiet entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getHoaDonDenBu(),
                    entity.getSach(),
                    entity.getGia());
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDonDenBuChiTiet selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDonDenBuChiTiet> selectByPage(BigInteger id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<HoaDonDenBuChiTiet> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDonDenBuChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonDenBuChiTiet> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                HoaDonDenBuChiTiet hddbct = new HoaDonDenBuChiTiet();
                hddbct.setHoaDonDenBu(rs.getObject("HoaDonDenBu", BigInteger.class));
                hddbct.setSach(rs.getObject("Sach", BigInteger.class));
                hddbct.setGia(rs.getFloat("GiaSach"));
                list.add(hddbct);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDenBuChiTietDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
