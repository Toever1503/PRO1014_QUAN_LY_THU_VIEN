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
public class TheLoai {
    private BigInteger id;
    private String tenTheLoai;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoai(BigInteger id, String tenTheLoai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
    }
    
}
