/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import group1.dao.CongThucDAO;
import group1.dao.CongThucNguyenLieuDAO;
import group1.dao.NguyenLieuDAO;
import group1.dao.SanPhamDao;
import group1.entity.CongThuc;
import group1.entity.CongThuc_NguyenLieu;
import group1.entity.NguyenLieu;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CongThucNguyenLieuJDialog extends javax.swing.JDialog {

    DefaultTableModel tblModel = new DefaultTableModel();
    DefaultTableModel tblmodel = new DefaultTableModel();
    CongThucNguyenLieuDAO dao = new CongThucNguyenLieuDAO();
    CongThucDAO ctdao = new CongThucDAO();
    NguyenLieuDAO nldao = new NguyenLieuDAO();
    SanPhamDao spdao = new SanPhamDao();

    public CongThucNguyenLieuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initTable();
        setLocationRelativeTo(null);
        loadCbo();
        loadTable();

    }

    public void btnnext1() {
        int selectedRow = tblcongthuc.getSelectedRow();
        if (selectedRow == tblcongthuc.getRowCount() - 1) {
            int currentRow = 0;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltocontrol1(currentRow);
        } else if (selectedRow > -1) {
            int currentRow = selectedRow;
            currentRow++;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltocontrol1(currentRow);
        } else {
            int currentRow = 0;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltocontrol1(currentRow);
        }
    }

    public void btnfirst1() {
        if (tblcongthuc.getRowCount() > 0) {
            //table.getRowcount() trả về một số nguyên đại diện cho số lượng dòng trong jtable 
            int currentRow = 0;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
        }

        int selectedRow = tblcongthuc.getSelectedRow();
        // mặc định selectedRow = -1
        filltocontrol1(selectedRow);
    }

    public void btnlast1() {
        if (tblcongthuc.getRowCount() > 0) {
            int currentRow = tblcongthuc.getRowCount() - 1;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
        }
        int selectedRow = tblcongthuc.getSelectedRow();
        // mặc định selectedRow = -1
        filltocontrol1(selectedRow);
    }

    public void btnprevious1() {
        int selectedRow = tblcongthuc.getSelectedRow();
        if (selectedRow == 0) {
            int currentRow = tblcongthuc.getRowCount() - 1;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltocontrol1(currentRow);
        } else if (selectedRow > -1) {
            int currentRow = selectedRow;
            currentRow--;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltocontrol1(currentRow);
        } else {
            int currentRow = tblcongthuc.getRowCount() - 1;
            tblcongthuc.setRowSelectionInterval(currentRow, currentRow);
            filltocontrol1(currentRow);

        }
    }

    void loadTable() {
        String[] columnsName = {"Mã CT", "Tên CT"};
        tblmodel = (DefaultTableModel) tblcongthuc.getModel();
        tblmodel.setColumnIdentifiers(columnsName);
        tblmodel.setRowCount(0);

        List<CongThuc> list = ctdao.selectAll();

        for (CongThuc ct : list) {
            tblmodel.addRow(new Object[]{
                ct.getMaCT(), ct.getTenCT()});
        }
    }

    void filltocontrol1(int selectedRow) {
        if (selectedRow >= 0) {
            String value1 = tblcongthuc.getValueAt(selectedRow, 0).toString(); // mã công thức 
            String value2 = tblcongthuc.getValueAt(selectedRow, 1).toString();// tên công thức 
            txtMacongthuc.setText(value1);
            txtTencongthuc.setText(value2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDonvido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCongthuc = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        cboMact = new javax.swing.JComboBox<>();
        btnFirst = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        cboManl = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcongthuc = new javax.swing.JTable();
        btnTim = new javax.swing.JButton();
        btnFirst1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnPrevious1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        btnInsert1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnNew1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMacongthuc = new javax.swing.JTextField();
        txtTencongthuc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane2.setBackground(new java.awt.Color(97, 139, 74));

        jLabel3.setText("Mã công thức: ");

        jLabel4.setText("Mã nguyên liệu: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("THÔNG TIN CÔNG THỨC, NGUYÊN LIỆU");

        jLabel5.setText("Số lượng:");

        txtSoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluongActionPerformed(evt);
            }
        });

        jLabel6.setText("Đơn vị đo: ");

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

        btnSearch.setText("Tìm kiếm ");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cboMact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã công thức" }));

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        cboManl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nguyên liệu" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMact, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboManl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(txtDonvido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnSearch))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(jLabel5)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel6))
                        .addComponent(cboMact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(btnFirst)
                            .addGap(18, 18, 18)
                            .addComponent(btnNext)
                            .addGap(18, 18, 18)
                            .addComponent(btnPrevious)
                            .addGap(26, 26, 26)
                            .addComponent(btnLast)
                            .addGap(38, 38, 38)
                            .addComponent(btnReset)
                            .addGap(78, 78, 78)
                            .addComponent(btnInsert)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdate)
                            .addGap(28, 28, 28)
                            .addComponent(btnNew)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelete)
                            .addGap(38, 38, 38)
                            .addComponent(btnPrint)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboManl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonvido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnSearch)
                .addContainerGap(454, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 70, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(cboMact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnFirst)
                        .addComponent(btnNext)
                        .addComponent(btnPrevious)
                        .addComponent(btnLast)
                        .addComponent(btnReset)
                        .addComponent(btnInsert)
                        .addComponent(btnUpdate)
                        .addComponent(btnNew)
                        .addComponent(btnDelete)
                        .addComponent(btnPrint))
                    .addGap(0, 7, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Công thức nguyên liệu", jPanel6);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setText("THÔNG TIN CÔNG THỨC");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 40));

        tblcongthuc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblcongthuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcongthucMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblcongthucMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblcongthuc);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 561, 340));

        btnTim.setText("Tìm kiếm ");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        jPanel5.add(btnTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        btnFirst1.setText("First");
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnFirst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        btnNext1.setText("Next");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnNext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, -1, -1));

        btnPrevious1.setText("Previous");
        btnPrevious1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevious1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnPrevious1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, -1, -1));

        btnLast1.setText("Last");
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnLast1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, -1, -1));

        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnReset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, -1, -1));

        btnInsert1.setText("Insert");
        btnInsert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsert1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnInsert1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));

        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, -1, -1));

        btnNew1.setText("New");
        btnNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 350, -1, -1));

        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, -1, -1));
        jPanel5.add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 110, -1));

        jLabel7.setText("Mã công thức, tên công thức: ");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 20));

        jLabel8.setText("Mã công thức ");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, -1, -1));

        jLabel9.setText("Tên công thức ");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, -1, 20));
        jPanel5.add(txtMacongthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 130, -1));
        jPanel5.add(txtTencongthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 130, -1));

        jTabbedPane2.addTab("Công thức ", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCongthucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCongthucMouseClicked
        int selectedRow = tblCongthuc.getSelectedRow();
        filltoControl(selectedRow);
    }//GEN-LAST:event_tblCongthucMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //        String id =  txtSearch.getText();
        // sử dụng cho text field
        String mact = (String) cboMact.getSelectedItem();

        List<CongThuc_NguyenLieu> list = dao.FindById(mact);
        if (list == null) {
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy");
        } else {
            tblModel.setRowCount(0);
            for (CongThuc_NguyenLieu ct : list) {
                tblModel.addRow(new Object[]{
                    ct.getMaCT(), ct.getTenCongThuc(), ct.getMaNL(), ct.getTenNL(), ct.getSoLuong(), ct.getDonViDoLuong()
                });
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        btnfirst();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        btnnext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        btnprevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        btnlast();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        initTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
//        vadidateForm();
        if (vadidateForm()) {
            CongThuc_NguyenLieu ct = getForm();
            dao.insert(ct);
            initTable();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        CongThuc_NguyenLieu ct = getForm();
        dao.update(ct);
        initTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ClearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = "Mã nguyên liệu";
        int mact = 0;
        int selectedRow = tblCongthuc.getSelectedRow();
        System.out.println(selectedRow);
        if (selectedRow >= 0) {
            id = (String) tblCongthuc.getValueAt(selectedRow, 2);
            mact = (int) tblCongthuc.getValueAt(selectedRow, 0);
            dao.Xoa(mact, id);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn nguyên liệu muốn xóa");
            JOptionPane.showMessageDialog(null, "Chưa chọn mã công thức ");
        }
        initTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        exportToPdf(tblModel);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtSoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluongActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        btnfirst1();
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        btnnext1();
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnPrevious1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevious1ActionPerformed
        btnprevious1();
    }//GEN-LAST:event_btnPrevious1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        btnlast1();
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        loadTable();
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnInsert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsert1ActionPerformed

        if (vadidateForm1()) {
            CongThuc ct = getForm1();
            ctdao.insert(ct);
            loadTable();
        }

    }//GEN-LAST:event_btnInsert1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        if (vadidateForm1()) {
            CongThuc ct = getForm1();
            ctdao.update(ct);
            loadTable();
        }


    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew1ActionPerformed
        txtMacongthuc.setText("");
        txtTencongthuc.setText("");
    }//GEN-LAST:event_btnNew1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed

        int selectedRow = tblcongthuc.getSelectedRow();
        if (selectedRow >= 0) {
            String id = (String) tblcongthuc.getValueAt(selectedRow, 0);
            ctdao.delete(id);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn mã công thức muốn xóa");
        }
        loadTable();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String mact = txtTim.getText();
        CongThuc ct = ctdao.selectById(mact);
        if (ct == null) {
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy");
        } else {
            tblmodel.setRowCount(0);

            tblmodel.addRow(new Object[]{
                ct.getMaCT(), ct.getTenCT()});

        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblcongthucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcongthucMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblcongthucMouseEntered

    private void tblcongthucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcongthucMouseClicked
        int selectedRow = tblcongthuc.getSelectedRow();
        filltocontrol1(selectedRow);
    }//GEN-LAST:event_tblcongthucMouseClicked

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CongThucNguyenLieuJDialog dialog = new CongThucNguyenLieuJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnInsert1;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrevious1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JComboBox<String> cboMact;
    private javax.swing.JComboBox<String> cboManl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblCongthuc;
    private javax.swing.JTable tblcongthuc;
    private javax.swing.JTextField txtDonvido;
    private javax.swing.JTextField txtMacongthuc;
    private javax.swing.JTextField txtMact;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTencongthuc;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

    void initTable() {
        String[] columnsName = {"Mã CT", "Tên CT", "Mã NL", "Tên NL", "Số Lượng", "Đơn vị"};
        tblModel = (DefaultTableModel) tblCongthuc.getModel();
        tblModel.setColumnIdentifiers(columnsName);
        tblModel.setRowCount(0);

        List<CongThuc_NguyenLieu> list = dao.selectAll();

        for (CongThuc_NguyenLieu ct : list) {
            tblModel.addRow(new Object[]{
                ct.getMaCT(), ct.getTenCongThuc(), ct.getMaNL(), ct.getTenNL(), ct.getSoLuong(), ct.getDonViDoLuong()
            });
        }
    }

    public CongThuc_NguyenLieu getForm() {
        int mact = Integer.parseInt(txtMact.getText());
        String manl = (String) cboManl.getSelectedItem();
        int soluong = Integer.parseInt(txtSoluong.getText());
        String donvi = txtDonvido.getText();
        CongThuc_NguyenLieu ct = new CongThuc_NguyenLieu(mact, manl, soluong, donvi);
        return ct;
    }

    public CongThuc getForm1() {
        int mact = Integer.parseInt(txtMacongthuc.getText());
        String tenct = txtTencongthuc.getText();
        CongThuc ct = new CongThuc(mact, tenct);
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
            cboManl.setSelectedItem(value3);
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
        cboManl.setSelectedIndex(0);
        txtSoluong.setText("");
        txtDonvido.setText("");
    }

    public void loadCbo() {
        List<NguyenLieu> listnl = nldao.selectAll();
        for (NguyenLieu nl : listnl) {
            cboManl.addItem(nl.getMaNL());
        }
        List<CongThuc> listct = ctdao.selectAll();
        for (CongThuc ct : listct) {
            cboMact.addItem(String.valueOf(ct.getMaCT()));
        }
    }

    public void exportToPdf(DefaultTableModel table) {
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

    boolean vadidateForm() {
        String mact = txtMact.getText();
        String soluong = txtSoluong.getText();
        String donvi = txtDonvido.getText();
        if (mact.equals("") || soluong.equals("") || donvi.equals("") || cboManl.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Không được để trống bất kì thông tin nào ");
            return false;
        } else {
            return true;
        }
    }

    boolean vadidateForm1() {
        String mact = txtMacongthuc.getText();
        String tenct = txtTencongthuc.getText();
        if (mact.equals("") || tenct.equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống bất kì thông tin nào ");
            return false;
        } else {
            return true;
        }

    }

}
