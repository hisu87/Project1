/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.dao;

import group1.entity.NguyenLieu;
import group1.utils.xJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author numpa
 */
public class NguyenLieuDAO extends CafeDAO<NguyenLieu, String> {

    public String INSERT_SQL = "INSERT INTO NguyenLieu(MaNL, TenNL, SoLuong, DonViTinh, DonGia) VALUES(?,?,?,?,?)";
    public String UPDATE_SQL = "UPDATE NguyenLieu SET TenNL=?, SoLuong=?, DonViTinh=?, DonGia=? WHERE MaNL=?";
    public String DELETE_SQL = "DELETE FROM NguyenLieu WHERE MaNV=?";
    public String SELECT_ALL_SQL = "SELECT * FROM NguyenLieu";
    public String SELECT_BY_ID_SQL = "SELECT * FROM NguyenLieu WHERE MaNL=?";

    @Override
    public void insert(NguyenLieu entity) {
        xJDBC.executeUpdate(INSERT_SQL,
                entity.getMaNL(),
                entity.getTenNL(),
                entity.getSoLuong(),
                entity.getDonViTinh(),
                entity.getDonGia());
    }

    @Override
    public void update(NguyenLieu entity) {
        xJDBC.executeUpdate(UPDATE_SQL,
                entity.getTenNL(),
                entity.getSoLuong(),
                entity.getDonViTinh(),
                entity.getDonGia(),
                entity.getMaNL());
    }

    @Override
    public void delete(String id) {
        xJDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public NguyenLieu selectById(String id) {
        List<NguyenLieu> list = selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguyenLieu> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<NguyenLieu> selectBySQL(String sql, Object... args) {
        List<NguyenLieu> list = new ArrayList<>();
        try {
            ResultSet rs = xJDBC.executeQuery(sql, args);
            while (rs.next()) {
                NguyenLieu entity = new NguyenLieu();
                entity.setMaNL(rs.getString("MaNL"));
                entity.setTenNL(rs.getString("TenNL"));
                entity.setSoLuong(rs.getDouble("SoLuong"));
                entity.setDonViTinh(rs.getString("DonViTinh"));
                entity.setDonGia(rs.getDouble("DonGia"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
