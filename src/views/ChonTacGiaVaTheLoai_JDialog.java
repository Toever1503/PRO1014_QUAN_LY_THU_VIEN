/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import DAO.TacGiaDao;
import DAO.TheLoaiDao;
import Helper.MsgBox;
import Models.TacGia;
import Models.TheLoai;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haunv
 */
public class ChonTacGiaVaTheLoai_JDialog extends javax.swing.JDialog {

    private static ChonTacGiaVaTheLoai_JDialog instance;
    private DefaultTableModel tableModel;
    private String actionType;

    /**
     * Creates new form ChonTacGiaVaTheLoai
     */
    private ChonTacGiaVaTheLoai_JDialog() {
        initComponents();
        tableModel = (DefaultTableModel) tblTacGiaVaTheLoai.getModel();
    }

    public static ChonTacGiaVaTheLoai_JDialog getInstance() {
        if (instance == null) {
            instance = new ChonTacGiaVaTheLoai_JDialog();
        }
        return instance;
    }

    public void show(String actionType, Map<Long, TacGia> listTG, Map<Long, TheLoai> listTL) {
        this.actionType = actionType;
        tableModel.setRowCount(0);
        String[] colsHeader = {"Mã", ""};
        if (this.actionType.equals("TAC_GIA")) {
            System.out.println(listTG == null);
            listTG.forEach((x, y) -> {
                tableModel.addRow(new Object[]{x, y.getTenTacGia()});
            });
        } else {
            listTL.forEach((x, y) -> {
                tableModel.addRow(new Object[]{x, y.getTenTheLoai()});
            });
        }
        tblTacGiaVaTheLoai.setModel(tableModel);
        setVisible(true);
    }

    public ChonTacGiaVaTheLoai_JDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTacGiaVaTheLoai = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTacGiaVaTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null}
            },
            new String [] {
                "Mã", "Tên"
            }
        ));
        jScrollPane1.setViewportView(tblTacGiaVaTheLoai);
        if (tblTacGiaVaTheLoai.getColumnModel().getColumnCount() > 0) {
            tblTacGiaVaTheLoai.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 440, 340));

        btnBack.setText("Quay Lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int row = tblTacGiaVaTheLoai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn bản ghi cần thêm!");
        }
        if (this.actionType.equals("TAC_GIA")) {
            if (QLSach_JPanel.getInstance().addTacGia(Long.valueOf(tblTacGiaVaTheLoai.getValueAt(row, 0).toString()))) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Tác giả đã được thêm!");
            }

        } else {
            if (QLSach_JPanel.getInstance().addTheLoai(Long.valueOf(tblTacGiaVaTheLoai.getValueAt(row, 0).toString()))) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thể loại đã được thêm!");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        this.updateTacGiaVaTheLoai();
    }//GEN-LAST:event_btnUpdateActionPerformed

    void updateTacGiaVaTheLoai() {
        int row = 0;
        if (this.actionType.equals("TAC_GIA")) {
            String tenTg = MsgBox.prompt(this, "Nhập tên tác giả muốn thêm :0");
            if (tenTg == null) {
                return;
            }
            if (tenTg.equals("")) {
                MsgBox.alert_WARNING(this, "Không được để trống");
                return;
            }
            TacGiaDao tgDao = TacGiaDao.getInstance();
            if (!tgDao.selectByKeyWorld(tenTg).isEmpty()) {
                MsgBox.alert_WARNING(this, "Tên tác giả đã tồn tại");
                return;
            }
            TacGia tg = new TacGia(null, tenTg.trim());
            row = tgDao.insert(tg);
        } else {
            String tenTl = MsgBox.prompt(this, "Nhập tên thể loại muốn thêm :0");
            if (tenTl == null) {
                return;
            }
            if (tenTl.equals("")) {
                MsgBox.alert_WARNING(this, "Không được để trống");
                return;
            }
            TheLoaiDao tlDao = TheLoaiDao.getInstance();
            if (!tlDao.selectByKeyWorld(tenTl).isEmpty()) {
                MsgBox.alert_WARNING(this, "Tên thể loại đã tồn tại");
                return;
            }
            TheLoai tg = new TheLoai(null, tenTl.trim());
            row = tlDao.insert(tg);
        }
        if (row > 0) {
            MsgBox.alert_INFORMATION(this, "Update thành công!");
            this.dispose();
        } else {
            MsgBox.alert_ERROR(this, "Update thất bại!");
        }
    }

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
            java.util.logging.Logger.getLogger(ChonTacGiaVaTheLoai_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChonTacGiaVaTheLoai_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChonTacGiaVaTheLoai_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChonTacGiaVaTheLoai_JDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ChonTacGiaVaTheLoai_JDialog dialog = new ChonTacGiaVaTheLoai_JDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
        ChonTacGiaVaTheLoai_JDialog.getInstance().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTacGiaVaTheLoai;
    // End of variables declaration//GEN-END:variables
}
