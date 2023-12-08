/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

/**
 *
 * @author HUY
 */
public class ChiTietDonHang {

    private int MaChiTietDH;
    private String MaHD;
    private String MaSP;
    private String TenSP;
    private int SoLuong;
    private double gia;

    public ChiTietDonHang() {
    }

    public double getTongtien() {
        return gia;
    }

    public void setTongtien(double gia) {
        this.gia = gia;
    }

    
    public ChiTietDonHang( String MaSP, String TenSP, int SoLuong,double gia) {
      
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
    }

    public int getMaChiTietDH() {
        return MaChiTietDH;
    }

    public void setMaChiTietDH(int MaChiTietDH) {
        this.MaChiTietDH = MaChiTietDH;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
   
    

}
