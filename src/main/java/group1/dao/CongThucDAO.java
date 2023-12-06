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
public class CongThucDAO {

    public static Connection getConnection() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
       String url = "jdbc:sqlserver://localhost:1433;trustServerCertificate=true;databaseName=QLStarbucks;";

        String username = "sa";
        String password = "0807";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Success! ");
        } catch (SQLException e) {
            System.out.println("connection fail !");
            e.printStackTrace();
        }
        return connection;
    }

//    public static  String selectAll_sql = "Select CT_Nl.MaCT, [Công thức].TenCongThuc, CT_NL.MaNL,[Nguyên Liệu].TenNL, CT_NL.SoLuong, CT_NL.DonViDoLuong"
//            + "From CT_NL" + 
//            "Join [Công thức] on CT_NL.MaCT = [Công thức].MaCT" +
//            "Join [Nguyên Liệu] on CT_NL.MaNL = [Nguyên Liệu].MaNL";
//    
    public static List<CongThuc_NguyenLieu> getCongThucNguyenLieu() {
        List<CongThuc_NguyenLieu> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql = "SELECT CT_NL.MaCT, [Công thức].TenCongThuc, CT_NL.MaNL, [Nguyên Liệu].TenNL, CT_NL.SoLuong, CT_NL.DonViDoLuong "
                    + "FROM CT_NL "
                    + "JOIN [Công thức] ON CT_NL.MaCT = [Công thức].MaCT "
                    + "JOIN [Nguyên Liệu] ON CT_NL.MaNL =[Nguyên Liệu].MaNL"
                    + " order by [Công thức].MaCT";

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                CongThuc_NguyenLieu entity = new CongThuc_NguyenLieu();
                entity.setMaCT(rs.getInt("MaCT"));
                entity.setTenCongThuc(rs.getString("TenCongThuc"));
                entity.setMaNL(rs.getString("MaNL"));
                entity.setTenNL(rs.getString("TenNL"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setDonViDoLuong(rs.getString("DonViDoLuong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert(CongThuc_NguyenLieu ct) throws SQLException {
        // truyền vào một đối tượng kiểu congthuc 
        // Tạo một hàm trả về đối tượng kiểu cong thuc  sau đó truyền tham số vào hàm insert
        Connection conn = getConnection();
        String sql = ("Insert into CT_Nl (mact,manl,soluong,donvidoluong) values(?,?,?,?)");

        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, ct.getMaCT());
        stm.setString(2, ct.getMaNL());
        stm.setInt(3, ct.getSoLuong());
        stm.setString(4, ct.getDonViDoLuong());
        int rowsAffected = stm.executeUpdate();
        stm.close();
        conn.close();

    }

    public static List<CongThuc_NguyenLieu> FindByid(String mact, String tenct) throws SQLException {

        List<CongThuc_NguyenLieu> list = new ArrayList<>();
        Connection conn = getConnection();
        String sql = "SELECT CT_NL.MaCT, [Công thức].TenCongThuc, CT_NL.MaNL, [Nguyên Liệu].TenNL, CT_NL.SoLuong, CT_NL.DonViDoLuong "
                + "FROM CT_NL "
                + "JOIN [Công thức] ON CT_NL.MaCT = [Công thức].MaCT "
                + "JOIN [Nguyên Liệu] ON CT_NL.MaNL =[Nguyên Liệu].MaNL"
                + " where  [Công thức].MaCT = ? or [Công thức].TenCongThuc = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, mact); // Chỉ số của tham số bắt đầu từ 1
        pstm.setString(2, tenct);
        
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            int Mact = rs.getInt("mact");
            String Tenct = rs.getString("tenCongThuc");
            String manl = rs.getString("manl");
            String tennl = rs.getString("tennl");
            int soluong = rs.getInt("soluong");
            String donvi = rs.getString("DonviDoluong");

            CongThuc_NguyenLieu congthuc = new CongThuc_NguyenLieu(Mact, tenct, manl, tennl, soluong, donvi);
            list.add(congthuc);
        }
        // Đóng tài nguyên
        rs.close();
        pstm.close();
        conn.close();
        return list;
    }
    
    public static void delete(CongThuc_NguyenLieu ct) throws SQLException {
        Connection conn = getConnection();

        String sql = "DELETE FROM CT_NL WHERE MaCT = ? AND MaNL = ?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setInt(1, ct.getMaCT());
        stm.setString (2,ct.getMaNL());
        // trả về số hàng dữ liệu bị ảnh hưởng sau khi thực hiện truy vấn 
        int rowsAffected = stm.executeUpdate();

        // đóng kết nối 
        stm.close();
        conn.close();

    }
    
    public static void update(CongThuc_NguyenLieu ct) throws SQLException {
        Connection conn = getConnection();

        String sql = ("Update CT_NL set  soluong=?, donvidoluong=? where manl=?");
        PreparedStatement stm = conn.prepareStatement(sql);
      ;
        
        stm.setInt(1,ct.getSoLuong());
        stm.setString(2,ct.getDonViDoLuong());
        stm.setString(3,ct.getMaNL());
        // trả về số hàng dữ liệu bị ảnh hưởng sau khi thực hiện truy vấn 
        int rowsAffected = stm.executeUpdate();
        // đóng kết nối 
        stm.close();
        conn.close();
    }
    
     public static List<CongThuc> getCongThuc() {
        List<CongThuc> list = new ArrayList<>();
        try {
            Connection conn = getConnection();
            String sql ="select * from [Công thức]";

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                CongThuc entity = new CongThuc();
                entity.setMaCT(rs.getInt("MaCT"));
                entity.setTenCT(rs.getString("TenCongThuc"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
