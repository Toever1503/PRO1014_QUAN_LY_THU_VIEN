/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoTest;

import Models.TheLoai;
import java.sql.SQLException;
import static junit.framework.Assert.assertNotNull;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author haunv
 */
public class TheLoaiDaoTest {

    private TheLoaiDao instance;

    @BeforeClass
    public void createInstance() {
        instance = TheLoaiDao.getInstance();
    }

    @AfterClass
    public void close() {
        instance = null;
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Get instance not null", TheLoaiDao.getInstance());
    }

    @Test
    public void testInsertOnUpDateDuLieuDung() throws Exception {
        Assert.assertNotEquals(0, instance.insertOnUpdate(new TheLoai(30l, "oris")));
    }

    @Test
    public void testInsertOnUpDateDuLieuThieuId() throws Exception {
        Assert.assertNotEquals(0, instance.insertOnUpdate(new TheLoai(null, "oris")));
    }

    @Test(expected = SQLException.class)
    public void testInsertOnUpDateDuLieuThieuName() throws Exception {
        instance.insertOnUpdate(new TheLoai(30l, null));
    }

    @Test
    public void testInsertOnUpDateDuLieuIdTrung() throws Exception {
        Assert.assertNotEquals(0, instance.insertOnUpdate(new TheLoai(30l, "oris121")));
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
    public void testInsertVoiNhaXuatBanDung() throws Exception {
        Assert.assertNotEquals(0, instance.insert(new TheLoai(31l, "kkk")));
    }

    @Test
    public void testInsertVoiThieuId() throws Exception {
        Assert.assertNotEquals(0, instance.insert(new TheLoai(null, "kkk")));
    }

    @Test(expected = SQLException.class)
    public void testInsertVoThieuName() throws Exception {
        instance.insert(new TheLoai(null, null));
    }

    @Test(expected = SQLException.class)
    public void testInsertVoiIdTrung() throws Exception {
        instance.insert(new TheLoai(2l, "llll"));
    }

    @Test
    public void testUpdateVoiTheLoaiDung() throws Exception {
        Assert.assertNotEquals(0, instance.update(new TheLoai(10l, "kkkzzz")));
    }

    @Test(expected = SQLException.class)
    public void testUpdateVoiTheLoaiThieuId() throws Exception {
        instance.update(new TheLoai(null, "vasa"));
    }

    @Test(expected = SQLException.class)
    public void testUpdateVoiTheLoaiThieuName() throws Exception {
        instance.update(new TheLoai(2l, null));
    }

    @Test
    public void testUpdateVoiIdTrung() throws Exception {
        Assert.assertNotEquals(0, instance.update(new TheLoai(2l, "kkkkl")));
    }

    @Test
    public void testSelectByIdVoiIdDung() throws Exception {
        Assert.assertNotNull(instance.selectByID(1l));
    }

    @Test(expected = SQLException.class)
    public void testSelectByIdVoiIdKhongTonTai() throws Exception {
        instance.update(new TheLoai(100l, null));
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
        Assert.assertNotEquals(0, instance.selectBySql("SELECT ID, TenTheLoai FROM the_loai").size());
    }

    @Test(expected = SQLException.class)
    public void testSelectByAllThieuSql() throws Exception {
        instance.selectBySql(null, 1);
    }

    @Test
    public void testSelectByAllThieuArgs() throws Exception {
        Assert.assertNotEquals(0, instance.selectBySql("SELECT ID, TenTheLoai FROM the_loai where id = 1").size());
    }

    public static void main(String[] args) {
        //        Result result = JUnitCore.runClasses(NhaXuatBanDaoTest.class);
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
