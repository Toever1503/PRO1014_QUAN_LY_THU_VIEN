/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author haunv
 */
public class HoaDonDenBuChiTiet {

    private long hoaDonDenBu;
    private long sach;
    private float gia;

    public HoaDonDenBuChiTiet() {
    }

    public HoaDonDenBuChiTiet(long hoaDonDenBu, long sach, float gia) {
        this.hoaDonDenBu = hoaDonDenBu;
        this.sach = sach;
        this.gia = gia;
    }

    public long getHoaDonDenBu() {
        return hoaDonDenBu;
    }

    public void setHoaDonDenBu(long hoaDonDenBu) {
        this.hoaDonDenBu = hoaDonDenBu;
    }

    public long getSach() {
        return sach;
    }

    public void setSach(long sach) {
        this.sach = sach;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "HoaDonDenBuChiTiet{" + "hoaDonDenBu=" + hoaDonDenBu + ", sach=" + sach + ", gia=" + gia + '}';
    }

}
