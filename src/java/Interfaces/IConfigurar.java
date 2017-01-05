package Interfaces;

import Dados.FrPrefeitura;
import Dados.FrUsuario;

public class IConfigurar {
    
    public static FrUsuario usuarioAtivo;
    public static FrPrefeitura prefeituraAtiva;
    
    public IConfigurar(){
        
    }
    
    public boolean configurarUsuario(FrUsuario frUsuario){
        
        boolean status = false;
        
        if (frUsuario != null){
            usuarioAtivo = frUsuario;
            prefeituraAtiva = frUsuario.getPrefeitura();
        }
        
        return status;
    }
}
