/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import khungproject.model.chucvu;
import khungproject.model.khachhang;
import khungproject.model.nhanvienmodel;

/**
 *
 * @author Hp
 */
public class nhanvienREPO {

    DBConnection dbcon;

    public boolean them(nhanvienmodel kh,String ma) {
        String sql = "declare @idcv varchar(max)\n"
                + "    set @idcv = (select id from ChucVu where ma='"+ma+"')\n"
                + "   insert into nhanvien(Ma,Ten,TenDem,Ho,gioitinh,\n"
                + "  NgaySinh,Sdt,DiaChi,MatKhau,Email,IdCV) \n"
                + "  values(?,?,?,?,?,?,?,?,?,?,@idcv)";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getTenDem());
            ps.setObject(4, kh.getHo());
            ps.setObject(6, kh.getNgaySinh());
            ps.setObject(7, kh.getSdt());
            ps.setObject(5, kh.getGioiTinh());
            ps.setObject(8, kh.getDiaChi());
            ps.setObject(9, kh.getMatKhau());
            ps.setObject(10, kh.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(String ma) {
        String sql = "delete from NhanVien where Ma ='" + ma + "'"
                +"delete from chucvu where Ma ='" + ma + "'"
                ;
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(nhanvienmodel kh, String ma) {
        String sql = "update NhanVien set Ten=?,TenDem=?,"
                + "ho=?,GioiTinh=?,NgaySinh=?,DiaChi=?,Sdt=?,MatKhau=?,email=? where Ma='" + ma + "'";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getTenDem());
            ps.setObject(3, kh.getHo());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(7, kh.getSdt());
            ps.setObject(4, kh.getGioiTinh());
            ps.setObject(6, kh.getDiaChi());
            ps.setObject(8, kh.getMatKhau());
            ps.setObject(9, kh.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themCV(chucvu cv) {
        String sql = "insert into chucvu(ma,ten) values(?,?)";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, cv.getMa());
            ps.setObject(2, cv.getTen());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
