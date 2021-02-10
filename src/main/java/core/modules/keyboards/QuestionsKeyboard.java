package core.modules.keyboards;

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
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("FAQ")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Нашли ошибку?")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Реклама в сообществе")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));

        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));

        allKey.add(line1);
        allKey.add(line2);
        allKey.add(line3);
        keyboard.setButtons(allKey);

    }

}
