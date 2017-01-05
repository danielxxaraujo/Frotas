package Telas;

import Dados.FrPrefeitura;
import Interfaces.IConfigurar;
import Interfaces.IMenu;
import Interfaces.IPrefeitura;
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

@WebServlet(name = "TPrefeituraListar", urlPatterns = {"/TPrefeituraListar"})
public class TPrefeituraListar extends HttpServlet {

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
            
            if (request.getParameter("Novo") != null && !request.getParameter("Novo").isEmpty()){
                response.sendRedirect("TPrefeituraCadastrar");
            }
            
            if (request.getParameter("cnpj") != null && !request.getParameter("cnpj").isEmpty()){
                opcao += " AND CNPJ LIKE '%"+ request.getParameter("cnpj") +"%'";
            }
            if (request.getParameter("descricao") != null && !request.getParameter("descricao").isEmpty()){
                opcao += " AND Descricao LIKE '%"+ request.getParameter("descricao") +"%'";
            }
            if (request.getParameter("cidade") != null && !request.getParameter("cidade").isEmpty()){
                opcao += " AND Cidade LIKE '%"+ request.getParameter("cidade") +"%'";
            }
            if (request.getParameter("uf") != null && !request.getParameter("uf").isEmpty()){
                opcao += " AND UF LIKE '%"+ request.getParameter("uf") +"%'";
            }
         
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            out.println("           <form action='TPrefeituraListar' method='Post'>");
            out.println("           <table class='Pesquisa' border=0 width=100%>");
            out.println("               <tr><th colspan=10 class='Titulo'>Módulo de Prefeitura</th></tr>");
            out.println("               <tr>");
            out.println("                   <td rowspan=2><input type='image' name='Novo' value='Novo' src='imagens/adicionar.png' width=45px height=45px ></td>");
            out.println("                   <th>CNPJ</th>");
            out.println("                   <th>Descrição</th>");
            out.println("                   <th>Cidade</th>");
            out.println("                   <th>UF</th>");
            out.println("                   <td rowspan=2><input type='image' name='Atualizar' value='Atualizar' src='imagens/atualizar.png' width=45px height=45px ></td>");
            
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <td><input type='text' name='cnpj' value='' size=15></td>");
            out.println("                   <td><input type='text' name='descricao' value='' size=30></td>");
            out.println("                   <td><input type='text' name='cidade' value='' size=20></td>");
            out.println("                   <td><input type='text' name='uf' value='' size=2></td>");
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
        
        out.println("<form action='TPrefeituraCadastrar' method='Post'>");
        out.println("<table class='Pesquisa' width=100%>");
        out.println("   <tr>");
        out.println("       <th></th>");
        out.println("       <th>CNPJ</th>");
        out.println("       <th>Descrição</th>");
        out.println("       <th>Endereço</th>");
        out.println("       <th>Bairro</th>");
        out.println("       <th>CEP</th>");
        out.println("       <th>Cidade</th>");
        out.println("       <th>UF</th>");
        out.println("       <th>Logo</th>");
        out.println("       <th></th>");
        out.println("   </tr>");
        
        String grade ="";
    
        List<FrPrefeitura> frPrefeituras = new IPrefeitura().Listar(opcao);

        for (int x=0; x < frPrefeituras.size(); x++){
            if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
            out.println("<tr>");
            out.println("   <td><input type='image' name='Alterar' value='"+ frPrefeituras.get(x).getId() +"' src='imagens/alterar.jpg' width=15px height=15px></td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getCnpj() +"</td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getDescricao()+"</td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getEndereco()+"</td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getBairro()+"</td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getCep()+"</td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getCidade()+"</td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getUf()+"</td>");
            out.println("   <td "+ grade +">"+ frPrefeituras.get(x).getLogo()+"</td>");
            out.println("   <td><input type='image' name='Excluir' value='"+ frPrefeituras.get(x).getId() +"' src='imagens/excluir.png' width=15px height=15px></td>");
            out.println("</tr>");
        }
        out.println("   <tr><th colspan=20>Foi(ram) localizado(s) "+ frPrefeituras.size() + " registro(s).</th></tr>");
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
            Logger.getLogger(TPrefeituraListar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TPrefeituraListar.class.getName()).log(Level.SEVERE, null, ex);
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