package core.modules.keyboards.classicKeyboard;

import com.vk.api.sdk.objects.messages.*;
import core.db.DBCore;
import core.db.DBManager;
import core.db.data.DBQuestion;
import core.db.data.DBUser;
import core.db.data.DBUsersGame;

import java.util.ArrayList;
import java.util.List;

public class GameKeyboard {

    private  Keyboard keyboard = new Keyboard();
    private  List<List<KeyboardButton>> allKey = new ArrayList<>();

    public Keyboard getKeyboard(int peerId){

        var dbQuestion = DBManager.getQuestions(peerId);

        String[] list_answers = dbQuestion.getListAnswers();

        for (var answer: list_answers) {
            List<KeyboardButton> line = new ArrayList();
            line.add(
                    new KeyboardButton().setAction(
                    new KeyboardButtonAction().setLabel(answer)
                    .setType(TemplateActionTypeNames.TEXT))
                    .setColor(KeyboardButtonColor.DEFAULT));
            allKey.add(line);
        }

        List<KeyboardButton> line = new ArrayList();
        line.add(
                new KeyboardButton().setAction(
                        new KeyboardButtonAction().setLabel("Назад")
                                .setType(TemplateActionTypeNames.TEXT))
                        .setColor(KeyboardButtonColor.NEGATIVE));
        allKey.add(line);

        keyboard.setButtons(allKey);

        return keyboard;
    }

}
