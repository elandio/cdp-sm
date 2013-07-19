/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ivc.cdp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author KENIARP
 */
@Entity
@Table(name = "visitas", catalog = "visitas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Visitas.findAll", query = "SELECT v FROM Visitas v"),
    @NamedQuery(name = "Visitas.findByCodVisita", query = "SELECT v FROM Visitas v WHERE v.codVisita = :codVisita"),
    @NamedQuery(name = "Visitas.findByCodVisitante", query = "SELECT v FROM Visitas v WHERE v.codVisitante = :codVisitante"),
    @NamedQuery(name = "Visitas.findByCodInterno", query = "SELECT v FROM Visitas v WHERE v.codInterno = :codInterno"),
    @NamedQuery(name = "Visitas.findByData", query = "SELECT v FROM Visitas v WHERE v.data = :data")})
public class Visitas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_visita")
    private Integer codVisita;
    
    
    @JoinColumn(name = "cod_visitante",referencedColumnName="cod_visitante")
    @ManyToOne
    private Visitantes codVisitante;
    
    
    @JoinColumn(name = "cod_interno",referencedColumnName="cod_interno")
    @ManyToOne
    private Internos codInterno;
    
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Lob
    @Column(name = "obs")
    private String obs;

    public Visitas() {
    }

    public Visitas(Integer codVisita) {
        this.codVisita = codVisita;
    }

    public Visitas(Integer codVisita, Visitantes codVisitante, Internos codInterno, Date data, String obs) {
        this.codVisita = codVisita;
        this.codVisitante = codVisitante;
        this.codInterno = codInterno;
        this.data = data;
        this.obs = obs;
    }

    public Integer getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(Integer codVisita) {
        Integer oldCodVisita = this.codVisita;
        this.codVisita = codVisita;
        changeSupport.firePropertyChange("codVisita", oldCodVisita, codVisita);
    }

    public Visitantes getCodVisitante() {
        return codVisitante;
    }

    public void setCodVisitante(Visitantes codVisitante) {
        Visitantes oldCodVisitante = this.codVisitante;
        this.codVisitante = codVisitante;
        changeSupport.firePropertyChange("codVisitante", oldCodVisitante, codVisitante);
    }

    public Internos getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(Internos codInterno) {
        Internos oldCodInterno = this.codInterno;
        this.codInterno = codInterno;
        changeSupport.firePropertyChange("codInterno", oldCodInterno, codInterno);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        String oldObs = this.obs;
        this.obs = obs;
        changeSupport.firePropertyChange("obs", oldObs, obs);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVisita != null ? codVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitas)) {
            return false;
        }
        Visitas other = (Visitas) object;
        if ((this.codVisita == null && other.codVisita != null) || (this.codVisita != null && !this.codVisita.equals(other.codVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ivc.cdp.Visitas[ codVisita=" + codVisita + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
