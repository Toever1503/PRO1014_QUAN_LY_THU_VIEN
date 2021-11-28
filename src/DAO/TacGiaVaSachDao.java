/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TacGiaVaSach;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author haunv
 */
public class TacGiaVaSachDao extends LibrarianDAO<TacGiaVaSach, Long> {

    private final String SELECT_ALL_SQL = "SELECT Sach, TacGia FROM tac_gia_va_sach";
    private final String SELECT_ALL_BY_SACH = SELECT_ALL_SQL + " WHERE Sach = ?";
    private final String DELETE_SQL = "DELETE FROM `tac_gia_va_sach` WHERE Sach = ?";
    private final String INSERT_SQL = "INSERT INTO tac_gia_va_sach (Sach, TacGia) VALUES (?, ?)";
    private final String UPDATE_SQL = "";
    private static TacGiaVaSachDao instance;

    public static TacGiaVaSachDao getInstacne() {
        if (instance == null) {
            instance = new TacGiaVaSachDao();
        }
        return instance;
    }

    @Override
    public int insert(TacGiaVaSach entity) {
        System.out.println("tacgiavasach: "+entity);
        int row = 0;
        try {
            row = Helper.Utility.update(INSERT_SQL, entity.getSach(), entity.getTacGia());
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiVaSachDao.class.getName()).log(Level.SEVERE, "tacgia va sach loi", ex);
        }

        return row;
    }

    @Override
    public int update(TacGiaVaSach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertOnUpdate(TacGiaVaSach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            System.out.println("id sach =>" + id);
            row = Helper.Utility.update(DELETE_SQL, id);
            
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiVaSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("delete tacgia");
        return row;
    }

    @Override
    public TacGiaVaSach selectByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TacGiaVaSach> selectByPage(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TacGiaVaSach> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TacGiaVaSach> selectALLBySach(Long sach) {
        return selectBySql(SELECT_ALL_BY_SACH, sach);
    }

    @Override
    protected List<TacGiaVaSach> selectBySql(String sql, Object... args) {
        List<TacGiaVaSach> list = new ArrayList<TacGiaVaSach>();
        try {
            ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                list.add(new TacGiaVaSach(rs.getLong("Sach"), rs.getLong("TacGia")));
            }
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiVaSachDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list.size() == 0 ? null : list;
    }

}
