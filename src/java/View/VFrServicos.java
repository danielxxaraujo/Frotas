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
@Table(name = "v_fr_servicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFrServicos.findAll", query = "SELECT v FROM VFrServicos v"),
    @NamedQuery(name = "VFrServicos.findById", query = "SELECT v FROM VFrServicos v WHERE v.id = :id"),
    @NamedQuery(name = "VFrServicos.findByPrefeitura", query = "SELECT v FROM VFrServicos v WHERE v.prefeitura = :prefeitura"),
    @NamedQuery(name = "VFrServicos.findByCnpj", query = "SELECT v FROM VFrServicos v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "VFrServicos.findByDescricao", query = "SELECT v FROM VFrServicos v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VFrServicos.findByEndereco", query = "SELECT v FROM VFrServicos v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VFrServicos.findByBairro", query = "SELECT v FROM VFrServicos v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "VFrServicos.findByCep", query = "SELECT v FROM VFrServicos v WHERE v.cep = :cep"),
    @NamedQuery(name = "VFrServicos.findByCidade", query = "SELECT v FROM VFrServicos v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VFrServicos.findByUf", query = "SELECT v FROM VFrServicos v WHERE v.uf = :uf"),
    @NamedQuery(name = "VFrServicos.findByFone", query = "SELECT v FROM VFrServicos v WHERE v.fone = :fone"),
    @NamedQuery(name = "VFrServicos.findByLogo", query = "SELECT v FROM VFrServicos v WHERE v.logo = :logo"),
    @NamedQuery(name = "VFrServicos.findByDiaria", query = "SELECT v FROM VFrServicos v WHERE v.diaria = :diaria"),
    @NamedQuery(name = "VFrServicos.findByVeiculo", query = "SELECT v FROM VFrServicos v WHERE v.veiculo = :veiculo"),
    @NamedQuery(name = "VFrServicos.findByPlaca", query = "SELECT v FROM VFrServicos v WHERE v.placa = :placa"),
    @NamedQuery(name = "VFrServicos.findByVeiculoNome", query = "SELECT v FROM VFrServicos v WHERE v.veiculoNome = :veiculoNome"),
    @NamedQuery(name = "VFrServicos.findByMarca", query = "SELECT v FROM VFrServicos v WHERE v.marca = :marca"),
    @NamedQuery(name = "VFrServicos.findByAquisicao", query = "SELECT v FROM VFrServicos v WHERE v.aquisicao = :aquisicao"),
    @NamedQuery(name = "VFrServicos.findByPotencia", query = "SELECT v FROM VFrServicos v WHERE v.potencia = :potencia"),
    @NamedQuery(name = "VFrServicos.findByAno", query = "SELECT v FROM VFrServicos v WHERE v.ano = :ano"),
    @NamedQuery(name = "VFrServicos.findByNf", query = "SELECT v FROM VFrServicos v WHERE v.nf = :nf"),
    @NamedQuery(name = "VFrServicos.findByCilindradas", query = "SELECT v FROM VFrServicos v WHERE v.cilindradas = :cilindradas"),
    @NamedQuery(name = "VFrServicos.findByCombustivel", query = "SELECT v FROM VFrServicos v WHERE v.combustivel = :combustivel"),
    @NamedQuery(name = "VFrServicos.findByLotado", query = "SELECT v FROM VFrServicos v WHERE v.lotado = :lotado"),
    @NamedQuery(name = "VFrServicos.findByRenavam", query = "SELECT v FROM VFrServicos v WHERE v.renavam = :renavam"),
    @NamedQuery(name = "VFrServicos.findByVeiculoCategoria", query = "SELECT v FROM VFrServicos v WHERE v.veiculoCategoria = :veiculoCategoria"),
    @NamedQuery(name = "VFrServicos.findByData", query = "SELECT v FROM VFrServicos v WHERE v.data = :data"),
    @NamedQuery(name = "VFrServicos.findByKmInicial", query = "SELECT v FROM VFrServicos v WHERE v.kmInicial = :kmInicial"),
    @NamedQuery(name = "VFrServicos.findByKmFinal", query = "SELECT v FROM VFrServicos v WHERE v.kmFinal = :kmFinal"),
    @NamedQuery(name = "VFrServicos.findByUsuario", query = "SELECT v FROM VFrServicos v WHERE v.usuario = :usuario"),
    @NamedQuery(name = "VFrServicos.findByObs", query = "SELECT v FROM VFrServicos v WHERE v.obs = :obs"),
    @NamedQuery(name = "VFrServicos.findByPeca", query = "SELECT v FROM VFrServicos v WHERE v.peca = :peca"),
    @NamedQuery(name = "VFrServicos.findByCategoria", query = "SELECT v FROM VFrServicos v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "VFrServicos.findByCodigo", query = "SELECT v FROM VFrServicos v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VFrServicos.findByPecasDescricao", query = "SELECT v FROM VFrServicos v WHERE v.pecasDescricao = :pecasDescricao"),
    @NamedQuery(name = "VFrServicos.findByUnidade", query = "SELECT v FROM VFrServicos v WHERE v.unidade = :unidade"),
    @NamedQuery(name = "VFrServicos.findByQuantidade", query = "SELECT v FROM VFrServicos v WHERE v.quantidade = :quantidade")})
public class VFrServicos implements Serializable {
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
    @Column(name = "Fone")
    private String fone;
    @Column(name = "Logo")
    private String logo;
    @Basic(optional = false)
    @Column(name = "Diaria")
    private int diaria;
    @Column(name = "Veiculo")
    private Integer veiculo;
    @Column(name = "Placa")
    private String placa;
    @Column(name = "VeiculoNome")
    private String veiculoNome;
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Aquisicao")
    @Temporal(TemporalType.DATE)
    private Date aquisicao;
    @Column(name = "Potencia")
    private String potencia;
    @Column(name = "Ano")
    private String ano;
    @Column(name = "NF")
    private String nf;
    @Column(name = "Cilindradas")
    private String cilindradas;
    @Column(name = "Combustivel")
    private Integer combustivel;
    @Column(name = "Lotado")
    private String lotado;
    @Column(name = "Renavam")
    private String renavam;
    @Column(name = "VeiculoCategoria")
    private Integer veiculoCategoria;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "KmInicial")
    private Integer kmInicial;
    @Column(name = "KmFinal")
    private Integer kmFinal;
    @Column(name = "Usuario")
    private Integer usuario;
    @Column(name = "OBS")
    private String obs;
    @Basic(optional = false)
    @Column(name = "Peca")
    private int peca;
    @Column(name = "Categoria")
    private Integer categoria;
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "PecasDescricao")
    private String pecasDescricao;
    @Column(name = "Unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantidade")
    private Float quantidade;

    public VFrServicos() {
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

    public Integer getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Integer veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVeiculoNome() {
        return veiculoNome;
    }

    public void setVeiculoNome(String veiculoNome) {
        this.veiculoNome = veiculoNome;
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

    public Integer getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Integer combustivel) {
        this.combustivel = combustivel;
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

    public Integer getVeiculoCategoria() {
        return veiculoCategoria;
    }

    public void setVeiculoCategoria(Integer veiculoCategoria) {
        this.veiculoCategoria = veiculoCategoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getPeca() {
        return peca;
    }

    public void setPeca(int peca) {
        this.peca = peca;
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

    public String getPecasDescricao() {
        return pecasDescricao;
    }

    public void setPecasDescricao(String pecasDescricao) {
        this.pecasDescricao = pecasDescricao;
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
