package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import core.modules.comands.Command;
import core.modules.data.GroupData;
import vk.VKManager;
import vk.callback.data.ClientInfo;

import static vk.VKServer.vkCore;


public class Members extends Command implements ServiceCommand{

    public Members(String name) {
        super(name);
    }

    @Override
    public void exec(Message message, ClientInfo clientInfo) {

        String contacts = getGroupContacts();

        if(contacts.equals(""))
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
     * @return список контактов с линками людей
     */
    private String getGroupContacts() {
        try {
            StringBuilder contacts = new StringBuilder(vkCore.getVk().pages().get(vkCore.getUserActor())
                    .ownerId(Integer.valueOf(GroupData.GROUP_ID.getValue()))
                    .pageId(Integer.valueOf(GroupData.MEMBERS_POST_ID.getValue()))
                    .needSource(true)
                    .execute()
                    .getSource());

            contacts = new StringBuilder(contacts.toString().split("<left>")[1].replaceAll("</left>", "")
                    .replaceAll("\\[\\[", "")
                    .replaceAll("]]", ""));

            String[] splitContacts = contacts.toString().split("\n");
            contacts = new StringBuilder();

            for (String urlAndName: splitContacts) {
                String[] splitUrlAndName = urlAndName.split("\\|");
                String link = splitUrlAndName[0].split("/")[3];
                contacts.append("* @").append(link).append("(").append(splitUrlAndName[1]).append(")").append("\n\n");
            }

            return contacts.toString();
        }
        catch (ApiException | ClientException e) {
            e.printStackTrace();
            return null;
        }

    }
}
