package Telas;

import Dados.FrVeiculo;
import Interfaces.IConfigurar;
import Interfaces.IMenu;
import Interfaces.IPeca;
import Interfaces.IPrefeitura;
import Interfaces.IVeiculo;
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

@WebServlet(name = "TVeiculoCadastrar", urlPatterns = {"/TVeiculoCadastrar"})
public class TVeiculoCadastrar extends HttpServlet {

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
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            FrVeiculo frVeiculo = new FrVeiculo(0);
            
            if (request.getParameter("Novo") != null && !request.getParameter("Novo").isEmpty()){
                
            } else {
            
                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
                    frVeiculo.setId(Integer.parseInt(request.getParameter("id")));
                }
                if (request.getParameter("prefeitura") != null && !request.getParameter("prefeitura").isEmpty()){
                    frVeiculo.setPrefeitura(new IPrefeitura().Consultar(" WHERE ID=" + request.getParameter("prefeitura")));
                }
                if (request.getParameter("placa") != null && !request.getParameter("placa").isEmpty()){
                    frVeiculo.setPlaca(request.getParameter("placa"));
                }
                if (request.getParameter("veiculo") != null && !request.getParameter("veiculo").isEmpty()){
                    frVeiculo.setVeiculo(request.getParameter("veiculo"));
                }
                if (request.getParameter("marca") != null && !request.getParameter("marca").isEmpty()){
                    frVeiculo.setMarca(request.getParameter("marca"));
                }
                if (request.getParameter("aquisicao") != null && !request.getParameter("aquisicao").isEmpty()){
                    frVeiculo.setAquisicao(new java.sql.Date(sdf.parse(request.getParameter("aquisicao")).getTime()));
                } else {
                    frVeiculo.setAquisicao(cal.getTime());
                }
                if (request.getParameter("potencia") != null && !request.getParameter("potencia").isEmpty()){
                    frVeiculo.setPotencia(request.getParameter("potencia"));
                }
                if (request.getParameter("ano") != null && !request.getParameter("ano").isEmpty()){
                    frVeiculo.setAno(request.getParameter("ano"));
                }
                if (request.getParameter("nf") != null && !request.getParameter("nf").isEmpty()){
                    frVeiculo.setNf(request.getParameter("nf"));
                }
                if (request.getParameter("cilindradas") != null && !request.getParameter("cilindradas").isEmpty()){
                    frVeiculo.setCilindradas(request.getParameter("cilindradas"));
                }
                if (request.getParameter("combustivel") != null && !request.getParameter("combustivel").isEmpty()){
                    frVeiculo.setCombustivel(new IPeca().Consultar(" WHERE ID=" + request.getParameter("combustivel")));
                }
                if (request.getParameter("lotado") != null && !request.getParameter("lotado").isEmpty()){
                    frVeiculo.setLotado(request.getParameter("lotado"));
                }
                if (request.getParameter("renavam") != null && !request.getParameter("renavam").isEmpty()){
                    frVeiculo.setRenavam(request.getParameter("renavam"));
                }
                if (request.getParameter("categoria") != null && !request.getParameter("categoria").isEmpty()){
                    frVeiculo.setCategoria(Integer.parseInt(request.getParameter("categoria")));
                }
                if (request.getParameter("Salvar") != null && !request.getParameter("Salvar").isEmpty()){
                    new IVeiculo().Salvar(frVeiculo);
                    mensagem = "Informações Salvas com sucesso.";
                }
                if (request.getParameter("Alterar") != null && !request.getParameter("Alterar").isEmpty()){
                    frVeiculo = new IVeiculo().Consultar(" WHERE ID=" + request.getParameter("Alterar"));
                }
                if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                    frVeiculo = new IVeiculo().Consultar(" WHERE ID=" +request.getParameter("Excluir"));
                }
                if (request.getParameter("Excluindo") != null && !request.getParameter("Excluindo").isEmpty()){
                     new IVeiculo().Excluir(new IVeiculo().Consultar(" WHERE ID=" +request.getParameter("Excluindo")));
                     response.sendRedirect("TVeiculoListar");
                }
            }
            
            IMenu iMenu = new IMenu();
            
            out.println("<html>");
            out.println(iMenu.Cabecalho(prefeitura));
            out.println("        <div class='corpo'>");
            out.println("           <table border='0' width='100%'><tr><td width='80%'>"+ iMenu.Display(ano, mes) +"</td><td style='text-align: right; font-size: 10px;' width='20%'>"+ usuario +"<BR>"+ prefeitura +"</td><td><a href='TUsuario'><image src='CSS/usuario.png' height=40px width=40px></a></td></tr></table>");
            
            if (!mensagem.isEmpty())
                out.println("<div class='salvar'>"+ mensagem +"</div>");
            
            out.println("           <form action='TVeiculoCadastrar' method='Post'>");
            out.println("           <table class='Cadastro' border=0 width=100%>");
            out.println("               <tr><th colspan=2 class='Titulo'>Módulo de Veículo</th></tr>");
            out.println("               <tr>");
            out.println("                   <th width=40%>Prefeitura</th>");
            out.println("                   <td width=60%><select name='prefeitura'>"+ new IPrefeitura().MontarDropDown(frVeiculo.getPrefeitura().getId(), opcaoPrefeitura)+"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Placa</th>");
            out.println("                   <td><input type='text' name='placa' value='"+ frVeiculo.getPlaca()+"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Veículo</th>");
            out.println("                   <td><input type='text' name='veiculo' value='"+ frVeiculo.getVeiculo() +"' size=60></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Marca</th>");
            out.println("                   <td><input type='text' name='marca' value='"+ frVeiculo.getMarca() +"' size=40></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Aquisição</th>");
            out.println("                   <td><input type='text' name='aquisicao' value='"+ sdf.format(frVeiculo.getAquisicao()) +"' class='tcal' size=9></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Potencia</th>");
            out.println("                   <td><input type='text' name='potencia' value='"+ frVeiculo.getPotencia() +"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Ano</th>");
            out.println("                   <td><input type='text' name='ano' value='"+ frVeiculo.getAno() +"' size=5></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Nota Fiscal</th>");
            out.println("                   <td><input type='text' name='nf' value='"+ frVeiculo.getNf() +"' size=20></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Cilindradas</th>");
            out.println("                   <td><input type='text' name='cilindradas' value='"+ frVeiculo.getCilindradas() +"' size=10></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Combustível</th>");
            out.println("                   <td><select name='combustivel'>"+ new IPeca().MontarDropDown(frVeiculo.getCombustivel().getId(), " AND Categoria=0 ") +"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Lotado</th>");
            out.println("                   <td><input type='text' name='lotado' value='"+ frVeiculo.getLotado() +"' size=40></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Renavam</th>");
            out.println("                   <td><input type='text' name='renavam' value='"+ frVeiculo.getRenavam() +"' size=20></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            out.println("                   <th>Categoria</th>");
            out.println("                   <td><select name='categoria'>"+ new IMenu().CategoriaVeiculo(frVeiculo.getCategoria()) +"</select></td>");
            out.println("               </tr>");
            out.println("               <tr>");
            if (request.getParameter("Excluir") != null && !request.getParameter("Excluir").isEmpty()){
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "Deseja excluir o registro <input type='submit' name='Excluindo' value='"+ frVeiculo.getId() +"'> ou "
                        + "<input type='submit' name='Nao' value='Não'> ?");
            } else {
                out.println("                   <th colspan=2 class='Titulo'>"
                        + "<input type='submit' name='Novo' value='Novo'>&nbsp"
                        + "<input type='submit' name='Salvar' value='Salvar'>&nbsp"
                        + "<a href='TVeiculoListar'><input type='button' value='Voltar'></a></th>");
            }
            out.println("               </tr>");
            out.println("           </table>");
            if (frVeiculo.getId() != null)
                out.println("           <input type='hidden' name='id' value='"+ frVeiculo.getId() +"'>");
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
            Logger.getLogger(TVeiculoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TVeiculoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
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