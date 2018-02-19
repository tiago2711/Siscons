package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Servidor;
import model.User;


/**
 *
 * @author Vitor Mesaque
 */
public class ServidorDao 
{
    private Connection connection;

    public ServidorDao(Connection connection) {
        this.connection = connection;
    }
    
    public void create(Servidor servidor) {

        try
        {
           String sql=""; 
           PreparedStatement ps =connection.prepareStatement("") ;
           switch(servidor.getCategoria()){
               case"Tecnico":
                    ps =  connection.prepareStatement("INSERT INTO tecnico (nome, siape, lotacao, cargo, classe, telefone, ramal, email, lattes, situacao, afastado,coordenador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
                    ps.setString(1, servidor.getNome());
                    ps.setInt(2, servidor.getSiape());
                    ps.setString(3, servidor.getLotacao());
                    ps.setString(4, servidor.getCargo());
                    ps.setString(5, servidor.getClasse());
                    ps.setString(6, servidor.getTelefone());
                    ps.setInt(7, servidor.getRamal());
                    ps.setString(8, servidor.getEmail());
                    ps.setString(9, servidor.getLattes());
                    ps.setBoolean(10, servidor.isSituacao());
                    ps.setBoolean(11, servidor.isAfastado());
                    ps.setBoolean(12, false);
                   break;
               case"Docente":
                   if(!servidor.isAfastado()){
                        ps =  connection.prepareStatement("INSERT INTO docente (nome, siape, telefone, ramal, email, lattes, situacao, afastado,curso,tit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
                        ps.setString(1, servidor.getNome());
                        ps.setInt(2, servidor.getSiape());
                        ps.setString(3, servidor.getTelefone());
                        ps.setInt(4, servidor.getRamal());
                        ps.setString(5, servidor.getEmail());
                        ps.setString(6, servidor.getLattes());
                        ps.setBoolean(7, servidor.isSituacao());
                        ps.setBoolean(8, servidor.isAfastado());
                        ps.setString(9, servidor.getCurso());
                        ps.setString(10, servidor.getTIT());
                   }else{
                        ps =  connection.prepareStatement("INSERT INTO docente_afastado (nome, siape, lotacao, cargo, classe, telefone, ramal, email, lattes, situacao, afastado,curso,tit,ies,area,inicio,termino,substituto,nome_substituto,edital) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)"); 
                        ps.setString(1, servidor.getNome());
                        ps.setInt(2, servidor.getSiape());
                        ps.setString(3, servidor.getLotacao());
                        ps.setString(4, servidor.getCargo());
                        ps.setString(5, servidor.getClasse());
                        ps.setString(6, servidor.getTelefone());
                        ps.setInt(7, servidor.getRamal());
                        ps.setString(8, servidor.getEmail());
                        ps.setString(9, servidor.getLattes());
                        ps.setBoolean(10, servidor.isSituacao());
                        ps.setBoolean(11, servidor.isAfastado());
                        ps.setString(12, servidor.getCurso());
                        ps.setString(13, servidor.getTIT());
                        ps.setString(14, servidor.getIes());
                        ps.setString(15, servidor.getArea());
                        ps.setString(16, servidor.getInicio());
                        ps.setString(17, servidor.getTermino());
                        ps.setString(18, servidor.getSubstituto());
                        ps.setString(19, servidor.getEdital_preg());
                   }
                   break;
               case "Substituto":
                   ps =  connection.prepareStatement("INSERT INTO substituto (nome, siape, lotacao, cargo, classe, telefone, ramal, email, lattes, situacao, afastado,curso,inicio,termino,titulacao,substituicao,tutor_contrato,resolucao,edital_preg) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)");
                   ps.setString(1, servidor.getNome());
                    ps.setInt(2, servidor.getSiape());
                    ps.setString(3, servidor.getLotacao());
                    ps.setString(4, servidor.getCargo());
                    ps.setString(5, servidor.getClasse());
                    ps.setString(6, servidor.getTelefone());
                    ps.setInt(7, servidor.getRamal());
                    ps.setString(8, servidor.getEmail());
                    ps.setString(9, servidor.getLattes());
                    ps.setBoolean(10, servidor.isSituacao());
                    ps.setBoolean(11, servidor.isAfastado());
                    ps.setString(12, servidor.getCurso());
                    ps.setString(13, servidor.getInicio());
                    ps.setString(14, servidor.getTermino());
                    ps.setString(15, servidor.getTitulacao());
                    ps.setString(16, servidor.getSubstituto());
                    ps.setString(17, servidor.getTutor());
                    ps.setString(18, servidor.getResolucao());
                    ps.setString(19, servidor.getEdital_preg());
                   break;
               case "Voluntario":
                   ps =  connection.prepareStatement("INSERT INTO voluntario (nome, siape, lotacao, cargo, classe, telefone, ramal, email, lattes, situacao, afastado,curso,inicio,termino,prorrogacao,tutor,disciplina) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)");
                    ps.setString(1, servidor.getNome());
                    ps.setInt(2, servidor.getSiape());
                    ps.setString(3, servidor.getLotacao());
                    ps.setString(4, servidor.getCargo());
                    ps.setString(5, servidor.getClasse());
                    ps.setString(6, servidor.getTelefone());
                    ps.setInt(7, servidor.getRamal());
                    ps.setString(8, servidor.getEmail());
                    ps.setString(9, servidor.getLattes());
                    ps.setBoolean(10, servidor.isSituacao());
                    ps.setBoolean(11, servidor.isAfastado());
                    ps.setString(12, servidor.getCurso());
                    ps.setString(13, servidor.getLattes());
                    ps.setString(14, servidor.getInicio());
                    ps.setString(15, servidor.getTermino());
                    ps.setString(16, servidor.getProrrogacao());
                    ps.setString(17, servidor.getTutor());
                    ps.setString(18, servidor.getDisciplina());
                   break;  
           } 
            
           ps.executeUpdate(); 
           ps.close();
           
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
        
    }
      
    public ArrayList<Servidor> getServidores(int siape,String nome,String categoria) {

        try
        {
            String sql;          
            if(siape!=0){
                sql = "SELECT * FROM "+categoria+" where siape="+siape+"";
            }else{
                sql = "select * from "+categoria+" where nome like '%"+nome+"%' ";
            }
            System.out.println(sql);
            Statement stmt = this.connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList<Servidor> servidores = new ArrayList();
            while(rs.next())   
            {
                Servidor servidor = new Servidor();
                switch(categoria){
                    case"tecnico":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setLotacao(rs.getString("lotacao"));
                        servidor.setCargo(rs.getString("cargo"));
                        servidor.setClasse(rs.getString("classe"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCategoria("tecnico");
                        break;
                    case"voluntario":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setTelefone(rs.getString("telefone"));
                        
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setProrrogacao(rs.getString("prorrogacao"));
                        servidor.setTutor(rs.getString("tutor"));
                        servidor.setDisciplina(rs.getString("disciplina"));
                        servidor.setCategoria("voluntario");
                        break;
                    case"substituto":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));                        
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setTitulacao(rs.getString("titulacao"));
                        servidor.setResolucao(rs.getString("resolucao"));
                        servidor.setCategoria("substituto");
                        break;
                    case"docente_afastado":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setTIT(rs.getString("tit"));
                        servidor.setIes(rs.getString("ies"));
                        servidor.setArea(rs.getString("area"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setSubstituto(rs.getString("substituto"));
                        servidor.setEdital_preg(rs.getString("edital"));
                        servidor.setCategoria("docente_afastado");
                        break;
                    case"docente":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));                                                     
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setTIT(rs.getString("tit"));
                        servidor.setCategoria("docente");
                        break;    
                }
                servidores.add(servidor);
            }
            
            return servidores;
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
        
        return null;
    }
    
    public void update(Servidor servidor)
    {
        try
        {
            String sql;
            PreparedStatement ps =connection.prepareStatement("") ;
            System.out.println(servidor.getCategoria());
            switch(servidor.getCategoria()){
               case"tecnico":
                    ps =  connection.prepareStatement("UPDATE tecnico set nome=?,lotacao=?, cargo=?, classe=?, telefone=?, ramal=?, email=?, lattes=?, situacao=?, afastado=?,coordenador=? where siape="+servidor.getSiape()+"");
                    ps.setString(1, servidor.getNome());
                    ps.setString(2, servidor.getLotacao());
                    ps.setString(3, servidor.getCargo());
                    ps.setString(4, servidor.getClasse());
                    ps.setString(5, servidor.getTelefone());
                    ps.setInt(6, servidor.getRamal());
                    ps.setString(7, servidor.getEmail());
                    ps.setString(8, servidor.getLattes());
                    ps.setBoolean(9, servidor.isSituacao());
                    ps.setBoolean(10, servidor.isAfastado());
                    ps.setBoolean(11, false);
                   break;
               case"docente":
                   if(!servidor.isAfastado()){
                        ps =  connection.prepareStatement("UPDATE docente set nome=?, lotacao=?, cargo=?, classe=?, telefone=?, ramal=?, email=?, lattes=?, situacao=?, afastado=?,curso=?,tit=? where siape="+servidor.getSiape()+" ");
                        ps.setString(1, servidor.getNome());
                        ps.setString(2, servidor.getLotacao());
                        ps.setString(3, servidor.getCargo());
                        ps.setString(4, servidor.getClasse());
                        ps.setString(5, servidor.getTelefone());
                        ps.setInt(6, servidor.getRamal());
                        ps.setString(7, servidor.getEmail());
                        ps.setString(8, servidor.getLattes());
                        ps.setBoolean(9, servidor.isSituacao());
                        ps.setBoolean(10, servidor.isAfastado());
                        ps.setString(11, servidor.getCurso());
                        ps.setString(12, servidor.getTIT());
                   }else{
                        ps =  connection.prepareStatement("UPDATE docente_afastado set nome=?,lotacao=?, cargo=?, classe=?, telefone=?, ramal=?, email=?, lattes=?, situacao=?, afastado=?,curso=?,tit=?,ies=?,area=?,inicio=?,termino=?,substituto=?,nome_substituto=?,edital=? where siape="+servidor.getSiape()+""); 
                        ps.setString(1, servidor.getNome());
                        ps.setString(2, servidor.getLotacao());
                        ps.setString(3, servidor.getCargo());
                        ps.setString(4, servidor.getClasse());
                        ps.setString(5, servidor.getTelefone());
                        ps.setInt(6, servidor.getRamal());
                        ps.setString(7, servidor.getEmail());
                        ps.setString(8, servidor.getLattes());
                        ps.setBoolean(9, servidor.isSituacao());
                        ps.setBoolean(10, servidor.isAfastado());
                        ps.setString(11, servidor.getCurso());
                        ps.setString(12, servidor.getTIT());
                        ps.setString(13, servidor.getIes());
                        ps.setString(14, servidor.getArea());
                        ps.setString(15, servidor.getInicio());
                        ps.setString(16, servidor.getTermino());
                        ps.setString(17, servidor.getSubstituto());
                        ps.setString(18, servidor.getEdital_preg());
                   }
                   break;
               case "substituto":
                   ps =  connection.prepareStatement("UPDATE substituto set nome=?, lotacao=?, cargo=?, classe=?, telefone=?, ramal=?, email=?, lattes=?, situacao=?, afastado=?,curso=?,inicio=?,termino=?,titulacao=?,substituicao=?,tutor_contrato=?,resolucao=?,edital_preg=? where siape="+servidor.getSiape()+"");
                   ps.setString(1, servidor.getNome());
                    ps.setString(3, servidor.getLotacao());
                    ps.setString(4, servidor.getCargo());
                    ps.setString(5, servidor.getClasse());
                    ps.setString(6, servidor.getTelefone());
                    ps.setInt(7, servidor.getRamal());
                    ps.setString(8, servidor.getEmail());
                    ps.setString(9, servidor.getLattes());
                    ps.setBoolean(10, servidor.isSituacao());
                    ps.setBoolean(11, servidor.isAfastado());
                    ps.setString(12, servidor.getCurso());
                    ps.setString(13, servidor.getInicio());
                    ps.setString(14, servidor.getTermino());
                    ps.setString(15, servidor.getTitulacao());
                    ps.setString(16, servidor.getSubstituto());
                    ps.setString(17, servidor.getTutor());
                    ps.setString(18, servidor.getResolucao());
                    ps.setString(19, servidor.getEdital_preg());
                   break;
               case "voluntario":
                   ps =  connection.prepareStatement("UPDATE voluntario set nome=?, lotacao=?, cargo=?, classe=?, telefone=?, ramal=?, email=?, lattes=?, situacao=?, afastado=?,curso=?,inicio=?,termino=?,prorrogacao=?,tutor=?,disciplina=? where siape="+servidor.getSiape()+"");
                    ps.setString(1, servidor.getNome());
                    ps.setString(3, servidor.getLotacao());
                    ps.setString(4, servidor.getCargo());
                    ps.setString(5, servidor.getClasse());
                    ps.setString(6, servidor.getTelefone());
                    ps.setInt(7, servidor.getRamal());
                    ps.setString(8, servidor.getEmail());
                    ps.setString(9, servidor.getLattes());
                    ps.setBoolean(10, servidor.isSituacao());
                    ps.setBoolean(11, servidor.isAfastado());
                    ps.setString(12, servidor.getCurso());
                    ps.setString(13, servidor.getLattes());
                    ps.setString(14, servidor.getInicio());
                    ps.setString(15, servidor.getTermino());
                    ps.setString(16, servidor.getProrrogacao());
                    ps.setString(17, servidor.getTutor());
                    ps.setString(18, servidor.getDisciplina());
                   break;  
           } 

           ps.executeUpdate();
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        } 
    }
    
    public Servidor getServidor(int siape,String categoria){    
        try {
            String sql = "select * from "+categoria+" where siape='"+siape+"'";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Servidor servidor = new Servidor();
            if(rs.next()){
                switch(categoria){
                    case"tecnico":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setLotacao(rs.getString("lotacao"));
                        servidor.setCargo(rs.getString("cargo"));
                        servidor.setClasse(rs.getString("classe"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCategoria("tecnico");
                        break;
                    case"voluntario":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setLotacao(rs.getString("lotacao"));
                        servidor.setCargo(rs.getString("cargo"));
                        servidor.setClasse(rs.getString("classe"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setProrrogacao(rs.getString("prorrogacao"));
                        servidor.setTutor(rs.getString("tutor"));
                        servidor.setDisciplina(rs.getString("disciplina"));
                        servidor.setCategoria("voluntario");
                        break;
                    case"substituto":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setLotacao(rs.getString("lotacao"));
                        servidor.setCargo(rs.getString("cargo"));
                        servidor.setClasse(rs.getString("classe"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setTitulacao(rs.getString("titulacao"));
                        servidor.setSubstituto(rs.getString("substituto"));
                        servidor.setTutor(rs.getString("tutor"));
                        servidor.setResolucao(rs.getString("resolucao"));
                        servidor.setEdital_preg(rs.getString("edital"));
                        servidor.setCategoria("substituto");
                        break;
                    case"docente_afastado":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setLotacao(rs.getString("lotacao"));
                        servidor.setCargo(rs.getString("cargo"));
                        servidor.setClasse(rs.getString("classe"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setTIT(rs.getString("tit"));
                        servidor.setIes(rs.getString("ies"));
                        servidor.setArea(rs.getString("area"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setSubstituto(rs.getString("substituto"));
                        servidor.setEdital_preg(rs.getString("edital"));
                        servidor.setCategoria("docente_afastado");
                        break;
                    case"docente":
                        servidor.setNome(rs.getString("nome"));
                        servidor.setSiape(rs.getInt("siape"));
                        servidor.setLotacao(rs.getString("lotacao"));
                        servidor.setCargo(rs.getString("cargo"));
                        servidor.setClasse(rs.getString("classe"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setTIT(rs.getString("tit"));
                        servidor.setCategoria("docente");
                        break;    
                }
            }
            return servidor;
        } catch (SQLException ex) {
            Logger.getLogger(ServidorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Servidor> getRelatorio(String tabela){
        String sql="";
        switch(tabela){
            case"coordenadores":
                sql="select * from docente where coordenador='true';";
                break;
            case"exprofessores":
                sql="select * from docente where situacao='false';";
                break;
            case"extecnicos":
                sql="select * from tecnico where situacao='false';";
                break;
            case"grade":
                sql="";
                break;
            case"porcurso":
                sql="";
                break;
            case"substituto":
                sql="select * from substituto;";
                break;
            case"tecnicos":
                
                sql="select * from tecnico where situacao='true';";
                break;
            case"todos":
                sql="";
                break;
            case"voluntario":
                sql="select * from voluntario;";
                break;        
        }
        Statement stmt;
        try {
            stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Servidor> servidores = new ArrayList();
            while(rs.next()){
                Servidor servidor = new Servidor();
                if(tabela.equals("coordenadores")||tabela.equals("porcurso")||tabela.equals("exprofessores")||tabela.equals("grade")||tabela.equals("porcurso")){
                    servidor.setNome(rs.getString("nome"));
                    servidor.setSiape(rs.getInt("siape"));
                    servidor.setLotacao(rs.getString("lotacao"));
                    servidor.setCargo(rs.getString("cargo"));
                    servidor.setClasse(rs.getString("classe"));
                    servidor.setTelefone(rs.getString("telefone"));
                    servidor.setRamal(rs.getInt("ramal"));
                    servidor.setEmail(rs.getString("email"));
                    servidor.setLattes(rs.getString("lattes"));
                    servidor.setSituacao(rs.getBoolean("situacao"));
                    servidor.setAfastado(rs.getBoolean("afastado"));
                    servidor.setCurso(rs.getString("curso"));
                    servidor.setTIT(rs.getString("tit"));
                    servidor.setCategoria("docente");
                }
                if(tabela.equals("tecnicos")||tabela.equals("extecnicos")){
                    System.out.println("testando tecnicos");
                    servidor.setNome(rs.getString("nome"));
                    servidor.setSiape(rs.getInt("siape"));
                    servidor.setLotacao(rs.getString("lotacao"));
                    servidor.setCargo(rs.getString("cargo"));
                    servidor.setClasse(rs.getString("classe"));
                    servidor.setTelefone(rs.getString("telefone"));
                    servidor.setRamal(rs.getInt("ramal"));
                    servidor.setEmail(rs.getString("email"));
                    servidor.setLattes(rs.getString("lattes"));
                    servidor.setSituacao(rs.getBoolean("situacao"));
                    servidor.setAfastado(rs.getBoolean("afastado"));
                    servidor.setCategoria("tecnico");
                }
                if(tabela.equals("voluntario")){
                    servidor.setNome(rs.getString("nome"));
                    servidor.setSiape(rs.getInt("siape"));
                    servidor.setLotacao(rs.getString("lotacao"));
                    servidor.setCargo(rs.getString("cargo"));
                    servidor.setClasse(rs.getString("classe"));
                    servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setProrrogacao(rs.getString("prorrogacao"));
                        servidor.setTutor(rs.getString("tutor"));
                        servidor.setDisciplina(rs.getString("disciplina"));
                        servidor.setCategoria("voluntario");
                }
                if(tabela.equals("substituto")){
                   servidor.setNome(rs.getString("nome"));
                   servidor.setSiape(rs.getInt("siape"));
                    servidor.setLotacao(rs.getString("lotacao"));
                        servidor.setCargo(rs.getString("cargo"));
                        servidor.setClasse(rs.getString("classe"));
                        servidor.setTelefone(rs.getString("telefone"));
                        servidor.setRamal(rs.getInt("ramal"));
                        servidor.setEmail(rs.getString("email"));
                        servidor.setLattes(rs.getString("lattes"));
                        servidor.setSituacao(rs.getBoolean("situacao"));
                        servidor.setAfastado(rs.getBoolean("afastado"));
                        servidor.setCurso(rs.getString("curso"));
                        servidor.setInicio(rs.getString("inicio"));
                        servidor.setTermino(rs.getString("termino"));
                        servidor.setTitulacao(rs.getString("titulacao"));
                        servidor.setSubstituto(rs.getString("substituto"));
                        servidor.setTutor(rs.getString("tutor"));
                        servidor.setResolucao(rs.getString("resolucao"));
                        servidor.setEdital_preg(rs.getString("edital"));
                        servidor.setCategoria("substituto"); 
                }
                servidores.add(servidor);
            }
            return servidores;
        } catch (SQLException ex) {
            Logger.getLogger(ServidorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
}