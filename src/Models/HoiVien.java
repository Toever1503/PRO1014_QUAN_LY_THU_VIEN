/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author haunv
 */
public class HoiVien {

    private long id;
    private String nguoiTao;
    private String cccd;
    private String fullName;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private Date ngaySinh;
    private Date ngayTao;
    private Date ngayHan;
    private String qr_code;

    public HoiVien() {
    }

    public HoiVien(long id, String nguoiTao, String cccd, String fullName, String diaChi, String soDienThoai, String email, Date ngaySinh, Date ngayTao, Date ngayHan, String qr_code) {
        this.id = id;
        this.nguoiTao = nguoiTao;
        this.cccd = cccd;
        this.fullName = fullName;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.ngayHan = ngayHan;
        this.qr_code = qr_code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayHan() {
        return ngayHan;
    }

    public void setNgayHan(Date ngayHan) {
        this.ngayHan = ngayHan;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

 
}
