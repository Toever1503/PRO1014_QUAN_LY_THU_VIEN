/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoTest;

import DAO.*;
import Models.TacGia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author haunv
 */
public class TacGiaDao {

    private final String SELECT_ALL_SQL = "SELECT ID, TenTacGia FROM tac_gia";
    private final String SELECT_BY_ID_SQL = this.SELECT_ALL_SQL + " WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO tac_gia(TenTacGia) VALUES (?)";
    private final String UPDATE_SQL = "UPDATE tac_gia SET TenTacGia = ? WHERE ID = ?";
    private final String DELETE_SQL = "DELETE * FROM tac_gia WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO tac_gia (ID, TenTacGia) VALUES (?, ?) ON DUPLICATE KEY UPDATE TenTacGia = VALUES(TenTacGia)";
    private final String SELECT_BY_PAGE_SQL = this.SELECT_ALL_SQL + " LIMIT ?, 30";
    private final String SELECT_BY_KEY_SQL = this.SELECT_ALL_SQL + " WHERE TenTacGia = ?";
    private static TacGiaDao instance;

    public TacGiaDao() {
    }

    public static TacGiaDao getInstance() {
        if (instance == null) {
            instance = new TacGiaDao();
        }
        return instance;
    }

    public int insert(TacGia entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.INSERT_SQL, entity.getTenTacGia());
        return row;
    }

    public int update(TacGia entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.UPDATE_SQL,
                entity.getTenTacGia(),
                entity.getId());
        return row;
    }

    public int insertOnUpdate(TacGia entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                entity.getId(),
                entity.getTenTacGia());
        return row;
    }

    public int delete(Long id) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.DELETE_SQL, id);
        return row;
    }

    public TacGia selectByID(Long id) throws Exception {
        List<TacGia> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<TacGia> selectByPage(Long id) throws Exception {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    public List<TacGia> selectALL() throws Exception {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    protected List<TacGia> selectBySql(String sql, Object... args) throws Exception {
        List<TacGia> list = new java.util.ArrayList<>();
        java.sql.ResultSet rs = Helper.Utility.query(sql, args);
        while (rs.next()) {
            TacGia tg = new TacGia();
            tg.setId(rs.getLong("ID"));
            tg.setTenTacGia(rs.getString("TenTacGia"));
            list.add(tg);
        }
        rs.getStatement().getConnection().close();
        return list;
    }

}
