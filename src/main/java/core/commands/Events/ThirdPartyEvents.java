package core.commands.Events;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.modules.comands.Command;
import vk.VKManager;
import vk.callback.data.ClientInfo;

import java.util.List;

public class ThirdPartyEvents extends Command implements ServiceCommand {
    public ThirdPartyEvents(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        List<String> attachments = VKManager.getPosts("#примиучастие", 2628000000l, 20);

        if(attachments.size() < 1)
            new VKManager().sendMessage("За последние 2 месяца нет сторонних мероприятий =(", message.getPeerId());
        else
            new VKManager().sendPost(attachments, message.getPeerId());
    }

    @Override
    public void service() {

    }
}
