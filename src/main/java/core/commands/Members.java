package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.data.GroupData;
import vk.VKManager;

import static vk.VKServer.vkCore;


public class Members extends Command implements ServiceCommand{

    public Members(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {

        String contacts = getGroupContacts();

        if(contacts == "")
            contacts = "Ошибка получения контактов";

        new VKManager().sendMessage(contacts, message.getPeerId());
    }

    @Override
    public void service() {

    }

    /**
     * Метод получает участников комитета из меню группы,
     * удаляет все лишнее и преобразует вывод
     * Данные на странице должны получаться в формате <ссылка><Доожность+имя>
     * @return
     */
    private String getGroupContacts() {
        try {
            String contacts = vkCore.getVk().pages().get(vkCore.getUserActor())
                    .ownerId(Integer.valueOf(GroupData.GROUP_ID.getValue()))
                    .pageId(Integer.valueOf(GroupData.MEMBERS_POST_ID.getValue()))
                    .needSource(true)
                    .execute()
                    .getSource();

            contacts=contacts.split("<left>")[1].replaceAll("</left>","")
                    .replaceAll("\\[\\[","")
                    .replaceAll("]]","");

            String[] splitContacts = contacts.split("\n");
            contacts = "";

            for (String urlAndName: splitContacts) {
                String[] splitUrlAndName = urlAndName.split("\\|");
                contacts += splitUrlAndName[1]+" | "+ splitUrlAndName[0]+"\n";
            }

            return  contacts;
        }
        catch (ApiException | ClientException e) {
            e.printStackTrace();
            return null;
        }

    }
}
