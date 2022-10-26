/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.ChiTietSP;
import domainModel.NSX;
import domainModel.SanPham;
import java.util.List;
import service.iplm.sanphamImpl;

/**
 *
 * @author Hp
 */
public interface Isanphamservice {

    List<ChiTietSP> getlistSp();

    boolean themsp(SanPham sp);

    boolean themCTSP(ChiTietSP ctsp);

    List<SanPham> FindId(String Ma);
    
    boolean xoaSP(String maSP);
    
    boolean xoaCTSP(String idSP);
    
    boolean update(SanPham sp,String id);
    
     boolean themNSX(NSX nsx);

         List<NSX> findIDNSX(String ma);
}
