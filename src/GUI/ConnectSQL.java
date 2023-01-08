/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ADMIN
 */
public class ConnectSQL {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
           + "databaseName=QLCF;";
           
    private static String USER_NAME = "sa";
    private static String PASSWORD = "nguyenhuuhung";
    
    // Tạo 1 biến kết nối truy cập tĩnh
    public static Connection conn;
    
    public ConnectSQL(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             conn =  DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
             System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException ex) {
            System.out.println("Thiếu thư viện");
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nỗi SQL");
        }
    }
    
    public  static  ResultSet ThucThiLenhReSultset(String CauLenhSQL){
        try {
            Statement stm = conn.createStatement();
            return  stm.executeQuery(CauLenhSQL);
        } catch (SQLException ex) {
          
            System.out.println("Lỗi thực hiện truy vấn SQL");
            System.out.println("Câu lệnh của bạn: "+ CauLenhSQL);
            System.out.println("Lỗi chi tiết "+ ex.getMessage());
        }
        return null;
    }
    
    public  static int ThucThi3Lenh(String CauLenhSQL){
        try {
            Statement stm = conn.createStatement();
            return stm.executeUpdate(CauLenhSQL);
        } catch (SQLException ex) {
            System.out.println("Lỗi truy vấn SQL");
            System.out.println("Câu lệnh của bạn: " + CauLenhSQL);
            System.out.println("Lỗi chi tiết" + ex.getMessage());
        }
        return 0;
        
    
    
    }
    
    
}
