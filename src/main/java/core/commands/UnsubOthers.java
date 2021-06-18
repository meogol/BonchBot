package core.commands;
import com.vk.api.sdk.objects.messages.Message;
import core.db.DBCore;
import core.db.data.DBUser;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.EventsKeyboard;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;
import java.util.ArrayList;

/**
 * Класс для отписки от сторонних новостей
 * для пользователя, уже занесённого в БД.
 */

public class UnsubOthers extends Command implements ServiceCommand{
    public UnsubOthers(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        DBCore db = new DBCore();
        ArrayList<DBUser> dbUsers = db.dbRead("SELECT * FROM Users WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";", DBUser.class);
        if(!dbUsers.get(0).getPost_tag().contains("#scienceдвиж")) {
            db.dbWrite("DELETE FROM Users WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";");
            userStatus(dbUsers,1);
            new VKManager().sendKeyboard(new SubscribeKeyboard().getKeyboard(), "Вы отписались от рассылки на новости о сторонних мероприятиях :с", message.getPeerId());
        } else {
<<<<<<< HEAD
            db.dbWrite("UPDATE Users SET post_tag = '" + dbUsers.get(0).getPost_tag().replace(" #примиучастие", "") + "' WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";");
=======
            db.dbWrite("UPDATE Users SET post_tag = '#scienceдвиж' WHERE vk_user_id = " + Integer.toString(message.getPeerId()) + ";");
>>>>>>> onepantsu
            userStatus(dbUsers,2);
            new VKManager().sendKeyboard(new SubscribeKeyboard().getKeyboard(message.getPeerId()), "Вы отписались от рассылки на новости о сторонних мероприятиях :с", message.getPeerId());
        }
    }

    @Override
    public void service() {

    }

    private void userStatus(ArrayList<DBUser> dbUsers, int n){
        switch (n){
            case 1:{
                System.out.println("__________________________________________________");
                System.out.println("DBUser_ID:\t\t" + (char) 27 + "[35m" + Integer.toString(dbUsers.get(0).getVk_user_id()) + (char) 27 + "[0m");
                System.out.println("Status:\t\t\t" + (char) 27 + "[31mУдалён из БД" + (char) 27 + "[0m");
                break;
            }
            case 2:{
                System.out.println("__________________________________________________");
                System.out.println("DBUser_ID:\t\t" + (char) 27 + "[35m" + Integer.toString(dbUsers.get(0).getVk_user_id()) + (char) 27 + "[0m");
                System.out.println("Status:\t\t\t" + (char) 27 + "[31mОтписался от сторонних меро" + (char) 27 + "[0m");
                break;
            }
            default: break;
        }
    }

}
