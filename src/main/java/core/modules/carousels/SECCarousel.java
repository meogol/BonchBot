package core.modules.carousels;

import com.google.gson.Gson;
import com.vk.api.sdk.objects.wall.CarouselBase;
import core.modules.carousels.basic.BasicCarousel;

import java.util.ArrayList;

public class SECCarousel extends BasicCarousel {

    public SECCarousel(){
        elements.add(new SECElement("Ноц ИТНС",
                "Типа описание",
                "Подробнее", "https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-infokommunikacionnih-tehnologiy-i-neyrokognitivnih-arhitektur"));
        elements.add(new SECElement("Ноц ТИОС",
                "Типа описание",
                "Подробнее", "https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/noc-tehnologii-informacionnih-i-obrazovatelnih-sistem"));
        elements.add(new SECElement("Ноц ПОС",
                "Типа описание",
                "Подробнее", "https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-programmno-opredelyaemie-sistemi"));
        elements.add(new SECElement("Ноц ЛП",
                "Типа описание",
                "Подробнее", "https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-laboratoriya-programmirovaniya"));
        elements.add(new SECElement("Ноц БИС",
                "Типа описание",
                "Подробнее", "https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-besprovodnie-infotelekommunikacionnie-seti"));

    }

}
