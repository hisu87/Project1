/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.dao;

import group1.entity.HoaDon;
import group1.utils.xJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonDAO extends CafeDAO<HoaDon, String> {

    public String INSERT_SQL = "INSERT INTO [Hóa Đơn]( MaHD,MaNV, NgayTao, TrangThai, TongCong) VALUES(?,?,?,?,?)";
    public String UPDATE_SQL = "UPDATE [Hóa Đơn] SET MaNV=?, MaSP=?, NgayTao=?, SoLuong=?, TrangThai=?, TongCong=? WHERE MaHD=?";
    public String DELETE_SQL = "DELETE FROM [Hóa Đơn] WHERE MaNV=?";
    public String SELECT_ALL_SQL = "SELECT * FROM [Hóa Đơn]";
    public String SELECT_BY_ID_SQL = "SELECT * FROM [Hóa Đơn] WHERE MaNV=?";

    @Override
    public void insert(HoaDon entity) {
        xJDBC.executeUpdate(INSERT_SQL,
                entity.getMaHD(),
                entity.getMaNV(),
            
                entity.getNgayTao(),
                
                entity.getTrangThai(),
                entity.getTongCong());
    }

    @Override
    public void update(HoaDon entity) {
        xJDBC.executeUpdate(UPDATE_SQL,
                entity.getMaHD(),
                entity.getMaNV(),
                entity.getMaSP(),
                entity.getNgayTao(),
                entity.getSoLuong(),
                entity.getTrangThai(),
                entity.getTongCong());
    }

    @Override
    public void delete(String id) {
        xJDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public HoaDon selectById(String id) {
        List<HoaDon> list = selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = xJDBC.executeQuery(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                entity.setTongCong(rs.getFloat("TongCong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Integer> selectYear() {
        String SQL = "SELECT DISTINCT year(NgayTao) Year FROM [Hóa Đơn] ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = xJDBC.executeQuery(SQL);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
