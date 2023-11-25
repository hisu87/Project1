package group1.entity;

/**
 *
 * @author numpa
 */
public class NhanVien {
    private String MaNV;
    private String MatKhau;
    private String Vaitro;
    private String HoTen;
    private int tuoi;
    private String gioiTinh;
    private String sdt;
    private String diaChi;
    private String Anh;

    public String getMaNV() {
        return MaNV;
    }

    public String getVaitro() {
        return Vaitro;
    }

    public void setVaitro(String Vaitro) {
        this.Vaitro = Vaitro;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }
}
