/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group1.views;

import group1.utils.Auth;
import group1.utils.msgBox;
import group1.utils.xImage;
import java.io.File;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author nu///mpa
 */
public class JMainFrame extends javax.swing.JFrame {
    // demo
    /**
     * Creates new form JMainFrame
     */
    public JMainFrame() {
        initComponents();
        setIconImage(xImage.getAppIcon());
        setTitle("Coffee Shop Management");
        setLocationRelativeTo(null);
        startClock();
        displayUserInfo();
        // new SanPhamJDialog(this,true).setVisible(true);

    }

    void startClock() {
        class TimeClock extends Thread {

            @Override
            public void run() {
                while (true) {
                    lbl_clock.setText(new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()));
                }
            }
        }
        TimeClock timeClock = new TimeClock();
        timeClock.start();
    }

    void displayUserInfo() {
        String userID = Auth.user.getMaNV();
        String role = Auth.user.getVaitro();
        lbl_user.setText("UserID: " + userID + " |  Role: " + role);
    }

    void openWebsite() {
        try {
            Desktop.getDesktop().browse(new URI("https://hisu87.github.io/guide/"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(JMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void openChangePass() {
        new ChangePasswordJDialog(this, true).setVisible(true);
    }

    void openLogout() {
        if (msgBox.confirm(this, "Bạn có muốn đăng xuất không?")) {
            this.dispose();
            new LoginJDialog(this, true).setVisible(true);
        }
    }

    void openExit() {
        if (msgBox.confirm(this, "Bạn có muốn thoát chương trình không?")) {
            System.exit(0);
        }
    }

    void openProducts() {
        new QuanLySanPham(this, true).setVisible(true);
    }

    void openRecipe() {
        new CongThucNguyenLieuJDialog(this, true).setVisible(true);
    }

    void openIngridients() {
        new QLNguyenLieuJDialog(this, true).setVisible(true);
    }

    void openInvoice() {
        new HoaDonJDialog().setVisible(true);
    }

    void openSanPham() {
        new SanPhamJDialog(this, true).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jToolBar = new javax.swing.JToolBar();
        btn_TinhTien = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btn_NguyenLieu = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        btn_Recipe = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        btn_Product = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        btn_Revenue = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        pnl_center = new javax.swing.JPanel();
        lbl_centerlogo = new javax.swing.JLabel();
        pnl_statusbar = new javax.swing.JPanel();
        lbl_user = new javax.swing.JLabel();
        lbl_clock = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_system = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        changepass = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        logout = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menu_managing = new javax.swing.JMenu();
        products = new javax.swing.JMenuItem();
        recipe = new javax.swing.JMenuItem();
        ingridients = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        invoice = new javax.swing.JMenuItem();
        employees = new javax.swing.JMenuItem();
        menu_statitics = new javax.swing.JMenu();
        revenue = new javax.swing.JMenuItem();
        chart = new javax.swing.JMenuItem();
        menu_about = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 127, 33));

        jToolBar.setBackground(new java.awt.Color(226, 109, 92));
        jToolBar.setRollover(true);

        btn_TinhTien.setForeground(new java.awt.Color(255, 255, 255));
        btn_TinhTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-invoice-20.png"))); // NOI18N
        btn_TinhTien.setText("Tính Tiền");
        btn_TinhTien.setFocusable(false);
        btn_TinhTien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_TinhTien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_TinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TinhTienActionPerformed(evt);
            }
        });
        jToolBar.add(btn_TinhTien);
        jToolBar.add(jSeparator6);

        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-invoice-20 (1).png"))); // NOI18N
        jButton2.setText("Tra cứu hóa đơn");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar.add(jButton2);
        jToolBar.add(jSeparator11);

        btn_NguyenLieu.setForeground(new java.awt.Color(255, 255, 255));
        btn_NguyenLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ingredient-24.png"))); // NOI18N
        btn_NguyenLieu.setText("Nhập Nguyên Liệu");
        btn_NguyenLieu.setFocusable(false);
        btn_NguyenLieu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_NguyenLieu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_NguyenLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NguyenLieuActionPerformed(evt);
            }
        });
        jToolBar.add(btn_NguyenLieu);
        jToolBar.add(jSeparator12);

        btn_Recipe.setForeground(new java.awt.Color(255, 255, 255));
        btn_Recipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_book_20px_1.png"))); // NOI18N
        btn_Recipe.setText("Nhập Công Thức");
        btn_Recipe.setFocusable(false);
        btn_Recipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Recipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Recipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RecipeActionPerformed(evt);
            }
        });
        jToolBar.add(btn_Recipe);
        jToolBar.add(jSeparator13);

        btn_Product.setForeground(new java.awt.Color(255, 255, 255));
        btn_Product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poolside-bar-20.png"))); // NOI18N
        btn_Product.setText("Nhập Sản Phẩm");
        btn_Product.setFocusable(false);
        btn_Product.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Product.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProductActionPerformed(evt);
            }
        });
        jToolBar.add(btn_Product);
        jToolBar.add(jSeparator14);

        btn_Revenue.setForeground(new java.awt.Color(255, 255, 255));
        btn_Revenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_report_card_20px.png"))); // NOI18N
        btn_Revenue.setText("Doanh Thu");
        btn_Revenue.setFocusable(false);
        btn_Revenue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Revenue.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Revenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RevenueActionPerformed(evt);
            }
        });
        jToolBar.add(btn_Revenue);
        jToolBar.add(jSeparator15);

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-positive-dynamic-20.png"))); // NOI18N
        jButton1.setText("Biểu Đồ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar.add(jButton1);
        jToolBar.add(jSeparator16);

        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_help_20px.png"))); // NOI18N
        jButton3.setText("Hướng Dẫn");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar.add(jButton3);
        jToolBar.add(jSeparator18);

        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_logout_rounded_up_20px.png"))); // NOI18N
        jButton4.setText("Đăng Xuất");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar.add(jButton4);
        jToolBar.add(jSeparator4);

        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_exit_20px.png"))); // NOI18N
        jButton5.setText("Exit");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar.add(jButton5);

        pnl_center.setBackground(new java.awt.Color(249, 249, 249));

        lbl_centerlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/longlogo.png"))); // NOI18N

        javax.swing.GroupLayout pnl_centerLayout = new javax.swing.GroupLayout(pnl_center);
        pnl_center.setLayout(pnl_centerLayout);
        pnl_centerLayout.setHorizontalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_centerlogo, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_centerLayout.setVerticalGroup(
            pnl_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_centerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lbl_centerlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnl_statusbar.setBackground(new java.awt.Color(0, 175, 84));

        lbl_user.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(242, 240, 235));
        lbl_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_username_25px.png"))); // NOI18N

        lbl_clock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_clock.setForeground(new java.awt.Color(242, 240, 235));
        lbl_clock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_alarm_clock_25px.png"))); // NOI18N

        javax.swing.GroupLayout pnl_statusbarLayout = new javax.swing.GroupLayout(pnl_statusbar);
        pnl_statusbar.setLayout(pnl_statusbarLayout);
        pnl_statusbarLayout.setHorizontalGroup(
            pnl_statusbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_statusbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_user, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_clock, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_statusbarLayout.setVerticalGroup(
            pnl_statusbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_statusbarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_statusbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_clock)
                    .addComponent(lbl_user))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_statusbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_statusbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 117, 74));

        menu_system.setBackground(new java.awt.Color(0, 117, 74));
        menu_system.setText("Hệ Thống");
        menu_system.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_system.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_system.setPreferredSize(new java.awt.Dimension(70, 22));
        menu_system.add(jSeparator1);

        changepass.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        changepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_password_20px.png"))); // NOI18N
        changepass.setText("Đổi mật khẩu");
        changepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepassActionPerformed(evt);
            }
        });
        menu_system.add(changepass);
        menu_system.add(jSeparator2);

        logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_logout_rounded_up_20px.png"))); // NOI18N
        logout.setText("Đăng Xuất");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        menu_system.add(logout);
        menu_system.add(jSeparator10);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_exit_20px.png"))); // NOI18N
        exit.setText("Thoát");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        menu_system.add(exit);
        menu_system.add(jSeparator8);

        jMenuBar1.add(menu_system);

        menu_managing.setBackground(new java.awt.Color(0, 117, 74));
        menu_managing.setText("Quản Lý");
        menu_managing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_managing.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_managing.setPreferredSize(new java.awt.Dimension(70, 22));

        products.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-poolside-bar-20.png"))); // NOI18N
        products.setText("Sản Phảm");
        products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsActionPerformed(evt);
            }
        });
        menu_managing.add(products);

        recipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_book_20px_1.png"))); // NOI18N
        recipe.setText("Công Thức");
        recipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recipeActionPerformed(evt);
            }
        });
        menu_managing.add(recipe);

        ingridients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-ingredient-24.png"))); // NOI18N
        ingridients.setText("Nguyên Liệu");
        ingridients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ingridientsMouseEntered(evt);
            }
        });
        ingridients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingridientsActionPerformed(evt);
            }
        });
        menu_managing.add(ingridients);
        menu_managing.add(jSeparator3);

        invoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-invoice-20.png"))); // NOI18N
        invoice.setText("Hóa Đơn");
        menu_managing.add(invoice);

        employees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_people_20px.png"))); // NOI18N
        employees.setText("Nhân Viên");
        employees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesActionPerformed(evt);
            }
        });
        menu_managing.add(employees);

        jMenuBar1.add(menu_managing);

        menu_statitics.setBackground(new java.awt.Color(0, 117, 74));
        menu_statitics.setText("Thống Kê");
        menu_statitics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_statitics.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_statitics.setPreferredSize(new java.awt.Dimension(70, 22));

        revenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_report_card_20px.png"))); // NOI18N
        revenue.setText("Doanh Thu");
        revenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenueActionPerformed(evt);
            }
        });
        menu_statitics.add(revenue);

        chart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-positive-dynamic-20.png"))); // NOI18N
        chart.setText("Biểu đồ");
        chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartActionPerformed(evt);
            }
        });
        menu_statitics.add(chart);

        jMenuBar1.add(menu_statitics);

        menu_about.setText("...");
        menu_about.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_about.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menu_about.setPreferredSize(new java.awt.Dimension(70, 22));
        jMenuBar1.add(menu_about);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NguyenLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NguyenLieuActionPerformed
        // TODO add your handling code here:
        openIngridients();
    }//GEN-LAST:event_btn_NguyenLieuActionPerformed

    private void btn_RevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RevenueActionPerformed
        // TODO add your handling code here:
        openRevenue();
    }//GEN-LAST:event_btn_RevenueActionPerformed

    private void btn_TinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TinhTienActionPerformed
        // TODO add your handling code here:
        openSanPham();
    }//GEN-LAST:event_btn_TinhTienActionPerformed

    private void btn_RecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RecipeActionPerformed
        // TODO add your handling code here:
        openRecipe();
    }//GEN-LAST:event_btn_RecipeActionPerformed

    private void btn_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProductActionPerformed
        // TODO add your handling code here:
        openProducts();
    }//GEN-LAST:event_btn_ProductActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        openChart();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        openWebsite();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        openLogout();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        openExit();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        openInvoice();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_tinhtienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_tinhtienActionPerformed
        // TODO add your handling code here:
        openSanPham();
    }// GEN-LAST:event_btn_tinhtienActionPerformed

    private void btn_importRecipeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_importRecipeActionPerformed
        // TODO add your handling code here:
        openRecipe();
    }// GEN-LAST:event_btn_importRecipeActionPerformed

    private void employeesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_employeesActionPerformed
        // TODO add your handling code here:
        openEmployees();
    }// GEN-LAST:event_employeesActionPerformed

    private void revenueActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_revenueActionPerformed
        // TODO add your handling code here:
        openRevenue();
    }// GEN-LAST:event_revenueActionPerformed

    private void recipeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_recipeActionPerformed
        // TODO add your handling code here:
        openRecipe();
    }// GEN-LAST:event_recipeActionPerformed

    private void ingridientsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ingridientsActionPerformed
        // TODO add your handling code here:
        openIngridients();
    }// GEN-LAST:event_ingridientsActionPerformed

    private void chartActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chartActionPerformed
        // TODO add your handling code here:
        openChart();
    }// GEN-LAST:event_chartActionPerformed

    private void changepassActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_changepassActionPerformed
        // TODO add your handling code here:
        openChangePass();
    }// GEN-LAST:event_changepassActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        openLogout();
    }// GEN-LAST:event_logoutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        openExit();
    }// GEN-LAST:event_exitActionPerformed

    private void productsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_productsActionPerformed
        // TODO add your handling code here:
        openProducts();
    }// GEN-LAST:event_productsActionPerformed

    private void btn_createReceiptMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_createReceiptMouseClicked
        // TODO add your handling code here:
        openInvoice();
    }// GEN-LAST:event_btn_createReceiptMouseClicked

    private void btn_HuongDanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_HuongDanActionPerformed
        // TODO add your handling code here:
        openWebsite();
    }// GEN-LAST:event_btn_HuongDanActionPerformed

    private void btn_importIngridientsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_importIngridientsActionPerformed
        // TODO add your handling code here:
        openIngridients();
    }// GEN-LAST:event_btn_importIngridientsActionPerformed

    private void btn_importProductActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_importProductActionPerformed
        // TODO add your handling code here:
        openProducts();
    }// GEN-LAST:event_btn_importProductActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        openLogout();
    }// GEN-LAST:event_btn_logoutActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        openExit();
    }// GEN-LAST:event_btn_exitActionPerformed

    private void ingridientsMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ingridientsMouseEntered
        ingridients.setVisible(false);
    }// GEN-LAST:event_ingridientsMouseEntered

    void openChart() {
        ChartJDialog chartJDialog = new ChartJDialog(this, true);
        chartJDialog.setVisible(true);
    }

    void openEmployees() {
        new QuanLyNhanVien(this, true).setVisible(true);
    }

    void openRevenue() {
        new DoanhThuJDialog(this, true).setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_NguyenLieu;
    private javax.swing.JButton btn_Product;
    private javax.swing.JButton btn_Recipe;
    private javax.swing.JButton btn_Revenue;
    private javax.swing.JButton btn_TinhTien;
    private javax.swing.JMenuItem changepass;
    private javax.swing.JMenuItem chart;
    private javax.swing.JMenuItem employees;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuItem ingridients;
    private javax.swing.JMenuItem invoice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lbl_centerlogo;
    private javax.swing.JLabel lbl_clock;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenu menu_about;
    private javax.swing.JMenu menu_managing;
    private javax.swing.JMenu menu_statitics;
    private javax.swing.JMenu menu_system;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_statusbar;
    private javax.swing.JMenuItem products;
    private javax.swing.JMenuItem recipe;
    private javax.swing.JMenuItem revenue;
    // End of variables declaration//GEN-END:variables
}
