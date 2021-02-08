package vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;

import java.util.List;
import java.util.Random;

public class VKManager {

    public static VKCore vkCore;
    Random random = new Random();

    static {
        try {
            vkCore = new VKCore();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg, int peerId){
        if (msg == null){
            System.out.println("null");
            return;
        }
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).randomId(random.nextInt(10000))
                    .message(msg).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод принимает набор строк вида <type><owner_id>_<media_id> для пересылки
     *  постов пользователю
     * @param attachments Список строк с Id группы и поста
     * @param peerId Id пользователя
     */
    public void sendPost(List<String> attachments, int peerId){
        if (attachments.size() < 1){
            System.out.println("null");
            return;
        }
        try {
            for (String attachment: attachments) {
                vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).randomId(random.nextInt(10000))
                        .attachment(attachment).execute();
            }

        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendKeyboard(Keyboard keyboard, String msg, int peerId){
        if (keyboard == null){
            System.out.println("null");
            return;
        }
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(msg).keyboard(keyboard)
                    .randomId(random.nextInt(10000)).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public MessagesSendQuery getSendQuery(){
        return vkCore.getVk().messages().send(vkCore.getActor());
    }

    /**
     * Обращается к VK API и получает объект, описывающий пользователя.
     * @param id идентификатор пользователя в VK
     * @return {@link UserXtrCounters} информацию о пользователе
     * @see UserXtrCounters
     */
    public static GetResponse getUserInfo(int id){
        try {
            return vkCore.getVk().users()
                    .get(vkCore.getActor())
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

}
