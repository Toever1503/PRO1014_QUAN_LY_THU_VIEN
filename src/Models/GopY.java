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
public class GopY {
    private BigInteger id;
    private BigInteger hoiVien;
    private Date ngayTao;
    private String noiDung;
    private boolean trangThai;

    public GopY() {
    }

    public GopY(BigInteger id, BigInteger hoiVien, Date ngayTao, String noiDung, boolean trangThai) {
        this.id = id;
        this.hoiVien = hoiVien;
        this.ngayTao = ngayTao;
        this.noiDung = noiDung;
        this.trangThai = trangThai;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getHoiVien() {
        return hoiVien;
    }

    public void setHoiVien(BigInteger hoiVien) {
        this.hoiVien = hoiVien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "GopY{" + "id=" + id + ", hoiVien=" + hoiVien + ", ngayTao=" + ngayTao + ", noiDung=" + noiDung + ", trangThai=" + trangThai + '}';
    }

}
