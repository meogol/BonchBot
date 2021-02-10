package core.modules.carousels;

import com.google.gson.Gson;
import com.vk.api.sdk.objects.messages.KeyboardButton;
import com.vk.api.sdk.objects.messages.KeyboardButtonAction;
import com.vk.api.sdk.objects.messages.KeyboardButtonColor;
import com.vk.api.sdk.objects.messages.TemplateActionTypeNames;
import com.vk.api.sdk.objects.wall.CarouselBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicElements {
    List<KeyboardButton> buttons;

    public KeyboardButton getButton() {
        return buttons.get(0);
    }

    public void setButton(String buttonMsg, String buttonLink) {
        this.buttons = new ArrayList<>();
        buttons.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(buttonMsg)
                .setType(TemplateActionTypeNames.OPEN_LINK).setLink(buttonLink)));
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
