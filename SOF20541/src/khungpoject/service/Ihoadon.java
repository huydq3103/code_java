/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package khungpoject.service;

import java.util.ArrayList;
import khungproject.model.hoadon;
import khungproject.model.hoadonchitiet;

/**
 *
 * @author Hp
 */
public interface Ihoadon {

    public ArrayList<hoadon> getlist();

    public boolean them(hoadon hd,String ten);

    public ArrayList<hoadon> getlistHDDH();

    public ArrayList<hoadon> getlistHDDTT();

    public ArrayList<hoadon> getlistHDCTT();
    
    public boolean saveHDCT(hoadonchitiet hdct,String maHD,String maSP); 
    
    public boolean updateHD(String ma);
}
