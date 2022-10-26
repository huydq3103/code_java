/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.service.impl;

import java.util.ArrayList;
import khungpoject.service.Ihoadon;
import khungproject.model.hoadon;
import khungproject.model.hoadonchitiet;
import khungproject.repository.hoadonRepo;

/**
 *
 * @author Hp
 */
public class hoadonservice implements Ihoadon{
    hoadonRepo repo= new hoadonRepo() ;
    @Override
    public ArrayList<hoadon> getlist() {
         return repo.getlist();
    }

    @Override
    public boolean them(hoadon hd,String ten) {
        return repo.them(hd, ten);
    }

    @Override
    public ArrayList<hoadon> getlistHDDH() {
        return repo.listHDDH();
    }

    @Override
    public ArrayList<hoadon> getlistHDDTT() {
          return repo.listHDDTT();
    }

    @Override
    public ArrayList<hoadon> getlistHDCTT() {
          return repo.listHDCTT();
    }

    @Override
    public boolean saveHDCT(hoadonchitiet hdct, String maHD, String maSP) {
        return repo.them(hdct, maHD, maSP);
    }

    @Override
    public boolean updateHD(String ma) {
        return repo.updateHD(ma);
    }

   
}
