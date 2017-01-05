package Dados;

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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "fr_servicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrServicos.findAll", query = "SELECT f FROM FrServicos f"),
    @NamedQuery(name = "FrServicos.findById", query = "SELECT f FROM FrServicos f WHERE f.id = :id"),
    @NamedQuery(name = "FrServicos.findByQuantidade", query = "SELECT f FROM FrServicos f WHERE f.quantidade = :quantidade")})
public class FrServicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantidade")
    private Float quantidade = 0f;
    @JoinColumn(name = "Diaria", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrDiaria diaria;
    @JoinColumn(name = "Peca", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPecas peca;
    @JoinColumn(name = "Prefeitura", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPrefeitura prefeitura;

    public FrServicos() {
    }

    public FrServicos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public FrDiaria getDiaria() {
        return diaria;
    }

    public void setDiaria(FrDiaria diaria) {
        this.diaria = diaria;
    }

    public FrPecas getPeca() {
        return peca;
    }

    public void setPeca(FrPecas peca) {
        this.peca = peca;
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
        if (!(object instanceof FrServicos)) {
            return false;
        }
        FrServicos other = (FrServicos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrServicos[ id=" + id + " ]";
    }
    
}
