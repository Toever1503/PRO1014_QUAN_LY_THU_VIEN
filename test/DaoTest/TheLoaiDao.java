/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoTest;

import DAO.*;
import Models.TheLoai;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class TheLoaiDao {

    private final String SELECT_ALL_SQL = "SELECT ID, TenTheLoai FROM the_loai";
    private final String SELECT_BY_ID_SQL = this.SELECT_ALL_SQL + " WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO the_loai(ID, TenTheLoai) VALUES (?,?);";
    private final String UPDATE_SQL = "UPDATE the_loai SET TenTheLoai = ?, WHERE ID = ?";
    private final String DELETE_SQL = "DELETE FROM the_loai WHERE ID =?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO the_loai (ID, TenTheLoai) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTheLoai = VALUES(TenTheLoai)";
    private final String SELECT_BY_PAGE_SQL = this.SELECT_ALL_SQL + " LIMIT ?, 30";
    private final String SELECT_BY_KEY_SQL = this.SELECT_ALL_SQL + " WHERE TenTheLoai = ?";
    private static TheLoaiDao instance;

    private TheLoaiDao() {
    }

    public static TheLoaiDao getInstance() {
        if (instance == null) {
            instance = new TheLoaiDao();
        }
        return instance;
    }

    public int insert(TheLoai entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.INSERT_SQL, entity.getTenTheLoai());
        return row;
    }

    public int update(TheLoai entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.UPDATE_SQL,
                entity.getTenTheLoai(),
                entity.getId());
        return row;
    }

    public int insertOnUpdate(TheLoai entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                entity.getId(),
                entity.getTenTheLoai());
        return row;
    }

    public int delete(Long id) throws Exception {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public TheLoai selectByID(Long id) throws Exception {
        List<TheLoai> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<TheLoai> selectByPage(Long id) throws Exception {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    public List<TheLoai> selectByKeyWorld(String keyWorld) throws Exception {
        return this.selectBySql(this.SELECT_BY_KEY_SQL, keyWorld);
    }

    public List<TheLoai> selectALL() throws Exception {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    protected List<TheLoai> selectBySql(String sql, Object... args) throws Exception {
        List<TheLoai> list = new java.util.ArrayList<>();
        java.sql.ResultSet rs = Helper.Utility.query(sql, args);
        while (rs.next()) {
            TheLoai tl = new TheLoai();
            tl.setId(rs.getLong("ID"));
            tl.setTenTheLoai(rs.getString("TenTheLoai"));
            list.add(tl);
        }
        rs.getStatement().getConnection().close();
        return list.size() == 0 ? null : list;
    }

}
