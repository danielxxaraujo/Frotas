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
@Table(name = "v_fr_servicos_pecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFrServicosPecas.findAll", query = "SELECT v FROM VFrServicosPecas v"),
    @NamedQuery(name = "VFrServicosPecas.findById", query = "SELECT v FROM VFrServicosPecas v WHERE v.id = :id"),
    @NamedQuery(name = "VFrServicosPecas.findByPrefeitura", query = "SELECT v FROM VFrServicosPecas v WHERE v.prefeitura = :prefeitura"),
    @NamedQuery(name = "VFrServicosPecas.findByCnpj", query = "SELECT v FROM VFrServicosPecas v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "VFrServicosPecas.findByPrefeituraDescricao", query = "SELECT v FROM VFrServicosPecas v WHERE v.prefeituraDescricao = :prefeituraDescricao"),
    @NamedQuery(name = "VFrServicosPecas.findByEndereco", query = "SELECT v FROM VFrServicosPecas v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VFrServicosPecas.findByBairro", query = "SELECT v FROM VFrServicosPecas v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "VFrServicosPecas.findByCep", query = "SELECT v FROM VFrServicosPecas v WHERE v.cep = :cep"),
    @NamedQuery(name = "VFrServicosPecas.findByCidade", query = "SELECT v FROM VFrServicosPecas v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VFrServicosPecas.findByUf", query = "SELECT v FROM VFrServicosPecas v WHERE v.uf = :uf"),
    @NamedQuery(name = "VFrServicosPecas.findByFone", query = "SELECT v FROM VFrServicosPecas v WHERE v.fone = :fone"),
    @NamedQuery(name = "VFrServicosPecas.findByLogo", query = "SELECT v FROM VFrServicosPecas v WHERE v.logo = :logo"),
    @NamedQuery(name = "VFrServicosPecas.findByDiaria", query = "SELECT v FROM VFrServicosPecas v WHERE v.diaria = :diaria"),
    @NamedQuery(name = "VFrServicosPecas.findByPeca", query = "SELECT v FROM VFrServicosPecas v WHERE v.peca = :peca"),
    @NamedQuery(name = "VFrServicosPecas.findByPrefeituraPecas", query = "SELECT v FROM VFrServicosPecas v WHERE v.prefeituraPecas = :prefeituraPecas"),
    @NamedQuery(name = "VFrServicosPecas.findByCategoria", query = "SELECT v FROM VFrServicosPecas v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "VFrServicosPecas.findByCodigo", query = "SELECT v FROM VFrServicosPecas v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VFrServicosPecas.findByDescricao", query = "SELECT v FROM VFrServicosPecas v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VFrServicosPecas.findByUnidade", query = "SELECT v FROM VFrServicosPecas v WHERE v.unidade = :unidade"),
    @NamedQuery(name = "VFrServicosPecas.findByQuantidade", query = "SELECT v FROM VFrServicosPecas v WHERE v.quantidade = :quantidade")})
public class VFrServicosPecas implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "Diaria")
    private int diaria;
    @Basic(optional = false)
    @Column(name = "Peca")
    private int peca;
    @Column(name = "PrefeituraPecas")
    private Integer prefeituraPecas;
    @Column(name = "Categoria")
    private Integer categoria;
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "Unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantidade")
    private Float quantidade;

    public VFrServicosPecas() {
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

    public int getDiaria() {
        return diaria;
    }

    public void setDiaria(int diaria) {
        this.diaria = diaria;
    }

    public int getPeca() {
        return peca;
    }

    public void setPeca(int peca) {
        this.peca = peca;
    }

    public Integer getPrefeituraPecas() {
        return prefeituraPecas;
    }

    public void setPrefeituraPecas(Integer prefeituraPecas) {
        this.prefeituraPecas = prefeituraPecas;
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

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
    
}
