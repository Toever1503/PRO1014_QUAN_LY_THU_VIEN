/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import DAO.GopYDAO;
import DAO.HoaDonDenBuChiTietDao;
import DAO.HoiVienDao;
import DAO.NhaXuatBanDao;
import DAO.PhieuMuonChiTietDao;
import DAO.QuanLyDao;
import DAO.TacGiaDao;
import DAO.TheLoaiDao;
import Helper.QR_SCANNER;
import Helper.XImage;
import Models.GopY;
import Models.QuanLy;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NguyenHoan
 */
public class Home_Frame extends javax.swing.JFrame {

    private CardLayout cardLayoutMainRight;
    private static Home_Frame instance;

    /**
     * Creates new form main_frame
     */
    public Home_Frame() {
        this.init();
        this.initPnlQuanLy();
//        fillTableDeXuat();
    }

    public static Home_Frame getInstance() {
        if (instance == null) {
            instance = new Home_Frame();
        }
        return instance;
    }

    public void init() {
        XImage.init();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(Home_Frame.MAXIMIZED_BOTH);    //cho toàn màn hình 
        this.startClock();
        cardLayoutMainRight = (CardLayout) pnlMainRight.getLayout();
//        cardLayoutMainRight.removeLayoutComponent(jPanel2Home);
//        cardLayoutMainRight.addLayoutComponent(jPanel2Home, "card10");
//        cardLayoutMainRight.show(pnlMainRight, "card10");
    }

    public void initPnlQuanLy() {
        new Thread() {
            @Override
            public void run() {
                jPanel_QlThuThu.add(QLThuThu_JPanel.getInstance(), BorderLayout.CENTER);
            }
        }.start();
        jPanel_ThongKe.add(ThongKe_JPanel.getInstance(), BorderLayout.CENTER);
        jPanel_QlSach.add(QLSach_JPanel.getInstance(), BorderLayout.CENTER);
        jPanel_QlHoaDonDenBu.add(QLHoaDonDenBu.getInstance(), BorderLayout.CENTER);
        jPanel_QlHoiVien.add(QLHoiVien_JPanel.getInstance(), BorderLayout.CENTER);
        jPanel_QlPhieuMuon.add(QLPhieuMuon_JPanel.getInstance(), BorderLayout.CENTER);
        jPanel_Ql_Nhap_Sach.add(QLHoaDonNhapSach.getInstance(), BorderLayout.CENTER);
    }

    //Đồng hồ
    void startClock() {
        new javax.swing.Timer(0, (java.awt.event.ActionEvent e) -> {
            java.util.Date now = new java.util.Date();
            java.text.SimpleDateFormat s = new java.text.SimpleDateFormat("hh:mm:ss aa");
            this.lblClock.setText(s.format(now));
        }).start();
    }

