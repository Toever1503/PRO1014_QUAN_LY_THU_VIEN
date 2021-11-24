/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Helper.Auth;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class QLHoaDonDenBu extends javax.swing.JPanel {
    
    /**
     * Creates new form QLHoaDonDenBu
     */
    public QLHoaDonDenBu() {
        initComponents();
        tabs.remove(tabCapNhat);
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        tabDanhSach = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSQuanLyHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnThemMoi = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        cmb = new javax.swing.JComboBox<>();
        tabCapNhat = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSaveQR = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtHoiVien = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnChonSach = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCNQuanLyHoaDon = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        tabDanhSach.setLayout(new java.awt.BorderLayout());

        tblDSQuanLyHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Sách", "Nhà xuất bản", "Tác Giả", "Thể loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDSQuanLyHoaDon);

        tabDanhSach.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/Last_button.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/next_button.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/back_button.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/First_button.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tabDanhSach.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel9.setPreferredSize(new java.awt.Dimension(648, 50));

        btnTimKiem.setText("Tìm kiếm");

        btnThemMoi.setText("Thêm Mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnChiTiet.setText("Chi Tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChiTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTiet)
                    .addComponent(btnThemMoi)
                    .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tabDanhSach.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        tabs.addTab("Danh sách", tabDanhSach);

        tabCapNhat.setLayout(new java.awt.BorderLayout());

        btnSaveQR.setText("Save QR");
        btnSaveQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveQRActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnSaveQR)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnSaveQR)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tabCapNhat.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel7.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel7.setLayout(new java.awt.BorderLayout(10, 10));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 14, -1, -1));

        jLabel2.setText("Hội viên");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        txtID.setText(" ");
        txtID.setEnabled(false);
        jPanel4.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 11, 154, -1));

        txtHoiVien.setText(" ");
        jPanel4.add(txtHoiVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 49, 154, -1));

        txtNgayTao.setText(" ");
        jPanel4.add(txtNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 11, 154, -1));

        txtTongTien.setText(" ");
        jPanel4.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 49, 154, -1));

        jLabel4.setText("Ngày tạo");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 14, -1, -1));

        jLabel3.setText("Tổng tiền");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 52, -1, -1));

        jPanel7.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setPreferredSize(new java.awt.Dimension(392, 60));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 15));

        btnChonSach.setText("Chọn Sách");
        btnChonSach.setPreferredSize(new java.awt.Dimension(100, 30));
        btnChonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSachActionPerformed(evt);
            }
        });
        jPanel5.add(btnChonSach);

        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(100, 30));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel5.add(btnThem);

        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel5.add(btnSua);

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel5.add(btnQuayLai);

        jPanel7.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        tblCNQuanLyHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Thể Loại", "Nhà Xuất Bản"
            }
        ));
        jScrollPane1.setViewportView(tblCNQuanLyHoaDon);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabCapNhat.add(jPanel7, java.awt.BorderLayout.CENTER);

        tabs.addTab("Cập nhật", tabCapNhat);

        add(tabs, java.awt.BorderLayout.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ HÓA ĐƠN ĐỀN BÙ");
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 100));
        add(jLabel9, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveQRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveQRActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (checkNullText(txtHoiVien)&&checkNullText(txtNgayTao)
                &&checkNullText(txtTongTien)){
            
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonSachActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        activeTabCapNhat();
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        activeTabCapNhat();
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (Auth.user.getVaiTro()) {
            if (checkNullText(txtHoiVien)&&checkNullText(txtNgayTao)
                &&checkNullText(txtTongTien)){
            
            }
        }else{
            JOptionPane.showMessageDialog(this, "Chỉ admin mới được sửa");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    public void activeTabCapNhat(){
        tabs.add(tabCapNhat, "Cập Nhật");
        tabs.setSelectedIndex(1);
    }
    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setSize(900, 600);
       // frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.add(new QLHoaDonDenBu());
        frame.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnChonSach;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnSaveQR;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tabCapNhat;
    private javax.swing.JPanel tabDanhSach;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblCNQuanLyHoaDon;
    private javax.swing.JTable tblDSQuanLyHoaDon;
    private javax.swing.JTextField txtHoiVien;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
