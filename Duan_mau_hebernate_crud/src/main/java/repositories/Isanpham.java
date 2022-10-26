/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import domainModel.ChiTietSP;
import domainModel.NSX;
import domainModel.SanPham;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface Isanpham {

    List<ChiTietSP> gtelistSp();

    boolean them(ChiTietSP ctsp);

    boolean themNSX(NSX nsx);

    boolean themSp(SanPham sp);

    boolean xoaSP(String Ma);

    boolean xoaCtSP(String IdSP);

    boolean update(SanPham sp, String id);

    boolean updateCTSP(ChiTietSP ctsp, String idsp);

    List<SanPham> findID(String ma);

    List<NSX> findIDNSX(String ma);

}