    public void activeDialogChonSach() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlWest = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        btnQLSach = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        btnQLPhieuMuon = new javax.swing.JLabel();
        pnl3 = new javax.swing.JPanel();
        btnQLHoiVien = new javax.swing.JLabel();
        pnl4 = new javax.swing.JPanel();
        btnHoaDonDenBu = new javax.swing.JLabel();
        pnl5 = new javax.swing.JPanel();
        btnThongKe = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnScanQR = new javax.swing.JButton();
        btnHome = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        pnlLast = new javax.swing.JPanel();
        lblClock = new javax.swing.JLabel();
        pnlMainRight = new javax.swing.JPanel();
        jPanel_QlSach = new javax.swing.JPanel();
        jPanel_QlPhieuMuon = new javax.swing.JPanel();
        jPanel_QlHoiVien = new javax.swing.JPanel();
        jPanel_QlThuThu = new javax.swing.JPanel();
        jPanel_QlHoaDonDenBu = new javax.swing.JPanel();
        jPanel_ThongKe = new javax.swing.JPanel();
        jPanel_Ql_Nhap_Sach = new javax.swing.JPanel();
        jPanel2Home = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeXuat = new javax.swing.JTable();
        btnThemDeXuat = new javax.swing.JButton();
        btnIangDeXuat = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblWelcome1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnHeThong = new javax.swing.JMenu();
        mniTaiKhoan = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniDangXuat = new javax.swing.JMenuItem();
        mnQuanLy = new javax.swing.JMenu();
        mniQLSach = new javax.swing.JMenuItem();
        mniQLPhieuMuon = new javax.swing.JMenuItem();
        mniQuanLyHoiVien = new javax.swing.JMenuItem();
        mniQLHoaDon = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        mniQLThuThu = new javax.swing.JMenuItem();
        mnThongKe = new javax.swing.JMenu();
        mniSachDaMuon = new javax.swing.JMenuItem();
        mniSachBiLoai = new javax.swing.JMenuItem();
        mniSachTreHan = new javax.swing.JMenuItem();
        mniSachConLai = new javax.swing.JMenuItem();
        mnTroDiup = new javax.swing.JMenu();
        mniHuongDanSuDung = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniGioiThieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thư viện");

        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlWest.setBackground(new java.awt.Color(6, 143, 202));
        pnlWest.setPreferredSize(new java.awt.Dimension(250, 397));
        pnlWest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl1.setBackground(new java.awt.Color(6, 143, 202));
        pnl1.setLayout(new java.awt.BorderLayout());

        btnQLSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQLSach.setForeground(new java.awt.Color(255, 255, 255));
        btnQLSach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/book0.png"))); // NOI18N
        btnQLSach.setText("Quản lý sách");
        btnQLSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLSachMouseClicked(evt);
            }
        });
        pnl1.add(btnQLSach, java.awt.BorderLayout.CENTER);

        pnlWest.add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 250, 40));

        pnl2.setBackground(new java.awt.Color(6, 143, 202));
        pnl2.setLayout(new java.awt.BorderLayout());

        btnQLPhieuMuon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQLPhieuMuon.setForeground(new java.awt.Color(255, 255, 255));
        btnQLPhieuMuon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLPhieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/loan_slip0.png"))); // NOI18N
        btnQLPhieuMuon.setText("Quản lý phiếu mượn");
        btnQLPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLPhieuMuonMouseClicked(evt);
            }
        });
        pnl2.add(btnQLPhieuMuon, java.awt.BorderLayout.CENTER);

        pnlWest.add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 45));

        pnl3.setBackground(new java.awt.Color(6, 143, 202));
        pnl3.setLayout(new java.awt.BorderLayout());

        btnQLHoiVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQLHoiVien.setForeground(new java.awt.Color(255, 255, 255));
        btnQLHoiVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLHoiVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/members 0.png"))); // NOI18N
        btnQLHoiVien.setText("Quản lý hội viên");
        btnQLHoiVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLHoiVienMouseClicked(evt);
            }
        });
        pnl3.add(btnQLHoiVien, java.awt.BorderLayout.CENTER);

        pnlWest.add(pnl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 250, 45));

        pnl4.setBackground(new java.awt.Color(6, 143, 202));
        pnl4.setLayout(new java.awt.BorderLayout());

        btnHoaDonDenBu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHoaDonDenBu.setForeground(new java.awt.Color(255, 255, 255));
        btnHoaDonDenBu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHoaDonDenBu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/receipt.png"))); // NOI18N
        btnHoaDonDenBu.setText("Hóa đơn đền bù");
        btnHoaDonDenBu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHoaDonDenBuMouseClicked(evt);
            }
        });
        pnl4.add(btnHoaDonDenBu, java.awt.BorderLayout.CENTER);

        pnlWest.add(pnl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 45));

        pnl5.setBackground(new java.awt.Color(6, 143, 202));
        pnl5.setLayout(new java.awt.BorderLayout());

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/trend0.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongKeMouseExited(evt);
            }
        });
        pnl5.add(btnThongKe, java.awt.BorderLayout.CENTER);

        pnlWest.add(pnl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 250, 45));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        pnlWest.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 250, -1));

        btnScanQR.setBackground(new java.awt.Color(0, 153, 0));
        btnScanQR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnScanQR.setForeground(new java.awt.Color(255, 255, 255));
        btnScanQR.setText("Scan QR");
        btnScanQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanQRActionPerformed(evt);
            }
        });
        pnlWest.add(btnScanQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 170, 50));

        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/library.png"))); // NOI18N
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });
        pnlWest.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 250, 100));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setAlignmentX(0.0F);
        jSeparator5.setAlignmentY(0.0F);
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jSeparator5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSeparator5.setFocusCycleRoot(true);
        jSeparator5.setFocusTraversalPolicy(null);
        jSeparator5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jSeparator5.setPreferredSize(new java.awt.Dimension(40, 2));
        pnlWest.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 120, 200, -1));

        pnlMain.add(pnlWest, java.awt.BorderLayout.WEST);

        pnlLast.setBackground(new java.awt.Color(255, 255, 255));
        pnlLast.setPreferredSize(new java.awt.Dimension(826, 30));
        pnlLast.setLayout(new java.awt.BorderLayout());

        lblClock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClock.setForeground(new java.awt.Color(204, 0, 0));
        lblClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/clock.png"))); // NOI18N
        lblClock.setText("00:00");
        lblClock.setPreferredSize(new java.awt.Dimension(150, 14));
        pnlLast.add(lblClock, java.awt.BorderLayout.LINE_END);

        pnlMain.add(pnlLast, java.awt.BorderLayout.PAGE_END);

        pnlMainRight.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainRight.setLayout(new java.awt.CardLayout());

        jPanel_QlSach.setLayout(new java.awt.BorderLayout());
        pnlMainRight.add(jPanel_QlSach, "card3");

        jPanel_QlPhieuMuon.setLayout(new java.awt.BorderLayout());
        pnlMainRight.add(jPanel_QlPhieuMuon, "card4");

        jPanel_QlHoiVien.setLayout(new java.awt.BorderLayout());
        pnlMainRight.add(jPanel_QlHoiVien, "card5");

        jPanel_QlThuThu.setLayout(new java.awt.BorderLayout());
        pnlMainRight.add(jPanel_QlThuThu, "card6");

        jPanel_QlHoaDonDenBu.setLayout(new java.awt.BorderLayout());
        pnlMainRight.add(jPanel_QlHoaDonDenBu, "card7");

        jPanel_ThongKe.setLayout(new java.awt.BorderLayout());
        pnlMainRight.add(jPanel_ThongKe, "card8");

        jPanel_Ql_Nhap_Sach.setLayout(new java.awt.BorderLayout());
        pnlMainRight.add(jPanel_Ql_Nhap_Sach, "card9");

        jPanel2Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDeXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Đề xuất", "Số Lượt", "Ngày Tạo"
            }
        ));
        jScrollPane1.setViewportView(tblDeXuat);
        if (tblDeXuat.getColumnModel().getColumnCount() > 0) {
            tblDeXuat.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel2Home.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 350, 550, 230));

        btnThemDeXuat.setText("Thêm đề xuất Mới");
        btnThemDeXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDeXuatActionPerformed(evt);
            }
        });
        jPanel2Home.add(btnThemDeXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        btnIangDeXuat.setText("Tăng Lượt Đề Xuất");
        jPanel2Home.add(btnIangDeXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblWelcome.setText("Xin chào");
        jPanel2Home.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 130, 30));

        pnlMainRight.add(jPanel2Home, "card10");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblWelcome1.setText("Xin chào");
        jPanel1.add(lblWelcome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 130, 30));

        pnlMainRight.add(jPanel1, "card10");

        pnlMain.add(pnlMainRight, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(234, 25));
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setOpaque(false);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(234, 25));

        mnHeThong.setText("Hệ thống");

        mniTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/user.png"))); // NOI18N
        mniTaiKhoan.setText("Tài khoản");
        mnHeThong.add(mniTaiKhoan);

        jMenuItem1.setText("Đổi Mật Khẩu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnHeThong.add(jMenuItem1);
        mnHeThong.add(jSeparator3);

        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/logout.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnHeThong.add(mniDangXuat);

        jMenuBar1.add(mnHeThong);

        mnQuanLy.setText("Quản lý");

        mniQLSach.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniQLSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/book.png"))); // NOI18N
        mniQLSach.setText("Quản lý sách");
        mnQuanLy.add(mniQLSach);

        mniQLPhieuMuon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniQLPhieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/loan_slip.png"))); // NOI18N
        mniQLPhieuMuon.setText("Quản lý phiếu mượn");
        mnQuanLy.add(mniQLPhieuMuon);

        mniQuanLyHoiVien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniQuanLyHoiVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/members .png"))); // NOI18N
        mniQuanLyHoiVien.setText("Quản lý hội viên");
        mnQuanLy.add(mniQuanLyHoiVien);

        mniQLHoaDon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniQLHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/receipt.png"))); // NOI18N
        mniQLHoaDon.setText("Hóa đơn đề bù");
        mnQuanLy.add(mniQLHoaDon);
        mnQuanLy.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Quản Lý Nhập Sách");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnQuanLy.add(jMenuItem2);
        jMenuItem2.getAccessibleContext().setAccessibleDescription("");

        mniQLThuThu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniQLThuThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/librarian.png"))); // NOI18N
        mniQLThuThu.setText("Quản lý thủ thư");
        mniQLThuThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLThuThuActionPerformed(evt);
            }
        });
        mnQuanLy.add(mniQLThuThu);

        jMenuBar1.add(mnQuanLy);

        mnThongKe.setText("Thống kê");

        mniSachDaMuon.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mniSachDaMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/borrow.png"))); // NOI18N
        mniSachDaMuon.setText("Sách đã mượn");
        mnThongKe.add(mniSachDaMuon);

        mniSachBiLoai.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mniSachBiLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/remove.png"))); // NOI18N
        mniSachBiLoai.setText("Sách bị loại");
        mnThongKe.add(mniSachBiLoai);

        mniSachTreHan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mniSachTreHan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/overdue.png"))); // NOI18N
        mniSachTreHan.setText("Sách trễ hạn");
        mnThongKe.add(mniSachTreHan);

        mniSachConLai.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mniSachConLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/available.png"))); // NOI18N
        mniSachConLai.setText("Sách còn lại");
        mnThongKe.add(mniSachConLai);

        jMenuBar1.add(mnThongKe);

        mnTroDiup.setText("Trợ giúp");

        mniHuongDanSuDung.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniHuongDanSuDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/instructions.png"))); // NOI18N
        mniHuongDanSuDung.setText("Hướng dẫn sử dụng");
        mnTroDiup.add(mniHuongDanSuDung);
        mnTroDiup.add(jSeparator2);

        mniGioiThieu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mniGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images_Icon/idea.png"))); // NOI18N
        mniGioiThieu.setText("Giới thiệu sản phẩm");
        mnTroDiup.add(mniGioiThieu);

        jMenuBar1.add(mnTroDiup);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseEntered
        this.pnl5.setBackground(new java.awt.Color(105, 184, 218));
        this.btnThongKe.setForeground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_btnThongKeMouseEntered

    private void btnThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseExited
        this.pnl5.setBackground(new java.awt.Color(6, 143, 202));
        this.btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btnThongKeMouseExited

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        cardLayoutMainRight.show(pnlMainRight, "card10");
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnQLSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLSachMouseClicked
        activePanel("QLSACH");
    }//GEN-LAST:event_btnQLSachMouseClicked

    private void btnQLPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLPhieuMuonMouseClicked
        activePanel("QLPHIEUMUON");
    }//GEN-LAST:event_btnQLPhieuMuonMouseClicked

    private void btnQLHoiVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLHoiVienMouseClicked
        activePanel("QLHOIVIEN");
    }//GEN-LAST:event_btnQLHoiVienMouseClicked

    private void btnHoaDonDenBuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDonDenBuMouseClicked
        activePanel("QLHOADONDENBU");
    }//GEN-LAST:event_btnHoaDonDenBuMouseClicked

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
        cardLayoutMainRight.show(pnlMainRight, "card8");
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnScanQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanQRActionPerformed
        new QR_SCANNER("HOME");
    }//GEN-LAST:event_btnScanQRActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        // TODO add your handling code here:
        this.dispose();
