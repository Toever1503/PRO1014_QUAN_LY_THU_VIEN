/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.QuanLy;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class QuanLyDao extends DAO<QuanLy, String> {

    private final String SELECT_ALL_BY_PAGE_SQL = "SELECT MaQL,MatKhau,CCCD,HoTen,DiaChi,NgaySinh,SoDienThoai,Email,VaiTro,TrangThai FROM quan_ly";
    private final String SELECT_BY_ID_SQL = "SELECT MaQL,MatKhau,CCCD,HoTen,DiaChi,NgaySinh,SoDienThoai,Email,VaiTro,TrangThai FROM quan_ly WHERE MaQL = ?;";
    private final String INSERT_ON_SAVE_SQL = "INSERT INTO quan_ly (MaQL,MatKhau,CCCD,HoTen,DiaChi,NgaySinh,SoDienThoai,Email,VaiTro,TrangThai) VALUES (?,?,?,?,?,?,?,?,?,?,)";
    private final String DELETE_SQL = "DELETE FROM quan_ly WHERE MaQL = ?";

    private static QuanLyDao instance;

    @Override
    public int save(QuanLy entity) {
        int row = 0;
        try {
            Helper.Utility.update(this.INSERT_ON_SAVE_SQL,
                    entity.getMaQL(),
                    entity.getMatKhau(),
                    entity.getCccd(),
                    entity.getFullName(),
                    entity.getDiaChi(),
                    entity.getNgaySinh(),
                    entity.getSoDienThoai(),
                    entity.getEmail(),
                    entity.getVaiTro(),
                    entity.getTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(String id) {
        int row = 0;
        try {
            Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public QuanLy selectByID(String id) {
        List<QuanLy> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QuanLy> selectAllByPage(int page) {
        return this.selectBySql(this.SELECT_ALL_BY_PAGE_SQL);
    }

    @Override
    protected List<QuanLy> selectBySql(String sql, Object... args) {
        List<QuanLy> list = new ArrayList<QuanLy>();
        try {
            ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                QuanLy ql = new QuanLy();
                ql.setMaQL(rs.getString("MaQL"));
                ql.setMatKhau(rs.getString("MatKhau"));
                ql.setCccd(rs.getString("CCCD"));
                ql.setFullName(rs.getString("HoTen"));
                ql.setDiaChi(rs.getString("DiaChi"));
                ql.setNgaySinh(rs.getDate("NgaySinh"));
                ql.setSoDienThoai(rs.getString("SoDienThoai"));
                ql.setEmail(rs.getString("Email"));
                ql.setVaiTro(rs.getObject("VaiTro", Boolean.class));
                ql.setTrangThai(rs.getObject("TrangThai", Boolean.class));
                list.add(ql);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
