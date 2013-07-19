/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ivc.cdp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author KENIARP
 */
@Entity
@Table(name = "visitantes", catalog = "visitas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Visitantes.findAll", query = "SELECT v FROM Visitantes v"),
    @NamedQuery(name = "Visitantes.findByCodVisitante", query = "SELECT v FROM Visitantes v WHERE v.codVisitante = :codVisitante"),
    @NamedQuery(name = "Visitantes.findByVisitante", query = "SELECT v FROM Visitantes v WHERE v.visitante = :visitante"),
    @NamedQuery(name = "Visitantes.findByRg", query = "SELECT v FROM Visitantes v WHERE v.rg = :rg"),
    @NamedQuery(name = "Visitantes.findByCpf", query = "SELECT v FROM Visitantes v WHERE v.cpf = :cpf")})
public class Visitantes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_visitante")
    private Integer codVisitante;
    @Basic(optional = false)
    @Column(name = "visitante")
    private String visitante;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Lob
    @Column(name = "endereco")
    private String endereco;
    @Lob
    @Column(name = "obs")
    private String obs;
    @OneToMany(mappedBy = "codVisitante")
    private List<Visitas> visitasList;

    public Visitantes() {
    }

    public Visitantes(Integer codVisitante) {
        this.codVisitante = codVisitante;
    }

    public Visitantes(Integer codVisitante, String visitante, String rg, String cpf, String endereco) {
        this.codVisitante = codVisitante;
        this.visitante = visitante;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Integer getCodVisitante() {
        return codVisitante;
    }

    public void setCodVisitante(Integer codVisitante) {
        Integer oldCodVisitante = this.codVisitante;
        this.codVisitante = codVisitante;
        changeSupport.firePropertyChange("codVisitante", oldCodVisitante, codVisitante);
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        String oldVisitante = this.visitante;
        this.visitante = visitante;
        changeSupport.firePropertyChange("visitante", oldVisitante, visitante);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
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
        hash += (codVisitante != null ? codVisitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitantes)) {
            return false;
        }
        Visitantes other = (Visitantes) object;
        if ((this.codVisitante == null && other.codVisitante != null) || (this.codVisitante != null && !this.codVisitante.equals(other.codVisitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ivc.cdp.Visitantes[ codVisitante=" + codVisitante + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
