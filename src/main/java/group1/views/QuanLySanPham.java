package group1.views;

import group1.dao.CongThucDAO;
import group1.dao.SanPhamDao;
import group1.entity.CongThuc;
import group1.entity.CongThuc_NguyenLieu;
import group1.entity.SanPham;
import group1.utils.Auth;
import group1.utils.msgBox;
import group1.utils.xImage;
import io.opencensus.metrics.export.Value;

import java.awt.Image;
import java.io.File;
import java.sql.Date;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
//import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;

public class QuanLySanPham extends javax.swing.JDialog {
    SanPhamDao daosp = new SanPhamDao();
    CongThucDAO ctdao = new CongThucDAO();
    DefaultTableModel tblmodel = new DefaultTableModel();
    List<SanPham> list = new ArrayList<>();
    JFileChooser filechooser = new JFileChooser();
    int row = -1;

    public QuanLySanPham(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        filltable();
        loadcbx();
    }

    void filltable() {
        tblmodel = (DefaultTableModel) tblsanPham.getModel();
        tblmodel.setRowCount(0);
        List<SanPham> sp = daosp.selectAll();
        for (SanPham SP : sp) {
            Object[] row = { SP.getTenSP(), SP.getMaSP(), SP.getMaCT(), SP.getGia(), SP.getAnh() };
            cbxct.setSelectedItem(0);
            // cbxct.setSelectedItem("f");
            tblmodel.addRow(row);
            tblsanPham.setModel(tblmodel);
        }
    }

    void loadcbx() {
        try {
            DefaultComboBoxModel cbxmodel = (DefaultComboBoxModel) cbxct.getModel();
            cbxmodel.removeAllElements();
            List<CongThuc> listct = ctdao.getCongThuc();
            for (CongThuc ct : listct) {
                cbxmodel.addElement(ct.getMaCT());

            }

        } catch (Exception e) {
            e.printStackTrace();
            msgBox.alert(this, "Lỗi khi load cbx");
        }
    }

    void setForm(SanPham sp) {
        txtmaSanPham.setText(sp.getMaSP());
        txtTenSanPham.setText(sp.getTenSP());
        cbxct.setSelectedItem(sp.getMaCT());
        txtgia.setText(String.valueOf(sp.getGia()));
        if (sp.getAnh() != null) {
            lblanh.setToolTipText(sp.getAnh());
            lblanh.setIcon(xImage.read(sp.getAnh()));
        }
    }

