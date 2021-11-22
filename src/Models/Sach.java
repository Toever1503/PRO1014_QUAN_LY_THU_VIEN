/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author NguyenHoan
 */
public class Sach {

    private BigInteger id;
    private String tenSach;
    private String viTri;
    private Date ngayTao;
    private String qr_code;
    private BigInteger nhaXuatBan;
    private String nguoiTao;
    private boolean trangThai;

    public Sach(BigInteger id, String tenSach, String viTri, Date ngayTao, String qr_code, BigInteger nhaXuatBan, String nguoiTao, boolean trangThai) {
        this.id = id;
        this.tenSach = tenSach;
        this.viTri = viTri;
        this.ngayTao = ngayTao;
        this.qr_code = qr_code;
        this.nhaXuatBan = nhaXuatBan;
        this.nguoiTao = nguoiTao;
        this.trangThai = trangThai;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public BigInteger getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(BigInteger nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Sach{" + "id=" + id + ", tenSach=" + tenSach + ", viTri=" + viTri + ", ngayTao=" + ngayTao + ", qr_code=" + qr_code + ", nhaXuatBan=" + nhaXuatBan + ", nguoiTao=" + nguoiTao + ", trangThai=" + trangThai + '}';
    }
    
    
}
