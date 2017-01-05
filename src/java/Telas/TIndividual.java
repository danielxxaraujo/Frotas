package Telas;

import Interfaces.IConfigurar;
import Interfaces.IDiaria;
import Interfaces.IMenu;
import Interfaces.IVeiculo;
import View.VFrDiariaCategoria;
import View.VFrVeiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "TIndividual", urlPatterns = {"/TIndividual"})
public class TIndividual extends HttpServlet {

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
            
            String opcao = "";
            String opcaoVeiculo = "";
            
            if (request.getParameter("Alterar") != null && !request.getParameter("Alterar").isEmpty()){
               opcao = " WHERE ID = " + request.getParameter("Alterar");
            } else {
               opcao = " WHERE 0=1 ";
            }
            if (request.getParameter("Opcao") != null && !request.getParameter("Opcao").isEmpty()){
                opcao = request.getParameter("Opcao");
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            
            if (request.getParameter("Imprimir") != null && !request.getParameter("Imprimir").isEmpty()){
                out.println(iMenu.Cabecalho(null));
            } else {
                out.println(iMenu.Cabecalho(prefeitura));
                out.println("        <div class='corpo'>");
                out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            }
            
            List<VFrVeiculo> vFrVeiculos = new IVeiculo().ListarView(opcao);
            for (int i = 0; i < vFrVeiculos.size(); i ++){
                
                opcaoVeiculo = " WHERE Veiculo ="+ vFrVeiculos.get(i).getId()+" AND data BETWEEN '"+ ano +"-"+ mes +"-01' AND '"+ ano +"-"+ mes +"-30' ";

                List<VFrDiariaCategoria> vFrDiariaCategorias = new IDiaria().DiariaCategoriaView(opcaoVeiculo, false);
            
                if (vFrDiariaCategorias.size() > 0){
                    out.println("<form action='TIndividual'>");
                    out.println("<table class='Pesquisa' width=100% boder=0>");
                    out.println("   <tr><td colspan=10 style='font-size: 17px;'>Controle Individual de bens ou produtos utilizados nos veículos/máquinas da <br>Prefeitura/Câmara Municipal de "+ prefeitura +"</td></tr>");
                    out.println("<tr><th colspan=10></th><tr>");
                    out.println("   <tr>");
                    out.println("       <th width=10%>Veículo</th>"
                            + "<td width=20%>"+ vFrDiariaCategorias.get(0).getVeiculoDescricao()+"</td>"
                            + "<th width=10%>Marca</th>"
                            + "<td width=20%>"+  vFrDiariaCategorias.get(0).getMarca() +"</td>"
                            + "<th width=10%>Data de Aquisição</th>"
                            + "<td width=20%>"+ sdf.format(vFrDiariaCategorias.get(0).getAquisicao()) +"</td>");
                    if (request.getParameter("Imprimir") != null && !request.getParameter("Imprimir").isEmpty()){

                    } else {
                        out.println("           <td rowspan=4 width=10%><input type='image' name='Imprimir' value='Imprimir' src='imagens/imprimir.jpg' width=60px height=60px formtarget='_blank'>");
                    }
                    out.println("       </td>");
                    out.println("   </tr>");
                    out.println("   <tr>");
                    out.println("       <th>Potência</th><td>"+ vFrDiariaCategorias.get(0).getPotencia() +"</td><th>Ano</th><td>"+ vFrDiariaCategorias.get(0).getAno() +"</td><th>NFº</th><td>"+ vFrDiariaCategorias.get(0).getNf() +"</td>");
                    out.println("   </tr>");
                    out.println("   <tr>");
                    out.println("       <th>Cilindrada</th><td>"+ vFrDiariaCategorias.get(0).getCilindradas() +"</td><th>Combustível</th><td>"+ vFrDiariaCategorias.get(0).getDescricao()+"</td><th>Placa</th><td>"+ vFrDiariaCategorias.get(0).getPlaca() +"</td>");
                    out.println("   </tr>");
                    out.println("   <tr>");
                    out.println("       <th>Lotado em</th><td>"+ vFrDiariaCategorias.get(0).getLotado() +"</td><th>Renavam</th><td>"+ vFrDiariaCategorias.get(0).getRenavam() +"</td><td></td><td></td>");
                    out.println("   </tr>");
                    out.println("</table>");

                    out.println("<table class='Pesquisa' width=100% boder=0>");
                    out.println("   <tr>");
                    out.println("       <th>Data</th>");
                    out.println("       <th>Km Inicial</th>");
                    out.println("       <th>Km Final</th>");
                    out.println("       <th>Quantidade Abastecida</th>");
                    out.println("       <th>Pneus Substituídos</th>");
                    out.println("       <th>Peças Aplicadas</th>");
                    out.println("       <th>Serviços Realizados</th>");
                    out.println("   </tr>");

                    String grade ="";
                    for (int x=0; x < vFrDiariaCategorias.size(); x++){
                    if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
                        out.println("<tr>");
                        out.println("   <td "+ grade +">"+ sdf.format(vFrDiariaCategorias.get(x).getData()) +"</td>");
                        out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getKmInicial()+"</td>");
                        out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getKmFinal()+"</td>");
                        out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getCombustivel()+"</td>");
                        out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getPneu()+"</td>");
                        out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getPeca()+"</td>");
                        out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getServico()+"</td>");
                        out.println("</tr>");
                    }
                    
                    vFrDiariaCategorias = new IDiaria().DiariaCategoriaView(opcaoVeiculo, true);
                    for (int x=0; x < vFrDiariaCategorias.size(); x++){
                    if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
                        out.println("<tr>");
                        out.println("   <td "+ grade +"><b>Total</b></td>");
                        out.println("   <td "+ grade +"></td>");
                        out.println("   <td "+ grade +"></td>");
                        out.println("   <td "+ grade +"><b>"+ vFrDiariaCategorias.get(x).getCombustivel()+ "</b></td>");
                        out.println("   <td "+ grade +"><b>"+ vFrDiariaCategorias.get(x).getPneu()+ "</b></td>");
                        out.println("   <td "+ grade +"><b>"+ vFrDiariaCategorias.get(x).getPeca()+ "</b></td>");
                        out.println("   <td "+ grade +"><b>"+ vFrDiariaCategorias.get(x).getServico()+ "</b></td>");
                        out.println("</tr>");
                    }
                    
                    out.println("<tr><th colspan=10></th><tr>");
                    out.println("<tr><td colspan=10 style='text-align:left;'>a- Quilometragem verificada no primeiro dia do mês de referência constante do odômetro do veículo.<td></tr>");
                    out.println("<tr><td colspan=10 style='text-align:left;'>b- Quilometragem verificada no último dia do mês de referência cosntatne do odômetro do veículo.<td></tr>");
                    out.println("<tr><td colspan=10 style='text-align:right;'>Responsável pelo preenchimento: <b>"+ usuario+"</b><td></tr>");
                    out.println("</table>");
                    out.println("<input type='hidden' name='Opcao' value='"+ opcao +"'>");
                    out.println("</form>");
                    out.println("<div style='page-break-after: always'></div>");
                }
            }
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
            Logger.getLogger(TIndividual.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TIndividual.class.getName()).log(Level.SEVERE, null, ex);
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