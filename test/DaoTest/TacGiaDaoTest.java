/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoTest;

import static DaoTest.TacGiaDao.getInstance;
import Models.TacGia;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertNotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author haunv
 */
public class TacGiaDaoTest {

    private TacGiaDao instance;

    @BeforeClass
    public void createInstance() {
        instance = TacGiaDao.getInstance();
        try {
            instance.insertOnUpdate(new TacGia(85l, "aks"));
            instance.insertOnUpdate(new TacGia(90l, "aks"));
        } catch (Exception ex) {
            Logger.getLogger(NhaXuatBanDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public void close() {
        try {
            instance.delete(100l);
            instance.delete(110l);
            instance.delete(85l);
            instance.delete(115l);
            instance.delete(90l);
        } catch (Exception ex) {
            Logger.getLogger(NhaXuatBanDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance = null;
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Get instance not null", TacGiaDao.getInstance());
    }

    @Test
    public void testInsertOnUpDateDuLieuDung() throws Exception {
        Assert.assertNotEquals(0, instance.insertOnUpdate(new TacGia(30l, "oris")));
    }

    @Test
    public void testInsertOnUpDateDuLieuThieuId() throws Exception {
        Assert.assertNotEquals(0, instance.insertOnUpdate(new TacGia(null, "oris")));
    }

    @Test(expected = SQLException.class)
    public void testInsertOnUpDateDuLieuThieuName() throws Exception {
        instance.insertOnUpdate(new TacGia(30l, null));
    }

    @Test
    public void testInsertOnUpDateDuLieuIdTrung() throws Exception {
        Assert.assertNotEquals(0, instance.insertOnUpdate(new TacGia(30l, "oris121")));
    }

    @Test
    public void testDelteVoiIdDung() throws Exception {
        Assert.assertNotEquals(0, instance.delete(30l));
    }

    @Test(expected = SQLException.class)
    public void testDelteVoiIdKhongTonTai() throws Exception {
        Assert.assertNotEquals(0, instance.delete(30l));
    }

    @Test
    public void testInsertVoiTacGiaDung() throws Exception {
        Assert.assertNotEquals(0, instance.insert(new TacGia(31l, "kkk")));
    }

    @Test
    public void testInsertVoiTacGiaThieuId() throws Exception {
        Assert.assertNotEquals(0, instance.insert(new TacGia(null, "kkk")));
    }

    @Test(expected = SQLException.class)
    public void testInsertVoiTacGiaThieuName() throws Exception {
        instance.insert(new TacGia(null, null));
    }

    @Test(expected = SQLException.class)
    public void testInsertVoiTacGiaIdTrung() throws Exception {
        instance.insert(new TacGia(2l, "llll"));
    }

    @Test
    public void testUpdateVoiTacGiaDung() throws Exception {
        Assert.assertNotEquals(0, instance.update(new TacGia(10l, "kkkzzz")));
    }

    @Test(expected = SQLException.class)
    public void testUpdateVoiTacGiaThieuId() throws Exception {
        instance.update(new TacGia(null, "vasa"));
    }

    @Test(expected = SQLException.class)
    public void testUpdateVoiTacGiaThieuName() throws Exception {
        instance.update(new TacGia(2l, null));
    }

    @Test
    public void testUpdateVoiTacGiaIdTrung() throws Exception {
        Assert.assertNotEquals(0, instance.update(new TacGia(2l, "kkkkl")));
    }

    @Test
    public void testSelectByIdVoiIdDung() throws Exception {
        Assert.assertNotNull(instance.selectByID(1l));
    }

    @Test(expected = SQLException.class)
    public void testSelectByIdVoiIdKhongTonTai() throws Exception {
        instance.update(new TacGia(100l, null));
    }

    @Test
    public void testSelectByPageVoiPageDung() throws Exception {
        Assert.assertNotEquals(0, instance.selectByPage(0l).size());
    }

    @Test
    public void testSelectByPageVoiPageKhongTonTai() throws Exception {
        Assert.assertNotEquals(0, instance.selectByPage(100l).size());
    }

    @Test
    public void testSelectByAll() throws Exception {
        Assert.assertNotEquals(0, instance.selectALL().size());
    }

    @Test
    public void testSelectBySqlVoiDuLieuDung() throws Exception {
        Assert.assertNotEquals(0, instance.selectBySql("SELECT ID, TenTacGia FROM tac_gia").size());
    }

    @Test(expected = SQLException.class)
    public void testSelectByAllThieuSql() throws Exception {
        instance.selectBySql(null, 1);
    }

    @Test
    public void testSelectByAllThieuArgs() throws Exception {
        Assert.assertNotEquals(0, instance.selectBySql("SELECT ID, TenTacGia FROM tac_gia where id = 1").size());
    }

    public static void main(String[] args) {
        //        Result result = JUnitCore.runClasses(TacGiaDao.class);
//        for (Failure failed : result.getFailures()) {
//            System.out.println(failed.toString());
//        }
//        System.out.println("Total tests: " + result.getRunCount());
//        System.out.println("Failed tests: " + result.getFailureCount());
//        System.out.println("Ignored tests: " + result.getIgnoreCount());
//        System.err.println("Time test: " + result.getRunTime());
//        System.out.println("is Successfull? " + result.wasSuccessful());

    }
}
