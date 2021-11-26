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
public class GopY {

    private Long id;
    private String hoiVien;
    private Date ngayTao;
    private String noiDung;
    private boolean trangThai;

    public GopY() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoiVien() {
        return hoiVien;
    }

    public void setHoiVien(String hoiVien) {
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
