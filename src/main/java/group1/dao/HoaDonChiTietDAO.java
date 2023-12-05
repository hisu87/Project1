/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.dao;

import group1.entity.HoaDonChiTiet;
import group1.utils.xJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author numpa
 */
public class HoaDonChiTietDAO extends CafeDAO<HoaDonChiTiet, String> {

    public String INSERT_SQL = "INSERT INTO [Hóa Đơn]( MaHD,MaNV, NgayTao, TrangThai, TongCong) VALUES(?,?,?,?,?)";
    public String UPDATE_SQL = "UPDATE [Hóa Đơn] SET MaNV=?, NgayTao=?, TrangThai=?, TongCong=? WHERE MaHD=?";
    public String DELETE_SQL = "DELETE FROM [Hóa Đơn] WHERE MaNV=?";
    public String SELECT_ALL_SQL = "SELECT * FROM [Hóa Đơn]";
    public String SELECT_BY_ID_SQL = "SELECT * FROM [Hóa Đơn] WHERE MaNV=?";

    @Override
    public void insert(HoaDonChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonChiTiet selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySQL(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = xJDBC.executeQuery(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHDCT(rs.getString("MaHDCT"));
                entity.setMaHD(rs.getString("MaHD"));
                // entity.setMaNV(rs.getString("MaNV"));
                entity.setMaSP(rs.getString("MaSP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setTenSP(rs.getString("TenSP"));
                // entity.setGiaBan(rs.getInt("GiaBan"));
                // entity.setThanhTien(rs.getInt("ThanhTien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<HoaDonChiTiet> selectByMaHD(String maHD) {
        String SQL = "SELECT * FROM [Hóa Đơn Chi Tiết] WHERE MaHD=?";
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = xJDBC.executeQuery(SQL, maHD);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHDCT(rs.getString("MaHDCT"));
                entity.setMaHD(rs.getString("MaHD"));
                // entity.setMaNV(rs.getString("MaNV"));
                entity.setMaSP(rs.getString("MaSP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setTenSP(rs.getString("TenSP"));
                // entity.setGiaBan(rs.getInt("GiaBan"));
                // entity.setThanhTien(rs.getInt("ThanhTien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
