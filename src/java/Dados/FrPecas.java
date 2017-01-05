package Dados;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "fr_pecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrPecas.findAll", query = "SELECT f FROM FrPecas f"),
    @NamedQuery(name = "FrPecas.findById", query = "SELECT f FROM FrPecas f WHERE f.id = :id"),
    @NamedQuery(name = "FrPecas.findByCategoria", query = "SELECT f FROM FrPecas f WHERE f.categoria = :categoria"),
    @NamedQuery(name = "FrPecas.findByCodigo", query = "SELECT f FROM FrPecas f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "FrPecas.findByDescricao", query = "SELECT f FROM FrPecas f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "FrPecas.findByUnidade", query = "SELECT f FROM FrPecas f WHERE f.unidade = :unidade")})
public class FrPecas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Categoria")
    private Integer categoria = 0;
    @Column(name = "Codigo")
    private String codigo = "";
    @Column(name = "Descricao")
    private String descricao = "";
    @Column(name = "Unidade")
    private String unidade = "";
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peca")
    private Collection<FrValor> frValorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "combustivel")
    private Collection<FrVeiculo> frVeiculoCollection;
    @JoinColumn(name = "Prefeitura", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPrefeitura prefeitura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peca")
    private Collection<FrServicos> frServicosCollection;

    public FrPecas() {
    }

    public FrPecas(Integer id) {
        this.id = id;
        this.prefeitura = new FrPrefeitura(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @XmlTransient
    public Collection<FrValor> getFrValorCollection() {
        return frValorCollection;
    }

    public void setFrValorCollection(Collection<FrValor> frValorCollection) {
        this.frValorCollection = frValorCollection;
    }

    @XmlTransient
    public Collection<FrVeiculo> getFrVeiculoCollection() {
        return frVeiculoCollection;
    }

    public void setFrVeiculoCollection(Collection<FrVeiculo> frVeiculoCollection) {
        this.frVeiculoCollection = frVeiculoCollection;
    }

    public FrPrefeitura getPrefeitura() {
        return prefeitura;
    }

    public void setPrefeitura(FrPrefeitura prefeitura) {
        this.prefeitura = prefeitura;
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
        if (!(object instanceof FrPecas)) {
            return false;
        }
        FrPecas other = (FrPecas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrPecas[ id=" + id + " ]";
    }
    
}
