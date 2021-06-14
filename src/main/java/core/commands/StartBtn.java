package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import core.modules.data.GroupData;
import core.modules.keyboards.classicKeyboard.MainKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;


public class StartBtn extends Command implements ServiceCommand{

    public StartBtn(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        new VKManager().sendKeyboard(new MainKeyboard().getKeyboard(), "Привет! [бззз] Меня зовут Бонч-Мобильбот! [боп]\n" +
                                            "Я представляю наш комитет, всегда рад помочь и ответить на твои вопросы :3 [бип-боп]\n" +
                                            "У меня ты можешь узнать о предстоящих научных мероприятиях и стажировках![буп]\n" +
                                            "Более того! [бззз] Я всегда готов рассказать о Научно-образовательных центрах (НОЦ) нашего университета " +
                                            "и, конечно же [бззз], об участниках Bonch.Science :D [бип-бип]", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
