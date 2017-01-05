package Dados;

import Dados.FrDiaria;
import Dados.FrPrefeitura;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrUsuario.class)
public class FrUsuario_ { 

    public static volatile SingularAttribute<FrUsuario, String> categoria;
    public static volatile CollectionAttribute<FrUsuario, FrDiaria> frDiariaCollection;
    public static volatile SingularAttribute<FrUsuario, String> nome;
    public static volatile SingularAttribute<FrUsuario, Date> validade;
    public static volatile SingularAttribute<FrUsuario, String> fone;
    public static volatile SingularAttribute<FrUsuario, String> senha;
    public static volatile SingularAttribute<FrUsuario, FrPrefeitura> prefeitura;
    public static volatile SingularAttribute<FrUsuario, String> matricula;
    public static volatile SingularAttribute<FrUsuario, String> celular;
    public static volatile SingularAttribute<FrUsuario, Integer> id;
    public static volatile SingularAttribute<FrUsuario, String> cnh;
    public static volatile SingularAttribute<FrUsuario, Integer> nivel;
    public static volatile SingularAttribute<FrUsuario, String> email;

}