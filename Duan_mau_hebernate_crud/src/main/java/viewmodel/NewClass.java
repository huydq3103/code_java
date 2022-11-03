/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainModel.ChiTietSP;
import domainModel.NSX;
import domainModel.SanPham;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repositories.iplm.sanphamRepo;
import service.Isanphamservice;
import service.iplm.sanphamImpl;
import untils.HebernateUntil;

/**
 *
 * @author Hp
 */
public class NewClass {

    public static void main(String[] args) {
        Transaction tran ;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
         tran = session.beginTransaction();
         SanPham sp = new SanPham();
         ChiTietSP ctsp = new ChiTietSP();
          NSX nsx = new NSX();
            
          sp.setMa("v7");
          sp.setTen("s8");
        
          nsx.setMa("ohh");
          nsx.setTen(" long");
          
        ctsp.setGiaBan(1);
        ctsp.setGiaNhap(2);
        ctsp.setMoTa("oke");
        ctsp.setNamBH(1);
        ctsp.setSoLuongTon(108);
        ctsp.setSanpham(sp);
        ctsp.setNSX(nsx);
        nsx.setChiTietSPs(Arrays.asList(ctsp)); 
        sp.setChiTietSPs(Arrays.asList(ctsp));
        // hd : dau tien sẽ thêm cha là sản phẩm
        // bước 2: sẽ lấy toàn bộ sản phẩm vừa thêm truy xuất ngược qua hàm mapby
        // trả về 1 đóio tượng vừa thêm 
        // sau đó ínert id trong list add vào bảng ctsp
        session.persist(nsx);
        session.persist(sp);
            
       tran.commit();
       session.close();
            
// insert nhieu truong 1 luc
        } catch (HibernateError e) {
            e.getMessage();
        }

    }

}
