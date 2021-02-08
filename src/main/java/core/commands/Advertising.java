package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;

public class Advertising extends Command implements ServiceCommand{

    public Advertising(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage("По вопросам рекламы обращайтесь к \"ссылка\"", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
