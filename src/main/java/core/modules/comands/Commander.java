package core.modules.comands;

import com.vk.api.sdk.objects.messages.Message;
import vk.callback.data.ClientInfo;

public class Commander {

    /**
     * Обработка сообщений, получаемых через сервис Вконтакте. Имеет ряд дополнительной информации.
     * @param message сообщение (запрос) пользователя
     */
    public static void execute(Message message, ClientInfo clientInfo){
        CommandDeterminant.getCommand(CommandManager.getCommands(), message).exec(message, clientInfo);
    }

}
