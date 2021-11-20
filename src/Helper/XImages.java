/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Nguyen Hoan
 */
public class XImages {

    public static final Image APP_ICON;
    public static final ImageIcon APP_ICON_1;

    static {
        // Tải biểu tượng ứng dụng 
        String file = "/Images_Icon/library0.png";      //icon là thư mục con của src
        APP_ICON = new ImageIcon(XImages.class.getResource(file)).getImage();
        APP_ICON_1 = new ImageIcon(XImages.class.getResource(file));
    }
}
