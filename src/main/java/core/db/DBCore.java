package core.db;

import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import core.db.data.DBUser;
import vk.VKCore;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBCore <T> {

    static String url;
    static String username;
    static String password;

    private ArrayList resultData = new ArrayList();
    public ArrayList dbRead(String s, Class <T> tClass){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password) )
            {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(s);

                while (resultSet.next()){
                    resultData.add(serialize(resultSet, tClass));
                }
                resultSet.close();
                statement.close();

            } catch (NoSuchFieldException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    public void dbWrite(String s){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password) )
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate(s);



                statement.close();

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    private <T> T serialize (ResultSet resultSet, Class <T> tClass) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SQLException {
        T t = tClass.newInstance();
        for (var item: tClass.getFields()) {
            tClass.getDeclaredField(item.getName()).set(t, resultSet.getObject(item.getName()));

            int a = 0;
        }

        return t;


    }

    public static void readFromConfig(){
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
