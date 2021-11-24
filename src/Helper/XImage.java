/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.io.File;

/**
 *
 * @author haunv
 */
public class XImage {

    public static final String USER_UPLOAD = "upload/user";
    public static final String SACH_UPLOAD = "upload/sach";
    public static final String PHIEUMUON_UPLOAD = "upload/phieumuon";
    public static final String HOADON_UPLOAD = "upload/hoadon";

    public static void init() {
        File userUpload = new File(USER_UPLOAD);
        File sachUpload = new File(SACH_UPLOAD);
        File hoaDonUpload = new File(HOADON_UPLOAD);
        File phieuMuonUpload = new File(PHIEUMUON_UPLOAD);

        if (!userUpload.isDirectory()) {
            userUpload.mkdir();
        }
        if (!sachUpload.isDirectory()) {
            sachUpload.mkdir();
        }
        if (!hoaDonUpload.isDirectory()) {
            hoaDonUpload.mkdir();
        }
        if (!phieuMuonUpload.isDirectory()) {
            phieuMuonUpload.mkdir();
        }

    }
}
