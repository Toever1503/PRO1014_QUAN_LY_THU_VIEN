/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.GopYDAO;
import DAO.HoaDonDenBuChiTietDao;
import DAO.HoaDonDenBuDao;
import DAO.HoaDonNhapSachChiTietDao;
import DAO.HoaDonNhapSachDao;
import DAO.HoiVienDao;
import DAO.NhaXuatBanDao;
import DAO.PhieuMuonChiTietDao;
import DAO.PhieuMuonDao;
import DAO.QuanLyDao;
import DAO.TacGiaDao;
import DAO.TheLoaiDao;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class Loading_JFrame extends javax.swing.JFrame {

    /**
     * Creates new form Loading_JFrame
     */
    public Loading_JFrame() {
        initComponents();
        setLocationRelativeTo(null);
        new Thread() {
            @Override
            public void run() {
                HoiVienDao.getInstance();
                QuanLyDao.getInstance();
                TacGiaDao.getInstance();
                TheLoaiDao.getInstance();
                NhaXuatBanDao.getInstance();
                GopYDAO.getInstance();

                HoaDonDenBuChiTietDao.getInstance();
                PhieuMuonChiTietDao.getInstance();
                HoaDonNhapSachChiTietDao.getInstance();

                PhieuMuonDao.getInstance();
                HoaDonDenBuDao.getInstance();
                HoaDonNhapSachDao.getInstance();
                
                Home_Frame.getInstance();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                int i = 0;
                Random ran = new Random();
                while (i <= 100) {
                    try {
                        i++;
                        jProgressBar1.setValue(i);
                        Thread.sleep(ran.nextInt(200));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Loading_JFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                dispose();
                new Login_JFrame().setVisible(true);
            }
        }.start();;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/Logo_?????i_h???c_FPT.png"))); // NOI18N
        jLabel1.setText(" ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loading_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
