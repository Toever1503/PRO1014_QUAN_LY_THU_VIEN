/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DAO.TheLoaiDao;
import Models.Sach;
import Models.TheLoai;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haunv
 */
public class Chon_Sach_JDialog extends javax.swing.JDialog {

    private static Chon_Sach_JDialog instance;
    private String type;
    private DefaultTableModel tableModelSach;
    private DefaultComboBoxModel boxModelTheLoai;
    private List<Sach> listSach;
    private int index;
    private String ACTION_TYPE;

    /**
     * Creates new form Chon_Sach_JDialog
     */
    private Chon_Sach_JDialog() {
        initComponents();
        setLocationRelativeTo(null);
        tableModelSach = (DefaultTableModel) tblSach.getModel();
        boxModelTheLoai = (DefaultComboBoxModel) cmbTheLoai.getModel();

        listSach = new ArrayList<Sach>();
        listSach.add(new Sach(BigInteger.ONE, "shiki", "khu 4", new Date(2021, 11, 25), "qr-code", BigInteger.ONE, "chung999", true));
        listSach.add(new Sach(BigInteger.TWO, "shiki1", "khu 4", new Date(2021, 11, 25), "qr-code", BigInteger.ONE, "chung999", true));
        listSach.add(new Sach(BigInteger.TEN, "shiki2", "khu 4", new Date(2021, 11, 25), "qr-code", BigInteger.ONE, "chung999", true));
        listSach.add(new Sach(BigInteger.ONE, "shiki3", "khu 4", new Date(2021, 11, 25), "qr-code", BigInteger.ONE, "chung999", true));
        listSach.add(new Sach(BigInteger.ONE, "shiki4", "khu 4", new Date(2021, 11, 25), "qr-code", BigInteger.ONE, "chung999", true));
        listSach.add(new Sach(BigInteger.ONE, "shiki5", "khu 4", new Date(2021, 11, 25), "qr-code", BigInteger.ONE, "chung999", true));

        fillComboboxTheLoai();
    }

    public static Chon_Sach_JDialog getInstance() {
        return instance == null ? new Chon_Sach_JDialog() : instance;
    }

