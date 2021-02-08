package core.modules;

public enum GroupData {
    GROUP_ID("-87630042"),
    MEMBERS_POST_ID("54493128");


    private String value;

    private GroupData(String value) {
        this.value = value;
    }
    public String getCode(){ return value;}
}

