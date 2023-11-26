    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import group1.dao.SanPhamDao;
import group1.entity.SanPham;
import group1.utils.msgBox;
import group1.utils.xImage;
import group1.utils.xJDBC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

public class SanPhamJDialog extends javax.swing.JDialog {
    List<SanPham> listcart=new ArrayList<>();
    SanPhamDao dao=new SanPhamDao();
    JPanel pn;
    JPanel pnx;
    int index = 0;
    int soluong;
    TextArea textar;
    JButton btnmua;
    int soLanMua;
    List<SanPham> listbest = new ArrayList<>();
    JScrollPane scrollPane;
    JLabel lbltongtien;
    JTextField txtsoluong;

    private long currentmilis;
    public SanPhamJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        settime();
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);



        System.out.println(listbest);

        fillSanPham();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbloclock = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblten = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtfind = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quản Lý Sản Phẩm");

        lbloclock.setForeground(new java.awt.Color(255, 255, 255));
        lbloclock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_alarm_clock_25px.png"))); // NOI18N
        lbloclock.setText("00:00:00 ");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nhân Viên:");

        lblten.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblten.setForeground(new java.awt.Color(255, 255, 255));
        lblten.setText("Quang Huy");

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\icon_snow.png")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\icon_snow.png")); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\mu.png")); // NOI18N
        jLabel16.setText("jLabel16");

        jLabel13.setFont(new java.awt.Font("VNI-Bazooka", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\noel.png")); // NOI18N
        jLabel13.setText("Merry Christmas!");

        jLabel15.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\xekeo.png")); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\xekeo.png")); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel34.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel35.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel36.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel41.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel42.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel44.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(204, 102, 0));
        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 2027));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 2592));

        jButton1.setBackground(new java.awt.Color(24, 122, 74));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\xmag_search_find_export_locate_5984.png")); // NOI18N
        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtfind.setBackground(new java.awt.Color(204, 204, 204));
        txtfind.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtfind.setText("Search");

        jLabel43.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        jLabel33.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\winter.png")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(txtfind, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jButton1)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel43)
                                .addGap(183, 183, 183)
                                .addComponent(jLabel33)
                                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel33)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtfind, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton1))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel43))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2521, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(1413, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(500, 32767));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 400));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setAlignmentY(5.0F);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1126, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(288, 288, 288)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(834, Short.MAX_VALUE)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(479, 479, 479)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(647, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 656, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(524, Short.MAX_VALUE)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(311, 311, 311)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(345, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(1365, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thanh toán", jPanel3);

        jScrollPane2.setViewportView(jTabbedPane1);

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\FPTPolytechnic\\duan1\\src\\main\\java\\group1\\images\\gau.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel17))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel44)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel42))
                            .addComponent(jLabel41))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel19)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jLabel9)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblten, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(lbldongho)))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel36))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel4))
                                                        .addComponent(jLabel17))
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel44))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel42)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel41))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel19)
                                                                        .addComponent(jLabel16))
                                                                .addGap(58, 58, 58)
                                                                .addComponent(jLabel7))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(70, 70, 70)
                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(100, 100, 100)
                                                                .addComponent(jLabel18))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(8, 8, 8)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(lblten)
                                                        .addComponent(lbloclock)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel35)
                                                        .addComponent(jLabel36))
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel34))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1239, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        findSanPham();
    }//GEN-LAST:event_jButton1ActionPerformed

    void settime(){
        //     this.setIconImage(XImage.GetAppIcon());
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentmilis = System.currentTimeMillis();

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
                String formattedDate = formatter.format(new Date(currentmilis));
                lbloclock.setText(formattedDate);
            }

        });
        // Set an initial value for currentMillis
        currentmilis = System.currentTimeMillis();
        timer.start();
    }
    void fillSanPham() {

        listbest=dao.selectAll();
        for (SanPham sp : listbest) {
            String tensp = sp.getTenSP();
            double gia = sp.getGia();
            String anh = sp.getAnh();

            createPanels(tensp, gia, anh);
        }
    }

    void createPanels(String TenSP, double gia, String anh) {

        jPanel10.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));

        // Tạo JPanel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 350));
        // Thêm hình ảnh vào JPanel
        ImageIcon icon = xImage.readimage(anh);

        JLabel imageLabel = new JLabel(icon);

        panel.add(imageLabel);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        // Set the layout of the panel
        jPanel4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(Color.white);
        JPanel pn1 = new JPanel();
        pn1.setLayout(new GridLayout(3, 1));
        panel.add(pn1);

        // Thêm văn bản vào JPanel
        JLabel textLabel1 = new JLabel(TenSP);
        textLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        // Thêm giá
        DecimalFormat decimalfom=new DecimalFormat("#,###");
        String giaformat=decimalfom.format(gia);
        JLabel textLabel4 = new JLabel(giaformat);
        JPanel panelgia=new JPanel();
        panelgia.setBackground(Color.white);
        panelgia.add(textLabel4);
        textLabel4.setFont(new Font("Arial", Font.BOLD, 15));
        textLabel4.setForeground(new Color(12,113,61));
        JPanel jpanelbutton=new JPanel();
        jpanelbutton.setSize(150, 50);
        jpanelbutton.setBackground(Color.white);
        int i;
        for (i = 0; i < listbest.size(); i++) {

            btnmua = new JButton("Mua Ngay");
//             txtsoluong=new JTextField();
//             txtsoluong.setSize(60,10);
//              txtsoluong.setBackground(new Color(12,113,61));
            btnmua.setSize(50, 90);
            btnmua.setBackground(new Color(12,113,61));
            btnmua.setForeground(Color.white);
        }
        jpanelbutton.add(btnmua);
