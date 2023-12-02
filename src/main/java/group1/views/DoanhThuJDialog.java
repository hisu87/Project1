/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

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
import java.util.HashSet;

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlb_doanhthu = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        rdo_byyear = new javax.swing.JRadioButton();
        rdo_bymonth = new javax.swing.JRadioButton();
        rdo_day = new javax.swing.JRadioButton();
        rdo_daytoday = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbo_year = new javax.swing.JComboBox<>();
        date = new com.toedter.calendar.JDateChooser();
        datefrom = new com.toedter.calendar.JDateChooser();
        dateto = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btn_exel = new javax.swing.JToggleButton();
        lbl_min = new javax.swing.JLabel();
        lbl_max = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(30, 57, 50));
        setForeground(new java.awt.Color(242, 240, 232));

        jPanel2.setBackground(new java.awt.Color(0, 117, 73));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 241, 235), 2, true));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 240, 235));
        jLabel1.setText("DOANH THU");

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true));

        tlb_doanhthu.setBackground(new java.awt.Color(16, 59, 41));
        tlb_doanhthu.setForeground(new java.awt.Color(242, 240, 235));
        tlb_doanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Thời gian", "Doanh Thu"
            }
        ));
        jScrollPane1.setViewportView(tlb_doanhthu);
        if (tlb_doanhthu.getColumnModel().getColumnCount() > 0) {
            tlb_doanhthu.getColumnModel().getColumn(0).setPreferredWidth(50);
            tlb_doanhthu.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel4.setBackground(new java.awt.Color(0, 98, 59));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true), "Tiêu chí thống kê", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(242, 240, 235))); // NOI18N

        rdo_byyear.setForeground(new java.awt.Color(242, 240, 235));
        rdo_byyear.setText("Theo Năm");
        rdo_byyear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdo_byyearItemStateChanged(evt);
            }
        });

        rdo_bymonth.setForeground(new java.awt.Color(242, 240, 235));
        rdo_bymonth.setText("Theo Tháng trong năm");
        rdo_bymonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdo_bymonthItemStateChanged(evt);
            }
        });
        rdo_bymonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdo_bymonthMouseClicked(evt);
            }
        });
        rdo_bymonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_bymonthActionPerformed(evt);
            }
        });

        rdo_day.setForeground(new java.awt.Color(242, 240, 235));
        rdo_day.setText("Theo Ngày");
        rdo_day.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdo_dayItemStateChanged(evt);
            }
        });
        rdo_day.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdo_dayMouseClicked(evt);
            }
        });

        rdo_daytoday.setForeground(new java.awt.Color(242, 240, 235));
        rdo_daytoday.setText("Theo khoảng ngày");
        rdo_daytoday.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdo_daytodayItemStateChanged(evt);
            }
        });
        rdo_daytoday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_daytodayActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(rdo_byyear)
                        .addGap(112, 112, 112)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdo_bymonth))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdo_day, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(rdo_daytoday)
                                .addGap(108, 108, 108)
                                .addComponent(jLabel8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdo_day)
                            .addComponent(rdo_bymonth)
                            .addComponent(rdo_byyear)
                            .addComponent(rdo_daytoday))))
                .addGap(4, 4, 4)
                .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 117, 73));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true));

        btn_exel.setBackground(new java.awt.Color(28, 86, 29));
        btn_exel.setForeground(new java.awt.Color(242, 240, 235));
        btn_exel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-excel-20.png"))); // NOI18N
        btn_exel.setText("Exel");

        lbl_min.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_min.setForeground(new java.awt.Color(242, 240, 235));
        lbl_min.setText("Thấp nhất");

        lbl_max.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_max.setForeground(new java.awt.Color(242, 240, 235));
        lbl_max.setText("Cao nhất");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbl_max)
                .addGap(117, 117, 117)
                .addComponent(lbl_min)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exel)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_exel)
                    .addComponent(lbl_min)
                    .addComponent(lbl_max))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(422, 422, 422))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JToggleButton btn_exel;
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
    private javax.swing.JRadioButton rdo_bymonth;
    private javax.swing.JRadioButton rdo_byyear;
    private javax.swing.JRadioButton rdo_day;
    private javax.swing.JRadioButton rdo_daytoday;
    private javax.swing.JTable tlb_doanhthu;
    // End of variables declaration//GEN-END:variables
}
