package core.modules.comands;


import core.commands.Events.*;
import core.commands.Game.Answer;
import core.commands.Game.RightAnswer;
import core.commands.Game.StartGame;
import core.commands.Game.WrongAnswer;
import core.commands.Menu.*;
import core.commands.Questions.*;
import core.commands.Questions.Error;
import core.commands.Menu.SECs;
import core.commands.SecItems.*;
import core.commands.Subscribe.*;
import core.db.DBCore;
import core.db.data.DBQuestion;

import java.util.ArrayList;
import java.util.HashSet;


public class CommandManager {
    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new StartBtn("начать"));
        commands.add(new Unknown("unknown"));
        commands.add(new Members("\uD83D\uDE0Eучастники\uD83D\uDE0E"));
        commands.add(new Questions("❓вопросы❓"));
        commands.add(new SECs("ноцы\uD83D\uDD2C"));
        commands.add(new Internships("\uD83D\uDCB0стажировки\uD83D\uDCB0"));
        commands.add(new Events("\uD83C\uDF89мероприятия"));
        commands.add(new Back("назад"));
        commands.add(new Error("\uD83D\uDC94нашли ошибку?\uD83D\uDC94"));
        commands.add(new Advertising("\uD83D\uDCC8реклама в сообществе\uD83D\uDCC8"));
        commands.add(new CommitteeEvents("\uD83D\uDC40мероприятия комитета\uD83D\uDC40"));
        commands.add(new ThirdPartyEvents("⭐сторонние мероприятия⭐"));
        commands.add(new FAQ("\uD83D\uDD2Efaq\uD83D\uDD2E"));
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
        commands.add(new Settings("настройки"));
        commands.add(new Subscribe("управление подпиской"));

        /**
         * Изменение уже существующей подписки
         */
        commands.add(new SubOurs("наши меро :3"));
        commands.add(new SubOthers("сторонние меро :3"));
        commands.add(new UnsubOurs("наши меро :с"));
        commands.add(new UnsubOthers("сторонние меро :с"));

        /**
         * Создание нового DB-юзера (первый раз чел нажал на подписку)
         */
        commands.add(new AllNews("все новости!"));
        commands.add(new OurEvents("наши меро!"));
        commands.add(new OtherEvents("сторонние меро!"));

        /**
         * Game
         */
        commands.add(new StartGame("играть!"));

        DBCore db = new DBCore();
        ArrayList<DBQuestion> dbQuestion = db.dbRead("SELECT * FROM Game;", DBQuestion.class);

        for(int i = 0; i < dbQuestion.size(); i++){
            String list_answers[] = dbQuestion.get(i).getListAnswers();

            for(int j = 0; j < list_answers.length; j++){
                var answer = new Answer(list_answers[j]);

                if(i == dbQuestion.size() - 1 && j == list_answers.length -1)
                    answer.setEndGame(true);

                commands.add(answer);
            }

        }

        /**
         *
         */

    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
