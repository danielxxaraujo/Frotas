package Telas;

import Interfaces.IConfigurar;
import Interfaces.IDiaria;
import Interfaces.IMenu;
import View.VFrDiaria;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TDiariaListar", urlPatterns = {"/TDiariaListar"})
public class TDiariaListar extends HttpServlet {

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
            String prefeituraAtiva = " AND VeiculoPrefeitura =" + IConfigurar.usuarioAtivo.getPrefeitura().getId();
            
            if (IConfigurar.usuarioAtivo.getNivel().equals(0)){
                
            } else {
                opcao += " AND VeiculoPrefeitura =" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
                opcaoPrefeitura += " AND ID=" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
            
            Date data = cal.getTime();
            
            if (request.getParameter("Data") != null && !request.getParameter("Data").isEmpty()){
                data = sdf.parse(request.getParameter("Data"));
            }
            
            opcao += " AND Data = '"+ sdfBanco.format(data) +"' ";
         
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
 
            out.println("           <form action='TDiariaListar' method='Post'>");
            out.println("           <table class='Pesquisa' width=30%>");
            out.println("               <tr>");
            out.println("                   <th>Data</th>");
            out.println("                   <td rowspan=2><input type='image' name='Atualizar' value='Atualizar' src='imagens/atualizar.png' width=45px height=45px ></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <td><input type='text' name='Data' value='"+ sdf.format(data) +"' class='tcal' size=15></td>");
            out.println("               </tr>");
            out.println("           </table>");
            out.println("           </form>");
            
            ListarView(response, opcao, data, prefeituraAtiva);
            
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
    
    public void ListarView(HttpServletResponse response, String opcao, Date data, String prefeituraAtiva) throws IOException, SQLException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        PrintWriter out = response.getWriter();
        
        out.println("<form>");
        out.println("<table class='Pesquisa' width=100%>");
        out.println("   <tr>");
        out.println("       <th></th>");
        out.println("       <th colspan=2>Veículo</th>");
        out.println("       <th>Combustível</th>");
        out.println("       <th>Lotado</th>");
        out.println("       <th>Km inicial</th>");
        out.println("       <th>Km final</th>");
        out.println("       <th colspan=2>Motorista</th>");
        out.println("       <th colspan=5>Combustível/Serviço/Peça</th>");
        out.println("       <th></th>");
        out.println("   </tr>");
        
        String grade ="";
    
        List<VFrDiaria> vFrDiarias = new IDiaria().ListarView(opcao, prefeituraAtiva);

        for (int x=0; x < vFrDiarias.size(); x++){
            if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
            out.println("<tr>");
            out.println("   <td align='left'"+ grade +"><input type='submit' name='Alterar' value='"+ vFrDiarias.get(x).getId() +"' class='botaoAlterar'></td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getPlaca() +"</td>");
            out.println("   <td align='left' "+ grade +">"+ vFrDiarias.get(x).getVeiculo() +"</td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getDescricao() +"</td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getLotado() +"</td>");
            if (vFrDiarias.get(x).getKmInicial() > 0)
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getKmInicial()+"</td>");
            else
                out.println("   <td "+ grade +"><a href='TDiariaCadastrar?Abrir=abrir&Veiculo="+ vFrDiarias.get(x).getId()+"&Prefeitura="+ vFrDiarias.get(x).getPrefeitura()+"&Data="+ sdf.format(data) +"'><img src='imagens/abrir.png' width=20px weight=20px></a></td>");
            if (vFrDiarias.get(x).getKmFinal() > 0)
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getKmFinal()+"</td>");
            else
                out.println("   <td "+ grade +"><a href='TDiariaCadastrar?Alterar="+ vFrDiarias.get(x).getDiariaId()+"&Veiculo="+ vFrDiarias.get(x).getId()+"&Prefeitura="+ vFrDiarias.get(x).getPrefeitura()+"&Data="+ sdf.format(data) +"'><img src='imagens/fechar.png' width=20px weight=20px></a></td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getMatricula() +"</td>");
            out.println("   <td align='left' "+ grade +">"+ vFrDiarias.get(x).getUsuarioNome() +"</td>");
            if (vFrDiarias.get(x).getDiariaId() != null){
                out.println("   <td "+ grade +"><a href='TServicoCadastrar?Diaria="+ vFrDiarias.get(x).getDiariaId()+"'><img src='imagens/adicionar.png' width=20px weight=20px></a></td>");
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getPecaCodigo() +"</td>");
                out.println("   <td align='left' "+ grade +">"+ vFrDiarias.get(x).getPecaDescricao() +"</td>");
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getQuantidade()+"</td>");
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getPecaUnidade()+"</td>");
            }
            else{
                out.println("   <td "+ grade +"><a href='TServicoCadastrar'><img src='imagens/adicionar.png' width=20px weight=20px></a></td>");
                out.println("   <td "+ grade +"></td>");
                out.println("   <td "+ grade +"></td>");
                out.println("   <td "+ grade +"></td>");
                out.println("   <td "+ grade +"></td>");
            }
            out.println("   <td "+ grade +"><input type='submit' name='Excluir' value='"+ vFrDiarias.get(x).getId() +"' class='botaoExcluir'></td>");
            out.println("</tr>");
        }
        out.println("   <tr><th colspan=20>Foi(ram) localizado(s) "+ vFrDiarias.size() + " registro(s).</th></tr>");
        out.println("</table>");
        out.println("</form>");
        
    }
    
    public void Listar(HttpServletResponse response, String opcao, Date data) throws IOException, SQLException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        PrintWriter out = response.getWriter();
        
        out.println("<table class='Pesquisa' width=100%>");
        out.println("   <tr>");
        out.println("       <th>Data</th>");
        out.println("       <th colspan=2>Veículo</th>");
        out.println("       <th>Combustível</th>");
        out.println("       <th>Lotado</th>");
        out.println("       <th>Km inicial</th>");
        out.println("       <th>Km final</th>");
        out.println("       <th colspan=2>Motorista</th>");
        out.println("       <th colspan=4>Combustível/Serviço/Peça</th>");
        out.println("   </tr>");
        
        String grade ="";
    
        List<VFrDiaria> vFrDiarias = new IDiaria().Listar(opcao);

        for (int x=0; x < vFrDiarias.size(); x++){
            if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
            out.println("<tr>");
            out.println("   <td "+ grade +">"+ sdf.format(vFrDiarias.get(x).getData()) +"</td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getPlaca() +"</td>");
            out.println("   <td align='left' "+ grade +">"+ vFrDiarias.get(x).getVeiculo() +"</td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getDescricao() +"</td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getLotado() +"</td>");
            if (vFrDiarias.get(x).getKmInicial() > 0)
                out.println("   <td "+ grade +"><b>"+ vFrDiarias.get(x).getKmInicial()+"</b></td>");
            else
                out.println("   <td "+ grade +"><a href='TDiariaCadastrar?Abrir=abrir&Veiculo="+ vFrDiarias.get(x).getId()+"&Prefeitura="+ vFrDiarias.get(x).getPrefeitura()+"&Data="+ sdf.format(data) +"'><img src='imagens/abrir.png' width=20px weight=20px></a></td>");
            if (vFrDiarias.get(x).getKmFinal() > 0)
                out.println("   <td "+ grade +"><b>"+ vFrDiarias.get(x).getKmFinal()+"</b></td>");
            else
                out.println("   <td "+ grade +"><a href='TDiariaCadastrar?Alterar="+ vFrDiarias.get(x).getDiariaId()+"&Veiculo="+ vFrDiarias.get(x).getId()+"&Prefeitura="+ vFrDiarias.get(x).getPrefeitura()+"&Data="+ sdf.format(data) +"'><img src='imagens/fechar.png' width=20px weight=20px></a></td>");
            out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getMatricula() +"</td>");
            out.println("   <td align='left' "+ grade +">"+ vFrDiarias.get(x).getUsuarioNome() +"</td>");
            if (vFrDiarias.get(x).getDiariaId() != null){
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getPecaCodigo() +"</td>");
                out.println("   <td align='left' "+ grade +">"+ vFrDiarias.get(x).getPecaDescricao() +"</td>");
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getQuantidade()+"</td>");
                out.println("   <td "+ grade +">"+ vFrDiarias.get(x).getPecaUnidade()+"</td>");
            }
            else{
                out.println("   <td "+ grade +"></td>");
                out.println("   <td "+ grade +"></td>");
                out.println("   <td "+ grade +"></td>");
                out.println("   <td "+ grade +"></td>");
            }
            out.println("</tr>");
        }
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
            Logger.getLogger(TDiariaListar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TDiariaListar.class.getName()).log(Level.SEVERE, null, ex);
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