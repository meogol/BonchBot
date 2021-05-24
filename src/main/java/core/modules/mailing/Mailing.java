package core.modules.mailing;

import org.apache.logging.log4j.core.jackson.ListOfMapEntryDeserializer;
import vk.VKManager;

import java.time.LocalDateTime;

public class Mailing {
    private static boolean isMailing = false;

    public static void execute(){
        while (true){
            var thisTime = LocalDateTime.now().toLocalTime().getHour();

            if(!isMailing)
            {
                if(thisTime == 19){
                    isMailing = true;
                    new VKManager().sendMessage("ну типо рассылка", 173079751);
                    // TODO: 24.05.2021 тут должен быть код для отправки сообщений юзерам из бд
                }else {
                    isMailing = false;

                }
            }

            thisTime=thisTime;
        }

    }

}
