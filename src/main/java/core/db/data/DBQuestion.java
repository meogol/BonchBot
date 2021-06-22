package core.db.data;

import core.db.DBCore;

/**
 * Data-class для хранения вопросов для геймификации
 */
public class DBQuestion {

    public String answer, question;
    public String list_answers[] = new String[4];

    public DBQuestion(){
        answer = question = null;
        list_answers = null;
    }
    public DBQuestion(Integer num){
        DBCore db = new DBCore();
        answer = db.dbRead("SELECT answer FROM Game WHERE id = " + num, String.class).get(0).toString();
        question = db.dbRead("SELECT question FROM Game WHERE id = " + num, String.class).get(0).toString();
        String list = db.dbRead("SELECT list_answers FROM Game WHERE id = " + num, String.class).get(0).toString();
        list_answers = list.split(";");
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }


    public String getBtn1() {
        return list_answers[1];
    }
    public String getBtn2() {
        return list_answers[2];
    }
    public String getBtn3() {
        return list_answers[3];
    }
    public String getBtn4() {
        return list_answers[4];
    }

}
