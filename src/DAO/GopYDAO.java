package DAO;

import Models.GopY;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class GopYDAO extends LibrarianDAO<GopY, Long> {

    private final String SELECT_ALL_SQL = "SELECT ID, NgayTao, NoiDung, TrangThai, soLuot FROM gop_y";
    private final String SELECT_BY_ID_SQL = "SELECT ID, NgayTao, NoiDung, TrangThai, soLuot FROM gop_y WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO gop_y (ID, NgayTao, NoiDung, TrangThai, soLuot) VALUES (?,?,?,?,?)";
    private final String UPDATE_SQL = "";
    private final String DELETE_SQL = "DELETE FROM gop_y WHERE ID = ?";
    private final String INSERT_ON_UPDATE_SQL = "INSERT INTO gop_y (ID, NgayTao, NoiDung, TrangThai, soLuot) VALUES (?, ?, ?, ?, ?)\n"
            + "ON DUPLICATE KEY UPDATE soLuot=VALUES(soLuot), NgayTao=VALUES(NgayTao), NoiDung=VALUES(NoiDung), TrangThai = VALUES(TrangThai)";
    private final String SELECT_BY_PAGE_SQL = SELECT_ALL_SQL.concat(" WHERE TrangThai = 1 ORDER BY soLuot DESC LIMIT ?, 30");
    private static GopYDAO instance;

    private GopYDAO() {
    }

    public static GopYDAO getInstance() {
        if (instance == null) {
            instance = new GopYDAO();
        }
        return instance;
    }

    @Override
    public int insert(GopY entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_SQL,
                    entity.getId(),
                    entity.getNgayTao(),
                    entity.getNoiDung(),
                    entity.getTrangThai(),
                    entity.getSoLuot());
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int update(GopY entity) {
        return 0;
    }

    @Override
    public int insertOnUpdate(GopY entity) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.INSERT_ON_UPDATE_SQL,
                    entity.getId(),
                    entity.getNgayTao(),
                    entity.getNoiDung(),
                    entity.getTrangThai(),
                    entity.getSoLuot());
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int delete(Long id) {
        int row = 0;
        try {
            row = Helper.Utility.update(this.DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(QuanLyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public GopY selectByID(Long id) {
        List<GopY> list = this.selectBySql(this.SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GopY> selectByPage(Long id) {
        return this.selectBySql(this.SELECT_BY_PAGE_SQL, id);
    }

    @Override
    public List<GopY> selectALL() {
        return this.selectBySql(this.SELECT_ALL_SQL);
    }

    public int getTotalPage() {
        int total = 0;
        try {
            java.sql.ResultSet rs = Helper.Utility.query("SELECT COUNT(ID)/30 as total FROM gop_y");
            while (rs.next()) {
                total = (int) rs.getDouble("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(PhieuMuonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public List<GopY> selectByKeyword(String key) {
        return this.selectBySql(this.SELECT_ALL_SQL + " WHERE NoiDung LIKE ? and TrangThai = 1", key);
    }

    @Override
    protected List<GopY> selectBySql(String sql, Object... args) {
        List<GopY> list = new java.util.ArrayList<>();
        try {
            java.sql.ResultSet rs = Helper.Utility.query(sql, args);
            while (rs.next()) {
                GopY gy = new GopY();
                gy.setId(rs.getLong("ID"));
                gy.setNgayTao(rs.getDate("NgayTao"));
                gy.setNoiDung(rs.getString("NoiDung"));
                gy.setTrangThai(rs.getBoolean("TrangThai"));
                gy.setSoLuot(rs.getInt("soLuot"));
                list.add(gy);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(GopYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(GopYDAO.getInstance().selectByKeyword("%harry%"));
    }

}
