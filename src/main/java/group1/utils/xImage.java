/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author numpa
 */

/* Đây là file để xử lý hình ảnh để ảnh lên label dễ dàng hơn */
public class xImage {
    /**
     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
     */
    public static Image getAppIcon() {
        URL url = xImage.class.getResource("/images/logo.png");
        return new ImageIcon(url).getImage();
    }

    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     * 
     * @param src là đối tượng file ảnh
     */
    public static void save(File src) {
        File dir = new File("logos", src.getName());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            Path source = Paths.get(src.getAbsolutePath());
            Path destination = Paths.get(dir.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Đọc hình ảnh logo chuyên đề
     * 
     * @param fileName là tên file logo
     * @return ảnh đọc được
     */
    public static ImageIcon read(String filename) {
        File path = new File("logos", filename);
        return new ImageIcon(
                new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    }

    public static ImageIcon readimage(String FileName) {
        File path = new File("src/main/resources/images", FileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
