package core.modules;

public enum SECData {
    SEC_TIOS_TITLE("НОЦ ТИОС"),
    SEC_TIOS_DESC("НОЦ ТИОС"),
    SEC_TIOS_URL("НОЦ ТИОС");

    private String value;

    private SECData(String value) {
        this.value = value;
    }
    public String getValue(){ return value;}
}

