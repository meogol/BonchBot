package core.commands.Questions;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.modules.comands.Command;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class FAQ extends Command implements ServiceCommand {

    public FAQ(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        String msg = "Как написать статью?\n" +
                "https://vk.com/@yana_tih-faq-ksnr";

        new VKManager().sendMessage(msg, message.getPeerId());
    }

    @Override
    public void service() {

    }
}
