/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.dao;

/**
 *
 * @author HUY
 */

   




import group1.entity.ChiTietDonHang;
import group1.utils.xJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietDonHangDAO extends CafeDAO<ChiTietDonHang, Integer> {

    String INSERT_SQL = "INSERT INTO CHITIETDONHANG (TenSP, SoLuong,MaHD, MaSP) VALUES (?,?, ?, ?)";    
    String UPDATE_SQL = "UPDATE CHITIETDONHANG SET TenSP=?, SoLuong=?, MaHD=?, MaSP=? WHERE MaChiTietDH=?";
    String DELETE_SQL = "DELETE FROM CHITIETDONHANG WHERE MaChiTietDH=?";
    String SELECT_ALL_SQL = "SELECT * FROM CHITIETDONHANG";
    String SELECT_BY_ID_SQL = "SELECT * FROM CHITIETDONHANG WHERE MaChiTietDH=?";

    @Override
    public void insert(ChiTietDonHang entity) {
    
        xJDBC.executeUpdate(INSERT_SQL, entity.getTenSP(), entity.getSoLuong(), entity.getMaHD(), entity.getMaSP());
       
    }

    @Override
    public void update(ChiTietDonHang entity) {
     
        xJDBC.executeUpdate(UPDATE_SQL, entity.getTenSP(), entity.getSoLuong(), entity.getMaHD(), entity.getMaSP(),entity.getMaChiTietDH());
       
    }

    @Override
    public void delete(Integer key) {
       
            xJDBC.executeQuery(DELETE_SQL, key);
        
    }

    @Override
    public List<ChiTietDonHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietDonHang selectById(Integer key) {
        List<ChiTietDonHang> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    protected List<ChiTietDonHang> selectBySql(String sql, Object... args) {
        List<ChiTietDonHang> list = new ArrayList<>();
        try {
            ResultSet rs = xJDBC.executeQuery(sql, args);
            while (rs.next()) {
                ChiTietDonHang entity = new ChiTietDonHang();
                entity.setMaChiTietDH(rs.getInt("MaChiTietDH"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                
                entity.setMaSP(rs.getString("MaSP"));
                entity.setMaHD(rs.getString("MaHD"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ChiTietDonHang> selectByDonHang(String maDH) {
        String sql = "SELECT * FROM CHITIETDONHANG WHERE MaDH=?";
        return this.selectBySql(sql, maDH);
    }

    @Override
    protected List<ChiTietDonHang> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietDonHang> FindById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Xoa(int mact, Integer manl) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
