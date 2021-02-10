package core.modules.carousels.basic;

import com.google.gson.Gson;
import core.modules.carousels.SECElement;

import java.util.ArrayList;

public class BasicCarousel {
    protected final String type = "carousel";
    protected ArrayList<BasicElements> elements = new ArrayList();


    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
