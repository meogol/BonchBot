package core.modules.data;

public enum GroupData {
    GROUP_ID("-87630042"),
    MEMBERS_POST_ID("54493128"),
    DEVELOPER_URL("https://vk.com/meogol"),
    SMM_URL("https://vk.com/dsshvts");

    private String value;

    private GroupData(String value) {
        this.value = value;
    }
    public String getValue(){ return value;}
}

