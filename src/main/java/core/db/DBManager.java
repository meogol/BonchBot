package core.db;

import core.db.data.DBUser;

public class DBManager {
    /**
     *   Метод, определяющий наличие пользователя в БД
     *   Ваня :3
     */

    public static boolean userPresence(int peerId){
        boolean presence = false;

        DBCore db = new DBCore();

        var dbUsers = db.dbRead("SELECT * FROM Users WHERE vk_user_id = " + peerId + ";", DBUser.class);

        if(!dbUsers.isEmpty()){
            presence = true;
        }

        return presence;
    }
}
