/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package khungpoject.service;

import khungproject.model.chucvu;
import khungproject.model.nhanvienmodel;

/**
 *
 * @author Hp
 */
public interface Inhanvien {
      public boolean them(nhanvienmodel nv, String ma);
      
      public boolean xoa(String ma);
      
      public boolean update(nhanvienmodel nv,String ma);
      
      public boolean them(chucvu cv);
      
}
