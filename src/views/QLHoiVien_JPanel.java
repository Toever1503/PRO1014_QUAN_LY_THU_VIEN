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
        jPanel5 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jPanelCapNhat = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblQR_code = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        txtCCCD = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtMaTT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserNgayHan = new com.toedter.calendar.JDateChooser();
        txtDiaChi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoKhoa = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        tabDanhSach.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabDanhSach.setLayout(new java.awt.BorderLayout(10, 10));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 54));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 10));

        jPanel5.setPreferredSize(new java.awt.Dimension(330, 35));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/First_button.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel5.add(btnFirst);

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/back_button.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        jPanel5.add(btnPrev);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/next_button.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel5.add(btnNext);

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/Last_button.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel5.add(btnLast);

        jPanel1.add(jPanel5);

        tabDanhSach.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(648, 85));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 15));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(320, 52));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 10));

        jPanel7.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btnThemMoi.setText("Thêm Mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });
        jPanel7.add(btnThemMoi);

        btnChiTiet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChiTiet.setText("Chi Tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        jPanel7.add(btnChiTiet);

        btnReload.setText("Làm Mới");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jPanel7.add(btnReload);

        jPanel8.add(jPanel7);

        jPanel4.add(jPanel8);

        jPanel9.setPreferredSize(new java.awt.Dimension(200, 53));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel9);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(271, 53));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel4.add(jPanel6);

        tabDanhSach.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        tabs.addTab("Danh Sách", tabDanhSach);

        jPanelCapNhat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelCapNhat.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));

        jPanel3.setPreferredSize(new java.awt.Dimension(820, 470));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(lblQR_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, -1, -1));

        lblError.setText(" ");
        jPanel3.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, -1, -1));

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(836, 10));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel15.setPreferredSize(new java.awt.Dimension(836, 10));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel15, java.awt.BorderLayout.PAGE_END);

        jPanel16.setPreferredSize(new java.awt.Dimension(100, 10));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel16, java.awt.BorderLayout.LINE_START);

        jPanel17.setPreferredSize(new java.awt.Dimension(100, 10));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel17, java.awt.BorderLayout.LINE_END);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/add.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel10.add(btnInsert);

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/cleaning.png"))); // NOI18N
        btnClear.setText("Làm Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel10.add(btnClear);

        btnBack.setText("Quay Lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel10.add(btnBack);

        jPanel11.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 790, 70));

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Mã hội viên :");
        jPanel12.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Họ tên :");
        jPanel12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("CCCD :");
        jPanel12.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 27));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Ngày sinh :");
        jPanel12.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 27));

        jDateChooserNgaySinh.setDateFormatString("dd-MM-yyyy");
        jPanel12.add(jDateChooserNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 230, 27));

        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });
        jPanel12.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 230, 27));
        jPanel12.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 230, 27));

        txtMaTT.setEnabled(false);
        jPanel12.add(txtMaTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 230, 27));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Số điện thoại :");
        jPanel12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, 27));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Email :");
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, 27));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Địa chỉ :");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, 27));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Ngày hạn :");
        jPanel12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, 27));

        jDateChooserNgayHan.setDateFormatString("dd-MM-yyyy");
        jPanel12.add(jDateChooserNgayHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 230, 27));
        jPanel12.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 230, 27));
        jPanel12.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 230, 27));
        jPanel12.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 230, 27));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 240));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng thái"));

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
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(rdoHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHoatDong)
                    .addComponent(rdoKhoa))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel2);

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 790, 90));

        jPanelCapNhat.add(jPanel3);

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
