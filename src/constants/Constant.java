package constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Constant {
    private static ConcurrentHashMap<String, Integer> LIST_OF_OCCUPANT_TYPES = new ConcurrentHashMap<>();

    static {
        setListOfOccupantTypes();
    }

    public static ConcurrentHashMap<String, Integer> getListOfOccupantTypes() {
        return LIST_OF_OCCUPANT_TYPES;
    }

    private static void setListOfOccupantTypes() {
        List<String> keys = new ArrayList<>(List.of("wolf", "boa", "fox", "bear", "eagle", "horse",
                "deer", "rabbit", "mouse", "goat", "sheep", "boar", "buffalo", "duck", "caterpillar", "flower",
                "poisonFlower", "bush", "grass"));
        List<Integer> values = new ArrayList<>(List.of(15, 15, 15, 2, 10, 10, 10, 75, 250, 70, 70,
                25, 5, 100, 500, 100, 50, 50, 200));

        HashMap<String, Integer> map = keys.stream().collect(HashMap::new, (k, v) -> k.put(v, values.get(keys.indexOf(v))),
                Map::putAll);
        LIST_OF_OCCUPANT_TYPES.putAll(map);
    }
}
