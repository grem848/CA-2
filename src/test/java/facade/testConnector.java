///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facade;
//
//import com.mysql.jdbc.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// *
// * @author andre
// */
//public class testConnector {
//   
//    private static String url = "jdbc:mysql://localhost:3306/ca2test";
//    private static String driverName = "com.mysql.jdbc.Driver"; 
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "1cd5288";
//    private static Connection singleton;
//
//    public static void setConnection(Connection con) {
//        singleton = con;
//    }
//
//    public static Connection connection() throws ClassNotFoundException, SQLException {
//        if (singleton == null) {
//            Class.forName("com.mysql.jdbc.Driver");
//            singleton = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
//        }
//        return singleton;
//    }
//
//}
//    
//
