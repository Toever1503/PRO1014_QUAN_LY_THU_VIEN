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
    private Date ngayTao;
    private String noiDung;
    private Boolean trangThai;
    private Integer soLuot;

    public GopY() {
    }

    public GopY(Long id, Date ngayTao, String noiDung, Boolean trangThai, Integer soLuot) {
        this.id = id;
        this.ngayTao = ngayTao;
        this.noiDung = noiDung;
        this.trangThai = trangThai;
        this.soLuot = soLuot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getSoLuot() {
        return soLuot;
    }

    public void setSoLuot(Integer soLuot) {
        this.soLuot = soLuot;
    }

    @Override
    public String toString() {
        return "GopY{" + "id=" + id + ", ngayTao=" + ngayTao + ", noiDung=" + noiDung + ", trangThai=" + trangThai + ", soLuot=" + soLuot + '}';
    }

}
