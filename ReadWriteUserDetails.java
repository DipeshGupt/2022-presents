package com.example.savelife;

public class ReadWriteUserDetails {
    public String user_name,email,dates,pass,copass;

    public ReadWriteUserDetails(String textusername, String textemail, String textdates,String pass,String copass){
        this.user_name=textusername;
        this.email=textemail;
        this.dates=textdates;
        this.pass=pass;
        this.copass=copass;
    }
}
