package core.modules.keyboards.classicKeyboard;

import com.vk.api.sdk.objects.messages.*;
import core.db.DBCore;
import core.db.data.DBUser;

import java.util.ArrayList;
import java.util.List;

public class SubscribeKeyboard {

    private Keyboard keyboard = new Keyboard();
    private List<List<KeyboardButton>> allKey = new ArrayList<>();
    private List<KeyboardButton> line1 = new ArrayList<>();
    private List<KeyboardButton> line2 = new ArrayList<>();
    private List<KeyboardButton> line3 = new ArrayList<>();

    public Keyboard getKeyboard() {
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Все новости!")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Наши меро!")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Сторонние меро!")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));


        allKey.add(line1);
        allKey.add(line2);

        keyboard.setButtons(allKey);

        return keyboard;
    }

    public Keyboard getKeyboard(int peerId) {

        DBCore db = new DBCore();

        ArrayList<DBUser> dbUsers = db.dbRead("SELECT * FROM Users WHERE vk_user_id = " + peerId, DBUser.class);

        if (dbUsers.get(0).getPost_tag().contains("#scienceдвиж")){
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Наши меро :с")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        }else {
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Наши меро :3")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));

        }
        if (dbUsers.get(0).getPost_tag().contains("#примиучастие")) {
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Сторонние меро :с")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        }else{
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Cторонние меро :3")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        }

         line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        allKey.add(line1);
        allKey.add(line3);


        keyboard.setButtons(allKey);

        return keyboard;
    }

    /**
     *   Наличие пользователя в БД
     *   Ваня :3
     */

    public static boolean userPresence(int peerId){
        boolean presence = false;

        DBCore db = new DBCore();

        var dbUsers = db.dbRead("SELECT * FROM Users WHERE vk_user_id = " + peerId + ";", DBUser.class);

        if(!dbUsers.isEmpty()){
            presence = true;
        }

        return presence;
    }

}
