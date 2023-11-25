package group1.dao;

import group1.entity.NhanVien;
import group1.utils.xJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends CafeDAO<NhanVien, String> {

    public String INSERT_SQL = "INSERT INTO [Nhân Viên](MaNV , MatKhau, Vaitro, TenNV, Tuoi, GioiTinh, SDT, DiaChi, Anh) VALUES(?,?,?,?,?,?,?,?,?)";
    public String UPDATE_SQL = "UPDATE [Nhân Viên] SET MatKhau=? , Vaitro=?, TenNV=?,  Tuoi=?, GioiTinh=?, SDT=?, DiaChi=? WHERE MaNV=?";
    public String DELETE_SQL = "DELETE FROM [Nhân Viên] WHERE MaNV=?";
    public String SELECT_ALL_SQL = "SELECT * FROM [Nhân Viên]";
    public String SELECT_BY_ID_SQL = "SELECT * FROM [Nhân Viên] WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        xJDBC.executeUpdate(INSERT_SQL,
                entity.getMaNV(),
                entity.getHoTen(),
                entity.getMatKhau(),
                entity.getVaitro(),
                entity.getTuoi(),
                entity.getGioiTinh(),
                entity.getSdt(),
                entity.getDiaChi());
    }

    @Override
    public void update(NhanVien entity) {
        xJDBC.executeUpdate(UPDATE_SQL,
                entity.getMatKhau(),
                entity.getVaitro(),
                entity.getHoTen(),
                entity.getTuoi(),
                entity.getGioiTinh(),
                entity.getSdt(),
                entity.getDiaChi(),
                entity.getAnh(),
                entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        xJDBC.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = xJDBC.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setVaitro(rs.getString("VaiTro"));
                entity.setHoTen(rs.getString("TenNV"));
                entity.setTuoi(rs.getInt("Tuoi"));
                entity.setGioiTinh(rs.getString("GioiTinh"));
                entity.setSdt(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setAnh(rs.getString("Anh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
