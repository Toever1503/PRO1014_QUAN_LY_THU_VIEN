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
abstract public class LibrarianDAO<EntityType, KeyType> {

    abstract public int insert(EntityType entity);

    abstract public int update(EntityType entity);

    abstract public int insertOnUpdate(EntityType entity);

    abstract public int delete(KeyType id);

    abstract public EntityType selectByID(KeyType id);

    abstract public List<EntityType> selectByPage(KeyType id);

    abstract public List<EntityType> selectALL();

    abstract protected List<EntityType> selectBySql(String sql, Object... args);
}
