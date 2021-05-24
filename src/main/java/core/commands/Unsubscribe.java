package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Unsubscribe extends Command implements ServiceCommand  {

    public Unsubscribe(String name) { super(name); }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendMessage("Вы отписались от рассылки :с", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
