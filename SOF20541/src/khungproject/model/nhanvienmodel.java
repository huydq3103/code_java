/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.model;

/**
 *
 * @author Hp
 */
public class nhanvienmodel {

    private String Id;
    private String Ma;
    private String Ten;
    private String TenDem;
    private String Ho;
    private String GioiTinh;
    private String NgaySinh;
    private String DiaChi;
    private String Sdt;
    private String MatKhau;
    private String IdCH;
    private int TrangThai;
    private String email;

    public nhanvienmodel() {
    }

    public nhanvienmodel(String Id, String Ma, String Ten, String TenDem, String Ho, String GioiTinh, String NgaySinh, String DiaChi, String Sdt, String MatKhau, String IdCH, int TrangThai, String email) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.TenDem = TenDem;
        this.Ho = Ho;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.MatKhau = MatKhau;
        this.IdCH = IdCH;
        this.TrangThai = TrangThai;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String TenDem) {
        this.TenDem = TenDem;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getIdCH() {
        return IdCH;
    }

    public void setIdCH(String IdCH) {
        this.IdCH = IdCH;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "nhanvien{" + "Id=" + Id + ", Ma=" + Ma + ", Ten=" + Ten + ", TenDem=" + TenDem + ", Ho=" + Ho + ", GioiTinh=" + GioiTinh + ", NgaySinh=" + NgaySinh + ", DiaChi=" + DiaChi + ", Sdt=" + Sdt + ", MatKhau=" + MatKhau + ", IdCH=" + IdCH + ", TrangThai=" + TrangThai + '}';
    }

    
}
