package fr.pantheonsorbonne.ufr27.miage.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    String email;
    String pwd;
    public User(String email, String pwd){
        this.email = email;
        this.pwd = pwd;
    }
    public User(){}
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPwd(){
        return this.pwd;
    }
    public void setPwd(){
        this.pwd = pwd;
    }
}
