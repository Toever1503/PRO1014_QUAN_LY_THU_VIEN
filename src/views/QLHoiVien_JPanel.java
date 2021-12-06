/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import DAO.HoiVienDao;
import Models.HoiVien;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dung
 */
public class QLHoiVien_JPanel extends javax.swing.JPanel {

    private static QLHoiVien_JPanel instance;
    private DefaultTableModel model;
    private HoiVienDao dao = new HoiVienDao();
    private int index = 0;
    private Map<Integer, List<HoiVien>> listHV;
    private DefaultTableModel tableModel;
    private int total;

    public QLHoiVien_JPanel() {
        initComponents();
        tabs.remove(jPanelCapNhat);

        listHV = new HashMap<Integer, List<HoiVien>>();
        dao = HoiVienDao.getInstance();
        total = dao.getTotal();
        listHV.put(index, dao.selectByPage(Long.valueOf(index)));
        model = (DefaultTableModel) tblQuanLyNguoiDung.getModel();
        fillTable(listHV.get(index));
    }

    public static QLHoiVien_JPanel getInstance() {
        if (instance == null) {
            instance = new QLHoiVien_JPanel();
        }
        return instance;
    }

    void fillTable(List<HoiVien> list) {
        model.setRowCount(0);   //đưa số dòng về 0 (xóa bảng)
        try {
            for (HoiVien hv : list) {
                Object[] row = {
                    hv.getId(),
                    hv.getFullName(),
                    hv.getNgaySinh(),
                    hv.getSoDienThoai(),
                    hv.getEmail(),
                    hv.getDiaChi(), //hv.isTrangThai() ? "Mở" : "Khóa"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
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
        tabs = new javax.swing.JTabbedPane();
        tabDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLyNguoiDung = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnThemMoi = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jPanelCapNhat = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        lblQR_code = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jDateChooserNgayHan = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoKhoa = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        tabDanhSach.setLayout(new java.awt.BorderLayout(0, 10));

        tblQuanLyNguoiDung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblQuanLyNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ND", "Họ Và Tên", "Ngày Sinh", "Số điện thoại", "Email", "Địa Chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblQuanLyNguoiDung);
        if (tblQuanLyNguoiDung.getColumnModel().getColumnCount() > 0) {
            tblQuanLyNguoiDung.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        tabDanhSach.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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
                .addContainerGap(946, Short.MAX_VALUE)
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tabDanhSach.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel4.setPreferredSize(new java.awt.Dimension(648, 50));

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnThemMoi.setText("Thêm Mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnChiTiet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChiTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 690, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTim)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnThemMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tabDanhSach.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        tabs.addTab("Danh Sách", tabDanhSach);

        jPanelCapNhat.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Mã hội viên :");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        txtMaTT.setEnabled(false);
        jPanel3.add(txtMaTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 240, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("CCCD :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Ngày hạn :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Họ tên :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Ngày sinh :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Số điện thoại :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Email :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });
        jPanel3.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 240, -1));
        jPanel3.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 240, -1));
        jPanel3.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 230, -1));
        jPanel3.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 230, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Địa chỉ :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, -1, -1));
        jPanel3.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 230, -1));

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/cleaning.png"))); // NOI18N
        btnClear.setText("Làm Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel3.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        btnBack.setText("Quay Lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel3.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, -1, 30));

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/add.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel3.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));
        jPanel3.add(lblQR_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, -1, -1));

        lblError.setText(" ");
        jPanel3.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, -1, -1));

        jDateChooserNgaySinh.setDateFormatString("dd-MM-yyyy");
        jPanel3.add(jDateChooserNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 240, -1));

        jDateChooserNgayHan.setDateFormatString("dd-MM-yyyy");
        jPanel3.add(jDateChooserNgayHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Trạng Thái");

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoHoatDong.setSelected(true);
        rdoHoatDong.setText("Hoạt Động");

        buttonGroup1.add(rdoKhoa);
        rdoKhoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoKhoa.setText("Khóa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(rdoHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHoatDong)
                    .addComponent(rdoKhoa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        jPanelCapNhat.add(jPanel3, java.awt.BorderLayout.CENTER);

        tabs.addTab("Cập Nhật", jPanelCapNhat);

        add(tabs, java.awt.BorderLayout.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ HỘI VIÊN");
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 100));
        add(jLabel9, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        index = total;
        List<HoiVien> list = listHV.get(index);
        if (list == null) {
            list = dao.selectByPage(Long.valueOf(index));
        }
        fillTable(list);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (index + 1 > total) {
            JOptionPane.showMessageDialog(this, "Hiện đã là trang đầu tiên!");
            return;
        } else {
            index++;
            List<HoiVien> list = listHV.get(index);
            if (list == null) {
                list = dao.selectByPage(Long.valueOf(index));
            }
            fillTable(list);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        if (index - 1 < 0) {
            JOptionPane.showMessageDialog(this, "Hiện đã là trang đầu tiên!");
            return;
        } else {
            index--;
            List<HoiVien> list = listHV.get(index);
            if (list == null) {
                list = dao.selectByPage(Long.valueOf(index));
            }
            fillTable(list);
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this.index = 0;
        fillTable(listHV.get(index));
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        clearForm();
        activeTabCapNhat();
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        int row = tblQuanLyNguoiDung.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 người dùng cần xem!");
        } else {
            btnInsert.setText("Lưu");
            setForm(listHV.get(index).get(row));
            activeTabCapNhat();
        }

    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (check())
            insert();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        tabs.remove(jPanelCapNhat);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        index = 0;
        fillTable(listHV.get(index));
    }//GEN-LAST:event_btnReloadActionPerformed

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDActionPerformed
    public void activeTabCapNhat() {
        tabs.add(jPanelCapNhat, "Cập Nhật");
        tabs.setSelectedIndex(1);
    }

    void insert() {
        //getModel() viết ở dưới, lấy thông tin trên form điền vào đt model
        HoiVien model = getForm();
        System.out.println(model == null);
        if (model != null) {
            if (model.getId() == null) {
                Long id = Long.valueOf(dao.insertOnUpdate(model));
                if (id <= 0) {
                    JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
                } else {
                    new Thread() {
                        @Override
                        public void run() {
                            index = 0;
                            listHV.clear();
                            listHV.put(index, dao.selectByPage(Long.valueOf(index)));
                        }
                    }.start();
                    String keyData = model.getQr_code().split("-")[1];
                    String past = Helper.XImage.USER_UPLOAD.concat("/" + keyData + ".png");

                    if (!Helper.QR_CODE.generateQRcode(keyData, past)) {
                        JOptionPane.showMessageDialog(this, "Không thể khởi tạo mã Qr-code");
                    }
                    try {
                        lblQR_code.setIcon(new ImageIcon(new ImageIcon(past).getImage().getScaledInstance(200, 200, 1)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                    txtMaTT.setText(id.toString());
                    total = dao.getTotal();
                }
            } else {
                if (dao.insertOnUpdate(model) <= 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    List<HoiVien> list = listHV.get(index);
                    for (int i = 0; i < list.size(); ++i) {
                        if (list.get(i).getId().equals(model.getId())) {
                            list.set(i, model);
                            break;
                        }
                    }
                    listHV.replace(index, list);
                }
            }
        }
    }

    void updateStatus() {
        boolean edit = (this.index >= 0);
        boolean first = (this.index == 0);
        boolean last = (this.index == tblQuanLyNguoiDung.getRowCount() - 1);
        //Trang thái form
        txtMaTT.setEditable(!edit);
        btnInsert.setEnabled(!edit);
        btnBack.setEnabled(edit);
        btnClear.setEnabled(edit);
        //trangjt hái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);

    }

    void clearForm() {
        txtCCCD.setText("");
        txtHoTen.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtMaTT.setText("");
        txtSoDienThoai.setText("");
        btnInsert.setText("Thêm");
        jDateChooserNgayHan.setDate(null);
        jDateChooserNgaySinh.setDate(null);
    }

    void setForm(HoiVien model) {
        txtMaTT.setText(model.getId().toString());
        model.setNguoiTao(model.getNguoiTao());
        txtCCCD.setText(model.getCccd());
        txtHoTen.setText(model.getFullName());
        txtDiaChi.setText(model.getDiaChi());
        jDateChooserNgaySinh.setDate(model.getNgaySinh());
        model.setNgaySinh(model.getNgaySinh());
        txtSoDienThoai.setText(model.getSoDienThoai());
        txtEmail.setText(model.getEmail());
        jDateChooserNgayHan.setDate(model.getNgayHan());
        model.setNgayHan(model.getNgayHan());
        model.setNgayTao(model.getNgayTao());
        if (model.isTrangThai()) {
            rdoHoatDong.setSelected(true);
        } else {
            rdoKhoa.setSelected(true);
        }
        // qr_code
        if (model.getQr_code() != null) {
            try {
                lblQR_code.setIcon(new ImageIcon(new ImageIcon(Helper.XImage.USER_UPLOAD.concat("/"
                        + model.getQr_code().split("-")[1]
                        + ".png")).getImage().getScaledInstance(200, 200, 1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    HoiVien getForm() {
        Long timeNow = Calendar.getInstance().getTimeInMillis();
        HoiVien model = new HoiVien();
        Long id = txtMaTT.getText().isEmpty() ? null : Long.valueOf(txtMaTT.getText());
        model.setId(id);
        model.setNguoiTao(Helper.Auth.user.getMaQL());
        model.setCccd(txtCCCD.getText());
        model.setFullName(txtHoTen.getText());
        model.setDiaChi(txtDiaChi.getText());
        model.setNgaySinh(jDateChooserNgaySinh.getDate() == null ? null : new java.sql.Date(jDateChooserNgaySinh.getDate().getTime()));
        model.setSoDienThoai(txtSoDienThoai.getText());
        model.setEmail(txtEmail.getText());
        model.setNgayTao(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        model.setNgayHan(jDateChooserNgayHan.getDate() == null ? null : new java.sql.Date(jDateChooserNgayHan.getDate().getTime()));
        model.setTrangThai(rdoHoatDong.isSelected());
        if (model.getId() == null) {
            model.setQr_code("hoivien-" + timeNow.toString());

        } else {
            int row = tblQuanLyNguoiDung.getSelectedRow();
            model.setQr_code(listHV.get(index).get(row).getQr_code());
        }
        return model;
    }

    boolean check() {
        if (txtCCCD.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Căn cước công dân trống!");
            return false;
        } else if (txtHoTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên hội viên trống!");
            return false;
        } else if (jDateChooserNgaySinh.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh!");
            return false;
        } else if (txtSoDienThoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại trống!");
            return false;
        } else if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email trống!");
            return false;
        } else if (txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ trống!");
            return false;
        } else if (jDateChooserNgayHan.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hạn!");
            return false;
        }
        return true;
    }

    public void showHoiVien(String data) {
        HoiVien hoivien = dao.findByQR("hoivien-".concat(data));
        if (hoivien != null) {
            btnInsert.setText("Lưu");
            setForm(hoivien);
            activeTabCapNhat();
            Home_Frame.getInstance().activePanel("QLHOIVIEN");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTim;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooserNgayHan;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCapNhat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblQR_code;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhoa;
    private javax.swing.JPanel tabDanhSach;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblQuanLyNguoiDung;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
