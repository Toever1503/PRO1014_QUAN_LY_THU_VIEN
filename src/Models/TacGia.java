/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;

/**
 *
 * @author haunv
 */
public class TacGia {
    private BigInteger id;
    private String tenTacGia;

    public TacGia(BigInteger id, String tenTacGia) {
        this.id = id;
        this.tenTacGia = tenTacGia;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
}
