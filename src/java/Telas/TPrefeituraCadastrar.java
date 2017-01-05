package Telas;

import Dados.FrPrefeitura;
import Interfaces.IConfigurar;
import Interfaces.IMenu;
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

@WebServlet(name = "TPrefeituraCadastrar", urlPatterns = {"/TPrefeituraCadastrar"})
public class TPrefeituraCadastrar extends HttpServlet {

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
            
            String mensagem = "";
            
            FrPrefeitura frPrefeitura = new FrPrefeitura();
            
            if (request.getParameter("Novo") != null && !request.getParameter("Novo").isEmpty()){
                
            } else {
            
                if (request.getParameter("cnpj") != null && !request.getParameter("cnpj").isEmpty()){
                    frPrefeitura.setCnpj(request.getParameter("cnpj"));                
                }
                if (request.getParameter("descricao") != null && !request.getParameter("descricao").isEmpty()){
                    frPrefeitura.setDescricao(request.getParameter("descricao"));
                }
                if (request.getParameter("endereco") != null && !request.getParameter("endereco").isEmpty()){
                    frPrefeitura.setEndereco(request.getParameter("endereco"));
                }
                if (request.getParameter("bairro") != null && !request.getParameter("bairro").isEmpty()){
                    frPrefeitura.setBairro(request.getParameter("bairro"));
                }
                if (request.getParameter("cep") != null && !request.getParameter("cep").isEmpty()){
                    frPrefeitura.setCep(request.getParameter("cep"));
                }
                if (request.getParameter("cidade") != null && !request.getParameter("cidade").isEmpty()){
                    frPrefeitura.setCidade(request.getParameter("cidade"));
                }
                if (request.getParameter("uf") != null && !request.getParameter("uf").isEmpty()){
                    frPrefeitura.setUf(request.getParameter("uf"));
                }
                if (request.getParameter("fone") != null && !request.getParameter("fone").isEmpty()){
                    frPrefeitura.setFone(request.getParameter("fone"));
                }
                if (request.getParameter("logo") != null && !request.getParameter("logo").isEmpty()){
                    frPrefeitura.setLogo(request.getParameter("logo"));
                }
                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
                    frPrefeitura.setId(Integer.parseInt(request.getParameter("id")));
                }
                if (request.getParameter("Salvar") != null && !request.getParameter("Salvar").isEmpty()){
                    
                    frPrefeitura = new IPrefeitura().Salvar(frPrefeitura);
                    if (frPrefeitura != null)
                        mensagem = "Informações Salvas com sucesso.";
                    else
                        mensagem = "Não foi possível salvar as informações.";
                }
                if (request.getParameter("Alterar") != null && !request.getParameter("Alterar").isEmpty()){
                    frPrefeitura = new IPrefeitura().Consultar(request.getParameter("Alterar"));
                }
                if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                    frPrefeitura = new IPrefeitura().Consultar(request.getParameter("Excluir"));
                }
                if (request.getParameter("Excluindo") != null && !request.getParameter("Excluindo").isEmpty()){
                     new IPrefeitura().Excluir(new IPrefeitura().Consultar(request.getParameter("Excluindo")));
                     response.sendRedirect("TPrefeituraListar");
                }
            }
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            if (!mensagem.isEmpty())
                out.println("<div class='salvar'>"+ mensagem +"</div>");
            
            out.println("           <form action='TPrefeituraCadastrar' method='Post'>");
            out.println("           <table class='Cadastro' border=0 width=100%>");
            out.println("               <tr><th colspan=2 class='Titulo'>Módulo de Prefeitura</th></tr>");
            out.println("               <tr>");
            out.println("                   <th width=40%>CNPJ</th>");
            out.println("                   <td width=60%><input type='text' name='cnpj' value='"+ frPrefeitura.getCnpj() +"' size=20></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Descrição</th>");
            out.println("                   <td><input type='text' name='descricao' value='"+ frPrefeitura.getDescricao()+"' size=60></td>");
            out.println("               <tr>");
            out.println("                   <th>Endereço</th>");
            out.println("                   <td><input type='text' name='endereco' value='"+ frPrefeitura.getEndereco()+"' size=60></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Bairro</th>");
            out.println("                   <td><input type='text' name='bairro' value='"+ frPrefeitura.getBairro()+"' size=40></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>CEP</th>");
            out.println("                   <td><input type='text' name='cep' value='"+ frPrefeitura.getCep()+"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Cidade</th>");
            out.println("                   <td><input type='text' name='cidade' value='"+ frPrefeitura.getCidade()+"' size=40></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>UF</th>");
            out.println("                   <td><input type='text' name='uf' value='"+ frPrefeitura.getUf()+"' size=4></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Fone</th>");
            out.println("                   <td><input type='text' name='fone' value='"+ frPrefeitura.getFone()+"' size=20></td>");
            out.println("               <tr>");
            out.println("                   <th>Logo</th>");
            out.println("                   <td><input type='text' name='logo' value='"+ frPrefeitura.getLogo()+"' size=60></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "Deseja excluir o registro <input type='submit' name='Excluindo' value='"+ frPrefeitura.getId() +"'> ou "
                        + "<input type='submit' name='Nao' value='Não'> ?");
            } else {
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "<input type='submit' name='Novo' value='Novo'>&nbsp"
                        + "<input type='submit' name='Salvar' value='Salvar'>&nbsp"
                        + "<a href='TPrefeituraListar'><input type='button' value='Voltar'></a></th>");
            }
            out.println("               </tr>");
            out.println("           </table>");
            if (frPrefeitura.getId() != null)
                out.println("           <input type='hidden' name='id' value='"+ frPrefeitura.getId() +"'>");
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
            Logger.getLogger(TPrefeituraCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TPrefeituraCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
