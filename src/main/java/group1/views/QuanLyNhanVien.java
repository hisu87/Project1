/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import group1.dao.NhanVienDAO;
import group1.entity.NhanVien;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyNhanVien extends javax.swing.JDialog {

    DefaultTableModel tblModel  = new DefaultTableModel();
    NhanVienDAO dao = new NhanVienDAO();
    public QuanLyNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        initTable();
        cboVaitro.addItem("Nhân viên");
        cboVaitro.addItem("Quản lý");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        txtManv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMatkhau = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rdoNhanvien = new javax.swing.JCheckBox();
        rdoQuanly = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JCheckBox();
        rdoNu = new javax.swing.JCheckBox();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanvien = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiachi = new javax.swing.JTextArea();
        btnLast = new javax.swing.JButton();
        btnPevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnTimkiem = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboVaitro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Mã Nhân Viên");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 217, -1));
        getContentPane().add(txtManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 217, -1));

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Họ Và Tên");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 217, -1));
        getContentPane().add(txtHoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 217, -1));

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Mật Khẩu");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 217, -1));
        getContentPane().add(txtMatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 217, -1));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số điện thoại");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 217, -1));
        getContentPane().add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 217, -1));

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Tuổi");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 69, -1));

        txtTuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuoiActionPerformed(evt);
            }
        });
        getContentPane().add(txtTuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 97, -1));

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Vai Trò");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 97, -1));

        buttonGroup1.add(rdoNhanvien);
        rdoNhanvien.setSelected(true);
        rdoNhanvien.setText("Nhân viên");
        rdoNhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanvienActionPerformed(evt);
            }
        });
        getContentPane().add(rdoNhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        buttonGroup1.add(rdoQuanly);
        rdoQuanly.setText("Quản lý");
        rdoQuanly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoQuanlyActionPerformed(evt);
            }
        });
        getContentPane().add(rdoQuanly, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, -1, -1));

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Giới Tính ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 71, -1));

        buttonGroup2.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        getContentPane().add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        buttonGroup2.add(rdoNu);
        rdoNu.setText("Nữ");
        getContentPane().add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_book_20px.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, 33));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_update_user_20px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, -1, 33));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_delete_20px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, -1, 33));

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_change_20px.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, 33));

        tblNhanvien.setAutoCreateRowSorter(true);
        tblNhanvien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblNhanvien.setToolTipText("Merry Christmas");
        tblNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanvien);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 940, 364));

        jButton1.setText("Print");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 530, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Quản lý nhân viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        jLabel2.setText("Địa chỉ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        txtDiachi.setColumns(20);
        txtDiachi.setRows(5);
        jScrollPane1.setViewportView(txtDiachi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 210, 90));

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        getContentPane().add(btnLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 530, -1, -1));

        btnPevious.setText("Previous");
        btnPevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeviousActionPerformed(evt);
            }
        });
        getContentPane().add(btnPevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 530, -1, -1));

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, -1, -1));

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        getContentPane().add(btnFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, -1, -1));

        btnTimkiem.setText("Tìm kiếm ");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));
        getContentPane().add(txtTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 130, -1));

        jLabel6.setText("Mã nhân viên, Họ tên");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        cboVaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vai trò " }));
        getContentPane().add(cboVaitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuoiActionPerformed

    private void rdoNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNhanvienActionPerformed

    private void rdoQuanlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoQuanlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoQuanlyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        NhanVien nv = getForm();
        dao.insert(nv);
        initTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        NhanVien nv = getForm();
        dao.update(nv);
        initTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        Clearform();
        txtManv.setEditable(true);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        btnlast();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
       btnfirst();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        btnnext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPeviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeviousActionPerformed
       btnprevious();
    }//GEN-LAST:event_btnPeviousActionPerformed

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked
        int selectedRow = tblNhanvien.getSelectedRow();
        filltoControl(selectedRow);
       
    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        
        int selectedRow = tblNhanvien.getSelectedRow();
        String id = "";
        if(selectedRow > 0) {
         id = (String) tblNhanvien.getValueAt(selectedRow, 0);
        } else {
            id = txtManv.getText();
        }
        
        if (id.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên muốn xóa");
        }  else {
            dao.delete(id);
        }
        initTable(); 
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        String id = txtTimkiem.getText();

        tblModel.setRowCount(0);

        NhanVien nv = dao.selectById(id);

        tblModel.addRow(new Object[]{
            nv.getMaNV(), nv.getMatKhau(), nv.getHoTen(), nv.getVaitro(), nv.getTuoi(), nv.getGioiTinh(), nv.getSdt(), nv.getDiaChi()
        });

       
    }//GEN-LAST:event_btnTimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyNhanVien dialog = new QuanLyNhanVien(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPevious;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboVaitro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox rdoNam;
    private javax.swing.JCheckBox rdoNhanvien;
    private javax.swing.JCheckBox rdoNu;
    private javax.swing.JCheckBox rdoQuanly;
    private javax.swing.JTable tblNhanvien;
    private javax.swing.JTextArea txtDiachi;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtMatkhau;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
