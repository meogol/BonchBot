package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.keyboards.classicKeyboard.MainKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class Back extends Command implements ServiceCommand{
    public Back(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        //new VKManager().sendMessage("???????????", message.getPeerId());
        if(clientInfo.getKeyboard())
            new VKManager().sendKeyboard(MainKeyboard.getKeyboard(), "Что вы хотите узнать?", message.getPeerId());
        else
            new VKManager().sendMessage("Напишите поле интересующего вас поля\n" +
                    "Мероприятия комитета-1\n" +
                    "Сторонние мероприятия-2\n" +
                    "Стажировка-3\n" +
                    "Участники-4\n" +
                    "НОЦы-5\n" +
                    "FAQ-6\n"+
                    "Нашли ошибку?-7\n" +
                    "Реклама в сообществе-8\n", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
