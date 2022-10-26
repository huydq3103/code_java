/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.iplm;

import domainModel.ChiTietSP;
import domainModel.NSX;
import domainModel.SanPham;
import java.util.ArrayList;
import java.util.List;
import repositories.Isanpham;
import repositories.iplm.sanphamRepo;
import service.Isanphamservice;
import viewmodel.sanphamviewmodel;

/**
 *
 * @author Hp
 */
public class sanphamImpl implements Isanphamservice{
       private Isanpham reposp = new sanphamRepo();
    @Override
    public List<ChiTietSP> getlistSp() {
        List<ChiTietSP> list = reposp.gtelistSp();
      ArrayList<viewmodel.sanphamviewmodel> listSp = new ArrayList<>();
//        for (ChiTietSP chiTietSP : list) {
//            sanphamviewmodel sanphamVM = new sanphamviewmodel();
//            
//            sanphamVM.setTenSP(chiTietSP.getSanpham().getTenSP());
//            sanphamVM.setMaSP(chiTietSP.getSanpham().getMaSP());
//            sanphamVM.setNamBH(chiTietSP.getNamBH());
//            sanphamVM.setMoTa(chiTietSP.getMoTa());
//            sanphamVM.setSoLuongTon(chiTietSP.getSoLuongTon());
//            sanphamVM.setGiaBan(chiTietSP.getGiaBan());
//            sanphamVM.setGiaNhap(chiTietSP.getGiaNhap());
//             
//            listSp.add(sanphamVM);
//        }
       
         return list;
        
    }

    @Override
    public boolean themsp(SanPham sp) {
        if(reposp.themSp(sp)){
            return true;
        }
        return false;
    }

    @Override
    public boolean themCTSP(ChiTietSP ctsp) {
        if(reposp.them(ctsp)){
            return true;
        }
          return false;
    }

    @Override
    public List<SanPham> FindId(String Ma) {
        return reposp.findID(Ma);
    }

   


    @Override
    public boolean xoaSP(String maSP) {
        if(reposp.xoaSP(maSP)){
            return true;
        }
        return false;
    }

    @Override
    public boolean xoaCTSP(String idSP) {
        if(reposp.xoaCtSP(idSP)){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(SanPham sp, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean themNSX(NSX nsx) {
        if(reposp.themNSX(nsx)){
            return true;
        }
        return false;
    }

    @Override
    public List<NSX> findIDNSX(String ma) {
        return reposp.findIDNSX(ma);
    }
    
    
    
}
