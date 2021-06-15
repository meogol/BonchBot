package core.commands.SecItems;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import core.commands.Menu.ServiceCommand;
import core.modules.keyboards.inlineKeyboard.LPKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class LP extends Command implements ServiceCommand {

    public LP(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        if(clientInfo.getInlineKeyboard())
            new VKManager().sendKeyboard(LPKeyboard.getKeyboard(),
                    "Научно-образовательный центр \"Лаборатория программирования\" \n" +
                    "описание\n",
                    message.getPeerId());
        else
            new VKManager().sendMessage("Научно-образовательный центр \"Лаборатория программирования\" \n" +
                    "описание\n" +
                    "Подробнее:https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-laboratoriya-programmirovaniya", message.getPeerId());

    }

    @Override
    public void service() {

    }
}
