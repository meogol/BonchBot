package vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import com.vk.api.sdk.objects.wall.CarouselBase;
import com.vk.api.sdk.objects.wall.Wallpost;
import com.vk.api.sdk.objects.wall.WallpostFull;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import core.modules.carousels.SECCarousel;
import core.modules.carousels.basic.BasicCarousel;
import core.modules.data.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static vk.VKServer.vkCore;

public class VKManager {
    private static final Logger LOG = LoggerFactory.getLogger(VKManager.class);

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
            LOG.error(e.getMessage());
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
            LOG.error(e.getMessage());

        }
    }


    public void sendCarousel(String msg, BasicCarousel carousel, int peerId){

        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).randomId(random.nextInt(10000))
                    .message(msg).template(carousel.toString()).execute();


        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());

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
            LOG.error(e.getMessage());

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
            LOG.error(e.getMessage());

        }
        return null;
    }

    /**
     * Возвращает список постов, отфильтрованных по тегу
     * @param tag - тег, по которому производится поиск
     * @param searchedTime Отнимается от текущей даты- задает период поиска постов. В милисекундах
     * @param count Максимум выводимых постов
     * @return
     */
    public static List<String> getPosts(String tag, long searchedTime, int count) {
        List<String> attachments = new ArrayList<String>();
        final long LAST_TWO_MONTH = 2628000000l;

        try {
            long lastDate = new Date( System.currentTimeMillis() - searchedTime).getTime();
            //Данный ужас берет все посты по тегу, после чего фильтрует
            // только опубликованные за последние 2 месяца
            List<WallpostFull> searchPost = vkCore.getVk().wall().search(vkCore.getUserActor())
                    .ownerId(Integer.valueOf(GroupData.GROUP_ID.getValue()))
                    .query(tag)
                    .count(count)
                    .execute()
                    .getItems()
                    .stream().filter(x->
                            ((long)x.getDate()*1000) > lastDate)
                    .collect(Collectors.toList());


            for (Wallpost post:searchPost) {
                attachments.add("wall"+GroupData.GROUP_ID.getValue()+"_"+post.getId());
            }

            return attachments;
        }
        catch (ApiException | ClientException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());

            return null;
        }

    }
}
