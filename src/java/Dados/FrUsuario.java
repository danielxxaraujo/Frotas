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
@Table(name = "fr_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrUsuario.findAll", query = "SELECT f FROM FrUsuario f"),
    @NamedQuery(name = "FrUsuario.findById", query = "SELECT f FROM FrUsuario f WHERE f.id = :id"),
    @NamedQuery(name = "FrUsuario.findByMatricula", query = "SELECT f FROM FrUsuario f WHERE f.matricula = :matricula"),
    @NamedQuery(name = "FrUsuario.findByNome", query = "SELECT f FROM FrUsuario f WHERE f.nome = :nome"),
    @NamedQuery(name = "FrUsuario.findByCnh", query = "SELECT f FROM FrUsuario f WHERE f.cnh = :cnh"),
    @NamedQuery(name = "FrUsuario.findByValidade", query = "SELECT f FROM FrUsuario f WHERE f.validade = :validade"),
    @NamedQuery(name = "FrUsuario.findByCategoria", query = "SELECT f FROM FrUsuario f WHERE f.categoria = :categoria"),
    @NamedQuery(name = "FrUsuario.findByEmail", query = "SELECT f FROM FrUsuario f WHERE f.email = :email"),
    @NamedQuery(name = "FrUsuario.findByFone", query = "SELECT f FROM FrUsuario f WHERE f.fone = :fone"),
    @NamedQuery(name = "FrUsuario.findByCelular", query = "SELECT f FROM FrUsuario f WHERE f.celular = :celular"),
    @NamedQuery(name = "FrUsuario.findByNivel", query = "SELECT f FROM FrUsuario f WHERE f.nivel = :nivel"),
    @NamedQuery(name = "FrUsuario.findBySenha", query = "SELECT f FROM FrUsuario f WHERE f.senha = :senha")})
public class FrUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Matricula")
    private String matricula  = "";
    @Column(name = "Nome")
    private String nome = "";
    @Column(name = "CNH")
    private String cnh = "";
    @Column(name = "Validade")
    @Temporal(TemporalType.DATE)
    private Date validade = new Date();
    @Column(name = "Categoria")
    private String categoria = "";
    @Column(name = "email")
    private String email = "";
    @Column(name = "Fone")
    private String fone = "";
    @Column(name = "Celular")
    private String celular = "";
    @Column(name = "Nivel")
    private Integer nivel = 0;
    @Column(name = "Senha")
    private String senha = "123";
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<FrDiaria> frDiariaCollection;
    @JoinColumn(name = "Prefeitura", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FrPrefeitura prefeitura;

    public FrUsuario() {
    }

    public FrUsuario(Integer id) {
        this.id = id;
        this.prefeitura = new FrPrefeitura(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public Collection<FrDiaria> getFrDiariaCollection() {
        return frDiariaCollection;
    }

    public void setFrDiariaCollection(Collection<FrDiaria> frDiariaCollection) {
        this.frDiariaCollection = frDiariaCollection;
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
        if (!(object instanceof FrUsuario)) {
            return false;
        }
        FrUsuario other = (FrUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dados.FrUsuario[ id=" + id + " ]";
    }
    
}
