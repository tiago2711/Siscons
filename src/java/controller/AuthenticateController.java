package controller;

import business.AuthenticateBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import util.Md5;
import util.Message;

/**
 *
 * @author Vitor Mesaque
 */

public class AuthenticateController extends HttpServlet 
{    
    private static String LOGOFF = "/index.jsp";
    
    private static String LOGON  = "/view/module/inicio.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        User user;
        
        String action = request.getParameter("action");  
        
        AuthenticateBO authenticateBo = new AuthenticateBO();
         
        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        
        Message message = new Message();
        
        try
        {
            switch(action)
            {
                
                case "logon":
                    System.out.println(Md5.encrypt("123"));
                    System.out.println(Md5.encrypt(Md5.encrypt("123")));
                    user = authenticateBo.logon(request.getParameter("email"), request.getParameter("password"));                    
                    if(user == null)
                    {
                        view = request.getRequestDispatcher("index.jsp");
                       
                        message.addWarning("Usuário ou senha incorreto!");
                    }
                    else
                    {
                        HttpSession session = request.getSession(true); 
                    
                        session.setAttribute("usuario",user);
                        
                        
                        
                        message.addMessage("Usuário autenticado com sucesso!");
                        
                        view = request.getRequestDispatcher("/view/home.jsp");
 
                        request.setAttribute("pageContent", LOGON);
                        
                        request.setAttribute("usuario", user);
                    }        
                    break;
            }             
        }catch (Exception ex) 
        {
            Logger.getLogger(AuthenticateController.class.getName()).log(Level.SEVERE, null, ex); 
        }        
        
        request.setAttribute("message", message);
        
        view.forward(request, response); 
    } 
}