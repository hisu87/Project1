/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import group1.dao.HoaDonDAO;
import group1.dao.ThongKeDAO;
import group1.utils.Auth;
import group1.utils.MailService;
import group1.utils.msgBox;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

/**
 *
 * @author numpa
 */
public class DoanhThuJDialog extends javax.swing.JDialog {

    ThongKeDAO dao = new ThongKeDAO();
    HoaDonDAO daoHD = new HoaDonDAO();

    /**
     * Creates new form DoanhThuJDialog
     */
    public DoanhThuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        DateString();
        fillcboYear();
        center();
    }

    void center() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tlb_doanhthu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tlb_doanhthu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tlb_doanhthu.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    }

    void DateString() {
        datefrom.setDateFormatString("yyyy-MM-dd");
        dateto.setDateFormatString("yyyy-MM-dd");
        date.setDateFormatString("yyyy-MM-dd");
        datefrom.setDate(new java.util.Date());
        dateto.setDate(new java.util.Date());
        date.setDate(new java.util.Date());

    }

    void fillbyYear() {
        DefaultTableModel model = (DefaultTableModel) tlb_doanhthu.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao.getDoanhThuYear();
        for (Object[] row : list) {
            model.addRow(new Object[] { row[0], row[1], row[2] });
        }
        checkMinMaxValues();
    }

    void fillcboYear() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_year.getModel();
        model.removeAllElements();
        List<Integer> list = daoHD.selectYear();
        for (Integer year : list) {
            model.addElement(year);
        }
    }

    void fillbyMonthInYear() {
        DefaultTableModel model = (DefaultTableModel) tlb_doanhthu.getModel();
        model.setRowCount(0);
        int year = (Integer) cbo_year.getSelectedItem();
        List<Object[]> list = dao.getDoanhThuMonth(year);
        for (Object[] row : list) {
            model.addRow(new Object[] { row[0], row[1], row[2] });
        }
        checkMinMaxValues();
    }

    void fillbyDay() {
        DefaultTableModel model = (DefaultTableModel) tlb_doanhthu.getModel();
        model.setRowCount(0);
        Date daTe = date.getDate();
        List<Object[]> list = dao.getDoanhThuDay(daTe);
        for (Object[] row : list) {
            model.addRow(new Object[] { row[0], row[1], row[2] });
        }
        checkMinMaxValues();
    }

    void fillbyDateRange() {
        DefaultTableModel model = (DefaultTableModel) tlb_doanhthu.getModel();
        model.setRowCount(0);
        Date date1 = datefrom.getDate();
        Date date2 = dateto.getDate();
        List<Object[]> list = dao.getDoanhThuDateRange(date1, date2);
        for (Object[] row : list) {
            model.addRow(new Object[] { row[0], row[1], row[2] });
        }
        checkMinMaxValues();
    }

    private void checkMinMaxValues() {
        int selectedColumn = 2; // Chỉ số cột chứa doanh thu

        ArrayList<Integer> values = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tlb_doanhthu.getModel();

        // Lấy giá trị từ cột đã chọn và thêm vào danh sách
        for (int row = 0; row < model.getRowCount(); row++) {
            Object value = model.getValueAt(row, selectedColumn);
            if (value instanceof Number) {
                values.add(((Number) value).intValue());
            }
        }

        // Kiểm tra nếu danh sách không trống
        if (!values.isEmpty()) {
            int maxValue = Collections.max(values);
            int minValue = Collections.min(values);

            // Gán giá trị cao nhất và thấp nhất vào các Label
            lbl_max.setText("Giá trị cao nhất: " + maxValue);
            lbl_min.setText("Giá trị thấp nhất: " + minValue);
        } else {
            // Nếu danh sách trống, hiển thị thông báo
            lbl_max.setText("Không có giá trị");
            lbl_min.setText("Không có giá trị");
        }
    }

    void exportExcel(JTable table, File file) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        TableModel model = table.getModel();

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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlb_doanhthu = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbo_year = new javax.swing.JComboBox<>();
        date = new com.toedter.calendar.JDateChooser();
        datefrom = new com.toedter.calendar.JDateChooser();
        dateto = new com.toedter.calendar.JDateChooser();
        btn_byyear = new javax.swing.JButton();
        btn_bymonth = new javax.swing.JButton();
        btn_day = new javax.swing.JButton();
        btn_daytoday = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_min = new javax.swing.JLabel();
        lbl_max = new javax.swing.JLabel();
        btn_export = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(30, 57, 50));
        setForeground(new java.awt.Color(242, 240, 232));

        jPanel2.setBackground(new java.awt.Color(139, 177, 116));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 241, 235), 2, true));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 240, 235));
        jLabel1.setText("DOANH THU");

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true));

        tlb_doanhthu.setBackground(new java.awt.Color(97, 139, 74));
        tlb_doanhthu.setForeground(new java.awt.Color(242, 240, 235));
        tlb_doanhthu.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "STT", "Thời gian", "Doanh Thu"
                }));
        jScrollPane1.setViewportView(tlb_doanhthu);

        jPanel4.setBackground(new java.awt.Color(97, 139, 74));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true), "Tiêu chí thống kê",
                javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(242, 240, 235))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(242, 240, 235));
        jLabel7.setText("Từ ngày");

        jLabel8.setForeground(new java.awt.Color(242, 240, 235));
        jLabel8.setText("Đến ngày");

        cbo_year.setForeground(new java.awt.Color(242, 240, 235));
        cbo_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2022", "2021" }));
        cbo_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_yearActionPerformed(evt);
            }
        });

        btn_byyear.setText("Theo Năm");
        btn_byyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_byyearActionPerformed(evt);
            }
        });

        btn_bymonth.setText("Theo Tháng Trong năm");
        btn_bymonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bymonthActionPerformed(evt);
            }
        });

        btn_day.setText("Theo Ngày");
        btn_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dayActionPerformed(evt);
            }
        });

        btn_daytoday.setText("Theo khoảng ngày");
        btn_daytoday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daytodayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_byyear)
                                .addGap(74, 74, 74)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, 161,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_bymonth))
                                .addGap(120, 120, 120)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_day, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 144,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(btn_daytoday)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(datefrom, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 140,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btn_daytoday)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(cbo_year,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(btn_bymonth)
                                                                        .addComponent(btn_byyear)))
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(date,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btn_day))))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21,
                                                        Short.MAX_VALUE)
                                                .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel8)))
                                .addGap(4, 4, 4)
                                .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        jPanel3.setBackground(new java.awt.Color(139, 177, 116));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true));

        lbl_min.setBackground(new java.awt.Color(139, 177, 116));
        lbl_min.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_min.setForeground(new java.awt.Color(242, 240, 235));
        lbl_min.setText("Thấp nhất");

        lbl_max.setBackground(new java.awt.Color(139, 177, 116));
        lbl_max.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_max.setForeground(new java.awt.Color(242, 240, 235));
        lbl_max.setText("Cao nhất");

        btn_export.setBackground(new java.awt.Color(139, 177, 116));
        btn_export.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-excel-20.png"))); // NOI18N
        btn_export.setText("Export To Exel");
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_max, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)
                                .addComponent(lbl_min)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_export)
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_export)
                                        .addComponent(lbl_min)
                                        .addComponent(lbl_max, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(329, 329, 329)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_bymonthActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_bymonthActionPerformed
        // TODO add your handling code here:
        fillbyMonthInYear();
    }// GEN-LAST:event_btn_bymonthActionPerformed

    private void btn_daytodayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_daytodayActionPerformed
        // TODO add your handling code here:
        fillbyDateRange();
    }// GEN-LAST:event_btn_daytodayActionPerformed

    private void btn_dayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_dayActionPerformed
        // TODO add your handling code here:
        fillbyDay();
    }// GEN-LAST:event_btn_dayActionPerformed

    private void btn_byyearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_byyearActionPerformed
        // TODO add your handling code here:
        fillbyYear();
    }// GEN-LAST:event_btn_byyearActionPerformed

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_exportActionPerformed
        // TODO add your handling code here:
        if (Auth.isManager()) {
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
                exportExcel(tlb_doanhthu, f);
                msgBox.alert(this, "Xuất file thành công");
                String maNV = Auth.user.getMaNV();
                String title = "Xuất file excel";
                String content = "Xuất file excel doanh thu";
                String date = java.time.LocalDate.now().toString();
                MailService.sendMail(title, content + "Vào ngày:" + date + "Bởi:" + maNV);

                try {
                    Desktop.getDesktop().open(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }// GEN-LAST:event_btn_exportActionPerformed

    void openchart() {
        ChartJDialog chart = new ChartJDialog(this, true);
        chart.setVisible(true);
    }

    private void btn_chartActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_chartActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_btn_chartActionPerformed

    private void rdo_bymonthItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdo_bymonthItemStateChanged
        // TODO add your handling code here:
    }// GEN-LAST:event_rdo_bymonthItemStateChanged

    private void rdo_dayItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdo_dayItemStateChanged
        // TODO add your handling code here:
    }// GEN-LAST:event_rdo_dayItemStateChanged

    private void rdo_daytodayItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdo_daytodayItemStateChanged
        // TODO add your handling code here:
    }// GEN-LAST:event_rdo_daytodayItemStateChanged

    private void rdo_daytodayActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdo_daytodayActionPerformed
        // TODO add your handling code here:
        fillbyDateRange();
    }// GEN-LAST:event_rdo_daytodayActionPerformed

    private void rdo_byyearItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_rdo_byyearItemStateChanged
        // TODO add your handling code here:
        fillbyYear();
    }// GEN-LAST:event_rdo_byyearItemStateChanged

    private void rdo_dayMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_rdo_dayMouseClicked
        // TODO add your handling code here:
        fillbyDay();
    }// GEN-LAST:event_rdo_dayMouseClicked

    private void cbo_yearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbo_yearActionPerformed
        // TODO add your handling code here:
        // fillbyMonthInYear();
    }// GEN-LAST:event_cbo_yearActionPerformed

    private void rdo_bymonthActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rdo_bymonthActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_rdo_bymonthActionPerformed

    private void rdo_bymonthMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_rdo_bymonthMouseClicked
        // TODO add your handling code here:
        fillbyMonthInYear();
    }// GEN-LAST:event_rdo_bymonthMouseClicked

    // private void rdo_byyearMouseClicked(java.awt.event.MouseEvent evt) {//
    // GEN-FIRST:event_rdo_byyearMouseClicked
    // // TODO add your handling code here:
    // fillbyYear();
    // }// GEN-LAST:event_rdo_byyearMouseClicked

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
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoanhThuJDialog.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoanhThuJDialog dialog = new DoanhThuJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_bymonth;
    private javax.swing.JButton btn_byyear;
    private javax.swing.JButton btn_day;
    private javax.swing.JButton btn_daytoday;
    private javax.swing.JButton btn_export;
    private javax.swing.JComboBox<String> cbo_year;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser datefrom;
    private com.toedter.calendar.JDateChooser dateto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_max;
    private javax.swing.JLabel lbl_min;
    private javax.swing.JTable tlb_doanhthu;
    // End of variables declaration//GEN-END:variables
}
