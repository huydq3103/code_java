/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package khungpoject.service;

import java.util.ArrayList;
import khungproject.model.giohangCT;

/**
 *
 * @author Hp
 */
public interface Igiohang {
    public ArrayList<giohangCT> getlist();
    
    public boolean xoa();
    
    public boolean them(giohangCT ghct,String ma); // them khi chua co ma gh
    
    public ArrayList<String> timID();
    
    public boolean them2(giohangCT ghct,String ma); // them khi da co ma gh
    
    public ArrayList<String> timMASP(String ma);
    
    public boolean update(giohangCT ghct,String ma); // update khi gio hang da ton tai sp
}
