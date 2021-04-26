package vk.callback.data;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.messages.MessageAction;

import java.util.List;

public class ClientInfo {
    @SerializedName("button_actions")
    private List<String> buttonActions;

    @SerializedName("keyboard")
    private Boolean keyboard;

    @SerializedName("inline_keyboard")
    private Boolean inlineKeyboard;

    @SerializedName("carousel")
    private Boolean carousel;

    @SerializedName("lang_id")
    private Integer langId;

    public Boolean getKeyboard() {
        return keyboard;
    }

    public Boolean getCarousel() {
        return carousel;
    }

    public Boolean getInlineKeyboard() {
        return inlineKeyboard;
    }

    public Integer getLangId() {
        return langId;
    }

    public List<String> getButtonActions() {
        return buttonActions;
    }
}
