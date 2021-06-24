package core.modules.keyboards.classicKeyboard;

import com.vk.api.sdk.objects.messages.*;
import core.db.DBCore;
import core.db.data.DBQuestion;
import core.db.data.DBUser;
import core.db.data.DBUsersGame;

import java.util.ArrayList;
import java.util.List;

public class GameKeyboard {

    private static Keyboard keyboard = new Keyboard();
    private static List<List<KeyboardButton>> allKey = new ArrayList<>();
    private static List<KeyboardButton> line1 = new ArrayList<>();
    private static List<KeyboardButton> line2 = new ArrayList<>();
    private static List<KeyboardButton> line3 = new ArrayList<>();

    public Keyboard getKeyboard(int peerId){

        DBCore db = new DBCore();

        DBCore db1 = new DBCore();

        ArrayList<DBUsersGame> dbUsersGame = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = "
                                                                + peerId, DBUsersGame.class);

        ArrayList<DBQuestion> dbQuestion = db1.dbRead("SELECT * FROM Game", DBQuestion.class);

        String list_answers[] = dbQuestion.get(dbUsersGame.get(0).getQuestion()).getListAnswers();

        int listSize = list_answers.length;



        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(list_answers[0])
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(list_answers[1])
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        if (listSize == 2){
            line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        }
        else if (listSize == 3) {

            line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(list_answers[2])
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

            line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        }
        else if (listSize == 4){
            line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(list_answers[2])
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
            line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(list_answers[3])
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

            line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                    .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        }

        allKey.add(line1);
        allKey.add(line2);
        if(listSize == 4){
            allKey.add(line3);
        }
        keyboard.setButtons(allKey);

        return keyboard;
    }

}
