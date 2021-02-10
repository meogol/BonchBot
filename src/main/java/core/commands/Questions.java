package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.keyboards.QuestionsKeyboard;
import vk.VKManager;

public class Questions extends Command implements ServiceCommand{
    public Questions(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendKeyboard(QuestionsKeyboard.getKeyboard(), "Какой у вас вопрос?", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
