package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.keyboards.classicKeyboard.QuestionsKeyboard;
import core.modules.keyboards.classicKeyboard.SettingsKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Settings extends Command implements ServiceCommand{
    public Settings(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendKeyboard(SettingsKeyboard.getKeyboard(), "Что вы хотите поменять?", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
