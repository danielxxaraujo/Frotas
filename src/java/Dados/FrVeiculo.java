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
@Table(name = "fr_veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrVeiculo.findAll", query = "SELECT f FROM FrVeiculo f"),
    @NamedQuery(name = "FrVeiculo.findById", query = "SELECT f FROM FrVeiculo f WHERE f.id = :id"),
    @NamedQuery(name = "FrVeiculo.findByPlaca", query = "SELECT f FROM FrVeiculo f WHERE f.placa = :placa"),
    @NamedQuery(name = "FrVeiculo.findByVeiculo", query = "SELECT f FROM FrVeiculo f WHERE f.veiculo = :veiculo"),
    @NamedQuery(name = "FrVeiculo.findByMarca", query = "SELECT f FROM FrVeiculo f WHERE f.marca = :marca"),
    @NamedQuery(name = "FrVeiculo.findByAquisicao", query = "SELECT f FROM FrVeiculo f WHERE f.aquisicao = :aquisicao"),
    @NamedQuery(name = "FrVeiculo.findByPotencia", query = "SELECT f FROM FrVeiculo f WHERE f.potencia = :potencia"),
    @NamedQuery(name = "FrVeiculo.findByAno", query = "SELECT f FROM FrVeiculo f WHERE f.ano = :ano"),
    @NamedQuery(name = "FrVeiculo.findByNf", query = "SELECT f FROM FrVeiculo f WHERE f.nf = :nf"),
    @NamedQuery(name = "FrVeiculo.findByCilindradas", query = "SELECT f FROM FrVeiculo f WHERE f.cilindradas = :cilindradas"),
    @NamedQuery(name = "FrVeiculo.findByLotado", query = "SELECT f FROM FrVeiculo f WHERE f.lotado = :lotado"),
    @NamedQuery(name = "FrVeiculo.findByRenavam", query = "SELECT f FROM FrVeiculo f WHERE f.renavam = :renavam"),
    @NamedQuery(name = "FrVeiculo.findByCategoria", query = "SELECT f FROM FrVeiculo f WHERE f.categoria = :categoria")})
public class FrVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Placa")
    private String placa = "";
    @Column(name = "Veiculo")
    private String veiculo = "";
    @Column(name = "Marca")
    private String marca = "";
    @Column(name = "Aquisicao")
    @Temporal(TemporalType.DATE)
    private Date aquisicao;
    @Column(name = "Potencia")
    private String potencia = "";
    @Column(name = "Ano")
    private String ano = "";
    @Column(name = "NF")
    private String nf = "";
    @Column(name = "Cilindradas")
    private String cilindradas = "";
    @Column(name = "Lotado")
    private String lotado = "";
    @Column(name = "Renavam")
    private String renavam = "";
    @Column(name = "Categoria")
    private Integer categoria = 0;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")
    private Collection<FrDiaria> frDiariaCollection;
    @JoinColumn(name = "Combustivel", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPecas combustivel;
    @JoinColumn(name = "Prefeitura", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPrefeitura prefeitura;

    public FrVeiculo() {
    }

    public FrVeiculo(Integer id) {
        this.id = id;
        this.combustivel = new FrPecas(0);
        this.prefeitura = new FrPrefeitura(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAquisicao() {
        return aquisicao;
    }

    public void setAquisicao(Date aquisicao) {
        this.aquisicao = aquisicao;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public String getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(String cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getLotado() {
        return lotado;
    }

    public void setLotado(String lotado) {
        this.lotado = lotado;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public Collection<FrDiaria> getFrDiariaCollection() {
        return frDiariaCollection;
    }

    public void setFrDiariaCollection(Collection<FrDiaria> frDiariaCollection) {
        this.frDiariaCollection = frDiariaCollection;
    }

    public FrPecas getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(FrPecas combustivel) {
        this.combustivel = combustivel;
    }

    public FrPrefeitura getPrefeitura() {
        return prefeitura;
    }

    public void setPrefeitura(FrPrefeitura prefeitura) {
        this.prefeitura = prefeitura;
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
        if (!(object instanceof FrVeiculo)) {
            return false;
        }
        FrVeiculo other = (FrVeiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrVeiculo[ id=" + id + " ]";
    }
    
}
