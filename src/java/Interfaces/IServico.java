package Interfaces;

import Dados.Banco;
import Dados.FrServicos;
import View.VFrServicos;
import java.util.List;
import java.util.logging.Logger;

public class IServico {
    
    public FrServicos Salvar(FrServicos frServicos){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();
            
            if (frServicos.getId().equals(0)){
                banco.Acesso().persist(frServicos);
            } else {
                banco.Acesso().merge(frServicos);
            }
            
            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
        
        return frServicos;
    }
    
    public FrServicos Consultar(String opcao){
        
        Banco banco = Banco.getInstance();
        
        FrServicos frServicos = null;
        
        try{
            
            frServicos = banco.Acesso()
                .createNamedQuery("FrServicos.findById", FrServicos.class)
                .setParameter("id", opcao)
                .getSingleResult();
                    
        } catch (Exception e) {
            Logger.getGlobal().info(e.toString());
        }
        
        return frServicos;
    }
    
    public List<FrServicos> Listar(String opcao){
        
        List<FrServicos> frServicoses = null;
        
        String script = " SELECT ID, VeiculoPrefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP,Cidade, UF, Fone"
                + ", Logo, Veiculo, Marca, Aquisicao, Potencia, Ano, NF, Cilindradas, Combustivel, Prefeitura, PecasCategoria"
                + ", Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Placa, DiariaId, iariaPrefeitura, DiariaVeiculo"
                + ", Data, KmInicial, KmFinal, Usuario, Matricula, UsuarioNome, email, UsuarioFone, Celular, Nivel, OBS"
                + ", Quantidade, PecaServico, PecaCategoria, PecaCodigo, PecaDescricao, PecaUnidade FROM v_fr_diaria  ";
        
        try{
            
            frServicoses = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, FrServicos.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return frServicoses;
    }
    
    public List<VFrServicos> ListarView(String opcao){
        
        List<VFrServicos> vFrServicoses = null;
        
        String script = " SELECT ID, VeiculoPrefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP,Cidade, UF, Fone"
                + ", Logo, Veiculo, Marca, Aquisicao, Potencia, Ano, NF, Cilindradas, Combustivel, Prefeitura, PecasCategoria"
                + ", Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Placa, DiariaId, iariaPrefeitura, DiariaVeiculo"
                + ", Data, KmInicial, KmFinal, Usuario, Matricula, UsuarioNome, email, UsuarioFone, Celular, Nivel, OBS"
                + ", Quantidade, PecaServico, PecaCategoria, PecaCodigo, PecaDescricao, PecaUnidade FROM v_fr_diaria  ";
        
        try{
            
            vFrServicoses = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, FrServicos.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return vFrServicoses;
    }
  
    public String MontarDropDown(int selecionado, String opcao) {
              
        List<FrServicos> frServicoss = Listar(" WHERE 1=1 " + opcao);

        String menu = "";
        
        for ( int i = 0 ; i < frServicoss.size(); i++){
            if (selecionado == frServicoss.get(i).getId()){
                menu += "<option value='" + frServicoss.get(i).getId() + "' selected>" + frServicoss.get(i).getPeca().getDescricao() + "</option>" ;
            } else {
                menu += "<option value='" + frServicoss.get(i).getId() + "'>" + frServicoss.get(i).getPeca().getDescricao()+ "</option>" ;
            }
        }
        return menu;
    }
    
    public void Excluir(FrServicos frServicos){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();

            banco.Acesso().remove(frServicos);

            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
    }
}