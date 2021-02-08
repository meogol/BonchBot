package core;

import com.vk.api.sdk.objects.messages.Message;
import core.commands.Unknown;

import java.util.Collection;

/**
 * Определяет команду
 */
public class CommandDeterminant {


    public static Command getCommand(Collection<Command> commands, Message message) {
        String body = message.getText();

        for (Command command : commands
        ) {
                if (command.name.equals(body)) {
                    return command;
                }
        }

        return new Unknown("unknown");
    }

}
