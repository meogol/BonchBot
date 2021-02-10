package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.keyboards.MainKeyboard;
import vk.VKManager;

public class Back extends Command implements ServiceCommand{
    public Back(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        //new VKManager().sendMessage("???????????", message.getPeerId());
        new VKManager().sendKeyboard(MainKeyboard.getKeyboard(), "Что вы хотите узнать?", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
