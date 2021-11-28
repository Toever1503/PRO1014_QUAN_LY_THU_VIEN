/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import DAO.NhaXuatBanDao;
import DAO.SachDAO;
import DAO.TacGiaDao;
import DAO.TacGiaVaSachDao;
import DAO.TheLoaiDao;
import DAO.TheLoaiVaSachDao;
import Models.NhaXuatBan;
import Models.Sach;
import Models.TacGia;
import Models.TacGiaVaSach;
import Models.TheLoai;
import Models.TheLoaiVaSach;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Hoan
 */
public class QLSach_JPanel extends javax.swing.JPanel {

    private Map<Integer, List<Sach>> listSach;
    private Map<Long, TacGia> listTacGia;
    private Map<Long, TheLoai> listTheLoai;
    private List<NhaXuatBan> listNhaXuatBan;

    private Map<Long, Long> theLoaiAdd;
    private Map<Long, Long> tacGiaAdd;

    private DefaultTableModel tableModelListSach;
    private DefaultTableModel tableModelListTacGia;
    private DefaultTableModel tableModelListTheLoais;

    private DefaultComboBoxModel boxModelTheLoai;
    private DefaultComboBoxModel boxModelNhaXuatBan;
    private DefaultComboBoxModel boxModelKhuVuc;
    private int pageIndex = 0;
    private int total;

    private TheLoaiVaSachDao theLoaiVaSachDao;
    private TacGiaVaSachDao tacGiaVaSachDao;
    private TheLoaiDao theLoaiDao;
    private NhaXuatBanDao nhaXuatBanDao;
    private TacGiaDao tacGiaDao;
    private SachDAO sachDAO;
    private static QLSach_JPanel instance;

    /**
     * Creates new form QLSach_JPanel
     */
    private QLSach_JPanel() {
        initComponents();
        jTabbedPane1.remove(jPanelCapNhat);

        theLoaiDao = TheLoaiDao.getInstance();
        nhaXuatBanDao = NhaXuatBanDao.getInstance();
        sachDAO = SachDAO.getInstance();
        tacGiaDao = TacGiaDao.getInstance();
        tacGiaVaSachDao = TacGiaVaSachDao.getInstacne();
        theLoaiVaSachDao = TheLoaiVaSachDao.getInstacne();
        total = sachDAO.getTotal();

        theLoaiAdd = new HashMap<Long, Long>();
        tacGiaAdd = new HashMap<Long, Long>();

        listTacGia = new HashMap<Long, TacGia>();
        listTheLoai = new HashMap<Long, TheLoai>();
        listNhaXuatBan = nhaXuatBanDao.selectALL();

        listSach = new HashMap<Integer, List<Sach>>();
        listSach.put(pageIndex, sachDAO.selectByPage(Long.valueOf(pageIndex)));

        loadList();

        tableModelListSach = (DefaultTableModel) tblSach.getModel();
        tableModelListTacGia = (DefaultTableModel) tblTacGia.getModel();
        tableModelListTheLoais = (DefaultTableModel) tblTheLoai.getModel();

        boxModelKhuVuc = (DefaultComboBoxModel) cmbKhuVuc.getModel();
        boxModelNhaXuatBan = (DefaultComboBoxModel) cmbNhaXuatBan.getModel();
        boxModelTheLoai = (DefaultComboBoxModel) cmbTheLoaiFilter.getModel();

        fillCmbKhuVuc();
        fillCmbNhaXuatBan();
        fillTableSach(listSach.get(pageIndex));
        fillCmbTheLoai();
    }

