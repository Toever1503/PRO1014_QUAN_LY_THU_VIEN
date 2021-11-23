/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TheLoai;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author haunv
 */
public class TheLoaiDao extends LibrarianDAO<TheLoai, BigInteger> {

    private String sqlGetByID = "SELECT * FROM the_loai WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `the_loai` (`ID`, `TenTheLoai`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTheLoai=VALUES(TenTheLoai)";
    private String sqlGetAll = "SELECT * FROM the_loai";
    private String sqlGetByPage = "SELECT * FROM the_loai LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM the_loai WHERE ID = ?";

    @Override
    public int insert(TheLoai entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(TheLoai entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TheLoai selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TheLoai> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<TheLoai> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
