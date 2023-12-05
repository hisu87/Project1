/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

import java.util.Date;

/**
 *
 * @author numpa
 */
public class HoaDonChiTiet {
    String MaHD;
    String MaNV;
    Date NgayTao;
    String MaHDCT;
    String MaSP;
    int SoLuong;
    String TenSP;
    Double GiaBan;
    Double ThanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHD, String MaNV, Date NgayTao, String MaHDCT, String MaSP, int SoLuong, String TenSP,
            Double GiaBan,
            Double ThanhTien) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
        this.MaHDCT = MaHDCT;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.TenSP = TenSP;
        this.GiaBan = GiaBan;
        this.ThanhTien = ThanhTien;

    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String setMaHD(String MaHD) {
        return this.MaHD = MaHD;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String setTenSP(String TenSP) {
        return this.TenSP = TenSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date ngayTao) {
        NgayTao = ngayTao;
    }

}
