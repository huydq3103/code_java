/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.model;

/**
 *
 * @author Hp
 */
public class giohang {

    private nhanvienmodel nv;
    private khachhang kh;
    private String Id;
    private String Ma;
    private String NgayTao;
    private String NgayThanhToan;
    private String TenNguoiNhan;
    private String DiaChi;
    private String Sdt;
    private int TinhTrang;

    public giohang() {
    }

    public giohang(nhanvienmodel nv, khachhang kh, String Id, String Ma, String NgayTao, String NgayThanhToan, String TenNguoiNhan, String DiaChi, String Sdt, int TinhTrang) {
        this.nv = nv;
        this.kh = kh;
        this.Id = Id;
        this.Ma = Ma;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.TenNguoiNhan = TenNguoiNhan;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.TinhTrang = TinhTrang;
    }

    public nhanvienmodel getNv() {
        return nv;
    }

    public void setNv(nhanvienmodel nv) {
        this.nv = nv;
    }

    public khachhang getKh() {
        return kh;
    }

    public void setKh(khachhang kh) {
        this.kh = kh;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public String getTenNguoiNhan() {
        return TenNguoiNhan;
    }

    public void setTenNguoiNhan(String TenNguoiNhan) {
        this.TenNguoiNhan = TenNguoiNhan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    public String trangthai(){
        if(TinhTrang==0){
            return "Đang chờ thanh toán";
        }else if(TinhTrang==-1){
            return "Đã hủy";
        }else if(TinhTrang==1){
            return "Đã thanh toán";
        }
        return null;
    }
    
}
