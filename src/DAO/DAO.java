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
public interface DAO<T, ID> {
    public T getById(ID id);
    public List<T> getALL();
    public int save(T obj);
    public int deleteById(ID id);
    public List<T> getListByPage(ID page);
}
