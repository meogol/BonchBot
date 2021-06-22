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

        ArrayList<DBUsersGame> dbUsersGame = db.dbRead("SELECT * FROM Users_Game WHERE vk_user_id = " + peerId, DBUsersGame.class);

        ArrayList<DBQuestion> question = db.dbRead("SELECT * FROM Game WHERE question_number = " + dbUsersGame.get(0).getQuestion(), DBQuestion.class);

        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(question.get(0).getBtn1())
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(question.get(0).getBtn2())
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(question.get(0).getBtn3())
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(question.get(0).getBtn4())
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));

        allKey.add(line1);
        allKey.add(line2);
        allKey.add(line3);
        keyboard.setButtons(allKey);

        return keyboard;
    }

}
