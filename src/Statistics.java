import enums.types.OccupantType;
import island.Island;
import island.Location;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
    private static Long currentAmountOfParticularOccupants;
    private static final HashMap<OccupantType, Long> mapOfOccupantsOnIsland;

    static {
        EnumSet<OccupantType> occupantTypeEnumSet = EnumSet.allOf(OccupantType.class);

        mapOfOccupantsOnIsland = occupantTypeEnumSet
                .stream()
                .collect(HashMap::new, (k, v) -> k.put(v, 0L), Map::putAll);
    }

    public static void showStatistics() {
        countAmountOfParticularOccupantOnIsland();
        System.out.println("______________________________");
        System.out.println("Обитатели островка на данный момент:");
        System.out.println(getCurrentAmountOfOccupantsOnIsland());
        mapOfOccupantsOnIsland.forEach((key, value) -> System.out.printf("%s - %,d%n", key.getUnicode(), value));
    }

    private static void countAmountOfParticularOccupantOnIsland() {
        // Получаем все локации на острове
        CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations = Island.getIsland().getListOfLocations();
        // Получаем лист локаций
        for (CopyOnWriteArrayList<Location> list : listOfLocations) {
            // Перебираем локации
            for (Location location : list) {
                // Получаем мапу с обитателями и их количеством
                Map<OccupantType, AtomicInteger> tempMap = location.getMapWithOccupantsOnLocation();
                for (OccupantType typeOfCurrentOccupant : tempMap.keySet()) {
                    currentAmountOfParticularOccupants = (long) tempMap.get(typeOfCurrentOccupant).get();
                    for (OccupantType tempType : mapOfOccupantsOnIsland.keySet()) {
                        if (typeOfCurrentOccupant == tempType) {
                            incrementAmountOfParticularOccupant(tempType);
                            break;
                        }
                    }
                }
            }
        }
    }

    protected static long getCurrentAmountOfOccupantsOnIsland() {
        return mapOfOccupantsOnIsland.values().stream().mapToLong(Long::longValue).sum();
    }

    private static void incrementAmountOfParticularOccupant(OccupantType type) {
        mapOfOccupantsOnIsland.merge(type, currentAmountOfParticularOccupants, Long::sum);
    }

}
