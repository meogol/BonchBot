package core.modules.carousels;

/**
 * Данный клас нужен для правильного конверта в json объекта карусели
 */
public class Action {
    private String type;
    private String link;

    Action(String type, String link){
        this.link = link;
        this.type = type;
    }
}
