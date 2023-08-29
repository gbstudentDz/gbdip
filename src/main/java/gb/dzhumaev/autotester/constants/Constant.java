package gb.dzhumaev.autotester.constants;

import java.time.Duration;

public class Constant {
    public static class TimeoutVariable{
        public static final int IMPLICIT_WAIT = 5;
        public static final int EXPLICIT_WAIT = 5;
    }

    public static class Urls {
        public static final String PARFUMLIDER_HOMEPAGE = "https://parfum-lider.ru/";
        public static final String PARFUMLIDER_FAVORITE = "https://www.parfum-lider.ru/favorite/";
        public static final String PARFUMLIDER_CART = "https://www.parfum-lider.ru/personal/cart/";
    }

    public static class InputData {
        public static final String POSITIVE_SEARCH_QUERY = "Смартфон";
        public static final String NEGATIVE_SEARCH_QUERY = "AjhghjdjsegbdjewnkdjkhwhjegdwdkmkwehdewhdknwehndjkwhkjdnWKNDKJWEHDjk";

    }

}
