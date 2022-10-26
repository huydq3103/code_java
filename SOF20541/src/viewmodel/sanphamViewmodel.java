/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Hp
 */
public class sanphamViewmodel {

    private int namBH;
    private String moTa;
    private int soLuongTon;
    private double giaNHap;
    private double giaBan;
    private String idSp;
    private String tenSP;
    private String maSP;
    private String tenNSX;
    private String mausac;
    private String tenDONGSP;

    public sanphamViewmodel() {
    }

    public sanphamViewmodel(int namBH, String moTa, int soLuongTon, double giaNHap, double giaBan, String idSp, String tenSP, String maSP, String tenNSX, String mausac, String tenDONGSP) {
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNHap = giaNHap;
        this.giaBan = giaBan;
        this.idSp = idSp;
        this.tenSP = tenSP;
        this.maSP = maSP;
        this.tenNSX = tenNSX;
        this.mausac = mausac;
        this.tenDONGSP = tenDONGSP;
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

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getTenDONGSP() {
        return tenDONGSP;
    }

    public void setTenDONGSP(String tenDONGSP) {
        this.tenDONGSP = tenDONGSP;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    
    
}
