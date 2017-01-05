package Interfaces;

import Dados.FrPrefeitura;
import java.util.Calendar;

public class IMenu {
    
    public String Display(String ano, String mes) throws ClassNotFoundException{
        
        String texto = 
        
        "<ul id='css3menu1' class='topmenu'>" +
            "<li class='topfirst'><a href='htt://www.google.com.br' style='height:32px;line-height:32px;'>" +
                "<img src='CSS/internet.png' height='40px' width='40px'/>Sair</a></li>" +
            "<li class='topmenu'><a href='#' style='height:32px;line-height:32px;'>" +
                "<span><img src='CSS/calendario.png' height='40px' width='40px'/>|mes|/|ano|</span></a>|calendario|" +
            "<li class='topmenu'><a href='TDiariaListar' style='height:32px;line-height:32px;'>" +
                "<span><img src='CSS/veiculo.png' height='40px' width='40px'/>Informar Diária</span></a>" +
            "</li>" +
            "<li class='topmenu'><a href='#' style='height:32px;line-height:32px;'>" +
                "<span><img src='CSS/relweb.png' height='40px' width='40px'/>Relatórios</span></a>" +
                "<ul>" +
                    "<li><a href='TIndividualListar' style='height:32px;line-height:32px;'><img src='CSS/relatorio.png' height='40px' width='40px'/>Controle Individual</a></li>" +
                    "<li><a href='TKilometragem' style='height:32px;line-height:32px;'><img src='CSS/relatorio.png' height='40px' width='40px'/>Controle Kilometragem</a></li>" +
                    "<li><a href='TAbastecimento' style='height:32px;line-height:32px;'><img src='CSS/relatorio.png' height='40px' width='40px'/>Controle de Abastecimento</a></li>" +
                "</ul>" +                
            "</li>" +
            "<li class='toplast'><a href='#' style='height:32px;line-height:32px;'>" +
                "<img src='CSS/administrar2.png' height='40px' width='40px'/>Administração</a>" +
                "<ul>" +
                    "<li><a href='TPrefeituraListar' style='height:32px;line-height:32px;'><img src='CSS/prefeitura.png'height='40px' width='40px'/>Prefeitura</a></li>" +
                    "<li><a href='TUsuarioListar' style='height:32px;line-height:32px;'><img src='CSS/usuario.png' height='40px' width='40px'/>Usuário</a></li>" +
                    "<li><a href='TVeiculoListar' style='height:32px;line-height:32px;'><img src='CSS/veiculo.png' height='40px' width='40px'/>Veículo</a></li>" +
                    "<li><a href='TServicoListar' style='height:32px;line-height:32px;'><img src='CSS/servico.png' height='40px' width='40px'/>Serviços / Peças</a></li>" +
                "</ul>" +
            "</li>" +
        "</ul>";
        
        texto = Concatenar(texto, "mes", mes);
        texto = Concatenar(texto, "ano", ano);
        texto = Concatenar(texto, "calendario", DataMenu(ano, mes));
        
        return texto;
    }
    
    public String Concatenar(String xml, String campo, String valor) throws ClassNotFoundException{
        
        String resultado = "";
        
        String [] script = xml.split("\\|");
        
        for (int x = 0; x < script.length; x++){
            if (x % 2 == 0){
                resultado += script[x];
            } else {
                if (script[x].equals(campo)){
                    resultado += valor ;
                } else {
                    resultado += "|" + script[x] + "|";
                }
            }
        }
        return resultado;
    }
    
    public String DataMenu(String ano, String mes){
        
        String texto = "<ul>";
        int mes_inteiro = Integer.parseInt(mes);
        int ano_inteiro = Integer.parseInt(ano);
        
        if (mes_inteiro - 6 < 1){
            mes_inteiro = 12 - (6 - mes_inteiro);
            ano_inteiro --;
        } else {
            mes_inteiro -= 6;
        }
        
        for (int x=1; x < 12; x++){
            
            mes_inteiro ++;
            
            if (mes_inteiro > 12){
                mes_inteiro = 1;
                ano_inteiro ++;
            }
            texto += "	<li><a href='TFrotas?ano="+ ano_inteiro +"&mes="+String.format ("%02d", mes_inteiro)+"'>Referência: "+String.format ("%02d", mes_inteiro)+"/"+ ano_inteiro +"</a></li>";
        }
        return texto + "</ul></li>" ;
    }
    
    public String Ano(int anoSelecionado){
        
        String menu = "";
           
        for (int x = anoSelecionado -5 ; x <= anoSelecionado + 5; x++){
            
            if ( x == anoSelecionado){
                menu += "<option value='" + x + "' selected>" + x + "</option>" ;
            } else {
                menu += "<option value='" + x + "'>" + x + "</option>" ;
            }
        }
        return menu;
    }
    
