package Telas;

import Dados.FrPrefeitura;
import Dados.FrUsuario;
import Interfaces.IConfigurar;
import Interfaces.IMenu;
import Interfaces.IPeca;
import Interfaces.IPrefeitura;
import Interfaces.IVeiculo;
import View.VFrVeiculo;
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

@WebServlet(name = "TIndividualListar", urlPatterns = {"/TIndividualListar"})
public class TIndividualListar extends HttpServlet {

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
            String opcaoPrefeitura = "";
            
            if (IConfigurar.usuarioAtivo.getNivel().equals(0)){
                opcao = " WHERE 1=1 ";
            } else {
                opcao = " WHERE 1=1 AND Prefeitura =" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
                opcaoPrefeitura = " AND ID=" + IConfigurar.usuarioAtivo.getPrefeitura().getId() ;
            }
            
            if (request.getParameter("Novo") != null && !request.getParameter("Novo").isEmpty()){
                response.sendRedirect("TVeiculoCadastrar");
            }
            if (request.getParameter("Imprimir") != null && !request.getParameter("Imprimir").isEmpty()){
                response.sendRedirect("TIndividual?Opcao=" + request.getParameter("Imprimir"));
            }
            if (request.getParameter("prefeitura") != null && !request.getParameter("prefeitura").isEmpty()){
                opcao += " AND VeiculoPrefeitura =" + request.getParameter("prefeitura");
            }
            if (request.getParameter("placa") != null && !request.getParameter("placa").isEmpty()){
                opcao += " AND Placa LIKE '%" + request.getParameter("placa") +"%'";
            }
            if (request.getParameter("marca") != null && !request.getParameter("marca").isEmpty()){
                opcao += " AND Marca LIKE'%"+ request.getParameter("marca") + "%'" ;
            }
            if (request.getParameter("veiculo") != null && !request.getParameter("veiculo").isEmpty()){
                opcao += " AND Veiculo LIKE'%"+ request.getParameter("veiculo") +"%'";
            }
            if (request.getParameter("aquisicao") != null && !request.getParameter("aquisicao").isEmpty()){
                
            }
            if (request.getParameter("ano") != null && !request.getParameter("ano").isEmpty()){
                opcao += " AND Ano LIKE'%"+ request.getParameter("ano") +"%'";
            }
            if (request.getParameter("nf") != null && !request.getParameter("nf").isEmpty()){
                opcao += " AND NF LIKE '%"+ request.getParameter("nf") +"%'";
            }
            if (request.getParameter("combustivel") != null && !request.getParameter("combustivel").isEmpty()){
                opcao += " AND Combustivel =" + request.getParameter("combustivel");
            }
            if (request.getParameter("lotado") != null && !request.getParameter("lotado").isEmpty()){
                opcao += " AND Lotado LIKE '%"+ request.getParameter("lotado") +"%'";
            }
            if (request.getParameter("renavam") != null && !request.getParameter("renavam").isEmpty()){
                opcao += " AND Renavam LIKE '%"+ request.getParameter("renavam") +"%'";
            }
            if (request.getParameter("categoria") != null && !request.getParameter("categoria").isEmpty()){
                opcao += " AND Categoria ="+ request.getParameter("categoria");
            }
         
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            out.println("           <form action='TIndividualListar'>");
            out.println("           <table class='Pesquisa' border=0 width=100%>");
            out.println("               <tr><th colspan=20 class='Titulo'>Relatório de Veículos</th></tr>");
            out.println("               <tr>");
            out.println("                   <td rowspan=2><input type='image' name='Imprimir' value='"+ opcao +"' src='imagens/imprimir.jpg' width=45px height=45px ></td>");            
            out.println("                   <th>Prefeitura</th>");
            out.println("                   <th>Placa</th>");
            out.println("                   <th>Veiculo</th>");
            out.println("                   <th>Marca</th>");
            out.println("                   <th>Aquisição</th>");
            out.println("                   <th>Ano</th>");
            out.println("                   <th>Nota Fiscal</th>");
            out.println("                   <th>Combustível</th>");
            out.println("                   <th>Lotado</th>");
            out.println("                   <th>Renavam</th>");
            out.println("                   <th>Categoria</th>");
            out.println("                   <td rowspan=2><input type='image' name='Atualizar' value='Atualizar' src='imagens/atualizar.png' width=45px height=45px ></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <td><select name='prefeitura' style='width:100px;'><option value=''></option>"+ new IPrefeitura().MontarDropDown(0, opcaoPrefeitura)+"</select></td>");
            out.println("                   <td><input type='text' name='placa' value='' size=6></td>");
            out.println("                   <td><input type='text' name='veiculo' value='' size=20></td>");
            out.println("                   <td><input type='text' name='marca' value='' size=10></td>");
            out.println("                   <td><input type='text' name='aquisicao' value='' class='tcal' size=10></td>");
            out.println("                   <td><input type='text' name='ano' value='' size=4></td>");
            out.println("                   <td><input type='text' name='nf' value='' size=10></td>");
            out.println("                   <td><select name='combustivel' style='width:100px;'><option value=''></option>"+ new IPeca().MontarDropDown(0, " AND Categoria=0 ") +"</select></td>");
            out.println("                   <td><input type='text' name='lotado' value='' size=10></td>");
            out.println("                   <td><input type='text' name='renavam' value='' size=10></td>");
            out.println("                   <td><select name='categoria' style='width:100px;'><option value=''></option>"+ new IMenu().CategoriaVeiculo(-1) +"</select></td>");
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
        
