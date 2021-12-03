/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Helper;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.Exchanger;
import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import views.QLHoaDonDenBu;
import views.QLHoaDonNhapSach;
import views.QLHoiVien_JPanel;
import views.QLPhieuMuon_JPanel;
import views.QLSach_JPanel;

/**
 *
 * @author haunv
 */
public class QR_SCANNER extends javax.swing.JDialog implements Closeable {

    private static final long serialVersionUID = 1L;

    private Webcam webcam = null;
    private java.awt.image.BufferedImage image = null;
    private volatile Result result = null;
    private Exchanger<String> exchanger = new Exchanger<String>();
    private String ACTION_TYPE = null;

    /**
     * Creates new form QR_SCANNER
     */
    public QR_SCANNER(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public QR_SCANNER(String action) {
        this.ACTION_TYPE = action;
        initComponents();
        init();
    }

    public void init() {
        setLayout(new FlowLayout());
        setTitle("Capture");

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    close();
                } catch (IOException ex) {
                    Logger.getLogger(QR_SCANNER.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.QVGA.getSize());

        webcam.open();

        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        add(webcamPanel);

        try {
            pack();
            setVisible(true);
        } catch (Exception e) {
            System.out.println("bug");
        }

        System.out.println("here");
        final Thread daemon = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isVisible()) {
                    scanner();
                }
            }
        });
        daemon.setDaemon(true);

        daemon.start();
    }

    public void scanner() {
        if (!webcam.isOpen()) {
            return;
        }
        if ((image = webcam.getImage()) == null) {
            return;
        }

        try {
            result = new MultiFormatReader().decode(toBinaryBitmap(this.image));
        } catch (NotFoundException e) {
            return;
            // fall thru, it means there is no QR code in image
        }
        if (result != null) {
            System.out.println(result.getText());

            String[] data = {};

            try {
                data = result.getText().split("-");
            } catch (Exception e) {
            }

            if (data.length == 2) {
                String key = data[0];
                
                if (ACTION_TYPE.equalsIgnoreCase("HOME")) {
                    if (key.equalsIgnoreCase("sach")) {
                        QLSach_JPanel.getInstance().showSach(data[1]);
                         System.out.println("sach");
                    } else if (key.equalsIgnoreCase("hoivien")) {
                        QLHoiVien_JPanel.getInstance().showHoiVien(data[1]);
                    } else if (key.equalsIgnoreCase("phieumuon")) {
                        QLPhieuMuon_JPanel.getInstance().showPhieuMuon(data[1]);
                    } else if (key.equalsIgnoreCase("hoadon")) {
                        QLHoaDonDenBu.getInstance().showHoaDon(data[1]);
                    } else {
                        QLHoaDonNhapSach.getInstance().showNhapSach(data[1]);
                    }
                    try {
                        close();
                    } catch (IOException ex) {
                        Logger.getLogger(QR_SCANNER.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (ACTION_TYPE.equalsIgnoreCase("PHIEU_MUON")) {

                } else if (ACTION_TYPE.equalsIgnoreCase("HOA_DON")) {
                }
            }

        }
    }

    private static BinaryBitmap toBinaryBitmap(BufferedImage image) {
        return new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
    }

    @Override
    public void close() throws IOException {
        webcam.close();
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(QR_SCANNER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QR_SCANNER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QR_SCANNER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QR_SCANNER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                QR_SCANNER dialog = new QR_SCANNER(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
////                dialog.setVisible(true);
//            }
//        });
        new QR_SCANNER("home");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
