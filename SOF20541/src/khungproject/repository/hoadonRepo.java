/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.repository;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.util.ArrayList;
import khungproject.model.hoadon;
import java.sql.*;
import khungproject.model.hoadonchitiet;
import khungproject.model.nhanvienmodel;

/**
 *
 * @author Hp
 */
public class hoadonRepo {

    DBConnection dbcon;

    public ArrayList<hoadon> getlist() {
        ArrayList<hoadon> list = new ArrayList<>();
        String sql = "select HoaDon.Ma,HoaDon.NgayTao,\n"
                + "NhanVien.Ten,HoaDon.TinhTrang \n"
                + "from NhanVien \n"
                + "join HoaDon\n"
                + "on HoaDon.IdNV \n"
                + "= NhanVien.Id";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhanvienmodel nv = new nhanvienmodel();
                hoadon hd = new hoadon();

                nv.setTen(rs.getString(3));
                hd.setNv(nv);
                hd.setMa(rs.getString("Ma"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<hoadon> listHDDH() { // list hoa don da huy
        ArrayList<hoadon> list = new ArrayList<>();
        String sql = "select HoaDon.Ma,HoaDon.NgayTao,\n"
                + "NhanVien.Ten,HoaDon.TinhTrang \n"
                + "from NhanVien \n"
                + "join HoaDon\n"
                + "on HoaDon.IdNV \n"
                + "= NhanVien.Id  where TinhTrang=-1";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhanvienmodel nv = new nhanvienmodel();
                hoadon hd = new hoadon();

                nv.setTen(rs.getString(3));
                hd.setNv(nv);
                hd.setMa(rs.getString("Ma"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<hoadon> listHDDTT() { // list hoa don da thanh toan
        ArrayList<hoadon> list = new ArrayList<>();
        String sql = "select HoaDon.Ma,HoaDon.NgayTao,\n"
                + "NhanVien.Ten,HoaDon.TinhTrang \n"
                + "from NhanVien \n"
                + "join HoaDon\n"
                + "on HoaDon.IdNV \n"
                + "= NhanVien.Id  where TinhTrang=1";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhanvienmodel nv = new nhanvienmodel();
                hoadon hd = new hoadon();

                nv.setTen(rs.getString(3));
                hd.setNv(nv);
                hd.setMa(rs.getString("Ma"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<hoadon> listHDCTT() { // list hoa don cho thanh toan
        ArrayList<hoadon> list = new ArrayList<>();
        String sql = "select HoaDon.Ma,HoaDon.NgayTao,\n"
                + "NhanVien.Ten,HoaDon.TinhTrang \n"
                + "from NhanVien \n"
                + "join HoaDon\n"
                + "on HoaDon.IdNV \n"
                + "= NhanVien.Id  where TinhTrang=0";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nhanvienmodel nv = new nhanvienmodel();
                hoadon hd = new hoadon();

                nv.setTen(rs.getString(3));
                hd.setNv(nv);
                hd.setMa(rs.getString("Ma"));
                hd.setNgayTao(rs.getString("NgayTao"));
                hd.setTinhTrang(rs.getInt("TinhTrang"));
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean them(hoadon hd, String ten) {
        String sql = "declare @idNV nvarchar(max)\n"
                + " set @idNV = (select id from NhanVien where ten ='" + ten + "')\n"
                + " \n"
                + " insert into HoaDon(IdNV,Ma,NgayTao) values(@idNV,?,?)";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getNgayTao());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    public boolean them(hoadonchitiet hdct, String maHD, String maSP) {
        String sql = "declare @idhoadon varchar(max)\n"
                + "set @idhoadon = (select id from HoaDon where Ma='" + maHD + "')\n"
                + "\n"
                + "declare @idsp varchar(max)\n"
                + "set @idsp = (select id from SanPham where Ma='" + maSP + "')\n"
                + "declare @idCTSP nvarchar(max)\n"
                + "set @idCTSP = (select id from ChiTietSP where IdSP=@idsp)\n"
                + "\n"
                + "insert into HoaDonChiTiet values(@idhoadon,@idCTSP,?,?)";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, hdct.getDonGia());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }

    public boolean updateHD(String ma) {

        String sql = "update hoadon set hoadon.TinhTrang =1 where Ma ='" + ma + "'";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
