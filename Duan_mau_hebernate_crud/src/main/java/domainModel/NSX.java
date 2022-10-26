/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "NSX")
public class NSX implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private String Id;
    
    @Column(name = "Ten")
    private String Ten;
    
    @Column(name = "Ma")
    private String Ma;
    
    @OneToMany(mappedBy = "NSX",cascade = CascadeType.ALL)
    private Set<ChiTietSP> chiTietSPs ;
    
  

    public NSX() {
    }

    public NSX(String Id, String Ten, String Ma) {
        this.Id = Id;
        this.Ten = Ten;
        this.Ma = Ma;
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

    public Set<ChiTietSP> getChiTietSPs() {
        return chiTietSPs;
    }

    public void setChiTietSPs(Set<ChiTietSP> chiTietSPs) {
        this.chiTietSPs = chiTietSPs;
    }

    @Override
    public String toString() {
        return "NSX{" + "Id=" + Id + ", Ten=" + Ten + ", Ma=" + Ma + ", chiTietSPs=" + chiTietSPs + '}';
    }


  

   
   
    
    
}
