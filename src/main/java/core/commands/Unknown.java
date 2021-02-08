package core.commands;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.keyboards.MainKeyboard;
import vk.VKManager;


public class Unknown extends Command {

    public Unknown(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {

        new VKManager().sendKeyboard(MainKeyboard.getKeyboard(),"Неизвестная команда", message.getPeerId());
    }
}
