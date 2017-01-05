package Telas;

import Dados.FrUsuario;
import Interfaces.IConfigurar;
import Interfaces.IUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TUsuario", urlPatterns = {"/TUsuario"})
public class TUsuario extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            HttpSession session = request.getSession();
            
            String mensagem = "";
            String email = "";
            
            IUsuario iUsuario = new IUsuario();
            
            if (request.getParameter("email") != null && !request.getParameter("email").isEmpty()
                    && request.getParameter("senha") != null && !request.getParameter("senha").isEmpty()){
                
                email = request.getParameter("email");
                String senha = request.getParameter("senha");
                
//                email = "danie@wfrotas.com.br";
//                senha = "123";
                
                FrUsuario frUsuario = iUsuario.ConsultarEmail(email);
                
                if (frUsuario !=  null){
                    
                    if (frUsuario.getSenha().equals(senha)){
                        
                        new IConfigurar().configurarUsuario(frUsuario);
                                
                        session.setAttribute("usuario", frUsuario.getId());
                        
//                        new NLog().Salvar(new Log(new Date(Calendar.getInstance().getTimeInMillis()), 1, 1, "Acesso", usuario.getCodigo()));
                        
                        response.sendRedirect("TFrotas");
                        
                    } else {
                        
                        mensagem = "Usuário ou Senha inválidos.";
                        
                    }
                } else {
                    
                    mensagem = "Não foi possível conectar a base de dados.";
                    
                }
            }
                        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("   <link rel='stylesheet' href='usuario.css' type='text/css'>");
            out.println("<title>..:: WEB Frotas ::..</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("   <form action='TUsuario' method='Post'>");
            out.println("   <table border=0 width=100%>");
            out.println("       <tr style='height:100px;'><td width=40%></td><td width=40%></td><td width=20%></td></tr>");
            out.println("       <tr style='height:400px;'><td></td><td style='background-color:#D5FFD5; box-shadow: 2px 2px 5px #999, -2px -2px 5px #000;'>");
            
            out.println("           <table border=0 width=100%>");
            out.println("               <tr><td width=10% rowspan='9'></td><td width=45% style='font-size: 20px; height:60px;'>Seja bem-vindo</td><td width='45%' rowspan='8' align='center'><image src='CSS/internet.png'><br><image src='imagens/webfrota.png' height=40px width=150px ></td></tr>");
            out.println("               <tr><td style='height:50px;'>Identifique-se por favor para utilizar o <br><b>Web Frotas</b></td></tr>");
            out.println("               <tr><td>Usuário*</td></tr>");
            out.println("               <tr><td><input type='text' name='email' placeholder='Informe a matricula ou e-mail' size=40></td></tr>");
            out.println("               <tr><td>Senha*</td></tr>");
            out.println("               <tr><td><input type='password' name='senha' placeholder='Informe a senha' size=20></td></tr>");
            out.println("               <tr><td style='font-size: 12px;'>Esqueceu a sua senha? <a href=''>Enviar senha</a></td></tr>");
            
            if (mensagem.isEmpty())
                out.println("               <tr style='height:50px;'><td></td></tr>");
            else
                out.println("               <tr style='height:50px; color:#FF0000; font-size: 16px; '><td><b>"+ mensagem +"</b></td></tr>");
                
            out.println("               </td></tr>");
            out.println("               <tr><td colspan=2 align='center'><input type='submit' name='senha' value='Entrar'></td></tr>");
            out.println("           </table>");
            
            out.println("       </td><td></td></tr>");
            out.println("       <tr><td></td><td></td><td></td></tr>");
            out.println("   </table>");
            out.println("   </form>");
            out.println("</body>");
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
            Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TUsuario.class.getName()).log(Level.SEVERE, null, ex);
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