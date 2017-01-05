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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "fr_prefeitura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrPrefeitura.findAll", query = "SELECT f FROM FrPrefeitura f"),
    @NamedQuery(name = "FrPrefeitura.findById", query = "SELECT f FROM FrPrefeitura f WHERE f.id = :id"),
    @NamedQuery(name = "FrPrefeitura.findByCnpj", query = "SELECT f FROM FrPrefeitura f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "FrPrefeitura.findByDescricao", query = "SELECT f FROM FrPrefeitura f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "FrPrefeitura.findByEndereco", query = "SELECT f FROM FrPrefeitura f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "FrPrefeitura.findByBairro", query = "SELECT f FROM FrPrefeitura f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "FrPrefeitura.findByCep", query = "SELECT f FROM FrPrefeitura f WHERE f.cep = :cep"),
    @NamedQuery(name = "FrPrefeitura.findByCidade", query = "SELECT f FROM FrPrefeitura f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "FrPrefeitura.findByUf", query = "SELECT f FROM FrPrefeitura f WHERE f.uf = :uf"),
    @NamedQuery(name = "FrPrefeitura.findByFone", query = "SELECT f FROM FrPrefeitura f WHERE f.fone = :fone"),
    @NamedQuery(name = "FrPrefeitura.findByLogo", query = "SELECT f FROM FrPrefeitura f WHERE f.logo = :logo")})
public class FrPrefeitura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CNPJ")
    private String cnpj = "";
    @Column(name = "Descricao")
    private String descricao = "";
    @Column(name = "Endereco")
    private String endereco = "";
    @Column(name = "Bairro")
    private String bairro = "";
    @Column(name = "CEP")
    private String cep = "";
    @Column(name = "Cidade")
    private String cidade = "";
    @Column(name = "UF")
    private String uf = "";
    @Column(name = "Fone")
    private String fone = "";
    @Column(name = "Logo")
    private String logo = "";
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeitura")
    private Collection<FrDiaria> frDiariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeitura")
    private Collection<FrValor> frValorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeitura")
    private Collection<FrVeiculo> frVeiculoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeitura")
    private Collection<FrPecas> frPecasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeitura")
    private Collection<FrServicos> frServicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefeitura")
    private Collection<FrUsuario> frUsuarioCollection;

    public FrPrefeitura() {
    }

    public FrPrefeitura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @XmlTransient
    public Collection<FrDiaria> getFrDiariaCollection() {
        return frDiariaCollection;
    }

    public void setFrDiariaCollection(Collection<FrDiaria> frDiariaCollection) {
        this.frDiariaCollection = frDiariaCollection;
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

    @XmlTransient
    public Collection<FrPecas> getFrPecasCollection() {
        return frPecasCollection;
    }

    public void setFrPecasCollection(Collection<FrPecas> frPecasCollection) {
        this.frPecasCollection = frPecasCollection;
    }

    @XmlTransient
    public Collection<FrServicos> getFrServicosCollection() {
        return frServicosCollection;
    }

    public void setFrServicosCollection(Collection<FrServicos> frServicosCollection) {
        this.frServicosCollection = frServicosCollection;
    }

    @XmlTransient
    public Collection<FrUsuario> getFrUsuarioCollection() {
        return frUsuarioCollection;
    }

    public void setFrUsuarioCollection(Collection<FrUsuario> frUsuarioCollection) {
        this.frUsuarioCollection = frUsuarioCollection;
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
        if (!(object instanceof FrPrefeitura)) {
            return false;
        }
        FrPrefeitura other = (FrPrefeitura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrPrefeitura[ id=" + id + " ]";
    }
    
}
