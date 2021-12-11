/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Sach;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author NguyenHoan
 */
public class SachDAO extends LibrarianDAO<Sach, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, MaQL, TenSach, ViTri, NgayTao, NhaXuatBan, TrangThai, QR_FILE, giaSach FROM sach";
    private final String SELECT_BY_ID_SQL = SELECT_ALL_SQL + " WHERE ID = ?";
    private final String SELECT_BY_QR_SQL = SELECT_ALL_SQL + " WHERE QR_FILE = ?";
    private final String INSERT_SQL = "INSERT INTO sach(ID, MaQL, TenSach, ViTri, NgayTao, NhaXuatBan, TrangThai, QR_FILE, giaSach) VALUES (?,?,?,?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE sach SET MaQL=?,TenSach=?,ViTri=?,NgayTao=?,NhaXuatBan=?,TrangThai=?,QR_FILE=? WHERE ID=?";
    private final String UPDATE_GIA_SQL = "UPDATE sach SET giaSach=? WHERE ID=?";
    private final String DELETE_SQL = "DELETE FROM sach WHERE ID = ?";
    private final String DELETE_BY_HDNS_SQL = "DELETE FROM sach WHERE hdctnsct = ?";

    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO sach (ID, MaQL, TenSach, ViTri, NgayTao, NhaXuatBan, TrangThai, QR_FILE, hdctnsct, giaSach) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE MaQL=VALUES(MaQL), TenSach=VALUES(TenSach), ViTri=VALUES(ViTri), NgayTao=VALUES(NgayTao), NhaXuatBan=VALUES(NhaXuatBan), TrangThai=VALUES(TrangThai), QR_FILE=VALUES(QR_FILE)";
    private final String SELECT_BY_PAGE_SQL = SELECT_ALL_SQL + " where hdctnsct = 0  LIMIT ?, 30";
    private final String SELECT_BY_KEY = SELECT_ALL_SQL + " WHERE ID like ? or TenSach like ? or ViTri like ?";
    private final String SELECT_ALL_BY_TL = SELECT_ALL_SQL + " as s JOIN the_loai_va_sach AS tlvs\n"
            + "ON\n"
            + "    tlvs.Sach = s.ID\n"
            + "WHERE tlvs.TheLoai = ?";
    private final String SELECT_ALL_BY_KEY = "SELECT s.ID, s.MaQL, s.TenSach, s.ViTri, s.NgayTao, s.NhaXuatBan, s.TrangThai, s.QR_FILE, s.giaSach \n"
            + "FROM sach as s\n"
            + "JOIN nha_xuat_ban as nxb on nxb.ID = s.NhaXuatBan\n"
            + "JOIN tac_gia_va_sach as tgvs on tgvs.Sach = s.ID\n"
            + "JOIN tac_gia as tg on tg.ID = tgvs.TacGia\n"
            + "WHERE s.TenSach like ? or s.MaQL like ? or s.ViTri like ? or tg.TenTacGia LIKE ?\n"
            + "ORDER BY s.NgayTao";
    private static SachDAO instance;

    private SachDAO() {
    }

    public static SachDAO getInstance() {
        if (instance == null) {
            instance = new SachDAO();
        }
        return instance;
    }

    @Override
    public int insert(Sach entity) {
        return 0;
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
                    entity.getQr_code(),
                    entity.getHdns(),
                    entity.getGia());
            if (row > 0) {
                if (entity.getId() == null) {
                    ResultSet rs = Helper.Utility.query("SELECT ID FROM sach\n"
                            + "ORDER BY ID DESC\n"
                            + "LIMIT 0,?", 1);
                    rs.next();
                    Long id = rs.getLong("ID");
                    entity.setId(id);
                    row = id.intValue();
                }
            }
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
    
    public int deleteByHDNS(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_BY_HDNS_SQL, id);
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

    public List<Sach> selectByPage(Long page, int type) {
        return this.selectBySql(SELECT_ALL_SQL + " where hdctnsct != 0  LIMIT ?, 30", page * 30);
    }

    public List<Sach> selectByKey(String key) {
        return this.selectBySql(this.SELECT_ALL_BY_KEY, key, key, key, key);
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
                s.setNguoiTao(rs.getString("MaQL"));
                s.setTenSach(rs.getString("TenSach"));
                s.setViTri(rs.getString("ViTri"));
                s.setNgayTao(rs.getObject("NgayTao", java.sql.Date.class));
                s.setNhaXuatBan(rs.getLong("NhaXuatBan"));
                s.setTrangThai(rs.getBoolean("TrangThai"));
                s.setQr_code(rs.getString("QR_FILE"));
                s.setGia(rs.getDouble("giaSach"));
                list.add(s);
            }
            rs.getStatement().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateGia(Long id, Double gia) {
        try {
            Helper.Utility.update(this.UPDATE_GIA_SQL,
                    gia, id);
        } catch (Exception ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Sach> searchByKey(String input) {
        input = "%" + input + "%";
        return this.selectBySql(this.SELECT_BY_KEY, input, input, input);
    }

    public List<Sach> selectAllByTheLoai(Long theLoai) {
        return this.selectBySql(this.SELECT_ALL_BY_TL, theLoai);
    }

    public int getTotal() {
        int total = 0;
        try {
            java.sql.ResultSet rs = Helper.Utility.query("SELECT COUNT(ID)/30 as total FROM sach");
            while (rs.next()) {
                total = (int) rs.getDouble("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public Sach findByQR(String qr) {
        List<Sach> list = this.selectBySql(this.SELECT_BY_QR_SQL, qr);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        SachDAO sachDAO = SachDAO.getInstance();

        System.out.println(sachDAO.selectByPage(Long.valueOf(0)).size());
    }

}
