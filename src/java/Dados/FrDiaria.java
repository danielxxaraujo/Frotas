package Dados;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "fr_diaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrDiaria.findAll", query = "SELECT f FROM FrDiaria f"),
    @NamedQuery(name = "FrDiaria.findById", query = "SELECT f FROM FrDiaria f WHERE f.id = :id"),
    @NamedQuery(name = "FrDiaria.findByData", query = "SELECT f FROM FrDiaria f WHERE f.data = :data"),
    @NamedQuery(name = "FrDiaria.findByKmInicial", query = "SELECT f FROM FrDiaria f WHERE f.kmInicial = :kmInicial"),
    @NamedQuery(name = "FrDiaria.findByKmFinal", query = "SELECT f FROM FrDiaria f WHERE f.kmFinal = :kmFinal"),
    @NamedQuery(name = "FrDiaria.findByObs", query = "SELECT f FROM FrDiaria f WHERE f.obs = :obs")})
public class FrDiaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "KmInicial")
    private Integer kmInicial = 0;
    @Column(name = "KmFinal")
    private Integer kmFinal = 0;
    @Column(name = "OBS")
    private String obs = "";
    @JoinColumn(name = "Prefeitura", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPrefeitura prefeitura;
    @JoinColumn(name = "Usuario", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrUsuario usuario;
    @JoinColumn(name = "Veiculo", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrVeiculo veiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diaria")
    private Collection<FrTrajeto> frTrajetoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diaria")
    private Collection<FrServicos> frServicosCollection;

    public FrDiaria() {
    }

    public FrDiaria(Integer id) {
        this.id = id;
        this.prefeitura = new FrPrefeitura(0);
        this.usuario = new FrUsuario(0);
        this.veiculo = new FrVeiculo(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Integer kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Integer getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Integer kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public FrPrefeitura getPrefeitura() {
        return prefeitura;
    }

    public void setPrefeitura(FrPrefeitura prefeitura) {
        this.prefeitura = prefeitura;
    }

    public FrUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(FrUsuario usuario) {
        this.usuario = usuario;
    }

    public FrVeiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(FrVeiculo veiculo) {
        this.veiculo = veiculo;
    }

    @XmlTransient
    public Collection<FrTrajeto> getFrTrajetoCollection() {
        return frTrajetoCollection;
    }

    public void setFrTrajetoCollection(Collection<FrTrajeto> frTrajetoCollection) {
        this.frTrajetoCollection = frTrajetoCollection;
    }

    @XmlTransient
    public Collection<FrServicos> getFrServicosCollection() {
        return frServicosCollection;
    }

    public void setFrServicosCollection(Collection<FrServicos> frServicosCollection) {
        this.frServicosCollection = frServicosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrDiaria)) {
            return false;
        }
        FrDiaria other = (FrDiaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrDiaria[ id=" + id + " ]";
    }
    
}
