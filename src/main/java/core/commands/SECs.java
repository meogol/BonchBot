package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.carousels.SECCarousel;
import core.modules.keyboards.classicKeyboard.SECKeyboard;
import vk.VKManager;
import vk.callback.data.ClientInfo;

public class SECs extends Command implements ServiceCommand{

    public SECs(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        if(clientInfo.getCarousel())
                new VKManager().sendCarousel("О каком из научно-образовательных центров вы хотите узнать?",
                        new SECCarousel(), message.getPeerId());
        else if(clientInfo.getKeyboard()){
            new VKManager().sendKeyboard(SECKeyboard.getKeyboard(),"О каком из научно-образовательных центров вы" +
                    " хотите узнать?", message.getPeerId());
        }else
            new VKManager().sendMessage("Напишите название интересующего вас научно-образовательного центра\n" +
                    "ИТНС\n" +
                    "ТИОС\n" +
                    "ПОС\n" +
                    "ЛП\n" +
                    "БИС\n", message.getPeerId());
        System.out.println("fsgsdffds");
        System.out.println("fsgsdffds");
    }

    @Override
    public void service() {

    }
}
