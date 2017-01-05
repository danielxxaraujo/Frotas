package Telas;

import Dados.FrDiaria;
import Dados.FrServicos;
import Interfaces.IConfigurar;
import Interfaces.IDiaria;
import Interfaces.IMenu;
import Interfaces.IPeca;
import Interfaces.IPrefeitura;
import Interfaces.IServico;
import Interfaces.IUsuario;
import Interfaces.IVeiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TDiariaCadastrar", urlPatterns = {"/TDiariaCadastrar"})
public class TDiariaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        try {
                      
            HttpSession session = request.getSession();
            
            String usuario = "";
            String prefeitura = "";
            
            if (session.getAttribute("usuario") == null){
                response.sendRedirect("TUsuario");
            } else {
                usuario = IConfigurar.usuarioAtivo.getNome();
                prefeitura = IConfigurar.prefeituraAtiva.getDescricao();
            }
            
            Calendar cal = Calendar.getInstance();
           
            String ano = String.valueOf(cal.get(Calendar.YEAR));
            String mes = String.format ("%02d",cal.get(Calendar.MONTH) + 1);
                        
            if (request.getParameter("ano") != null && !request.getParameter("ano").isEmpty()) {
                ano = request.getParameter("ano");
                session.setAttribute("ano", ano);
            }
            else {
                if (session.getAttribute("ano") == null) {
                    session.setAttribute("ano", ano);
                }
                else
                    ano = session.getAttribute("ano").toString();
            }
            
            if (request.getParameter("mes") != null && !request.getParameter("mes").isEmpty()){
                mes = request.getParameter("mes");
                session.setAttribute("mes", mes);
            }
            else {
                if (session.getAttribute("mes") == null) {
                    session.setAttribute("mes", mes);
                }
                else 
                    mes = session.getAttribute("mes").toString();
            }
            
            String opcao = " WHERE 1=1 ";
            String opcaoPrefeitura = " WHERE 1=1 ";
            
