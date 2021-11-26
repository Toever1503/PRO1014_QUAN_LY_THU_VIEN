/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Sach;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenHoan
 */
public class SachDAO extends LibrarianDAO<Sach, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, MaQL, TenSach, ViTri, NgayTao, NhaXuatBan, TrangThai, QR_FILE FROM sach";
    private final String SELECT_BY_ID_SQL = SELECT_ALL_SQL + " WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO sach(ID, MaQL, TenSach, ViTri, NgayTao, NhaXuatBan, TrangThai, QR_FILE) VALUES (?,?,?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE sach SET MaQL=?,TenSach=?,ViTri=?,NgayTao=?,NhaXuatBan=?,TrangThai=?,QR_FILE=? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM sach WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO sach (ID, MaQL, TenSach, ViTri, NgayTao, NhaXuatBan, TrangThai, QR_FILE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE MaQL=VALUES(MaQL), TenSach=VALUES(TenSach), ViTri=VALUES(ViTri), NgayTao=VALUES(NgayTao), NhaXuatBan=VALUES(NhaXuatBan), TrangThai=VALUES(TrangThai), QR_FILE=VALUES(QR_FILE)";
    private final String SELECT_BY_PAGE_SQL = SELECT_ALL_SQL + " LIMIT ?, 30";
    private final String SELECT_BY_KEY = SELECT_ALL_SQL + " WHERE s.ID like ? or s.TenSach like ? or nxb.TenNhaXuatBan like ? or s.ViTri like ?";
    private final String SELECT_ALL_BY_TL = SELECT_ALL_SQL + " JOIN the_loai_va_sach AS tlvs\n"
            + "ON\n"
            + "    tlvs.Sach = s.ID\n"
            + "WHERE tlvs.TheLoai = ?";
    private static SachDAO instance;
    private HoaDonNhapSachChiTietDao hoaDonNhapSachChiTietDao;
    private QuanLyDao quanLyDao;
    private NhaXuatBanDao nhaXuatBanDao;

    private SachDAO() {
//        hoaDonNhapSachChiTietDao = HoaDonNhapSachChiTietDao.getInstance();
        quanLyDao = QuanLyDao.getInstance();
        nhaXuatBanDao = NhaXuatBanDao.getInstance();
    }

    public static SachDAO getInstance() {
        if (instance == null) {
            instance = new SachDAO();
        }
        return instance;
    }

    public void setHoaDonNhapSachChiTietDao(HoaDonNhapSachChiTietDao hoaDonNhapSachChiTietDao) {
        this.hoaDonNhapSachChiTietDao = hoaDonNhapSachChiTietDao;
    }

    @Override
    public int insert(Sach entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getNguoiTao(),
                    entity.getTenSach(),
                    entity.getViTri(),
                    entity.getNgayTao(),
                    entity.getNhaXuatBan(),
                    entity.isTrangThai(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(Sach entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getNguoiTao(),
                    entity.getTenSach(),
                    entity.getViTri(),
                    entity.getNgayTao(),
                    entity.getNhaXuatBan(),
                    entity.isTrangThai(),
                    entity.getQr_code(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(Sach entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getNguoiTao(),
                    entity.getTenSach(),
                    entity.getViTri(),
                    entity.getNgayTao(),
                    entity.getNhaXuatBan(),
                    entity.isTrangThai(),
                    entity.getQr_code());
        } catch (Exception ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public Sach selectByID(Long id) {
        List<Sach> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Sach> selectByPage(Long page) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, page * 30);
    }

    @Override
    public List<Sach> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                Sach s = new Sach();
                s.setId(rs.getLong("ID"));
                s.setNguoiTao(quanLyDao.selectByID(rs.getString("MaQL")));
                s.setTenSach(rs.getString("TenSach"));
                s.setViTri(rs.getString("ViTri"));
                s.setNgayTao(rs.getDate("NgayTao"));
                s.setNhaXuatBan(nhaXuatBanDao.selectByID(rs.getLong("NhaXuatBan")));
                s.setTrangThai(rs.getBoolean("TrangThai"));
                s.setQr_code(rs.getString("QR_FILE"));
//                s.setHoaDonNhapSachChiTiet(hoaDonNhapSachChiTietDao.selectBySach(s.getId()));
                list.add(s);
            }
            rs.getStatement().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Sach> searchByKey(String input) {
        input = "%" + input + "%";
        return this.selectBySql(this.SELECT_BY_KEY, input, input, input, input);
    }

    public List<Sach> selectAllByTheLoai(Long theLoai) {
        return this.selectBySql(this.SELECT_ALL_BY_TL, theLoai);
    }

    public static void main(String[] args) {
        SachDAO sachDAO = SachDAO.getInstance();

        sachDAO.selectByID(Long.valueOf(1));
    }
}
