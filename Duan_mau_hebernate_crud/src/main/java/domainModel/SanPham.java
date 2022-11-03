/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.id.UUIDGenerationStrategy;
import org.hibernate.type.UUIDBinaryType;

@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {

    @Id

    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private String Id;

    @Column(name = "Ten")
    private String Ten;

    @Column(name = "Ma")
    private String Ma;

    @OneToMany(mappedBy = "sanpham", cascade = CascadeType.PERSIST)
    private List<ChiTietSP> chiTietSPs;

    
    public SanPham() {
    }

 


  
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public SanPham(String Id, String Ten, String Ma, List<ChiTietSP> chiTietSPs) {
        this.Id = Id;
        this.Ten = Ten;
        this.Ma = Ma;
        this.chiTietSPs = chiTietSPs;
    }

    public List<ChiTietSP> getChiTietSPs() {
        return chiTietSPs;
    }

    public void setChiTietSPs(List<ChiTietSP> chiTietSPs) {
        this.chiTietSPs = chiTietSPs;
    }

   
    @Override
    public String toString() {
        return "SanPham{" + "Id=" + Id + ", Ten=" + Ten + ", Ma=" + Ma + ", chiTietSPs=" + chiTietSPs + '}';
    }

   

}
