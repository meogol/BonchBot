package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class OurEvents extends Command implements ServiceCommand {

    public OurEvents(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendMessage("Спасибо за подписку!\nВсе новости будут приходить в 19:00!", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
