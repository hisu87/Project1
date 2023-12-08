/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import javax.swing.table.DefaultTableModel;

import group1.dao.NguyenLieuDAO;
import group1.entity.NguyenLieu;
import group1.utils.Auth;
import group1.utils.MailService;
import group1.utils.msgBox;
import group1.utils.xImage;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author numpa
 */
public class QLNguyenLieuJDialog extends javax.swing.JDialog {

    NguyenLieuDAO dao = new NguyenLieuDAO();
    int row = -1;
    String maNV = Auth.user.getMaNV();
    String role = Auth.user.getVaitro();

    /**
     * Creates new form QLNhanVienJDialog
     */
    public QLNguyenLieuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Quản Lý Nguyên Liệu");
        setLocationRelativeTo(null);
        setIconImage(xImage.getAppIcon());
        innit();
    }

    void innit() {
        startClock();
        displayUserInfo();
        fillTable();
        txt_search.setText("");
        search();

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
        if (!Auth.isManager()) {
            msgBox.alert(this, "Bạn không có quyền thêm nguyên liệu!");
        } else {
            if (validateForm()) {
                NguyenLieu nl = getForm();
                try {
                    dao.insert(nl);
                    this.fillTable();
                    this.clearForm();
                    String mes = "Nguyên liệu: " + nl.getMaNL() + " | " + nl.getTenNL() + " | "
                            + "Đã được thêm mới bởi nhân viên: " + maNV + " | " + role;
                    MailService.sendMail("Nguyên liệu đã được thêm mới", mes);
                    msgBox.alert(this, "Thêm mới thành công!");
                } catch (Exception e) {
                    msgBox.alert(this, "Thêm mới thất bại!");
                }
            }
        }
    }

    void update() {
        //
        if (Auth.isManager()) {
            if (validateForm()) {
                NguyenLieu nl = getForm();
                try {
                    String mes = "Nguyên liệu: " + nl.getMaNL() + " | " + nl.getTenNL() + " | "
                            + "<br> Đã được chỉnh sửa bởi nhân viên: " + maNV + " | " + role;
                    MailService.sendMail("Nguyên liệu đã được chỉnh sửa", mes);
                    dao.update(nl);
                    this.fillTable();
                    msgBox.alert(this, "Cập nhật thành công!");

                } catch (Exception e) {
                    msgBox.alert(this, "Cập nhật thất bại!");
                }
            }
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
            String keyword = txt_search.getText();
            List<NguyenLieu> list = dao.selectByKeyword(keyword); // Assuming dao.getAll() returns a list of NguyenLieu
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

    void setForm(NguyenLieu nl) {
        // TODO
        txt_MaNL.setText(nl.getMaNL());
        txt_TenNL.setText(nl.getTenNL());
        txt_SoLuong.setText(String.valueOf(nl.getSoLuongCon()));
        txt_Gia.setText(String.valueOf(nl.getGiaNL()));
        txt_DonVi.setText(nl.getDonViDoLuong());
    }

    void clearForm() {
        // TODO
        NguyenLieu nl = new NguyenLieu();
        this.setForm(nl);
        this.row = -1;
        this.updateStatus();
    }

    void edit() {

        String manl = (String) tbl_nguyenlieu.getValueAt(this.row, 0);
        NguyenLieu nl = dao.selectById(manl);
        this.setForm(nl);
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
        if (this.row < tbl_nguyenlieu.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        // TODO
        this.row = tbl_nguyenlieu.getRowCount() - 1;
        this.edit();
    }

    boolean validateForm() {
        if (txt_MaNL.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống mã nguyên liệu!");
            txt_MaNL.requestFocus();
            return false;
        } else if (txt_TenNL.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống tên nguyên liệu!");
            txt_TenNL.requestFocus();
            return false;
        } else if (txt_SoLuong.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống số lượng!");
            txt_SoLuong.requestFocus();
            return false;
        } else if (txt_DonVi.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống đơn vị!");
            txt_DonVi.requestFocus();
            return false;
        } else if (txt_Gia.getText().length() == 0) {
            msgBox.alert(this, "Không được để trống giá!");
            txt_Gia.requestFocus();
            return false;
        } else {
            return true;
            // TODO: Add your code here
        }
    }

    void exportExcel(JTable table, File file) {
        if (Auth.isManager()) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");
            TableModel model = table.getModel();
            String maVN = Auth.user.getMaNV();
            String role = Auth.user.getVaitro();
            String title = "Danh sách nguyên liệu";
            String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
            MailService.sendMail(title,
                    "Nhân Viên:" + maVN + " | " + role + " | " + "Đã xuất file nguyên liệu vào ngày:" + date);

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }

            // Create data rows
            for (int i = 0; i < model.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    Object value = model.getValueAt(i, j);
                    if (value instanceof Number) {
                        cell.setCellValue(((Number) value).doubleValue());
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                }
            }

            try (FileOutputStream out = new FileOutputStream(file)) {
                workbook.write(out);
            } catch (IOException e) {
                throw new RuntimeException("Error writing to file", e);
            }
        } else {
            msgBox.alert(this, "Bạn không có quyền xuất file!");
        }
    }

    // Feteares
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainPanel = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nguyenlieu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_MaNL = new javax.swing.JLabel();
        txt_MaNL = new javax.swing.JTextField();
        lbl_TenNL = new javax.swing.JLabel();
        txt_TenNL = new javax.swing.JTextField();
        lbl_SoLuong = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        lbl_DonVi = new javax.swing.JLabel();
        txt_DonVi = new javax.swing.JTextField();
        txt_Gia = new javax.swing.JTextField();
        lbl_Gia = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btn_export = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_clock = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlMainPanel.setBackground(new java.awt.Color(252, 177, 166));
        pnlMainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true));
        pnlMainPanel.setForeground(new java.awt.Color(242, 240, 235));

        lbl_title.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 232, 209));
        lbl_title.setText("Quản Lý Nguyên Liệu");
        lbl_title.setToolTipText("Merry Christmas");

        jPanel1.setBackground(new java.awt.Color(234, 181, 99));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true));

        txt_search.setForeground(new java.awt.Color(235, 202, 188));
        txt_search.setText("Search");
        txt_search.setToolTipText("Mã NL, Tên NL");
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        btn_search.setBackground(new java.awt.Color(213, 233, 226));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-find-24.png"))); // NOI18N
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(242, 240, 235));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 1, true));

        tbl_nguyenlieu.setAutoCreateRowSorter(true);
        tbl_nguyenlieu.setBackground(new java.awt.Color(139, 177, 116));
        tbl_nguyenlieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_nguyenlieu.setForeground(new java.awt.Color(235, 202, 188));
        tbl_nguyenlieu.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { "NL01", "Robustar Medium", "100", "Kg", "5000000" },
                        { "NL02", "Arabica Light", "200", "Kg", "7500000" },
                        { "NL03", "Rich Lùn", "10", "Thùng x 350ml", "25000000" },
                        { "NL04", "TH True Milk", "20", "Hộp 1L", "2000000" }
                },
                new String[] {
                        "Mã Nguyên Liệu", "Tên Nguyên Liệu", "Số Lượng", "Đơn Vị", "Giá"
                }));
        tbl_nguyenlieu.setToolTipText("Merry Christmas");
        tbl_nguyenlieu.setCellSelectionEnabled(true);
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
        tbl_nguyenlieu.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txt_search)
                                .addGap(18, 18, 18)
                                .addComponent(btn_search)
                                .addContainerGap())
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_search)
                                        .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485,
                                        Short.MAX_VALUE)));

        jPanel2.setBackground(new java.awt.Color(247, 214, 201));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true));

        lbl_MaNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_MaNL.setForeground(new java.awt.Color(0, 0, 0));
        lbl_MaNL.setText("Mã Nguyên Liệu");

        txt_MaNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_MaNL.setForeground(new java.awt.Color(0, 0, 0));
        txt_MaNL.setToolTipText("NLXX");
        txt_MaNL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaNLActionPerformed(evt);
            }
        });

        lbl_TenNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_TenNL.setForeground(new java.awt.Color(0, 0, 0));
        lbl_TenNL.setText("Tên Nguyên Liệu");

        txt_TenNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TenNL.setForeground(new java.awt.Color(0, 0, 0));
        txt_TenNL.setToolTipText("tên nguyên liệu");

        lbl_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_SoLuong.setForeground(new java.awt.Color(0, 0, 0));
        lbl_SoLuong.setText("Số Lượng");

        txt_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SoLuong.setForeground(new java.awt.Color(0, 0, 0));
        txt_SoLuong.setToolTipText("số lượng nguyên liệu");
        txt_SoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoLuongActionPerformed(evt);
            }
        });

        lbl_DonVi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_DonVi.setForeground(new java.awt.Color(0, 0, 0));
        lbl_DonVi.setText("Đơn Vị");

        txt_DonVi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_DonVi.setForeground(new java.awt.Color(0, 0, 0));
        txt_DonVi.setToolTipText("kg, hộp, lít, ml, .....");

        txt_Gia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Gia.setForeground(new java.awt.Color(0, 0, 0));
        txt_Gia.setToolTipText("tổng giá nhập nguyên liệu vào");

        lbl_Gia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Gia.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Gia.setText("Giá");

        btnAdd.setBackground(new java.awt.Color(234, 181, 99));
        btnAdd.setForeground(new java.awt.Color(235, 202, 188));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-20.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(234, 181, 99));
        btnFirst.setForeground(new java.awt.Color(235, 202, 188));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_double_left_20px.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(234, 181, 99));
        btnEdit.setForeground(new java.awt.Color(235, 202, 188));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-edit-20.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(234, 181, 99));
        btnPrev.setForeground(new java.awt.Color(235, 202, 188));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_left_20px.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(234, 181, 99));
        btnNew.setForeground(new java.awt.Color(235, 202, 188));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-new-20.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(234, 181, 99));
        btnNext.setForeground(new java.awt.Color(235, 202, 188));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_right_20px.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(234, 181, 99));
        btnDelete.setForeground(new java.awt.Color(235, 202, 188));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-20.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(234, 181, 99));
        btnLast.setForeground(new java.awt.Color(235, 202, 188));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_double_right_20px.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btn_export.setBackground(new java.awt.Color(234, 181, 99));
        btn_export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-excel-20.png"))); // NOI18N
        btn_export.setText("Export To Exel");
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_Gia, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(btnFirst,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(55, 55, 55)
                                                                .addComponent(btnPrev,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(btnAdd,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(55, 55, 55)
                                                                .addComponent(btnEdit,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47,
                                                        Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(btnNew,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(40, 40, 40)
                                                                        .addComponent(btnDelete,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(btnNext,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(btnLast,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(txt_TenNL)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl_MaNL)
                                                        .addComponent(lbl_SoLuong)
                                                        .addComponent(lbl_DonVi)
                                                        .addComponent(txt_MaNL, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txt_SoLuong,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbl_Gia)
                                                        .addComponent(lbl_TenNL)
                                                        .addComponent(txt_DonVi, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btn_export,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 149,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_MaNL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_MaNL, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_TenNL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_TenNL, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_SoLuong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_DonVi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_DonVi, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Gia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Gia, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_export)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnPrev,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));

        jPanel3.setBackground(new java.awt.Color(242, 240, 235));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        lbl_clock.setBackground(new java.awt.Color(0, 0, 0));
        lbl_clock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_clock.setForeground(new java.awt.Color(255, 232, 209));
        lbl_clock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_alarm_clock_25px.png"))); // NOI18N

        lbl_user.setBackground(new java.awt.Color(0, 0, 0));
        lbl_user.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(255, 232, 209));
        lbl_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_username_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_user, javax.swing.GroupLayout.PREFERRED_SIZE, 412,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_clock, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_clock, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_user, javax.swing.GroupLayout.DEFAULT_SIZE, 28,
                                                Short.MAX_VALUE))
                                .addContainerGap()));

        javax.swing.GroupLayout pnlMainPanelLayout = new javax.swing.GroupLayout(pnlMainPanel);
        pnlMainPanel.setLayout(pnlMainPanelLayout);
        pnlMainPanelLayout.setHorizontalGroup(
                pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMainPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                .addGap(324, 324, 324)
                                .addComponent(lbl_title)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        pnlMainPanelLayout.setVerticalGroup(
                pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlMainPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_exportActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Save file");
        int select = chooser.showSaveDialog(this);
        if (select == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            if (!f.getName().endsWith(".xlsx")) {
                f = new File(f.getAbsolutePath() + ".xlsx");
            }
            exportExcel(tbl_nguyenlieu, f);
            msgBox.alert(this, "Xuất file thành công");
            try {
                Desktop.getDesktop().open(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }// GEN-LAST:event_btn_exportActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        search();
    }// GEN-LAST:event_txt_searchKeyReleased

    private void tbl_nguyenlieuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbl_nguyenlieuMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tbl_nguyenlieu.getSelectedRow();
            this.edit();
            System.out.println("hola");
        }
    }// GEN-LAST:event_tbl_nguyenlieuMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        insert();
    }// GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        update();
    }// GEN-LAST:event_btnEditActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearForm();
    }// GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }// GEN-LAST:event_btnDeleteActionPerformed

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
        last();
    }// GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
        next();
    }// GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }// GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFirstActionPerformed
        first();
    }// GEN-LAST:event_btnFirstActionPerformed

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
    private javax.swing.JButton btn_export;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_DonVi;
    private javax.swing.JLabel lbl_Gia;
    private javax.swing.JLabel lbl_MaNL;
    private javax.swing.JLabel lbl_SoLuong;
    private javax.swing.JLabel lbl_TenNL;
    private javax.swing.JLabel lbl_clock;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_user;
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
