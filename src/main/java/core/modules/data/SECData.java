package core.modules.data;

public enum SECData {
    SEC_TIOS_TITLE("НОЦ ТИОС"),
    SEC_TIOS_DESC("-Software рфзработка приемо-передатчиков\n" +
            "-3D принтерыб\n" +
            "-3D моделирование\n" +
            "-Разработка электроники"),
    SEC_TIOS_URL("https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/noc-tehnologii-informacionnih-i-obrazovatelnih-sistem"),

    SEC_BIS_TITLE("НОЦ БИС"),
    SEC_BIS_DESC("Научно-образовательный центр «Беспроводные инфотелекоммуникационные сети» создан с целью объединения и развития компетенций в области беспроводных коммуникаций."),
    SEC_BIS_URL("https://www.sut.ru/university/structure/podrazdeleniya-prorektora-po-nauchnoy-rabote/nauchno-issledovatelskiy-institut-tehnologiy-svyazi/nauchno-obrazovatelniy-centr-besprovodnie-infotelekommunikacionnie-seti");

    private String value;

    private SECData(String value) {
        this.value = value;
    }
    public String getValue(){ return value;}
}

