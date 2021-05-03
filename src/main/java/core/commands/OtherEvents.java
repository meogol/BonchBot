package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class OtherEvents extends Command implements ServiceCommand {

    public OtherEvents(String name) {
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
