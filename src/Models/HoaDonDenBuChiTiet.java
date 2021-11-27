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

    private Long hoaDonDenBu;
    private Long sach;
    private Double gia;

    public HoaDonDenBuChiTiet() {
    }

    public HoaDonDenBuChiTiet(Long hoaDonDenBu, Long sach, Double gia) {
        this.hoaDonDenBu = hoaDonDenBu;
        this.sach = sach;
        this.gia = gia;
    }

    public Long getHoaDonDenBu() {
        return hoaDonDenBu;
    }

    public void setHoaDonDenBu(Long hoaDonDenBu) {
        this.hoaDonDenBu = hoaDonDenBu;
    }

    public Long getSach() {
        return sach;
    }

    public void setSach(Long sach) {
        this.sach = sach;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "HoaDonDenBuChiTiet{" + "hoaDonDenBu=" + hoaDonDenBu + ", sach=" + sach + ", gia=" + gia + '}';
    }

}
