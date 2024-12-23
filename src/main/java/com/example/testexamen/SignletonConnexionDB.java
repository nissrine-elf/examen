package com.example.testexamen;

import java.sql.Connection;
import java.sql.DriverManager;

public class SignletonConnexionDB {
    private static Connection con;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_prep","root","");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Connection getCon(){
        return con;
    }
}
