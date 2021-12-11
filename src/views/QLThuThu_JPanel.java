/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import DAO.QuanLyDao;
import Models.QuanLy;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.Color;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.awt.Component;
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Hoan
 */
public class QLThuThu_JPanel extends javax.swing.JPanel {

    private static QLThuThu_JPanel instance;

    private List<QuanLy> listQLThuThu;
    private Map<Integer, List<QuanLy>> listQLTT;
    int row = 0;
    private int total;
    private QuanLyDao QLDao;

    /**
     * Creates new form QLThuThu_JPanel
     */
    private QLThuThu_JPanel() {
        initComponents();
        tabs.remove(tabCapNhat);
        QLDao = QLDao.getInstance();
        listQLTT = new HashMap<>();
        listQLTT.put(row, QLDao.selectByPage(String.valueOf(row)));
        fillTable(listQLTT.get(row));
    }

    public static QLThuThu_JPanel getInstance() {
        if (instance == null) {
            instance = new QLThuThu_JPanel();
        }
        return instance;
    }

    void fillTable(List<QuanLy> QLList) {
        DefaultTableModel model = (DefaultTableModel) tblQuanLyThuThu.getModel();
        model.setRowCount(0);
        if (QLList != null) {
            try {
                for (QuanLy ql : QLList) {
                    Object[] row = {
                        ql.getMaQL(),
                        ql.getFullName(),
                        ql.getDiaChi(),
                        ql.getNgaySinh(),
                        ql.getSoDienThoai(),
                        ql.getEmail(),
                        ql.isVaiTro() ? "Thủ thư" : "Admin",
                        ql.isTrangThai() ? "Khóa" : "Hoạt động"
                    };
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }

    void insert() {
        QuanLy model = getForm();
        if(QLDao.insertOnUpdate(model)==0){
            JOptionPane.showMessageDialog(this, "thêm thất bại");
        }else{
           QLDao.insertOnUpdate(model);
        row = 0;
        listQLTT.clear();
        listQLTT.put(row, QLDao.selectByPage(String.valueOf(row)));
        fillTable(listQLTT.get(row)); 
        JOptionPane.showMessageDialog(this,btnInsert.getText()+ " Thành công");
        }
        
    }

    void clearForm() {
        this.setForm(new QuanLy());

    }

    void setForm(QuanLy model) {

        txtMaTT.setText(model.getMaQL());
        txtMatKhau.setText(model.getMatKhau());
        txtCCCD.setText(model.getCccd());
        txtHoTen.setText(model.getFullName());

        rdoQuanLy.setSelected(model.isVaiTro());
        txtSoDienThoai.setText(model.getSoDienThoai());
        txtEmail.setText(model.getEmail());
        txtDiaChi.setText(model.getDiaChi());
        jDateChooserNgaySinh.setDate(model.getNgaySinh());
        rdoKhoa.setSelected(model.isTrangThai());
    }

    QuanLy getForm() {
        QuanLy model = new QuanLy();
        model.setMaQL(txtMaTT.getText());
        model.setFullName(txtHoTen.getText());
        model.setSoDienThoai(txtSoDienThoai.getText());
        model.setMatKhau(Helper.PasswordEncoder.getInstance().encode(
                String.valueOf(txtMatKhau.getPassword())));
        model.setCccd(txtCCCD.getText());
        model.setEmail(txtEmail.getText());
        model.setDiaChi(txtDiaChi.getText());
        model.setVaiTro(rdoThuThu.isSelected());
        model.setTrangThai(rdoKhoa.isSelected());
        model.setNgaySinh(jDateChooserNgaySinh.getDate() == null ? null
                : new Date(jDateChooserNgaySinh.getDate().getTime()));

        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        tabDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuanLyThuThu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnChiTiet = new javax.swing.JButton();
        btnThemMoi = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnFirst1 = new javax.swing.JButton();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        tabCapNhat = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        txtMaTT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rdoThuThu = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoKhoa = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        tabDanhSach.setLayout(new java.awt.BorderLayout(20, 10));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);

        tblQuanLyThuThu.setAutoCreateRowSorter(true);
        tblQuanLyThuThu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblQuanLyThuThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thủ thư", "Họ tên", "Địa chỉ", "Ngày sinh", "Số điện thoại", "Email", "Vai Trò", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuanLyThuThu.setGridColor(new java.awt.Color(255, 255, 255));
        tblQuanLyThuThu.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblQuanLyThuThu.setRowHeight(25);
        tblQuanLyThuThu.setSelectionBackground(new java.awt.Color(6, 143, 202));
        jScrollPane1.setViewportView(tblQuanLyThuThu);

        tabDanhSach.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(648, 85));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 15));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setPreferredSize(new java.awt.Dimension(280, 52));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 10));

        jPanel8.setPreferredSize(new java.awt.Dimension(260, 29));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btnChiTiet.setText("Chi Tiết");
        btnChiTiet.setPreferredSize(new java.awt.Dimension(62, 27));
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        jPanel8.add(btnChiTiet);

        btnThemMoi.setText("Thêm Mới");
        btnThemMoi.setPreferredSize(new java.awt.Dimension(62, 27));
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });
        jPanel8.add(btnThemMoi);

        jPanel9.add(jPanel8);

        jPanel3.add(jPanel9);

        jPanel10.setPreferredSize(new java.awt.Dimension(200, 53));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel10);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setPreferredSize(new java.awt.Dimension(271, 53));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7);

        tabDanhSach.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel6.setPreferredSize(new java.awt.Dimension(100, 54));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 50, 10));

        jPanel4.setPreferredSize(new java.awt.Dimension(330, 35));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        btnFirst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/First_button.png"))); // NOI18N
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnFirst1);

        btnPrev1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/back_button.png"))); // NOI18N
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnPrev1);

        btnNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/next_button.png"))); // NOI18N
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNext1);

        btnLast1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/Last_button.png"))); // NOI18N
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnLast1);

        jPanel6.add(jPanel4);

        tabDanhSach.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        tabs.addTab("DANH SÁCH", tabDanhSach);

        tabCapNhat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabCapNhat.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(840, 450));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 10));

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setPreferredSize(new java.awt.Dimension(760, 200));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Mã thủ thư :");
        jPanel18.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 27));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mật khẩu :");
        jPanel18.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 90, 27));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("CCCD :");
        jPanel18.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 80, 27));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Họ tên :");
        jPanel18.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 80, 27));
        jPanel18.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 230, 27));
        jPanel18.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 230, 27));
        jPanel18.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 230, 27));
        jPanel18.add(txtMaTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 230, 27));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Ngày sinh :");
        jPanel18.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 100, 27));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Số điện thoại :");
        jPanel18.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 110, 27));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Email :");
        jPanel18.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 90, 27));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Địa chỉ :");
        jPanel18.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 90, 27));
        jPanel18.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 230, 27));
        jPanel18.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 230, 27));
        jPanel18.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 230, 27));
        jPanel18.add(jDateChooserNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 230, 27));

        jPanel1.add(jPanel18);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setPreferredSize(new java.awt.Dimension(760, 84));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 70, 5));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Vai trò"));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 70));

        buttonGroup1.add(rdoThuThu);
        rdoThuThu.setText("Thủ Thư");

        buttonGroup1.add(rdoQuanLy);
        rdoQuanLy.setText("Quản lý");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(rdoThuThu)
                .addGap(38, 38, 38)
                .addComponent(rdoQuanLy)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoThuThu)
                    .addComponent(rdoQuanLy))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng thái"));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 70));

        buttonGroup2.add(rdoHoatDong);
        rdoHoatDong.setText("Hoại động");

        buttonGroup2.add(rdoKhoa);
        rdoKhoa.setText("Khóa");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(rdoHoatDong)
                .addGap(38, 38, 38)
                .addComponent(rdoKhoa)
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHoatDong)
                    .addComponent(rdoKhoa))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel5);

        jPanel1.add(jPanel13);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setPreferredSize(new java.awt.Dimension(760, 70));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(836, 10));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel15.setPreferredSize(new java.awt.Dimension(836, 10));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel15, java.awt.BorderLayout.PAGE_END);

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

        jPanel12.add(jPanel16, java.awt.BorderLayout.LINE_START);

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

        jPanel12.add(jPanel17, java.awt.BorderLayout.LINE_END);

        jPanel11.setPreferredSize(new java.awt.Dimension(470, 100));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0, 20, 10));

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/add.png"))); // NOI18N
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel11.add(btnInsert);

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/cleaning.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel11.add(btnClear);

        jPanel12.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel12);

        tabCapNhat.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel19.setPreferredSize(new java.awt.Dimension(908, 10));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1966, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        tabCapNhat.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jPanel20.setPreferredSize(new java.awt.Dimension(908, 20));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1966, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        tabCapNhat.add(jPanel20, java.awt.BorderLayout.PAGE_END);

        jPanel21.setPreferredSize(new java.awt.Dimension(20, 417));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        tabCapNhat.add(jPanel21, java.awt.BorderLayout.LINE_END);

        jPanel22.setPreferredSize(new java.awt.Dimension(20, 337));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        tabCapNhat.add(jPanel22, java.awt.BorderLayout.LINE_START);

        tabs.addTab("CẬP NHẬT", tabCapNhat);

        add(tabs, java.awt.BorderLayout.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ THỦ THƯ");
        jLabel9.setPreferredSize(new java.awt.Dimension(95, 100));
        add(jLabel9, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed


    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (checkNullText(txtMaTT) && checkNullPass(txtMatKhau) && checkNullText(txtCCCD)
                && checkNullText(txtHoTen) && checkNullDate(jDateChooserNgaySinh) && checkNullText(txtSoDienThoai)
                && checkNullText(txtEmail) && checkNullText(txtDiaChi)) {
            if (checkCCCD(txtCCCD) && checkName(txtHoTen) && checkSDT(txtSoDienThoai) && checkEmail(txtEmail)) {
                insert();
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
        row = total;
        List<QuanLy> list = listQLTT.get(row);
        if (list == null) {
            listQLTT.put(row, QLDao.selectByPage(String.valueOf(row)));
        }
        fillTable(listQLTT.get(row));
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
        if (row + 1 > total) {
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang cuối!");
        } else {
            row++;
            List<QuanLy> list = listQLTT.get(row);
            if (list == null) {
                listQLTT.put(row, QLDao.selectByPage(String.valueOf(row)));
            }
            fillTable(listQLTT.get(row));
        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        // TODO add your handling code here:
        if (row - 1 < 0) {
            JOptionPane.showMessageDialog(this, "Bạn đã ở trang đầu!");
        } else {
            row--;
            List<QuanLy> list = listQLTT.get(row);
            if (list == null) {
                listQLTT.put(row, QLDao.selectByPage(String.valueOf(row)));
            }
            fillTable(listQLTT.get(row));
        }
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
        row = 0;
        fillTable(listQLTT.get(row));

    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        activeTabCapNhat();
        btnInsert.setText("Thêm");
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        
        int i = tblQuanLyThuThu.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn phiếu mượn cần xem!");
        } else {
            activeTabCapNhat();
            setForm(listQLTT.get(row).get(i));
            btnInsert.setText("Cập nhật");
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String search = txtTimKiem.getText();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy điền thông tin sách cần tìm kiếm!");
        } else {
            List<QuanLy> list = QLDao.searchByKey(search);
            if (list == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sách!");
            } else {
                fillTable(list);
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemMoiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnThemMoiAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMoiAncestorAdded
    public void activeTabCapNhat() {
        tabs.add(tabCapNhat, "Cập Nhật");
        tabs.setSelectedIndex(1);
    }

    public static boolean checkNullText(JTextField txt) {// check null 
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public boolean checkName(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            alert(txt.getRootPane(), txt.getName() + " phải là tên tiếng việt hoặc không đấu\ntừ 3-25 kí tự");
            return false;
        }
    }

    public boolean checkSDT(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            alert(txt.getRootPane(), txt.getName() + " phải gồm 10 số\nđúng các đầu số của nhà mạng.");
            return false;
        }
    }

    public boolean checkEmail(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            alert(txt.getRootPane(), txt.getName() + " không đúng định dạng");
            return false;
        }
    }

    public boolean checkNullDate(JDateChooser txt) {
        txt.setBackground(Color.white);
        if (txt.getDate() != null) {
            return true;
        } else {
            txt.setBackground(Color.pink);
            alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public boolean checkCCCD(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "[0-9]{12}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            alert(txt.getRootPane(), txt.getName() + " phải gồm 12 số");
            return false;
        }
    }

    public void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Quản lý thư viện", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Quản lý thư viện", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, "Quản lý thư viện", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setSize(900, 600);
        // frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.add(new QLThuThu_JPanel());
        frame.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JRadioButton rdoKhoa;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JRadioButton rdoThuThu;
    private javax.swing.JPanel tabCapNhat;
    private javax.swing.JPanel tabDanhSach;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblQuanLyThuThu;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
