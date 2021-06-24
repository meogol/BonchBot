package core.commands.Game;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.db.DBCore;
import core.db.DBManager;
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

        ArrayList<DBQuestion> question = db.dbRead("SELECT * FROM Game WHERE id = " + (dbUsersGame.get(0).getQuestion()), DBQuestion.class);

        boolean isRight = false;
        if (question.get(0).getAnswer().equals(message.getText())){
            isRight = true;
            dbUsersGame.get(0).setScore(dbUsersGame.get(0).getScore() + 1);
        }
        dbUsersGame.get(0).setQuestion(dbUsersGame.get(0).getQuestion() + 1);


        if (isRight){
            db.dbWrite("UPDATE Users_Game SET score = '" + dbUsersGame.get(0).getScore() +
                    "' WHERE vk_user_id = " + message.getPeerId() + ";");

            db.dbWrite("UPDATE Users_Game SET question_number = '" + dbUsersGame.get(0).getQuestion() +
                    "' WHERE vk_user_id = " + message.getPeerId() + ";");
        }
        else {
            db.dbWrite("UPDATE Users_Game SET question_number = '" + dbUsersGame.get(0).getQuestion() +
                    "' WHERE vk_user_id = " + message.getPeerId() + ";");
        }

        int qCount = db.dbRead("SELECT * FROM Game", DBQuestion.class).size();

        if (dbUsersGame.get(0).getQuestion() > qCount){
            setEndGame(true);
        }

        if (!endGame){
            question = db.dbRead("SELECT * FROM Game WHERE id = " + dbUsersGame.get(0).getQuestion(), DBQuestion.class);
            new VKManager().sendKeyboard(new GameKeyboard().getKeyboard(message.getPeerId()), "Следующий вопрос! (" +
                    dbUsersGame.get(0).getQuestion() + "/" + qCount + ")\n" + question.get(0).getQuestion(), message.getPeerId());
        }
        else {
            new VKManager().sendKeyboard(new MainKeyboard().getKeyboard(), "Поздравляю! [буп] Вы завершили игру!\nВаш результат: " +
                    dbUsersGame.get(0).getScore() + "/" + qCount, message.getPeerId());
        }

    }

    @Override
    public void service() {

    }
}