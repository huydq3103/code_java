/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.model;

/**
 *
 * @author Hp
 */
public class chitietSP {
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private double giaNHap;
    private double giaBan;
    private sanPham sp;

    public chitietSP() {
    }

    public chitietSP(int namBH, String moTa, int soLuongTon, double giaNHap, double giaBan, sanPham sp) {
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNHap = giaNHap;
        this.giaBan = giaBan;
        this.sp = sp;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNHap() {
        return giaNHap;
    }

    public void setGiaNHap(double giaNHap) {
        this.giaNHap = giaNHap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public sanPham getSp() {
        return sp;
    }

    public void setSp(sanPham sp) {
        this.sp = sp;
    }

    @Override
    public String toString() {
        return "chitietSP{" + "namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNHap=" + giaNHap + ", giaBan=" + giaBan + ", sp=" + sp + '}';
    }

   
    
    
}
