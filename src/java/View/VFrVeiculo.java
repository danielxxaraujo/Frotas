package View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "v_fr_veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VFrVeiculo.findAll", query = "SELECT v FROM VFrVeiculo v"),
    @NamedQuery(name = "VFrVeiculo.findById", query = "SELECT v FROM VFrVeiculo v WHERE v.id = :id"),
    @NamedQuery(name = "VFrVeiculo.findByVeiculoPrefeitura", query = "SELECT v FROM VFrVeiculo v WHERE v.veiculoPrefeitura = :veiculoPrefeitura"),
    @NamedQuery(name = "VFrVeiculo.findByCnpj", query = "SELECT v FROM VFrVeiculo v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "VFrVeiculo.findByPrefeituraDescricao", query = "SELECT v FROM VFrVeiculo v WHERE v.prefeituraDescricao = :prefeituraDescricao"),
    @NamedQuery(name = "VFrVeiculo.findByEndereco", query = "SELECT v FROM VFrVeiculo v WHERE v.endereco = :endereco"),
    @NamedQuery(name = "VFrVeiculo.findByBairro", query = "SELECT v FROM VFrVeiculo v WHERE v.bairro = :bairro"),
    @NamedQuery(name = "VFrVeiculo.findByCep", query = "SELECT v FROM VFrVeiculo v WHERE v.cep = :cep"),
    @NamedQuery(name = "VFrVeiculo.findByCidade", query = "SELECT v FROM VFrVeiculo v WHERE v.cidade = :cidade"),
    @NamedQuery(name = "VFrVeiculo.findByUf", query = "SELECT v FROM VFrVeiculo v WHERE v.uf = :uf"),
    @NamedQuery(name = "VFrVeiculo.findByFone", query = "SELECT v FROM VFrVeiculo v WHERE v.fone = :fone"),
    @NamedQuery(name = "VFrVeiculo.findByLogo", query = "SELECT v FROM VFrVeiculo v WHERE v.logo = :logo"),
    @NamedQuery(name = "VFrVeiculo.findByVeiculo", query = "SELECT v FROM VFrVeiculo v WHERE v.veiculo = :veiculo"),
    @NamedQuery(name = "VFrVeiculo.findByMarca", query = "SELECT v FROM VFrVeiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "VFrVeiculo.findByAquisicao", query = "SELECT v FROM VFrVeiculo v WHERE v.aquisicao = :aquisicao"),
    @NamedQuery(name = "VFrVeiculo.findByPotencia", query = "SELECT v FROM VFrVeiculo v WHERE v.potencia = :potencia"),
    @NamedQuery(name = "VFrVeiculo.findByAno", query = "SELECT v FROM VFrVeiculo v WHERE v.ano = :ano"),
    @NamedQuery(name = "VFrVeiculo.findByNf", query = "SELECT v FROM VFrVeiculo v WHERE v.nf = :nf"),
    @NamedQuery(name = "VFrVeiculo.findByCilindradas", query = "SELECT v FROM VFrVeiculo v WHERE v.cilindradas = :cilindradas"),
    @NamedQuery(name = "VFrVeiculo.findByCombustivel", query = "SELECT v FROM VFrVeiculo v WHERE v.combustivel = :combustivel"),
    @NamedQuery(name = "VFrVeiculo.findByPrefeitura", query = "SELECT v FROM VFrVeiculo v WHERE v.prefeitura = :prefeitura"),
    @NamedQuery(name = "VFrVeiculo.findByPecasCategoria", query = "SELECT v FROM VFrVeiculo v WHERE v.pecasCategoria = :pecasCategoria"),
    @NamedQuery(name = "VFrVeiculo.findByCodigo", query = "SELECT v FROM VFrVeiculo v WHERE v.codigo = :codigo"),
    @NamedQuery(name = "VFrVeiculo.findByDescricao", query = "SELECT v FROM VFrVeiculo v WHERE v.descricao = :descricao"),
    @NamedQuery(name = "VFrVeiculo.findByUnidade", query = "SELECT v FROM VFrVeiculo v WHERE v.unidade = :unidade"),
    @NamedQuery(name = "VFrVeiculo.findByLotado", query = "SELECT v FROM VFrVeiculo v WHERE v.lotado = :lotado"),
    @NamedQuery(name = "VFrVeiculo.findByRenavam", query = "SELECT v FROM VFrVeiculo v WHERE v.renavam = :renavam"),
    @NamedQuery(name = "VFrVeiculo.findByCategoria", query = "SELECT v FROM VFrVeiculo v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "VFrVeiculo.findByPlaca", query = "SELECT v FROM VFrVeiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "VFrVeiculo.findByMatricula", query = "SELECT v FROM VFrVeiculo v WHERE v.matricula = :matricula"),
    @NamedQuery(name = "VFrVeiculo.findByUsuarioNome", query = "SELECT v FROM VFrVeiculo v WHERE v.usuarioNome = :usuarioNome"),
    @NamedQuery(name = "VFrVeiculo.findByEmail", query = "SELECT v FROM VFrVeiculo v WHERE v.email = :email"),
    @NamedQuery(name = "VFrVeiculo.findByUsuarioFone", query = "SELECT v FROM VFrVeiculo v WHERE v.usuarioFone = :usuarioFone"),
    @NamedQuery(name = "VFrVeiculo.findByCelular", query = "SELECT v FROM VFrVeiculo v WHERE v.celular = :celular"),
    @NamedQuery(name = "VFrVeiculo.findByNivel", query = "SELECT v FROM VFrVeiculo v WHERE v.nivel = :nivel"),
    @NamedQuery(name = "VFrVeiculo.findByQuantidade", query = "SELECT v FROM VFrVeiculo v WHERE v.quantidade = :quantidade")})
