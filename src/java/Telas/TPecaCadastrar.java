package Telas;

import Dados.FrPecas;
import Dados.FrPrefeitura;
import Dados.FrUsuario;
import Interfaces.IConfigurar;
import Interfaces.IMenu;
import Interfaces.IPeca;
import Interfaces.IPrefeitura;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TPecaCadastrar", urlPatterns = {"/TPecaCadastrar"})
public class TPecaCadastrar extends HttpServlet {

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
            
            String mensagem = "";
            
            FrPecas frPecas = new FrPecas(0);
            
            if (request.getParameter("Novo") != null && !request.getParameter("Novo").isEmpty()){
                
            } else {
            
                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
                    frPecas.setId(Integer.parseInt(request.getParameter("id")));
                }
                if (request.getParameter("prefeitura") != null && !request.getParameter("prefeitura").isEmpty()){
                    frPecas.setPrefeitura(new IPrefeitura().Consultar(" WHERE ID =" + request.getParameter("prefeitura")));
                }
                if (request.getParameter("codigo") != null && !request.getParameter("codigo").isEmpty()){
                    frPecas.setCodigo(request.getParameter("codigo"));
                }
                if (request.getParameter("categoria") != null && !request.getParameter("categoria").isEmpty()){
                    frPecas.setCategoria(Integer.parseInt(request.getParameter("categoria")));
                }
                if (request.getParameter("descricao") != null && !request.getParameter("descricao").isEmpty()){
                    frPecas.setDescricao(request.getParameter("descricao"));
                }
                if (request.getParameter("unidade") != null && !request.getParameter("unidade").isEmpty()){
                    frPecas.setUnidade(request.getParameter("unidade"));
                }
                if (request.getParameter("Salvar") != null && !request.getParameter("Salvar").isEmpty()){
                    new IPeca().Salvar(frPecas);
                    mensagem = "Informações Salvas com sucesso.";
                }
                if (request.getParameter("Alterar") != null && !request.getParameter("Alterar").isEmpty()){
                    frPecas = new IPeca().Consultar(" WHERE ID=" + request.getParameter("Alterar"));
                }
                if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                    frPecas = new IPeca().Consultar(" WHERE ID=" +request.getParameter("Excluir"));
                }
                if (request.getParameter("Excluindo") != null && !request.getParameter("Excluindo").isEmpty()){
                     new IPeca().Excluir(new IPeca().Consultar(" WHERE ID=" +request.getParameter("Excluindo")));
                     response.sendRedirect("TServicoListar");
                }
            }

            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            if (!mensagem.isEmpty())
                out.println("<div class='salvar'>"+ mensagem +"</div>");
            
            out.println("           <form action='TPecaCadastrar' method='Post'>");
            out.println("           <table class='Cadastro' border=0 width=100%>");
            out.println("               <tr><th colspan=2 class='Titulo'>Módulo de Serviços/Peças</th></tr>");
            out.println("               <tr>");
            out.println("                   <th width=40%>Prefeitura</th>");
            out.println("                   <td width=60%><select name='prefeitura'>"+ new IPrefeitura().MontarDropDown(frPecas.getPrefeitura().getId(), opcaoPrefeitura) +"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Código</th>");
            out.println("                   <td><input type='text' name='codigo' value='"+ frPecas.getCodigo() +"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Categoria</th>");
            out.println("                   <td><select name='categoria'>"+ new IMenu().Categoria(frPecas.getCategoria()) +"</td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Descrição</th>");
            out.println("                   <td><input type='text' name='descricao' value='"+ frPecas.getDescricao() +"' size=80></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Unidade</th>");
            out.println("                   <td><input type='text' name='unidade' value='"+ frPecas.getUnidade() +"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "Deseja excluir o registro <input type='submit' name='Excluindo' value='"+ frPecas.getId() +"'> ou "
                        + "<input type='submit' name='Nao' value='Não'> ?");
            } else {
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "<input type='submit' name='Novo' value='Novo'>&nbsp"
                        + "<input type='submit' name='Salvar' value='Salvar'>&nbsp"
                        + "<a href='TServicoListar'><input type='button' value='Voltar'></a></th>");
            }
            out.println("               </tr>");
            out.println("           </table>");
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
            Logger.getLogger(TPecaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TPecaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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