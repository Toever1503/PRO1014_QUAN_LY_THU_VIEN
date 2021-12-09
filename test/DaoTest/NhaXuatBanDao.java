/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoTest;

import DAO.*;
import Models.NhaXuatBan;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class NhaXuatBanDao {

    private final String SELECT_ALL_SQL = "SELECT ID, TenNhaXuatBan FROM nha_xuat_ban";
    private final String SELECT_BY_ID_SQL = this.SELECT_ALL_SQL + " WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO nha_xuat_ban(TenNhaXuatBan) VALUES (?)";
    private final String UPDATE_SQL = "UPDATE nha_xuat_ban SET TenNhaXuatBan= ? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM nha_xuat_ban WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO nha_xuat_ban (ID, TenNhaXuatBan) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenNhaXuatBan=VALUES(TenNhaXuatBan)";
    private final String SELECT_BY_PAGE_SQL = "SELECT TenNhaXuatBan, ID FROM nha_xuat_ban LIMIT ?, 30";
    private final String SELECT_BY_KEY_SQL = this.SELECT_ALL_SQL + " WHERE TenNhaXuatBan = ?";
    private static NhaXuatBanDao instance;

    private NhaXuatBanDao() {
    }

    public static NhaXuatBanDao getInstance() {
        if (instance == null) {
            instance = new NhaXuatBanDao();
        }
        return instance;
    }

    public int insert(NhaXuatBan entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.INSERT_SQL, entity.getTenNhaXuatBan());
        return row;
    }

    public int update(NhaXuatBan entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.UPDATE_SQL,
                entity.getTenNhaXuatBan(),
                entity.getId());
        return row;
    }

    public int insertOnUpdate(NhaXuatBan entity) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                entity.getId(),
                entity.getTenNhaXuatBan());
        return row;
    }

    public int delete(Long id) throws Exception {
        int row = 0;
        row = Helper.Utility.update(this.DELETE_SQL, id);
        return row;
    }

    public NhaXuatBan selectByID(Long id) throws Exception {
        List<NhaXuatBan> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<NhaXuatBan> selectByPage(Long id) throws Exception {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    public List<NhaXuatBan> selectALL() throws Exception {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    public List<NhaXuatBan> selectByKeyWorld(String keyWorld) throws Exception {
        return this.selectBySql(this.SELECT_BY_KEY_SQL, keyWorld);
    }

    protected List<NhaXuatBan> selectBySql(String sql, Object... args) throws Exception {
        List<NhaXuatBan> list = new java.util.ArrayList<>();
        java.sql.ResultSet rs = Helper.Utility.query(sql, args);
        while (rs.next()) {
            NhaXuatBan nxb = new NhaXuatBan();
            nxb.setId(rs.getLong("ID"));
            nxb.setTenNhaXuatBan(rs.getString("TenNhaXuatBan"));
            list.add(nxb);
        }
        rs.getStatement().getConnection().close();
        return list;
    }

    public static void main(String[] args) {
    }
}
