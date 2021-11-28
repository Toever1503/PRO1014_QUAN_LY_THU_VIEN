/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TheLoaiVaSach;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author haunv
 */
public class TheLoaiVaSachDao extends LibrarianDAO<TheLoaiVaSach, Long> {

    private final String SELECT_ALL_SQL = "SELECT Sach, TheLoai FROM the_loai_va_sach";
    private final String SELECT_ALL_BY_SACH = SELECT_ALL_SQL + " WHERE Sach = ?";
    private final String DELETE_SQL = "DELETE FROM the_loai_va_sach WHERE Sach = ?";
    private final String INSERT_SQL = "INSERT INTO the_loai_va_sach (Sach, TheLoai) VALUES (?, ?)";
    private final String UPDATE_SQL = "";
    private static TheLoaiVaSachDao instance;

    public static TheLoaiVaSachDao getInstacne() {
        if (instance == null) {
            instance = new TheLoaiVaSachDao();
        }
        return instance;
    }

    @Override
    public int insert(TheLoaiVaSach entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(INSERT_SQL, entity.getSach(), entity.getTheLoai());
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiVaSachDao.class.getName()).log(Level.SEVERE, "error theloai va sach", ex);
        }

        return row;
    }

    @Override
    public int update(TheLoaiVaSach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertOnUpdate(TheLoaiVaSach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        System.out.println("id sach =>" + id);
        try {
            row = Helper.Utility.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiVaSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public TheLoaiVaSach selectByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TheLoaiVaSach> selectByPage(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TheLoaiVaSach> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TheLoaiVaSach> selectALLBySach(Long sach) {
        return selectBySql(SELECT_ALL_BY_SACH, sach);
    }

    @Override
    protected List<TheLoaiVaSach> selectBySql(String sql, Object... args) {
        List<TheLoaiVaSach> list = new ArrayList<>();
        try {
            ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                list.add(new TheLoaiVaSach(rs.getLong("Sach"), rs.getLong("TheLoai")));
            }
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiVaSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list.size() == 0 ? null : list;
    }

}
