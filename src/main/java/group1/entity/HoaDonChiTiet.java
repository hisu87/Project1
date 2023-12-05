/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

/**
 *
 * @author numpa
 */
public class HoaDonChiTiet {
    String MaHDCT;
    String MaHD;
    String MaSP;
    int SoLuong;
    String TenSP;
    Double TongTien;

    public HoaDonChiTiet() {
    }


    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }

    public HoaDonChiTiet(String MaHDCT, String MaHD, String MaSP, int SoLuong, String TenSP, Double TongTien) {
        this.MaHDCT = MaHDCT;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.TenSP = TenSP;
        this.TongTien = TongTien;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    // public String getMaNV() {
    // return MaNV;
    // }

    // public void setMaNV(String MaNV) {
    // this.MaNV = MaNV;
    // }

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

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    // public int getGiaBan() {
    // return GiaBan;
    // }

    // public void setGiaBan(int GiaBan) {
    // this.GiaBan = GiaBan;
    // }

    // public int getThanhTien() {
    // return ThanhTien;
    // }

    // public void setThanhTien(int ThanhTien) {
    // this.ThanhTien = ThanhTien;
    // }

}
