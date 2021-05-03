package core.db;

import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import vk.VKCore;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBCore {

    static String url;
    static String username;
    static String password;

    void dbConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password) )
            {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

                resultSet.close();
                statement.close();

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    static void readFromConfig(){
        Properties prop = new Properties();
        try {

            InputStream inputStream = VKCore.class.getClassLoader().getResourceAsStream("vkconfig.properties");
            prop.load(inputStream);
            url = prop.getProperty("dbUrl");
            username = prop.getProperty("dbUsername");
            password = prop.getProperty("dbPassword");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при загрузке файла конфигурации");
        }

    }

}