    public static QLSach_JPanel getInstance() {
        if (instance == null) {
            instance = new QLSach_JPanel();
        }
        return instance;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        btnAddNew = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        cmbTheLoaiFilter = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jPanelCapNhat = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblMaSach = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        lblTenSach = new javax.swing.JLabel();
        lblViTri = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblQr_Code = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        lblErrorTenSach = new javax.swing.JLabel();
        cmbKhuVuc = new javax.swing.JComboBox<>();
        btnQuayLai = new javax.swing.JButton();
        cmbNhaXuatBan = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        lblNhaXuatBan1 = new javax.swing.JLabel();
        btnChonTacGia = new javax.swing.JButton();
        btnXoaTacGia = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTacGia = new javax.swing.JTable();
        btnChonTheLoai = new javax.swing.JButton();
        btnXoaTheLoai = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ SÁCH");
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 100));
        add(jLabel9, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);

        tblSach.setAutoCreateRowSorter(true);
        tblSach.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Vị Trí", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSach.setGridColor(new java.awt.Color(255, 255, 255));
        tblSach.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblSach.setRowHeight(25);
        tblSach.setSelectionBackground(new java.awt.Color(6, 143, 202));
        jScrollPane1.setViewportView(tblSach);
        if (tblSach.getColumnModel().getColumnCount() > 0) {
            tblSach.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(648, 50));

        jButton1.setText("Tìm kiếm");

        btnAddNew.setText("Thêm Mới");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnDetails.setText("Chi Tiết");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        cmbTheLoaiFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTheLoaiFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTheLoaiFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNew)
                .addGap(3, 3, 3)
                .addComponent(btnDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbTheLoaiFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField6)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddNew)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDetails)
                            .addComponent(cmbTheLoaiFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Danh sách", jPanel2);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaSach.setText("Mã sách:");
        jPanel4.add(lblMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 51, -1, -1));

        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaSach.setEnabled(false);
        jPanel4.add(txtMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 48, 236, -1));

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 89, 236, -1));

        lblTenSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTenSach.setText("Tên sách:");
        jPanel4.add(lblTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 92, -1, -1));

        lblViTri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblViTri.setText("Vị trí:");
        jPanel4.add(lblViTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 142, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQr_Code, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQr_Code, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 55, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, -1, -1));

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/cleaning.png"))); // NOI18N
        btnClear.setText("Làm Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel4.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 108, -1));

        btnDownload.setText("Download");
        jPanel4.add(btnDownload, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 266, -1, -1));

        lblErrorTenSach.setText(" ");
        jPanel4.add(lblErrorTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 118, 236, -1));

        cmbKhuVuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKhuVuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKhuVucActionPerformed(evt);
            }
        });
        jPanel4.add(cmbKhuVuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 143, 236, -1));

        btnQuayLai.setText("Quay Lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });
        jPanel4.add(btnQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, -1, 33));

        cmbNhaXuatBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cmbNhaXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 236, -1));

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Thể Loại"
            }
        ));
        jScrollPane2.setViewportView(tblTheLoai);
        if (tblTheLoai.getColumnModel().getColumnCount() > 0) {
            tblTheLoai.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 200, 110));

        lblNhaXuatBan1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNhaXuatBan1.setText("Nhà xuất bản:");
        jPanel4.add(lblNhaXuatBan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        btnChonTacGia.setText("Chọn");
        btnChonTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonTacGiaActionPerformed(evt);
            }
        });
        jPanel4.add(btnChonTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, -1, -1));

        btnXoaTacGia.setText("Xóa");
        btnXoaTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTacGiaActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoaTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        tblTacGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Tác Giả"
            }
        ));
        jScrollPane3.setViewportView(tblTacGia);
        if (tblTacGia.getColumnModel().getColumnCount() > 0) {
            tblTacGia.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 210, 110));

        btnChonTheLoai.setText("Chọn");
        btnChonTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonTheLoaiActionPerformed(evt);
            }
        });
        jPanel4.add(btnChonTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        btnXoaTheLoai.setText("Xóa");
        btnXoaTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTheLoaiActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoaTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        javax.swing.GroupLayout jPanelCapNhatLayout = new javax.swing.GroupLayout(jPanelCapNhat);
        jPanelCapNhat.setLayout(jPanelCapNhatLayout);
        jPanelCapNhatLayout.setHorizontalGroup(
            jPanelCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCapNhatLayout.setVerticalGroup(
            jPanelCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cập nhật", jPanelCapNhat);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        btnAdd.setText("Thêm");
        resetForm();
        activeTabCapNhat();
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // TODO add your handling code here:
        int row = tblSach.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn sách cần xem!");
        } else {
            setForm(listSach.get(pageIndex).get(row));
            btnAdd.setText("");
            activeTabCapNhat();
        }


    }//GEN-LAST:event_btnDetailsActionPerformed

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

    private void cmbTheLoaiFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTheLoaiFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTheLoaiFilterActionPerformed

    private void btnXoaTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTheLoaiActionPerformed
        // TODO add your handling code here:
        if (theLoaiAdd.size() == 0) {
            JOptionPane.showMessageDialog(this, "Thể loại Trống!");
        } else {
            int row = tblTheLoai.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn thể loại cần xóa!");
            } else {
                Long maTl = Long.valueOf(tblTheLoai.getValueAt(row, 0).toString());
                theLoaiAdd.remove(maTl);
                tableModelListTheLoais.removeRow(row);
            }
        }
    }//GEN-LAST:event_btnXoaTheLoaiActionPerformed

    private void btnChonTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonTheLoaiActionPerformed
        // TODO add your handling code here:
        ChonTacGiaVaTheLoai_JDialog.getInstance().show("THE_LOAI", null, listTheLoai);
    }//GEN-LAST:event_btnChonTheLoaiActionPerformed

    private void btnXoaTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTacGiaActionPerformed
        // TODO add your handling code here:
        if (theLoaiAdd.size() == 0) {
            JOptionPane.showMessageDialog(this, "Tác  giả trống!");
        } else {
            int row = tblTacGia.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Hãy chọn thể loại cần xóa!");
            } else {
                Long maTg = Long.valueOf(tblTacGia.getValueAt(row, 0).toString());
                tacGiaAdd.remove(maTg);
                tableModelListTacGia.removeRow(row);
            }
        }
    }//GEN-LAST:event_btnXoaTacGiaActionPerformed

    private void btnChonTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonTacGiaActionPerformed
        // TODO add your handling code here:
        ChonTacGiaVaTheLoai_JDialog.getInstance().show("TAC_GIA", listTacGia, null);
    }//GEN-LAST:event_btnChonTacGiaActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanelCapNhat);
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void cmbKhuVucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKhuVucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKhuVucActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        resetForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed
    public void activeTabCapNhat() {
        jTabbedPane1.add(jPanelCapNhat, "Cập Nhật");
        jTabbedPane1.setSelectedIndex(1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnChonTacGia;
    private javax.swing.JButton btnChonTheLoai;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnXoaTacGia;
    private javax.swing.JButton btnXoaTheLoai;
    private javax.swing.JComboBox<String> cmbKhuVuc;
    private javax.swing.JComboBox<String> cmbNhaXuatBan;
    private javax.swing.JComboBox<String> cmbTheLoaiFilter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelCapNhat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblErrorTenSach;
    private javax.swing.JLabel lblMaSach;
    private javax.swing.JLabel lblNhaXuatBan1;
    private javax.swing.JLabel lblQr_Code;
    private javax.swing.JLabel lblTenSach;
    private javax.swing.JLabel lblViTri;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblTacGia;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        txtMaSach.setText(null);
        txtTenSach.setText(null);
        lblErrorTenSach.setText(null);
        cmbKhuVuc.setSelectedIndex(0);
        cmbNhaXuatBan.setSelectedIndex(0);
        lblQr_Code.setIcon(null);
        btnDownload.setVisible(false);
    }

    private void fillCmbKhuVuc() {
        boxModelKhuVuc.removeAllElements();;
        boxModelKhuVuc.addElement("Khu A");
        boxModelKhuVuc.addElement("Khu B");
        boxModelKhuVuc.addElement("Khu C");
        boxModelKhuVuc.addElement("Khu D");
        boxModelKhuVuc.addElement("Khu E");

    }

    private void fillCmbNhaXuatBan() {
        boxModelNhaXuatBan.removeAllElements();
        if (listNhaXuatBan != null) {
            listNhaXuatBan.forEach((nxb) -> boxModelNhaXuatBan.addElement(nxb.getId() + "-" + nxb.getTenNhaXuatBan()));
        }
    }

    private void fillTableSach(List<Sach> list) {
        tableModelListSach.setRowCount(0);
        if (list != null) {
            list.forEach((s) -> {
                tableModelListSach.addRow(new Object[]{
                    s.getId(),
                    s.getTenSach(),
                    s.getViTri(),
                    s.getNgayTao()
                });
            });
        }
    }

    private void setForm(Sach sach) {
        txtMaSach.setText(sach.getId().toString());
        txtTenSach.setText(sach.getTenSach());
        cmbKhuVuc.setSelectedItem(sach.getViTri());

        tableModelListTacGia.setRowCount(0);
        tableModelListTheLoais.setRowCount(0);

        new Thread() {
            @Override
            public void run() {
                List<TacGiaVaSach> tacGiaVaSachs = tacGiaVaSachDao.selectALLBySach(sach.getId());
                tacGiaVaSachs.forEach((tg) -> {
                    tacGiaAdd.put(tg.getTacGia(), tg.getSach());
                    tableModelListTacGia.addRow(new Object[]{tg.getTacGia(), listTacGia.get(tg.getTacGia()).getTenTacGia()});
                });
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                List<TheLoaiVaSach> theLoaiVaSachs = theLoaiVaSachDao.selectALLBySach(sach.getId());
                theLoaiVaSachs.forEach((tl) -> {
                    theLoaiAdd.put(tl.getTheLoai(), tl.getSach());

                    tableModelListTheLoais.addRow(new Object[]{tl.getTheLoai(), listTheLoai.get(tl.getTheLoai()).getTenTheLoai()});
                });
            }
        }.start();

        for (int i = 0; i < listNhaXuatBan.size(); ++i) {
            NhaXuatBan nxb = listNhaXuatBan.get(i);
            if (sach.getNhaXuatBan() == nxb.getId()) {
                cmbNhaXuatBan.setSelectedItem(nxb.getId() + "-" + nxb.getTenNhaXuatBan());
                break;
            }
        }
        if (sach.getQr_code()
                != null) {
            try {
                lblQr_Code.setIcon(new ImageIcon(
                        new ImageIcon(Helper.XImage.SACH_UPLOAD.concat("/" + sach.getQr_code().split("-")[1] + ".png")).
                                getImage().
                                getScaledInstance(185, 200, 1)));
                btnDownload.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy qr_code");
            }
        }
    }

    private void loadList() {
        List<TheLoai> listTl = theLoaiDao.selectALL();
        listTl.forEach(tl -> {
            listTheLoai.put(tl.getId(), tl);
        });

        List<TacGia> listTg = tacGiaDao.selectALL();
        listTg.forEach(tg -> {
            listTacGia.put(tg.getId(), tg);
        });
    }

    private void fillCmbTheLoai() {
        boxModelTheLoai.removeAllElements();
        listTheLoai.forEach((x, y) -> {
            boxModelTheLoai.addElement(y.getId() + "-" + y.getTenTheLoai());
        });
        cmbTheLoaiFilter.setModel(boxModelTheLoai);
    }

    public boolean addTacGia(Long id) {
        if (tacGiaAdd.containsKey(id)) {
            return false;
        }
        tacGiaAdd.put(id, null);
        tableModelListTacGia.addRow(new Object[]{id, listTacGia.get(id).getTenTacGia()});
        return true;
    }

    public boolean addTheLoai(Long id) {
        if (theLoaiAdd.containsKey(id)) {
            return false;
        }
        theLoaiAdd.put(id, null);
        tableModelListTheLoais.addRow(new Object[]{id, listTheLoai.get(id).getTenTheLoai()});
        return true;
    }

}