    SanPham getForm() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtmaSanPham.getText());
        sp.setTenSP(txtTenSanPham.getText());
        sp.setMaCT((String) cbxct.getSelectedItem().toString());
        sp.setGia(Float.parseFloat(txtgia.getText()));
        sp.setAnh(lblanh.getToolTipText());
        return sp;
    }

    void choosePic() {
        if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            filechooser.setDialogTitle("Choose Image");
            File file = filechooser.getSelectedFile();
            xImage.save(file);
            ImageIcon icon = xImage.read(file.getName());
            lblanh.setIcon(icon);
            lblanh.setToolTipText(file.getName());
            System.out.println("Oke");
        }
    }

    void updateStatus() {
        // TODO
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblsanPham.getRowCount() - 1);
        // Trạng thái form
        txtmaSanPham.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
        // Trạng thái điều hướng
        btnfirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnnext.setEnabled(edit && !last);
        btnlast.setEnabled(edit && !last);
    }

    void clear() {
        this.setForm(new SanPham());
        this.row = -1;
        this.updateStatus();
    }

    Boolean validateForm() {
        if (txtmaSanPham.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống mã sản phẩm");
            txtmaSanPham.requestFocus();
            return false;
        } else if (txtTenSanPham.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống tên sản phẩm");
            txtTenSanPham.requestFocus();
            return false;
        } else if (txtgia.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống giá sản phẩm");
            txtgia.requestFocus();
            return false;
        } else if (cbxct.getSelectedIndex() == 0) {
            msgBox.alert(this, "Không được để trống mã công thức");
            cbxct.requestFocus();
            return false;
        } else if (lblanh.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống ảnh");
            lblanh.requestFocus();
            return false;
        } else if (Double.parseDouble(txtgia.getText()) <= 0) {
            msgBox.alert(this, "Giá sản phẩm phải lớn hơn 0");
            txtgia.requestFocus();
            return false;
        }
        return true;
    }

    void insert() {
        if (validateForm()) {
            SanPham sp = getForm();
            try {
                daosp.insert(sp);
                this.filltable();
                this.clear();
                msgBox.alert(this, "Thêm thành công");
            } catch (Exception e) {
                e.printStackTrace();
                msgBox.alert(this, "Thêm thất bại");
            }
        }
    }

    void update() {
        if (validateForm()) {
            SanPham sp = getForm();
            try {
                daosp.update(sp);
                this.filltable();
                this.clear();
                msgBox.alert(this, "Sửa thành công");
            } catch (Exception e) {
                e.printStackTrace();
                msgBox.alert(this, "Sửa thất bại");
            }
        }
    }

    void delete() {
        if (!Auth.isManager()) {
            msgBox.alert(this, "Bạn không có quyền xóa sản phẩm");
        } else {
            String masp = txtmaSanPham.getText();
            if (msgBox.confirm(this, "Bạn có muốn xóa sản phẩm này không?")) {
                try {
                    daosp.delete(masp);
                    this.filltable();
                    this.clear();
                    msgBox.alert(this, "Xóa thành công");
                } catch (Exception e) {
                    e.printStackTrace();
                    msgBox.alert(this, "Xóa thất bại");
                }
            }
        }
    }

    void openRecipe() {
        new CongThucNguyenLieuJDialog().setVisible(true);
    }

    void edit() {
        String masp = (String) tblsanPham.getValueAt(this.row, 0);
        SanPham sp = daosp.selectById(masp);
        this.setForm(sp);
        this.updateStatus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panelGradient1 = new raven.panel.PanelGradient();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsanPham = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        panelGradient2 = new raven.panel.PanelGradient();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblanh = new javax.swing.JLabel();
        txtmaSanPham = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnfirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnlast = new javax.swing.JButton();
        btnThemCT = new javax.swing.JButton();
        txtTenSanPham = new javax.swing.JTextField();
        cbxct = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGradient1.setBackground(new java.awt.Color(171, 120, 78));
        panelGradient1.setColorGradient(new java.awt.Color(153, 101, 58));

        tblsanPham.setBackground(new java.awt.Color(120, 88, 77));
        tblsanPham.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "MÃ SP", "TÊN SP", "MÃ CT", "GIÁ", "ẢNH"
                }));
        tblsanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsanPhamMouseClicked(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblsanPhamMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblsanPham);

        panelGradient1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 770, 440);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE));

        tabs.addTab("DANH SÁCH", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        panelGradient2.setBackground(new java.awt.Color(171, 120, 78));
        panelGradient2.setColorGradient(new java.awt.Color(153, 101, 58));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnMoi)
                                        .addComponent(btnXoa)
                                        .addComponent(btnSua)
                                        .addComponent(btnThem))
                                .addContainerGap(14, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnThem)
                                .addGap(39, 39, 39)
                                .addComponent(btnSua)
                                .addGap(42, 42, 42)
                                .addComponent(btnXoa)
                                .addGap(43, 43, 43)
                                .addComponent(btnMoi)
                                .addContainerGap(97, Short.MAX_VALUE)));

        panelGradient2.add(jPanel4);
        jPanel4.setBounds(650, 40, 108, 351);

        lblanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drinks/phindenda.png"))); // NOI18N
        lblanh.setText("jLabel9");
        lblanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblanhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblanh, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE));

        panelGradient2.add(jPanel1);
        jPanel1.setBounds(20, 80, 200, 230);
        panelGradient2.add(txtmaSanPham);
        txtmaSanPham.setBounds(240, 80, 240, 26);

        jLabel1.setText("Mã Sản Phẩm:");
        panelGradient2.add(jLabel1);
        jLabel1.setBounds(240, 60, 76, 16);

        jLabel3.setText("Tên Sản Phẩm:");
        panelGradient2.add(jLabel3);
        jLabel3.setBounds(240, 140, 78, 16);

        btnfirst.setText("|<");
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });
        panelGradient2.add(btnfirst);
        btnfirst.setBounds(240, 350, 76, 27);

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        panelGradient2.add(btnPrev);
        btnPrev.setBounds(320, 350, 76, 27);

        btnnext.setText(">>");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        panelGradient2.add(btnnext);
        btnnext.setBounds(400, 350, 76, 27);

        btnlast.setText(">|");
        btnlast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlastActionPerformed(evt);
            }
        });
        panelGradient2.add(btnlast);
        btnlast.setBounds(480, 350, 76, 27);

        btnThemCT.setText("Thêm");
        btnThemCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTActionPerformed(evt);
            }
        });
        panelGradient2.add(btnThemCT);
        btnThemCT.setBounds(330, 220, 76, 27);
        panelGradient2.add(txtTenSanPham);
        txtTenSanPham.setBounds(240, 160, 280, 26);

        cbxct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thêm", " ", " " }));
        cbxct.setToolTipText("thêm");
        panelGradient2.add(cbxct);
        cbxct.setBounds(240, 220, 76, 26);

        jLabel8.setText("Mã Công Thức:");
        panelGradient2.add(jLabel8);
        jLabel8.setBounds(240, 200, 81, 16);

        txtgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiaActionPerformed(evt);
            }
        });
        panelGradient2.add(txtgia);
        txtgia.setBounds(240, 290, 280, 26);

        jLabel2.setText("Giá:");
        panelGradient2.add(jLabel2);
        jLabel2.setBounds(240, 270, 150, 16);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelGradient2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelGradient2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE));

        tabs.addTab("CẬP NHẬT", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabs));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 495,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblanhMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblanhMouseClicked
        // TODO add your handling code here:
        choosePic();
    }// GEN-LAST:event_lblanhMouseClicked

    private void btnThemCTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemCTActionPerformed
        // TODO add your handling code here:
        openRecipe();

    }// GEN-LAST:event_btnThemCTActionPerformed

    private void tblsanPhamMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblsanPhamMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblsanPham.getSelectedRow();
            this.edit();
            System.out.println("selected");
            tabs.setSelectedIndex(1);
            System.out.println("hola");
        }
    }// GEN-LAST:event_tblsanPhamMouseClicked

    private void txtgiaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtgiaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtgiaActionPerformed

    private void tblsanPhamMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblsanPhamMousePressed

    }// GEN-LAST:event_tblsanPhamMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
        insert();
    }// GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
        // try {
        // int selectbyif=(int) tblkhoahoc.getValueAt(this.tblkhoahoc.getSelectedRow(),
        // 0);
        // KhoaHoc kh=daokhoahoc.selected_by_id(selectbyif);
        // kh.setTenKhoaHoc((txtChuyenDE.getText()));
        // kh.setHocPhi(Double.parseDouble(txtHocPhi.getText()));
        // kh.setNgayKhaiGiang((Date) XDate.toDate(txtKhaiGiang.getText(), "dd/MM/yy"));
        // kh.setGhiChu(txtGhiChu.getText());
        // kh.setNgayTao((Date) XDate.toDate(txtNgayTao.getText(), "dd/MM/yy"));
        // fillTable();
        // msg_box.alert(this, "Update thành công");
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }// GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed

    }// GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoiActionPerformed

    }// GEN-LAST:event_btnMoiActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnfirstActionPerformed

    }// GEN-LAST:event_btnfirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrevActionPerformed

    }// GEN-LAST:event_btnPrevActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnnextActionPerformed

    }// GEN-LAST:event_btnnextActionPerformed

    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnlastActionPerformed

    }// GEN-LAST:event_btnlastActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        CongThucNguyenLieuJDialog ct = new CongThucNguyenLieuJDialog();
        ct.setVisible(true);
    }// GEN-LAST:event_jButton1ActionPerformed

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
        // try {
        // UIManager.setLookAndFeel(new FlatLightLaf());
        // } catch (Exception ex) {
        // System.err.println("Failed to initialize LaF");
        // }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLySanPham dialog = new QuanLySanPham(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemCT;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnnext;
    private javax.swing.JComboBox<String> cbxct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblanh;
    private raven.panel.PanelGradient panelGradient1;
    private raven.panel.PanelGradient panelGradient2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblsanPham;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtmaSanPham;
    // End of variables declaration//GEN-END:variables
}
