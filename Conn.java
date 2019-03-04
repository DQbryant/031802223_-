import java.sql.*;
public class Conn {
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Novels?serverTimezone=UTC","root","root");
            System.out.println("数据库连接成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
