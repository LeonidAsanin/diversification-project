package utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapUtil {
    public static <K, V extends Comparable<? super V>> Map<K,V> sortByValue(Map<K,V> map) {
        var mapEntries = new ArrayList<>(map.entrySet());
        var sortedMap = new LinkedHashMap<K,V>();

        mapEntries.sort(Map.Entry.<K,V>comparingByValue().reversed());

        for (Map.Entry<K,V> entry : mapEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
