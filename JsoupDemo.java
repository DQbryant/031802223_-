import com.sun.jndi.toolkit.url.UrlUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsoupDemo {
    static ResultSet res;

    public static void main(String[] args) {
        int page = 1;
        int time = 3;
        String url = "http://www.biquw.com/quanben/";
        Conn conn = new Conn();
        Connection connection = conn.getConnection();
        try {
            Statement sql = connection.createStatement();
            while (time-->0) {
                Document doc = Jsoup.connect(url).get();
                for (int i = 1; i <= 20; i++) {
                    String title = doc.select("#main > div.view > div.box.mt10 > div.sitebox > dl:nth-child(" + i + ") > dd:nth-child(2) > h3 > a").text();
                    String author = doc.select("#main > div.view > div.box.mt10 > div.sitebox > dl:nth-child(" + i + ") > dd:nth-child(3) > span").text();
                    String summary = doc.select("#main > div.view > div.box.mt10 > div.sitebox > dl:nth-child(" + i + ") > dd.book_des").text();
                    String jpg = doc.select("#main > div.view > div.box.mt10 > div.sitebox > dl:nth-child(" + i + ") > dt > a > img").attr("src");
                    sql.execute("insert into novels values ('" + title + "','" + author + "','" + summary + "','" + jpg + "');");
                }
                page++;
                url = "http://www.biquw.com/xs/quanbu-default-0-0-0-0-0-0-" + page + ".html";
            }
        }catch(Exception e){
                e.printStackTrace();
            }
    }
}