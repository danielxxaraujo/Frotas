package Telas;

import Dados.FrPrefeitura;
import Interfaces.IConfigurar;
import Interfaces.IDiaria;
import Interfaces.IMenu;
import View.VFrDiariaCategoria;
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

@WebServlet(name = "TKilometragem", urlPatterns = {"/TKilometragem"})
public class TKilometragem extends HttpServlet {

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
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            String opcao = " WHERE 1=1 ";
         
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            
            if (request.getParameter("Imprimir") != null && !request.getParameter("Imprimir").isEmpty()){
                out.println(iMenu.Cabecalho(null));
            } else {
                out.println(iMenu.Cabecalho(prefeitura));
                out.println("        <div class='corpo'>");
                out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            }
            
            opcao = " WHERE Data BETWEEN '"+ ano +"-"+ mes +"-01' AND '"+ ano +"-"+ mes +"-30' GROUP BY Veiculo ";

            List<VFrDiariaCategoria> vFrDiariaCategorias = new IDiaria().DiariaCategoriaView(opcao, true);
            
            if (vFrDiariaCategorias.size() > 0){
                out.println("<form action='TKilometragem'>");
                out.println("<table class='Pesquisa' width=100% boder=0>");
                out.println("   <tr><td colspan=10 style='font-size: 17px;'>Controle de Quilometragem dos Veículos das Prefeitura/Câmara Municipal de <br>"+ prefeitura +"</td></tr>");
                out.println("   <tr><th colspan=10></th><tr>");
                out.println("   <tr>");
                out.println("       <th width='10%'>Exercício</th><td>"+ ano +"</td><th width='10%'>Mês de Referência</th><td>"+ iMenu.MesDescricao(Integer.parseInt(mes))+"</td>");
                if (request.getParameter("Imprimir") != null && !request.getParameter("Imprimir").isEmpty()){
                    
                } else {
                    out.println("           <td rowspan=2 align='right'><input type='image' name='Imprimir' value='Imprimir' src='imagens/imprimir.jpg' width=40px height=30px formtarget='_blank'>");
                }
                out.println("       </td>");
                out.println("   </tr>");
                out.println("</table>");

                out.println("<table class='Pesquisa' width=100% boder=0>");
                out.println("   <tr>");
                out.println("       <th>Veículo Modelo</th>");
                out.println("       <th>Marca</th>");
                out.println("       <th>Placa</th>");
                out.println("       <th>Cilindrada</th>");
                out.println("       <th>Combustível</th>");
                out.println("       <th>Situação</th>");
                out.println("       <th>Km Inicial</th>");
                out.println("       <th>Km Final</th>");
                out.println("       <th>Quantidade Abastecida</th>");
                out.println("   </tr>");
                String grade ="";
                for (int x=0; x < vFrDiariaCategorias.size(); x++){
                if (x % 2 == 0){ grade = "bgcolor=#D8D8D8"; } else { grade = "bgcolor=#FFFFFF"; }
                    out.println("<tr>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getVeiculoDescricao() +"</td>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getMarca()+"</td>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getPlaca()+"</td>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getCilindradas()+"</td>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getDescricao()+"</td>");
                    out.println("   <td "+ grade +">"+ iMenu.CategoriaVeiculoDescricao(vFrDiariaCategorias.get(x).getCategoria()) +"</td>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getKmInicial()+"</td>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getKmFinal()+"</td>");
                    out.println("   <td "+ grade +">"+ vFrDiariaCategorias.get(x).getCombustivel()+"</td>");
                    out.println("</tr>");
                }
                out.println("<tr><th colspan=10></th><tr>");
                out.println("<tr><td colspan=10 style='text-align:left;'>a- Quilometragem verificada no primeiro dia do mês de referência constante do odômetro do veículo.<td></tr>");
                out.println("<tr><td colspan=10 style='text-align:left;'>b- Quilometragem verificada no último dia do mês de referência cosntatne do odômetro do veículo.<td></tr>");
                out.println("<tr><td colspan=10 style='text-align:right;'>Responsável pelo preenchimento: <b>"+ usuario+"</b><td></tr>");
                out.println("</table>");
                out.println("</form>");
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
            Logger.getLogger(TKilometragem.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TKilometragem.class.getName()).log(Level.SEVERE, null, ex);
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