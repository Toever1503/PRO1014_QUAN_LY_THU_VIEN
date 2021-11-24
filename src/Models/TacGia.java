/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author haunv
 */
public class TacGia {

    private long id;
    private String tenTacGia;

    public TacGia() {
    }

    public TacGia(long id, String tenTacGia) {
        this.id = id;
        this.tenTacGia = tenTacGia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    @Override
    public String toString() {
        return "TacGia{" + "id=" + id + ", tenTacGia=" + tenTacGia + '}';
    }

}
