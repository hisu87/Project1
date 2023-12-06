/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package group1.views;
// thư viện iText 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import group1.dao.CongThucDAO;
import group1.entity.CongThuc;
import group1.entity.CongThuc_NguyenLieu;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
// THơ

public class CongThucNguyenLieuJDialog extends javax.swing.JFrame {

    DefaultTableModel tblModel = new DefaultTableModel();
    public CongThucNguyenLieuJDialog() {
        initComponents();
        initTable();
        setTitle("Thông tin công thức");
        setLocationRelativeTo(null);
        loadCbo();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCongthuc = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDonvido = new javax.swing.JTextField();
        txtMact = new javax.swing.JTextField();
        txtManl = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        cboMact = new javax.swing.JComboBox<>();
        cboTenct = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 181, 172));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCongthuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCongthuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCongthucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCongthuc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1000, 370));

        btnSearch.setText("Tìm kiếm ");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, -1, -1));

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel1.add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, -1, -1));

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, -1, -1));

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel1.add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, -1, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, -1, -1));

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 550, -1, -1));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("THÔNG TIN CÔNG THỨC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 40));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        jLabel3.setText("Mã công thức: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel4.setText("Mã nguyên liệu: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jLabel5.setText("Số lượng:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jLabel6.setText("Đơn vị đo: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, 20));
        jPanel1.add(txtDonvido, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 60, -1));
        jPanel1.add(txtMact, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 120, -1));
        jPanel1.add(txtManl, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 120, -1));
        jPanel1.add(txtSoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 60, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, -1, -1));

        cboMact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã công thức" }));
        jPanel1.add(cboMact, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        cboTenct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên công thức " }));
        jPanel1.add(cboTenct, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));
        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));
        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        btnnext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        CongThuc_NguyenLieu ct = getForm();
        try {
            CongThucDAO.insert(ct);
        } catch (SQLException ex) {
            Logger.getLogger(CongThucNguyenLieuJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTable();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
    btnfirst();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
       btnprevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        btnlast();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblCongthucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCongthucMouseClicked
       int selectedRow = tblCongthuc.getSelectedRow();
        filltoControl(selectedRow);
    }//GEN-LAST:event_tblCongthucMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ClearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        CongThuc_NguyenLieu ct = getForm();
        try {
            CongThucDAO.delete(ct);
        } catch (SQLException ex) {
            Logger.getLogger(CongThucNguyenLieuJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
//        String id =  txtSearch.getText();
// sử dụng cho text field
        String mact = (String) cboMact.getSelectedItem();
        String tenct = (String) cboTenct.getSelectedItem();
        
        try {
           List<CongThuc_NguyenLieu> list = CongThucDAO.FindByid(mact, tenct);
            if (list == null) {
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy");
            } else {
                tblModel.setRowCount(0);
                for(CongThuc_NguyenLieu ct :list ){
                tblModel.addRow(new Object[]{
                    ct.getMaCT(),ct.getTenCongThuc(),ct.getMaNL(),ct.getTenNL(),ct.getSoLuong(),ct.getDonViDoLuong()
                });
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CongThuc_NguyenLieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
       initTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         CongThuc_NguyenLieu ct = getForm();
        try {
            CongThucDAO.update(ct);
        } catch (SQLException ex) {
            Logger.getLogger(CongThucNguyenLieuJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        exportToPdf(tblModel);
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(CongThucNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CongThucNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CongThucNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CongThucNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CongThucNguyenLieuJDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboMact;
    private javax.swing.JComboBox<String> cboTenct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblCongthuc;
    private javax.swing.JTextField txtDonvido;
    private javax.swing.JTextField txtMact;
    private javax.swing.JTextField txtManl;
    private javax.swing.JTextField txtSoluong;
    // End of variables declaration//GEN-END:variables

   void initTable () {
       String []columnsName = {"Mã CT","Tên CT","Mã NL","Tên NL","Số Lượng","Đơn vị"};
       tblModel = (DefaultTableModel) tblCongthuc.getModel();
       tblModel.setColumnIdentifiers(columnsName);
       tblModel.setRowCount(0);
       
       List<CongThuc_NguyenLieu> list = CongThucDAO.getCongThucNguyenLieu();
       
       for (CongThuc_NguyenLieu ct : list) {
            tblModel.addRow(new Object[]{
                ct.getMaCT(),ct.getTenCongThuc(),ct.getMaNL(),ct.getTenNL(),ct.getSoLuong(),ct.getDonViDoLuong()
            });
        }
   }
   
   public CongThuc_NguyenLieu getForm() {
       int mact = Integer.parseInt(txtMact.getText());
       String manl = txtManl.getText();
       int soluong = Integer.parseInt(txtSoluong.getText());
       String donvi = txtDonvido.getText();
       CongThuc_NguyenLieu ct = new CongThuc_NguyenLieu(mact, manl, soluong, donvi);
       return ct;
   }
   
   
   
   public void filltoControl(int selectedRow) {
        if (selectedRow >= 0) {
            String value1 = tblCongthuc.getValueAt(selectedRow, 0).toString(); // mã công thức 
            String value2 = tblCongthuc.getValueAt(selectedRow, 1).toString();// tên công thức 
            String value3 = tblCongthuc.getValueAt(selectedRow, 2).toString(); // mã nguyên liệu  
            String value4 = tblCongthuc.getValueAt(selectedRow, 3).toString();// tên nguyên liệu
            String value5 = tblCongthuc.getValueAt(selectedRow, 4).toString(); // số lượng 
            String value6 = tblCongthuc.getValueAt(selectedRow, 5).toString(); // đơn vị đo 
            txtMact.setText(value1);
            txtManl.setText(value3);
            txtSoluong.setText(value5);
            txtDonvido.setText(value6);
        }
    }
   
    public void btnnext() {
        int selectedRow = tblCongthuc.getSelectedRow();
        if (selectedRow == tblCongthuc.getRowCount() - 1) {
            int currentRow = 0;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else if (selectedRow > -1) {
            int currentRow = selectedRow;
            currentRow++;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else {
            int currentRow = 0;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        }
    }

    public void btnfirst() {
        if (tblCongthuc.getRowCount() > 0) {
            //table.getRowcount() trả về một số nguyên đại diện cho số lượng dòng trong jtable 
            int currentRow = 0;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
        }

        int selectedRow = tblCongthuc.getSelectedRow();
        // mặc định selectedRow = -1
        filltoControl(selectedRow);
    }

    public void btnlast() {
        if (tblCongthuc.getRowCount() > 0) {
            int currentRow = tblCongthuc.getRowCount() - 1;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
        }
        int selectedRow = tblCongthuc.getSelectedRow();
        // mặc định selectedRow = -1
        filltoControl(selectedRow);
    }

    public void btnprevious() {
        int selectedRow = tblCongthuc.getSelectedRow();
        if (selectedRow == 0) {
            int currentRow = tblCongthuc.getRowCount() - 1;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else if (selectedRow > -1) {
            int currentRow = selectedRow;
            currentRow--;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else {
            int currentRow = tblCongthuc.getRowCount() - 1;
            tblCongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        }
    }
    
    public void ClearForm() {
        txtMact.setText("");
        txtManl.setText("");
        txtSoluong.setText("");
        txtDonvido.setText("");
    }
    
    public void loadCbo() {
        List<CongThuc> list = CongThucDAO.getCongThuc();
        for (CongThuc ct: list) {
            cboMact.addItem(Integer.toString(ct.getMaCT()));
            cboTenct.addItem(ct.getTenCT());
        }
    }
    
    public void exportToPdf( DefaultTableModel table) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
 
