/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package khungpoject.service;

import java.util.ArrayList;
import khungproject.model.login;
import khungproject.model.khachhang;
import khungproject.model.nhanvienmodel;

/**
 *
 * @author Hp
 */
public interface IserviceLogin {

    public ArrayList<login> tim(String user, String pass);

    public ArrayList<login> tim2(String user, String pass);

    public boolean them(khachhang kh);

    public ArrayList<String> timMKNV(String email);

    public ArrayList<String> timMKKH(String email);
}
