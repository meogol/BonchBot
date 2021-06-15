package core.commands.Questions;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.modules.comands.Command;
import core.modules.data.GroupData;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Error extends Command implements ServiceCommand {

    public Error(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendMessage("Напишите разработчику бота\n"+
                GroupData.DEVELOPER_URL.getValue(), message.getPeerId());
    }

    @Override
    public void service() {

    }
}
