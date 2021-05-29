package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.db.DBCore;
import core.db.data.DBUser;
import core.modules.comands.Command;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class OurEvents extends Command implements ServiceCommand {

    public OurEvents(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendMessage("Спасибо за подписку!\nВсе новости будут приходить в 19:00!", message.getPeerId());
        DBCore db = new DBCore();
        DBUser user = new DBUser();
        user.setVk_user_id(message.getPeerId());
        user.setPost_tag("#scienceдвиж");
        db.dbWrite("INSERT INTO Usres (vk_user_id, post_tag) VALUES (" + user.getVk_user_id() + ", '" + user.getPost_tag() +"')");
    }

    @Override
    public void service() {

    }
}
