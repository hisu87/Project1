package group1.entity;

/**
 *
 * @author numpa
 */
public class NhanVien {
    private String MaNV;
    private String HoTen;
    private String MatKhau;
    private String Vaitro ;
    private int tuoi;
    private String gioiTinh;
    private String sdt;
    private String diaChi;
    private String Anh;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTen, String MatKhau, int tuoi, String gioiTinh, String sdt, String diaChi, String Anh) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.MatKhau = MatKhau;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.Anh = Anh;
    }

    public String getMaNV() {
        return MaNV;
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

    public String getVaitro() {
        return Vaitro;
    }

    public void setVaitro(String Vaitro) {
        this.Vaitro = Vaitro;
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
    public String getAnh(){
        return Anh;
    }
    public void setAnh(String Anh){
        this.Anh = Anh;
    }

    public boolean isVaitro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
