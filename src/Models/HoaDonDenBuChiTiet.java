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
public class HoaDonDenBuChiTiet {
    private BigInteger hoaDonDenBu;
    private BigInteger sach;
    private BigInteger gia;

    public HoaDonDenBuChiTiet(BigInteger hoaDonDenBu, BigInteger sach, BigInteger gia) {
        this.hoaDonDenBu = hoaDonDenBu;
        this.sach = sach;
        this.gia = gia;
    }

    public BigInteger getHoaDonDenBu() {
        return hoaDonDenBu;
    }

    public void setHoaDonDenBu(BigInteger hoaDonDenBu) {
        this.hoaDonDenBu = hoaDonDenBu;
    }

    public BigInteger getSach() {
        return sach;
    }

    public void setSach(BigInteger sach) {
        this.sach = sach;
    }

    public BigInteger getGia() {
        return gia;
    }

    public void setGia(BigInteger gia) {
        this.gia = gia;
    }
    
}
