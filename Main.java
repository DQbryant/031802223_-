import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static ResultSet res;
    public static void main(String[] args) {
        Conn c = new Conn();
        Connection con = c.getConnection();
        try {
            Statement sql = con.createStatement();
            res = sql.executeQuery("select *from user");
            System.out.println("当前用户表：");
            while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                String username = res.getString("username");
                String password = res.getString("password");
                String phone = res.getString("phone");
                String gender = res.getString("gender");
                System.out.println("编号："+id+" 姓名："+name+" 性别："+gender+" 用户名："+username+" 密码:"+password+" 电话："+phone);
            }
            sql.execute("insert into user values (3,'用户3','男','root3','root3','10086')");
            System.out.println("用户添加成功！");
            sql.execute("update user set password = 'rootroot2' where id = 2");
            System.out.println("用户资料修改成功！");
            sql.execute("delete from user where id = 1");
            System.out.println("用户资料删除成功！");
            res = sql.executeQuery("select *from user");
            System.out.println("操作后的用户表：");
            while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                String username = res.getString("username");
                String password = res.getString("password");
                String phone = res.getString("phone");
                String gender = res.getString("gender");
                System.out.println("编号："+id+" 姓名："+name+" 性别："+gender+" 用户名："+username+" 密码:"+password+" 电话："+phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