    public String MesDescricao(int mes){
        
        String Mes[] = new String[13];
        
        Mes[1] = "Janeiro";
        Mes[2] = "Fevereiro";
        Mes[3] = "Março";
        Mes[4] = "Abril";
        Mes[5] = "Maio";
        Mes[6] = "Junho";
        Mes[7] = "Julho";
        Mes[8] = "Agosto";
        Mes[9] = "Setembro";
        Mes[10] = "Outubro";
        Mes[11] = "Novembro";
        Mes[12] = "Dezembro";
        
        return Mes[mes];
    }
    
    public String Categoria(int categoria){
        
        String menu[] = new String[4];
        String texto = "";
       
        menu[0] = "Combustivel";
        menu[1] = "Pneu";
        menu[2] = "Peça";
        menu[3] = "Serviço";
           
        for (int x = 0; x <= menu.length -1; x++){
            
            if ( x == categoria){
                texto += "<option value='" + x + "' selected>" + menu[x] + "</option>" ;
            } else {
                texto += "<option value='" + x + "'>" + menu[x] + "</option>" ;
            }
        }
        return texto;
    }
    
    public String CategoriaDescricao(int categoria){
        
        String menu[] = new String[4];
       
        menu[0] = "Combustivel";
        menu[1] = "Pneu";
        menu[2] = "Peça";
        menu[3] = "Serviço";
        
        return menu[categoria];
    }
    
    public String CategoriaVeiculo(int categoria){
        
        String menu[] = new String[4];
        String texto = "";
       
        menu[0] = "Prefeitura";
        menu[1] = "Alugado";
        menu[2] = "Particular";
        menu[3] = "Sucata";
           
        for (int x = 0; x <= menu.length -1; x++){
            
            if ( x == categoria){
                texto += "<option value='" + x + "' selected>" + menu[x] + "</option>" ;
            } else {
                texto += "<option value='" + x + "'>" + menu[x] + "</option>" ;
            }
        }
        return texto;
    }
    
    public String CategoriaVeiculoDescricao(int categoria){
        
        String menu[] = new String[4];
      
        menu[0] = "Prefeitura";
        menu[1] = "Alugado";
        menu[2] = "Particular";
        menu[3] = "Sucata";

        return menu[categoria];
    } 
    
    public String Nivel(int nivel){
        
        String menu[] = new String[4];
        String texto = ""; 
        
        menu[0] = "Administrador";
        menu[1] = "Gerente";
        menu[2] = "Usuario";
        menu[3] = "Motorista";
           
        for (int x = 0; x <= menu.length -1; x++){
            
            if ( x == nivel){
                texto += "<option value='" + x + "' selected>" + menu[x] + "</option>" ;
            } else {
                texto += "<option value='" + x + "'>" + menu[x] + "</option>" ;
            }
        }
        return texto;
    }
    
    public String NivelDescricao(int nivel){
        String menu[] = new String[4];
        
        menu[0] = "Administrador";
        menu[1] = "Gerente";
        menu[2] = "Usuario";
        menu[3] = "Motorista";
        
        return menu[nivel];
    }
    
    public String Cabecalho(String prefeitura){
        
        String texto =
        
              "    <head>"
            + "        <link rel='stylesheet' href='style.css' type='text/css'>"
            + "        <link rel='stylesheet' href='CSS/style.css' type='text/css' />"
            + "        <link rel='stylesheet' href='tcal.css' type='text/css' />"
            + "        <script type='text/javascript' src='tcal.js'></script>"
            + "         <script type='text/javascript' src='fecharConexao.js'></script>"
            + "        <meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>"
            + "        <title>..:: WEB Frotas ::..</title>"
            + "    </head>"
            + "    <body>";
            
        if (!prefeitura.isEmpty()){
        texto +=
             "        <div class='cabecalho'>"
            + "             <table border=0 width=100%>"
            + "                 <tr><td rowspan='2'>"
            + "                         <img src='imagens/brasil.png' height=50px width=50px></td>"
            + "                     <td style='font-size: 18px; text-align: center;'>..:: Sistema de Controle de Fotas - Web Frotas::..</td></tr>"
            + "                 <tr><td style='font-size: 12px; text-align: center;'><b>"+ prefeitura +"<b></td></tr>"
            + "             </table>"                
            + "        </div>";                
        }            

        return texto;
    }
    
    public String RodaPe(boolean classe){
        Calendar cal = Calendar.getInstance();
        String ano = String.valueOf(cal.get(Calendar.YEAR));
            
        if(classe){
            return "<div class='rodape'><table border='0' width='100%'><tr><td style='text-align: left; font-size: 12px;'>"
                    + "Copyright &copy "+ ano +" - MADS.ti - Soluções em Tecnologia - Todos os direitos reservados.</td>"
                    + "<td style='text-align: right; font-size: 9px;'>versão 2.1.8</td><tr></table></div>";
        } else {
            return "<div><table border='0' width='100%' bgcolor='#BFBFBF'><tr><td style='text-align: left; font-size: 12px;'>"
                    + "Copyright &copy "+ ano +" - MADS.ti - Soluções em Tecnologia - Todos os direitos reservados.</td>"
                    + "<td style='text-align: right; font-size: 9px;'>versão 2.1.8</td><tr></table></div>";
        }
    }
}