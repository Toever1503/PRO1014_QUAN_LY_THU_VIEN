/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TacGia;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author haunv
 */
public class TacGiaDao extends LibrarianDAO<TacGia, BigInteger> {

    private String sqlGetByID = "SELECT * FROM tac_gia WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `tac_gia` (`ID`, `TenTacGia`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTacGia=VALUES(TenTacGia)";
    private String sqlGetAll = "SELECT * FROM tac_gia";
    private String sqlGetByPage = "SELECT * FROM tac_gia LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM tac_gia WHERE ID = ?";

    @Override
    public int insert(TacGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(TacGia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TacGia selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TacGia> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<TacGia> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
