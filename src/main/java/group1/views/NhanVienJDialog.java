/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import group1.dao.HoaDonDAO;
import group1.dao.NhanVienDAO;
import group1.entity.NguyenLieu;
import group1.entity.NhanVien;
import group1.utils.Auth;
import group1.utils.msgBox;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SON
 */
public class NhanVienJDialog extends javax.swing.JDialog {

    
     NhanVienDAO dao = new NhanVienDAO();
     int row = -1;
    /**
     * Creates new form NhanVienJDialog
     */
    public NhanVienJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        
    }
    
    void init(){
    txt_search.setText(" ");
    fillTable();
    }


    NhanVien getform(){
        NhanVien nv = new NhanVien();
        
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(txtHoten.getText());
        nv.setMatKhau(txtpass.getText());
        nv.setMatKhau(txtpassword.getText());
        nv.setDiaChi(txt_Diachi.getText());
        nv.setTuoi(Integer.parseInt(txtTuoi.getText()));
        nv.setVaitro(txtvaitro.getText());
        nv.setGioiTinh(txtGioitinh.getText());
        return nv;
    }
    
    void insert() {
        // TODO
        if (validateForm()) {
            NhanVien nv = getform();
            try {
               dao.insert(nv);
                this.fillTable();
                clearForm();
                msgBox.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                msgBox.alert(this, "Thêm mới thất bại!");
            }
        }
    }

    void update() {
        //
        if (validateForm()) {
            NhanVien nv = getform();
            try {
                dao.update(nv);
                this.fillTable();
                msgBox.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                msgBox.alert(this, "Cập nhật thất bại!");
            }
        }
    }

    void delete() {
        // TODO
        if (!Auth.isManager()) {
            msgBox.alert(this, "Bạn không có quyền xóa nhân viên!");
        } else {
            String manl = txtMaNV.getText();
            if (msgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
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
        DefaultTableModel model = (DefaultTableModel) tbl_nhanvien.getModel();
        model.setRowCount(0);
        try {
            String keyword = txt_search.getText();
            List<NhanVien> list = dao.selectByKeyword(keyword); // Assuming dao.getAll() returns a list of NguyenLieu
            for (NhanVien nv : list) {
                Object[] rows = { nv.getMaNV(), nv.getHoTen(), nv.getMatKhau(),
                        nv.getGioiTinh(), nv.getVaitro(),  nv.getSdt(),nv.getTuoi(), nv.getDiaChi()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            msgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void search(){
        
    }

    void setForm(NhanVien nv) {
        // TODO
        txtMaNV.setText(nv.getMaNV());
        txtHoten.setText(nv.getHoTen());
        txtpass.setText(nv.getMatKhau());
        txtpassword.setText(nv.getMatKhau());
        txt_Diachi.setText(nv.getDiaChi());
        txtTuoi.setText(String.valueOf(nv.getTuoi()));
        txtvaitro.setText(nv.getVaitro());
        txtGioitinh.setText(nv.getGioiTinh());
    }

    void clearForm() {
        // TODO
        NhanVien nv = new NhanVien();
        this.setForm(nv);
        this.row = -1;
        this.updateStatus();
    }

    void edit() {
        String manv = (String) tbl_nhanvien.getValueAt(this.row, 0);
        NhanVien nv = dao.selectById(manv);
        this.setForm(nv);
        this.updateStatus();
    }

    void updateStatus() {
        // TODO
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tbl_nhanvien.getRowCount() - 1);
        // Trạng thái form
        
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
        // Trạng thái điều hướng
        btn_first.setEnabled(edit && !first);
        btn_previous.setEnabled(edit && !first);
        btn_next.setEnabled(edit && !last);
        btn_last.setEnabled(edit && !last);
    }

    void search() {
        // TODO
        this.fillTable();
        this.clearForm();
        this.row = -1;
        this.updateStatus();
    }

    void first() {
        // TODO
        this.row = 0;
        this.edit();
    }

    void prev() {
        // TODO
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void next() {
        // TODO
        if (this.row < tbl_nhanvien.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        // TODO
        this.row = tbl_nhanvien.getRowCount() - 1;
        this.edit();
    }

    boolean validateForm() {
        if (txtMaNV.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống mã nhân viên!");
            txtMaNV.requestFocus();
            return false;
        } else if (txtHoten.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống tên nhân viên!");
            txtHoten.requestFocus();
            return false;
        } else if (txtpass.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống mật khẩu!");
            txtpass.requestFocus();
            return false;
        }else if (txtpassword.getText().length() == 0) {
            msgBox.alert(this, "Vui lòng nhập lại mật khẩu!");
            txtpass.requestFocus();
            return false;
        }else if (txt_Diachi.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống điaj chỉ!");
            txt_Diachi.requestFocus();
            return false;
        } else if (txtTuoi.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống tuổi!");
            txtTuoi.requestFocus();
            return false;
        
        } else if (txtvaitro.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống vai trò!");
            txtvaitro.requestFocus();
            return false;
        }else if (txtGioitinh.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống giới tính!");
            txtGioitinh.requestFocus();
            return false;
        }else {
            return true;
            // TODO: Add your code here
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel18 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_previous = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtGioitinh = new javax.swing.JTextField();
        txtvaitro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_Diachi = new javax.swing.JTextField();

        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_alarm_clock_25px.png"))); // NOI18N
        jLabel9.setText("00:00:00 SA");

        jLabel18.setText("jLabel18");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBackground(new java.awt.Color(131, 35, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 240, 235));
        jLabel2.setText("Quản Lý Nhân Viên");

        jLabel10.setForeground(new java.awt.Color(242, 240, 235));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_alarm_clock_25px.png"))); // NOI18N
        jLabel10.setText("00:00:00 SA");

        jTabbedPane1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel3.setBackground(new java.awt.Color(28, 97, 51));

        tbl_nhanvien.setAutoCreateRowSorter(true);
        tbl_nhanvien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NV01", "Trần Dần", "112", "Nam", "Nhân Viên", null, "22/1/11997"},
                {"NV02", "Trần Dần", "112", "Nam", "Nhân Viên", null, "22/1/11997"},
                {"NV03", "Trần Dần", "112", "Nam", "Nhân Viên", null, "22/1/11997"},
                {"NV04", "Trần Dần", "112", "Nam", "Nhân Viên", null, "22/1/11997"}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Mật Khẩu", "Giới Tính", "Vai Trò", "SDT", "Tuổi"
            }
        ));
        tbl_nhanvien.setToolTipText("Merry Christmas");
        jScrollPane1.setViewportView(tbl_nhanvien);

        txt_search.setBackground(new java.awt.Color(102, 102, 0));
        txt_search.setForeground(new java.awt.Color(235, 202, 188));
        txt_search.setText("Search");
        txt_search.setToolTipText("Mã NL, Tên NL");
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        btn_search.setBackground(new java.awt.Color(102, 102, 0));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8-find-24.png"))); // NOI18N
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_first.setBackground(new java.awt.Color(153, 153, 153));
        btn_first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_left_20px.png"))); // NOI18N

        btn_next.setBackground(new java.awt.Color(153, 153, 153));
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_left_20px.png"))); // NOI18N

        btn_previous.setBackground(new java.awt.Color(153, 153, 153));
        btn_previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_right_20px.png"))); // NOI18N

        btn_last.setBackground(new java.awt.Color(153, 153, 153));
        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_double_right_20px.png"))); // NOI18N

        btn_delete.setBackground(new java.awt.Color(153, 153, 153));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-20.png"))); // NOI18N
        btn_delete.setText("Delete");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_delete)
                .addGap(63, 63, 63))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_next)
                    .addComponent(btn_last)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_first)
                        .addComponent(btn_delete))
                    .addComponent(btn_previous))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông Tin Nhân Viên", jPanel2);

        jPanel1.setBackground(new java.awt.Color(28, 97, 51));

        jLabel3.setForeground(new java.awt.Color(242, 240, 235));
        jLabel3.setText("Mã Nhân Viên");

        jLabel4.setForeground(new java.awt.Color(242, 240, 235));
        jLabel4.setText("Họ Và Tên");

        jLabel5.setForeground(new java.awt.Color(242, 240, 235));
        jLabel5.setText("Mật Khẩu");

        jLabel6.setForeground(new java.awt.Color(242, 240, 235));
        jLabel6.setText("Xác Nhận Mật Khẩu");

        jLabel8.setForeground(new java.awt.Color(242, 240, 235));
        jLabel8.setText("Tuổi");

        jLabel11.setForeground(new java.awt.Color(242, 240, 235));
        jLabel11.setText("Vai Trò");

        jLabel12.setForeground(new java.awt.Color(242, 240, 235));
        jLabel12.setText("Giới Tính ");

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_update_user_20px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_delete_20px.png"))); // NOI18N
        btnXoa.setText("Xóa");

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_change_20px.png"))); // NOI18N
        btnMoi.setText("Mới");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/group1/images/icons8_book_20px.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Địa Chỉ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Diachi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                    .addComponent(txtHoten, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtvaitro)
                                    .addComponent(txtGioitinh))))
                        .addGap(215, 215, 215)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMoi)))
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        jTabbedPane1.addTab("Chỉnh Sửa Nhân Viên", jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        this.row = -1;
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchKeyReleased

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
            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVienJDialog dialog = new NhanVienJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JButton btn_search;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_nhanvien;
    private javax.swing.JTextField txtGioitinh;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTuoi;
    private javax.swing.JTextField txt_Diachi;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtvaitro;
    // End of variables declaration//GEN-END:variables
}
