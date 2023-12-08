/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.dao;

import group1.entity.CongThuc_NguyenLieu;
import group1.utils.xJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CongThucNguyenLieuDAO  extends CafeDAO<CongThuc_NguyenLieu, String>{
    public String INSERT_SQL = "Insert into CT_Nl (mact,manl,soluong,donvidoluong) values(?,?,?,?)";
    public String UPDATE_SQL = "Update CT_NL set  soluong=?, donvidoluong=? where manl=?";
    public String DELETE_SQL = "DELETE FROM CT_NL WHERE MaCT = ? AND MaNL = ?";
    public String SELECT_ALL_SQL = "SELECT CT_NL.MaCT, [Công thức].TenCongThuc, CT_NL.MaNL, [Nguyên Liệu].TenNL, CT_NL.SoLuong, CT_NL.DonViDoLuong "
                    + "FROM CT_NL "
                    + "JOIN [Công thức] ON CT_NL.MaCT = [Công thức].MaCT "
                    + "JOIN [Nguyên Liệu] ON CT_NL.MaNL =[Nguyên Liệu].MaNL"
                    + " order by [Công thức].MaCT";
    public String SELECT_BY_ID_SQL = "SELECT CT_NL.MaCT, [Công thức].TenCongThuc, CT_NL.MaNL, [Nguyên Liệu].TenNL, CT_NL.SoLuong, CT_NL.DonViDoLuong "
                    + "FROM CT_NL "
                    + "JOIN [Công thức] ON CT_NL.MaCT = [Công thức].MaCT "
                    + "JOIN [Nguyên Liệu] ON CT_NL.MaNL =[Nguyên Liệu].MaNL"
                    + " where CT_NL.MaCT  = ?";

    @Override
    public void insert(CongThuc_NguyenLieu entity) {
        xJDBC.executeUpdate(INSERT_SQL,
                entity.getMaCT(),
                entity.getMaNL(),
                entity.getSoLuong(),
                entity.getDonViDoLuong());
}

    @Override
    public void update(CongThuc_NguyenLieu entity) {
        xJDBC.executeUpdate(UPDATE_SQL,
                entity.getSoLuong(),
                entity.getDonViDoLuong(),
                entity.getMaNL());
    }

    @Override
    public void delete(String id) {
        xJDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public CongThuc_NguyenLieu selectById(String id) {
        List<CongThuc_NguyenLieu> list = selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CongThuc_NguyenLieu> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    
    // lấy ra hết bảng công thức nguyên liệu
    @Override
    protected List<CongThuc_NguyenLieu> selectBySQL(String sql, Object... args) {
        List<CongThuc_NguyenLieu> list = new ArrayList<>();
        
        try {
            ResultSet rs = xJDBC.executeQuery(sql, args);
            while (rs.next()) {
                CongThuc_NguyenLieu entity = new CongThuc_NguyenLieu();
                entity.setMaCT(Integer.parseInt(rs.getString("Mact")));
                entity.setMaNL(rs.getString("MaNL"));
                entity.setTenCongThuc(rs.getString("TenCongThuc"));
                entity.setTenNL(rs.getString("TenNl"));
                entity.setSoLuong(Integer.parseInt(rs.getString("Soluong")));
                entity.setDonViDoLuong(rs.getString("DonViDoLuong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Xoa(int mact, String manl) {
        xJDBC.executeUpdate(DELETE_SQL, 
                mact,manl);
    }

    @Override
    public List<CongThuc_NguyenLieu> FindById(String id) {
        List<CongThuc_NguyenLieu> list = selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }  
}
