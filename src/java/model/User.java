package model;

public class User {
    
    private int id;
    
    private String email;
    
    private String senha;
    
    private String nome;
    
    public User ()
    {
        
    }
    
    public String getNome ()
    {
        return this.nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEmail ()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return this.id;
    }
    public void setId(int id) {
        this.id =  id;
    }
    
    public String getSenha()
    {
        return this.senha;
    }
    public void setSenha(String senha) {
        this.senha =  senha;
    } 
}
