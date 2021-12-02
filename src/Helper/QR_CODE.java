/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haunv
 */
public class QR_CODE {

    public static final String CHARSET = "UTF-8";

    public static final int IMAGE_HEIGHT = 500;
    public static final int IMAGE_WIDTH = 500;

    // method create qr-code image with input is key and path is file will be created
    public static boolean generateQRcode(String data, String path) {
        // the BitMatrix class represents the 2D matrix of bits
        // MultiFormatWriter is a factory class that finds the appropriate Writer
        // subclass for the BarcodeFormat requested and encodes the barcode with the
        // supplied contents.

        try {
            Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(CHARSET), CHARSET),
                    BarcodeFormat.QR_CODE, IMAGE_WIDTH, IMAGE_HEIGHT);
            MatrixToImageWriter.writeToStream(matrix, path.substring(path.lastIndexOf('.') + 1),
                    new FileOutputStream(path));
            return true;
        } catch (WriterException e) {
            Logger.getLogger(QR_CODE.class.getName()).log(Level.SEVERE, "Write qr-code failed", e);
        } catch (IOException e2) {
            Logger.getLogger(QR_CODE.class.getName()).log(Level.SEVERE, "Qr-code Exception ~~", e2);
        }

        return false;
    }
    public static void main(String[] args) {
        String[] a = {};
        System.out.println(a.length);
    }

}
