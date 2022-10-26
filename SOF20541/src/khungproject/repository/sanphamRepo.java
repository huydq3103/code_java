/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import khungproject.model.NSX;
import khungproject.model.chitietSP;
import khungproject.model.dongSP;
import khungproject.model.login;
import khungproject.model.mausac;
import khungproject.model.sanPham;
import viewmodel.sanphamViewmodel;

/**
 *
 * @author Hp
 */
public class sanphamRepo {

    DBConnection dbcon;

    public ArrayList<chitietSP> getlistSP() {
        ArrayList<chitietSP> list = new ArrayList<>();
        String sql = "select Ma,Ten,NamBH,MoTa,SoLuongTon,"
                + "GiaNhap,GiaBan,IDSP from  ChiTietSP"
                + " join SanPham on SanPham.Id = ChiTietSP.IdSP";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chitietSP ct = new chitietSP();
                sanPham sp = new sanPham();

                sp.setTen(rs.getString("Ten"));
                sp.setMa(rs.getString("Ma"));
                sp.setId(rs.getString("IDSP"));
                ct.setNamBH(rs.getInt("NamBH"));
                ct.setSp(sp);
                ct.setSp(sp);
                ct.setSp(sp);
                ct.setMoTa(rs.getString(4));
                ct.setSoLuongTon(rs.getInt(5));
                ct.setGiaBan(rs.getInt(7));
                ct.setGiaNHap(rs.getInt(6));

                list.add(ct);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean them(sanPham sp) {
        String sql = "insert into SanPham(Ma,Ten) values(?,?)";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean them(chitietSP ct, String ma, String tenNSX, String tenMAU, String tenDONGSP) {
        String sql = "declare @idNSX varchar(max)\n"
                + "set @idNSX = (select id from NSX where Ten='" + tenNSX + "')\n"
                + "\n"
                + "declare @idDSP varchar(max)\n"
                + "set @idDSP = (select id from DongSP where Ten='" + tenDONGSP + "')\n"
                + "\n"
                + "declare @idMAu varchar(max)\n"
                + "set @idMAu = (select id from MauSac where Ten='" + tenMAU + "')\n"
                + "\n"
                + "declare @idsp varchar(max)\n"
                + "  select @idsp =(select id from SanPham where ma ='" + ma + "')\n"
                + "  insert into ChiTietSP(IdSP,IdNsx,IdMauSac,IdDongSP,NamBH,MoTa,SoLuongTon,GiaNhap,GiaBan)\n"
                + "  values(@idsp,@idNSX,@idMAu,@idDSP,?,?,?,?,?)";
        // b1 : them vao bang san pham trc 
        // b2 : tao 1 bien cho nó bằng thằng id với điều kiện là mã
        // b3: ínert với biến đã tạo ở bước 2 .

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ct.getNamBH());
            ps.setObject(2, ct.getMoTa());
            ps.setObject(3, ct.getSoLuongTon());
            ps.setObject(4, ct.getGiaNHap());
            ps.setObject(5, ct.getGiaBan());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoa(String idSP) {
        String sql = "delete from ChiTietSP  where idsp=? "
                + "delete from SanPham where Id=?";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, idSP);
            ps.setObject(2, idSP);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSP(sanPham sp, String id) {
        String sql = "update SanPham \n"
                + "set Ma = ? , ten =? \n"
                + "where id = ? \n";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, id);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCTSP(chitietSP ctsp, String id, String tenNSX, String MAU, String dongsp) {
        String sql
                = "declare @idnsx varchar(Max)\n"
                + "set @idnsx = (select id from NSX where ten='" + tenNSX + "')\n"
                + "\n"
                + "\n"
                + "declare @idmau varchar(Max)\n"
                + "set @idmau = (select id from MauSac where ten='" + MAU + "')\n"
                + "\n"
                + "\n"
                + "declare @idDSP varchar(Max)\n"
                + "set @idDSP = (select id from DongSP where ten='" + dongsp + "')"
                + "update ChiTietSP \n"
                + "set NamBH=? ,MoTa=? ,SoLuongTon=? ,GiaNhap=? ,GiaBan=?, \n"
                + "IdNsx=@idnsx , IdMauSac=@idmau , IdDongSP =@idDSP \n"
                + "where IdSP =?";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, ctsp.getNamBH());

            ps.setObject(2, ctsp.getMoTa());
            ps.setObject(3, ctsp.getSoLuongTon());
            ps.setObject(4, ctsp.getGiaNHap());
            ps.setObject(5, ctsp.getGiaBan());
            ps.setObject(6, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSLSP(chitietSP ctsp, String ma) {
        String sql = "  \n"
                + "	  declare @idsp varchar(max)\n"
                + "	  set @idsp = (select id from SanPham where Ma ='" + ma + "'  )\n"
                + "\n"
                + " update ChiTietSP set SoLuongTon =? where IdSP = @idsp";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setObject(1, ctsp.getSoLuongTon());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //list danhj sach san pham join nhieu bang
    public ArrayList<sanphamViewmodel> getALL() {
        ArrayList<sanphamViewmodel> list = new ArrayList<>();
        String sql = "select SanPham.id,SanPham.Ma,SanPham.Ten,ChiTietSP.NamBH,ChiTietSP.MoTa,ChiTietSP.SoLuongTon,\n"
                + "ChiTietSP.GiaNhap,ChiTietSP.GiaBan,NSX.Ten,MauSac.Ten,DongSP.Ten\n"
                + "from ChiTietSP join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "join NSX on NSX.Id = ChiTietSP.IdNsx\n"
                + "join MauSac on MauSac.Id = ChiTietSP.IdMauSac\n"
                + "join DongSP on DongSP.Id = ChiTietSP.IdDongSP";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanphamViewmodel sp = new sanphamViewmodel();
                sp.setIdSp(rs.getString(1));
                sp.setTenSP(rs.getString(3));
                sp.setMaSP(rs.getString(2));
                sp.setNamBH(rs.getInt(4));
                sp.setMoTa(rs.getString(5));
                sp.setSoLuongTon(rs.getInt(6));
                sp.setGiaNHap(rs.getDouble(7));
                sp.setGiaBan(rs.getDouble(8));
                sp.setTenNSX(rs.getString(9));
                sp.setMausac(rs.getString(10));
                sp.setTenDONGSP(rs.getString(11));
                list.add(sp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean themNSX(NSX nsx) {
        String sql = "insert into NSX(Ten) values(?)";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, nsx.getTenNSX());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themDONGSP(dongSP Dsp) {
        String sql = "insert into DongSP(Ten) values(?)";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, Dsp.getTenDONGSP());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themMAUSAC(mausac mau) {
        String sql = "insert into MauSac(Ten) values(?)";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, mau.getTenMau());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNSX(NSX nsx, String tenNSX) {
        String sql = "update NSX set Ten=? where Ten =?";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(NSX nsx, String tenNSX) {
        String sql = "update NSX set Ten=? where Ten =?";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> getlistNSX() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select ten from nsx";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getlistMAu() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select ten from mausac";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getlistDONGSP() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select ten from dongSP";

        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<sanphamViewmodel> getListFind(String ten) {
        ArrayList<sanphamViewmodel> list = new ArrayList<>();
        String sql = "select SanPham.id,SanPham.Ma,SanPham.Ten,ChiTietSP.NamBH,ChiTietSP.MoTa,ChiTietSP.SoLuongTon,\n"
                + "ChiTietSP.GiaNhap,ChiTietSP.GiaBan,NSX.Ten,MauSac.Ten,DongSP.Ten\n"
                + "from ChiTietSP join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "join NSX on NSX.Id = ChiTietSP.IdNsx\n"
                + "join MauSac on MauSac.Id = ChiTietSP.IdMauSac\n"
                + "join DongSP on DongSP.Id = ChiTietSP.IdDongSP where SanPham.Ten ='" + ten + "'";
        try ( Connection con = dbcon.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanphamViewmodel sp = new sanphamViewmodel();
                sp.setIdSp(rs.getString(1));
                sp.setTenSP(rs.getString(3));
                sp.setMaSP(rs.getString(2));
                sp.setNamBH(rs.getInt(4));
                sp.setMoTa(rs.getString(5));
                sp.setSoLuongTon(rs.getInt(6));
                sp.setGiaNHap(rs.getDouble(7));
                sp.setGiaBan(rs.getDouble(8));
                sp.setTenNSX(rs.getString(9));
                sp.setMausac(rs.getString(10));
                sp.setTenDONGSP(rs.getString(11));
                list.add(sp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
   

}
