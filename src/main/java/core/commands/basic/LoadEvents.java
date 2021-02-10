package core.commands.basic;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.Wallpost;
import com.vk.api.sdk.objects.wall.WallpostFull;
import core.modules.data.GroupData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static vk.VKServer.vkCore;

public class LoadEvents {
    public static List<String> getPost(String tag) {
        List<String> attachments = new ArrayList<String>();
        final long LAST_TWO_MONTH = 2628000000l;

        try {
            long lastDate = new Date( System.currentTimeMillis() - LAST_TWO_MONTH).getTime();
            //Данный ужас берет все посты по тегу стажировка, после чего фильтрует
            // только опубликованные за последние 2 месяца
            List<WallpostFull> searchPost = vkCore.getVk().wall().search(vkCore.getUserActor())
                    .ownerId(Integer.valueOf(GroupData.GROUP_ID.getValue()))
                    .query(tag)
                    .count(20)
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
            return null;
        }

    }
}
