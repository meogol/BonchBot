package core.modules.keyboards.classicKeyboard;

import com.vk.api.sdk.objects.messages.*;

import java.util.ArrayList;
import java.util.List;

public class SECKeyboard {

    private static Keyboard keyboard = new Keyboard();
    private static List<List<KeyboardButton>> allKey = new ArrayList<>();
    private static List<KeyboardButton> line1 = new ArrayList<>();
    private static List<KeyboardButton> line2 = new ArrayList<>();
    private static List<KeyboardButton> line3 = new ArrayList<>();

    public static Keyboard getKeyboard() {
        return keyboard;
    }

    static{
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("ИТНС")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("ТИОС")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));

        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("ПОС")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));
        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("ЛП")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));

        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("БИС")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.PRIMARY));
        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Назад")
                .setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.NEGATIVE));
        allKey.add(line1);
        allKey.add(line2);
        allKey.add(line3);
        keyboard.setButtons(allKey);

    }
}
