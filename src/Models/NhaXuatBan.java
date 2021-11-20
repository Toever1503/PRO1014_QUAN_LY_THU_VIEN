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
public class NhaXuatBan {
    private BigInteger id;
    private String tenNhaXuatBan;

    public NhaXuatBan(BigInteger id, String tenNhaXuatBan) {
        this.id = id;
        this.tenNhaXuatBan = tenNhaXuatBan;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        this.tenNhaXuatBan = tenNhaXuatBan;
    }
    
}
