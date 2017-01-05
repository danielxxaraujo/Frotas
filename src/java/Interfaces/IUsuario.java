package Interfaces;

import Dados.Banco;
import Dados.FrUsuario;
import View.VFrUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class IUsuario {
   
    public FrUsuario Salvar(FrUsuario frUsuario){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();
            
            if (frUsuario.getId().equals(0)){
                banco.Acesso().persist(frUsuario);
            } else {
                banco.Acesso().merge(frUsuario);
            }
            
            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
        
        return frUsuario;
    }
    
    public FrUsuario ConsultarEmail(String opcao){
        
        Banco banco = Banco.getInstance();
        
        FrUsuario frUsuario = null;
        
        try{
            
            frUsuario = banco.Acesso()
                .createNamedQuery("FrUsuario.findByEmail", FrUsuario.class)
                .setParameter("email", opcao)
                .getSingleResult();
                    
        } catch (Exception e) {
            Logger.getGlobal().info(e.toString());
        }
        
        return frUsuario;
    }
    
    public FrUsuario ConsultarMatricula(String opcao){
                
        Banco banco = Banco.getInstance();
        
        FrUsuario frUsuario = null;
        
        try{

            frUsuario = banco.Acesso()
                .createNamedQuery("FrUsuario.findByCodigo", FrUsuario.class)
                .setParameter("codigo", opcao)
                .getSingleResult();
                         
        } catch (Exception e) {
            Logger.getGlobal().info(">>>>>>> ConsultarMatricula:"+ opcao +"::::: " + e.toString());
        }
        return frUsuario;
    }
    
    public FrUsuario Consultar(String id){
        
        Banco banco = Banco.getInstance();
        
        FrUsuario frUsuario = null;
        
        try {
            
            frUsuario = 
                banco.Acesso()
                    .createNamedQuery("FrUsuario.findById", FrUsuario.class)
                    .setParameter("id", Integer.parseInt(id))
                    .getSingleResult();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        }
        
        return frUsuario;
    }
    
    public List<FrUsuario> Listar(String opcao){
        
        List<FrUsuario> frUsuarios = new ArrayList<FrUsuario>();
        
        String script = " SELECT  ID, Prefeitura, Matricula, Nome, CNH, Validade, Categoria, email, Fone, Celular, Nivel"
                + ", Senha FROM fr_usuario ";
        
        try{
            
            frUsuarios = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, FrUsuario.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return frUsuarios;
    }
    
    public List<VFrUsuario> ListarView(String opcao){
        
        List<VFrUsuario> vFrUsuarios = new ArrayList<VFrUsuario>();
        
        String script = " SELECT ID , Prefeitura, CNPJ, Descricao, Endereco, Bairro, CEP, Cidade, UF, PrefeituraFone, Logo"
                + ", Matricula, Nome, CNH, Validade, Categoria, email, Fone, Celular, Nivel FROM  v_fr_usuario ";
        
        try{
            
            vFrUsuarios = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, VFrUsuario.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return vFrUsuarios;
    }
    
    public String MontarDropDown(int selecionado, String opcao) {
              
        List<FrUsuario> frUsuarios = Listar(" WHERE 1=1 " + opcao);

        String menu = "";
        
        for ( int i = 0 ; i < frUsuarios.size(); i++){
            if (selecionado == frUsuarios.get(i).getId()){
                menu += "<option value='" + frUsuarios.get(i).getId() + "' selected>" + frUsuarios.get(i).getNome() + "</option>" ;
            } else {
                menu += "<option value='" + frUsuarios.get(i).getId() + "'>" + frUsuarios.get(i).getNome() + "</option>" ;
            }
        }
        return menu;
    }
    
    public void Excluir(FrUsuario frUsuario){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();

            banco.Acesso().remove(frUsuario);

            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
    }
}