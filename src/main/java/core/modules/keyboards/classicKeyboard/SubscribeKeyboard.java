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


    /**
     * Метод, вызывающий клавиатуру управления подпиской
     * для юзера, которого еще нет в БД
     */
    public Keyboard getKeyboard() {

        /**
         * Добавление кнопок в лайны
         */
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Все новости!")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Наши меро!")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Сторонние меро!")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));


        /**
         * Добавление лайнов на клавиатуру
         */
        allKey.add(line1);
        allKey.add(line2);
        keyboard.setButtons(allKey);

        return keyboard;
    }

    /**
     * Метод, вызывающий клавиатуру управления подпиской
     * для юзера, который уже был занесён в БД
     */
    public Keyboard getKeyboard(int peerId) {

        DBCore db = new DBCore();
        ArrayList<DBUser> dbUsers = db.dbRead("SELECT * FROM Users WHERE vk_user_id = " + peerId, DBUser.class);

        /**
         * Для отладки тегов и кнопок подписки
         */
        subKeyDebug(dbUsers);

        /**
         * Условия для подбора кнопок в зависимости от тегов юзера
         */
        if (dbUsers.get(0).getPost_tag().contains("#scienceдвиж")){
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Наши меро :с")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        } else {
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Наши меро :3")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        }

        if (dbUsers.get(0).getPost_tag().contains("#примиучастие")) {
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Сторонние меро :с")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        } else{
            line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Сторонние меро :3")
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
     * Для отладки тегов и кнопок подписки
     */
    private void subKeyDebug(ArrayList<DBUser> dbUsers){
        System.out.println("__________________________________________________");
        System.out.println("DBUser_ID:\t\t" + (char) 27 + "[35m" + Integer.toString(dbUsers.get(0).getVk_user_id()) + (char) 27 + "[0m");
        System.out.println("DBUser_TAG:\t\t" + (char) 27 + "[34m" + dbUsers.get(0).getPost_tag() + (char) 27 + "[0m");
        System.out.print("#scienceдвиж:\t");
        if (!dbUsers.get(0).getPost_tag().contains("#scienceдвиж")) {
            System.out.println((char) 27 + "[31m" + dbUsers.get(0).getPost_tag().contains("#scienceдвиж") + (char) 27 + "[0m");
        } else {
            System.out.println((char) 27 + "[32m" + dbUsers.get(0).getPost_tag().contains("#scienceдвиж") + (char) 27 + "[0m");
        }
        System.out.print("#примиучастие:\t");
        if (!dbUsers.get(0).getPost_tag().contains("#примиучастие")) {
            System.out.println((char) 27 + "[31m" + dbUsers.get(0).getPost_tag().contains("#примиучастие") + (char) 27 + "[0m");
        } else {
            System.out.println((char) 27 + "[32m" + dbUsers.get(0).getPost_tag().contains("#примиучастие") + (char) 27 + "[0m");
        }
    }

    /**
     *   Метод, определяющий наличие пользователя в БД
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
