package core;


import core.commands.*;
import core.commands.Error;
import core.commands.SecItems.*;

import java.util.HashSet;


public class CommandManager {
    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new Unknown("unknown"));
        commands.add(new Members("участники"));
        commands.add(new Questions("вопросы"));
        commands.add(new SECs("ноцы"));
        commands.add(new Internships("стажировки"));
        commands.add(new Events("мероприятия"));
        commands.add(new Back("назад"));
        commands.add(new Error("нашли ошибку?"));
        commands.add(new Advertising("реклама в сообществе"));
        commands.add(new CommitteeEvents("мероприятия комитета"));
        commands.add(new ThirdPartyEvents("сторонние мероприятия"));
        commands.add(new FAQ("faq"));
        commands.add(new ITNS("итнс"));
        commands.add(new TIOS("тиос"));
        commands.add(new POS("пос"));
        commands.add(new LP("лп"));
        commands.add(new BIS("бис"));
        commands.add(new CommitteeEvents("1"));
        commands.add(new ThirdPartyEvents("2"));
        commands.add(new Internships("3"));
        commands.add(new Members("4"));
        commands.add(new SECs("5"));
        commands.add(new FAQ("6"));
        commands.add(new Error("7"));
        commands.add(new Advertising("8"));
    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
