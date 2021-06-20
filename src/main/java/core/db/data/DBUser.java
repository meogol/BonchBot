package core.db.data;

/**
 * Data-class для хранения информации о пользователях и постах, на которые они подписаны
 */
public class DBUser {

    public Integer  vk_user_id;
    public String post_tag;


    public Integer getVk_user_id() {
        return vk_user_id;
    }

    public void setVk_user_id(Integer vk_user_id) {
        this.vk_user_id = vk_user_id;
    }

    public String getPost_tag() {
        return post_tag;
    }

    public void setPost_tag(String post_tag) {
        this.post_tag = post_tag;
    }

    @Override
    public String toString() {
        return "DBUser{" +
                " vk_user_id=" + vk_user_id +
                ", post_tag='" + post_tag + '\'' +
                '}';
    }
}
