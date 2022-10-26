/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.model;

/**
 *
 * @author Hp
 */
public class sanPham {

    private String ten;
    private String ma;
    private String id;

    public sanPham() {
    }

    public sanPham(String ten, String ma, String id) {
        this.ten = ten;
        this.ma = ma;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Override
    public String toString() {
        return "sanPham{" + "ten=" + ten + ", ma=" + ma + ", id=" + id + '}';
    }
    
    
}
