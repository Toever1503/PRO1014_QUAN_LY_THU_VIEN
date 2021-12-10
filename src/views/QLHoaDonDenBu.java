/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DAO.HoaDonDenBuChiTietDao;
import DAO.HoaDonDenBuDao;
import DAO.HoiVienDao;
import DAO.SachDAO;
import Models.HoaDonDenBu;
import Models.HoaDonDenBuChiTiet;
import Models.HoiVien;
import Models.Sach;
import java.awt.Image;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLHoaDonDenBu extends javax.swing.JPanel {

    private Map<Integer, List<HoaDonDenBu>> listHoaDonDenBu;
    private Map<Long, HoaDonDenBuChiTiet> listHoaDonChiTiet;
    private DefaultTableModel tableModelHoaDonDenBu;
    private DefaultTableModel tableModelHoaDonDenBuChiTiet;
    private DefaultComboBoxModel boxModelNguoiMuon;
    private int pageIndex = 0;
    private int total;

    HoiVienDao hoiVienDao;
    private SachDAO sachDao;
    private HoaDonDenBuDao hoaDonDenBuDao;
    private HoaDonDenBuChiTietDao hoaDonDenBuChiTietDao;
    private static QLHoaDonDenBu instance;

    /**
     * Creates new form QLHoaDonDenBu
     */
    private QLHoaDonDenBu() {
        initComponents();
        this.init();
    }

    public static QLHoaDonDenBu getInstance() {
        if (instance == null) {
            instance = new QLHoaDonDenBu();
        }
        return instance;
    }

    public void init() {
        tabs.remove(tabCapNhat);
        hoiVienDao = HoiVienDao.getInstance();
        sachDao = SachDAO.getInstance();
        hoaDonDenBuDao = HoaDonDenBuDao.getInstance();
        hoaDonDenBuChiTietDao = HoaDonDenBuChiTietDao.getInstance();
        total = hoaDonDenBuDao.getTotal();

        listHoaDonDenBu = new HashMap<Integer, List<HoaDonDenBu>>();
        listHoaDonChiTiet = new HashMap<Long, HoaDonDenBuChiTiet>();
        listHoaDonDenBu.put(0, hoaDonDenBuDao.selectByPage(Long.valueOf(0)));

        tableModelHoaDonDenBu = (DefaultTableModel) tblHoaDonDenBu.getModel();
        tableModelHoaDonDenBuChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        boxModelNguoiMuon = (DefaultComboBoxModel) cmbNguoiMuon.getModel();

        fillTableHoaDonDenBu(listHoaDonDenBu.get(0));
        fillCmbHoiVien();
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
        tblHoaDonDenBu = new javax.swing.JTable();
        pnlTrang = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        pnlActionHoaDon = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnReload = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        tabCapNhat = new javax.swing.JPanel();
        pnlLeftTabCapNhat = new javax.swing.JPanel();
        pnlAction = new javax.swing.JPanel();
        lblErrorAction = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnChonSach = new javax.swing.JButton();
        btnXoaSach = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jScrollPaneTableSachMuon = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        pnlDetail = new javax.swing.JPanel();
        lblMaHoaDonDenBu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbNguoiMuon = new javax.swing.JComboBox<>();
        lblErrorMaHoaDonDenBu = new javax.swing.JLabel();
        lblErrorNguoiMuon = new javax.swing.JLabel();
        lblErrorTongTien = new javax.swing.JLabel();
        txtMaHoaDonDenBu = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        pnlQrCode = new javax.swing.JPanel();
        btnDownloadQr = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblQR_CODE = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        tabDanhSach.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabDanhSach.setLayout(new java.awt.BorderLayout(10, 10));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHoaDonDenBu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Người Xử Lý", "Tổng Tiền", "Ngày Tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHoaDonDenBu);

        tabDanhSach.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlTrang.setPreferredSize(new java.awt.Dimension(100, 54));
        pnlTrang.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 10));

        jPanel4.setPreferredSize(new java.awt.Dimension(330, 35));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/First_button.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel4.add(btnFirst);

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/back_button.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jPanel4.add(btnPrev);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/next_button.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel4.add(btnNext);

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/Last_button.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel4.add(btnLast);

        pnlTrang.add(jPanel4);

        tabDanhSach.add(pnlTrang, java.awt.BorderLayout.PAGE_END);

        pnlActionHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlActionHoaDon.setPreferredSize(new java.awt.Dimension(648, 85));
        pnlActionHoaDon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 15));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(280, 52));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jPanel5.setPreferredSize(new java.awt.Dimension(254, 28));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btnReload.setText("Làm Mới");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jPanel5.add(btnReload);

        btnChiTiet.setText("Chi Tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        jPanel5.add(btnChiTiet);

        btnThemMoi.setText("Thêm Mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });
        jPanel5.add(btnThemMoi);

        jPanel8.add(jPanel5);

        pnlActionHoaDon.add(jPanel8);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        pnlActionHoaDon.add(jPanel7);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(271, 53));

        btnSearch.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlActionHoaDon.add(jPanel6);

        tabDanhSach.add(pnlActionHoaDon, java.awt.BorderLayout.PAGE_START);

        tabs.addTab("Danh sách", tabDanhSach);

        tabCapNhat.setLayout(new java.awt.BorderLayout());

        pnlLeftTabCapNhat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlLeftTabCapNhat.setPreferredSize(new java.awt.Dimension(400, 400));
        pnlLeftTabCapNhat.setLayout(new java.awt.BorderLayout(10, 10));

        pnlAction.setPreferredSize(new java.awt.Dimension(392, 65));
        pnlAction.setLayout(new java.awt.BorderLayout(0, 10));

        lblErrorAction.setText(" ");
        pnlAction.add(lblErrorAction, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(634, 50));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btnChonSach.setText("Chọn Sách");
        btnChonSach.setPreferredSize(new java.awt.Dimension(100, 40));
        btnChonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSachActionPerformed(evt);
            }
        });
        jPanel1.add(btnChonSach);

        btnXoaSach.setText("Xóa Sách");
        btnXoaSach.setPreferredSize(new java.awt.Dimension(100, 40));
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoaSach);

        btnReset.setText("Làm Mới");
        btnReset.setPreferredSize(new java.awt.Dimension(100, 40));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset);

        btnSave.setText("Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(100, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.setPreferredSize(new java.awt.Dimension(100, 40));
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuayLai);

        pnlAction.add(jPanel1, java.awt.BorderLayout.CENTER);

        pnlLeftTabCapNhat.add(pnlAction, java.awt.BorderLayout.PAGE_END);

        jScrollPaneTableSachMuon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTableSachMuon.setViewportView(tblHoaDonChiTiet);

        pnlLeftTabCapNhat.add(jScrollPaneTableSachMuon, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 10));

        pnlDetail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDetail.setPreferredSize(new java.awt.Dimension(450, 228));
        pnlDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaHoaDonDenBu.setText("Hóa Đơn");
        pnlDetail.add(lblMaHoaDonDenBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        jLabel2.setText("Hội viên");
        pnlDetail.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));

        txtTongTien.setEnabled(false);
        pnlDetail.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 290, -1));

        jLabel3.setText("Tổng tiền");
        pnlDetail.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        cmbNguoiMuon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlDetail.add(cmbNguoiMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 290, 25));

        lblErrorMaHoaDonDenBu.setText(" ");
        pnlDetail.add(lblErrorMaHoaDonDenBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 290, -1));

        lblErrorNguoiMuon.setText(" ");
        pnlDetail.add(lblErrorNguoiMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 290, -1));

        lblErrorTongTien.setText(" ");
        pnlDetail.add(lblErrorTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 290, -1));

        txtMaHoaDonDenBu.setEnabled(false);
        pnlDetail.add(txtMaHoaDonDenBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 290, -1));

        jPanel3.add(pnlDetail);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlQrCode.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlQrCode.setLayout(new java.awt.BorderLayout(0, 10));

        btnDownloadQr.setText("print");
        btnDownloadQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadQrActionPerformed(evt);
            }
        });
        pnlQrCode.add(btnDownloadQr, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());

        lblQR_CODE.setText(" ");
        jPanel2.add(lblQR_CODE, java.awt.BorderLayout.CENTER);

        pnlQrCode.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlQrCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlQrCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel9);

        pnlLeftTabCapNhat.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        tabCapNhat.add(pnlLeftTabCapNhat, java.awt.BorderLayout.CENTER);

        tabs.addTab("Cập nhật", tabCapNhat);

        add(tabs, java.awt.BorderLayout.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ HÓA ĐƠN ĐỀN BÙ");
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 100));
        add(jLabel9, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDownloadQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadQrActionPerformed
        // TODO add your handling code here:
        HoaDonDenBu hoaDonDenBu = hoaDonDenBuDao.selectByID(Long.valueOf(txtMaHoaDonDenBu.getText()));
    }//GEN-LAST:event_btnDownloadQrActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (listHoaDonChiTiet.size() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy thêm sách cần đền bù");
        } else {
            //save
            HoaDonDenBu hoaDonDenBu = getForm();

            System.out.println("insert hoaDonDenBu->" + hoaDonDenBu);
            System.out.println("HoaDonDenBu Detail->" + listHoaDonChiTiet.size());

            if (hoaDonDenBu.getId() == null) {
                Long id = Long.valueOf(hoaDonDenBuDao.insertOnUpdate(hoaDonDenBu));
                if (id <= 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                    return;
                } else {
                    String keyData = hoaDonDenBu.getQr_code().split("-")[1];
                    if (!Helper.QR_CODE.generateQRcode(keyData, Helper.XImage.HOADON_UPLOAD.concat("/" + keyData + ".png"))) {
                        JOptionPane.showMessageDialog(this, "Không thể khởi tạo mã Qr-code");
                    }
                    InsertOnUpdateListHoaDenChiTiet(hoaDonDenBu.getId());
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    hoaDonDenBu.setId(id);
                    txtMaHoaDonDenBu.setText(id.toString());
                    pageIndex = 0;
                    listHoaDonDenBu.clear();
                    listHoaDonDenBu.put(pageIndex, hoaDonDenBuDao.selectByPage(Long.valueOf(pageIndex)));

                }
            } else {
                if (hoaDonDenBuDao.insertOnUpdate(hoaDonDenBu) <= 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                    return;
                } else {
                    InsertOnUpdateListHoaDenChiTiet(hoaDonDenBu.getId());
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    hoaDonDenBu = hoaDonDenBuDao.selectByID(hoaDonDenBu.getId());
                    List<HoaDonDenBu> list = listHoaDonDenBu.get(pageIndex);
                    for (int i = 0; i < list.size(); ++i) {
                        if (list.get(i).getId().equals(hoaDonDenBu.getId())) {
                            list.set(i, hoaDonDenBu);
                            break;
                        }
                    }
                    listHoaDonDenBu.replace(pageIndex, list);
                    fillTableHoaDonDenBu(listHoaDonDenBu.get(pageIndex));
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnChonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSachActionPerformed
        // TODO add your handling code here:
        Chon_Sach_JDialog.getInstance().show("HOA_DON");
    }//GEN-LAST:event_btnChonSachActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        pageIndex = total;
        List<HoaDonDenBu> list = listHoaDonDenBu.get(pageIndex);
        if (list == null) {
            listHoaDonDenBu.put(pageIndex, hoaDonDenBuDao.selectByPage(Long.valueOf(pageIndex)));
        }
        fillTableHoaDonDenBu(listHoaDonDenBu.get(pageIndex));
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (pageIndex + 1 > total) {
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang cuối!");
        } else {
            pageIndex++;
            List<HoaDonDenBu> list = listHoaDonDenBu.get(pageIndex);
            if (list == null) {
                listHoaDonDenBu.put(pageIndex, hoaDonDenBuDao.selectByPage(Long.valueOf(pageIndex)));
            }
            fillTableHoaDonDenBu(listHoaDonDenBu.get(pageIndex));
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (pageIndex - 1 < 0) {
            JOptionPane.showMessageDialog(this, "Bạn đã ở tranđầug !");
        } else {
            pageIndex--;
            List<HoaDonDenBu> list = listHoaDonDenBu.get(pageIndex);
            if (list == null) {
                listHoaDonDenBu.put(pageIndex, hoaDonDenBuDao.selectByPage(Long.valueOf(pageIndex)));
            }
            fillTableHoaDonDenBu(listHoaDonDenBu.get(pageIndex));
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        pageIndex = 0;
        fillTableHoaDonDenBu(listHoaDonDenBu.get(pageIndex));
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
        activeTabCapNhat();
        if (listHoaDonChiTiet.size() > 0)
            listHoaDonChiTiet.clear();
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDonDenBu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 hóa đơn cần xem!");
        } else {
            setForm(listHoaDonDenBu.get(pageIndex).get(row));
            activeTabCapNhat();
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSachActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDonChiTiet.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sách cần xóa!");
        } else {
            long maSach = Long.valueOf(tblHoaDonChiTiet.getValueAt(row, 0).toString());
            listHoaDonChiTiet.remove(maSach);
            tableModelHoaDonDenBuChiTiet.removeRow(row);
            tinhTongTien();;
        }
    }//GEN-LAST:event_btnXoaSachActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        tabs.remove(tabCapNhat);
        tabs.setSelectedIndex(0);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        pageIndex = 0;
        fillTableHoaDonDenBu(listHoaDonDenBu.get(0));
    }//GEN-LAST:event_btnReloadActionPerformed

    public void activeTabCapNhat() {
        tabs.add(tabCapNhat, "Cập Nhật");
        tabs.setSelectedIndex(1);
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
    private javax.swing.JButton btnDownloadQr;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXoaSach;
    private javax.swing.JComboBox<String> cmbNguoiMuon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneTableSachMuon;
    private javax.swing.JLabel lblErrorAction;
    private javax.swing.JLabel lblErrorMaHoaDonDenBu;
    private javax.swing.JLabel lblErrorNguoiMuon;
    private javax.swing.JLabel lblErrorTongTien;
    private javax.swing.JLabel lblMaHoaDonDenBu;
    private javax.swing.JLabel lblQR_CODE;
    private javax.swing.JPanel pnlAction;
    private javax.swing.JPanel pnlActionHoaDon;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlLeftTabCapNhat;
    private javax.swing.JPanel pnlQrCode;
    private javax.swing.JPanel pnlTrang;
    private javax.swing.JPanel tabCapNhat;
    private javax.swing.JPanel tabDanhSach;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblHoaDonDenBu;
    private javax.swing.JTextField txtMaHoaDonDenBu;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
    public void fillTableHoaDonDenBu(List<HoaDonDenBu> list) {
        if (listHoaDonDenBu == null) {
            return;
        }
        tableModelHoaDonDenBu.setRowCount(0);
        list.forEach((hoaDon) -> {
            tableModelHoaDonDenBu.addRow(new Object[]{hoaDon.getId(),
                hoaDon.getNguoiXuLy(), hoaDon.getTongTien(), hoaDon.getNgayTao()});
        });
    }

    public HoaDonDenBu getForm() {
        Long maHoaDonDenBu = txtMaHoaDonDenBu.getText().isEmpty() ? null : Long.valueOf(txtMaHoaDonDenBu.getText());
        String nguoiMuon = cmbNguoiMuon.getSelectedItem() == null ? null : cmbNguoiMuon.getSelectedItem().toString().split("-")[0];
        Double tongTien = txtTongTien.getText().isEmpty() ? 0 : Double.valueOf(txtTongTien.getText());

        Long timeNow = Calendar.getInstance().getTimeInMillis();

        HoaDonDenBu hoaDonDenBu = new HoaDonDenBu();
        hoaDonDenBu.setId(maHoaDonDenBu);
        hoaDonDenBu.setNguoiMuon(Long.valueOf(nguoiMuon));
        hoaDonDenBu.setNguoiXuLy(Helper.Auth.user.getMaQL());
        hoaDonDenBu.setNgayTao(new Date(timeNow));
        hoaDonDenBu.setTongTien(tongTien);
        if (maHoaDonDenBu == null) {
            hoaDonDenBu.setQr_code("hoadon-" + timeNow.toString());
        } else {
            hoaDonDenBu.setQr_code(listHoaDonDenBu.get(pageIndex).get(tblHoaDonDenBu.getSelectedRow()).getQr_code());
        }

        return hoaDonDenBu;
    }

    public void setForm(HoaDonDenBu hoaDonDenBu) {
        txtMaHoaDonDenBu.setText(String.valueOf(hoaDonDenBu.getId()));
        txtTongTien.setText(hoaDonDenBu.getTongTien().toString());
        for (int i = cmbNguoiMuon.getItemCount() - 1; i >= 0; --i) {
            if (cmbNguoiMuon.getItemAt(i).toString().split("-")[0].equals(hoaDonDenBu.getNguoiMuon().toString())) {
                cmbNguoiMuon.setSelectedIndex(i);
                break;
            }
        }

        tableModelHoaDonDenBuChiTiet.setRowCount(0);
        new Thread() {
            @Override
            public void run() {
                hoaDonDenBu.setListhBuChiTiets(HoaDonDenBuChiTietDao.getInstance().selectALLByHoaDonDenBu(hoaDonDenBu.getId()));
                if (hoaDonDenBu.getListhBuChiTiets() != null) {

                    hoaDonDenBu.getListhBuChiTiets().forEach((hdct) -> {
                        listHoaDonChiTiet.put(hdct.getSach(), hdct);
                        Sach sach = sachDao.selectByID(hdct.getSach());
                        tableModelHoaDonDenBuChiTiet.addRow(new Object[]{
                            sach.getId(),
                            sach.getTenSach(),
                            sach.getGia()
                        });
                    });
                }
            }
        }.start();;

        if (hoaDonDenBu.getQr_code() != null) {
            try {
                lblQR_CODE.setIcon(new ImageIcon(
                        new ImageIcon(Helper.XImage.HOADON_UPLOAD.concat("/" + hoaDonDenBu.getQr_code().split("-")[1] + ".png"))
                                .getImage()
                                .getScaledInstance(195, 210,
                                        Image.SCALE_DEFAULT)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        btnDownloadQr.setVisible(true);
    }

    public boolean addSach(HoaDonDenBuChiTiet hdct, String tenSach) {
        long key = hdct.getSach();
        if (!listHoaDonChiTiet.containsKey(key)) {
            listHoaDonChiTiet.put(key, hdct);
            tableModelHoaDonDenBuChiTiet.addRow(new Object[]{
                key,
                tenSach,
                hdct.getGia()
            });
            tinhTongTien();
            return true;
        }
        return false;
    }

    public void tinhTongTien() {
        double tongTien = 0;
        for (long key : listHoaDonChiTiet.keySet()) {
            HoaDonDenBuChiTiet hdct = listHoaDonChiTiet.get(key);
            tongTien += hdct.getGia();
        }
        txtTongTien.setText(String.valueOf(tongTien));
    }

    public void resetForm() {
        tableModelHoaDonDenBuChiTiet.setRowCount(0);
        listHoaDonChiTiet.clear();
        txtMaHoaDonDenBu.setText(null);
        txtTongTien.setText(null);
        cmbNguoiMuon.setSelectedIndex(0);
        lblQR_CODE.setIcon(null);
        btnDownloadQr.setVisible(false);
        btnSave.setText("Thêm");
    }

    private void fillCmbHoiVien() {
        boxModelNguoiMuon.removeAllElements();
        List<HoiVien> listHoiViens = hoiVienDao.selectALL();
        if (listHoiViens != null) {
            listHoiViens.forEach((nm) -> boxModelNguoiMuon.addElement(nm.getId() + "-" + nm.getFullName()));
        }
    }

    private void InsertOnUpdateListHoaDenChiTiet(Long id) {
        listHoaDonChiTiet.forEach((x, hdct) -> {
            hdct.setHoaDonDenBu(id);
            new Thread() {
                @Override
                public void run() {
                    hoaDonDenBuChiTietDao.insert(hdct);
                }
            }.start();
        });
    }

    public void showHoaDon(String data) {
        HoaDonDenBu hoaDonDenBu = hoaDonDenBuDao.findByQR("sach-".concat(data));
        if (hoaDonDenBu != null) {
            btnSave.setText("Lưu");
            setForm(hoaDonDenBu);
            activeTabCapNhat();
            Home_Frame.getInstance().activePanel("QLHOADONDENBU");
        }
    }

}
