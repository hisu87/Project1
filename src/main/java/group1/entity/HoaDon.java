/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String MaHD;
    private String MaNV;
    private String MaSP;
    private Date NgayTao;
    private double SoLuong;
    private boolean TrangThai;
    private float TongCong;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, String MaSP, Date NgayTao, double SoLuong, boolean TrangThai, float TongCong) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaSP = MaSP;
        this.NgayTao = NgayTao;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
        this.TongCong = TongCong;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }
    
    public double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public float getTongCong() {
        return TongCong;
    }

    public void setTongCong(float TongCong) {
        this.TongCong = TongCong;
    }
}

