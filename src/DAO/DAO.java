/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author haunv
 */
abstract public class DAO<EntityType, KeyType> {

    abstract public int save(EntityType entity);
    
    abstract public int delete(KeyType id);

    abstract public EntityType selectByID(KeyType id);

    abstract public List<EntityType> selectAllByPage(int page);

    abstract protected List<EntityType> selectBySql(String sql, Object... args);
}
