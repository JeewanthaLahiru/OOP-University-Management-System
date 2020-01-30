package com.company;
import java.sql.*;

public class SignupSql {
    private String tablename;
    private String id;
    private String coursetable;
    public void signuser(String name,String username,String index,String password,int role){
        if(role == 1){
            tablename = "lecture";
        }else if(role == 2){
            tablename = "user";
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root","");
            Statement st = con.createStatement();
            st.executeUpdate("insert into "+tablename+" (name, username, indexNo, password) values('"+name+"','"+username+"','"+index+"','"+password+"');");

            con.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void addCoursesOnly(String username, String password,int oop,int database, int datastructure , int role){
        if(role == 1 ){
            tablename = "lecture";
            id = "lecID";
            coursetable = "leccourse";
        }else if(role == 2){
            tablename = "user";
            id = "userID";
            coursetable = "course";
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ums","root","");
            Statement st = con.createStatement();
            if( oop == 1 ){
                st.executeUpdate("insert into "+coursetable+" (userNo, crsName, crsNo) values ((select "+id+" from "+tablename+" where username = '"+username+"' and password = '"+password+"'),'SENG 12233 - Object Oriented Programing','1');");
            }
            if( database == 1){
                st.executeUpdate("insert into "+coursetable+" (userNo, crsName, crsNo) values ((select "+id+" from "+tablename+" where username = '"+username+"' and password = '"+password+"'),'SENG 12223 - Databases Design and Developement','2');");
            }
            if(datastructure == 1){
                st.executeUpdate("insert into "+coursetable+" (userNo, crsName, crsNo) values ((select "+id+" from "+tablename+" where username = '"+username+"' and password = '"+password+"'),'SENG 12213 - Data Structures and Algorithm','3');");
            }
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
