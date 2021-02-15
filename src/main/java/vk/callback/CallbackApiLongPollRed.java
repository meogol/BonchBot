package vk.callback;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.messages.Message;
import vk.callback.data.ClientInfo;

/**
 * По сути- один большой костыль, чтобы прикрутить возмодность
 * получения информации о пользовательских функциях.
 * Рассчитан на обработку только новых собщений или событий,
 * не связанных с сообщениями. Будет переписан.
 */
public class CallbackApiLongPollRed extends CallbackApiLongPoll {

    public CallbackApiLongPollRed(VkApiClient client, UserActor actor, int groupId) {
        super(client, actor, groupId);
    }

    public CallbackApiLongPollRed(VkApiClient client, GroupActor actor) {
        super(client, actor);
    }

    public CallbackApiLongPollRed(VkApiClient client, UserActor actor, int groupId, int waitTime) {
        super(client, actor, groupId, waitTime);
    }

    public CallbackApiLongPollRed(VkApiClient client, GroupActor actor, int waitTime) {
        super(client, actor, waitTime);
    }

    /**
     * Метод для обработки сообщений с API 5.103 и выше
     * @param groupId id Группы
     * @param clientInfo Объект с информацией о возможностях пользователя
     * @param message Объект сообщения
     */
    public void messageNew(Integer groupId, ClientInfo clientInfo, Message message) {
    }


    /**
     * Перегружаем метод для поддержки API 5.103 и выше
     * Старый метод не умеет парсить json с полем client_info
     * client_info содержит набор доступных пользователю функций
     * что необходимо для проверки возможности отправки клавиатуры и
     * карусели
     * @param json
     * @return
     */
    @Override
    public boolean parse(JsonObject json) {
        //в json надо вырезать поле client_info
        if(json.toString().contains("client_info")) {
            String js = json.toString();
            String[] removeClientInfo = js.split(",\"client_info\":");
            String[] ClientInfoAndEndMsg = removeClientInfo[1].split("}}");
            String[] startMsg = removeClientInfo[0].split("\\{\"message\":");

            js = startMsg[0] + startMsg[1] + ClientInfoAndEndMsg[1];

            String user = ClientInfoAndEndMsg[0] + "}";

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(js, JsonObject.class);
            ClientInfo clientInfo = gson.fromJson(user, ClientInfo.class);

            //старый messageNew не поддерживает параметр clientInfo, а он нам нужен
            if(json.toString().contains("message_new") ) {
                CallbackMessage message = gson.fromJson(jsonObject,
                        new TypeToken<CallbackMessage<Message>>() {}.getType());

                messageNew(message.getGroupId(), clientInfo, (Message)message.getObject());
            }


            return super.parse(jsonObject);
        }
        else {
            boolean res = super.parse(json);
            return res;
        }

    }
}
