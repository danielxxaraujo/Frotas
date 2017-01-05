package Dados;

import Dados.FrDiaria;
import Dados.FrPecas;
import Dados.FrPrefeitura;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T16:05:04")
@StaticMetamodel(FrVeiculo.class)
public class FrVeiculo_ { 

    public static volatile SingularAttribute<FrVeiculo, String> veiculo;
    public static volatile SingularAttribute<FrVeiculo, String> ano;
    public static volatile SingularAttribute<FrVeiculo, FrPecas> combustivel;
    public static volatile SingularAttribute<FrVeiculo, String> lotado;
    public static volatile SingularAttribute<FrVeiculo, String> renavam;
    public static volatile SingularAttribute<FrVeiculo, Integer> categoria;
    public static volatile CollectionAttribute<FrVeiculo, FrDiaria> frDiariaCollection;
    public static volatile SingularAttribute<FrVeiculo, Date> aquisicao;
    public static volatile SingularAttribute<FrVeiculo, String> marca;
    public static volatile SingularAttribute<FrVeiculo, String> potencia;
    public static volatile SingularAttribute<FrVeiculo, FrPrefeitura> prefeitura;
    public static volatile SingularAttribute<FrVeiculo, String> nf;
    public static volatile SingularAttribute<FrVeiculo, Integer> id;
    public static volatile SingularAttribute<FrVeiculo, String> cilindradas;
    public static volatile SingularAttribute<FrVeiculo, String> placa;

}