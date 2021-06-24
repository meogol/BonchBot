package core.commands.Subscribe;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.ServiceCommand;
import core.db.DBManager;
import core.db.data.DBUser;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.SubscribeKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Subscribe extends Command implements ServiceCommand {
    public Subscribe(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        if(!DBManager.userPresence(message.getPeerId(), "Users", DBUser.class)) {
            new VKManager().sendKeyboard(new SubscribeKeyboard().getKeyboard(), "Выберите вид подписки", message.getPeerId());
        } else {
            new VKManager().sendKeyboard(new SubscribeKeyboard().getKeyboard(message.getPeerId()), "Выберите вид подписки", message.getPeerId());
        }
    }

    @Override
    public void service() {

    }
}