//         jpanelbutton.add(txtsoluong);
        pn1.add(textLabel1);
        pn1.add(panelgia);
        pn1.add(jpanelbutton);

        pn1.setBackground(Color.white);

        jPanel4.add(panel);
        btnmua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the border when the mouse enters the button
                panel.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
                btnmua.setBackground(Color.white);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Reset the border when the mouse exits the button
                panel.setBorder(null);

            }
        });
        btnmua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SanPham clickproduct = listbest.get(index);
                listcart.add(clickproduct);

                index++;

//               soLanMua=Integer.parseInt(txtsoluong.getText());
                // Lấy thông tin sản phẩm khi click vào nút "Mua Ngay"
                String clickedProductName = TenSP; // Tên sản phẩm
                double clickedProductPrice = gia; // Giá sản phẩm
                String clickedProductImage = anh; // Ảnh sản phẩm

                createCart(clickedProductName, clickedProductPrice, clickedProductImage);



                createHoaDon(TenSP, gia);
                System.out.println(clickproduct.getTenSP());

            }
        });

    }
    double tongtiengiohang = 0.0;

    void createCart(String tenSP, double Gia, String anh) {

        tongtiengiohang += Gia;
        JScrollPane jpcart=new JScrollPane();

//         jPanel3.add(jpcart);
        JPanel panelcart = new JPanel();

        panelcart.setPreferredSize(new Dimension(500, 100));
        panelcart.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        panelcart.setBackground(Color.white);
        // Thêm hình ảnh vào JPanel
        ImageIcon icon = xImage.readimage(anh);
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImage);

        JLabel imageLabel = new JLabel(newIcon);

        panelcart.add(imageLabel);
        DecimalFormat decimalfom=new DecimalFormat("#,###");
        String giaformat=decimalfom.format(Gia);
        JLabel textLabel11 = new JLabel(tenSP + "       " + giaformat + "       " + soluong);

        panelcart.add(textLabel11);
        //ảnh tru
        ImageIcon icontru = new ImageIcon("src/main/resources/images/tru.png");
        Image imagetru = icontru.getImage();
        Image newImagee = imagetru.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon newIconn = new ImageIcon(newImagee);
        JLabel labeltru=new JLabel(newIconn);
        // Add a mouse listener to the "trừ" label
        labeltru.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Remove the entire panelcart from the jPanel5
                jPanel5.remove(panelcart);

                // Repaint and revalidate to update the layout
                jPanel5.repaint();
                jPanel5.revalidate();
            }
        });
        panelcart.add(labeltru);




        jPanel5.setPreferredSize(new Dimension(500, 700));
        jPanel5.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        Border emptyBorder1 = BorderFactory.createEmptyBorder(10, 30, 0, 10);
        jPanel5.setBorder(emptyBorder1);
        jPanel5.add(panelcart);