            if (IConfigurar.usuarioAtivo.getNivel().equals(0)){
                
            } else {
                opcao += " AND Prefeitura =" + IConfigurar.usuarioAtivo.getPrefeitura().getId();
                opcaoPrefeitura += " AND ID=" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
            
            FrDiaria frDiaria = new FrDiaria(0);
            FrServicos frServicos = new FrServicos(0);
            
            if (request.getParameter("Alterar") != null && !request.getParameter("Alterar").isEmpty()){
                frDiaria = new IDiaria().Consultar(request.getParameter("Alterar"));
            } else {
                if (request.getParameter("ID") != null && !request.getParameter("ID").isEmpty()){
                    frDiaria.setId(Integer.parseInt(request.getParameter("ID")));
                }
                if (request.getParameter("Veiculo") != null && !request.getParameter("Veiculo").isEmpty()){
                    frDiaria.setVeiculo(new IVeiculo().Consultar(request.getParameter("Veiculo")));
                }
                if (request.getParameter("Data") != null && !request.getParameter("Data").isEmpty()){
                    frDiaria.setData(new java.sql.Date(sdf.parse(request.getParameter("Data")).getTime()));
                }
                if (request.getParameter("Abrir") != null && !request.getParameter("Abrir").isEmpty()){
                    frDiaria.setKmInicial(new IVeiculo().Abrir(frDiaria.getVeiculo().getId(), sdfBanco.format(frDiaria.getData())));
                }
                if (request.getParameter("Kminicial") != null && !request.getParameter("Kminicial").isEmpty()){
                    frDiaria.setKmInicial(Integer.parseInt(request.getParameter("Kminicial")));
                }
                if (request.getParameter("Kmfinal") != null && !request.getParameter("Kmfinal").isEmpty()){
                    frDiaria.setKmFinal(Integer.parseInt(request.getParameter("Kmfinal")));
                }
                if (request.getParameter("Obs") != null && !request.getParameter("Obs").isEmpty()){
                    frDiaria.setObs(request.getParameter("Obs"));
                }
                if (request.getParameter("Peca") != null && !request.getParameter("Peca").isEmpty()){
                    frServicos.setPeca(new IPeca().Consultar(request.getParameter("Peca")));
                }
                if (request.getParameter("Quantidade") != null && !request.getParameter("Quantidade").isEmpty()){
                    frServicos.setQuantidade(Float.parseFloat(request.getParameter("Quantidade")));
                }
            }
            
            if (request.getParameter("Salvar") != null && !request.getParameter("Salvar").isEmpty()){
                // Salva a KM final na ultima data informada na abertura do odometro.
//                frDiaria = (frDiaria);
                frDiaria.setPrefeitura(IConfigurar.prefeituraAtiva);
                frDiaria.setUsuario(IConfigurar.usuarioAtivo);
                frDiaria = new IDiaria().Salvar(frDiaria);
                
                frServicos.setDiaria(frDiaria);
                frServicos.setPrefeitura(IConfigurar.prefeituraAtiva);
                frServicos = new IServico().Salvar(frServicos);
                
                response.sendRedirect("TDiariaListar?Data=" + sdf.format(frDiaria.getData()));
            }

            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            out.println("           <form action='TDiariaCadastrar'>");
            out.println("           <table class='Cadastro' border=0 width=100%>");
            out.println("               <tr><th colspan=2 class='Titulo'>Módulo de Diária</th></tr>");
            out.println("               <tr>");
            out.println("                   <th width=40%>Prefeitura</th>");
            out.println("                   <td width=60%><select name='Prefeitura'>"+ new IPrefeitura().MontarDropDown(frDiaria.getPrefeitura().getId(), opcaoPrefeitura)+"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Veículo</th>");
            out.println("                   <td><select name='Veiculo'>"+ new IVeiculo().MontarDropDown(frDiaria.getVeiculo().getId(), "") +"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Data</th>");
            out.println("                   <td><input type='text' name='Data' value='"+ sdf.format(frDiaria.getData()) +"' class='tcal' size=9></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Km inicial</th>");
            out.println("                   <td><input type='text' name='Kminicial' value='"+ frDiaria.getKmInicial() +"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Km final</th>");
            out.println("                   <td><input type='text' name='Kmfinal' value='"+ frDiaria.getKmFinal() +"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Motorista</th>");
            out.println("                   <td><select name='Usuario'>"+ new IUsuario().MontarDropDown(frDiaria.getUsuario().getId(), "") +"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Combustível</th>");
            out.println("                   <td><select name='Peca'>"+ new IPeca().MontarDropDown(0, " AND Categoria=0") +"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Quantidade</th>");
            out.println("                   <td><input type='text' name='Quantidade' value='"+ frServicos.getQuantidade() +"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>OBS</th>");
            out.println("                   <td><textarea name='Obs' rows=4 cols=80>"+ frDiaria.getObs()+"</textarea></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th colspan=2 class='Titulo'><input type='submit' name='Salvar' value='Salvar'></th>");
            out.println("               </tr>");
            out.println("           </table>");
            if (frDiaria.getId() != null)
                out.println("           <input type='hidden' name='ID' value='"+ frDiaria.getId() +"'>");
            out.println("           </form>");
            out.println("        </div>");
            out.println(iMenu.RodaPe(true));
            out.println("    </body>");
            out.println("</html>");
           
        } catch (Exception e){
            Exception mensagemerro =  new RuntimeException(e);
            out.println("<Div>Erro: "+ mensagemerro.toString()+ "</div>");

        } finally {            
            out.close();
        }
    }

    private FrDiaria SalvarKMFinal(FrDiaria frDiaria) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        FrDiaria frDiariaFinal =  new IDiaria()
                .Procurar(" WHERE Data < '"+ sdf.format(frDiaria.getData()) 
                        +"' AND Prefeitura = '"+ frDiaria.getPrefeitura().getId() 
                        +"' AND Veiculo = '"+ frDiaria.getVeiculo().getId() 
                        +"' ORDER BY Data DESC LIMIT 1");
        
        if (frDiariaFinal == null){
            
            frDiaria.setKmFinal(0);
            return frDiaria;
        }
        else {
            
            frDiariaFinal.setKmFinal(frDiaria.getKmInicial());           
        }
        
        return frDiariaFinal;
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TDiariaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TDiariaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>    
}