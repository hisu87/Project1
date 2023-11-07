/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

/**
 *
 * @author numpa
 */
public class NguyenLieu {
    private String MaNL;
    private String TenNL;
    private String DonViTinh;
    private Double SoLuong;
    private Double DonGia;

    public NguyenLieu() {
    }

    public NguyenLieu(String MaNL, String TenNL, Double SoLuong, String DonViTinh, Double DonGia) {
        this.MaNL = MaNL;
        this.TenNL = TenNL;
        this.SoLuong = SoLuong;
        this.DonViTinh = DonViTinh;
        this.DonGia = DonGia;
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

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public Double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Double SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Double getDonGia() {
        return DonGia;
    }

    public void setDonGia(Double DonGia) {
        this.DonGia = DonGia;
    }

}
