/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Nguyen Hoan
 */
public class ThongKeDAO {

    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getSachDaMuon() {
        String sql = "{CALL sp_sach_da_muon}";
        String[] cols = {"ID","TenSach","TenTacGia","TenTheLoai","TenNhaXuatBan","NgayMuon","NgayHan"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getSachBiLoai() {
        String sql = "{CALL sp_sach_bi_loai}";
        String[] cols = {"ID","TenSach","TenTacGia","TenTheLoai","TenNhaXuatBan","ViTri"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getSachTreHan() {
        String sql = "{CALL sp_sach_tre_han}";
        String[] cols = {"ID","TenSach","TenTacGia","TenTheLoai","TenNhaXuatBan","NgayMuon","NgayHan"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getSachConLai() {
        String sql = "{CALL sp_sach_con_lai}";
        String[] cols = {"ID","TenSach","TenTacGia","TenTheLoai","TenNhaXuatBan","ViTri"};
        return this.getListOfArray(sql, cols);
    }
}
