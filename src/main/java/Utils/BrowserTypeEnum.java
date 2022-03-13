package Utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BrowserTypeEnum {
    CHROME,
    EDGE,
    FIREFOX,
    SAFARI,
    OPERA;

//    private String type;
//
//    BrowserType(String type) {
//        this.type = type;
//    }

    public static BrowserTypeEnum fromString(String text) {
        try {
            return Arrays.stream(values())
                    .filter(bl -> bl.name().equalsIgnoreCase(text))
                    .findAny().get();
        } catch (NoSuchElementException e) {
            return BrowserTypeEnum.CHROME;
        }
    }
}
