package core.modules.carousels;

import com.google.gson.Gson;
import com.vk.api.sdk.objects.wall.CarouselBase;
import core.modules.carousels.basic.BasicCarousel;

import java.util.ArrayList;

public class SECCarousel extends BasicCarousel {

    public SECCarousel(){
        elements.add(new SECElement("Ноц тиос",
                "SOFTWARE РАЗРАБОТКА ПР ЕМА ПЕРЕДАТЧИКОВ\n",
                "Контакты", "https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/noc-tehnologii-informacionnih-i-obrazovatelnih-sistem"));
        elements.add(new SECElement("Ноц БИС",
                "Научно-образовательный центр",
                "Контакты", "http://tios.spbgut.ru/index.php"));


    }

}
