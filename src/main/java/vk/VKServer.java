package vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import core.modules.mailing.Mailing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vk.callback.CallbackApiLongPollHandler;


public class VKServer {
    private static final Logger LOG = LoggerFactory.getLogger(VKServer.class);

    public static VKCore vkCore;

    static {
        try {
            vkCore = new VKCore();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

    public static void main(String[] args) throws NullPointerException, ApiException, ClientException, InterruptedException {
        System.out.println("Running server...");

        while (true) {
            try {
                Runnable mailing =() ->{
                    Mailing.execute();

                };
                Thread threadLoadingForm = new Thread(mailing);
                threadLoadingForm.start();

                CallbackApiLongPollHandler handler = new CallbackApiLongPollHandler(vkCore.getVk(), vkCore.getActor());
                handler.run();



            } catch (ClientException e) {
                System.out.println("Возникли проблемы");
                final int RECONNECT_TIME = 10000;
                System.out.println("Повторное соединение через " + RECONNECT_TIME / 1000 + " секунд");
                Thread.sleep(RECONNECT_TIME);
                LOG.info(e.getMessage());

            }
        }


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
