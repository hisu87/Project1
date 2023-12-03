
package group1.entity;

public class SanPham {
    private String maSP;
    private String tenSP;
    private String anh;
    private float gia;
    private String maCT;

    public SanPham() {
    }//////

    public SanPham( String tenSP,int soluong, float gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
    }
     public SanPham( String tenSP,int soluong, String masp) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
    }

    public SanPham(String maSP, String tenSP, String anh, float gia, String maCT) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.anh = anh;
        this.gia = gia;
        this.maCT = maCT;
    }

    // Getter và Setter cho các thuộc tính

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

 
}
