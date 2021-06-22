package core.modules.keyboards.classicKeyboard;

import com.vk.api.sdk.objects.messages.*;

import java.util.ArrayList;
import java.util.List;


public class MainKeyboard {
    private static Keyboard keyboard = new Keyboard();
    private static List<List<KeyboardButton>> allKey = new ArrayList<>();

    private static List<KeyboardButton> line0 = new ArrayList<>();
    private static List<KeyboardButton> line1 = new ArrayList<>();
    private static List<KeyboardButton> line2 = new ArrayList<>();
    private static List<KeyboardButton> line3 = new ArrayList<>();

    public static Keyboard getKeyboard() {
        return keyboard;
    }

    static{

        line0.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("\uD83C\uDF89ИГРАТЬ!")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));

        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("\uD83C\uDF89Мероприятия")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("\uD83D\uDCB0Стажировки\uD83D\uDCB0")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("\uD83D\uDE0EУчастники\uD83D\uDE0E")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("НОЦы\uD83D\uDD2C")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));

        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("❓Вопросы❓")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));
        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Настройки")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.DEFAULT));

        allKey.add(line0);
        allKey.add(line1);
        allKey.add(line2);
        allKey.add(line3);
        keyboard.setButtons(allKey);

    }
}
