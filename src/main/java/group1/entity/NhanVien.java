/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group1.entity;

/**
 *
 * @author numpa
 */
public class NhanVien {
    private String MaNV;
    private String MaHoTen;
    private String MaMatKhau;
    private Boolean Vaitro;

    public NhanVien(String MaNV, String MaHoTen, String MaMatKhau, Boolean Vaitro) {
        this.MaNV = MaNV;
        this.MaHoTen = MaHoTen;
        this.MaMatKhau = MaMatKhau;
        this.Vaitro = Vaitro;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaHoTen() {
        return MaHoTen;
    }

    public void setMaHoTen(String MaHoTen) {
        this.MaHoTen = MaHoTen;
    }

    public String getMaMatKhau() {
        return MaMatKhau;
    }

    public void setMaMatKhau(String MaMatKhau) {
        this.MaMatKhau = MaMatKhau;
    }

    public Boolean getVaitro() {
        return Vaitro;
    }

    public void setVaitro(Boolean Vaitro) {
        this.Vaitro = Vaitro;
    }
    
    
    
}
