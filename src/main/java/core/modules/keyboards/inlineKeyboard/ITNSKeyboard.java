package core.modules.keyboards.inlineKeyboard;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;
import com.vk.api.sdk.objects.messages.KeyboardButtonAction;
import com.vk.api.sdk.objects.messages.TemplateActionTypeNames;

import java.util.ArrayList;
import java.util.List;

public class ITNSKeyboard {
    private final static Keyboard keyboard = new Keyboard();
    private final static List<List<KeyboardButton>> allKey = new ArrayList<>();
    private final static List<KeyboardButton> line1 = new ArrayList<>();;

    public static Keyboard getKeyboard() {
        return keyboard;
    }

    static{
        keyboard.setInline(true);
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Подробнее")
                .setType(TemplateActionTypeNames.OPEN_LINK).setLink("https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-infokommunikacionnih-tehnologiy-i-neyrokognitivnih-arhitektur")));

        allKey.add(line1);
        keyboard.setButtons(allKey);

    }
}
