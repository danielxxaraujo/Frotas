package Telas;

import Dados.FrPrefeitura;
import Dados.FrUsuario;
import Interfaces.IConfigurar;
import Interfaces.IMenu;
import Interfaces.IPrefeitura;
import Interfaces.IUsuario;
import View.VFrUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TUsuarioListar", urlPatterns = {"/TUsuarioListar"})
public class TUsuarioListar extends HttpServlet {

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
                opcao += " AND Prefeitura =" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
                opcaoPrefeitura += " AND ID=" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
            }
            
            if (request.getParameter("Novo") != null && !request.getParameter("Novo").isEmpty()){
                response.sendRedirect("TUsuarioCadastrar");
            }
         
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            out.println("           <form action='TUsuarioListar' method='Post'>");
            out.println("           <table class='Pesquisa' border=0 width=100%>");
            out.println("               <tr><th colspan=10 class='Titulo'>Módulo de Usuário</th></tr>");
            out.println("               <tr>");
            out.println("                   <td rowspan=2><input type='image' name='Novo' value='Novo' src='imagens/adicionar.png' width=45px height=45px ></td>");
            out.println("                   <th>Prefeitura</th>");
            out.println("                   <th>Matricula</th>");
            out.println("                   <th>Nome</th>");
            out.println("                   <th>CNH</th>");
            out.println("                   <th>Categoria</th>");
            out.println("                   <th>Fones</th>");
            out.println("                   <td rowspan=2><input type='image' name='Atualizar' value='Atualizar' src='imagens/atualizar.png' width=45px height=45px ></td>");
            
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <td><select name='prefeitura'><option value=''></option>"+ new IPrefeitura().MontarDropDown(0, opcaoPrefeitura)+"</select></td>");
            out.println("                   <td><input type='text' name='mtricula' value='' size=10></td>");
            out.println("                   <td><input type='text' name='nome' value='' size=20></td>");
            out.println("                   <td><input type='text' name='cnh' value='' size=10></td>");
            out.println("                   <td><input type='text' name='categoria' value='' size=10></td>");
            out.println("                   <td><input type='text' name='fones' value='' size=10></td>");
            out.println("               </tr>");            
            out.println("           </table>");
            out.println("           </form>");
            
            Listar(response, opcao);
            
            out.println(iMenu.RodaPe(false));
            out.println("        </div>");
            out.println("    </body>");
            out.println("</html>");
           
        } catch (Exception e){
            Exception mensagemerro =  new RuntimeException(e);
            out.println("<Div>Erro: "+ mensagemerro.toString()+ "</div>");

        } finally {            
            out.close();
        }
    }
    
    public void Listar(HttpServletResponse response, String opcao) throws IOException, SQLException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        PrintWriter out = response.getWriter();
        
        out.println("<form action='TUsuarioCadastrar' method='Post'>");
        out.println("<table class='Pesquisa' width=100%>");
        out.println("   <tr>");
        out.println("       <th></th>");
        out.println("       <th>CNPJ</th>");
        out.println("       <th>Prefeitura</th>");
        out.println("       <th>Matricula</th>");
        out.println("       <th>Nome</th>");
        out.println("       <th>CNH</th>");
        out.println("       <th>Validade</th>");
        out.println("       <th>Categoria</th>");
        out.println("       <th>E-mail</th>");
        out.println("       <th>Fone</th>");
        out.println("       <th>Acesso</th>");
        out.println("       <th></th>");
        out.println("   </tr>");
        
        String grade ="";
    
        List<VFrUsuario> vFrUsuarios = new IUsuario().ListarView(opcao);

        for (int x=0; x < vFrUsuarios.size(); x++){
            if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
            out.println("<tr>");
            out.println("   <td><input type='image' name='Alterar' value='"+ vFrUsuarios.get(x).getId() +"' src='imagens/alterar.jpg' width=15px height=15px></td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getCnpj()+"</td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getDescricao()+"</td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getMatricula()+"</td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getNome()+"</td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getCnh()+"</td>");
            if ( vFrUsuarios.get(x).getValidade() == null)
                out.println("   <td "+ grade +"></td>");
            else
                out.println("   <td "+ grade +">"+ sdf.format(vFrUsuarios.get(x).getValidade()) +"</td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getCategoria()+"</td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getEmail()+"</td>");
            out.println("   <td "+ grade +">"+ vFrUsuarios.get(x).getFone()+"</td>");
            out.println("   <td "+ grade +">"+ new IMenu().NivelDescricao(vFrUsuarios.get(x).getNivel())+"</td>");
            out.println("   <td><input type='image' name='Excluir' value='"+ vFrUsuarios.get(x).getId() +"' src='imagens/excluir.png' width=15px height=15px></td>");
            out.println("</tr>");
        }
        out.println("   <tr><th colspan=20>Foi(ram) localizado(s) "+ vFrUsuarios.size() + " registro(s).</th></tr>");
        out.println("</table>");
        out.println("</form>");
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
            Logger.getLogger(TUsuarioListar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TUsuarioListar.class.getName()).log(Level.SEVERE, null, ex);
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