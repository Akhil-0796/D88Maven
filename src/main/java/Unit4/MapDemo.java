package Unit4;

import java.util.HashMap;
import java.util.Locale;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();

        map.put("student","teacher");
        map.put("class","school");
        map.put("marks","ink");

        // getOrDefault
        var ans = map.getOrDefault("class","home");
        System.out.println(ans);

        // putifabsent
       // map.putIfAbsent("marks","result");
        System.out.println(map.get("marks"));

        // compute
        map.compute("marks",(key,value)-> value.toUpperCase(Locale.ROOT));
        System.out.println(map.get("marks"));
    }
}
