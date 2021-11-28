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
    private Long nguoiMuon;
    private String nguoiXuLy;
    private Double tongTien;
    private String qr_code;
    private Date ngayTao;
    List<HoaDonDenBuChiTiet> listhBuChiTiets;

    public HoaDonDenBu() {
    }

    public HoaDonDenBu(Long id, Long nguoiMuon, String nguoiXuLy, Double tongTien, String qr_code, Date ngayTao, List<HoaDonDenBuChiTiet> listhBuChiTiets) {
        this.id = id;
        this.nguoiMuon = nguoiMuon;
        this.nguoiXuLy = nguoiXuLy;
        this.tongTien = tongTien;
        this.qr_code = qr_code;
        this.ngayTao = ngayTao;
        this.listhBuChiTiets = listhBuChiTiets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(Long nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    public String getNguoiXuLy() {
        return nguoiXuLy;
    }

    public void setNguoiXuLy(String nguoiXuLy) {
        this.nguoiXuLy = nguoiXuLy;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
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

    public List<HoaDonDenBuChiTiet> getListhBuChiTiets() {
        return listhBuChiTiets;
    }

    public void setListhBuChiTiets(List<HoaDonDenBuChiTiet> listhBuChiTiets) {
        this.listhBuChiTiets = listhBuChiTiets;
    }

    @Override
    public String toString() {
        return "HoaDonDenBu{" + "id=" + id + ", nguoiMuon=" + nguoiMuon + ", nguoiXuLy=" + nguoiXuLy + ", tongTien=" + tongTien + ", qr_code=" + qr_code + ", ngayTao=" + ngayTao + ", listhBuChiTiets=" + listhBuChiTiets + '}';
    }

}
