package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.data.GroupData;
import vk.VKManager;

public class Error extends Command implements ServiceCommand{

    public Error(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage("Напишите разработчику бота\n"+
                GroupData.DEVELOPER_URL.getValue(), message.getPeerId());
    }

    @Override
    public void service() {

    }
}
