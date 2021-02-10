package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;

import java.util.ArrayList;
import java.util.List;

public class SECs extends Command implements ServiceCommand{

    public SECs(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        List<String> s = new ArrayList<>();
        new VKManager().sendCarousel(s, message.getPeerId());

    }

    @Override
    public void service() {

    }
}
