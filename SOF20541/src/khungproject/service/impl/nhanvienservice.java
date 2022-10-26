/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.service.impl;

import khungpoject.service.Inhanvien;
import khungproject.model.chucvu;
import khungproject.model.nhanvienmodel;
import khungproject.repository.nhanvienREPO;

/**
 *
 * @author Hp
 */
public class nhanvienservice implements Inhanvien{
    nhanvienREPO repo = new nhanvienREPO();
    @Override
    public boolean them(nhanvienmodel nv,String ma) {
        return repo.them(nv,ma);
    }

    @Override
    public boolean xoa(String ma) {
        return repo.xoa(ma);
    }

    @Override
    public boolean update(nhanvienmodel nv, String ma) {
        return repo.update(nv, ma);
    }

    @Override
    public boolean them(chucvu cv) {
        return repo.themCV(cv);
    }
    
}
