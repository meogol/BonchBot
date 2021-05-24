package core.commands.SecItems;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import core.commands.ServiceCommand;
import core.modules.keyboards.inlineKeyboard.POSKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class POS extends Command implements ServiceCommand {

    public POS(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        if(clientInfo.getInlineKeyboard())
            new VKManager().sendKeyboard(POSKeyboard.getKeyboard(),
                    "Научно-образовательный центр \"Программно-определяемые системы\" \n" +
                    "описание\n",
                    message.getPeerId());
        else
            new VKManager().sendMessage("Научно-образовательный центр \"Программно-определяемые системы\" \n" +
                    "описание\n" +
                    "Подробнее:https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-programmno-opredelyaemie-sistemi", message.getPeerId());

    }

    @Override
    public void service() {

    }
}
