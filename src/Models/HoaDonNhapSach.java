/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author haunv
 */
public class HoaDonNhapSach {

    private Long id;
    private QuanLy nguoiXuLy;
    private Double tongTien;
    private Date ngayTao;
    private String qr_code;
    private List<HoaDonNhapSachChiTiet> listHoaDonNhapSachChiTiets;

    public HoaDonNhapSach() {
    }

    public HoaDonNhapSach(Long id) {
        this.id = id;
    }

    public HoaDonNhapSach(Long id, QuanLy nguoiXuLy, Double tongTien, Date ngayTao, String qr_code, List<HoaDonNhapSachChiTiet> listHoaDonNhapSachChiTiets) {
        this.id = id;
        this.nguoiXuLy = nguoiXuLy;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.qr_code = qr_code;
        this.listHoaDonNhapSachChiTiets = listHoaDonNhapSachChiTiets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuanLy getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(QuanLy nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public List<HoaDonNhapSachChiTiet> getListHoaDonNhapSachChiTiets() {
        return listHoaDonNhapSachChiTiets;
    }

    public void setListHoaDonNhapSachChiTiets(List<HoaDonNhapSachChiTiet> listHoaDonNhapSachChiTiets) {
        this.listHoaDonNhapSachChiTiets = listHoaDonNhapSachChiTiets;
    }

    @Override
    public String toString() {
        return "HoaDonNhapSach{" + "id=" + id + ", nguoiXuLy=" + nguoiXuLy + ", tongTien=" + tongTien + ", ngayTao=" + ngayTao + ", qr_code=" + qr_code + ", listHoaDonNhapSachChiTiets=" + listHoaDonNhapSachChiTiets + '}';
    }

}
