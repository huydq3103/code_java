/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.repository;

import java.util.ArrayList;
import khungproject.model.giohangCT;
import java.sql.*;
import khungproject.model.chitietSP;
import khungproject.model.giohang;
import khungproject.model.sanPham;

/**
 *
 * @author Hp
 */
public class giohangCTrepo {

    DBConnection dbcon;

    public ArrayList<giohangCT> getlistGHCT() {
        ArrayList<giohangCT> list = new ArrayList<>();
        String sql = "select SanPham.Ma,SanPham.Ten,GioHangChiTiet.SoLuong,DonGia from \n"
                + "ChiTietSP join SanPham on SanPham.Id = ChiTietSP.IdSP\n"
                + "join GioHangChiTiet on GioHangChiTiet.IdChiTietSP = ChiTietSP.Id";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPham sp = new sanPham();
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                chitietSP ctsp = new chitietSP();
                ctsp.setSp(sp);
                ctsp.setSp(sp);
                giohangCT ghCT = new giohangCT();
                ghCT.setChitietSP(ctsp);
                ghCT.setChitietSP(ctsp);
                ghCT.setDonGia(rs.getInt(4));
                ghCT.setSoLuong(rs.getInt(3));
                list.add(ghCT);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean xoa() {
        String sql = "delete GioHangChiTiet\n"
                + "delete from GioHang";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean them(giohangCT ghct, String ma) {
        String sql = "declare @ngay varchar(max)\n"
                + "set @ngay = GETDATE()\n"
                + "insert into GioHang(NgayTao) values(@ngay)\n"
                + "\n"
                + "\n"
                + "   declare @masp varchar(max)\n"
                + "	 set @masp = (select id from SanPham where Ma='" + ma + "')\n"
                + "\n"
                + "	 declare @idctsp varchar(max)\n"
                + "	 set @idctsp = (select id from ChiTietSP where IdSP=@masp)\n"
                + "	  \n"
                + "\n"
                + "declare @giohang varchar(max)\n"
                + "set @giohang = (select Id from GioHang)\n"
                + "insert into GioHangChiTiet(IdGioHang,IdChiTietSP,SoLuong,DonGia) \n"
                + "values(@giohang,@idctsp ,?,?)";
// dau tien tạo proc để tìm idsp và idspct 
        // 2 : thêm values vao gio hang rồi tạo biến chứa id của giỏ hàng
        // 3 : thêm vaò gio hang chi yiet

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ghct.getSoLuong());
            ps.setObject(2, ghct.getDonGia());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean them2(giohangCT ghct, String ma) {
        String sql
                = "   declare @masp varchar(max)\n"
                + "	 set @masp = (select id from SanPham where Ma='" + ma + "')\n"
                + "\n"
                + "	 declare @idctsp varchar(max)\n"
                + "	 set @idctsp = (select id from ChiTietSP where IdSP=@masp)\n"
                + "	  \n"
                + "\n"
                + "declare @giohang varchar(max)\n"
                + "set @giohang = (select Id from GioHang)\n"
                + "insert into GioHangChiTiet(idgiohang,IdChiTietSP,SoLuong,DonGia) \n"
                + "values(@giohang,@idctsp ,?,?)";
// dau tien tạo proc để tìm idsp và idspct 
        // 2 : thêm values vao gio hang rồi tạo biến chứa id của giỏ hàng
        // 3 : thêm vaò gio hang chi yiet

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ghct.getSoLuong());
            ps.setObject(2, ghct.getDonGia());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> timID() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select Id from GioHang";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString("Id");
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> timMASP(String ma) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "declare @masp varchar(max)\n"
                + " set @masp = (select id from SanPham where Ma='" + ma + "')\n"
                + "\n"
                + "select id from ChiTietSP where IdSP=@masp ";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString("id");
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean update(giohangCT ghct, String ma) {
        String sql = "declare @masp varchar(max)\n"
                + "   set @masp = (select id from SanPham where Ma='"+ma+"')\n"
                + "  declare @idctsp varchar(max)\n"
                + " set @idctsp  = (select id from ChiTietSP where IdSP=@masp) \n"
                + "\n"
                + "  update GioHangChiTiet set SoLuong=? \n"
                + "  where IdChiTietSP = @idctsp";
        try ( Connection con = dbcon.getConnection();  
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ghct.getSoLuong());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
   
   

}
