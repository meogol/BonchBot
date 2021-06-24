package core.commands.Game;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.db.DBCore;
import core.db.DBManager;
import core.db.data.DBQuestion;
import core.db.data.DBUser;
import core.db.data.DBUsersGame;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.GameKeyboard;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

import java.util.ArrayList;


public class StartGame extends Command implements ServiceCommand {
    public StartGame(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {


        /**
         *  метод оч похожий на метод из дб-менеджера. его надо проапгрейдить!
         */
        boolean presence = false;
        DBCore db = new DBCore();

        var dbUsers = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = " + message.getPeerId() + ";", DBUsersGame.class);
        if(!dbUsers.isEmpty()){
            presence = true;
        }


        if(!presence) {
            DBUsersGame user = new DBUsersGame();
            user.setVk_user_id(message.getPeerId());
            db.dbWrite("INSERT INTO Users_Game (vk_user_id, score, question_number) VALUES (" + user.getVk_user_id()
                    + ", " + user.getScore() + ", " + user.getQuestion() +")");
       }


        DBCore db1 = new DBCore();
        ArrayList<DBUsersGame> dbUsersGame = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = " + message.getPeerId() + ";", DBUsersGame.class);
        DBCore db2 = new DBCore();
        ArrayList<DBQuestion> dbQuestion = db2.dbRead("SELECT * FROM Game", DBQuestion.class);


        new VKManager().sendKeyboard(new GameKeyboard().getKeyboard(message.getPeerId()), "Поехали!\n" + dbQuestion.get(dbUsersGame.get(0).getQuestion()).getQuestion(), message.getPeerId());

    }

    @Override
    public void service() {

    }
}
