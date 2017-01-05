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
@Table(name = "v_fr_diaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFrDiaria.findAll", query = "SELECT v FROM VFrDiaria v"),
    @NamedQuery(name = "VFrDiaria.findById", query = "SELECT v FROM VFrDiaria v WHERE v.id = :id"),
    @NamedQuery(name = "VFrDiaria.findByVeiculoPrefeitura", query = "SELECT v FROM VFrDiaria v WHERE v.veiculoPrefeitura = :veiculoPrefeitura"),
    @NamedQuery(name = "VFrDiaria.findByCnpj", query = "SELECT v FROM VFrDiaria v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "VFrDiaria.findByPrefeituraDescricao", query = "SELECT v FROM VFrDiaria v WHERE v.prefeituraDescricao = :prefeituraDescricao"),
    @NamedQuery(name = "VFrDiaria.findByEndereco", query = "SELECT v FROM VFrDiaria v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VFrDiaria.findByBairro", query = "SELECT v FROM VFrDiaria v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "VFrDiaria.findByCep", query = "SELECT v FROM VFrDiaria v WHERE v.cep = :cep"),
    @NamedQuery(name = "VFrDiaria.findByCidade", query = "SELECT v FROM VFrDiaria v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VFrDiaria.findByUf", query = "SELECT v FROM VFrDiaria v WHERE v.uf = :uf"),
    @NamedQuery(name = "VFrDiaria.findByFone", query = "SELECT v FROM VFrDiaria v WHERE v.fone = :fone"),
    @NamedQuery(name = "VFrDiaria.findByLogo", query = "SELECT v FROM VFrDiaria v WHERE v.logo = :logo"),
    @NamedQuery(name = "VFrDiaria.findByVeiculo", query = "SELECT v FROM VFrDiaria v WHERE v.veiculo = :veiculo"),
    @NamedQuery(name = "VFrDiaria.findByMarca", query = "SELECT v FROM VFrDiaria v WHERE v.marca = :marca"),
    @NamedQuery(name = "VFrDiaria.findByAquisicao", query = "SELECT v FROM VFrDiaria v WHERE v.aquisicao = :aquisicao"),
    @NamedQuery(name = "VFrDiaria.findByPotencia", query = "SELECT v FROM VFrDiaria v WHERE v.potencia = :potencia"),
    @NamedQuery(name = "VFrDiaria.findByAno", query = "SELECT v FROM VFrDiaria v WHERE v.ano = :ano"),
    @NamedQuery(name = "VFrDiaria.findByNf", query = "SELECT v FROM VFrDiaria v WHERE v.nf = :nf"),
    @NamedQuery(name = "VFrDiaria.findByCilindradas", query = "SELECT v FROM VFrDiaria v WHERE v.cilindradas = :cilindradas"),
    @NamedQuery(name = "VFrDiaria.findByCombustivel", query = "SELECT v FROM VFrDiaria v WHERE v.combustivel = :combustivel"),
    @NamedQuery(name = "VFrDiaria.findByPrefeitura", query = "SELECT v FROM VFrDiaria v WHERE v.prefeitura = :prefeitura"),
    @NamedQuery(name = "VFrDiaria.findByPecasCategoria", query = "SELECT v FROM VFrDiaria v WHERE v.pecasCategoria = :pecasCategoria"),
    @NamedQuery(name = "VFrDiaria.findByCodigo", query = "SELECT v FROM VFrDiaria v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VFrDiaria.findByDescricao", query = "SELECT v FROM VFrDiaria v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VFrDiaria.findByUnidade", query = "SELECT v FROM VFrDiaria v WHERE v.unidade = :unidade"),
    @NamedQuery(name = "VFrDiaria.findByLotado", query = "SELECT v FROM VFrDiaria v WHERE v.lotado = :lotado"),
    @NamedQuery(name = "VFrDiaria.findByRenavam", query = "SELECT v FROM VFrDiaria v WHERE v.renavam = :renavam"),
    @NamedQuery(name = "VFrDiaria.findByCategoria", query = "SELECT v FROM VFrDiaria v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "VFrDiaria.findByPlaca", query = "SELECT v FROM VFrDiaria v WHERE v.placa = :placa"),
    @NamedQuery(name = "VFrDiaria.findByDiariaId", query = "SELECT v FROM VFrDiaria v WHERE v.diariaId = :diariaId"),
    @NamedQuery(name = "VFrDiaria.findByDiariaPrefeitura", query = "SELECT v FROM VFrDiaria v WHERE v.diariaPrefeitura = :diariaPrefeitura"),
    @NamedQuery(name = "VFrDiaria.findByDiariaVeiculo", query = "SELECT v FROM VFrDiaria v WHERE v.diariaVeiculo = :diariaVeiculo"),
    @NamedQuery(name = "VFrDiaria.findByData", query = "SELECT v FROM VFrDiaria v WHERE v.data = :data"),
    @NamedQuery(name = "VFrDiaria.findByKmInicial", query = "SELECT v FROM VFrDiaria v WHERE v.kmInicial = :kmInicial"),
    @NamedQuery(name = "VFrDiaria.findByKmFinal", query = "SELECT v FROM VFrDiaria v WHERE v.kmFinal = :kmFinal"),
    @NamedQuery(name = "VFrDiaria.findByUsuario", query = "SELECT v FROM VFrDiaria v WHERE v.usuario = :usuario"),
    @NamedQuery(name = "VFrDiaria.findByMatricula", query = "SELECT v FROM VFrDiaria v WHERE v.matricula = :matricula"),
    @NamedQuery(name = "VFrDiaria.findByUsuarioNome", query = "SELECT v FROM VFrDiaria v WHERE v.usuarioNome = :usuarioNome"),
    @NamedQuery(name = "VFrDiaria.findByEmail", query = "SELECT v FROM VFrDiaria v WHERE v.email = :email"),
    @NamedQuery(name = "VFrDiaria.findByUsuarioFone", query = "SELECT v FROM VFrDiaria v WHERE v.usuarioFone = :usuarioFone"),
    @NamedQuery(name = "VFrDiaria.findByCelular", query = "SELECT v FROM VFrDiaria v WHERE v.celular = :celular"),
    @NamedQuery(name = "VFrDiaria.findByNivel", query = "SELECT v FROM VFrDiaria v WHERE v.nivel = :nivel"),
    @NamedQuery(name = "VFrDiaria.findByObs", query = "SELECT v FROM VFrDiaria v WHERE v.obs = :obs"),
    @NamedQuery(name = "VFrDiaria.findByQuantidade", query = "SELECT v FROM VFrDiaria v WHERE v.quantidade = :quantidade"),
    @NamedQuery(name = "VFrDiaria.findByPecaServico", query = "SELECT v FROM VFrDiaria v WHERE v.pecaServico = :pecaServico"),
    @NamedQuery(name = "VFrDiaria.findByPecaCategoria", query = "SELECT v FROM VFrDiaria v WHERE v.pecaCategoria = :pecaCategoria"),
    @NamedQuery(name = "VFrDiaria.findByPecaCodigo", query = "SELECT v FROM VFrDiaria v WHERE v.pecaCodigo = :pecaCodigo"),
    @NamedQuery(name = "VFrDiaria.findByPecaDescricao", query = "SELECT v FROM VFrDiaria v WHERE v.pecaDescricao = :pecaDescricao"),
    @NamedQuery(name = "VFrDiaria.findByPecaUnidade", query = "SELECT v FROM VFrDiaria v WHERE v.pecaUnidade = :pecaUnidade")})
public class VFrDiaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "VeiculoPrefeitura")
    private int veiculoPrefeitura;
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
    @Column(name = "Veiculo")
    private String veiculo;
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
    @Basic(optional = false)
    @Column(name = "Combustivel")
    private int combustivel;
    @Column(name = "Prefeitura")
    private Integer prefeitura;
    @Column(name = "PecasCategoria")
    private Integer pecasCategoria;
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
    @Column(name = "Placa")
    private String placa;
    @Column(name = "DiariaId")
    private Integer diariaId;
    @Column(name = "DiariaPrefeitura")
    private Integer diariaPrefeitura;
    @Column(name = "DiariaVeiculo")
    private Integer diariaVeiculo;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "KmInicial")
    private Integer kmInicial;
    @Column(name = "KmFinal")
    private Integer kmFinal;
    @Column(name = "Usuario")
    private Integer usuario;
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "UsuarioNome")
    private String usuarioNome;
    @Column(name = "email")
    private String email;
    @Column(name = "UsuarioFone")
    private String usuarioFone;
    @Column(name = "Celular")
    private String celular;
    @Column(name = "Nivel")
    private Integer nivel;
    @Column(name = "OBS")
    private String obs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Quantidade")
    private Float quantidade;
    @Column(name = "PecaServico")
    private Integer pecaServico;
    @Column(name = "PecaCategoria")
    private Integer pecaCategoria;
    @Column(name = "PecaCodigo")
    private String pecaCodigo;
    @Column(name = "PecaDescricao")
    private String pecaDescricao;
    @Column(name = "PecaUnidade")
    private String pecaUnidade;

    public VFrDiaria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVeiculoPrefeitura() {
        return veiculoPrefeitura;
    }

    public void setVeiculoPrefeitura(int veiculoPrefeitura) {
        this.veiculoPrefeitura = veiculoPrefeitura;
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

    public int getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(int combustivel) {
        this.combustivel = combustivel;
    }

    public Integer getPrefeitura() {
        return prefeitura;
    }

    public void setPrefeitura(Integer prefeitura) {
        this.prefeitura = prefeitura;
    }

    public Integer getPecasCategoria() {
        return pecasCategoria;
    }

    public void setPecasCategoria(Integer pecasCategoria) {
        this.pecasCategoria = pecasCategoria;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getDiariaId() {
        return diariaId;
    }

    public void setDiariaId(Integer diariaId) {
        this.diariaId = diariaId;
    }

    public Integer getDiariaPrefeitura() {
        return diariaPrefeitura;
    }

    public void setDiariaPrefeitura(Integer diariaPrefeitura) {
        this.diariaPrefeitura = diariaPrefeitura;
    }

    public Integer getDiariaVeiculo() {
        return diariaVeiculo;
    }

    public void setDiariaVeiculo(Integer diariaVeiculo) {
        this.diariaVeiculo = diariaVeiculo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getKmInicial() {
        if (kmInicial == null) { kmInicial = 0; }
        return kmInicial;
    }

    public void setKmInicial(Integer kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Integer getKmFinal() {
        if (kmFinal == null) { kmFinal = 0; }
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuarioFone() {
        return usuarioFone;
    }

    public void setUsuarioFone(String usuarioFone) {
        this.usuarioFone = usuarioFone;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPecaServico() {
        return pecaServico;
    }

    public void setPecaServico(Integer pecaServico) {
        this.pecaServico = pecaServico;
    }

    public Integer getPecaCategoria() {
        return pecaCategoria;
    }

    public void setPecaCategoria(Integer pecaCategoria) {
        this.pecaCategoria = pecaCategoria;
    }

    public String getPecaCodigo() {
        return pecaCodigo;
    }

    public void setPecaCodigo(String pecaCodigo) {
        this.pecaCodigo = pecaCodigo;
    }

    public String getPecaDescricao() {
        return pecaDescricao;
    }

    public void setPecaDescricao(String pecaDescricao) {
        this.pecaDescricao = pecaDescricao;
    }

    public String getPecaUnidade() {
        return pecaUnidade;
    }

    public void setPecaUnidade(String pecaUnidade) {
        this.pecaUnidade = pecaUnidade;
    }
    
}