        out.println("<form action='TIndividual' method='Post'>");
        out.println("<table class='Pesquisa' width=100%>");
        out.println("   <tr>");
        out.println("       <th></th>");
        out.println("       <th>Prefeitura</th>");
        out.println("       <th>Placa</th>");
        out.println("       <th>Veículo</th>");
        out.println("       <th>Marca</th>");
        out.println("       <th>Aquisição</th>");
        out.println("       <th>Potência</th>");
        out.println("       <th>Ano</th>");
        out.println("       <th>Nota Fiscal</th>");
        out.println("       <th>Cilindradas</th>");
        out.println("       <th>Combustível</th>");
        out.println("       <th>Lotado</th>");
        out.println("       <th>Renavam</th>");
        out.println("       <th>Categoria</th>");
        out.println("       <th></th>");
        out.println("   </tr>");
        
        String grade ="";
    
        List<VFrVeiculo> vFrVeiculos = new IVeiculo().ListarView(opcao);

        for (int x=0; x < vFrVeiculos.size(); x++){
            if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
            out.println("<tr>");
            out.println("   <td "+ grade +"><input type='image' name='Alterar' value='"+ vFrVeiculos.get(x).getId() +"' src='imagens/alterar.jpg' width=15px height=15px></td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getPrefeituraDescricao() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getPlaca() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getVeiculo() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getMarca() +"</td>");
            out.println("   <td "+ grade +">"+ sdf.format(vFrVeiculos.get(x).getAquisicao()) +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getPotencia() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getAno() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getNf() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getCilindradas() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getDescricao() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getLotado() +"</td>");
            out.println("   <td "+ grade +">"+ vFrVeiculos.get(x).getRenavam() +"</td>");
            out.println("   <td "+ grade +">"+ new IMenu().CategoriaVeiculoDescricao(vFrVeiculos.get(x).getCategoria()) +"</td>");
            out.println("   <td "+ grade +"><input type='image' name='Excluir' value='"+ vFrVeiculos.get(x).getId() +"' src='imagens/excluir.png' width=15px height=15px></td>");
            out.println("</tr>");
        }
        out.println("   <tr><th colspan=20>Foi(ram) localizado(s) "+ vFrVeiculos.size() + " registro(s).</th></tr>");
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
            Logger.getLogger(TIndividualListar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TIndividualListar.class.getName()).log(Level.SEVERE, null, ex);
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