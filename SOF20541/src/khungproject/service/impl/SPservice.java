/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.service.impl;

import java.util.ArrayList;
import khungpoject.service.IsanPham;
import khungproject.model.NSX;
import khungproject.model.chitietSP;
import khungproject.model.dongSP;
import khungproject.model.mausac;
import khungproject.model.sanPham;
import khungproject.repository.sanphamRepo;
import viewmodel.sanphamViewmodel;

/**
 *
 * @author Hp
 */
public class SPservice implements IsanPham {

    sanphamRepo repo = new sanphamRepo();

    @Override
    public ArrayList<chitietSP> getlist() {
        return repo.getlistSP();
    }

    @Override
    public boolean themCT(sanPham sp) {
        return repo.them(sp);
    }

    @Override
    public boolean xoa(String idSP) {
        return repo.xoa(idSP);
    }

    @Override
    public boolean updateSP(sanPham sp, String id) {
        return repo.updateSP(sp, id);
    }

    @Override
    public boolean updateSLSP(chitietSP ctsp, String ma) {
        return repo.updateSLSP(ctsp, ma);
    }

    @Override
    public ArrayList<sanphamViewmodel> getALL() {
        return repo.getALL();
    }

    @Override
    public boolean updateNSX(NSX nsx, String ten) {
        return repo.update(nsx, ten);
    }

    @Override
    public boolean them(chitietSP ct, String ma, String tenNSX, String tenMAU, String tenDONGSP) {
        return repo.them(ct, ma, tenNSX, tenMAU, tenDONGSP);
    }

    @Override
    public ArrayList<String> listNSX() {
        return repo.getlistNSX();
    }

    @Override
    public ArrayList<String> listMAU() {
         return repo.getlistMAu();
    }

    @Override
    public ArrayList<String> listDONGSP() {
        return repo.getlistDONGSP();
    }

    @Override
    public boolean updateCTSP(chitietSP ctsp, String id, String tenNSX, String MAU, String dongsp) {
        return repo.updateCTSP(ctsp, id, tenNSX, MAU, dongsp);
    }

    @Override
    public ArrayList<sanphamViewmodel> getListFind(String ten) {
        return repo.getListFind(ten);
    }

}
