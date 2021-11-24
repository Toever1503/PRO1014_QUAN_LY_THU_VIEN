package DAO;

import Models.GopY;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class GopYDAO extends LibrarianDAO<GopY, BigInteger> {

    private final String SELECT_ALL_SQL = "SELECT ID, HoiVien, NgayTao, NoiDung, TrangThai FROM gop_y";
    private final String SELECT_BY_ID_SQL = "SELECT ID, HoiVien, NgayTao, NoiDung, TrangThai FROM gop_y WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO gop_y (ID, HoiVien, NgayTao, NoiDung, TrangThai) VALUES (?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE gop_y SET HoiVien = ?, NgayTao = ?, NoiDung = ?, TrangThai = ? WHERE ID = ?";
    private final String DELETE_SQL = "DELETE FROM gop_y WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO gop_y (ID, HoiVien, NgayTao, NoiDung, TrangThai) VALUES (?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE HoiVien=VALUES(HoiVien), NgayTao=VALUES(NgayTao), NoiDung=VALUES(NoiDung), TrangThai = VALUES(TrangThai)";
    private final String SELECT_BY_PAGE_SQL = "SELECT ID, HoiVien, NgayTao, NoiDung, TrangThai FROM the_loai LIMIT ?, 30";
  
    @Override
    public int insert(GopY entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getHoiVien(),
                    entity.getNgayTao(),
                    entity.getNoiDung(),
                    entity.isTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(GopY entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.UPDATE_SQL,
                    entity.getHoiVien(),
                    entity.getNgayTao(),
                    entity.getNoiDung(),
                    entity.isTrangThai(),
                    entity.getId());
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int insertOnUpdate(GopY entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getHoiVien(),
                    entity.getNgayTao(),
                    entity.getNoiDung(),
                    entity.isTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(BigInteger id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public GopY selectByID(BigInteger id) {
        List<GopY> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GopY> selectByPage(BigInteger id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<GopY> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    @Override
    protected List<GopY> selectBySql(String sql, Object... args) {
        List<GopY> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                GopY gy = new GopY();
                gy.setId(rs.getObject("ID", BigInteger.class));
                gy.setHoiVien(rs.getObject("HoiVien", BigInteger.class));
                gy.setNgayTao(rs.getDate("NgayTao"));
                gy.setNoiDung(rs.getString("NoiDung"));
                gy.setTrangThai(rs.getObject("TrangThai", boolean.class));
                list.add(gy);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
