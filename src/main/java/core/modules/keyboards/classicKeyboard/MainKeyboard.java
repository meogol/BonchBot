package core.modules.keyboards.classicKeyboard;

import com.vk.api.sdk.objects.messages.*;

import java.util.ArrayList;
import java.util.List;


public class MainKeyboard {
    private static Keyboard keyboard = new Keyboard();
    private static List<List<KeyboardButton>> allKey = new ArrayList<>();
    private static List<KeyboardButton> line1 = new ArrayList<>();
    private static List<KeyboardButton> line2 = new ArrayList<>();
    private static List<KeyboardButton> line3 = new ArrayList<>();

    public static Keyboard getKeyboard() {
        return keyboard;
    }

    static{
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Мероприятия")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Стажировки")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Участники")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("НОЦы")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));

        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Вопросы")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));

        allKey.add(line1);
        allKey.add(line2);
        allKey.add(line3);
        keyboard.setButtons(allKey);

    }
}
