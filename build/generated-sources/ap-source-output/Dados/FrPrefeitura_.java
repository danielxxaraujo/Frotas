package Dados;

import Dados.FrDiaria;
import Dados.FrPecas;
import Dados.FrServicos;
import Dados.FrUsuario;
import Dados.FrValor;
import Dados.FrVeiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrPrefeitura.class)
public class FrPrefeitura_ { 

    public static volatile SingularAttribute<FrPrefeitura, String> cidade;
    public static volatile SingularAttribute<FrPrefeitura, String> endereco;
    public static volatile SingularAttribute<FrPrefeitura, String> bairro;
    public static volatile CollectionAttribute<FrPrefeitura, FrPecas> frPecasCollection;
    public static volatile CollectionAttribute<FrPrefeitura, FrDiaria> frDiariaCollection;
    public static volatile SingularAttribute<FrPrefeitura, String> cnpj;
    public static volatile SingularAttribute<FrPrefeitura, String> descricao;
    public static volatile SingularAttribute<FrPrefeitura, String> cep;
    public static volatile CollectionAttribute<FrPrefeitura, FrServicos> frServicosCollection;
    public static volatile SingularAttribute<FrPrefeitura, String> fone;
    public static volatile SingularAttribute<FrPrefeitura, String> uf;
    public static volatile CollectionAttribute<FrPrefeitura, FrValor> frValorCollection;
    public static volatile SingularAttribute<FrPrefeitura, String> logo;
    public static volatile SingularAttribute<FrPrefeitura, Integer> id;
    public static volatile CollectionAttribute<FrPrefeitura, FrVeiculo> frVeiculoCollection;
    public static volatile CollectionAttribute<FrPrefeitura, FrUsuario> frUsuarioCollection;

}