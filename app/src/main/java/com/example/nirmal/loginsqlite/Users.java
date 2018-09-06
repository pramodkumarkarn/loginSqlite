package com.example.nirmal.loginsqlite;

public class Users {
    String uname, pwd;
    public Users(){

    }

    public Users(String username, String password){
        this.uname = username;
        this.pwd = password;
    }

    public String getUsername(){
        return this.uname;
    }

    public void setUsername(String string){
        this.uname = string;
    }

    public String getPassword(){
        return this.pwd;
    }

    public void setPassword(String s){
        this.pwd = s;
    }
}
