package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;

public class SECs extends Command implements ServiceCommand{

    public SECs(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage("НОЦы скролменю", message.getPeerId());

    }

    @Override
    public void service() {

    }
}
