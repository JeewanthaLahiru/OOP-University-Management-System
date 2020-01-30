package com.company;
import java.sql.*;

public class SigninSql extends Authentication {
    private String namej;
    private String usernamej;
    private String indexj;
    private String coursej;
    private String passwordj;

    private String tablename;
    private String coursename;
    private String id;
    public int signin(String username,String password,int role){
        if(role == 1){
            tablename = "lecture";
            coursename = "leccourse";
            id = "lecID";
        }else if(role == 2){
            tablename = "user";
            coursename = "course";
            id = "userID";
        }
        int count = 0;
        setUsername(username);
        setPassword(password);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from "+tablename+" ");

            while (rs.next()){
                if(username.equals(rs.getString(3))&& password.equals(rs.getString(5))){
                    namej = rs.getString(2);
                    usernamej = rs.getString(3);
                    indexj = rs.getString(4);
                    //usernamej = rs.getString(4);
                    count =1;
                }
            }
            con.close();

        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select crsName from "+coursename+" where userNo =(select "+id+" from "+tablename+" where username = '"+getUsername()+"' and password = '"+getPassword()+"');");
            String crses="";
            while (rs.next()){
                crses = crses + rs.getString(1) + "\n" ;
            }
            coursej = crses;
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        passwordj = password;
        if(count == 1) {
            ProfileGUI prfl = new ProfileGUI();
            prfl.profileGUI(namej,username,indexj,coursej,password,role);
        }
        return count;
    }
}
