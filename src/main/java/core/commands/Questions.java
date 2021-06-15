package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import core.modules.keyboards.classicKeyboard.SECKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Questions extends Command implements ServiceCommand{
    public Questions(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendKeyboard(SECKeyboard.QuestionsKeyboard.getKeyboard(), "Какой у вас вопрос?", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
