/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group1.views;

import group1.dao.CongThucDAO;
import group1.dao.HoaDonDAO;
import group1.entity.HoaDon;
import group1.entity.HoaDonChiTiet;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDonJDialog extends javax.swing.JFrame {

    HoaDonDAO dao = new HoaDonDAO();
    int row = -1;

    /**
     * Creates new form HoaDonJDialog
     */
    public HoaDonJDialog() {
        initComponents();
        init();

    }

    void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        filTableHD();
    }

    void filTableHD() {
        DefaultTableModel model = (DefaultTableModel) tbl_hoadon.getModel();
        model.setRowCount(0);
        try {
            List<HoaDon> list = dao.selectAll();
            for (HoaDon hd : list) {
                Object[] row = {
                        hd.getMaHD(),
                        hd.getMaNV(),
                        hd.getNgayTao(),
                        hd.getTrangThai(),
                        hd.getTongCong(),
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    // void fillTableHDCT() {
    // DefaultTableModel model = (DefaultTableModel) tbl_hoadonct.getModel();
    // model.setRowCount(0);
    // try {
    // List<HoaDonChiTiet> list = dao.selectAll();
    // for (HoaDon hd : list) {
    // Object[] row = {
    // hd.getMaHD(),
    // hd.getMaNV(),
    // hd.getNgayTao(),
    // hd.getTrangThai(),
    // hd.getTongCong(),
    // };
    // model.addRow(row);
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
    // }
    // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_hoadon = new javax.swing.JTable();
        txt_search2 = new javax.swing.JTextField();
        btn_search2 = new javax.swing.JButton();
        btn_first1 = new javax.swing.JButton();
        btn_next1 = new javax.swing.JButton();
        btn_previous1 = new javax.swing.JButton();
        btn_last1 = new javax.swing.JButton();
        btn_cut = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        txt_search4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_hoadonct = new javax.swing.JTable();
        btn_last2 = new javax.swing.JButton();
        btn_previous2 = new javax.swing.JButton();
        btn_next2 = new javax.swing.JButton();
        btn_first2 = new javax.swing.JButton();
        btn_cut1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(153, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Quản lý hóa đơn");

        jTabbedPane3.setBackground(new java.awt.Color(51, 153, 0));

        jPanel9.setBackground(new java.awt.Color(0, 102, 51));

        tbl_hoadon.setAutoCreateRowSorter(true);
        tbl_hoadon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { "HD01", "NV01", null, null, null },
                        { "HD02", "NV02", null, null, null },
                        { "HD03", "NV03", null, null, null },
                        { "", "", null, null, null }
                },
                new String[] {
                        "Mã hóa đơn", "Mã nhân viên", "Ngày Tạo", "Trạng thái", "Tổng Cộng"
                }));
        tbl_hoadon.setToolTipText("Merry Christmas");
        tbl_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_hoadonMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_hoadon);

        txt_search2.setBackground(new java.awt.Color(102, 102, 0));
        txt_search2.setForeground(new java.awt.Color(235, 202, 188));
        txt_search2.setText("Search");
        txt_search2.setToolTipText("Mã NL, Tên NL");

        btn_search2.setBackground(new java.awt.Color(102, 102, 0));
        btn_search2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-find-24.png"))); // NOI18N
        btn_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search2ActionPerformed(evt);
            }
        });

        btn_first1.setBackground(new java.awt.Color(153, 153, 153));
        btn_first1.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_left_20px.png"))); // NOI18N

        btn_next1.setBackground(new java.awt.Color(153, 153, 153));
        btn_next1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_left_20px.png"))); // NOI18N

        btn_previous1.setBackground(new java.awt.Color(153, 153, 153));
        btn_previous1
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_right_20px.png"))); // NOI18N

        btn_last1.setBackground(new java.awt.Color(153, 153, 153));
        btn_last1.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_right_20px.png"))); // NOI18N

        btn_cut.setText("exit");
        btn_cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 370,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(btn_search2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn_cut))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 984,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(btn_first1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(btn_next1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(btn_previous1, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(btn_last1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE)));
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_cut))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_next1)
                                        .addComponent(btn_last1)
                                        .addComponent(btn_first1)
                                        .addComponent(btn_previous1))
                                .addContainerGap()));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        jTabbedPane3.addTab("Quản lý hóa đơn", jPanel8);

        jPanel10.setBackground(new java.awt.Color(0, 102, 51));

        txt_search4.setBackground(new java.awt.Color(102, 102, 0));
        txt_search4.setForeground(new java.awt.Color(235, 202, 188));
        txt_search4.setText("Mã hóa đơn");
        txt_search4.setToolTipText("Mã NL, Tên NL");

        jButton3.setText("In lại");

        tbl_hoadonct.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { "HD01", "NV01", "SP01", "3/11/2022", "2", "Cafe sữa đá", "15000" },
                        { "HD02", "NV02", "SP02", "4/11/2022", "3", "Cafe đen", "25000" },
                        { "HD03", "NV03", "SP03", "5/11/2022", "4", "Bạc xỉu", "30000" },
                        { null, null, null, null, null, null, null }
                },
                new String[] {
                        "Mã hóa đơn", "Mã nhân viên", "Mã sản phẩm", "Ngày tạo", "Số lượng sản phẩm", "Trạng thái",
                        "Tổng tiền"
                }));
        jScrollPane4.setViewportView(tbl_hoadonct);

        btn_last2.setBackground(new java.awt.Color(153, 153, 153));
        btn_last2.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_right_20px.png"))); // NOI18N

        btn_previous2.setBackground(new java.awt.Color(153, 153, 153));
        btn_previous2
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_right_20px.png"))); // NOI18N

        btn_next2.setBackground(new java.awt.Color(153, 153, 153));
        btn_next2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_left_20px.png"))); // NOI18N

        btn_first2.setBackground(new java.awt.Color(153, 153, 153));
        btn_first2.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_left_20px.png"))); // NOI18N

        btn_cut1.setText("exit");
        btn_cut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(btn_first2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(btn_next2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(btn_previous2, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(btn_last2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGroup(jPanel10Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 982,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addComponent(txt_search4,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 370,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton3)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(459, 459, 459)
                                        .addComponent(btn_cut1)
                                        .addContainerGap(459, Short.MAX_VALUE))));
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(txt_search4, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_next2)
                                        .addComponent(btn_last2)
                                        .addComponent(btn_first2)
                                        .addComponent(btn_previous2))
                                .addContainerGap())
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(264, 264, 264)
                                        .addComponent(btn_cut1)
                                        .addContainerGap(264, Short.MAX_VALUE))));

        jTabbedPane3.addTab("Chi tiết hóa đơn", jPanel10);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(363, 363, 363)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 230,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(412, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 586,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 658, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_hoadonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_hoadonMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            row = tbl_hoadon.getSelectedRow();

        }
    }// GEN-LAST:event_tbl_hoadonMousePressed

    private void btn_cut1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_cut1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_cut1ActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_search2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_search2ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnThemActionPerformed

    public void Them() {
        try {
            JOptionPane.showMessageDialog(this, "Them hoa don thanh cong");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Them hoa don that bai");
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnXoaActionPerformed

    public void Xoa() {
        try {
            JOptionPane.showMessageDialog(this, "Xoa hoa don thanh cong");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Xoa hoa don that bai");
        }
    }

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnTimActionPerformed

    public void Tim() {
        try {
            JOptionPane.showMessageDialog(this, "Tìm kiếm thành công");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Tìm kiếm thất bại");
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnSuaActionPerformed

    private void btn_cutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_cutActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }// GEN-LAST:event_btn_cutActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonJDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cut;
    private javax.swing.JButton btn_cut1;
    private javax.swing.JButton btn_first1;
    private javax.swing.JButton btn_first2;
    private javax.swing.JButton btn_last1;
    private javax.swing.JButton btn_last2;
    private javax.swing.JButton btn_next1;
    private javax.swing.JButton btn_next2;
    private javax.swing.JButton btn_previous1;
    private javax.swing.JButton btn_previous2;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tbl_hoadon;
    private javax.swing.JTable tbl_hoadonct;
    private javax.swing.JTextField txt_search2;
    private javax.swing.JTextField txt_search4;
    // End of variables declaration//GEN-END:variables
}
