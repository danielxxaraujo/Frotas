package Interfaces;

import Dados.Banco;
import Dados.FrDiaria;
import View.VFrDiaria;
import View.VFrDiariaCategoria;
import View.VFrUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class IDiaria {
    
    public FrDiaria Salvar(FrDiaria frDiaria){
        
        Banco banco = Banco.getInstance();
        
        try{
            
            banco.Acesso().getTransaction().begin();
            
            if (frDiaria.getId().equals(0)){
                banco.Acesso().persist(frDiaria);
            } else {
                banco.Acesso().merge(frDiaria);
            }
            
            banco.Acesso().flush();
            
        } catch (Exception ex) {
            Logger.getGlobal().info(ex.toString());
        } finally {
            banco.Acesso().getTransaction().commit();
        }
        
        return frDiaria;
    }
    
    public FrDiaria Consultar(String opcao){
        
        FrDiaria frDiaria = null;
                        
        try{
            
            frDiaria = Banco.getInstance().Acesso()
                .createNamedQuery("FrDiaria.findById", FrDiaria.class)
                .setParameter("id", Integer.parseInt(opcao))
                .getSingleResult();
                    
        } catch (Exception e) {
            Logger.getGlobal().info(e.toString());
        }
        
        return frDiaria;
    }
    
    public FrDiaria Procurar(String opcao){
        
        FrDiaria frDiaria = new FrDiaria(0);
        
        String script = " SELECT ID, Prefeitura, Veiculo, Data, KmInicial, KmFinal, Usuario, OBS FROM fr_diaria " + opcao;
        
        try{
            
            List<FrDiaria> frDiarias = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, FrDiaria.class)
                    .getResultList();
            
            if (frDiarias.size() > 0)
                frDiaria = frDiarias.get(0);
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return frDiaria;
    }
    
    public List<VFrDiaria> Listar(String opcao){
        
        List<VFrDiaria> vFrDiarias = null;
        
        String script = " SELECT ID, VeiculoPrefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP,Cidade, UF, Fone"
                + ", Logo, Veiculo, Marca, Aquisicao, Potencia, Ano, NF, Cilindradas, Combustivel, Prefeitura, PecasCategoria"
                + ", Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Placa, DiariaId, iariaPrefeitura, DiariaVeiculo"
                + ", Data, KmInicial, KmFinal, Usuario, Matricula, UsuarioNome, email, UsuarioFone, Celular, Nivel, OBS"
                + ", Quantidade, PecaServico, PecaCategoria, PecaCodigo, PecaDescricao, PecaUnidade FROM v_fr_diaria  ";
        
        try{
            
            vFrDiarias = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(script, VFrUsuario.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return vFrDiarias;
    }
    
    public List<VFrDiaria> ListarView(String opcao, String prefeitura){
        
        List<VFrDiaria> vFrDiarias = new ArrayList<VFrDiaria>();
        
            String sql = 
                
                  " SELECT ID, VeiculoPrefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP, Cidade, UF, Fone"
                + ", Logo, Veiculo, Marca, Aquisicao, Potencia, Ano, NF, Cilindradas, Combustivel, Prefeitura"
                + ", PecasCategoria, Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Placa, DiariaId, DiariaPrefeitura"
                + ", DiariaVeiculo, Data, KmInicial, KmFinal, Usuario, Matricula, UsuarioNome, email, UsuarioFone, Celular"
                + ", Nivel, OBS, Quantidade, PecaServico, PecaCategoria, PecaCodigo, PecaDescricao, PecaUnidade "
                + " FROM v_fr_veiculo WHERE id not in (SELECT id FROM v_fr_diaria "+ opcao +")"+ prefeitura 
                + " union "
                + " SELECT ID, VeiculoPrefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP, Cidade, UF, Fone"
                + ", Logo, Veiculo, Marca, Aquisicao, Potencia, Ano, NF, Cilindradas, Combustivel, Prefeitura"
                + ", PecasCategoria, Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Placa, DiariaId, DiariaPrefeitura"
                + ", DiariaVeiculo, Data, KmInicial, KmFinal, Usuario, Matricula, UsuarioNome, email, UsuarioFone, Celular"
                + ", Nivel, OBS, Quantidade, PecaServico, PecaCategoria, PecaCodigo, PecaDescricao, PecaUnidade "
                + " FROM v_fr_diaria " + opcao + " ORDER BY ID  " ; 
        
        try{
            
            vFrDiarias = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(sql, VFrDiaria.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return vFrDiarias;
    }
    
    public List<VFrDiariaCategoria> DiariaCategoriaView(String opcao, boolean total){
        
        List<VFrDiariaCategoria> vFrDiariaCategorias = new ArrayList<VFrDiariaCategoria>();
        
        try{
            
            String sql = "";
            
            if (total)
                sql = " SELECT ID, Prefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP, Cidade, UF, Fone, Logo"
                    + ", Veiculo, PrefeituraVeiculo, Placa, VeiculoDescricao, Marca, Aquisicao, Potencia, Ano, NF"
                    + ", Cilindradas, VeiculoCombustivel, Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Data"
                    + ", MIN(KmInicial) KmInicial, MAX(KmFinal) KmFinal, Usuario, OBS, SUM(Combustivel) Combustivel, SUM(Pneu) Pneu, SUM(Peca) Peca"
                     + ", SUM(Servico) Servico "
                    + "FROM v_fr_diaria_categoria " + opcao +" ORDER BY Data ";
            else 
                
                sql = " SELECT ID, Prefeitura, CNPJ, PrefeituraDescricao, Endereco, Bairro, CEP, Cidade, UF, Fone, Logo"
                    + ", Veiculo, PrefeituraVeiculo, Placa, VeiculoDescricao, Marca, Aquisicao, Potencia, Ano, NF"
                    + ", Cilindradas, VeiculoCombustivel, Codigo, Descricao, Unidade, Lotado, Renavam, Categoria, Data"
                    + ", KmInicial, KmFinal, Usuario, OBS, Combustivel, Pneu, Peca, Servico "
                        + "FROM v_fr_diaria_categoria " + opcao +" ORDER BY Data ";
        
        
            
            vFrDiariaCategorias = Banco
                    .getInstance()
                    .Acesso()
                    .createNativeQuery(sql, VFrUsuario.class)
                    .getResultList();
            
        } catch (Exception ex){
            Logger.getGlobal().info(ex.toString());
        }
        
        return vFrDiariaCategorias;
    }
}