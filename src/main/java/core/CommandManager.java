package core;


import core.commands.*;
import core.commands.Error;
import core.commands.SecItems.*;

import java.util.HashSet;


public class CommandManager {
    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new Unknown("unknown"));
        commands.add(new Members("Участники"));
        commands.add(new Questions("Вопросы"));
        commands.add(new SECs("НОЦы"));
        commands.add(new Internships("Стажировки"));
        commands.add(new Events("Мероприятия"));
        commands.add(new Back("Назад"));
        commands.add(new Error("Нашли ошибку?"));
        commands.add(new Advertising("Реклама в сообществе"));
        commands.add(new CommitteeEvents("Мероприятия комитета"));
        commands.add(new ThirdPartyEvents("Сторонние мероприятия"));
        commands.add(new FAQ("FAQ"));
        commands.add(new ITNS("ИТНС"));
        commands.add(new TIOS("ТИОС"));
        commands.add(new POS("ПОС"));
        commands.add(new LP("ЛП"));
        commands.add(new BIS("БИС"));
    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
