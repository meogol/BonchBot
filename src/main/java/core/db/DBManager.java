package core.db;

import core.db.data.DBQuestion;
import core.db.data.DBUser;
import core.db.data.DBUsersGame;

import java.util.ArrayList;

public class DBManager {
    /**
     *
     *       Метод, определяющий наличие пользователя в БД
     *       Ваня :3
     *
     * @param peerId id юзера
     * @param table таблица, в которой надо искать юзера
     * @param typeClass тип дата класса для чтения
     * @return
     */
    public static boolean userPresence(int peerId, String table, Class typeClass){
        boolean presence = false;

        DBCore db = new DBCore();

        var dbUsers = db.dbRead("SELECT * FROM "+ table+ " WHERE vk_user_id = " + peerId + ";", typeClass);

        if(!dbUsers.isEmpty()){
            presence = true;
        }

        return presence;
    }

    public static DBQuestion getQuestions(int peerId){
        DBCore db = new DBCore();

        ArrayList<DBUsersGame> dbUsersGame = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = "
                + peerId, DBUsersGame.class);

        return (DBQuestion) db.dbRead(
                "SELECT * FROM Game where id = "+dbUsersGame.get(0).score, DBQuestion.class).get(0);
    }

}
