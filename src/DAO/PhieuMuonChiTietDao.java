/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhieuMuonChiTiet;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author haunv
 */
public class PhieuMuonChiTietDao extends DAO<PhieuMuonChiTiet, BigInteger> {

    private final String SELECT_ALL_BY_PAGE_SQL = "";
    private final String SELECT_BY_ID_SQL = "";
    private final String INSERT_ON_UPDATE_SQL = "";
    private final String DELETE_SQL = "";
    
    private static HoaDonDenBuDao instance;

    @Override
    public int save(PhieuMuonChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhieuMuonChiTiet selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhieuMuonChiTiet> selectAllByPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<PhieuMuonChiTiet> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
