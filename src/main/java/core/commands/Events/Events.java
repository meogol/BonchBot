package core.commands.Events;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.EventsKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Events extends Command implements ServiceCommand {

    public Events(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendKeyboard(EventsKeyboard.getKeyboard(), "Выбирите желаемые меро", message.getPeerId());
    }

    @Override
    public void service() {

    }


}
