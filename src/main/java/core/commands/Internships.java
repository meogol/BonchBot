package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.commands.basic.LoadEvents;
import vk.VKManager;

import java.util.List;

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
