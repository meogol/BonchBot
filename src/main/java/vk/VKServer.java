package vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import vk.callback.CallbackApiLongPollHandler;

public class VKServer {

    public static VKCore vkCore;

    static {
        try {
            vkCore = new VKCore();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NullPointerException, ApiException, ClientException {
        System.out.println("Running server...");

        CallbackApiLongPollHandler handler = new CallbackApiLongPollHandler(vkCore.getVk(), vkCore.getActor());
        handler.run();



//        while (true) {
//            Thread.sleep(300);
//
//            try {
////                Message message = vkCore.getMessage();
////                if (message != null) {
////                    ExecutorService exec = Executors.newCachedThreadPool();
////                    exec.execute(new Messenger(message));
////                }
//            } catch (ClientException e) {
//                System.out.println("Возникли проблемы");
//                final int RECONNECT_TIME = 10000;
//                System.out.println("Повторное соединение через " + RECONNECT_TIME / 1000 + " секунд");
//                Thread.sleep(RECONNECT_TIME);
//
//            }
//        }
    }

}
