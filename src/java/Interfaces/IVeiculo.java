package Interfaces;

import Dados.Banco;
import Dados.FrDiaria;
import Dados.FrVeiculo;
import View.VFrVeiculo;
import java.util.List;
import java.util.logging.Logger;

public class IVeiculo {
    
    public int Abrir(int veiculo, String data){
        
        int odometro = 0;
        
        FrDiaria frDiaria = new IDiaria().Procurar(" WHERE Data < '"+ data +"' AND Veiculo = '"+ veiculo +"' AND KmFinal is not NULL ORDER BY Veiculo, Data DESC LIMIT 1 ");
        
        if (frDiaria != null)
            odometro = frDiaria.getKmFinal();
         
        return odometro;
    }
    
    public FrVeiculo Salvar(FrVeiculo frVeiculo){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();
            
            if (frVeiculo.getId().equals(0)){
                banco.Acesso().persist(frVeiculo);
            } else {
                banco.Acesso().merge(frVeiculo);
            }
            
            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
        
        return frVeiculo;
    }
    
    public FrVeiculo Consultar(String opcao){
       
        FrVeiculo frVeiculo = null;
        
        try{
            
            frVeiculo = Banco
                .getInstance()
                .Acesso()
                .createNamedQuery("FrVeiculo.findById", FrVeiculo.class)
                .setParameter("id", Integer.parseInt(opcao))
                .getSingleResult();
                    
        } catch (Exception e) {
            Logger.getGlobal().info(e.toString());
        }
        
        return frVeiculo;
    }
    
    public List<FrVeiculo> Listar(String opcao){
        
        List<FrVeiculo> frVeiculoes = null;
        
        String script = " SELECT ID, Prefeitura, Placa, Veiculo, Marca, Aquisicao, Potencia, Ano, NF, Cilindradas, Combustivel"
                + ", Lotado, Renavam, Categoria FROM fr_veiculo " + opcao;
        
        try{
            
            frVeiculoes = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, FrVeiculo.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return frVeiculoes;
    }
    
    public List<VFrVeiculo> ListarView(String opcao){
        
        List<VFrVeiculo> vFrVeiculoes = null;
        
        String script = " SELECT ID, VeiculoPrefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP, Cidade, UF, Fone"
                + ", Logo, Veiculo, Marca, Aquisicao, Potencia, Ano, NF, Cilindradas, Combustivel, Prefeitura, PecasCategoria"
                + ", Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Placa, DiariaId, DiariaPrefeitura, DiariaVeiculo"
                + ", Data, KmInicial, KmFinal, Usuario, Matricula, UsuarioNome, email, UsuarioFone, Celular, Nivel, OBS"
                + ", Quantidade, PecaServico, PecaCategoria, PecaCodigo, PecaDescricao,PecaUnidade FROM v_fr_veiculo ";
        
        try{
            
            vFrVeiculoes = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, VFrVeiculo.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return vFrVeiculoes;
    }
    
    public String MontarDropDown(int selecionado, String opcao) {
              
        List<FrVeiculo> frVeiculos = Listar(" WHERE 1=1 " + opcao);

        String menu = "";
        
        for ( int i = 0 ; i < frVeiculos.size(); i++){
            if (selecionado == frVeiculos.get(i).getId()){
                menu += "<option value='" + frVeiculos.get(i).getId() + "' selected>" + frVeiculos.get(i).getVeiculo() + "</option>" ;
            } else {
                menu += "<option value='" + frVeiculos.get(i).getId() + "'>" + frVeiculos.get(i).getVeiculo()+ "</option>" ;
            }
        }
        return menu;
    }
    
    public void Excluir(FrVeiculo frVeiculo){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();

            banco.Acesso().remove(frVeiculo);

            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
    }
}