//        new Login_JFrame().setVisible(true);
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniQLThuThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLThuThuActionPerformed
        cardLayoutMainRight.show(pnlMainRight, "card6");
    }//GEN-LAST:event_mniQLThuThuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.out.println("change pass");
        new DoiMatKhau_JDialog().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        activePanel("QLNHAPSACH");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnThemDeXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDeXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemDeXuatActionPerformed

    public void activePanel(String panel) {
        switch (panel) {
            case "QLSACH":
                cardLayoutMainRight.show(pnlMainRight, "card3");
                break;
            case "QLNHAPSACH":
                cardLayoutMainRight.show(pnlMainRight, "card9");
                break;
            case "QLPHIEUMUON":
                cardLayoutMainRight.show(pnlMainRight, "card4");
                break;
            case "QLHOADONDENBU":
                cardLayoutMainRight.show(pnlMainRight, "card7");
                break;
            case "QLHOIVIEN":
                cardLayoutMainRight.show(pnlMainRight, "card5");
                break;
            default:
                cardLayoutMainRight.show(pnlMainRight, "card9");
                break;
        }
    }
    private void fillTableDeXuat() {
        DefaultTableModel tableModel = (DefaultTableModel)tblDeXuat.getModel();
        tableModel.setRowCount(0);
        List<GopY> list = GopYDAO.getInstance().selectALL();
        list.forEach(gopY->{
        tableModel.addRow(new Object[]{gopY.getId(), gopY.getNoiDung(), gopY.getNgayTao()});
        });
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
            java.util.logging.Logger.getLogger(Home_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home_Frame().setVisible(true);
//            }
//        });
//        Home_Frame.getInstance();
        new Home_Frame().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnHoaDonDenBu;
    private javax.swing.JLabel btnHome;
    private javax.swing.JButton btnIangDeXuat;
    private javax.swing.JLabel btnQLHoiVien;
    private javax.swing.JLabel btnQLPhieuMuon;
    private javax.swing.JLabel btnQLSach;
    private javax.swing.JButton btnScanQR;
    private javax.swing.JButton btnThemDeXuat;
    private javax.swing.JLabel btnThongKe;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2Home;
    private javax.swing.JPanel jPanel_QlHoaDonDenBu;
    private javax.swing.JPanel jPanel_QlHoiVien;
    private javax.swing.JPanel jPanel_QlPhieuMuon;
    private javax.swing.JPanel jPanel_QlSach;
    private javax.swing.JPanel jPanel_QlThuThu;
    private javax.swing.JPanel jPanel_Ql_Nhap_Sach;
    private javax.swing.JPanel jPanel_ThongKe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JMenu mnHeThong;
    private javax.swing.JMenu mnQuanLy;
    private javax.swing.JMenu mnThongKe;
    private javax.swing.JMenu mnTroDiup;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniHuongDanSuDung;
    private javax.swing.JMenuItem mniQLHoaDon;
    private javax.swing.JMenuItem mniQLPhieuMuon;
    private javax.swing.JMenuItem mniQLSach;
    private javax.swing.JMenuItem mniQLThuThu;
    private javax.swing.JMenuItem mniQuanLyHoiVien;
    private javax.swing.JMenuItem mniSachBiLoai;
    private javax.swing.JMenuItem mniSachConLai;
    private javax.swing.JMenuItem mniSachDaMuon;
    private javax.swing.JMenuItem mniSachTreHan;
    private javax.swing.JMenuItem mniTaiKhoan;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnl5;
    private javax.swing.JPanel pnlLast;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMainRight;
    private javax.swing.JPanel pnlWest;
    private javax.swing.JTable tblDeXuat;
    // End of variables declaration//GEN-END:variables
}
