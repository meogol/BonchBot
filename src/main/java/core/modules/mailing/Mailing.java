package core.modules.mailing;

import core.db.DBCore;
import core.db.data.DBUser;
import org.apache.logging.log4j.core.jackson.ListOfMapEntryDeserializer;
import vk.VKCore;
import vk.VKManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.time.LocalDateTime;

public class Mailing {
    private static boolean isMailing = false;

    /**
     * метод осуществляет рассылку в 19 00. Как только наступает время,
     * меняется переменная isMailing, запрещая повторную расслку.
     * По истечению часа она возвращается в исходное положение
     */
    public static void execute(){
        while (true){
            var thisTime = LocalDateTime.now().toLocalTime().getHour();

            if(!isMailing)
            {
                if(thisTime == 19){
                    isMailing = true;
                    sendMail("Привет всем!");

                }else if (isMailing){
                    isMailing = false;
                }
            }

        }

    }

    public static void sendMail(String txt){
        DBCore db = new DBCore();
        ArrayList<DBUser> users = db.dbRead("SELECT * FROM Users", DBUser.class);
        var committeeEvents = VKManager.getPosts("#scienceдвиж", 328500000l, 100);
        var otherEvents = VKManager.getPosts("#примиучастие", 328500000l, 100);

        for (DBUser user : users){

            new VKManager().sendMessage(txt, user.getVk_user_id());
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
