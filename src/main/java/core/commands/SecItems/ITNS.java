package core.commands.SecItems;

import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import core.commands.Menu.ServiceCommand;
import core.modules.keyboards.inlineKeyboard.ITNSKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class ITNS extends Command implements ServiceCommand {

    public ITNS(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        if(clientInfo.getInlineKeyboard())
            new VKManager().sendKeyboard(ITNSKeyboard.getKeyboard(),
                    "Научно-образовательный центр \"Инфокоммуникационных технологий и нейрокогнитивных архитектур\" \n" +
                            "описание\n",
                     message.getPeerId());
        else
            new VKManager().sendMessage("Научно-образовательный центр \"Инфокоммуникационных технологий и нейрокогнитивных архитектур\" \n" +
                    "описание\n" +
                    "Подробнее:https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-infokommunikacionnih-tehnologiy-i-neyrokognitivnih-arhitektur", message.getPeerId());
    }

    @Override
    public void service() {

    }
}
