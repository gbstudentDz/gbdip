package gb.dzhumaev.autotester;

public class SelectorInfo {
    private String selector;
    private String name;

    public SelectorInfo(String selector, String name) {
        this.selector = selector;
        this.name = name;
    }

    public String s() {
        return selector;
    }

    public String n() {
        return name;
    }
}
