/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.model;

/**
 *
 * @author Hp
 */
public class giohangCT {

    private chitietSP chitietSP;
    private giohang giohang;
    private int SoLuong;
    private double DonGia;
    private double DonGiaKhiGiam;

    public giohangCT() {
    }

    public giohangCT(chitietSP chitietSP, giohang giohang, int SoLuong, double DonGia, double DonGiaKhiGiam) {
        this.chitietSP = chitietSP;
        this.giohang = giohang;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.DonGiaKhiGiam = DonGiaKhiGiam;
    }

    public chitietSP getChitietSP() {
        return chitietSP;
    }

    public void setChitietSP(chitietSP chitietSP) {
        this.chitietSP = chitietSP;
    }

    public giohang getGiohang() {
        return giohang;
    }

    public void setGiohang(giohang giohang) {
        this.giohang = giohang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public double getDonGiaKhiGiam() {
        return DonGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(double DonGiaKhiGiam) {
        this.DonGiaKhiGiam = DonGiaKhiGiam;
    }

    @Override
    public String toString() {
        return "giohangCT{" + "chitietSP=" + chitietSP + ", giohang=" + giohang + ", SoLuong=" + SoLuong + ", DonGia=" + DonGia + ", DonGiaKhiGiam=" + DonGiaKhiGiam + '}';
    }
    
    public double tongtien(){
        return DonGia*SoLuong;
    }
    
  
}
