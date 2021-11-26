/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Helper;

import java.awt.image.BufferedImage;
import com.github.sarxos.webcam.Webcam;
import java.io.Closeable;
import javax.swing.JFrame;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import views.QLPhieuMuon_JPanel;

/**
 *
 * @author haunv
 */
public class QrCapture extends JFrame implements Closeable {

    private static final long serialVersionUID = 1L;

    private Webcam webcam = null;
    private BufferedImage image = null;
    private volatile Result result = null;
    private Exchanger<String> exchanger = new Exchanger<String>();
    private String ACTION_TYPE = null;
    private static QrCapture instance;

    /**
     * Creates new form QrCapture
     */
    public QrCapture(String actionType) {
        ACTION_TYPE = actionType;
        initComponents();
        this.init();
    }

    public static QrCapture getInsance(String actionType) {
        if (instance == null) {
            instance = new QrCapture(actionType);
        }
        return instance;
    }

    public void show() {
//        repaint();
//        setVisible(true);
    }

    public void init() {
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.QVGA.getSize());
        webcam.open();

        add(new WebcamPanel(webcam));

        pack();
        setVisible(true);

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

    @Override
    public void close() {
        webcam.close();
    }

    private void scanner() {
        if (!webcam.isOpen()) {
            return;
        }
        if ((image = webcam.getImage()) == null) {
            return;
        }

        try {
            result = new MultiFormatReader().decode(toBinaryBitmap(image));
        } catch (NotFoundException e) {
            return;
            // fall thru, it means there is no QR code in image
        }
        if (result != null) {
            if (ACTION_TYPE.equalsIgnoreCase("PHIEU_MUON")) {
                String check = QLPhieuMuon_JPanel.getInstance().addSachFromSacanner(result.getText());
                if (check != null) {
                    JOptionPane.showMessageDialog(this, "Đã thêm " + check);
                }
            }
        }
    }

    private static BinaryBitmap toBinaryBitmap(BufferedImage image) {
        return new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCANNER");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.FlowLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
        webcam.close();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(QrCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QrCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QrCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QrCapture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                QrCapture qr = new QrCapture("");
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                QrCapture qr = new QrCapture("");
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
