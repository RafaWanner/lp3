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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Winicius
 */
@Entity
@Table(name = "anime")
@NamedQueries({
    @NamedQuery(name = "Anime.findAll", query = "SELECT a FROM Anime a"),
    @NamedQuery(name = "Anime.findByIdAnime", query = "SELECT a FROM Anime a WHERE a.idAnime = :idAnime"),
    @NamedQuery(name = "Anime.findByNomeAnime", query = "SELECT a FROM Anime a WHERE a.nomeAnime = :nomeAnime"),
    @NamedQuery(name = "Anime.findByNota", query = "SELECT a FROM Anime a WHERE a.nota = :nota")})
public class Anime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_anime")
    private Integer idAnime;
    @Column(name = "nome_anime")
    private String nomeAnime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Double nota;
    @JoinTable(name = "genero_has_anime", joinColumns = {
        @JoinColumn(name = "anime_id_anime", referencedColumnName = "id_anime")}, inverseJoinColumns = {
        @JoinColumn(name = "genero_id_genero", referencedColumnName = "id_genero")})
    @ManyToMany
    private Collection<Genero> generoCollection;
    @JoinTable(name = "anime_has_staff", joinColumns = {
        @JoinColumn(name = "anime_id_anime", referencedColumnName = "id_anime")}, inverseJoinColumns = {
        @JoinColumn(name = "staff_id_staff", referencedColumnName = "id_staff")})
    @ManyToMany
    private Collection<Staff> staffCollection;
    @JoinColumn(name = "estudio_id_estudio", referencedColumnName = "id_estudio")
    @ManyToOne(optional = false)
    private Estudio estudioIdEstudio;

    public Anime() {
    }

    public Anime(Integer idAnime) {
        this.idAnime = idAnime;
    }

    public Integer getIdAnime() {
        return idAnime;
    }

    public void setIdAnime(Integer idAnime) {
        this.idAnime = idAnime;
    }

    public String getNomeAnime() {
        return nomeAnime;
    }

    public void setNomeAnime(String nomeAnime) {
        this.nomeAnime = nomeAnime;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Collection<Genero> getGeneroCollection() {
        return generoCollection;
    }

    public void setGeneroCollection(Collection<Genero> generoCollection) {
        this.generoCollection = generoCollection;
    }

    public Collection<Staff> getStaffCollection() {
        return staffCollection;
    }

    public void setStaffCollection(Collection<Staff> staffCollection) {
        this.staffCollection = staffCollection;
    }

    public Estudio getEstudioIdEstudio() {
        return estudioIdEstudio;
    }

    public void setEstudioIdEstudio(Estudio estudioIdEstudio) {
        this.estudioIdEstudio = estudioIdEstudio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnime != null ? idAnime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anime)) {
            return false;
        }
        Anime other = (Anime) object;
        if ((this.idAnime == null && other.idAnime != null) || (this.idAnime != null && !this.idAnime.equals(other.idAnime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idAnime + "-" + nomeAnime + "-" + nota + "-" + estudioIdEstudio;
    }

}
