package View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "v_fr_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFrUsuario.findAll", query = "SELECT v FROM VFrUsuario v"),
    @NamedQuery(name = "VFrUsuario.findById", query = "SELECT v FROM VFrUsuario v WHERE v.id = :id"),
    @NamedQuery(name = "VFrUsuario.findByPrefeitura", query = "SELECT v FROM VFrUsuario v WHERE v.prefeitura = :prefeitura"),
    @NamedQuery(name = "VFrUsuario.findByCnpj", query = "SELECT v FROM VFrUsuario v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "VFrUsuario.findByDescricao", query = "SELECT v FROM VFrUsuario v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VFrUsuario.findByEndereco", query = "SELECT v FROM VFrUsuario v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VFrUsuario.findByBairro", query = "SELECT v FROM VFrUsuario v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "VFrUsuario.findByCep", query = "SELECT v FROM VFrUsuario v WHERE v.cep = :cep"),
    @NamedQuery(name = "VFrUsuario.findByCidade", query = "SELECT v FROM VFrUsuario v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VFrUsuario.findByUf", query = "SELECT v FROM VFrUsuario v WHERE v.uf = :uf"),
    @NamedQuery(name = "VFrUsuario.findByPrefeituraFone", query = "SELECT v FROM VFrUsuario v WHERE v.prefeituraFone = :prefeituraFone"),
    @NamedQuery(name = "VFrUsuario.findByLogo", query = "SELECT v FROM VFrUsuario v WHERE v.logo = :logo"),
    @NamedQuery(name = "VFrUsuario.findByMatricula", query = "SELECT v FROM VFrUsuario v WHERE v.matricula = :matricula"),
    @NamedQuery(name = "VFrUsuario.findByNome", query = "SELECT v FROM VFrUsuario v WHERE v.nome = :nome"),
    @NamedQuery(name = "VFrUsuario.findByCnh", query = "SELECT v FROM VFrUsuario v WHERE v.cnh = :cnh"),
    @NamedQuery(name = "VFrUsuario.findByValidade", query = "SELECT v FROM VFrUsuario v WHERE v.validade = :validade"),
    @NamedQuery(name = "VFrUsuario.findByCategoria", query = "SELECT v FROM VFrUsuario v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "VFrUsuario.findByEmail", query = "SELECT v FROM VFrUsuario v WHERE v.email = :email"),
    @NamedQuery(name = "VFrUsuario.findByFone", query = "SELECT v FROM VFrUsuario v WHERE v.fone = :fone"),
    @NamedQuery(name = "VFrUsuario.findByCelular", query = "SELECT v FROM VFrUsuario v WHERE v.celular = :celular"),
    @NamedQuery(name = "VFrUsuario.findByNivel", query = "SELECT v FROM VFrUsuario v WHERE v.nivel = :nivel")})
public class VFrUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "Prefeitura")
    private int prefeitura;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "Endereco")
    private String endereco;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "Cidade")
    private String cidade;
    @Column(name = "UF")
    private String uf;
    @Column(name = "PrefeituraFone")
    private String prefeituraFone;
    @Column(name = "Logo")
    private String logo;
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "CNH")
    private String cnh;
    @Column(name = "Validade")
    @Temporal(TemporalType.DATE)
    private Date validade;
    @Column(name = "Categoria")
    private String categoria;
    @Column(name = "email")
    private String email;
    @Column(name = "Fone")
    private String fone;
    @Column(name = "Celular")
    private String celular;
    @Column(name = "Nivel")
    private Integer nivel;

    public VFrUsuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrefeitura() {
        return prefeitura;
    }

    public void setPrefeitura(int prefeitura) {
        this.prefeitura = prefeitura;
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

    public String getPrefeituraFone() {
        return prefeituraFone;
    }

    public void setPrefeituraFone(String prefeituraFone) {
        this.prefeituraFone = prefeituraFone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
    
}
