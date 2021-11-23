<<<<<<< Updated upstream:src/DAO/DeXuatDao.java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.DeXuat;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author haunv
 */
public class DeXuatDao implements DAO<DeXuat, BigInteger>{

    @Override
    public DeXuat getById(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DeXuat> getALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(DeXuat obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteById(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DeXuat> getListByPage(BigInteger page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.GopY;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class GopYDAO extends DAO<GopY, BigInteger> {

    private final String SELECT_ALL_SQL = "SELECT ID, HoiVien, NgayTao, NoiDung, TrangThai FROM gop_y";
    private final String SELECT_BY_ID_SQL = "SELECT ID, HoiVien, NgayTao, NoiDung, TrangThai FROM gop_y WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO gop_y (ID, HoiVien, NgayTao, NoiDung, TrangThai) VALUES (?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE gop_y SET HoiVien = ?, NgayTao = ?, NoiDung = ?, TrangThai = ? WHERE ID = ?";
    private final String DELETE_SQL = "DELETE FROM gop_y WHERE ID = ?";

    @Override
    public int insert(GopY entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getHoiVien(),
                    entity.getNgayTao(),
                    entity.getNoiDung(),
                    entity.isTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(GopY entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getHoiVien(),
                    entity.getNgayTao(),
                    entity.getNoiDung(),
                    entity.isTrangThai(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(BigInteger id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public GopY selectByID(BigInteger id) {
        List<GopY> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GopY> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<GopY> selectBySql(String sql, Object... args) {
        List<GopY> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                GopY gy = new GopY();
                gy.setId(rs.getObject("ID", BigInteger.class));
                gy.setHoiVien(rs.getObject("HoiVien", BigInteger.class));
                gy.setNgayTao(rs.getDate("NgayTao"));
                gy.setNoiDung(rs.getString("NoiDung"));
                gy.setTrangThai(rs.getObject("TrangThai", boolean.class));
                list.add(gy);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
>>>>>>> Stashed changes:src/DAO/GopYDAO.java
