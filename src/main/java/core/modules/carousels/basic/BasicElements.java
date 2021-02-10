package core.modules.carousels.basic;

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
    private List<KeyboardButton> buttons;

    public BasicElements(){
        this.buttons = new ArrayList<>();
    }



    public void setButton(String buttonMsg, String buttonLink) {
        buttons.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(buttonMsg)
                .setType(TemplateActionTypeNames.OPEN_LINK).setLink(buttonLink)));
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
