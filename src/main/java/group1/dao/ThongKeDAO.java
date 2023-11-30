/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import group1.utils.xJDBC;

/**
 *
 * @author numpa
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try (ResultSet rs = xJDBC.executeQuery(sql, args)) {
            List<Object[]> list = new ArrayList<>();
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getDoanhThuYear() {
        String sql = " SELECT \r\n" + //
                "        ROW_NUMBER() OVER (ORDER BY YEAR(NgayTao)) AS [STT], \r\n" + //
                "        YEAR(NgayTao) AS [Thời Gian], \r\n" + //
                "        SUM(TongCong) AS [Doanh Thu]\r\n" + //
                "    FROM \r\n" + //
                "        [Hóa Đơn]\r\n" + //
                "    GROUP BY \r\n" + //
                "        YEAR(NgayTao)\r\n" + //
                "    ORDER BY \r\n" + //
                "        YEAR(NgayTao);";
        String[] cols = { "STT", "Thời gian", "Doanh Thu" };
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThuMonth(int nam) {
        String sql = "{CALL dbo.GetRevenueByMonth(?)}";
        String[] cols = { "STT", "Tháng", "Doanh Thu" };
        return this.getListOfArray(sql, cols, nam);
    }

    public List<Object[]> getDoanhThuDay(Date Ngay) {
        String sql = "{CALL dbo.GetRevenueByDate(?)}";
        String[] cols = { "STT", "Thời Gian", "Doanh Thu" };
        return this.getListOfArray(sql, cols, Ngay);
    }

    public List<Object[]> getDoanhThuDateRange(Date Ngay1, Date Ngay2) {
        String sql = "{CALL dbo.GetRevenueByDateRange(?,?)}";
        String[] cols = { "STT", "Thời Gian", "Doanh Thu" };
        return this.getListOfArray(sql, cols, Ngay1, Ngay2);
    }
}
