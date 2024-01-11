package fr.pantheonsorbonne.ufr27.miage.dto;

public class User {
    String email;
    String pwd;
    public User(String email, String pwd){
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getpwd(){
        return this.pwd;
    }
    public void setPwd(){
        this.pwd = pwd;
    }
}
