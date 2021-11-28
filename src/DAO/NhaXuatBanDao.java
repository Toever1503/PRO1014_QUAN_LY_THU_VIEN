/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhaXuatBan;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class NhaXuatBanDao extends LibrarianDAO<NhaXuatBan, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, TenNhaXuatBan FROM nha_xuat_ban";
    private final String SELECT_BY_ID_SQL = "SELECT ID, TenNhaXuatBan FROM nha_xuat_ban WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO nha_xuat_ban(ID, TenNhaXuatBan) VALUES (?,?)";
    private final String UPDATE_SQL = "UPDATE nha_xuat_ban SET TenNhaXuatBan= ? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM nha_xuat_ban WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO nha_xuat_ban (ID, TenNhaXuatBan) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenNhaXuatBan=VALUES(TenNhaXuatBan)";
    private final String SELECT_BY_PAGE_SQL = "SELECT TenNhaXuatBan, ID FROM nha_xuat_ban LIMIT ?, 30";

    private static NhaXuatBanDao instance;

    private NhaXuatBanDao() {
    }

    public static NhaXuatBanDao getInstance() {
        if (instance == null) {
            instance = new NhaXuatBanDao();
        }
        return instance;
    }

    @Override
    public int insert(NhaXuatBan entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getTenNhaXuatBan());
        } catch (Exception ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(NhaXuatBan entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getTenNhaXuatBan(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(NhaXuatBan entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getTenNhaXuatBan());
        } catch (Exception ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public NhaXuatBan selectByID(Long id) {
        List<NhaXuatBan> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhaXuatBan> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<NhaXuatBan> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<NhaXuatBan> selectBySql(String sql, Object... args) {
        List<NhaXuatBan> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId(rs.getLong("ID"));
                nxb.setTenNhaXuatBan(rs.getString("TenNhaXuatBan"));
                list.add(nxb);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(NhaXuatBanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        NhaXuatBanDao banDao = new NhaXuatBanDao();
        System.out.println(banDao.selectALL());
    }
}
