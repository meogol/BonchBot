package core.commands.Game;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.db.DBCore;
import core.db.DBManager;
import core.db.data.DBUser;
import core.db.data.DBUsersGame;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.GameKeyboard;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;



public class StartGame extends Command implements ServiceCommand {
    public StartGame(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        if(!DBManager.userPresence(message.getPeerId())) {
            DBCore db = new DBCore();
            DBUsersGame user = new DBUsersGame();
            user.setVk_user_id(message.getPeerId());
            db.dbWrite("INSERT INTO Users_Game (vk_user_id, score, question_number) VALUES (" + user.getVk_user_id()
                    + ", \"" + user.getScore() + ", \"" + user.getQuestion() +"\")");
        }

        new VKManager().sendKeyboard(new GameKeyboard().getKeyboard(message.getPeerId()), "Поехали!", message.getPeerId());

    }

    @Override
    public void service() {

    }
}
