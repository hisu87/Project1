/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xJDBC {
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static String dburl = "jdbc:sqlserver://localhost:1433;trustServerCertificate=true;databaseName=QLStarbucks;";

    public static String username = "sa";
    public static String password = "0807";
    // public static String dburl =
    // "jdbc:sqlserver://localhost:1433;trustServerCertificate=true;databaseName=QLStarbucks;";
    //
    // public static String username = "sa";
    // public static String password = "songlong";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement preparedStatement(String sql, Object... args)
            throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, username, password);
        System.out.println("Connected to the database successfully!"); // Add log message
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = conn.prepareCall(sql); // proc
        } else {
            pstmt = conn.prepareStatement(sql); // SQLP
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                return pstmt.executeQuery();
            } finally {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void executeUpdate(String sql, Object... args) {
//        try {
//            PreparedStatement pstmt = preparedStatement(sql, args);
//            try {
//                pstmt.executeUpdate();
//            } finally {
//                pstmt.getConnection().close();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
     public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                pstmt.executeUpdate();
            } finally {
                pstmt.getConnection().close();
            }
        } catch (SQLException e) {
             if (e.getMessage().contains("Violation of PRIMARY KEY constraint")) {
                // Lỗi: Giá trị trùng khóa chính
                System.out.println("Mã nhân viên đã tồn tại");
                
            } else {
                // Xử lý các lỗi khác
                e.printStackTrace();
            }
    }
        
     }
}
