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
