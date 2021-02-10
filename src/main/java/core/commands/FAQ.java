package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;

public class FAQ extends Command implements ServiceCommand{

    public FAQ(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        String msg = "Как написать статью?\n" +
                "https://vk.com/@yana_tih-faq-ksnr";

        new VKManager().sendMessage(msg, message.getPeerId());
    }

    @Override
    public void service() {

    }
}
