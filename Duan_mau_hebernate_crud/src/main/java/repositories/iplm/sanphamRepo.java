/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.iplm;

import domainModel.ChiTietSP;
import domainModel.NSX;
import domainModel.SanPham;
import java.util.List;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import repositories.Isanpham;
import untils.HebernateUntil;
import viewmodel.sanphamviewmodel;

/**
 *
 * @author Hp
 */
public class sanphamRepo implements Isanpham {

    @Override
    public List<ChiTietSP> gtelistSp() {
        List<ChiTietSP> listSp = null;

        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {

            Query query = session.createQuery("FROM ChiTietSP ");

            listSp = (List<ChiTietSP>) query.list();

            session.close();
        } catch (HibernateError e) {
            e.getMessage();
        }

        return listSp;
    }

    @Override
    public boolean them(ChiTietSP ctsp) {
        Transaction tran = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            tran = session.beginTransaction();
            session.save(ctsp);
            tran.commit();
            session.close();
            return true;
        } catch (HibernateError e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean themSp(SanPham sp) {
        Transaction tran = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {

            tran = session.beginTransaction();
            session.save(sp);

            tran.commit();
            session.close();

            return true;
        } catch (HibernateError e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public List<SanPham> findID(String ma) {
        List<SanPham> listID = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            Query query = session.createQuery("from SanPham where Ma='" + ma + "'");

            listID = query.getResultList();

            session.close();

        } catch (HibernateError e) {
            e.getMessage();
        }
        return listID;

    }

    @Override
    public List<NSX> findIDNSX(String ma) {
        List<NSX> listID = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            Query query = session.createQuery("from NSX where Ma='" + ma + "'");

            listID = query.getResultList();

            session.close();

        } catch (HibernateError e) {
            e.getMessage();
        }
        return listID;

    }

    @Override
    public boolean xoaSP(String Ma) {
        Transaction tran = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            tran = session.beginTransaction();
            Query query = session.createQuery("delete from SanPham where Ma = :Ma");
            query.setParameter("Ma", Ma);
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;

        } catch (HibernateError e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean xoaCtSP(String IdSP) {
        Transaction tran = null;

        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            tran = session.beginTransaction();

            Query query = session.createQuery("delete ChiTietSP where IdSP = :IdSP");
            query.setParameter("IdSP", IdSP);
//            int result = 
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;

        } catch (HibernateError e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean update(SanPham sp, String id) {
        Transaction tran = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            tran = session.beginTransaction();
            String sql = "update SanPham \n"
                    + "set ten = :ten \n"
                    + "where id = :id \n";
            Query query = session.createQuery(sql);
            query.setParameter("ten", sp.getTen());
            query.setParameter("id", id);
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;

        } catch (HibernateError e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean updateCTSP(ChiTietSP ctsp, String idsp) {
        Transaction tran = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            tran = session.beginTransaction();
            String sql = "update ChiTietSP \n"
                    + " set NamBH= :NamBH ,MoTa= :MoTa ,SoLuongTon= :SoLuongTon"
                    + " ,GiaNhap= :GiaNhap ,GiaBan= :GiaBan \n"
                    + "   where IdSP = :IdSP";
            Query query = session.createQuery(sql);
            query.setParameter("NamBH", ctsp.getNamBH());
            query.setParameter("MoTa", ctsp.getMoTa());
            query.setParameter("SoLuongTon", ctsp.getSoLuongTon());
            query.setParameter("GiaNhap", ctsp.getGiaNhap());
            query.setParameter("GiaBan", ctsp.getGiaBan());
            query.setParameter("IdSP", idsp); // giá trị đầu là biến , giá trị 2 là set dữ liệu
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;

        } catch (HibernateError e) {
            e.getMessage();
        }
        return false;
    }

    @Override
    public boolean themNSX(NSX nsx) {
        Transaction tran = null;
        try ( Session session = HebernateUntil.getsSessionFactory().openSession();) {
            tran = session.beginTransaction();
            session.save(nsx);
            tran.commit();
            session.close();
            return true;

        } catch (HibernateError e) {
            e.getMessage();
        }
        return false;
    }

    public static void main(String[] args) {
        sanphamRepo sp = new sanphamRepo();
        String ten = "wc";
        String ma = "fc";
//        List<SanPham> listSp = sp.findID(ma);
//        String id = listSp.get(0).getId();
        SanPham sp1 = new SanPham();

        sp1.setMa(ma);
        sp1.setTen(ten);
        sp.themSp(sp1);

        NSX nsx = new NSX();
        nsx.setMa("h22h");
        nsx.setTen("okde");
        sp.themNSX(nsx);

        List<SanPham> list = sp.findID(ma);
        String idsp = list.get(0).getId();
        List<NSX> listNSX = sp.findIDNSX("h22h");
        String idNSX = listNSX.get(0).getId();
        
       
        ChiTietSP ctsp = new ChiTietSP();
//
        SanPham sp2 = new SanPham();
        NSX nsx2 = new NSX();
//        
        
        
        sp2.setId(idsp);
        nsx2.setId(idNSX);
        
        ctsp.setGiaBan(1);
        ctsp.setGiaNhap(2);
        ctsp.setMoTa("oke");
        ctsp.setNamBH(1);
        ctsp.setSoLuongTon(10);
        
        ctsp.setSanpham(sp2);
        ctsp.setNSX(nsx2);
        sp.them(ctsp);
    }
}
