package core.commands.Subscribe;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.db.DBCore;
import core.db.data.DBUser;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

/**
 * Класс для подписки только на наши новости
 * для пользователя, которого еще нет в БД.
 */

public class OurEvents extends Command implements ServiceCommand {

    public OurEvents(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        DBCore db = new DBCore();
        DBUser user = new DBUser();
        user.setVk_user_id(message.getPeerId());
        user.setPost_tag("#scienceдвиж");
        db.dbWrite("INSERT INTO Users (vk_user_id, post_tag) VALUES (" + user.getVk_user_id() + ", '" + user.getPost_tag() +"')");
        userStatus(user);
        new VKManager().sendKeyboard(new SubscribeKeyboard().getKeyboard(message.getPeerId()), "Спасибо за подписку!\nВсе новости будут приходить в 19:00!", message.getPeerId());
    }

    @Override
    public void service() {

    }

    private void userStatus(DBUser dbUsers){
        System.out.println("__________________________________________________");
        System.out.println("DBUser_ID:\t\t" + (char) 27 + "[35m" + Integer.toString(dbUsers.getVk_user_id()) + (char) 27 + "[0m");
        System.out.println("Status:\t\t\t" + (char) 27 + "[32mВнесён в БД" + (char) 27 + "[0m");
    }
}
