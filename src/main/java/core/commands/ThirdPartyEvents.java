package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.wall.Wallpost;
import com.vk.api.sdk.objects.wall.WallpostFull;
import core.Command;
import core.commands.basic.LoadEvents;
import core.modules.GroupData;
import vk.VKManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static vk.VKServer.vkCore;

public class ThirdPartyEvents extends Command implements ServiceCommand{
    public ThirdPartyEvents(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        List<String> attachments = LoadEvents.getPost("#приймиучастие");
        if(attachments.size() < 1)
            new VKManager().sendMessage("За последние 2 месяца нет сторонних мероприятий =(", message.getPeerId());
        else
            new VKManager().sendPost(attachments, message.getPeerId());
    }

    @Override
    public void service() {

    }
}
