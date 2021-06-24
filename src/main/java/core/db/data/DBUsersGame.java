package core.db.data;

/**
 * Data-class для хранения информации о пользователях и постах, на которые они подписаны
 */
public class DBUsersGame {

    public Integer  vk_user_id, score, question_number;


    public Integer getVk_user_id() {
        return vk_user_id;
    }

    public void setVk_user_id(Integer vk_user_id) {
        this.vk_user_id = vk_user_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getQuestion() {
        return question_number;
    }

    public void setQuestion(Integer question_number) {
        this.question_number = question_number;
    }

    public DBUsersGame(){
        vk_user_id = null;
        score = question_number = 0;
    }

    @Override
    public String toString() {
        return "DBUser{" +
                " vk_user_id=" + vk_user_id +
                ", score='" + score +
                ", question='" + question_number +'\'' +
                '}';
    }
}