public class VFrVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
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
    @Lob
    @Column(name = "DiariaId")
    private byte[] diariaId;
    @Lob
    @Column(name = "DiariaPrefeitura")
    private byte[] diariaPrefeitura;
    @Lob
    @Column(name = "DiariaVeiculo")
    private byte[] diariaVeiculo;
    @Lob
    @Column(name = "Data")
    private byte[] data;
    @Lob
    @Column(name = "KmInicial")
    private byte[] kmInicial;
    @Lob
    @Column(name = "KmFinal")
    private byte[] kmFinal;
    @Lob
    @Column(name = "Usuario")
    private byte[] usuario;
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
    @Lob
    @Column(name = "OBS")
    private byte[] obs;
    @Basic(optional = false)
    @Column(name = "Quantidade")
    private int quantidade;
    @Lob
    @Column(name = "PecaServico")
    private byte[] pecaServico;
    @Lob
    @Column(name = "PecaCategoria")
    private byte[] pecaCategoria;
    @Lob
    @Column(name = "PecaCodigo")
    private byte[] pecaCodigo;
    @Lob
    @Column(name = "PecaDescricao")
    private byte[] pecaDescricao;
    @Lob
    @Column(name = "PecaUnidade")
    private byte[] pecaUnidade;

    public VFrVeiculo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public byte[] getDiariaId() {
        return diariaId;
    }

    public void setDiariaId(byte[] diariaId) {
        this.diariaId = diariaId;
    }

    public byte[] getDiariaPrefeitura() {
        return diariaPrefeitura;
    }

    public void setDiariaPrefeitura(byte[] diariaPrefeitura) {
        this.diariaPrefeitura = diariaPrefeitura;
    }

    public byte[] getDiariaVeiculo() {
        return diariaVeiculo;
    }

    public void setDiariaVeiculo(byte[] diariaVeiculo) {
        this.diariaVeiculo = diariaVeiculo;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(byte[] kmInicial) {
        this.kmInicial = kmInicial;
    }

    public byte[] getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(byte[] kmFinal) {
        this.kmFinal = kmFinal;
    }

    public byte[] getUsuario() {
        return usuario;
    }

    public void setUsuario(byte[] usuario) {
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

    public byte[] getObs() {
        return obs;
    }

    public void setObs(byte[] obs) {
        this.obs = obs;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public byte[] getPecaServico() {
        return pecaServico;
    }

    public void setPecaServico(byte[] pecaServico) {
        this.pecaServico = pecaServico;
    }

    public byte[] getPecaCategoria() {
        return pecaCategoria;
    }

    public void setPecaCategoria(byte[] pecaCategoria) {
        this.pecaCategoria = pecaCategoria;
    }

    public byte[] getPecaCodigo() {
        return pecaCodigo;
    }

    public void setPecaCodigo(byte[] pecaCodigo) {
        this.pecaCodigo = pecaCodigo;
    }

    public byte[] getPecaDescricao() {
        return pecaDescricao;
    }

    public void setPecaDescricao(byte[] pecaDescricao) {
        this.pecaDescricao = pecaDescricao;
    }

    public byte[] getPecaUnidade() {
        return pecaUnidade;
    }

    public void setPecaUnidade(byte[] pecaUnidade) {
        this.pecaUnidade = pecaUnidade;
    }
    
}
