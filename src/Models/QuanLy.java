<<<<<<< Updated upstream
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
public class QuanLy {
    private BigInteger id;
    private String cccd;
    private String fullName;
    private String diaChi;
    private String soDienThoai;
    private String email;
    private Date ngaySinh;
    private Date ngayTao;
    private Date ngayHan;
    private String qr_code;
    private Boolean vaiTro;

    public QuanLy(BigInteger id, String cccd, String fullName, String diaChi, String soDienThoai, String email, Date ngaySinh, Date ngayTao, Date ngayHan, String qr_code, Boolean vaiTro) {
        this.id = id;
        this.cccd = cccd;
        this.fullName = fullName;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.ngayHan = ngayHan;
        this.qr_code = qr_code;
        this.vaiTro = vaiTro;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
    
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author haunv
 */
public class QuanLy {

    private String maQL;
    private String matKhau;
    private String cccd;
    private String fullName;
    private String diaChi;
    private Date ngaySinh;
    private String soDienThoai;
    private String email;
    private boolean vaiTro;
    private boolean trangThai;

    public QuanLy() {
    }

    public QuanLy(String maQL, String matKhau, String cccd, String fullName, String diaChi, Date ngaySinh, String soDienThoai, String email, boolean vaiTro, boolean trangThai) {
        this.maQL = maQL;
        this.matKhau = matKhau;
        this.cccd = cccd;
        this.fullName = fullName;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public String getMaQL() {
        return maQL;
    }

    public void setMaQL(String maQL) {
        this.maQL = maQL;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "QuanLy{" + "maQL=" + maQL + ", matKhau=" + matKhau + ", cccd=" + cccd + ", fullName=" + fullName + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + ", email=" + email + ", vaiTro=" + vaiTro + ", trangThai=" + trangThai + '}';
    }

}
>>>>>>> Stashed changes
