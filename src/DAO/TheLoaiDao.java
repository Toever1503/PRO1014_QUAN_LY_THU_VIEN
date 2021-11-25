/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TheLoai;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class TheLoaiDao extends LibrarianDAO<TheLoai, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, TenTheLoai FROM the_loai";
    private final String SELECT_BY_ID_SQL = "SELECT ID, TenTheLoai FROM the_loai WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO the_loai(ID, TenTheLoai) VALUES (?,?);";
    private final String UPDATE_SQL = "UPDATE the_loai SET TenTheLoai = ?, WHERE ID = ?";
    private final String DELETE_SQL = "DELETE FROM the_loai WHERE ID =?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO the_loai (ID, TenTheLoai) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTheLoai = VALUES(TenTheLoai)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, TenTheLoai FROM the_loai LIMIT ?, 30";
    private static TheLoaiDao instance;

    private TheLoaiDao() {
    }

    public static TheLoaiDao getInstance() {
        if (instance == null) {
            instance = new TheLoaiDao();
        }
        return instance;
    }

    @Override
    public int insert(TheLoai entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getTenTheLoai());
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(TheLoai entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getTenTheLoai(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(TheLoai entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getTenTheLoai());
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public TheLoai selectByID(Long id) {
        List<TheLoai> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TheLoai> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<TheLoai> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<TheLoai> selectBySql(String sql, Object... args) {
        List<TheLoai> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setId(rs.getLong("ID"));
                tl.setTenTheLoai(rs.getString("TenTheLoai"));
                list.add(tl);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size() == 0 ? null : list;
    }

}
