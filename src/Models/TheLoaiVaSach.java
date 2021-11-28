/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author haunv
 */
public class TheLoaiVaSach {

    private Long sach;
    private Long theLoai;

    public TheLoaiVaSach(Long sach, Long theLoai) {
        this.sach = sach;
        this.theLoai = theLoai;
    }

    public Long getSach() {
        return sach;
    }

    public void setSach(Long sach) {
        this.sach = sach;
    }

    public Long getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(Long theLoai) {
        this.theLoai = theLoai;
    }

    @Override
    public String toString() {
        return "TheLoaiVaSach{" + "sach=" + sach + ", theLoai=" + theLoai + '}';
    }

}
