package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddMoreCoursesSQL {
    private String tablename;
    private String coursename;
    private String id;

    private String usernmaes,passwords;
    private int roles;
    private int crscnt;
    public void add(String username, String password,int role){
        crscnt = 0;
        if(role == 1){
            tablename = "lecture";
            coursename = "leccourse";
            id = "lecID";
        }else if(role == 2){
            tablename = "user";
            coursename = "course";
            id = "userID";
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select crsNo from "+coursename+" where userNo =(select "+id+" from "+tablename+" where username = '"+username+"' and password = '"+password+"');");
            while (rs.next()){
                crscnt = crscnt*10 + rs.getInt(1);

            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        usernmaes = username;
        passwords = password;
        roles = role;
        AddMoreCourseGUI adds = new AddMoreCourseGUI(usernmaes,passwords,crscnt,roles);
    }
}
