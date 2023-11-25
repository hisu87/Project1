/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author numpa
 */

/* Đây là file để xử lý ngày tháng */
public class xDate {
    static SimpleDateFormat formater = new SimpleDateFormat();

    /**
     * Chuyển đổi String sang Date
     * 
     * @param date    là String cần chuyển
     * @param pattern là định dạng thời gian
     * @return Date kết quả
     */
    public static Date toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Chuyển đổi từ Date sang String
     * 
     * @param date    là Date cần chuyển đổi
     * @param pattern là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    /**
     * Bổ sung số ngày vào thời gian
     * 
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung váo date
     * @return Date kết quả
     */
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
       // Hàm để lấy ngày tháng năm hiện tại
    public static String getCurrentDate() {
        // Lấy ngày tháng năm hiện tại
        LocalDate currentDate = LocalDate.now();

        // Định dạng ngày tháng năm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Chuyển đối LocalDate thành chuỗi theo định dạng
        return currentDate.format(formatter);
    }
}
