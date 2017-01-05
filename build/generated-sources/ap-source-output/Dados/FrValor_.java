package Dados;

import Dados.FrPecas;
import Dados.FrPrefeitura;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrValor.class)
public class FrValor_ { 

    public static volatile SingularAttribute<FrValor, FrPrefeitura> prefeitura;
    public static volatile SingularAttribute<FrValor, Date> data;
    public static volatile SingularAttribute<FrValor, FrPecas> peca;
    public static volatile SingularAttribute<FrValor, Float> valor;
    public static volatile SingularAttribute<FrValor, Integer> id;

}