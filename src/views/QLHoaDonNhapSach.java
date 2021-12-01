/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DAO.HoaDonDenBuChiTietDao;
import DAO.HoaDonDenBuDao;
import DAO.HoaDonNhapSachChiTietDao;
import DAO.HoaDonNhapSachDao;
import DAO.HoiVienDao;
import DAO.SachDAO;
import Models.HoaDonDenBu;
import Models.HoaDonDenBuChiTiet;
import Models.HoaDonNhapSach;
import Models.HoaDonNhapSachChiTiet;
import Models.HoiVien;
import Models.Sach;
import java.awt.Image;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLHoaDonNhapSach extends javax.swing.JPanel {

    private Map<Integer, List<HoaDonNhapSach>> listHoaDonNhapSach;
    private Map<Long, HoaDonNhapSachChiTiet> listHoaDonNhapSachChiTiet;
    private DefaultTableModel tableModelHoaDonNhapSach;
    private DefaultTableModel tableModelHoaDonNhapSachChiTiet;
    private int pageIndex = 0;
    private int total;

    HoiVienDao hoiVienDao;
    private SachDAO sachDao;
    private HoaDonNhapSachDao hoaDonNhapSachDao;
    private HoaDonNhapSachChiTietDao hoaDonNhapSachDaoChiTietDao;
    private static QLHoaDonNhapSach instance;

    /**
     * Creates new form QLHoaDonDenBu
     */
    private QLHoaDonNhapSach() {
        initComponents();
        this.init();
    }

    public static QLHoaDonNhapSach getInstance() {
        if (instance == null) {
            instance = new QLHoaDonNhapSach();
        }
        return instance;
    }

    public void init() {
        tabs.remove(tabCapNhat);
        hoiVienDao = HoiVienDao.getInstance();
        sachDao = SachDAO.getInstance();
        hoaDonNhapSachDao = HoaDonNhapSachDao.getInstance();
        hoaDonNhapSachDaoChiTietDao = HoaDonNhapSachChiTietDao.getInstance();
        total = hoaDonNhapSachDao.getTotal();

        listHoaDonNhapSach = new HashMap<Integer, List<HoaDonNhapSach>>();
        listHoaDonNhapSachChiTiet = new HashMap<Long, HoaDonNhapSachChiTiet>();
        listHoaDonNhapSach.put(0, hoaDonNhapSachDao.selectByPage(Long.valueOf(0)));

        tableModelHoaDonNhapSach = (DefaultTableModel) tblHoaDonDenBu.getModel();
        tableModelHoaDonNhapSachChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();

        fillTableHoaDonDenBu(listHoaDonNhapSach.get(pageIndex));
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
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        pnlActionHoaDon = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnThemMoi = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        tabCapNhat = new javax.swing.JPanel();
        pnlQrCode = new javax.swing.JPanel();
        btnDownloadQr = new javax.swing.JButton();
        lblQR_CODE = new javax.swing.JLabel();
        pnlLeftTabCapNhat = new javax.swing.JPanel();
        pnlDetail = new javax.swing.JPanel();
        lblMaHoaDonDenBu = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblErrorMaHoaDonDenBu = new javax.swing.JLabel();
        lblErrorNguoiMuon = new javax.swing.JLabel();
        lblErrorTongTien = new javax.swing.JLabel();
        txtMaHoaDonDenBu = new javax.swing.JTextField();
        pnlAction = new javax.swing.JPanel();
        btnChonSach = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        btnXoaSach = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblErrorAction = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jScrollPaneTableSachMuon = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        tabDanhSach.setLayout(new java.awt.BorderLayout());

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

        pnlTrang.setPreferredSize(new java.awt.Dimension(100, 100));

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

        javax.swing.GroupLayout pnlTrangLayout = new javax.swing.GroupLayout(pnlTrang);
        pnlTrang.setLayout(pnlTrangLayout);
        pnlTrangLayout.setHorizontalGroup(
            pnlTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTrangLayout.createSequentialGroup()
                .addContainerGap(519, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addContainerGap())
        );
        pnlTrangLayout.setVerticalGroup(
            pnlTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTrangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tabDanhSach.add(pnlTrang, java.awt.BorderLayout.PAGE_END);

        pnlActionHoaDon.setPreferredSize(new java.awt.Dimension(648, 50));

        btnSearch.setText("Tìm kiếm");

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

        btnReload.setText("Làm Mới");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlActionHoaDonLayout = new javax.swing.GroupLayout(pnlActionHoaDon);
        pnlActionHoaDon.setLayout(pnlActionHoaDonLayout);
        pnlActionHoaDonLayout.setHorizontalGroup(
            pnlActionHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActionHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChiTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        pnlActionHoaDonLayout.setVerticalGroup(
            pnlActionHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActionHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlActionHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTiet)
                    .addComponent(btnThemMoi)
                    .addComponent(btnReload))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tabDanhSach.add(pnlActionHoaDon, java.awt.BorderLayout.PAGE_START);

        tabs.addTab("Danh sách", tabDanhSach);

        tabCapNhat.setLayout(new java.awt.BorderLayout());

        btnDownloadQr.setText("print");
        btnDownloadQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadQrActionPerformed(evt);
            }
        });

        lblQR_CODE.setText(" ");

        javax.swing.GroupLayout pnlQrCodeLayout = new javax.swing.GroupLayout(pnlQrCode);
        pnlQrCode.setLayout(pnlQrCodeLayout);
        pnlQrCodeLayout.setHorizontalGroup(
            pnlQrCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQrCodeLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(btnDownloadQr)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQrCodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQR_CODE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlQrCodeLayout.setVerticalGroup(
            pnlQrCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQrCodeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQR_CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDownloadQr)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        tabCapNhat.add(pnlQrCode, java.awt.BorderLayout.LINE_END);

        pnlLeftTabCapNhat.setPreferredSize(new java.awt.Dimension(400, 400));
        pnlLeftTabCapNhat.setLayout(new java.awt.BorderLayout(10, 10));

        pnlDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaHoaDonDenBu.setText("Hóa Đơn");
        pnlDetail.add(lblMaHoaDonDenBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        txtTongTien.setEnabled(false);
        pnlDetail.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 190, -1));

        jLabel3.setText("Tổng tiền");
        pnlDetail.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblErrorMaHoaDonDenBu.setText(" ");
        pnlDetail.add(lblErrorMaHoaDonDenBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 180, -1));

        lblErrorNguoiMuon.setText(" ");
        pnlDetail.add(lblErrorNguoiMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 180, -1));

        lblErrorTongTien.setText(" ");
        pnlDetail.add(lblErrorTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 190, -1));

        txtMaHoaDonDenBu.setEnabled(false);
        pnlDetail.add(txtMaHoaDonDenBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 190, -1));

        pnlLeftTabCapNhat.add(pnlDetail, java.awt.BorderLayout.PAGE_START);

        pnlAction.setPreferredSize(new java.awt.Dimension(392, 60));
        pnlAction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChonSach.setText("Chọn Sách");
        btnChonSach.setPreferredSize(new java.awt.Dimension(100, 30));
        btnChonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSachActionPerformed(evt);
            }
        });
        pnlAction.add(btnChonSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.setPreferredSize(new java.awt.Dimension(100, 30));
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });
        pnlAction.add(btnQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, 30));

        btnXoaSach.setText("Xóa Sách");
        btnXoaSach.setPreferredSize(new java.awt.Dimension(100, 30));
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });
        pnlAction.add(btnXoaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 30));

        btnSave.setText("Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlAction.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, 30));

        lblErrorAction.setText(" ");
        pnlAction.add(lblErrorAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 370, 10));

        btnReset.setText("Làm Mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        pnlAction.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, 30));

        pnlLeftTabCapNhat.add(pnlAction, java.awt.BorderLayout.PAGE_END);

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Giá", "Số Lượng", "Loại Sách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTableSachMuon.setViewportView(tblHoaDonChiTiet);
        if (tblHoaDonChiTiet.getColumnModel().getColumnCount() > 0) {
            tblHoaDonChiTiet.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        pnlLeftTabCapNhat.add(jScrollPaneTableSachMuon, java.awt.BorderLayout.CENTER);

        tabCapNhat.add(pnlLeftTabCapNhat, java.awt.BorderLayout.CENTER);

        tabs.addTab("Cập nhật", tabCapNhat);

        add(tabs, java.awt.BorderLayout.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ NHẬP SÁCH");
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 100));
        add(jLabel9, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDownloadQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadQrActionPerformed
        // TODO add your handling code here:
//        HoaDonDenBu hoaDonDenBu = hoaDonDenBuDao.selectByID(Long.valueOf(txtMaHoaDonDenBu.getText()));
    }//GEN-LAST:event_btnDownloadQrActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (listHoaDonNhapSachChiTiet.size() == 0) {
            JOptionPane.showMessageDialog(this, "Hãy thêm sách cần đền bù");
        } else {
            //save
            HoaDonNhapSach hoaDonNhapSach = getForm();

            System.out.println("insert hoaDonDenBu->" + hoaDonNhapSach);
            System.out.println("HoaDonDenBu Detail->" + listHoaDonNhapSachChiTiet.size());

            if (hoaDonNhapSach.getId() == null) {
                Long id = Long.valueOf(hoaDonNhapSachDao.insertOnUpdate(hoaDonNhapSach));
                if (id <= 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                    return;
                } else {
                    String keyData = hoaDonNhapSach.getQr_code().split("-")[1];
                    if (!Helper.QR_CODE.generateQRcode(keyData, Helper.XImage.HOADON_UPLOAD.concat("/" + keyData + ".png"))) {
                        JOptionPane.showMessageDialog(this, "Không thể khởi tạo mã Qr-code");
                    }
                    InsertOnUpdateListHoaNhapChiTiet(hoaDonNhapSach.getId());
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                    hoaDonNhapSach.setId(id);
                    txtMaHoaDonDenBu.setText(id.toString());
                    pageIndex = 0;
                    listHoaDonNhapSach.clear();
                    listHoaDonNhapSach.put(pageIndex, hoaDonNhapSachDao.selectByPage(Long.valueOf(pageIndex)));

                }
            } else {
                if (hoaDonNhapSachDao.insertOnUpdate(hoaDonNhapSach) <= 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                    return;
                } else {
                    InsertOnUpdateListHoaNhapChiTiet(hoaDonNhapSach.getId());
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");

                    hoaDonNhapSach = hoaDonNhapSachDao.selectByID(hoaDonNhapSach.getId());

                    List<HoaDonNhapSach> list = listHoaDonNhapSach.get(pageIndex);
                    for (int i = 0; i < list.size(); ++i) {
                        if (list.get(i).getId().equals(hoaDonNhapSach.getId())) {
                            list.set(i, hoaDonNhapSach);
                            break;
                        }
                    }
                    listHoaDonNhapSach.replace(pageIndex, list);
                    fillTableHoaDonDenBu(listHoaDonNhapSach.get(pageIndex));
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnChonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSachActionPerformed
        // TODO add your handling code here:
        Chon_Sach_JDialog.getInstance().show("NHAP_SACH");
    }//GEN-LAST:event_btnChonSachActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        pageIndex = total;
        List<HoaDonNhapSach> list = listHoaDonNhapSach.get(pageIndex);
        if (list == null) {
            listHoaDonNhapSach.put(pageIndex, hoaDonNhapSachDao.selectByPage(Long.valueOf(pageIndex)));
        }
        fillTableHoaDonDenBu(listHoaDonNhapSach.get(pageIndex));
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (pageIndex + 1 > total) {
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang cuối!");
        } else {
            pageIndex++;
            List<HoaDonNhapSach> list = listHoaDonNhapSach.get(pageIndex);
            if (list == null) {
                listHoaDonNhapSach.put(pageIndex, hoaDonNhapSachDao.selectByPage(Long.valueOf(pageIndex)));
            }
            fillTableHoaDonDenBu(listHoaDonNhapSach.get(pageIndex));
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (pageIndex - 1 < 0) {
            JOptionPane.showMessageDialog(this, "Bạn đã ở tranđầug !");
        } else {
            pageIndex--;
            List<HoaDonNhapSach> list = listHoaDonNhapSach.get(pageIndex);
            if (list == null) {
                listHoaDonNhapSach.put(pageIndex, hoaDonNhapSachDao.selectByPage(Long.valueOf(pageIndex)));
            }
            fillTableHoaDonDenBu(listHoaDonNhapSach.get(pageIndex));
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        pageIndex = 0;
        fillTableHoaDonDenBu(listHoaDonNhapSach.get(pageIndex));
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        resetForm();
        activeTabCapNhat();
        if (listHoaDonNhapSachChiTiet.size() > 0)
            listHoaDonNhapSachChiTiet.clear();
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDonDenBu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 hóa đơn cần xem!");
        } else {
            setForm(listHoaDonNhapSach.get(pageIndex).get(row));
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
            listHoaDonNhapSachChiTiet.remove(maSach);
            tableModelHoaDonNhapSachChiTiet.removeRow(row);
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
        fillTableHoaDonDenBu(listHoaDonNhapSach.get(0));
    }//GEN-LAST:event_btnReloadActionPerformed

    public void activeTabCapNhat() {
        tabs.add(tabCapNhat, "Cập Nhật");
        tabs.setSelectedIndex(1);
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setSize(900, 600);
        // frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.add(new QLHoaDonNhapSach());
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
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
    public void fillTableHoaDonDenBu(List<HoaDonNhapSach> list) {
        if (list == null) {
            return;
        }
        tableModelHoaDonNhapSach.setRowCount(0);
        list.forEach((hoaDon) -> {
            tableModelHoaDonNhapSach.addRow(new Object[]{hoaDon.getId(),
                hoaDon.getNguoiXuLy(), hoaDon.getTongTien(), hoaDon.getNgayTao()});
        });
    }

    public HoaDonNhapSach getForm() {
        Long maHoaDonDenBu = txtMaHoaDonDenBu.getText().isEmpty() ? null : Long.valueOf(txtMaHoaDonDenBu.getText());
        Double tongTien = txtTongTien.getText().isEmpty() ? 0 : Double.valueOf(txtTongTien.getText());

        Long timeNow = Calendar.getInstance().getTimeInMillis();

        HoaDonNhapSach hoaDonNhapSach = new HoaDonNhapSach();
        hoaDonNhapSach.setId(maHoaDonDenBu);
        hoaDonNhapSach.setNguoiXuLy(Helper.Auth.user.getMaQL());
        hoaDonNhapSach.setNgayTao(new Date(timeNow));
        hoaDonNhapSach.setTongTien(tongTien);
        if (maHoaDonDenBu == null) {
            hoaDonNhapSach.setQr_code("hoadon-" + timeNow.toString());
        } else {
            hoaDonNhapSach.setQr_code(listHoaDonNhapSach.get(pageIndex).get(tblHoaDonDenBu.getSelectedRow()).getQr_code());
        }

        return hoaDonNhapSach;
    }

    public void setForm(HoaDonNhapSach hoaDonNhapSach) {
        txtMaHoaDonDenBu.setText(String.valueOf(hoaDonNhapSach.getId()));
        txtTongTien.setText(hoaDonNhapSach.getTongTien().toString());

        tableModelHoaDonNhapSachChiTiet.setRowCount(0);
        new Thread() {
            @Override
            public void run() {
                hoaDonNhapSach.setListHoaDonNhapSachChiTiets(hoaDonNhapSachDaoChiTietDao.selectALLByHoaDon(hoaDonNhapSach.getId()));
                if (hoaDonNhapSach.getListHoaDonNhapSachChiTiets() != null) {

                    hoaDonNhapSach.getListHoaDonNhapSachChiTiets().forEach((hdct) -> {
                        listHoaDonNhapSachChiTiet.put(hdct.getSach(), hdct);
                        Sach sach = sachDao.selectByID(hdct.getSach());
                        tableModelHoaDonNhapSachChiTiet.addRow(new Object[]{
                            sach.getId(),
                            sach.getTenSach(),
                            hdct.getGia(),
                            hdct.getSoLuong(),
                            hdct.getLoaiSach() ? "Sách Mới" : "Sách Cũ"
                        });
                    });
                }
            }
        }.start();;

        if (hoaDonNhapSach.getQr_code() != null) {
            try {
                lblQR_CODE.setIcon(new ImageIcon(
                        new ImageIcon(Helper.XImage.HOADON_UPLOAD.concat("/" + hoaDonNhapSach.getQr_code().split("-")[1] + ".png"))
                                .getImage()
                                .getScaledInstance(195, 210,
                                        Image.SCALE_DEFAULT)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        btnDownloadQr.setVisible(true);
    }

    public boolean addSach(HoaDonNhapSachChiTiet hdct, String tenSach) {
        long key = hdct.getSach();
        if (!listHoaDonNhapSachChiTiet.containsKey(key)) {
            listHoaDonNhapSachChiTiet.put(key, hdct);
            tableModelHoaDonNhapSachChiTiet.addRow(new Object[]{
                key,
                tenSach,
                hdct.getGia(),
                hdct.getSoLuong(),
                hdct.getLoaiSach() ? "Sách Mới" : "Sách Cũ"
            });
            tinhTongTien();
            return true;
        }
        return false;
    }

    public void tinhTongTien() {
        double tongTien = 0;
        for (long key : listHoaDonNhapSachChiTiet.keySet()) {
            HoaDonNhapSachChiTiet hdct = listHoaDonNhapSachChiTiet.get(key);
            tongTien += hdct.getSoLuong() * hdct.getGia();
        }
        txtTongTien.setText(String.valueOf(tongTien));
    }

    public void resetForm() {
        tableModelHoaDonNhapSachChiTiet.setRowCount(0);
        listHoaDonNhapSachChiTiet.clear();
        txtMaHoaDonDenBu.setText(null);
        txtTongTien.setText(null);
        lblQR_CODE.setIcon(null);
        btnDownloadQr.setVisible(false);
        btnSave.setText("Thêm");
    }

    private void InsertOnUpdateListHoaNhapChiTiet(Long id) {

        listHoaDonNhapSachChiTiet.forEach((x, hdct) -> {
            hdct.setHoaDonNhap(id);
            new Thread() {
                @Override
                public void run() {
                    if (hdct.getLoaiSach()) {
                        sachDao.updateGia(hdct.getSach(), hdct.getGia());
                    }
                    hoaDonNhapSachDaoChiTietDao.insert(hdct);
                }
            }.start();
        });
    }

}