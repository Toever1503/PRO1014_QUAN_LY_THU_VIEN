/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import DAO.SachDAO;
import DAO.TheLoaiDao;
import Models.HoaDonDenBuChiTiet;
import Models.HoaDonNhapSachChiTiet;
import Models.PhieuMuonChiTiet;
import Models.Sach;
import Models.TheLoai;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
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
    private Map<Integer, List<Sach>> listSach;
    private String ACTION_TYPE;
    private TheLoaiDao theLoaiDao;
    private SachDAO sachDAO;
    private int pageIndex = 0;
    private int total;

    public static void main(String[] args) {
//        Chon_Sach_JDialog.getInstance().show("NHAP_SACH");
        new Chon_Sach_JDialog().setVisible(true);
    }

    /**
     * Creates new form Chon_Sach_JDialog
     */
    private Chon_Sach_JDialog() {
        initComponents();
        setLocationRelativeTo(null);
        theLoaiDao = TheLoaiDao.getInstance();
        sachDAO = SachDAO.getInstance();
        total = sachDAO.getTotal();
        tableModelSach = (DefaultTableModel) tblSach.getModel();
        boxModelTheLoai = (DefaultComboBoxModel) cmbTheLoai.getModel();
//
        listSach = new HashMap<Integer, List<Sach>>();
        fillComboboxTheLoai();
    }

    public static Chon_Sach_JDialog getInstance() {
        if (instance == null) {
            instance = new Chon_Sach_JDialog();
        }
        return instance;
    }

    public void show(String type) {
        setVisible(true);
        ACTION_TYPE = type;
        listSach.clear();
        pageIndex = 0;

        if (ACTION_TYPE == "PHIEU_MUON") {
            listSach.put(pageIndex, sachDAO.selectByPage(Long.valueOf(pageIndex), 1));
            btnReset.setVisible(false);
            jPanelDetailSach.setVisible(false);
        } else if (ACTION_TYPE == "HOA_DON") {
            listSach.put(pageIndex, sachDAO.selectByPage(Long.valueOf(pageIndex), 1));
            btnReset.setVisible(false);
            jPanelDetailSach.setVisible(true);

            lblLoaiSach.setVisible(false);
            lblSoLuong.setVisible(false);
            txtSoLuong.setVisible(false);

            radMoi.setVisible(false);
            radCu.setVisible(false);
        } else {
            listSach.put(pageIndex, sachDAO.selectByPage(Long.valueOf(pageIndex)));
            btnReset.setVisible(false);
            jPanelDetailSach.setVisible(true);

            lblLoaiSach.setVisible(true);
            lblSoLuong.setVisible(true);
            txtSoLuong.setVisible(true);
            txtGia.setEnabled(true);

            radMoi.setVisible(true);
            radCu.setVisible(true);
        }
        fillTableSach(listSach.get(pageIndex));
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
        btnSearch = new javax.swing.JButton();
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

        getContentPane().setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout(10, 15));

        txtSearch.setText("Nh???p T??n S??ch C???n T??m");

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "M?? S??ch", "T??n S??ch"
            }
        ));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSach);
        if (tblSach.getColumnModel().getColumnCount() > 0) {
            tblSach.getColumnModel().getColumn(0).setMaxWidth(100);
        }

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

        btnSearch.setText("T??m");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSachLayout = new javax.swing.GroupLayout(jPanelSach);
        jPanelSach.setLayout(jPanelSachLayout);
        jPanelSachLayout.setHorizontalGroup(
            jPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
            .addGroup(jPanelSachLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSachLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addGap(47, 47, 47))
        );
        jPanelSachLayout.setVerticalGroup(
            jPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSachLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
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
        lblGia.setText("Gi??");
        jPanelDetailSach.add(lblGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblLoaiSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLoaiSach.setText("Lo???i S??ch");
        jPanelDetailSach.add(lblLoaiSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanelDetailSach.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 210, -1));

        txtGia.setEnabled(false);
        jPanelDetailSach.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, -1));

        buttonGroup1.add(radCu);
        radCu.setText("C??");
        jPanelDetailSach.add(radCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        buttonGroup1.add(radMoi);
        radMoi.setSelected(true);
        radMoi.setText("M???i");
        jPanelDetailSach.add(radMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSoLuong.setText("S??? L?????ng");
        jPanelDetailSach.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        lblErrorSoLuong.setText(" ");
        jPanelDetailSach.add(lblErrorSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 210, -1));

        lblErrorGia.setText("  ");
        jPanelDetailSach.add(lblErrorGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 210, -1));

        jPanel1.add(jPanelDetailSach, java.awt.BorderLayout.CENTER);

        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnReset.setText("L??m m???i");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay L???i");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuayLai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelActionChonSachLayout.setVerticalGroup(
            jPanelActionChonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionChonSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelActionChonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelActionChonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnQuayLai)
                        .addComponent(btnThem)
                        .addComponent(btnReset))
                    .addComponent(lblErrorAction))
                .addContainerGap())
        );

        jPanel1.add(jPanelActionChonSach, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        pageIndex = 0;
        fillTableSach(listSach.get(pageIndex));
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (pageIndex + 1 > total) {
            JOptionPane.showMessageDialog(this, "B???n ??ang ??? trang cu???i!");
        } else {
            pageIndex++;
            List<Sach> list = listSach.get(pageIndex);
            if (list == null) {
                if (ACTION_TYPE == "NHAP_SACH") {
                    list = sachDAO.selectByPage(Long.valueOf(pageIndex));
                } else {
                    list = sachDAO.selectByPage(Long.valueOf(pageIndex), 1);
                }
            }
            fillTableSach(list);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (pageIndex - 1 < 0) {
            JOptionPane.showMessageDialog(this, "B???n ??ang ??? trang ?????u!");
        } else {
            pageIndex--;
            List<Sach> list = listSach.get(pageIndex);
            if (list == null) {
                if (ACTION_TYPE == "NHAP_SACH") {
                    list = sachDAO.selectByPage(Long.valueOf(pageIndex));
                } else {
                    list = sachDAO.selectByPage(Long.valueOf(pageIndex), 1);
                }
            }
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        pageIndex = total;
        fillTableSach(listSach.get(pageIndex));
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
        int row = tblSach.getSelectedRow();
        if (row == -1) {
            lblErrorAction.setText("H??y ch???n 1 s??ch c???n th??m!");
        } else {
            Sach sach = listSach.get(pageIndex).get(row);
            if (ACTION_TYPE == "PHIEU_MUON") {

                PhieuMuonChiTiet pmct = new PhieuMuonChiTiet(Long.valueOf(0), sach.getId(), Helper.Auth.user.getMaQL(), null, false);

                if (QLPhieuMuon_JPanel.getInstance().addSachMuon(pmct, sach)) {
                    JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
                } else {
                    JOptionPane.showMessageDialog(this, "S??ch hi???n ???? ???????c th??m!");
                }

            } else if (ACTION_TYPE == "HOA_DON") {
                if (QLHoaDonDenBu.getInstance().addSach(new HoaDonDenBuChiTiet(null, sach.getId(), sach.getGia()), sach.getGia().toString())) {
                    JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
                } else {
                    JOptionPane.showMessageDialog(this, "S??ch hi???n ???? ???????c th??m!");
                }
            } else { //for nhap sach
                HoaDonNhapSachChiTiet hdct = getFormHdct();
                System.out.println("nhapSach->" + hdct);
                if (hdct != null) {
                    hdct.setSach(sach.getId());
                    hdct.setTenSach(sach.getTenSach());
                    if (QLHoaDonNhapSach.getInstance().addSach(hdct, sach.getTenSach())) {
                        JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
                    } else {
                        JOptionPane.showMessageDialog(this, "S??ch hi???n ???? ???????c th??m!");
                    }
                }
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void cmbTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTheLoaiActionPerformed
        // TODO add your handling code here:
        String itemSelected = cmbTheLoai.getSelectedItem() == null ? null : cmbTheLoai.getSelectedItem().toString();
        if (itemSelected != null) {
            Long maTheLoai = Long.valueOf(itemSelected.split("-")[0]);

            List<Sach> listSachByTheLoai = sachDAO.selectAllByTheLoai(maTheLoai);
            fillTableSach(listSachByTheLoai);
        }
    }//GEN-LAST:event_cmbTheLoaiActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        // TODO add your handling code here:
        if (ACTION_TYPE == "HOA_DON" || ACTION_TYPE == "NHAP_SACH") {
            int row = tblSach.getSelectedRow();
            txtGia.setText(listSach.get(pageIndex).get(row).getGia().toString());
            txtSoLuong.setText(null);
            radMoi.setSelected(true);
        }
    }//GEN-LAST:event_tblSachMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(this, "H??y ??i???n th??ng tin s??ch c???n t??m ki???m!");
        } else {
            List<Sach> list = sachDAO.searchByKey(search);
            if (list == null) {
                JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y s??ch!");
            } else {
                fillTableSach(list);
            }
        }


    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
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
        pageIndex = 0;
        fillTableSach(listSach.get(pageIndex));
        cmbTheLoai.setSelectedIndex(0);
        txtGia.setText(null);
        txtSearch.setText(null);
        txtSoLuong.setText(null);
        lblErrorGia.setText(null);
        lblErrorSoLuong.setText(null);
    }

    private void fillTableSach(List<Sach> list) {
        tableModelSach.setRowCount(0);
        System.out.println("runn");
        list.forEach((sach) -> {
            tableModelSach.addRow(new Object[]{
                sach.getId(), sach.getTenSach()
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

    private HoaDonNhapSachChiTiet getFormHdct() {
        HoaDonNhapSachChiTiet hdct = null;
        Integer soLuong = null;
        Double gia = null;
        int check = 0;
        boolean isNew = radMoi.isSelected();

        if (txtSoLuong.getText().isEmpty()) {
            lblErrorSoLuong.setText("S??? l?????ng kh??ng ???????c b??? tr???ng");
        } else {
            try {
                soLuong = Integer.valueOf(txtSoLuong.getText());
                check++;
            } catch (Exception e) {
                e.printStackTrace();
                lblErrorSoLuong.setText("S??? l?????ng ph???i l?? s??? nguy??n");
            }
        }

        if (txtGia.getText().isEmpty()) {
            lblErrorGia.setText("Gi?? kh??ng ???????c b??? tr???ng");
        } else {
            try {
                gia = Double.valueOf(txtGia.getText().replace(".0", ""));
                check++;
            } catch (Exception e) {
                e.printStackTrace();
                lblErrorGia.setText("Gi?? ph???i l?? s??? nguy??n");
            }
        }

        if (check == 2) {
            hdct = new HoaDonNhapSachChiTiet();
            hdct.setGia(gia);
            hdct.setSoLuong(soLuong);
            hdct.setLoaiSach(radMoi.isSelected());
        }
        return hdct;
    }
}
