/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.service.impl;

import java.util.ArrayList;
import khungpoject.service.Igiohang;
import khungproject.model.giohangCT;
import khungproject.repository.giohangCTrepo;

/**
 *
 * @author Hp
 */
public class giohangCTservice implements Igiohang{
      giohangCTrepo repo = new giohangCTrepo();
    @Override
    public ArrayList<giohangCT> getlist() {
        return repo.getlistGHCT();
    }

    @Override
    public boolean xoa() {
        return repo.xoa();
    }

    @Override
    public boolean them(giohangCT ghct,String ma) {
        return repo.them(ghct, ma);
    }

    @Override
    public ArrayList<String> timID() {
       return repo.timID();
    }

    @Override
    public boolean them2(giohangCT ghct, String ma) {
         return repo.them2(ghct, ma);
    }

   

    @Override
    public boolean update(giohangCT ghct, String ma) {
        return repo.update(ghct, ma);
    }

    @Override
    public ArrayList<String> timMASP(String ma) {
        return repo.timMASP(ma);
    }
    
}
