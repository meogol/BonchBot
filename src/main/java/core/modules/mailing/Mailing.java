package core.modules.mailing;

import core.db.DBCore;
import core.db.data.DBUser;
import org.apache.logging.log4j.core.jackson.ListOfMapEntryDeserializer;
import vk.VKManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.time.LocalDateTime;

public class Mailing {
    private static boolean isMailing = false;

    public static void execute(){
        while (true){
            var thisTime = LocalDateTime.now().toLocalTime().getHour();

            if(!isMailing)
            {
                if(thisTime == 19){
                    isMailing = true;
                    new VKManager().sendMessage("ну типо рассылка", 173079751);
                    // TODO: 24.05.2021 тут должен быть код для отправки сообщений юзерам из бд

                    // Ваня
                    sendMail("Привет!", "#scienceдвиж");
                    sendMail("Привет всем!");

                }else {
                    isMailing = false;

                }
            }

            thisTime=thisTime;
        }

    }

    public static void sendMail(String txt){
        DBCore db = new DBCore();
        ArrayList<DBUser> users = db.dbRead("SELECT * FROM Users", DBUser.class);
        int count = users.size();

        for (DBUser user : users){
            new VKManager().sendMessage(txt, user.getId());
        }
    }

    public static void sendMail(String txt, String tag){
        DBCore db = new DBCore();
        ArrayList<DBUser> users = new ArrayList();
        switch (tag){
            case "#scienceдвиж" : {
                users = db.dbRead("SELECT * FROM Users WHERE post_tag IN ('#scienceдвиж')", DBUser.class);
                break;
            }
            case "#примиучастие" : {
                users = db.dbRead("SELECT * FROM Users WHERE post_tag IN ('#примиучастие')", DBUser.class);
                break;
            }
            case "all" : {
                users = db.dbRead("SELECT * FROM Users", DBUser.class);
                break;
            }
            default: break;
        }
        for (DBUser user : users){
            new VKManager().sendMessage(txt, user.getId());
        }
    }

}
