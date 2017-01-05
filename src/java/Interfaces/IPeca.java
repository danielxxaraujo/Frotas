package Interfaces;

import Dados.Banco;
import Dados.FrPecas;
import View.VFrPecas;
import java.util.List;
import java.util.logging.Logger;

public class IPeca {
    
    public FrPecas Salvar(FrPecas frPecas){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();
            
            if (frPecas.getId().equals(0)){
                banco.Acesso().persist(frPecas);
            } else {
                banco.Acesso().merge(frPecas);
            }
            
            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
        
        return frPecas;
    }
    
    public FrPecas Consultar(String opcao){
        
        Banco banco = Banco.getInstance();
        
        FrPecas frPecas = null;
        
        try{
            
            frPecas = banco.Acesso()
                .createNamedQuery("FrPecas.findById", FrPecas.class)
                .setParameter("id", Integer.parseInt(opcao))
                .getSingleResult();
                    
        } catch (Exception e) {
            Logger.getGlobal().info(e.toString());
        }
        
        return frPecas;
    }
    
    public List<FrPecas> Listar(String opcao){
        
        List<FrPecas> frPecases = null;
        
        String script = " SELECT ID, Prefeitura, Categoria, Codigo, Descricao, Unidade FROM fr_pecas ";
        
        try{
            
            frPecases = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, FrPecas.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return frPecases;
    }
    
    public List<VFrPecas> ListarView(String opcao){
        
        List<VFrPecas> vFrPecases = null;
        
        String script = " SELECT ID, Prefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP, Cidade, UF, Fone, Logo"
                + ", Categoria, Codigo, Descricao, Unidade FROM v_fr_pecas ";
        
        try{
            
            vFrPecases = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, VFrPecas.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return vFrPecases;
    }
    
    public String MontarDropDown(int selecionado, String opcao) {
              
        List<FrPecas> frPecass = Listar(opcao);

        String menu = "";
        
        for ( int i = 0 ; i < frPecass.size(); i++){
            if (selecionado == frPecass.get(i).getId()){
                menu += "<option value='" + frPecass.get(i).getId() + "' selected>" + frPecass.get(i).getDescricao() + "</option>" ;
            } else {
                menu += "<option value='" + frPecass.get(i).getId() + "'>" + frPecass.get(i).getDescricao()+ "</option>" ;
            }
        }
        return menu;
    }
    
    public void Excluir(FrPecas frPecas){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();

            banco.Acesso().remove(frPecas);

            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
    }
}