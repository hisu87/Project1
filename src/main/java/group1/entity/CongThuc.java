/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

/**
 *
 * @author numpa
 */
public class CongThuc {
    private String MaSP;
    private String MaNL;
    private String TenNL;
    private double SoLuong;

    public CongThuc() {
    }

    public CongThuc(String MaSP, String MaNL, String TenNL, double SoLuong) {
        this.MaSP = MaSP;
        this.MaNL = MaNL;
        this.TenNL = TenNL;
        this.SoLuong = SoLuong;
    }

    
    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaNL() {
        return MaNL;
    }

    public void setMaNL(String MaNL) {
        this.MaNL = MaNL;
    }

    public String getTenNL() {
        return TenNL;
    }

    public void setTenNL(String TenNL) {
        this.TenNL = TenNL;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
