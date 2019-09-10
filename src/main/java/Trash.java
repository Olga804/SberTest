import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Trash {

    private static Map<String, Integer> map = new HashMap<>();

    public static WebDriver driver;

    public static Integer get(String key) {
        return map.get(key);
    }

    public static void put(String key, String value) {
        String[] string = value.split("\\s");
        value = null;
        for (int i = 1; i < string.length; i++) {
            value = string[i - 1].concat(string[i]);
        }

        int x = Integer.parseInt(value);
        map.put(key, x);
    }
}