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

    public static String dburl = "jdbc:sqlserver://sqlstarbucks.database.windows.net:1433;database=QLStarbucks;";

    public static String username = "hisu";
    public static String password = "Numpad@@2023";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // public static PreparedStatement preparedStatement(String sql, Object... args)
    // throws SQLException {
    // try (Connection conn = DriverManager.getConnection(dburl, username,
    // password)) {
    // PreparedStatement pstmt = null;
    // if (sql.trim().startsWith("{")) {
    // pstmt = conn.prepareCall(sql); // proc
    // } else {
    // pstmt = conn.prepareStatement(sql); // SQL
    // }
    // for (int i = 0; i < args.length; i++) {
    // pstmt.setObject(i + 1, args[i]);
    // }
    // return pstmt;
    // } catch (SQLException e) {
    // throw new RuntimeException(e);
    // }
    // }

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

    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstmt = preparedStatement(sql, args);
            try {
                pstmt.executeUpdate();
            } finally {
                pstmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
