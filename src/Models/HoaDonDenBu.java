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
public class HoaDonDenBu {

    private Long id;
    private HoiVien nguoiMuon;
    private QuanLy nguoiXuLy;
    private Double tongTien;
    private String qr_code;
    private Date ngayTao;
    private List<HoaDonDenBuChiTiet> listHoaDonDenBuChiTiets;

    public HoaDonDenBu() {
    }

    public HoaDonDenBu(Long id) {
        this.id = id;
    }

    public HoaDonDenBu(long id, HoiVien nguoiMuon, QuanLy nguoiXuLy, double tongTien, String qr_code, Date ngayTao, List<HoaDonDenBuChiTiet> listHoaDonDenBuChiTiets) {
        this.id = id;
        this.nguoiMuon = nguoiMuon;
        this.nguoiXuLy = nguoiXuLy;
        this.tongTien = tongTien;
        this.qr_code = qr_code;
        this.ngayTao = ngayTao;
        this.listHoaDonDenBuChiTiets = listHoaDonDenBuChiTiets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HoiVien getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(HoiVien nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
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

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public List<HoaDonDenBuChiTiet> getListHoaDonDenBuChiTiets() {
        return listHoaDonDenBuChiTiets;
    }

    public void setListHoaDonDenBuChiTiets(List<HoaDonDenBuChiTiet> listHoaDonDenBuChiTiets) {
        this.listHoaDonDenBuChiTiets = listHoaDonDenBuChiTiets;
    }

    @Override
    public String toString() {
        return "HoaDonDenBu{" + "id=" + id + ", nguoiMuon=" + nguoiMuon + ", nguoiXuLy=" + nguoiXuLy + ", tongTien=" + tongTien + ", qr_code=" + qr_code + ", ngayTao=" + ngayTao + ", listHoaDonDenBuChiTiets=" + listHoaDonDenBuChiTiets + '}';
    }

}
