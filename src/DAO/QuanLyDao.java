package DAO;

import Models.QuanLy;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class QuanLyDao extends LibrarianDAO<QuanLy, String> {

    private final String SELECT_ALL_SQL = "SELECT MaQL,MatKhau,CCCD,HoTen,DiaChi,NgaySinh,SoDienThoai,Email,VaiTro,TrangThai FROM quan_ly";
    private final String SELECT_BY_ID_SQL = "SELECT MaQL,MatKhau,CCCD,HoTen,DiaChi,NgaySinh,SoDienThoai,Email,VaiTro,TrangThai FROM quan_ly WHERE MaQL = ?";
    private final String INSERT_SQL = "INSERT INTO quan_ly (MaQL,MatKhau,CCCD,HoTen,DiaChi,NgaySinh,SoDienThoai,Email,VaiTro,TrangThai) VALUES (?,?,?,?,?,?,?,?,?,?,)";
    private final String UPDATE_SQL = "UPDATE quan_ly SET MatKhau = ?,CCCD = ?,HoTen = ?,DiaChi = ?,NgaySinh = ?,SoDienThoai = ?,Email = ?,VaiTro = ?,TrangThai = ? WHERE MaQL = ?";
    private final String DELETE_SQL = "DELETE FROM quan_ly WHERE MaQL = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO quan_ly (MaQL, MatKhau, CCCD, HoTen, DiaChi, NgaySinh, SoDienThoai, Email, VaiTro, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE MatKhau=VALUES(MatKhau), CCCD=VALUES(CCCD), HoTen=VALUES(HoTen), DiaChi=VALUES(DiaChi), NgaySinh=VALUES(NgaySinh), SoDienThoai=VALUES(SoDienThoai), Email=VALUES(Email), VaiTro=VALUES(VaiTro), TrangThai=VALUES(TrangThai)";
    private final String SELECT_BY_PAGE_SQL = "SELECT MaQL,MatKhau,CCCD,HoTen,DiaChi,NgaySinh,SoDienThoai,Email,VaiTro,TrangThai FROM quan_ly LIMIT ?, 30";
    private static QuanLyDao instance;

    public static QuanLyDao getInstance() {
        if (instance == null) {
            instance = new QuanLyDao();
        }
        return instance;
    }

    @Override
    public int insert(QuanLy entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getMaQL(),
                    entity.getMatKhau(),
                    entity.getCccd(),
                    entity.getFullName(),
                    entity.getDiaChi(),
                    entity.getNgaySinh(),
                    entity.getSoDienThoai(),
                    entity.getEmail(),
                    entity.isVaiTro(),
                    entity.isTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(QuanLy entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getMatKhau(),
                    entity.getCccd(),
                    entity.getFullName(),
                    entity.getDiaChi(),
                    entity.getNgaySinh(),
                    entity.getSoDienThoai(),
                    entity.getEmail(),
                    entity.isVaiTro(),
                    entity.isTrangThai(),
                    entity.getMaQL());
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(QuanLy entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getMaQL(),
                    entity.getMatKhau(),
                    entity.getCccd(),
                    entity.getFullName(),
                    entity.getDiaChi(),
                    entity.getNgaySinh(),
                    entity.getSoDienThoai(),
                    entity.getEmail(),
                    entity.isVaiTro(),
                    entity.isTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(String id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public QuanLy selectByID(String id) {
        List<QuanLy> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QuanLy> selectByPage(String id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<QuanLy> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<QuanLy> selectBySql(String sql, Object... args) {
        List<QuanLy> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                QuanLy ql = new QuanLy();
                ql.setMaQL(rs.getString("MaQL"));
                ql.setMatKhau(rs.getString("MatKhau"));
                ql.setCccd(rs.getString("CCCD"));
                ql.setFullName(rs.getString("HoTen"));
                ql.setDiaChi(rs.getString("DiaChi"));
                ql.setNgaySinh(rs.getDate("NgaySinh"));
                ql.setSoDienThoai(rs.getString("SoDienThoai"));
                ql.setEmail(rs.getString("Email"));
                ql.setVaiTro(rs.getBoolean("VaiTro"));
                ql.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(ql);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
