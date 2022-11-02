//package com.raven.connection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class DatabaseConnection {
//
//    private static DatabaseConnection instance;
//    private Connection connection;
//    protected static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ClothesShop;encrypt=true;trustServerCertificate=true;";
//    protected static String user = "sa";
//    protected static String pass = "123";
//    protected static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//
//    static {
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException ex) {
//        }
//    }
//
//    public static PreparedStatement pre(String sql, Object... args) throws SQLException {
//        Connection con = DriverManager.getConnection(dbURL, user, pass);
//        PreparedStatement pstmt = null;
//        if (sql.trim().startsWith("{")) {
//            pstmt = con.prepareCall(sql);
//        } else {
//            pstmt = con.prepareStatement(sql);
//        }
//        for (int i = 0; i < args.length; i++) {
//            pstmt.setObject(i + 1, args[i]);
//        }
//        return pstmt;
//    }
//
//    public static void exUp(String sql, Object... args) {
//        try {
//            PreparedStatement preSta = pre(sql, args);
//            try {
//                preSta.executeUpdate();
//            } finally {
//                preSta.getConnection().close();
//            }
//        } catch (SQLException ex) {
////            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static ResultSet exQu(String sql, Object... args) {
//        try {
//            PreparedStatement preSta = pre(sql, args);
//            return preSta.executeQuery();
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//}
