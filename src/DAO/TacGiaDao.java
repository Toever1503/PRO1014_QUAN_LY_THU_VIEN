/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TacGia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class TacGiaDao extends LibrarianDAO<TacGia, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, TenTacGia FROM tac_gia";
    private final String SELECT_BY_ID_SQL = "SELECT ID, TenTacGia FROM tac_gia WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO tac_gia(ID, TenTacGia) VALUES (?,?)";
    private final String UPDATE_SQL = "UPDATE tac_gia SET TenTacGia = ? WHERE ID = ?";
    private final String DELETE_SQL = "DELETE * FROM tac_gia WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO tac_gia (ID, TenTacGia) VALUES (?, ?) ON DUPLICATE KEY UPDATE TenTacGia = VALUES(TenTacGia)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, TenTacGia FROM tac_gia LIMIT ?, 30";

    @Override
    public int insert(TacGia entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getTenTacGia());
        } catch (Exception ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(TacGia entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getTenTacGia(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(TacGia entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getTenTacGia());
        } catch (Exception ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public TacGia selectByID(Long id) {
        List<TacGia> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TacGia> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_ALL_SQL, id);
    }

    @Override
    public List<TacGia> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<TacGia> selectBySql(String sql, Object... args) {
        List<TacGia> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                TacGia tg = new TacGia();
                tg.setId(rs.getLong("ID"));
                tg.setTenTacGia(rs.getString("TenTacGia"));
                list.add(tg);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(TacGiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
