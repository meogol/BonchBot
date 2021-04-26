package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.keyboards.classicKeyboard.MainKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;


public class Unknown extends Command {

    public Unknown(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        if(clientInfo.getKeyboard())
            new VKManager().sendKeyboard(MainKeyboard.getKeyboard(),"Неизвестная команда", message.getPeerId());
        else
            new VKManager().sendMessage("Неизвестная команда", message.getPeerId());
    }
}
