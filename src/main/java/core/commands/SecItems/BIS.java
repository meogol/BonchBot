package core.commands.SecItems;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.commands.ServiceCommand;
import core.modules.carousels.SECCarousel;
import core.modules.keyboards.inlineKeyboard.BISKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class BIS extends Command implements ServiceCommand {

    public BIS(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {
        if(clientInfo.getInlineKeyboard())
                new VKManager().sendKeyboard(BISKeyboard.getKeyboard(),
                        "Научно-образовательный центр \"Беспроводные инфотелекоммуникационные сети\" \n" +
                                "описание\n",message.getPeerId());
        else
            new VKManager().sendMessage("Научно-образовательный центр \"Беспроводные инфотелекоммуникационные сети\" \n" +
                    "описание\n" +
                    "Подробнее:https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-besprovodnie-infotelekommunikacionnie-seti", message.getPeerId());

    }

    @Override
    public void service() {

    }
}
