package Dados;

import Dados.FrPrefeitura;
import Dados.FrServicos;
import Dados.FrTrajeto;
import Dados.FrUsuario;
import Dados.FrVeiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrDiaria.class)
public class FrDiaria_ { 

    public static volatile SingularAttribute<FrDiaria, FrVeiculo> veiculo;
    public static volatile SingularAttribute<FrDiaria, String> obs;
    public static volatile SingularAttribute<FrDiaria, Integer> kmFinal;
    public static volatile SingularAttribute<FrDiaria, FrPrefeitura> prefeitura;
    public static volatile SingularAttribute<FrDiaria, Date> data;
    public static volatile SingularAttribute<FrDiaria, FrUsuario> usuario;
    public static volatile SingularAttribute<FrDiaria, Integer> id;
    public static volatile CollectionAttribute<FrDiaria, FrTrajeto> frTrajetoCollection;
    public static volatile SingularAttribute<FrDiaria, Integer> kmInicial;
    public static volatile CollectionAttribute<FrDiaria, FrServicos> frServicosCollection;

}