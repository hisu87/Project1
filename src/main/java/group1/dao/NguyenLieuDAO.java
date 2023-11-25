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

    public String INSERT_SQL = "INSERT INTO [Nguyên Liệu](MaNL, TenNL, SoLuongCon, GiaNL, DonViDoLuong) VALUES(?,?,?,?,?)";
    public String UPDATE_SQL = "UPDATE [Nguyên Liệu] SET TenNL=?, SoLuongCon=? , GiaNL=?, DonViDoLuong=? WHERE MaNL=?";
    public String DELETE_SQL = "DELETE FROM [Nguyên Liệu] WHERE MaNL=?";
    public String SELECT_ALL_SQL = "SELECT * FROM [Nguyên Liệu]";
    public String SELECT_BY_ID_SQL = "SELECT * FROM [Nguyên Liệu] WHERE MaNL=?";

    public List<NguyenLieu> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM [Nguyên Liệu] WHERE TenNL LIKE ?";
        return this.selectBySQL(sql, "%" + keyword + "%");
    }

    @Override
    public void insert(NguyenLieu entity) {
        xJDBC.executeUpdate(INSERT_SQL, entity.getMaNL(), entity.getTenNL(), entity.getSoLuongCon(), entity.getGiaNL(),
                entity.getDonViDoLuong());
    }

    @Override
    public void update(NguyenLieu entity) {
        xJDBC.executeUpdate(UPDATE_SQL, entity.getTenNL(), entity.getSoLuongCon(), entity.getGiaNL(),
                entity.getDonViDoLuong(), entity.getMaNL());
    }

    @Override
    public void delete(String id) {
        xJDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public NguyenLieu selectById(String id) {
        List<NguyenLieu> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
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
                entity.setSoLuongCon(rs.getFloat("SoLuongCon"));
                entity.setGiaNL(rs.getFloat("GiaNL"));
                entity.setDonViDoLuong(rs.getString("DonViDoLuong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }

}
