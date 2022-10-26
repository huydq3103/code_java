/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package khungpoject.service;

import java.util.ArrayList;
import khungproject.model.NSX;
import khungproject.model.chitietSP;
import khungproject.model.dongSP;
import khungproject.model.mausac;
import khungproject.model.sanPham;
import viewmodel.sanphamViewmodel;

/**
 *
 * @author Hp
 */
public interface IsanPham {

    public ArrayList<chitietSP> getlist();

    public boolean them(chitietSP ct, String ma, String tenNSX, String tenMAU, String tenDONGSP);

    public boolean themCT(sanPham sp);

    public boolean xoa(String idSP);

    public boolean updateSP(sanPham sp, String id);

    public boolean updateCTSP(chitietSP ctsp, String id, String tenNSX, String MAU, String dongsp);

    public boolean updateSLSP(chitietSP ctsp, String ma);

    public ArrayList<sanphamViewmodel> getALL();

    public boolean updateNSX(NSX nsx, String ten);

    public ArrayList<String> listNSX();

    public ArrayList<String> listMAU();

    public ArrayList<String> listDONGSP();

    public ArrayList<sanphamViewmodel> getListFind(String ten);

}
