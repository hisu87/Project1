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
     private Date NgayTao;
    private boolean TrangThai;
    private float TongCong;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, Date NgayTao, boolean TrangThai, float TongCong) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.NgayTao = NgayTao;
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public boolean isTrangThai() {
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
