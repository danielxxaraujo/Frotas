package View;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "v_fr_pecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFrPecas.findAll", query = "SELECT v FROM VFrPecas v"),
    @NamedQuery(name = "VFrPecas.findById", query = "SELECT v FROM VFrPecas v WHERE v.id = :id"),
    @NamedQuery(name = "VFrPecas.findByPrefeitura", query = "SELECT v FROM VFrPecas v WHERE v.prefeitura = :prefeitura"),
    @NamedQuery(name = "VFrPecas.findByCnpj", query = "SELECT v FROM VFrPecas v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "VFrPecas.findByPrefeituraDescricao", query = "SELECT v FROM VFrPecas v WHERE v.prefeituraDescricao = :prefeituraDescricao"),
    @NamedQuery(name = "VFrPecas.findByEndereco", query = "SELECT v FROM VFrPecas v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VFrPecas.findByBairro", query = "SELECT v FROM VFrPecas v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "VFrPecas.findByCep", query = "SELECT v FROM VFrPecas v WHERE v.cep = :cep"),
    @NamedQuery(name = "VFrPecas.findByCidade", query = "SELECT v FROM VFrPecas v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VFrPecas.findByUf", query = "SELECT v FROM VFrPecas v WHERE v.uf = :uf"),
    @NamedQuery(name = "VFrPecas.findByFone", query = "SELECT v FROM VFrPecas v WHERE v.fone = :fone"),
    @NamedQuery(name = "VFrPecas.findByLogo", query = "SELECT v FROM VFrPecas v WHERE v.logo = :logo"),
    @NamedQuery(name = "VFrPecas.findByCategoria", query = "SELECT v FROM VFrPecas v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "VFrPecas.findByCodigo", query = "SELECT v FROM VFrPecas v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VFrPecas.findByDescricao", query = "SELECT v FROM VFrPecas v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VFrPecas.findByUnidade", query = "SELECT v FROM VFrPecas v WHERE v.unidade = :unidade")})
public class VFrPecas implements Serializable {
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
    @Column(name = "PrefeituraDescricao")
    private String prefeituraDescricao;
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
    @Column(name = "Fone")
    private String fone;
    @Column(name = "Logo")
    private String logo;
    @Column(name = "Categoria")
    private Integer categoria;
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "Unidade")
    private String unidade;

    public VFrPecas() {
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

    public String getPrefeituraDescricao() {
        return prefeituraDescricao;
    }

    public void setPrefeituraDescricao(String prefeituraDescricao) {
        this.prefeituraDescricao = prefeituraDescricao;
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
    
}
