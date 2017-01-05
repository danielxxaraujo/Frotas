package Dados;

import Dados.FrDiaria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrTrajeto.class)
public class FrTrajeto_ { 

    public static volatile SingularAttribute<FrTrajeto, Integer> kmFinal;
    public static volatile SingularAttribute<FrTrajeto, FrDiaria> diaria;
    public static volatile SingularAttribute<FrTrajeto, String> origem;
    public static volatile SingularAttribute<FrTrajeto, Integer> id;
    public static volatile SingularAttribute<FrTrajeto, String> destino;
    public static volatile SingularAttribute<FrTrajeto, Integer> kmInicial;

}