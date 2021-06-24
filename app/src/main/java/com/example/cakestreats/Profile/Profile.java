package com.example.cakestreats.Profile;

import com.example.cakestreats.Modelos.User;

public class Profile {
    private static Profile instance;
    private User user;
    private Profile(User user){
        this.user=user;
    }
    public static Profile getInstance(User user){
        if(instance==null || instance.getUser()==null){
            instance=new Profile(user);
        }
        return instance;
    }
    public void exitProfile(){
        user=null;
    }
    public User getUser(){
        return user;
    }
}
