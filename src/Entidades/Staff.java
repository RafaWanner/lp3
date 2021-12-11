/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Winicius
 */
@Entity
@Table(name = "staff")
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByIdStaff", query = "SELECT s FROM Staff s WHERE s.idStaff = :idStaff"),
    @NamedQuery(name = "Staff.findByNomeStaff", query = "SELECT s FROM Staff s WHERE s.nomeStaff = :nomeStaff"),
    @NamedQuery(name = "Staff.findByProfissaoStaff", query = "SELECT s FROM Staff s WHERE s.profissaoStaff = :profissaoStaff")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_staff")
    private Integer idStaff;
    @Column(name = "nome_staff")
    private String nomeStaff;
    @Column(name = "profissao_staff")
    private String profissaoStaff;
    @ManyToMany(mappedBy = "staffCollection")
    private Collection<Anime> animeCollection;

    public Staff() {
    }

    public Staff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public String getNomeStaff() {
        return nomeStaff;
    }

    public void setNomeStaff(String nomeStaff) {
        this.nomeStaff = nomeStaff;
    }

    public String getProfissaoStaff() {
        return profissaoStaff;
    }

    public void setProfissaoStaff(String profissaoStaff) {
        this.profissaoStaff = profissaoStaff;
    }

    public Collection<Anime> getAnimeCollection() {
        return animeCollection;
    }

    public void setAnimeCollection(Collection<Anime> animeCollection) {
        this.animeCollection = animeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStaff != null ? idStaff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.idStaff == null && other.idStaff != null) || (this.idStaff != null && !this.idStaff.equals(other.idStaff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idStaff + "-" + nomeStaff + "-" + profissaoStaff;
    }

}