//       jScrollPanecart.add(jPanel5);




        if (index <= 1) {
            createthanhtoan(tenSP, Gia);
        }
    }

    void createthanhtoan(String Tensp, double Gia) {

        JPanel pnx = new JPanel();
        pnx.setBackground(new Color(204,204,204));
        textar = new TextArea();
        textar.setSize(100, 200);
        pnx.setSize(500, 534);
        jPanel7.setLayout(new GridLayout(2, 1));
        Border emptyBorder1 = BorderFactory.createEmptyBorder(10, 10, 300, 10);
        jPanel7.setBorder(emptyBorder1);
        jPanel7.add(textar);
        JPanel panelthanhtoan = new JPanel();
        textar.setText("Tên đơn hàng:" + Tensp + "\n"
                + "                                            Số lượng: xxx" + "\n"
                + "                                           Thành tiền: " + Gia
        );

        JButton btnthanhtoan = new JButton("Thanh toán");
        JPanel pnthanhtoan = new JPanel();
        pnthanhtoan.setLayout(new GridLayout(1, 2));
        pnthanhtoan.add(new JLabel("Tổng Tiền: "));
        lbltongtien = new JLabel();
        lbltongtien.setBackground(Color.red);
        panelthanhtoan.add(lbltongtien);

        panelthanhtoan.add(btnthanhtoan);
        btnthanhtoan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                thanhtoan(textar.getText());
            }

        });
        panelthanhtoan.add(pnthanhtoan);
        panelthanhtoan.setBackground(new Color(204,204,204));
        jPanel7.add(panelthanhtoan);

        pnx.add(jPanel7);
        jPanel10.add(pnx);
    }

    // Khai báo một biến để lưu trữ thông tin sản phẩm đã mua
    StringBuilder hoaDonBuilder = new StringBuilder();

    void createHoaDon(String tenSP, double gia) {
        // Thêm thông tin sản phẩm mới vào hóa đơn
        String newProductInfo = "Tên đơn hàng: " + tenSP + "\n"
                + "                                            Số lượng: " + index + "      " + "Gia: " + gia + "      "
                + "        Thành tiền: " + tongtiengiohang + "\n";

        // Thêm thông tin mới vào StringBuilder
        hoaDonBuilder.append(newProductInfo);

        // Cập nhật nội dung của TextArea với toàn bộ thông tin đã mua
        textar.setText("                                                   Tên Công Ty: ABC Company\n\n                                   "
                +      "                                                   Hóa Đơn:\n" + hoaDonBuilder.toString());

    }
    void thanhtoan(String textar){
        String path ="src/main/resources/pdf";
        JFileChooser j = new JFileChooser(path);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();

            // Tạo tệp PDF tại đường dẫn đã chọn
            Document doc = new Document();

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path + "/output.pdf"));
                doc.open();

                // Thêm nội dung vào tệp PDF (ví dụ: dùng JTextArea)
                JTextArea textArea = new JTextArea();
                doc.add(new Paragraph(textar));

                int option=JOptionPane.showConfirmDialog(this, "Đã lưu tệp PDF thành công! Bạn có muốn mở thư mục không","Xác nhận",JOptionPane.YES_OPTION);
                if(option==JOptionPane.YES_OPTION){
                    try {
                        Desktop.getDesktop().open(new File(path));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Có lỗi khi mở");
                    }

                }
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Có lỗi khi lưu tệp PDF!");
            } finally {
                doc.close();
            }
        }

    }
    public double tinhTongTien(double gia) {
        return gia;
    }
    void getForm(){

    }
    void insert(){
        try {
            dao.insert(new SanPham());
            this.fillSanPham();
            msgBox.alert(this, "Đã thêm nhân viên thành công");
        } catch (Exception e) {
        }
    }
    void findSanPham(){
        try {
            List<SanPham>  list = (List<SanPham>) Arrays.asList(dao.selectById(txtfind.getText()));
            jPanel4.removeAll();
            for (SanPham sp : list) {
                String tensp = sp.getTenSP();
                double gia = sp.getGia();
                String anh = sp.getAnh();

                createPanels(tensp, gia, anh);
                jPanel4.repaint();
                jPanel4.revalidate();
                if(list!=null){
                    System.out.println("ko r");
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

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
            java.util.logging.Logger.getLogger(SanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SanPhamJDialog dialog = new SanPhamJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbloclock;
    private javax.swing.JLabel lblten;
    private javax.swing.JTextField txtfind;
    // End of variables declaration//GEN-END:variables
}
