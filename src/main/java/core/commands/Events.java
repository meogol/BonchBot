package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.keyboards.EventsKeyboard;
import vk.VKManager;

public class Events extends Command implements ServiceCommand{

    public Events(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendKeyboard(EventsKeyboard.getKeyboard(), "Выбирите желаемые меро", message.getPeerId());
    }

    @Override
    public void service() {

    }


}
