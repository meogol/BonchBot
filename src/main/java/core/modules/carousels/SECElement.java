package core.modules.carousels;

import core.modules.carousels.basic.BasicElements;

public class SECElement extends BasicElements {
    private String title;
    private String description;


    SECElement(String title, String description,
               String buttonMsg, String buttonLink){
        super();

        this.title=title;
        this.description = description;

        setButton(buttonMsg, buttonLink);
    }
}
