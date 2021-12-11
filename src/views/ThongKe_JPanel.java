/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import DAO.SachDAO;
import DAO.ThongKeDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NguyenHoan
 */
public final class ThongKe_JPanel extends javax.swing.JPanel {

    private ThongKeDAO thongKeDAO;
    private SachDAO sachDAO;

    private static ThongKe_JPanel instance;

    /**
     * Creates new form ThongKe_JPanel
     */
    private ThongKe_JPanel() {
        initComponents();
        this.init();
    }

    private void init() {
        this.thongKeDAO = ThongKeDAO.getInstance();
        this.sachDAO = SachDAO.getInstance();
        this.fillTableSachDaMuon();
//        this.fillTableSachBiLoai();

        this.fillTableSachConLai();
    }

    void fillTableDaMuon() {
        DefaultTableModel model = (DefaultTableModel) this.tblSachDaMuon.getModel();
        model.setRowCount(0);
        List<Object[]> list = this.thongKeDAO.getSachDaMuon();
//        list.forEach(row -> {
//            model.addRow(new Object[]{row[0],row[1],row[2],row[3],row[4],row[0],row[0]
//            });
//        });
    }

    public static ThongKe_JPanel getInstance() {
        if (instance == null) {
            instance = new ThongKe_JPanel();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlDaMuon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSachDaMuon = new javax.swing.JTable();
        pnlTreHan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoiVienTreHan = new javax.swing.JTable();
        pnlConLai = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSachConLai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        pnlDaMuon.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setColumnHeaderView(null);

        tblSachDaMuon.setAutoCreateRowSorter(true);
        tblSachDaMuon.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSachDaMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Tách giả", "Thể loại", "Nhà xuất bản", "Ngày mượn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSachDaMuon.setGridColor(new java.awt.Color(255, 255, 255));
        tblSachDaMuon.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblSachDaMuon.setRowHeight(25);
        tblSachDaMuon.setSelectionBackground(new java.awt.Color(6, 143, 202));
        jScrollPane1.setViewportView(tblSachDaMuon);
        if (tblSachDaMuon.getColumnModel().getColumnCount() > 0) {
            tblSachDaMuon.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout pnlDaMuonLayout = new javax.swing.GroupLayout(pnlDaMuon);
        pnlDaMuon.setLayout(pnlDaMuonLayout);
        pnlDaMuonLayout.setHorizontalGroup(
            pnlDaMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDaMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDaMuonLayout.setVerticalGroup(
            pnlDaMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDaMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Đã mượn", pnlDaMuon);

        pnlTreHan.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblHoiVienTreHan.setAutoCreateRowSorter(true);
        tblHoiVienTreHan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblHoiVienTreHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hội viên", "Tên hội viên", "Mã phiếu mượn", "Ngày mượn", "Ngày trả", "Số ngày trễ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoiVienTreHan.setGridColor(new java.awt.Color(255, 255, 255));
        tblHoiVienTreHan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblHoiVienTreHan.setRowHeight(25);
        tblHoiVienTreHan.setSelectionBackground(new java.awt.Color(6, 143, 202));
        jScrollPane2.setViewportView(tblHoiVienTreHan);
        if (tblHoiVienTreHan.getColumnModel().getColumnCount() > 0) {
            tblHoiVienTreHan.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout pnlTreHanLayout = new javax.swing.GroupLayout(pnlTreHan);
        pnlTreHan.setLayout(pnlTreHanLayout);
        pnlTreHanLayout.setHorizontalGroup(
            pnlTreHanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTreHanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTreHanLayout.setVerticalGroup(
            pnlTreHanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTreHanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hội viên trễ hạn", pnlTreHan);

        pnlConLai.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblSachConLai.setAutoCreateRowSorter(true);
        tblSachConLai.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSachConLai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Tách giả", "Thể loại", "Nhà xuất bản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSachConLai.setGridColor(new java.awt.Color(255, 255, 255));
        tblSachConLai.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblSachConLai.setRowHeight(25);
        tblSachConLai.setSelectionBackground(new java.awt.Color(6, 143, 202));
        jScrollPane3.setViewportView(tblSachConLai);
        if (tblSachConLai.getColumnModel().getColumnCount() > 0) {
            tblSachConLai.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout pnlConLaiLayout = new javax.swing.GroupLayout(pnlConLai);
        pnlConLai.setLayout(pnlConLaiLayout);
        pnlConLaiLayout.setHorizontalGroup(
            pnlConLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConLaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlConLaiLayout.setVerticalGroup(
            pnlConLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConLaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Còn lại", pnlConLai);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ");
        jLabel1.setPreferredSize(new java.awt.Dimension(95, 100));
        add(jLabel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    void fillTableSachDaMuon() {
        DefaultTableModel model = (DefaultTableModel) this.tblSachDaMuon.getModel();
        model.setRowCount(0);
        List<Object[]> list = this.thongKeDAO.getSachDaMuon();
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{i + 1, list.get(i)[0], list.get(i)[1], list.get(i)[2], list.get(i)[3], list.get(i)[4], list.get(i)[5]});
        }
    }

//    void fillTableSachBiLoai() {
//        DefaultTableModel model = (DefaultTableModel) this.tblSachBiLoai.getModel();
//        model.setRowCount(0);
//        List<Object[]> list = this.thongKeDAO.getSachBiLoai();
//        for (int i = 0; i < list.size(); i++) {
//            model.addRow(new Object[]{i + 1, list.get(i)[0], list.get(i)[1], list.get(i)[2], list.get(i)[3], list.get(i)[4], list.get(i)[5]});
//        }
//    }

    void fillTableSachTreHan() {
        DefaultTableModel model = (DefaultTableModel) this.tblSachTreHan.getModel();

        model.setRowCount(0);
        List<Object[]> list = this.thongKeDAO.getHoiVienTreHan();
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{i + 1, list.get(i)[0], list.get(i)[1], list.get(i)[2], list.get(i)[3], list.get(i)[4], list.get(i)[5]});
        }
    }

    void fillTableSachConLai() {
        DefaultTableModel model = (DefaultTableModel) this.tblSachConLai.getModel();
        model.setRowCount(0);
        List<Object[]> list = this.thongKeDAO.getSachConLai();
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{i + 1, list.get(i)[0], list.get(i)[1], list.get(i)[2], list.get(i)[3], list.get(i)[4], list.get(i)[5]});
        }
    }

//    void thuHoi() {
//        if (!Helper.Auth.isManager()) {
//            MsgBox.alert_WARNING(this, "Bạn không có quyền cho thao tác này!");
//            return;
//        }
//        for (int row : this.tblSachBiLoai.getSelectedRows()) {
//            Long maSach = (Long) this.tblSachBiLoai.getValueAt(row, 2);
//            this.sachDAO.delete(maSach);
//        }
//        MsgBox.alert_INFORMATION(this, "Thu hồi thành cống!");
//    }

//    public static void main(String[] args) {
//        javax.swing.JFrame frame = new javax.swing.JFrame();
//        frame.setSize(900, 800);
//        frame.add(new ThongKe_JPanel());
//        frame.setVisible(true);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlConLai;
    private javax.swing.JPanel pnlDaMuon;
    private javax.swing.JPanel pnlTreHan;
    private javax.swing.JTable tblSachConLai;
    private javax.swing.JTable tblSachDaMuon;
    // End of variables declaration//GEN-END:variables
}
