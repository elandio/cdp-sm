/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ivc.cdp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author KENIARP
 */
@Entity
@Table(name = "parentes", catalog = "visitas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Parentes.findAll", query = "SELECT p FROM Parentes p"),
    @NamedQuery(name = "Parentes.findByCodItem", query = "SELECT p FROM Parentes p WHERE p.codItem = :codItem"),
    @NamedQuery(name = "Parentes.findByCodInterno", query = "SELECT p FROM Parentes p WHERE p.codInterno = :codInterno"),
    @NamedQuery(name = "Parentes.findByCodVisitante", query = "SELECT p FROM Parentes p WHERE p.codVisitante = :codVisitante"),
    @NamedQuery(name = "Parentes.findByGrauParentesco", query = "SELECT p FROM Parentes p WHERE p.grauParentesco = :grauParentesco")})
public class Parentes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_item")
    private Integer codItem;
    
    @JoinColumn(name = "cod_visitante",referencedColumnName="cod_visitante")
    @ManyToOne
    private Visitantes codVisitante;
    
    
    @JoinColumn(name = "cod_interno",referencedColumnName="cod_interno")
    @ManyToOne
    private Internos codInterno;
    @Basic(optional = false)
    @Column(name = "grau_parentesco")
    private String grauParentesco;

    public Parentes() {
    }

    public Parentes(Integer codItem) {
        this.codItem = codItem;
    }

    public Parentes(Integer codItem, Internos codInterno, Visitantes codVisitante, String grauParentesco) {
        this.codItem = codItem;
        this.codInterno = codInterno;
        this.codVisitante = codVisitante;
        this.grauParentesco = grauParentesco;
    }

    public Integer getCodItem() {
        return codItem;
    }

    public void setCodItem(Integer codItem) {
        Integer oldCodItem = this.codItem;
        this.codItem = codItem;
        changeSupport.firePropertyChange("codItem", oldCodItem, codItem);
    }

    public Internos getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(Internos codInterno) {
        Internos oldCodInterno = this.codInterno;
        this.codInterno = codInterno;
        changeSupport.firePropertyChange("codInterno", oldCodInterno, codInterno);
    }

    public Visitantes getCodVisitante() {
        return codVisitante;
    }

    public void setCodVisitante(Visitantes codVisitante) {
        Visitantes oldCodVisitante = this.codVisitante;
        this.codVisitante = codVisitante;
        changeSupport.firePropertyChange("codVisitante", oldCodVisitante, codVisitante);
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        String oldGrauParentesco = this.grauParentesco;
        this.grauParentesco = grauParentesco;
        changeSupport.firePropertyChange("grauParentesco", oldGrauParentesco, grauParentesco);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codItem != null ? codItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentes)) {
            return false;
        }
        Parentes other = (Parentes) object;
        if ((this.codItem == null && other.codItem != null) || (this.codItem != null && !this.codItem.equals(other.codItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ivc.cdp.Parentes[ codItem=" + codItem + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
