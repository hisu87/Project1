
package group1.entity;

// Minh Thơ
public class CongThuc_NguyenLieu {
    private int maCT;
    private String tenCongThuc;
    private String maNL;
    private String tenNL;
    private int soLuong;
    private String donViDoLuong;

    public CongThuc_NguyenLieu(int maCT, String maNL, int soLuong, String donViDoLuong) {
        this.maCT = maCT;
        this.maNL = maNL;
        this.soLuong = soLuong;
        this.donViDoLuong = donViDoLuong;
    }
    
    

    public CongThuc_NguyenLieu(int maCT, String tenCongThuc, String maNL, String tenNL, int soLuong, String donViDoLuong) {
        this.maCT = maCT;
        this.tenCongThuc = tenCongThuc;
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.soLuong = soLuong;
        this.donViDoLuong = donViDoLuong;
    }

    public CongThuc_NguyenLieu() {
    }

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public String getTenCongThuc() {
        return tenCongThuc;
    }

    public void setTenCongThuc(String tenCongThuc) {
        this.tenCongThuc = tenCongThuc;
    }

    public String getMaNL() {
        return maNL;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViDoLuong() {
        return donViDoLuong;
    }

    public void setDonViDoLuong(String donViDoLuong) {
        this.donViDoLuong = donViDoLuong;
    }
    
    
}
