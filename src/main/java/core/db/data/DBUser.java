package core.db.data;

public class DBUser {

    public Integer id, vk_user_id;
    public String post_tag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
                "id=" + id +
                ", vk_user_id=" + vk_user_id +
                ", post_tag='" + post_tag + '\'' +
                '}';
    }
}
