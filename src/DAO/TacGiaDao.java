/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TacGia;
import java.math.BigInteger;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class TacGiaDao extends DAO<TacGia, BigInteger> {

    private final String SELECT_ALL_BY_PAGE_SQL = "SELECT `ID`, `TenTacGia` FROM `tac_gia` LIMIT ?, 30";
    private final String SELECT_BY_ID_SQL = "SELECT `ID`, `TenTacGia` FROM `tac_gia` WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO `tac_gia` (`ID`, `TenTacGia`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTacGia=VALUES(TenTacGia)";
    private final String DELETE_SQL = "DELETE FROM `tac_gia` WHERE ID = ?";

    private static TacGiaDao instance;

    private TacGiaDao() {
    }

    public static TacGiaDao getInstance() {
        if (instance == null) {
            instance = new TacGiaDao();
        }
        return instance;
    }

    @Override
    public int save(TacGia entity
    ) {
        int row = 0;
        try {
            row = Helper.Utility.update(INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getTenTacGia());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Insert TacGia Failed", ex);
        }
        return row;
    }

    @Override
    public int delete(BigInteger id
    ) {
        int row = 0;
        try {
            row = Helper.Utility.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Delete TacGia Failed", ex);
        }
        return row;
    }

    @Override
    public TacGia selectByID(BigInteger id
    ) {
        List<TacGia> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list == null ? null : list.get(0);
    }

    @Override
    public List<TacGia> selectAllByPage(int page
    ) {
        List<TacGia> list = this.selectBySql(SELECT_ALL_BY_PAGE_SQL, page);
        return list == null ? null : list;
    }

    @Override
    protected List<TacGia> selectBySql(String sql, Object... args
    ) {
        List<TacGia> list = new ArrayList<TacGia>();

        try {
            ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                list.add(new TacGia(
                        rs.getObject("ID", BigInteger.class),
                        rs.getNString("TenTacGia")));
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Select TacGia Failed", ex);
        }
        return list.size() == 0 ? null : list;
    }
    
}
