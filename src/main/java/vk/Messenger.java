package vk;


import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Commander;
import core.modules.mailing.Mailing;
import vk.callback.data.ClientInfo;

public class Messenger implements Runnable{

    private Message message;
    private ClientInfo clientInfo;

    public Messenger(Message message, ClientInfo clientInfo){

        this.message = message;
        this.clientInfo = clientInfo;
    }

    @Override
    public void run() {

        Commander.execute(message, clientInfo);
    }

}
