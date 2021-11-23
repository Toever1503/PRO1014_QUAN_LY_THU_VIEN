/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhaXuatBan;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author haunv
 */
public class NhaXuatBanDao extends LibrarianDAO<NhaXuatBan, BigInteger> {

    private String sqlGetByID = "SELECT * FROM nha_xuat_ban WHERE ID =?";
    private String sqlSaveOnUpdate = "INSERT INTO `nha_xuat_ban` (`ID`, `TenNhaXuatBan`) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenNhaXuatBan=VALUES(TenNhaXuatBan)";
    private String sqlGetAll = "SELECT * FROM nha_xuat_ban";
    private String sqlGetByPage = "SELECT * FROM nha_xuat_ban LIMIT ?, 15";
    private String sqlDeleteByID = "DELETE FROM nha_xuat_ban WHERE ID = ?";

    @Override
    public int insert(NhaXuatBan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(NhaXuatBan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NhaXuatBan selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhaXuatBan> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<NhaXuatBan> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
