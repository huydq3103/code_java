/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.repository;

import java.util.ArrayList;
import java.sql.*;
import khungproject.model.login;
import khungproject.model.khachhang;
import khungproject.model.nhanvienmodel;

/**
 *
 * @author Hp
 */
public class loginRepo {

    DBConnection dbcon;

    public ArrayList<login> listDN(String user, String pass) {
        ArrayList<login> list = new ArrayList<>();
        String sql = "select ma,MatKhau from NhanVien where ma='"
                + user + "' and matkhau='" + pass + "'";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                login lg = new login();
                lg.setPass(rs.getString(2));
                lg.setUser(rs.getString(1));
                list.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean them(khachhang kh) {
    String sql="insert into KhachHang(Ma,Ten,TenDem,Ho,"
            + "NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau,Email) "
            + "values(?,?,?,?,?,?,?,?,?,?,?)";   
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTendem());
            ps.setObject(4, kh.getHo());
            ps.setObject(5, kh.getNgaysinh());
            ps.setObject(6, kh.getSdt());
            ps.setObject(9, kh.getThanhpho());
            ps.setObject(8, kh.getQuocgia());
            ps.setObject(7, kh.getDiachi());
            ps.setObject(10, kh.getMatKhau());
            ps.setObject(11, kh.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<login> listKH(String user, String pass) {
        ArrayList<login> listKH = new ArrayList<>();
        String sql = "select ma,MatKhau from khachhang where"
                + " ma='" + user + "' and matkhau='" + pass + "'";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                login lg = new login();
                lg.setPass(rs.getString(2));
                lg.setUser(rs.getString(1));
                listKH.add(lg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKH;
    }
    
    
    
    public ArrayList<String> listMKNV(String email) {
        ArrayList<String> listNV = new ArrayList<>();
        String sql ="select email from nhanvien where Email ='"+email+"'";
        try ( Connection con = dbcon.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               
                String mk =(rs.getString("email"));
                listNV.add(mk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNV;
    }
    
    
      public ArrayList<String> listMKKH(String email) {
        ArrayList<String> listKH = new ArrayList<>();
        String sql ="select email from khachhang where Email ='"+email+"'";
        try ( Connection con = dbcon.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 String mk =(rs.getString("email"));
                 listKH.add(mk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKH;
    }
    
   

}
