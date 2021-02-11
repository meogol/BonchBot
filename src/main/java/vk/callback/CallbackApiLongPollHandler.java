package vk.callback;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vk.Messenger;
import vk.callback.data.ClientInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackApiLongPollHandler extends CallbackApiLongPollRed {

    private static final Logger LOG = LoggerFactory.getLogger(CallbackApiLongPollHandler.class);
    ExecutorService exec = Executors.newCachedThreadPool();

    public CallbackApiLongPollHandler(VkApiClient client, UserActor actor, Integer groupId) {
        super(client, actor, groupId);
    }

    public CallbackApiLongPollHandler(VkApiClient client, GroupActor actor) {
        super(client, actor);
    }

    @Override
    public void messageNew(Integer groupId, ClientInfo clientInfo, Message message) {
        LOG.info("messageNew: " + message.toString());

        exec.execute(new Messenger(message, clientInfo));
    }
}