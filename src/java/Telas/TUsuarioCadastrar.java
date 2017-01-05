package Telas;

import Dados.FrUsuario;
import Interfaces.IConfigurar;
import Interfaces.IMenu;
import Interfaces.IPrefeitura;
import Interfaces.IUsuario;
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

@WebServlet(name = "TUsuarioCadastrar", urlPatterns = {"/TUsuarioCadastrar"})
public class TUsuarioCadastrar extends HttpServlet {

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
            
            String opcao ;
            
            if (IConfigurar.usuarioAtivo.getNivel().equals(0)){
                opcao = " WHERE 1=1 ";
            } else {
                opcao = " WHERE 1=1 AND ID =" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
            }
            
            String mensagem = "";
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            FrUsuario frUsuario = new FrUsuario(0);
            IUsuario iUsuario = new IUsuario();
            
            if (request.getParameter("Novo") != null && !request.getParameter("Novo").isEmpty()){
                
            } else {
            
                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
                    frUsuario.setId(Integer.parseInt(request.getParameter("id")));
                }
                if (request.getParameter("prefeitura") != null && !request.getParameter("prefeitura").isEmpty()){
                    frUsuario.setPrefeitura(new IPrefeitura().Consultar(request.getParameter("prefeitura")));
                }
                if (request.getParameter("matricula") != null && !request.getParameter("matricula").isEmpty()){
                    frUsuario.setMatricula(request.getParameter("matricula"));
                }
                if (request.getParameter("nome") != null && !request.getParameter("nome").isEmpty()){
                    frUsuario.setNome(request.getParameter("nome"));
                }
                if (request.getParameter("cnh") != null && !request.getParameter("cnh").isEmpty()){
                    frUsuario.setCnh(request.getParameter("cnh"));
                }
                if (request.getParameter("validade") != null && !request.getParameter("validade").isEmpty()){
                    frUsuario.setValidade(new java.sql.Date(sdf.parse(request.getParameter("validade")).getTime()));
                } else {
                    frUsuario.setValidade(cal.getTime());
                }
                if (request.getParameter("categoria") != null && !request.getParameter("categoria").isEmpty()){
                    frUsuario.setCategoria(request.getParameter("categoria"));
                }
                if (request.getParameter("email") != null && !request.getParameter("email").isEmpty()){
                    frUsuario.setEmail(request.getParameter("email"));
                }
                if (request.getParameter("fone") != null && !request.getParameter("fone").isEmpty()){
                    frUsuario.setFone(request.getParameter("fone"));
                }
                if (request.getParameter("celular") != null && !request.getParameter("celular").isEmpty()){
                    frUsuario.setCelular(request.getParameter("celular"));
                }
                if (request.getParameter("nivel") != null && !request.getParameter("nivel").isEmpty()){
                    frUsuario.setNivel(Integer.parseInt(request.getParameter("nivel")));
                }
                if (request.getParameter("Salvar") != null && !request.getParameter("Salvar").isEmpty()){
                    frUsuario = iUsuario.Salvar(frUsuario);
                    if (frUsuario.getId() > 0)
                        mensagem = "Informações Salvas com sucesso.";
                    else
                        mensagem = "Não foi possível salvar as informações.";
                }
                if (request.getParameter("Alterar") != null && !request.getParameter("Alterar").isEmpty()){
                    frUsuario = iUsuario.Consultar(request.getParameter("Alterar"));
                }
                if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                    frUsuario = iUsuario.Consultar(request.getParameter("Excluir"));
                }
                if (request.getParameter("Excluindo") != null && !request.getParameter("Excluindo").isEmpty()){
                     iUsuario.Excluir(new IUsuario().Consultar(request.getParameter("Excluindo")));
                     response.sendRedirect("TUsuarioListar");
                }
            }
         
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            if (!mensagem.isEmpty())
                out.println("<div class='salvar'>"+ mensagem +"</div>");
            
            out.println("           <form action='TUsuarioCadastrar' method='Post'>");
            out.println("           <table class='Cadastro' border=0 width=100%>");
            out.println("               <tr><th colspan=2 class='Titulo'>Módulo de Usuário</th></tr>");
            out.println("               <tr>");
            out.println("                   <th width=40%>Prefeitura</th>");
            out.println("                   <td width=60%><select name='prefeitura'>"+ new IPrefeitura().MontarDropDown(frUsuario.getPrefeitura().getId(), opcao)+"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Matricula</th>");
            out.println("                   <td><input type='text' name='matricula' value='"+ frUsuario.getMatricula()+"' size=10></td>");
            out.println("               <tr>");
            out.println("                   <th>Nome</th>");
            out.println("                   <td><input type='text' name='nome' value='"+ frUsuario.getNome()+"' size=60></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>CNH</th>");
            out.println("                   <td><input type='text' name='cnh' value='"+ frUsuario.getCnh()+"' size=15></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Validade</th>");
            if (frUsuario.getValidade() == null)
                out.println("                   <td><input type='text' name='validade' value='' class='tcal' size=10></td>");
            else
                out.println("                   <td><input type='text' name='validade' value='"+ sdf.format(frUsuario.getValidade()) +"' class='tcal' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Categoria CNH</th>");
            out.println("                   <td><input type='text' name='categoria' value='"+ frUsuario.getCategoria()+"' size=4></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>E-mail</th>");
            out.println("                   <td><input type='text' name='email' value='"+ frUsuario.getEmail()+"' size=60></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Fone</th>");
            out.println("                   <td><input type='text' name='fone' value='"+ frUsuario.getFone()+"' size=40></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Celular</th>");
            out.println("                   <td><input type='text' name='celular' value='"+ frUsuario.getCelular()+"' size=40></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Nível de Acesso</th>");
            out.println("                   <td><select name='nivel'>"+ new IMenu().Nivel(frUsuario.getNivel())+"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "Deseja excluir o registro <input type='submit' name='Excluindo' value='"+ frUsuario.getId() +"'> ou "
                        + "<input type='submit' name='Nao' value='Não'> ?");
            } else {
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "<input type='submit' name='Novo' value='Novo'>&nbsp"
                        + "<input type='submit' name='Salvar' value='Salvar'>&nbsp"
                        + "<a href='TUsuarioListar'><input type='button' value='Voltar'></a></th>");
            }
            out.println("               </tr>");
            out.println("           </table>");
            if (frUsuario.getId() != null)
                out.println("           <input type='hidden' name='id' value='"+ frUsuario.getId() +"'>");
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
            Logger.getLogger(TUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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