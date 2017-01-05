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
@Table(name = "v_fr_diaria_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFrDiariaCategoria.findAll", query = "SELECT v FROM VFrDiariaCategoria v"),
    @NamedQuery(name = "VFrDiariaCategoria.findById", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.id = :id"),
    @NamedQuery(name = "VFrDiariaCategoria.findByPrefeitura", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.prefeitura = :prefeitura"),
    @NamedQuery(name = "VFrDiariaCategoria.findByCnpj", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "VFrDiariaCategoria.findByPrefeituraDescricao", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.prefeituraDescricao = :prefeituraDescricao"),
    @NamedQuery(name = "VFrDiariaCategoria.findByEndereco", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VFrDiariaCategoria.findByBairro", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "VFrDiariaCategoria.findByCep", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.cep = :cep"),
    @NamedQuery(name = "VFrDiariaCategoria.findByCidade", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VFrDiariaCategoria.findByUf", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.uf = :uf"),
    @NamedQuery(name = "VFrDiariaCategoria.findByFone", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.fone = :fone"),
    @NamedQuery(name = "VFrDiariaCategoria.findByLogo", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.logo = :logo"),
    @NamedQuery(name = "VFrDiariaCategoria.findByVeiculo", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.veiculo = :veiculo"),
    @NamedQuery(name = "VFrDiariaCategoria.findByPrefeituraVeiculo", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.prefeituraVeiculo = :prefeituraVeiculo"),
    @NamedQuery(name = "VFrDiariaCategoria.findByPlaca", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.placa = :placa"),
    @NamedQuery(name = "VFrDiariaCategoria.findByVeiculoDescricao", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.veiculoDescricao = :veiculoDescricao"),
    @NamedQuery(name = "VFrDiariaCategoria.findByMarca", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.marca = :marca"),
    @NamedQuery(name = "VFrDiariaCategoria.findByAquisicao", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.aquisicao = :aquisicao"),
    @NamedQuery(name = "VFrDiariaCategoria.findByPotencia", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.potencia = :potencia"),
    @NamedQuery(name = "VFrDiariaCategoria.findByAno", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.ano = :ano"),
    @NamedQuery(name = "VFrDiariaCategoria.findByNf", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.nf = :nf"),
    @NamedQuery(name = "VFrDiariaCategoria.findByCilindradas", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.cilindradas = :cilindradas"),
    @NamedQuery(name = "VFrDiariaCategoria.findByVeiculoCombustivel", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.veiculoCombustivel = :veiculoCombustivel"),
    @NamedQuery(name = "VFrDiariaCategoria.findByCodigo", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VFrDiariaCategoria.findByDescricao", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VFrDiariaCategoria.findByUnidade", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.unidade = :unidade"),
    @NamedQuery(name = "VFrDiariaCategoria.findByLotado", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.lotado = :lotado"),
    @NamedQuery(name = "VFrDiariaCategoria.findByRenavam", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.renavam = :renavam"),
    @NamedQuery(name = "VFrDiariaCategoria.findByCategoria", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "VFrDiariaCategoria.findByData", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.data = :data"),
    @NamedQuery(name = "VFrDiariaCategoria.findByKmInicial", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.kmInicial = :kmInicial"),
    @NamedQuery(name = "VFrDiariaCategoria.findByKmFinal", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.kmFinal = :kmFinal"),
    @NamedQuery(name = "VFrDiariaCategoria.findByUsuario", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.usuario = :usuario"),
    @NamedQuery(name = "VFrDiariaCategoria.findByObs", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.obs = :obs"),
    @NamedQuery(name = "VFrDiariaCategoria.findByCombustivel", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.combustivel = :combustivel"),
    @NamedQuery(name = "VFrDiariaCategoria.findByPneu", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.pneu = :pneu"),
    @NamedQuery(name = "VFrDiariaCategoria.findByPeca", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.peca = :peca"),
    @NamedQuery(name = "VFrDiariaCategoria.findByServico", query = "SELECT v FROM VFrDiariaCategoria v WHERE v.servico = :servico")})
public class VFrDiariaCategoria implements Serializable {
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
    @Column(name = "Veiculo")
    private int veiculo;
    @Column(name = "PrefeituraVeiculo")
    private Integer prefeituraVeiculo;
    @Column(name = "Placa")
    private String placa;
    @Column(name = "VeiculoDescricao")
    private String veiculoDescricao;
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
    @Column(name = "VeiculoCombustivel")
    private Integer veiculoCombustivel;
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "Descricao")
    private String descricao;
    @Column(name = "Unidade")
    private String unidade;
    @Column(name = "Lotado")
    private String lotado;
    @Column(name = "Renavam")
    private String renavam;
    @Column(name = "Categoria")
    private Integer categoria;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "KmInicial")
    private Integer kmInicial;
    @Column(name = "KmFinal")
    private Integer kmFinal;
    @Basic(optional = false)
    @Column(name = "Usuario")
    private int usuario;
    @Column(name = "OBS")
    private String obs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Combustivel")
    private Double combustivel;
    @Column(name = "Pneu")
    private Double pneu;
    @Column(name = "Peca")
    private Double peca;
    @Column(name = "Servico")
    private Double servico;

    public VFrDiariaCategoria() {
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

    public int getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(int veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getPrefeituraVeiculo() {
        return prefeituraVeiculo;
    }

    public void setPrefeituraVeiculo(Integer prefeituraVeiculo) {
        this.prefeituraVeiculo = prefeituraVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVeiculoDescricao() {
        return veiculoDescricao;
    }

    public void setVeiculoDescricao(String veiculoDescricao) {
        this.veiculoDescricao = veiculoDescricao;
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

    public Integer getVeiculoCombustivel() {
        return veiculoCombustivel;
    }

    public void setVeiculoCombustivel(Integer veiculoCombustivel) {
        this.veiculoCombustivel = veiculoCombustivel;
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

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Double combustivel) {
        this.combustivel = combustivel;
    }

    public Double getPneu() {
        return pneu;
    }

    public void setPneu(Double pneu) {
        this.pneu = pneu;
    }

    public Double getPeca() {
        return peca;
    }

    public void setPeca(Double peca) {
        this.peca = peca;
    }

    public Double getServico() {
        return servico;
    }

    public void setServico(Double servico) {
        this.servico = servico;
    }
    
}
