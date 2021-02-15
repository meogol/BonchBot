package core.modules.keyboards.classicKeyboard;

import com.vk.api.sdk.objects.messages.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionsKeyboard {

    private static Keyboard keyboard = new Keyboard();
    private static List<List<KeyboardButton>> allKey = new ArrayList<>();
    private static List<KeyboardButton> line1 = new ArrayList<>();
    private static List<KeyboardButton> line2 = new ArrayList<>();
    private static List<KeyboardButton> line3 = new ArrayList<>();

    public static Keyboard getKeyboard() {
        return keyboard;
    }

    static{
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("\uD83D\uDD2EFAQ\uD83D\uDD2E")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("\uD83D\uDC94Нашли ошибку?\uD83D\uDC94")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("\uD83D\uDCC8Реклама в сообществе\uD83D\uDCC8")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));

        allKey.add(line1);
        allKey.add(line2);
        allKey.add(line3);
        keyboard.setButtons(allKey);

    }

}
