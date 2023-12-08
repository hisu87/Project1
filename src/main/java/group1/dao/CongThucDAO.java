package group1.dao;

import group1.entity.CongThuc;
import group1.entity.CongThuc_NguyenLieu;
import group1.entity.HoaDon;
import group1.utils.xJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Thơ
public class CongThucDAO extends CafeDAO<CongThuc, String> {

    public String INSERT_SQL = "Insert into [Công thức ] (mact, TenCongThuc) values(?,?)";
    public String UPDATE_SQL = "Update [Công thức ] set  TenCongthuc = ? where mact = ?";
    public String DELETE_SQL = "DELETE FROM [công thức ] WHERE MaCT = ?";
    public String SELECT_ALL_SQL = "select * from [Công thức]";
    public String SELECT_BY_ID_SQL = "SELECT * FROM [Công thức] WHERE Mact=?";

    @Override
    public void insert(CongThuc entity) {
        xJDBC.executeUpdate(INSERT_SQL,
                entity.getMaCT(),
                entity.getTenCT());
    }

    @Override
    public void update(CongThuc entity) {
        xJDBC.executeUpdate(UPDATE_SQL,
                entity.getTenCT(),
                entity.getMaCT());
    }

    @Override
    public void delete(String id) {
        xJDBC.executeUpdate(DELETE_SQL, id);
    }

    // trả về 1 đối tượng
    @Override
    public CongThuc selectById(String id) {
        List<CongThuc> list = selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CongThuc> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<CongThuc> selectBySQL(String sql, Object... args) {
        List<CongThuc> list = new ArrayList<>();

        try {
            ResultSet rs = xJDBC.executeQuery(sql, args);
            while (rs.next()) {
                CongThuc entity = new CongThuc();
                entity.setMaCT(Integer.parseInt(rs.getString("Mact")));
                entity.setTenCT(rs.getString("TenCongthuc"));
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // trả về 1 danh sách
    @Override
    public List<CongThuc> FindById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
