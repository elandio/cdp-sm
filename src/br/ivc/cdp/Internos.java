/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ivc.cdp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author KENIARP
 */
@Entity
@Table(name = "internos", catalog = "visitas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Internos.findAll", query = "SELECT i FROM Internos i"),
    @NamedQuery(name = "Internos.findByCodInterno", query = "SELECT i FROM Internos i WHERE i.codInterno = :codInterno"),
    @NamedQuery(name = "Internos.findByInterno", query = "SELECT i FROM Internos i WHERE i.interno = :interno"),
    @NamedQuery(name = "Internos.findByDatEntrada", query = "SELECT i FROM Internos i WHERE i.datEntrada = :datEntrada"),
    @NamedQuery(name = "Internos.findByCpf", query = "SELECT i FROM Internos i WHERE i.cpf = :cpf"),
    @NamedQuery(name = "Internos.findByRg", query = "SELECT i FROM Internos i WHERE i.rg = :rg"),
    @NamedQuery(name = "Internos.findByGaleria", query = "SELECT i FROM Internos i WHERE i.galeria = :galeria"),
    @NamedQuery(name = "Internos.findByCela", query = "SELECT i FROM Internos i WHERE i.cela = :cela"),
    @NamedQuery(name = "Internos.findByBloqueadoVisita", query = "SELECT i FROM Internos i WHERE i.bloqueadoVisita = :bloqueadoVisita")})
public class Internos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_interno")
    private Integer codInterno;
    @Basic(optional = false)
    @Column(name = "interno")
    private String interno;
    @Basic(optional = false)
    @Column(name = "dat_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datEntrada;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "galeria")
    private String galeria;
    @Basic(optional = false)
    @Column(name = "cela")
    private int cela;
    @Basic(optional = false)
    @Column(name = "bloqueado_visita")
    private String bloqueadoVisita;
    @Basic(optional = false)
    @Lob
    @Column(name = "endereco")
    private String endereco;
    @Lob
    @Column(name = "obs")
    private String obs;
    @OneToMany(mappedBy = "codInterno")
    private List<Visitas> visitasList;

    public Internos() {
    }

    public Internos(Integer codInterno) {
        this.codInterno = codInterno;
    }

    public Internos(Integer codInterno, String interno, Date datEntrada, String cpf, String rg, String galeria, int cela, String bloqueadoVisita, String endereco) {
        this.codInterno = codInterno;
        this.interno = interno;
        this.datEntrada = datEntrada;
        this.cpf = cpf;
        this.rg = rg;
        this.galeria = galeria;
        this.cela = cela;
        this.bloqueadoVisita = bloqueadoVisita;
        this.endereco = endereco;
    }

    public Integer getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(Integer codInterno) {
        Integer oldCodInterno = this.codInterno;
        this.codInterno = codInterno;
        changeSupport.firePropertyChange("codInterno", oldCodInterno, codInterno);
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        String oldInterno = this.interno;
        this.interno = interno;
        changeSupport.firePropertyChange("interno", oldInterno, interno);
    }

    public Date getDatEntrada() {
        return datEntrada;
    }

    public void setDatEntrada(Date datEntrada) {
        Date oldDatEntrada = this.datEntrada;
        this.datEntrada = datEntrada;
        changeSupport.firePropertyChange("datEntrada", oldDatEntrada, datEntrada);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }

    public String getGaleria() {
        return galeria;
    }

    public void setGaleria(String galeria) {
        String oldGaleria = this.galeria;
        this.galeria = galeria;
        changeSupport.firePropertyChange("galeria", oldGaleria, galeria);
    }

    public int getCela() {
        return cela;
    }

    public void setCela(int cela) {
        int oldCela = this.cela;
        this.cela = cela;
        changeSupport.firePropertyChange("cela", oldCela, cela);
    }

    public String getBloqueadoVisita() {
        return bloqueadoVisita;
    }

    public void setBloqueadoVisita(String bloqueadoVisita) {
        String oldBloqueadoVisita = this.bloqueadoVisita;
        this.bloqueadoVisita = bloqueadoVisita;
        changeSupport.firePropertyChange("bloqueadoVisita", oldBloqueadoVisita, bloqueadoVisita);
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
        hash += (codInterno != null ? codInterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Internos)) {
            return false;
        }
        Internos other = (Internos) object;
        if ((this.codInterno == null && other.codInterno != null) || (this.codInterno != null && !this.codInterno.equals(other.codInterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ivc.cdp.Internos[ codInterno=" + codInterno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
