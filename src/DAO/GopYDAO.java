/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.DeXuat;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author haunv
 */
public class GopYDAO extends DAO<DeXuat, BigInteger>{
    private final String SELECT_ALL_BY_PAGE_SQL = "";
    private final String SELECT_BY_ID_SQL = "";
    private final String INSERT_ON_UPDATE_SQL = "";
    private final String DELETE_SQL = "";
    
    private static GopYDAO instance;
    
    @Override
    public int save(DeXuat entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int delete(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DeXuat selectByID(BigInteger id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DeXuat> selectAllByPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<DeXuat> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
