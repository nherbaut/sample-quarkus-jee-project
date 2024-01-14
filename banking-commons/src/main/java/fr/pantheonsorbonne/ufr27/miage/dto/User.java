package fr.pantheonsorbonne.ufr27.miage.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    @JsonProperty("email")
    String email;
    @JsonProperty("pwd")
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
