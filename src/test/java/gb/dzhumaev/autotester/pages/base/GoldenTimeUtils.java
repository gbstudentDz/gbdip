package gb.dzhumaev.autotester.pages.base;

public class GoldenTimeUtils {

    public static String delCurrencyDesignation(String s) {
        return s.replace("руб", "").trim();
    }
}
