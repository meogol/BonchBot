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
import core.modules.keyboards.classicKeyboard.MainKeyboard;
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

        DBCore db = new DBCore();

        //db.dbWrite("DELETE FROM Users_Game");

        if(!DBManager.userPresence(message.getPeerId(), "Users_Game", DBUsersGame.class)) {
            DBUsersGame user = new DBUsersGame();
            user.setVk_user_id(message.getPeerId());
            new DBCore().dbWrite("INSERT INTO Users_Game (vk_user_id, score, question_number) VALUES (" + user.getVk_user_id()
                    + ", " + user.getScore() + ", " + user.getQuestion() +")");
       }



        ArrayList<DBUsersGame> dbUsersGame = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = "
                + message.getPeerId() + ";", DBUsersGame.class);
        int qCount = db.dbRead("SELECT * FROM Game", DBQuestion.class).size();

        if (dbUsersGame.get(0).getQuestion() <= qCount) {

            var question = DBManager.getQuestions(message.getPeerId());
            new VKManager().sendKeyboard(new GameKeyboard().getKeyboard(message.getPeerId()),
                    "Поехали! [бззз]\n Итак, вопросик! (" +
                            dbUsersGame.get(0).getQuestion() + "/" + qCount + ")\n" + question.getQuestion(), message.getPeerId());
        }
        else {
            new VKManager().sendKeyboard(new MainKeyboard().getKeyboard(),
                    "Вы уже завершили игру! [бип-боп]\n Напоминаю, [бззз] что ваш результат: " +
                            dbUsersGame.get(0).getScore() + "/" + qCount, message.getPeerId());
        }

    }

    @Override
    public void service() {

    }
}
