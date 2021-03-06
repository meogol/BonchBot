package core.commands.Subscribe;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.db.DBCore;
import core.db.data.DBUser;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

import java.util.ArrayList;

/**
 * Класс для подписки на наши новости
 * для пользователя, уже занесённого в БД.
 */

public class SubOurs extends Command implements ServiceCommand {
    public SubOurs(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        DBCore db = new DBCore();
        ArrayList<DBUser> dbUsers = db.dbRead("SELECT * FROM Users WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";", DBUser.class);
        if(!dbUsers.get(0).getPost_tag().contains("#примиучастие")) {
            db.dbWrite("UPDATE Users SET post_tag = '#scienseдвиж' WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";");
            userStatus(dbUsers);
            new VKManager().sendKeyboard(new SubscribeKeyboard().getKeyboard(message.getPeerId()), "Спасибо за подписку!\nВсе новости будут приходить в 19:00!", message.getPeerId());
        } else {
            db.dbWrite("UPDATE Users SET post_tag = '#scienceдвиж " + dbUsers.get(0).getPost_tag() + "' WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";");
            userStatus(dbUsers);
            new VKManager().sendKeyboard(new SubscribeKeyboard().getKeyboard(message.getPeerId()), "Спасибо за подписку!\nВсе новости будут приходить в 19:00!", message.getPeerId());
        }

   }

    @Override
    public void service() {

    }

    private void userStatus(ArrayList<DBUser> dbUsers){
        System.out.println("__________________________________________________");
        System.out.println("DBUser_ID:\t\t" + (char) 27 + "[35m" + Integer.toString(dbUsers.get(0).getVk_user_id()) + (char) 27 + "[0m");
        System.out.println("Status:\t\t\t" + (char) 27 + "[32mПодписался на наши меро" + (char) 27 + "[0m");
    }
}
