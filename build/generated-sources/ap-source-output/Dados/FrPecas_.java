package Dados;

import Dados.FrPrefeitura;
import Dados.FrServicos;
import Dados.FrValor;
import Dados.FrVeiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrPecas.class)
public class FrPecas_ { 

    public static volatile SingularAttribute<FrPecas, String> codigo;
    public static volatile SingularAttribute<FrPecas, FrPrefeitura> prefeitura;
    public static volatile SingularAttribute<FrPecas, Integer> categoria;
    public static volatile CollectionAttribute<FrPecas, FrValor> frValorCollection;
    public static volatile SingularAttribute<FrPecas, String> unidade;
    public static volatile SingularAttribute<FrPecas, Integer> id;
    public static volatile CollectionAttribute<FrPecas, FrVeiculo> frVeiculoCollection;
    public static volatile SingularAttribute<FrPecas, String> descricao;
    public static volatile CollectionAttribute<FrPecas, FrServicos> frServicosCollection;

}