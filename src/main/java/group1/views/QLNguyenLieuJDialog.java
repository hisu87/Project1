/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import javax.swing.table.DefaultTableModel;

import group1.dao.NguyenLieuDAO;
import group1.entity.NguyenLieu;
import group1.utils.Auth;
import group1.utils.msgBox;
import group1.utils.xImage;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author numpa
 */
public class QLNguyenLieuJDialog extends javax.swing.JDialog {

    NguyenLieuDAO dao = new NguyenLieuDAO();
    int row = -1;

    /**
     * Creates new form QLNhanVienJDialog
     */
    public QLNguyenLieuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Quản Lý Nguyên Liệu");
        fillTable();
        setIconImage(xImage.getAppIcon());
        setLocationRelativeTo(parent);
    }

    NguyenLieu getForm() {
        NguyenLieu nl = new NguyenLieu();
        nl.setMaNL(txt_MaNL.getText());
        nl.setTenNL(txt_TenNL.getText());
        nl.setSoLuongCon(Float.parseFloat(txt_SoLuong.getText()));
        nl.setGiaNL(Float.parseFloat(txt_Gia.getText()));
        nl.setDonViDoLuong(txt_DonVi.getText());

        return nl;
    }

    void insert() {
        // TODO
        NguyenLieu nl = getForm();
        try {
            dao.insert(nl);
            this.fillTable();
            clearForm();
            msgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            msgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        //
        NguyenLieu nl = getForm();
        try {
            dao.update(nl);
            this.fillTable();
            msgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            msgBox.alert(this, "Cập nhật thất bại!");
        }
    }

    void delete() {
        // TODO
        if (!Auth.isManager()) {
            msgBox.alert(this, "Bạn không có quyền xóa nguyên liệu!");
        } else {
            String manl = txt_MaNL.getText();
            if (msgBox.confirm(this, "Bạn thực sự muốn xóa nguyên liệu này?")) {
                try {
                    dao.delete(manl);
                    this.fillTable();
                    this.clearForm();
                    msgBox.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    msgBox.alert(this, "Xóa thất bại!");
                }
            }
        }
    }

    // ...

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_nguyenlieu.getModel();
        model.setRowCount(0);
        try {
            List<NguyenLieu> list = dao.selectAll(); // Assuming dao.getAll() returns a list of NguyenLieu objects
            for (NguyenLieu nl : list) {
                Object[] rows = { nl.getMaNL(), nl.getTenNL(), nl.getSoLuongCon(),
                        nl.getDonViDoLuong(), nl.getGiaNL() };
                model.addRow(rows);
            }
        } catch (Exception e) {
            Logger.getLogger(QLNguyenLieuJDialog.class.getName()).log(Level.SEVERE, null, e);
            msgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void setForm() {
        // TODO
        txt_MaNL.setText((String) tbl_nguyenlieu.getValueAt(row, 0));
        txt_TenNL.setText((String) tbl_nguyenlieu.getValueAt(row, 1));
        txt_SoLuong.setText(String.valueOf(tbl_nguyenlieu.getValueAt(row, 2)));
        txt_Gia.setText(String.valueOf(tbl_nguyenlieu.getValueAt(row, 4)));
        txt_DonVi.setText((String) tbl_nguyenlieu.getValueAt(row, 3));
    }

    void clearForm() {
        // TODO
        txt_MaNL.setText("");
        txt_TenNL.setText("");
        txt_SoLuong.setText("");
        txt_Gia.setText("");
        txt_DonVi.setText("");
    }

    void edit() {
        // TODO
        String manl = (String) tbl_nguyenlieu.getValueAt(this.row, 0);
        NguyenLieu nl = dao.selectById(manl);
        this.setForm();
        this.updateStatus();
    }

    void updateStatus() {
        // TODO
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tbl_nguyenlieu.getRowCount() - 1);
        // Trạng thái form
        txt_MaNL.setEditable(!edit);
        btnAdd.setEnabled(!edit);
        btnEdit.setEnabled(edit);
        btnDelete.setEnabled(edit);
        // Trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    void search() {
        // TODO
    }

    void first() {
        // TODO
    }

    void prev() {
        // TODO
    }

    void next() {
        // TODO
    }

    void last() {
        // TODO
    }

    // Feteares
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainPanel = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nguyenlieu = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        lbl_MaNL = new javax.swing.JLabel();
        txt_MaNL = new javax.swing.JTextField();
        txt_TenNL = new javax.swing.JTextField();
        lbl_TenNL = new javax.swing.JLabel();
        lbl_SoLuong = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        lbl_DonVi = new javax.swing.JLabel();
        txt_DonVi = new javax.swing.JTextField();
        txt_Gia = new javax.swing.JTextField();
        lbl_Gia = new javax.swing.JLabel();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlMainPanel.setBackground(new java.awt.Color(132, 35, 60));
        pnlMainPanel.setForeground(new java.awt.Color(242, 240, 235));

        lbl_title.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(235, 202, 188));
        lbl_title.setText("Quản Lý Nguyên Liệu");
        lbl_title.setToolTipText("Merry Christmas");

        tbl_nguyenlieu.setAutoCreateRowSorter(true);
        tbl_nguyenlieu.setBackground(new java.awt.Color(0, 117, 74));
        tbl_nguyenlieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_nguyenlieu.setForeground(new java.awt.Color(235, 202, 188));
        tbl_nguyenlieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NL01", "Robustar Medium", "100", "Kg", "5000000"},
                {"NL02", "Arabica Light", "200", "Kg", "7500000"},
                {"NL03", "Rich Lùn", "10", "Thùng x 350ml", "25000000"},
                {"NL04", "TH True Milk", "20", "Hộp 1L", "2000000"}
            },
            new String [] {
                "Mã Nguyên Liệu", "Tên Nguyên Liệu", "Số Lượng", "Đơn Vị", "Giá"
            }
        ));
        tbl_nguyenlieu.setToolTipText("Merry Christmas");
        tbl_nguyenlieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nguyenlieuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nguyenlieu);
        if (tbl_nguyenlieu.getColumnModel().getColumnCount() > 0) {
            tbl_nguyenlieu.getColumnModel().getColumn(0).setPreferredWidth(35);
            tbl_nguyenlieu.getColumnModel().getColumn(1).setPreferredWidth(55);
            tbl_nguyenlieu.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbl_nguyenlieu.getColumnModel().getColumn(3).setPreferredWidth(30);
            tbl_nguyenlieu.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        txt_search.setForeground(new java.awt.Color(235, 202, 188));
        txt_search.setText("Search");
        txt_search.setToolTipText("Mã NL, Tên NL");

        btn_search.setBackground(new java.awt.Color(213, 233, 226));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-find-24.png"))); // NOI18N
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        lbl_MaNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_MaNL.setForeground(new java.awt.Color(235, 202, 188));
        lbl_MaNL.setText("Mã Nguyên Liệu");

        txt_MaNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_MaNL.setToolTipText("NLXX");
        txt_MaNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaNLActionPerformed(evt);
            }
        });

        txt_TenNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TenNL.setToolTipText("tên nguyên liệu");

        lbl_TenNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_TenNL.setForeground(new java.awt.Color(235, 202, 188));
        lbl_TenNL.setText("Tên Nguyên Liệu");

        lbl_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_SoLuong.setForeground(new java.awt.Color(235, 202, 188));
        lbl_SoLuong.setText("Số Lượng");

        txt_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SoLuong.setToolTipText("số lượng nguyên liệu");
        txt_SoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoLuongActionPerformed(evt);
            }
        });

        lbl_DonVi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_DonVi.setForeground(new java.awt.Color(235, 202, 188));
        lbl_DonVi.setText("Đơn Vị");

        txt_DonVi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_DonVi.setToolTipText("kg, hộp, lít, ml, .....");

        txt_Gia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Gia.setToolTipText("tổng giá nhập nguyên liệu vào");

        lbl_Gia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Gia.setForeground(new java.awt.Color(235, 202, 188));
        lbl_Gia.setText("Giá");

        btnLast.setBackground(new java.awt.Color(213, 233, 226));
        btnLast.setForeground(new java.awt.Color(235, 202, 188));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_right_20px.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(213, 233, 226));
        btnNext.setForeground(new java.awt.Color(235, 202, 188));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_right_20px.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(213, 233, 226));
        btnPrev.setForeground(new java.awt.Color(235, 202, 188));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_left_20px.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(213, 233, 226));
        btnFirst.setForeground(new java.awt.Color(235, 202, 188));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_left_20px.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(30, 57, 50));
        btnNew.setForeground(new java.awt.Color(235, 202, 188));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-delete-20.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(30, 57, 50));
        btnDelete.setForeground(new java.awt.Color(235, 202, 188));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-delete-20.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(30, 57, 50));
        btnEdit.setForeground(new java.awt.Color(235, 202, 188));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-edit-20.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(30, 57, 50));
        btnAdd.setForeground(new java.awt.Color(235, 202, 188));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-add-20.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainPanelLayout = new javax.swing.GroupLayout(pnlMainPanel);
        pnlMainPanel.setLayout(pnlMainPanelLayout);
        pnlMainPanelLayout.setHorizontalGroup(
            pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainPanelLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlMainPanelLayout.createSequentialGroup()
                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_MaNL)
                                    .addComponent(txt_MaNL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_DonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_TenNL)
                                    .addComponent(txt_TenNL, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_DonVi)
                                    .addComponent(lbl_SoLuong)
                                    .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Gia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainPanelLayout.createSequentialGroup()
                                .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainPanelLayout.createSequentialGroup()
                                                .addComponent(btnAdd)
                                                .addGap(37, 37, 37))
                                            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)))
                                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEdit))
                                        .addGap(51, 51, 51)
                                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDelete))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_Gia))
                                .addGap(93, 93, 93)))
                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_search)
                                .addGap(0, 32, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
        );
        pnlMainPanelLayout.setVerticalGroup(
            pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(18, 18, 18)
                .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainPanelLayout.createSequentialGroup()
                        .addComponent(lbl_MaNL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_MaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_TenNL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_SoLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_DonVi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_DonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Gia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew))
                        .addGap(16, 16, 16)
                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_nguyenlieuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_nguyenlieuMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tbl_nguyenlieu.getSelectedRow();
            if (this.row >= 0) {
                this.edit();
            }
        }
    }// GEN-LAST:event_tbl_nguyenlieuMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btn_searchActionPerformed

    private void txt_MaNLActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_MaNLActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_MaNLActionPerformed

    private void txt_SoLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_SoLuongActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_SoLuongActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLastActionPerformed
        // last();
    }// GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
        // next();
    }// GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrevActionPerformed
        // prev();
    }// GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFirstActionPerformed
        // first();
    }// GEN-LAST:event_btnFirstActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNewActionPerformed
        // clearForm();
    }// GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        // delete();
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        // update();
    }// GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        // insert();
    }// GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(QLNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLNguyenLieuJDialog dialog = new QLNguyenLieuJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btn_search;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_DonVi;
    private javax.swing.JLabel lbl_Gia;
    private javax.swing.JLabel lbl_MaNL;
    private javax.swing.JLabel lbl_SoLuong;
    private javax.swing.JLabel lbl_TenNL;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnlMainPanel;
    private javax.swing.JTable tbl_nguyenlieu;
    private javax.swing.JTextField txt_DonVi;
    private javax.swing.JTextField txt_Gia;
    private javax.swing.JTextField txt_MaNL;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_TenNL;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
