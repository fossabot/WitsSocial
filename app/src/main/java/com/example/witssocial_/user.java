package com.example.witssocial_;

public class user {
    String username;
//    String description;
//    String email;


    public user(){

    }


    public user(String username){
        this.username = username;
//        this.description = description;
//        this.email = email;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String email){
        username=email;
    }

//    public String getDescription(){
//        return description;
//    }
//
//    public void setDescription(String desc){
//        description=desc;
//    }
//
//    public String getEmail(){
//        return email;
//    }
//
//    public void setEmail(String em){
//        email=em;
//    }

}
