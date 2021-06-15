package core.commands.Questions;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.modules.comands.Command;
import core.modules.data.GroupData;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Advertising extends Command implements ServiceCommand {

    public Advertising(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendMessage("По вопросам рекламы обращайтесь к руководителю СММ отдела\n"+
                GroupData.SMM_URL.getValue(), message.getPeerId());
    }

    @Override
    public void service() {

    }
}
