/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author haunv
 */
public class NhaXuatBan {

    private long id;
    private String tenNhaXuatBan;

    public NhaXuatBan() {
    }

    public NhaXuatBan(Long id) {
        this.id = id;
    }
    

    public NhaXuatBan(long id, String tenNhaXuatBan) {
        this.id = id;
        this.tenNhaXuatBan = tenNhaXuatBan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        this.tenNhaXuatBan = tenNhaXuatBan;
    }

    @Override
    public String toString() {
        return "NhaXuatBan{" + "id=" + id + ", tenNhaXuatBan=" + tenNhaXuatBan + '}';
    }

}
