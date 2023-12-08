/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group1.views;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import group1.dao.CongThucDAO;
import group1.dao.HoaDonChiTietDAO;
import group1.dao.HoaDonDAO;
import group1.entity.HoaDon;
import group1.entity.HoaDonChiTiet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.Doc;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.Desktop;

/**
 *
 * @author Admin
 */
public class HoaDonJDialog extends javax.swing.JFrame {

        HoaDonDAO dao = new HoaDonDAO();
        HoaDonChiTietDAO daoCT = new HoaDonChiTietDAO();
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
                                String trangThai = "Chưa thanh toán";
                                if (hd.isTrangThai()) {
                                        trangThai = "Đã thanh toán";
                                }
                                Object[] row = {
                                                hd.getMaHD(),
                                                hd.getMaNV(),
                                                hd.getNgayTao(),
                                                trangThai, // use "trangThai" variable instead of hd.isTrangThai()
                                                hd.getTongCong(),
                                };
                                model.addRow(row);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
        }

        void fillTableHDCT() {
                DefaultTableModel model = (DefaultTableModel) tbl_hoadonct.getModel();
                model.setRowCount(0);
                try {
                        String MaHD = (String) tbl_hoadon.getValueAt(row, 0);
                        List<HoaDonChiTiet> list = daoCT.selectByMaHD(MaHD);
                        for (HoaDonChiTiet hdct : list) {
                                Object[] row = {
                                                hdct.getMaHD(),
                                                hdct.getMaNV(),
                                                hdct.getNgayTao(),
                                                hdct.getMaHDCT(),
                                                hdct.getTenSP(),
                                                hdct.getMaSP(),
                                                hdct.getSoLuong(),
                                                hdct.getGiaBan(),
                                                hdct.getThanhTien(),
                                };
                                model.addRow(row);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
        }

        void go() {
                fillTableHDCT();
                tabs.setSelectedIndex(1);
        }

        void exportToPDF(DefaultTableModel table) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save PDF");
                fileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));

                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                        try {
                                Document document = new Document();
                                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                                document.open();

                                // Tạo bảng PDF từ JTable
                                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

                                // Thêm cột vào bảng PDF
                                for (int i = 0; i < table.getColumnCount(); i++) {
                                        pdfTable.addCell(table.getColumnName(i));
                                }

                                // Thêm dữ liệu từ JTable vào bảng PDF
                                for (int i = 0; i < table.getRowCount(); i++) {
                                        for (int j = 0; j < table.getColumnCount(); j++) {
                                                pdfTable.addCell(table.getValueAt(i, j).toString());
                                        }
                                }
                                // Thêm bảng PDF vào tài liệu
                                document.add(pdfTable);

                                document.close();

                                // Open the saved PDF file
                                File savedFile = new File(filePath);
                                Desktop.getDesktop().open(savedFile);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_hoadon = new javax.swing.JTable();
        txt_search2 = new javax.swing.JTextField();
        btn_search2 = new javax.swing.JButton();
        btn_cut = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        txt_search4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_hoadonct = new javax.swing.JTable();
        btn_cut1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(132, 35, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(244, 219, 216));
        jLabel9.setText("Quản Lý Hóa Đơn");

        tabs.setBackground(new java.awt.Color(169, 15, 59));

        jPanel9.setBackground(new java.awt.Color(181, 202, 141));

        tbl_hoadon.setAutoCreateRowSorter(true);
        tbl_hoadon.setBackground(new java.awt.Color(139, 177, 116));
        tbl_hoadon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"HD01", "NV01", null, null, null},
                {"HD02", "NV02", null, null, null},
                {"HD03", "NV03", null, null, null},
                {"", "", null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã nhân viên", "Ngày Tạo", "Trạng thái", "Tổng Cộng"
            }
        ));
        tbl_hoadon.setToolTipText("Merry Christmas");
        tbl_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_hoadonMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_hoadon);

        txt_search2.setForeground(new java.awt.Color(235, 202, 188));
        txt_search2.setText("Search");
        txt_search2.setToolTipText("Mã NL, Tên NL");

        btn_search2.setBackground(new java.awt.Color(234, 181, 99));
        btn_search2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/xmag_search_find_export_locate_5984.png"))); // NOI18N
        btn_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search2ActionPerformed(evt);
            }
        });

        btn_cut.setBackground(new java.awt.Color(234, 181, 99));
        btn_cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_exit_20px.png"))); // NOI18N
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
                        .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_search2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cut)
                        .addGap(0, 503, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_search2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_search2)
                    .addComponent(btn_cut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabs.addTab("Quản lý hóa đơn", jPanel8);

        jPanel10.setBackground(new java.awt.Color(181, 202, 141));

        txt_search4.setForeground(new java.awt.Color(235, 202, 188));
        txt_search4.setText("Mã hóa đơn");
        txt_search4.setToolTipText("Mã NL, Tên NL");

        jButton3.setBackground(new java.awt.Color(234, 181, 99));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-invoice-20 (1).png"))); // NOI18N
        jButton3.setText("In lại");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tbl_hoadonct.setBackground(new java.awt.Color(139, 177, 116));
        tbl_hoadonct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"HD01", "NV01", "3/11/2022", null, "Cafe sữa đá", "SP01", "2", null, "15000"},
                {"HD02", "NV02", "4/11/2022", null, "Cafe đen", "SP02", "3", null, "25000"},
                {"HD03", "NV03", "5/11/2022", null, "Bạc xỉu", "SP03", "4", null, "30000"},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã nhân viên", "Ngày tạo", "Mã Hóa Đơn Chi Tiế", "Tên Sản Phẩm", "Mã sản phẩm", "Số lượng sản phẩm", "Giá", "Tổng tiền"
            }
        ));
        jScrollPane4.setViewportView(tbl_hoadonct);

        btn_cut1.setBackground(new java.awt.Color(234, 181, 99));
        btn_cut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_exit_20px.png"))); // NOI18N
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
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txt_search4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cut1)
                        .addGap(0, 493, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(txt_search4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_cut1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("Chi tiết hóa đơn", jPanel10);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
                // TODO add your handling code here:
                exportToPDF((DefaultTableModel) tbl_hoadonct.getModel());
        }// GEN-LAST:event_jButton3ActionPerformed

        private void tbl_hoadonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_hoadonMousePressed
                // TODO add your handling code here:
                if (evt.getClickCount() == 2) {
                        row = tbl_hoadon.getSelectedRow();
                        this.go();
                }
        }// GEN-LAST:event_tbl_hoadonMousePressed

        private void btn_cut1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_cut1ActionPerformed
                // TODO add your handling code here:
                this.setVisible(false);
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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
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
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_hoadon;
    private javax.swing.JTable tbl_hoadonct;
    private javax.swing.JTextField txt_search2;
    private javax.swing.JTextField txt_search4;
    // End of variables declaration//GEN-END:variables
}
