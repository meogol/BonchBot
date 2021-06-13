package core.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vk.VKCore;
import vk.VKManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBCore <T> {
    private static final Logger LOG = LoggerFactory.getLogger(VKManager.class);

    static String url;
    static String username;
    static String password;

    private ArrayList resultData = new ArrayList();

    /**
     * Метод обращается к БД и возвращает результат чтения
     * @param s запрос к БД
     * @param tClass тип возвращаемого значения(тип Data-class-а)
     * @return
     */
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
            LOG.error(e.getMessage());

        }
        return resultData;
    }

    /**
     * Метод обращается к БД и записывает/изменяет данные
     * @param s - Запрос к БД
     */
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
            LOG.error(e.getMessage());
        }
    }


    /**
     * Метод используется для сериализации данных из БД и записи их в Data-class.
     *
     * @param resultSet строка из БД
     * @param tClass Тип data-class-а
     * @param <T> Тип data-class-а
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SQLException
     */
    private <T> T serialize (ResultSet resultSet, Class <T> tClass) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SQLException {
        T t = tClass.newInstance();
        for (var item: tClass.getFields()) {
            tClass.getDeclaredField(item.getName()).set(t, resultSet.getObject(item.getName()));
        }

        return t;


    }

    /**
     * метод читает из конфига поля для подключения к БД. Вызывается при старте сервера.
     */
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
            LOG.error(e.getMessage());
            System.out.println("Ошибка при загрузке файла конфигурации");
        }

    }


}
