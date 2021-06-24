package core.commands.Game;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.db.DBCore;
import core.db.data.DBQuestion;
import core.db.data.DBUsersGame;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.GameKeyboard;
import core.modules.keyboards.classicKeyboard.MainKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

import java.util.ArrayList;

public class Answer extends Command implements ServiceCommand {
    private boolean endGame = false;
    public Answer(String name) {
        super(name);
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        DBCore db = new DBCore();

        ArrayList <DBUsersGame> dbUsersGame = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = "
                + message.getPeerId() + ";", DBUsersGame.class);

        DBCore db0 = new DBCore();
        ArrayList<DBQuestion> questions = db0.dbRead("SELECT * FROM Game", DBQuestion.class);

        dbUsersGame.get(0).setScore(dbUsersGame.get(0).getScore() + 1);
        dbUsersGame.get(0).setQuestion(dbUsersGame.get(0).getQuestion() + 1);

        db.dbWrite("UPDATE Users_Game SET score = '" + dbUsersGame.get(0).getScore() +
                "' WHERE vk_user_id = " + message.getPeerId() + ";");

        db.dbWrite("UPDATE Users_Game SET question_number = '" + dbUsersGame.get(0).getQuestion() +
                "' WHERE vk_user_id = " + message.getPeerId() + ";");

        if (dbUsersGame.get(0).getQuestion() <= questions.size()){

            DBCore db1 = new DBCore();
            ArrayList<DBUsersGame> dbUser= db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = " +
                    message.getPeerId() + ";", DBUsersGame.class);
            DBCore db2 = new DBCore();
            ArrayList<DBQuestion> dbQuestion = db2.dbRead("SELECT * FROM Game", DBQuestion.class);

            new VKManager().sendKeyboard(new GameKeyboard().getKeyboard(message.getPeerId()), "Баллы: " +
                    dbUsersGame.get(0).getScore() + "/" + (dbUsersGame.get(0).getQuestion()) + "\n" +
                    dbQuestion.get(dbUser.get(0).getQuestion()).getQuestion(), message.getPeerId());
        }
        else {
            new VKManager().sendKeyboard(new MainKeyboard().getKeyboard(), "Поздравляем! Вы завершили игру!\nВаш результат: " +
                    dbUsersGame.get(0).getScore() + "/" + (dbUsersGame.get(0).getQuestion() ), message.getPeerId());
        }

    }

    @Override
    public void service() {

    }
}