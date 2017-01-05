package Dados;

import Dados.FrDiaria;
import Dados.FrPecas;
import Dados.FrPrefeitura;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrServicos.class)
public class FrServicos_ { 

    public static volatile SingularAttribute<FrServicos, FrPrefeitura> prefeitura;
    public static volatile SingularAttribute<FrServicos, FrDiaria> diaria;
    public static volatile SingularAttribute<FrServicos, FrPecas> peca;
    public static volatile SingularAttribute<FrServicos, Integer> id;
    public static volatile SingularAttribute<FrServicos, Float> quantidade;

}