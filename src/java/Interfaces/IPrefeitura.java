package Interfaces;

import Dados.Banco;
import Dados.FrPrefeitura;
import java.util.List;
import java.util.logging.Logger;

public class IPrefeitura {
    
    public FrPrefeitura Salvar(FrPrefeitura frPrefeitura){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();
            
            if (frPrefeitura.getId().equals(0)){
                banco.Acesso().persist(frPrefeitura);
            } else {
                banco.Acesso().merge(frPrefeitura);
            }
            
            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
        
        return frPrefeitura;
    }
    
    public FrPrefeitura Consultar(String opcao){
        
        FrPrefeitura frPrefeitura = null;
        
        try{
            
            frPrefeitura = Banco
                .getInstance()
                .Acesso()
                .createNamedQuery("FrPrefeitura.findById", FrPrefeitura.class)
                .setParameter("id", Integer.parseInt(opcao))
                .getSingleResult();
                    
        } catch (Exception e) {
            Logger.getGlobal().info(e.toString());
        }
        
        return frPrefeitura;
    }
    
    public List<FrPrefeitura> Listar(String opcao){
        
        List<FrPrefeitura> frPrefeituraes = null;
        
        String script = " SELECT ID,CNPJ, Descricao, Endereco, Bairro, CEP, Cidade, UF, Fone, Logo FROM fr_prefeitura ";
        
        try{
            
            frPrefeituraes = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, FrPrefeitura.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return frPrefeituraes;
    }
  
    public String MontarDropDown(int selecionado, String opcao) {
              
        List<FrPrefeitura> frPrefeituras = Listar(opcao);

        String menu = "";
        
        for ( int i = 0 ; i < frPrefeituras.size(); i++){
            if (selecionado == frPrefeituras.get(i).getId()){
                menu += "<option value='" + frPrefeituras.get(i).getId() + "' selected>" + frPrefeituras.get(i).getDescricao() + "</option>" ;
            } else {
                menu += "<option value='" + frPrefeituras.get(i).getId() + "'>" + frPrefeituras.get(i).getDescricao()+ "</option>" ;
            }
        }
        return menu;
    }
    
    public void Excluir(FrPrefeitura frPrefeitura){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();

            banco.Acesso().remove(frPrefeitura);

            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
    }
    
}