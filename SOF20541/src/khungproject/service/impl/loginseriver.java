/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package khungproject.service.impl;

import java.util.ArrayList;
import khungpoject.service.IserviceLogin;
import khungproject.model.login;
import khungproject.repository.DBConnection;
import khungproject.repository.loginRepo;
import khungproject.model.khachhang;
import khungproject.model.nhanvienmodel;

/**
 *
 * @author Hp
 */
public class loginseriver implements IserviceLogin {

    loginRepo repo = new loginRepo();

    @Override
    public ArrayList<login> tim(String user, String pass) {
        return repo.listDN(user, pass);
    }

    

    @Override
    public ArrayList<login> tim2(String user, String pass) {
        return repo.listKH(user, pass);
    }

    @Override
    public boolean them(khachhang kh) {
        return repo.them(kh);
    }

    @Override
    public ArrayList<String> timMKNV(String email) {
        return repo.listMKNV(email);
    }

    @Override
    public ArrayList<String> timMKKH(String email) {
        return repo.listMKKH(email);
    }
    

}
