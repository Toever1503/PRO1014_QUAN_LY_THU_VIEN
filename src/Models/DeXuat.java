/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;
import java.sql.Date;
/**
 *
 * @author haunv
 */
public class DeXuat {
    private BigInteger id;
    private int luotDeXuat;
    private Date ngayTao;
    private BigInteger quanLy;

    public DeXuat(BigInteger id, int luotDeXuat, Date ngayTao, BigInteger quanLy) {
        this.id = id;
        this.luotDeXuat = luotDeXuat;
        this.ngayTao = ngayTao;
        this.quanLy = quanLy;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getLuotDeXuat() {
        return luotDeXuat;
    }

    public void setLuotDeXuat(int luotDeXuat) {
        this.luotDeXuat = luotDeXuat;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigInteger getQuanLy() {
        return quanLy;
    }

    public void setQuanLy(BigInteger quanLy) {
        this.quanLy = quanLy;
    }

    
}
