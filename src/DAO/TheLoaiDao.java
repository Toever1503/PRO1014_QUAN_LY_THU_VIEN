/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TheLoai;
import java.math.BigInteger;
import java.util.List;
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
public class TheLoaiDao extends DAO<TheLoai, BigInteger> {

    private final String SELECT_ALL_BY_PAGE_SQL = "SELECT `ID`, `TenTheLoai` FROM `the_loai` LIMIT ?, 30";
    private final String SELECT_BY_ID_SQL = "SELECT `ID`, `TenTheLoai` FROM `the_loai` WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO `the_loai` (`ID`, `TenTheLoai`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTheLoai=VALUES(TenTheLoai)";
    private final String DELETE_SQL = "DELETE FROM `the_loai` WHERE ID = ?";

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
    public int save(TheLoai entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getTenTheLoai());
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Insert TheLoai Failed", ex);
        }
        return row;
    }

    @Override
    public int delete(BigInteger id) {
        int row = 0;
        try {
            row = Helper.Utility.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Delete TheLoai Failed", ex);
        }
        return row;
    }

    @Override
    public TheLoai selectByID(BigInteger id) {
        List<TheLoai> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list == null ? null : list.get(0);
    }

    @Override
    public List<TheLoai> selectAllByPage(int page) {
        List<TheLoai> list = this.selectBySql(SELECT_ALL_BY_PAGE_SQL, page*30);
        return list == null ? null : list;
    }

    @Override
    protected List<TheLoai> selectBySql(String sql, Object... args) {
        List<TheLoai> list = new ArrayList<TheLoai>();

        try {
            ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                list.add(new TheLoai(
                        rs.getObject("ID", BigInteger.class),
                        rs.getNString("TenTheLoai")));
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, "Select TheLoai Failed", ex);
        }
        return list.size() == 0 ? null : list;
    }
    

}
