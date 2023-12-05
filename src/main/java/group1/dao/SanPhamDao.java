package group1.dao;

import group1.entity.SanPham;
import group1.utils.xJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDao extends CafeDAO<SanPham, String> {

    public String INSERT_SQL = "INSERT INTO (MaSP, TenSP, Anh, Gia, MaCT) VALUES(?,?,?,?,?)";
    public String UPDATE_SQL = "UPDATE SanPham SET TenSP=?, Anh=?, Gia=?, MaCT=? WHERE MaSP=?";
    public String DELETE_SQL = "DELETE FROM SanPham WHERE MaSP=?";
    public String SELECT_ALL_SQL = "SELECT * FROM [Sản Phẩm]";
    public String SELECT_BY_ID_SQL = "SELECT * FROM [Sản Phẩm] WHERE [MaSP]=?";

    @Override
    public void insert(SanPham entity) {
        xJDBC.executeUpdate(INSERT_SQL,
                entity.getMaSP(),
                entity.getTenSP(),
                entity.getAnh(),
                entity.getGia(),
                entity.getMaCT());
    }

    @Override
    public void update(SanPham entity) {
        xJDBC.executeUpdate(UPDATE_SQL,
                entity.getMaSP(),
                entity.getTenSP(),
                entity.getAnh(),
                entity.getGia(),
                entity.getMaCT());
    }

    @Override
    public void delete(String id) {
           xJDBC.executeUpdate(DELETE_SQL,id);
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> list=selectBySQL(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectAll() {
       return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<SanPham> selectBySQL(String sql, Object... args) {
        List<SanPham> list=new ArrayList<>();
        try {
            ResultSet rs=xJDBC.executeQuery(sql, args);
            while(rs.next()){
                SanPham sp=new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setAnh(rs.getString("Anh"));
                sp.setGia(rs.getFloat("Gia"));
                sp.setMaCT(rs.getString("MaCT"));
                list.add(sp);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
    }

    @Override
    public void Xoa(int mact, String manl) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPham> FindById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



 

}
