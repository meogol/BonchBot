package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Subscribe extends Command implements ServiceCommand{
    public Subscribe(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendKeyboard(SubscribeKeyboard.getKeyboard(), "Выберите вид подписки", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
