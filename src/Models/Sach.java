/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author NguyenHoan
 */
public class Sach {

    private Long id;
    private String nguoiTao;
    private String tenSach;
    private String viTri;
    private Date ngayTao;
    private String qr_code;
    private long nhaXuatBan;
    private boolean trangThai;
    private Double gia;
    private Long hdns;

    public Sach() {
    }

    public Sach(Long id) {
        this.id = id;
    }

    public Sach(Long id, String tenSach) {
        this.id = id;
        this.nguoiTao = nguoiTao;
    }

    public Sach(Long id, String nguoiTao, String tenSach, String viTri, Date ngayTao, String qr_code, long nhaXuatBan, boolean trangThai, Double gia, Long hdns) {
        this.id = id;
        this.nguoiTao = nguoiTao;
        this.tenSach = tenSach;
        this.viTri = viTri;
        this.ngayTao = ngayTao;
        this.qr_code = qr_code;
        this.nhaXuatBan = nhaXuatBan;
        this.trangThai = trangThai;
        this.gia = gia;
        this.hdns = hdns;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
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

    public long getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(long nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Long getHdns() {
        return hdns;
    }

    public void setHdns(Long hdns) {
        this.hdns = hdns;
    }

    @Override
    public String toString() {
        return "Sach{" + "id=" + id + ", nguoiTao=" + nguoiTao + ", tenSach=" + tenSach + ", viTri=" + viTri + ", ngayTao=" + ngayTao + ", qr_code=" + qr_code + ", nhaXuatBan=" + nhaXuatBan + ", trangThai=" + trangThai + ", gia=" + gia + ", hdns=" + hdns + '}';
    }

}
