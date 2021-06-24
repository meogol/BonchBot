package core.db.data;

import core.db.DBCore;

/**
 * Data-class для хранения вопросов для геймификации
 */
public class DBQuestion {

    public String answer, question, list_answers;

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getListAnswers() { return list_answers.split(";");}


}
