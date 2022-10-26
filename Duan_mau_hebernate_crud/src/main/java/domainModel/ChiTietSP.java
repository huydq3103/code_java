/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private String Id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanpham;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX NSX;
    
    @Column(name = "NamBH")
    private int NamBH;

    @Column(name = "MoTa")
    private String MoTa;

    @Column(name = "SoLuongTon")
    private int SoLuongTon;

    @Column(name = "GiaNhap")
    private double GiaNhap;

    @Column(name = "GiaBan")
    private double GiaBan;

    public ChiTietSP() {
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public ChiTietSP(String Id, SanPham sanpham, NSX NSX, int NamBH, String MoTa, int SoLuongTon, double GiaNhap, double GiaBan) {
        this.Id = Id;
        this.sanpham = sanpham;
        this.NSX = NSX;
        this.NamBH = NamBH;
        this.MoTa = MoTa;
        this.SoLuongTon = SoLuongTon;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
    }

   
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getNamBH() {
        return NamBH;
    }

    public void setNamBH(int NamBH) {
        this.NamBH = NamBH;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public NSX getNSX() {
        return NSX;
    }

    public void setNSX(NSX NSX) {
        this.NSX = NSX;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "Id=" + Id + ", sanpham=" + sanpham + ", NSX=" + NSX + ", NamBH=" + NamBH + ", MoTa=" + MoTa + ", SoLuongTon=" + SoLuongTon + ", GiaNhap=" + GiaNhap + ", GiaBan=" + GiaBan + '}';
    }

    
}
