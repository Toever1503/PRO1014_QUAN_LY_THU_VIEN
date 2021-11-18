/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

/**
 *
 * @author NguyenHoan
 */
public class JPanel_ThongKe extends javax.swing.JPanel {

    /**
     * Creates new form ThongKe_JPanel
     */
    public JPanel_ThongKe() {
        initComponents();
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
        pnlBiloai = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSachBiLoai = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        pnlTreHan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSachTreHan = new javax.swing.JTable();
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
            tblSachDaMuon.getColumnModel().getColumn(0).setResizable(false);
            tblSachDaMuon.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout pnlDaMuonLayout = new javax.swing.GroupLayout(pnlDaMuon);
        pnlDaMuon.setLayout(pnlDaMuonLayout);
        pnlDaMuonLayout.setHorizontalGroup(
            pnlDaMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDaMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDaMuonLayout.setVerticalGroup(
            pnlDaMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDaMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Đã mượn", pnlDaMuon);

        pnlBiloai.setBackground(new java.awt.Color(255, 255, 255));
        pnlBiloai.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblSachBiLoai.setAutoCreateRowSorter(true);
        tblSachBiLoai.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSachBiLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Tách giả", "Thể loại", "Nhà xuất bản", "Vị trí"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSachBiLoai.setGridColor(new java.awt.Color(255, 255, 255));
        tblSachBiLoai.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblSachBiLoai.setRowHeight(25);
        tblSachBiLoai.setSelectionBackground(new java.awt.Color(6, 143, 202));
        jScrollPane4.setViewportView(tblSachBiLoai);
        if (tblSachBiLoai.getColumnModel().getColumnCount() > 0) {
            tblSachBiLoai.getColumnModel().getColumn(0).setResizable(false);
            tblSachBiLoai.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        pnlBiloai.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Thu hồi");
        pnlBiloai.add(jButton1, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Bị loại", pnlBiloai);

        pnlTreHan.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblSachTreHan.setAutoCreateRowSorter(true);
        tblSachTreHan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSachTreHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Tách giả", "Thể loại", "Nhà xuất bản", "Ngày hạn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSachTreHan.setGridColor(new java.awt.Color(255, 255, 255));
        tblSachTreHan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblSachTreHan.setRowHeight(25);
        tblSachTreHan.setSelectionBackground(new java.awt.Color(6, 143, 202));
        jScrollPane2.setViewportView(tblSachTreHan);
        if (tblSachTreHan.getColumnModel().getColumnCount() > 0) {
            tblSachTreHan.getColumnModel().getColumn(0).setResizable(false);
            tblSachTreHan.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout pnlTreHanLayout = new javax.swing.GroupLayout(pnlTreHan);
        pnlTreHan.setLayout(pnlTreHanLayout);
        pnlTreHanLayout.setHorizontalGroup(
            pnlTreHanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTreHanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTreHanLayout.setVerticalGroup(
            pnlTreHanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTreHanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Trễ hạn", pnlTreHan);

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
        tblSachConLai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblSachConLaiKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblSachConLai);
        if (tblSachConLai.getColumnModel().getColumnCount() > 0) {
            tblSachConLai.getColumnModel().getColumn(0).setResizable(false);
            tblSachConLai.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout pnlConLaiLayout = new javax.swing.GroupLayout(pnlConLai);
        pnlConLai.setLayout(pnlConLaiLayout);
        pnlConLaiLayout.setHorizontalGroup(
            pnlConLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConLaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlConLaiLayout.setVerticalGroup(
            pnlConLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConLaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
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

    private void tblSachConLaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSachConLaiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSachConLaiKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlBiloai;
    private javax.swing.JPanel pnlConLai;
    private javax.swing.JPanel pnlDaMuon;
    private javax.swing.JPanel pnlTreHan;
    private javax.swing.JTable tblSachBiLoai;
    private javax.swing.JTable tblSachConLai;
    private javax.swing.JTable tblSachDaMuon;
    private javax.swing.JTable tblSachTreHan;
    // End of variables declaration//GEN-END:variables
}
