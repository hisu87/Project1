/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package group1.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import group1.dao.ThongKeDAO;
import group1.entity.Model;
import group1.utils.xJDBC;
import raven.chart.ModelChart;

/**
 *
 * @author numpa
 */
public class ChartJDialog extends javax.swing.JDialog {

    ThongKeDAO dao = new ThongKeDAO();

    /**
     * Creates new form JFreeChart
     */
    public ChartJDialog(JFrame jFrame, boolean modal) {
        super(jFrame, modal);
        initComponents();
        setLocationRelativeTo(null);
        addLegend();
        getInDex();
    }

    public ChartJDialog(DoanhThuJDialog doanhThuJDialog, boolean modal) {
    }

    void addLegend() {
        chart.addLegend("Năm", Color.decode("#f7f7f7"), Color.decode("#dedede"));
        chart2021.addLegend("Tháng", Color.decode("#070d2b"), Color.decode("#000312"));
        chart2022.addLegend("Tháng", Color.decode("#182e4d"), Color.decode("#289dbc"));
        chart2023.addLegend("Tháng", Color.decode("#0f1c3a"), Color.decode("#16b2bf"));
    }

    void setData() {
        try {
            List<Model> list = new ArrayList<>();
            String SQL = "select YEAR(NgayTao) as year, SUM(TongCong) as profit from [Hóa Đơn] group by YEAR(NgayTao) order by YEAR(NgayTao) desc";
            ResultSet rs = xJDBC.executeQuery(SQL);
            while (rs.next()) {
                String year = rs.getString("year");
                Double profit = rs.getDouble("profit");
                list.add(new Model(year, profit));
            }
            rs.getStatement().getConnection().close();

            for (int i = list.size() - 1; i >= 0; i--) {
                Model m = list.get(i);
                chart.addData(new ModelChart(m.getYear(), new double[] { m.getProfit() }));
            }
            chart.start();
            System.out.println("Years");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    void setData2021() {
        try {
            List<Model> list = new ArrayList<>();
            String SQL = "select MONTH(NgayTao) as month, sum(TongCong) as profit from [Hóa Đơn] where year(NgayTao) = '2021' GROUP by MONTH(NgayTao) order by MONTH(NgayTao) desc";
            ResultSet rs = xJDBC.executeQuery(SQL);
            while (rs.next()) {
                String month = rs.getString("month");
                Double profit = rs.getDouble("profit");
                list.add(new Model(month, profit));
            }
            rs.getStatement().getConnection().close();

            for (int i = list.size() - 1; i >= 0; i--) {
                Model m = list.get(i);
                chart2021.addData(new ModelChart(m.getYear(), new double[] { m.getProfit() }));
            }
            chart2021.start();
            System.out.println("2021");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    void setData2022() {
        try {
            List<Model> list = new ArrayList<>();
            String SQL = "select MONTH(NgayTao) as month, sum(TongCong) as profit from [Hóa Đơn] where year(NgayTao) = '2022' GROUP by MONTH(NgayTao) order by MONTH(NgayTao) desc";
            ResultSet rs = xJDBC.executeQuery(SQL);
            while (rs.next()) {
                String month = rs.getString("month");
                Double profit = rs.getDouble("profit");
                list.add(new Model(month, profit));
            }
            rs.getStatement().getConnection().close();

            for (int i = list.size() - 1; i >= 0; i--) {
                Model m = list.get(i);
                chart2022.addData(new ModelChart(m.getYear(), new double[] { m.getProfit() }));
            }
            chart2022.start();
            System.out.println("2022");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    void setData2023() {
        try {
            List<Model> list = new ArrayList<>();
            String SQL = "select MONTH(NgayTao) as month, sum(TongCong) as profit from [Hóa Đơn] where year(NgayTao) = '2021' GROUP by MONTH(NgayTao) order by MONTH(NgayTao) desc";
            ResultSet rs = xJDBC.executeQuery(SQL);
            while (rs.next()) {
                String month = rs.getString("month");
                Double profit = rs.getDouble("profit");
                list.add(new Model(month, profit));
            }
            rs.getStatement().getConnection().close();

            for (int i = list.size() - 1; i >= 0; i--) {
                Model m = list.get(i);
                chart2023.addData(new ModelChart(m.getYear(), new double[] { m.getProfit() }));
            }
            chart2023.start();
            System.out.println("2023");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    void getInDex() {
        tab.addChangeListener(e -> {
            int index = 0;
            index = tab.getSelectedIndex();
            switch (index) {
                case 0:
                    chart.clear();
                    setData();
                    break;
                case 1:
                    chart2021.clear();
                    setData2021();
                    break;
                case 2:
                    chart2022.clear();
                    setData2022();
                    break;
                case 3:
                    chart2023.clear();
                    setData2023();
                    break;
                default:
                    chart.clear();
                    setData();
                    break;
            }
        });
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelGradient2 = new raven.panel.PanelGradient();
        jLabel1 = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        pnl1 = new javax.swing.JPanel();
        panelGradient1 = new raven.panel.PanelGradient();
        chart = new raven.chart.CurveLineChart();
        pnl2 = new javax.swing.JPanel();
        panelGradient3 = new raven.panel.PanelGradient();
        chart2021 = new raven.chart.CurveLineChart();
        pnl3 = new javax.swing.JPanel();
        panelGradient4 = new raven.panel.PanelGradient();
        chart2022 = new raven.chart.CurveLineChart();
        pnl4 = new javax.swing.JPanel();
        panelGradient5 = new raven.panel.PanelGradient();
        chart2023 = new raven.chart.CurveLineChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setPreferredSize(new java.awt.Dimension(1300, 744));

        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        panelGradient2.setBackground(new java.awt.Color(255, 58, 74));
        panelGradient2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 240, 235), 2, true), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        panelGradient2.setColorGradient(new java.awt.Color(240, 171, 137));
        panelGradient2.setGradientType(raven.panel.PanelGradient.GradientType.DIAGONAL_2);

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 240, 235));
        jLabel1.setText("DOANH THU ");
        panelGradient2.add(jLabel1);
        jLabel1.setBounds(530, 40, 240, 30);

        tab.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        pnl1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        panelGradient1.setBackground(new java.awt.Color(0, 51, 31));
        panelGradient1.setColorGradient(new java.awt.Color(0, 133, 53));
        panelGradient1.setGradientType(raven.panel.PanelGradient.GradientType.DIAGONAL_2);

        chart.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Qua các năm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        chart.setForeground(new java.awt.Color(0, 0, 0));
        panelGradient1.add(chart);
        chart.setBounds(20, 20, 1250, 520);

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        tab.addTab("Years", pnl1);

        pnl2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        panelGradient3.setBackground(new java.awt.Color(128, 128, 128));
        panelGradient3.setColorGradient(new java.awt.Color(99, 97, 97));

        chart2021.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "2021", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        chart2021.setForeground(new java.awt.Color(0, 0, 0));
        panelGradient3.add(chart2021);
        chart2021.setBounds(20, 20, 1250, 520);

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient3, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient3, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        tab.addTab("2021", pnl2);

        pnl3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        panelGradient4.setBackground(new java.awt.Color(104, 104, 236));
        panelGradient4.setColorGradient(new java.awt.Color(190, 187, 219));
        panelGradient4.setGradientType(raven.panel.PanelGradient.GradientType.DIAGONAL_2);

        chart2022.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "2022"));
        chart2022.setForeground(new java.awt.Color(0, 0, 0));
        panelGradient4.add(chart2022);
        chart2022.setBounds(20, 20, 1250, 520);

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient4, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE)
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient4, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        tab.addTab("2022", pnl3);

        pnl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl4MouseClicked(evt);
            }
        });

        panelGradient5.setBackground(new java.awt.Color(158, 36, 63));
        panelGradient5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        panelGradient5.setColorGradient(new java.awt.Color(243, 197, 207));
        panelGradient5.setGradientType(raven.panel.PanelGradient.GradientType.DIAGONAL_1);

        chart2023.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "2023"));
        chart2023.setForeground(new java.awt.Color(0, 0, 0));
        panelGradient5.add(chart2023);
        chart2023.setBounds(20, 20, 1250, 520);

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient5, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient5, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );

        tab.addTab("2023", pnl4);

        tab.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnl4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnl4MouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_pnl4MouseClicked

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
            java.util.logging.Logger.getLogger(ChartJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChartJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChartJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChartJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChartJDialog dialog = new ChartJDialog(new javax.swing.JFrame(), true);
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
    private raven.chart.CurveLineChart chart;
    private raven.chart.CurveLineChart chart2021;
    private raven.chart.CurveLineChart chart2022;
    private raven.chart.CurveLineChart chart2023;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private raven.panel.PanelGradient panelGradient1;
    private raven.panel.PanelGradient panelGradient2;
    private raven.panel.PanelGradient panelGradient3;
    private raven.panel.PanelGradient panelGradient4;
    private raven.panel.PanelGradient panelGradient5;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
