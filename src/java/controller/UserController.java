package controller;

import Dao.ServidorDao;
import business.ServidorBO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Servidor;

public class UserController extends HttpServlet {
    private static String RELATORIO = "/view/module/relatorio.jsp";
    private static String INICIO = "/view/module/inicio.jsp";
    private static String EDIT = "/view/module/editar.jsp";
    private static String CADASTRO = "/view/module/cadastro.jsp";
    private static String DELETAR = "/view/module/deletar.jsp";
    private static String VISUALIZAR = "/view/module/visualizar.jsp";
    private static String EDITAR = "/view/module/edit.jsp";
    private static String PERFIL = "/view/module/perfil.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String forward = RELATORIO;
        
        String action = request.getParameter("action");
        RequestDispatcher view = request.getRequestDispatcher("/view/home.jsp");
        ServidorBO servidorBO = new ServidorBO();
        switch (action) 
        {
            case "inicio":
                view = request.getRequestDispatcher("/view/home.jsp");
                forward = INICIO;
                break;
            case "cadastro":
                view = request.getRequestDispatcher("/view/home.jsp"); 
                forward = CADASTRO;
                break;
            case "edit":
                view = request.getRequestDispatcher("/view/home.jsp"); 
                forward = EDIT;
                break;
            case "relatorio":
                String type = request.getParameter("type");
                view = request.getRequestDispatcher("/view/home.jsp");
                request.setAttribute("servidores", servidorBO.getRelatorio(type));
                forward = "/view/relatorio/"+type+".jsp";
                break;
            case "deletar":
                view = request.getRequestDispatcher("/view/home.jsp");
                forward = DELETAR;
               break;
            case "visualizar":
                view = request.getRequestDispatcher("/view/home.jsp");
                forward = VISUALIZAR;
               break;
            case "editar":
                int siape = Integer.valueOf(request.getParameter("siape"));
                String categoria = request.getParameter("categoria");
                view = request.getRequestDispatcher("/view/home.jsp");
                request.setAttribute("servidor", servidorBO.getServidor(siape, categoria));
                forward = EDITAR;
                break;
            case "sair":
                   HttpSession session = request.getSession(true); 
                   session.invalidate(); 
                   view = request.getRequestDispatcher("/index.jsp");
                break;
            case "perfil":
                   view = request.getRequestDispatcher("/view/home.jsp");
                   forward = PERFIL;
                break;    
               
        }
        request.setAttribute("pageContent", forward);
        view.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String forward = INICIO;
        String action = request.getParameter("action");
        RequestDispatcher view = request.getRequestDispatcher("/view/home.jsp");
        String categoria = request.getParameter("categoria");
        ServidorBO servidorBO = new ServidorBO();
        Servidor servidor = new Servidor();
        switch(action){
            case "create":
                servidor.setNome(request.getParameter("name"));
                servidor.setSiape(Integer.valueOf(request.getParameter("siape")));
                servidor.setLotacao(request.getParameter("lotacao"));
                servidor.setCargo(request.getParameter("cargo"));
                servidor.setClasse(request.getParameter("classe"));
                servidor.setTelefone(request.getParameter("telefone"));
                servidor.setRamal(Integer.valueOf(request.getParameter("ramal")));
                servidor.setEmail(request.getParameter("email"));
                servidor.setLattes(request.getParameter("lattes"));
                servidor.setSituacao(Boolean.valueOf(request.getParameter("situacao")));
                servidor.setAfastado(Boolean.valueOf(request.getParameter("afastado")));
                servidor.setCategoria(request.getParameter("categoria"));
                servidor.setCurso(request.getParameter("curso"));
                servidor.setTIT(request.getParameter("tit"));
                servidor.setInicio(request.getParameter("inicio"));
                servidor.setTermino(request.getParameter("termino"));
                servidor.setTitulacao(request.getParameter("titulacao"));
                servidor.setTutor(request.getParameter("tutor"));
                servidor.setDisciplina(request.getParameter("disciplina"));
                servidor.setResolucao(request.getParameter("resolucao"));
                servidor.setEdital_preg(request.getParameter("edital"));
                
                servidorBO.insertUser(servidor);
                
                forward = EDIT;            
            break;
            
            case "editar": 
                String nome = request.getParameter("nome");
                int siape;
                try{
                   siape = Integer.valueOf(request.getParameter("siape")); 
                   
                }catch(NumberFormatException e){
                   siape=0; 
                }
                System.out.println(siape);
                request.setAttribute("servidores", servidorBO.getServidores(siape, nome, categoria));
                forward = EDIT;
            break;    
            case "procurar":
                
                
            break;
            case "editPerfil":
            
                
            break;
            case "edit":
                servidor.setNome(request.getParameter("name"));
                servidor.setSiape(Integer.valueOf(request.getParameter("siape")));
                servidor.setLotacao(request.getParameter("lotacao"));
                servidor.setCargo(request.getParameter("cargo"));
                servidor.setClasse(request.getParameter("classe"));
                servidor.setTelefone(request.getParameter("telefone"));
                servidor.setRamal(Integer.valueOf(request.getParameter("ramal")));
                servidor.setEmail(request.getParameter("email"));
                servidor.setLattes(request.getParameter("lattes"));
                servidor.setSituacao(Boolean.valueOf(request.getParameter("situacao")));
                servidor.setAfastado(Boolean.valueOf(request.getParameter("afastado")));
                servidor.setCategoria(request.getParameter("categoria"));
                servidor.setCurso(request.getParameter("curso"));
                servidor.setTIT(request.getParameter("tit"));
                servidor.setInicio(request.getParameter("inicio"));
                servidor.setTermino(request.getParameter("termino"));
                servidor.setTitulacao(request.getParameter("titulacao"));
                servidor.setTutor(request.getParameter("tutor"));
                servidor.setDisciplina(request.getParameter("disciplina"));
                servidor.setResolucao(request.getParameter("resolucao"));
                servidor.setEdital_preg(request.getParameter("edital"));
                
                servidorBO.updateServidor(servidor);
                
                forward = EDIT;
                
                break;
            
        } 
        request.setAttribute("pageContent", forward);
        view.forward(request, response);
    }
}