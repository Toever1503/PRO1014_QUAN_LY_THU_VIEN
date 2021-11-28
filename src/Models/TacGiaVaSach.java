/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author haunv
 */
public class TacGiaVaSach {

    private Long sach;
    private Long tacGia;

    public TacGiaVaSach(Long sach, Long tacGia) {
        this.sach = sach;
        this.tacGia = tacGia;
    }

    public Long getSach() {
        return sach;
    }

    public void setSach(Long sach) {
        this.sach = sach;
    }

    public Long getTacGia() {
        return tacGia;
    }

    public void setTacGia(Long tacGia) {
        this.tacGia = tacGia;
    }

    @Override
    public String toString() {
        return "TacGiaVaSach{" + "sach=" + sach + ", tacGia=" + tacGia + '}';
    }

}
