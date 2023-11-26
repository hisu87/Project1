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

    public List<Object[]> getDoanhThu(Date ngay) {
        String sql = "{call dbo.GetDoanhThuByDate(?)}";
        String[] cols = { "Ngày Tạo", "Doanh Thu" };
        return this.getListOfArray(sql, cols, ngay);
    }
}
