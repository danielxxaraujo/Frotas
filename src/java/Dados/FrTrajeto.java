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
@Table(name = "fr_trajeto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrTrajeto.findAll", query = "SELECT f FROM FrTrajeto f"),
    @NamedQuery(name = "FrTrajeto.findById", query = "SELECT f FROM FrTrajeto f WHERE f.id = :id"),
    @NamedQuery(name = "FrTrajeto.findByKmInicial", query = "SELECT f FROM FrTrajeto f WHERE f.kmInicial = :kmInicial"),
    @NamedQuery(name = "FrTrajeto.findByKmFinal", query = "SELECT f FROM FrTrajeto f WHERE f.kmFinal = :kmFinal"),
    @NamedQuery(name = "FrTrajeto.findByOrigem", query = "SELECT f FROM FrTrajeto f WHERE f.origem = :origem"),
    @NamedQuery(name = "FrTrajeto.findByDestino", query = "SELECT f FROM FrTrajeto f WHERE f.destino = :destino")})
public class FrTrajeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "KmInicial")
    private Integer kmInicial;
    @Column(name = "KmFinal")
    private Integer kmFinal;
    @Column(name = "Origem")
    private String origem;
    @Column(name = "Destino")
    private String destino;
    @JoinColumn(name = "Diaria", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrDiaria diaria;

    public FrTrajeto() {
    }

    public FrTrajeto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public FrDiaria getDiaria() {
        return diaria;
    }

    public void setDiaria(FrDiaria diaria) {
        this.diaria = diaria;
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
        if (!(object instanceof FrTrajeto)) {
            return false;
        }
        FrTrajeto other = (FrTrajeto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrTrajeto[ id=" + id + " ]";
    }
    
}
