package core.modules.comands;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Menu.Back;

import java.util.Collection;

/**
 * Определяет команду
 */
public class CommandDeterminant {


    public static Command getCommand(Collection<Command> commands, Message message) {
        String body = message.getText().toLowerCase();

        for (Command command : commands
        ) {
                if (command.name.equals(body)) {
                    return command;
                }
        }

        return new Back("unknown");
    }

}
