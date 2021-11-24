/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Sach;
import java.util.List;

/**
 *
 * @author NguyenHoan
 */
public class SachDAO extends LibrarianDAO<Sach, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, TenTheLoai FROM the_loai";
    private final String SELECT_BY_ID_SQL = "SELECT ID, TenTheLoai FROM the_loai WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO the_loai(ID, TenTheLoai) VALUES (?,?);";
    private final String UPDATE_SQL = "UPDATE the_loai SET TenTheLoai = ?, WHERE ID = ?";
    private final String DELETE_SQL = "DELETE FROM the_loai WHERE ID =?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO the_loai (ID, TenTheLoai) VALUES (?, ?)\n"
            + "ON DUPLICATE KEY UPDATE TenTheLoai = VALUES(TenTheLoai)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, TenTheLoai FROM the_loai LIMIT ?, 30";

    @Override
    public int insert(Sach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Sach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertOnUpdate(Sach entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sach selectByID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sach> selectByPage(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sach> selectALL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