    public void show(String type) {
        setVisible(true);
        fillTableSach();
        ACTION_TYPE = type;
        if (ACTION_TYPE == "PHIEU_MUON") {
            btnReset.setVisible(false);
            jPanelDetailSach.setVisible(false);
        } else {
            btnReset.setVisible(true);
            jPanelDetailSach.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanelSach = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        cmbTheLoai = new javax.swing.JComboBox<>();
        jPanelDetailSach = new javax.swing.JPanel();
        lblGia = new javax.swing.JLabel();
        lblLoaiSach = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        radCu = new javax.swing.JRadioButton();
        radMoi = new javax.swing.JRadioButton();
        lblSoLuong = new javax.swing.JLabel();
        lblErrorSoLuong = new javax.swing.JLabel();
        lblErrorGia = new javax.swing.JLabel();
        jPanelActionChonSach = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        lblErrorAction = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtSearch.setText("Nhập Tên Sách Cần Tìm");

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Nhà Xuất Bản"
            }
        ));
        jScrollPane1.setViewportView(tblSach);

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/First_button.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/back_button.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/next_button.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/Last_button.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        cmbTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTheLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSachLayout = new javax.swing.GroupLayout(jPanelSach);
        jPanelSach.setLayout(jPanelSachLayout);
        jPanelSachLayout.setHorizontalGroup(
            jPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSachLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast))
            .addGroup(jPanelSachLayout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelSachLayout.setVerticalGroup(
            jPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSachLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap())
        );

        jPanel1.add(jPanelSach, java.awt.BorderLayout.PAGE_START);

        jPanelDetailSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblGia.setText("Giá");
        jPanelDetailSach.add(lblGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        lblLoaiSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoaiSach.setText("Loại Sách");
        jPanelDetailSach.add(lblLoaiSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanelDetailSach.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 160, -1));
        jPanelDetailSach.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 210, -1));

        buttonGroup1.add(radCu);
        radCu.setText("Cũ");
        jPanelDetailSach.add(radCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        buttonGroup1.add(radMoi);
        radMoi.setSelected(true);
        radMoi.setText("Mới");
        jPanelDetailSach.add(radMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSoLuong.setText("Số Lượng");
        jPanelDetailSach.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblErrorSoLuong.setText(" ");
        jPanelDetailSach.add(lblErrorSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 160, -1));

        lblErrorGia.setText("  ");
        jPanelDetailSach.add(lblErrorGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 210, -1));

        jPanel1.add(jPanelDetailSach, java.awt.BorderLayout.CENTER);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        lblErrorAction.setText(" ");

        javax.swing.GroupLayout jPanelActionChonSachLayout = new javax.swing.GroupLayout(jPanelActionChonSach);
        jPanelActionChonSach.setLayout(jPanelActionChonSachLayout);
        jPanelActionChonSachLayout.setHorizontalGroup(
            jPanelActionChonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActionChonSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblErrorAction, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuayLai)
                .addContainerGap())
        );
        jPanelActionChonSachLayout.setVerticalGroup(
            jPanelActionChonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionChonSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelActionChonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelActionChonSachLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelActionChonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuayLai)
                            .addComponent(btnThem)
                            .addComponent(btnReset)))
                    .addComponent(lblErrorAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanelActionChonSach, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
//        index = 
        listSach = null;
        fillTableSach();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        index++;
        listSach = null;
        fillTableSach();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        index--;
        listSach = null;
        fillTableSach();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        index = 0;
        listSach = null;
        fillTableSach();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        if (ACTION_TYPE == "PHIEU_MUON") {
            int row = tblSach.getSelectedRow();
            if (row == -1) {
                lblErrorAction.setText("Hãy chọn 1 sách cần thêm!");
            } else {
                if (QLPhieuMuon_JPanel.getInstance().addSachMuon(new Sach(
                        BigInteger.valueOf(Long.valueOf(tblSach.getValueAt(row, 0).toString())),
                        tblSach.getValueAt(row, 1).toString(),
                        null, null, null, BigInteger.valueOf(Long.valueOf(tblSach.getValueAt(row, 2).toString())), null, false))) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                }
                else
                    JOptionPane.showMessageDialog(this, "Sách hiện đã được thêm!");
            }

        } else {
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cmbTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTheLoaiActionPerformed
        // TODO add your handling code here:
//        Long maTheLoai = Long.valueOf(cmbTheLoai.getSelectedItem().toString().split("-")[0]);
//        listSach = null;
//        fillComboboxTheLoai();
    }//GEN-LAST:event_cmbTheLoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbTheLoai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelActionChonSach;
    private javax.swing.JPanel jPanelDetailSach;
    private javax.swing.JPanel jPanelSach;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorAction;
    private javax.swing.JLabel lblErrorGia;
    private javax.swing.JLabel lblErrorSoLuong;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblLoaiSach;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JRadioButton radCu;
    private javax.swing.JRadioButton radMoi;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        listSach = null;
        fillTableSach();
        cmbTheLoai.setSelectedIndex(0);
        txtGia.setText(null);
        txtSearch.setText(null);
        txtSoLuong.setText(null);
        lblErrorGia.setText(null);
        lblErrorSoLuong.setText(null);
    }

    private void fillTableSach() {
        tableModelSach.setRowCount(0);
        listSach.forEach((sach) -> {

            tableModelSach.addRow(new Object[]{
                sach.getId(), sach.getTenSach(), sach.getNhaXuatBan()
            });
        });
    }

    private void fillComboboxTheLoai() {
        boxModelTheLoai.removeAllElements();
        List<TheLoai> listTheLoai = TheLoaiDao.getInstance().selectALL();
        if (listTheLoai == null) {
            return;
        }
        listTheLoai.forEach((theLoai) -> boxModelTheLoai.addElement(theLoai.getId() + "-" + theLoai.getTenTheLoai()));
    }
}