void initTable () {
        String []columnName = {"Mã nv","Mật khẩu","Tên nv","Vai trò","Tuổi","Giới tính","SDT","Địa chỉ"};
        tblModel = (DefaultTableModel) tblNhanvien.getModel();
        tblModel.setColumnIdentifiers(columnName);
        
        tblModel.setRowCount(0);
       
       List<NhanVien> list = dao.selectAll();
       
       for (NhanVien nv : list) {
            tblModel.addRow(new Object[]{
                nv.getMaNV(),nv.getMatKhau(),nv.getHoTen(),nv.getVaitro(),nv.getTuoi(),nv.getGioiTinh(),nv.getSdt(),nv.getDiaChi()
            });
        }
    }

void Clearform() {
    txtManv.setText("");
    txtHoten.setText("");
    txtMatkhau.setText("");
    txtSdt.setText("");
    txtTuoi.setText("");
    txtDiachi.setText("");
    rdoNhanvien.setSelected(true);
    rdoNam.setSelected(true);
}

void VadidateForm() {
    
}

public void filltoControl(int selectedRow) {
        if (selectedRow >= 0) {
            String value1 = tblNhanvien.getValueAt(selectedRow, 0).toString(); // mã nhân viên 
            String value2 = tblNhanvien.getValueAt(selectedRow, 1).toString();// mật khẩu 
            String value3 = tblNhanvien.getValueAt(selectedRow, 2).toString(); //họ tên   
            String value4 = tblNhanvien.getValueAt(selectedRow, 3).toString();// vai trò 
            String value5 = tblNhanvien.getValueAt(selectedRow, 4).toString(); // tuổi 
            String value6 = tblNhanvien.getValueAt(selectedRow, 5).toString(); // giới tính  
            String value7 = tblNhanvien.getValueAt(selectedRow, 6).toString(); // Số điên thoại
            String value8 = tblNhanvien.getValueAt(selectedRow, 7).toString(); // Địa chỉ
            txtManv.setText(value1);
            txtManv.setEditable(false);
            txtMatkhau.setText(value2);
            txtHoten.setText(value3);
            txtTuoi.setText(value5);
            txtSdt.setText(value7);
            txtDiachi.setText(value8);
            if(value4.equalsIgnoreCase("Nhân viên")) {
                rdoNhanvien.setSelected(true);
            } else {
                rdoQuanly.setSelected(true);
            } 
            if (value6.equalsIgnoreCase("Nam")){
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
        }
    }
   
    public void btnnext() {
        int selectedRow = tblNhanvien.getSelectedRow();
        if (selectedRow == tblNhanvien.getRowCount() - 1) {
            int currentRow = 0;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else if (selectedRow > -1) {
            int currentRow = selectedRow;
            currentRow++;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else {
            int currentRow = 0;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        }
    }

    public void btnfirst() {
        if (tblNhanvien.getRowCount() > 0) {
            //table.getRowcount() trả về một số nguyên đại diện cho số lượng dòng trong jtable 
            int currentRow = 0;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
        }

        int selectedRow = tblNhanvien.getSelectedRow();
        // mặc định selectedRow = -1
        filltoControl(selectedRow);
    }

    public void btnlast() {
        if (tblNhanvien.getRowCount() > 0) {
            int currentRow = tblNhanvien.getRowCount() - 1;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
        }
        int selectedRow = tblNhanvien.getSelectedRow();
        // mặc định selectedRow = -1
        filltoControl(selectedRow);
    }

    public void btnprevious() {
        int selectedRow = tblNhanvien.getSelectedRow();
        if (selectedRow == 0) {
            int currentRow = tblNhanvien.getRowCount() - 1;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else if (selectedRow > -1) {
            int currentRow = selectedRow;
            currentRow--;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        } else {
            int currentRow = tblNhanvien.getRowCount() - 1;
            tblNhanvien.setRowSelectionInterval(currentRow, currentRow);
            filltoControl(currentRow);
        }
    }

NhanVien getForm() {
    String manv = txtManv.getText();
    String hoten = txtHoten.getText();
    String matkhau = txtMatkhau.getText();
    String diachi = txtDiachi.getText();
    int  tuoi = Integer.parseInt(txtTuoi.getText());
    String sdt = txtSdt.getText();
    String vaitro = "Nhân viên";
    if(rdoNhanvien.isSelected()) {
        vaitro = "Nhân viên";
    } else {
        vaitro = "Quản lý";
    }
    String gioitinh ="Nam";
    if(rdoNam.isSelected()) {
        gioitinh ="Nam";
    } else {
        gioitinh = "Nữ";
    }
    
    NhanVien nv = new NhanVien(manv, matkhau, vaitro, hoten, tuoi,gioitinh, sdt, diachi);
    return nv;
}


}
