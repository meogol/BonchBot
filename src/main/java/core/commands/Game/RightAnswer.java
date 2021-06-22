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

public class RightAnswer extends Command implements ServiceCommand {
    public RightAnswer(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        DBCore db = new DBCore();

        ArrayList <DBUsersGame> dbUsersGame = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = "
                + Integer.toString(message.getPeerId()) + ";", DBUsersGame.class);


        ArrayList<DBQuestion> questions = db.dbRead("SELECT * FROM Game", DBQuestion.class);

        dbUsersGame.get(0).setScore(dbUsersGame.get(0).getScore() + 1);
        dbUsersGame.get(0).setQuestion(dbUsersGame.get(0).getQuestion() + 1);

        db.dbWrite("UPDATE Users_Game SET score = '" + dbUsersGame.get(0).getScore() +
                "' WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";");

        db.dbWrite("UPDATE Users_Game SET question = '" + dbUsersGame.get(0).getQuestion() +
                "' WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";");

        if (dbUsersGame.get(0).getQuestion() <= questions.size()){
            new VKManager().sendKeyboard(new GameKeyboard().getKeyboard(message.getPeerId()), "Баллы: " +
                dbUsersGame.get(0).getScore() + "/" + (dbUsersGame.get(0).getQuestion() - 1), message.getPeerId());
        }
        else {
            new VKManager().sendKeyboard(new MainKeyboard().getKeyboard(), "Поздравляем! Вы завершили игру!\nВаш результат: " +
                            dbUsersGame.get(0).getScore() + "/" + (dbUsersGame.get(0).getQuestion() - 1), message.getPeerId());
        }

    }

    @Override
    public void service() {

    }
}