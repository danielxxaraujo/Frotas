package Dados;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "fr_valor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrValor.findAll", query = "SELECT f FROM FrValor f"),
    @NamedQuery(name = "FrValor.findById", query = "SELECT f FROM FrValor f WHERE f.id = :id"),
    @NamedQuery(name = "FrValor.findByData", query = "SELECT f FROM FrValor f WHERE f.data = :data"),
    @NamedQuery(name = "FrValor.findByValor", query = "SELECT f FROM FrValor f WHERE f.valor = :valor")})
public class FrValor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Float valor = 0f;
    @JoinColumn(name = "Peca", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPecas peca;
    @JoinColumn(name = "Prefeitura", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPrefeitura prefeitura;

    public FrValor() {
    }

    public FrValor(Integer id) {
        this.id = id;
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
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
        if (!(object instanceof FrValor)) {
            return false;
        }
        FrValor other = (FrValor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrValor[ id=" + id + " ]";
    }
    
}
