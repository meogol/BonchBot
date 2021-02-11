package core.commands.SecItems;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.commands.ServiceCommand;
import core.modules.carousels.SECCarousel;
import core.modules.keyboards.inlineKeyboard.TIOSKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class TIOS extends Command implements ServiceCommand {

    public TIOS(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        if(clientInfo.getInlineKeyboard())
            new VKManager().sendKeyboard(TIOSKeyboard.getKeyboard(),
                    "НОЦ \"Технологии информационных и образовательных систем\" \n" +
                            "описание\n",
                    message.getPeerId());
        else
            new VKManager().sendMessage("НОЦ \"Технологии информационных и образовательных систем\" \n" +
                    "описание\n" +
                    "Подробнее:https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/noc-tehnologii-informacionnih-i-obrazovatelnih-sistem", message.getPeerId());

    }

    @Override
    public void service() {

    }
}
