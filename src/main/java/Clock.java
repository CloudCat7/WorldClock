public enum Clock {

    bj("北京"),
    ld("伦敦"),
    msc("莫斯科"),
    sn("悉尼"),
    ny("纽约");

    private String name;

    Clock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
