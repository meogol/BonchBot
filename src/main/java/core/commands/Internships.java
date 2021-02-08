package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.groups.ContactsItem;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.wall.Wallpost;
import com.vk.api.sdk.objects.wall.WallpostFull;
import com.vk.api.sdk.objects.wall.responses.SearchResponse;
import core.Command;
import core.commands.basic.LoadEvents;
import core.modules.GroupData;
import vk.VKManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static vk.VKServer.vkCore;

public class Internships extends Command implements ServiceCommand {
    public Internships(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        List<String> attachments = LoadEvents.getPost("#стажировка");
        if(attachments.size() < 1)
            new VKManager().sendMessage("За последние 2 месяца нет стажировок =(", message.getPeerId());
        else
            new VKManager().sendPost(attachments, message.getPeerId());
    }

    @Override
    public void service() {

    }
}
