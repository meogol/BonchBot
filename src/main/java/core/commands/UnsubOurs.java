package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.db.DBCore;
import core.db.data.DBUser;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

import java.util.ArrayList;

public class UnsubOurs extends Command implements ServiceCommand{
    public UnsubOurs(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        DBCore db = new DBCore();
        ArrayList<DBUser> dbUsers = db.dbRead("SELECT FROM Users WHERE vk_user_id = " + Integer.toString(message.getPeerId()), DBUser.class);
        if(!dbUsers.get(0).getPost_tag().contains("#примиучастие")) {
            db.dbWrite("UPDATE FROM Users WHERE vk_user_id = " + Integer.toString(message.getPeerId()));
        } else {
            db.dbWrite("UPDATE Users SET post_tag = '#примиучастие' WHERE vk_user_id = " + Integer.toString(message.getPeerId()));
        }

        new VKManager().sendMessage("Вы отписались от рассылки на новости о наших мероприятиях :с", message.getPeerId());
    }


    @Override
    public void service() {

    }
}
