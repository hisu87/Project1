/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.utils;

import group1.entity.NhanVien;

/**
 *
 * @author numpa
 */

/* Đây là file để xác thực người dùng */
public class Auth {
    public static NhanVien user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        System.out.println(Auth.user.getVaitro().toUpperCase());
        return Auth.isLogin() && Auth.user.getVaitro().toUpperCase().equals("QUẢN LÝ");
    }
}