/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Hoan
 */
public class ThongKeDAO {

    public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();
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
        String[] cols = {"ID", "TenSach", "TenTacGia", "TenTheLoai", "TenNhaXuatBan", "NgayMuon", "NgayHan"};
        return this.getListOfArray(sql, cols);
    }
//
//    public List<Object[]> getLuongNguoiHoc() {
//        String sql = "{CALL dbo.sp_LuongNguoiHoc}";
//        String[] cols = {"Nam", "SoLuong", "DauTien", "CuoiCung"};
//        return this.getListOfArray(sql, cols);
//    }
//
//    public List<Object[]> getDiemChuyenDe() {
//        String sql = "{CALL dbo.sp_DiemChuyenDe}";
//        String[] cols = {"ChuyenDe", "SoHV", "ThapNhat", "CaoNhat", "TrungBinh"};
//        return this.getListOfArray(sql, cols);
//    }

    public static void main(String[] args) {
        ThongKeDAO tk = new ThongKeDAO();
        try {
               List l = tk.getSachDaMuon();
        System.out.println(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
     
        
//          String[] cols = {"ID", "TenSach", "TenTacGia", "TenTheLoai", "TenNhaXuatBan", "NgayMuon", "NgayHan"};
//             System.out.println(tk.getListOfArray("CALL sp_sach_da_muon", cols));   
    }

}
