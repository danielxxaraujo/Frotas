package Telas;

import Dados.FrServicos;
import Interfaces.IConfigurar;
import Interfaces.IDiaria;
import Interfaces.IMenu;
import Interfaces.IPeca;
import Interfaces.IServico;
import View.VFrServicos;
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

@WebServlet(name = "TServicoCadastrar", urlPatterns = {"/TServicoCadastrar"})
public class TServicoCadastrar extends HttpServlet {

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
            
            FrServicos frServicos = new FrServicos();
            
            if (request.getParameter("Diaria") != null && !request.getParameter("Diaria").isEmpty()){
                frServicos.setDiaria(new IDiaria().Consultar(request.getParameter("Diaria")));
            }
            if (request.getParameter("peca") != null && !request.getParameter("peca").isEmpty()){
                frServicos.setPeca(new IPeca().Consultar(request.getParameter("peca")));
            }
            if (request.getParameter("quantidade") != null && !request.getParameter("quantidade").isEmpty()){
                frServicos.setQuantidade(Float.parseFloat(request.getParameter("quantidade")));
            }
            
            frServicos.setPrefeitura(IConfigurar.prefeituraAtiva);            
            
            if (request.getParameter("Salvar") != null && !request.getParameter("Salvar").isEmpty()){
                new IServico().Salvar(frServicos);
                mensagem = "As informações foram salvas com sucesso.";
            }

            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            if (!mensagem.isEmpty())
                out.println("<div class='salvar'>"+ mensagem +"</div>");
            out.println("           <form>");
            out.println("           <table class='Pesquisa' border=0 width=100%>");
            out.println("               <tr><th colspan=4 class='Titulo'>Módulo de Diária</th></tr>");
            
            out.println("               <tr><th colspan=4>");
            new TDiariaListar().Listar(response, " WHERE DiariaID =" + frServicos.getDiaria().getId(), frServicos.getDiaria().getData());
            out.println("                   </th>");
            out.println("               </tr>");
            
            out.println("               <tr>");
            out.println("                   <th width=70%>Serviço / Peça</th>");
            out.println("                   <th width=20%>Quantidade</th>");
            out.println("                   <th width=10%></th>");
            out.println("                   <th width=10%></th>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <td><select name='peca'><option value=''></option>"+ new IPeca().MontarDropDown(frServicos.getPeca().getId(), " AND Categoria IN (1,2,3) ") +"</select></td>");
            out.println("                   <td><input type='text' name='quantidade' value=''></td>");
            out.println("                   <td><input type='submit' name='Salvar' value='Salvar'></td>");
            out.println("                   <td><a href='TDiariaListar'><input type='button' name='Voltar' value='Voltar'></a></td>");
            out.println("               </tr>");
            out.println("               <tr><th colspan=4 class='Titulo'>Relação de Serviços/Peças</th></tr>");
            out.println("           </table>");
            out.println("           <input type='hidden' name='Diaria' value='"+ frServicos.getDiaria().getId() +"'>");
            out.println("           </form>");
            
            Listar(response, "WHERE Diaria =" + frServicos.getDiaria().getId());
            
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
        
        out.println("<table class='Pesquisa' width=100%>");
        out.println("   <tr>");
        out.println("       <th width=1%></th>");
        out.println("       <th>Km inicial</th>");
        out.println("       <th>Km final</th>");
        out.println("       <th>Codigo</th>");
        out.println("       <th>Descrição</th>");
        out.println("       <th>Quantidade</th>");
        out.println("       <th>Unidade</th>");
        out.println("       <th width=1%></th>");
        out.println("   </tr>");
        
        String grade ="";
    
        List<VFrServicos> vFrServicoses = new IServico().ListarView(opcao);

        for (int x=0; x < vFrServicoses.size(); x++){
            if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
            out.println("<tr>");
            out.println("   <td align='left'"+ grade +"><input type='submit' name='Alterar' value='"+ vFrServicoses.get(x).getId() +"' class='botaoAlterar'></td>");
            if (vFrServicoses.get(x).getKmInicial() > 0)
                out.println("   <td "+ grade +">"+ vFrServicoses.get(x).getKmInicial()+"</td>");
            else
                out.println("   <td "+ grade +"><img src='imagens/abrir.png' width=20px weight=20px></td>");
            if (vFrServicoses.get(x).getKmFinal() > 0)
                out.println("   <td "+ grade +">"+ vFrServicoses.get(x).getKmFinal()+"</td>");
            else
                out.println("   <td "+ grade +"><img src='imagens/fechar.png' width=20px weight=20px></td>");
            out.println("   <td "+ grade +">"+ vFrServicoses.get(x).getCodigo()+"</td>");
            out.println("   <td "+ grade +">"+ vFrServicoses.get(x).getPecasDescricao()+"</td>");
            out.println("   <td "+ grade +">"+ vFrServicoses.get(x).getQuantidade()+"</td>");
            out.println("   <td "+ grade +">"+ vFrServicoses.get(x).getUnidade() +"</td>");
            out.println("   <td "+ grade +"><input type='submit' name='Excluir' value='"+ vFrServicoses.get(x).getId() +"' class='botaoExcluir'></td>");
            out.println("</tr>");
        }
        
        out.println("   <tr><th colspan=20>Foi(ram) localizado(s) "+ vFrServicoses.size() + " registro(s).</th></tr>");
        out.println("</table>");
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
            Logger.getLogger(TServicoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TServicoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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