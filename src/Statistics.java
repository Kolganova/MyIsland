import island.Island;
import island.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
    private static int amountOfAnimals;
    private static int currentAmountOfParticularOccupants;
    private static final Map<String, Integer> mapOfOccupantsOnIsland = new HashMap<>() {{
        put("\uD83D\uDC3A", 0); // волк
        put("\uD83D\uDC0D", 0); // змея
        put("\uD83E\uDD8A", 0); // лиса
        put("\uD83D\uDC3B", 0); // медведь
        put("\uD83E\uDD85", 0); // орел
        put("\uD83D\uDC0E", 0); // лошадь
        put("\uD83E\uDD8C", 0); // олень
        put("\uD83D\uDC07", 0); // кролик
        put("\uD83D\uDC01", 0); // мышь
        put("\uD83D\uDC10", 0); // козел
        put("\uD83D\uDC11", 0); // овца
        put("\uD83D\uDC17", 0); // кабан
        put("\uD83D\uDC03", 0); // бык
        put("\uD83E\uDD86", 0); // утка
        put("\uD83D\uDC1B", 0); // гусенница
        put("\uD83C\uDF37", 0); // цветок
        put("\uD83E\uDD40", 0); // отравленный цветок
        put("\uD83C\uDF33", 0); // куст
        put("\uD83C\uDF31", 0); // трава
        put("\uD83E\uDD69", 0); // мясо
    }};

    public static void showStatistics() {
        countAmountOfParticularOccupantOnIsland();
        System.out.println("______________________________");
        System.out.println("Обитатели островка на данный момент:");
        mapOfOccupantsOnIsland.forEach((key, value) -> System.out.printf("%s - %,d%n", key, value));
    }

    private static void countAmountOfParticularOccupantOnIsland() {
        CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations = Island.getIsland().getListOfLocations();
        for (CopyOnWriteArrayList<Location> list : listOfLocations) {
            for (Location location : list) {
                Map<String, AtomicInteger> tempMap = location.getMapWithOccupantsOnLocation();
                for (String type : tempMap.keySet()) {
                    currentAmountOfParticularOccupants = tempMap.get(type).get();
                    if ("deadAnimal".equals(type)) {
                        incrementAmountOfParticularOccupant("\uD83E\uDD69");
                    } else if ("bush".equals(type) || "flower".equals(type) || "grass".equals(type) ||
                            "poisonFlower".equals(type)) {
                        switch (type) {
                            case "bush" -> incrementAmountOfParticularOccupant("\uD83C\uDF33");
                            case "flower" -> incrementAmountOfParticularOccupant("\uD83C\uDF37");
                            case "grass" -> incrementAmountOfParticularOccupant("\uD83C\uDF31");
                            case "poisonFlower" -> incrementAmountOfParticularOccupant("\uD83E\uDD40");
                        }
                    } else {
                        amountOfAnimals++;
                        switch (type) {
                            case "wolf" -> incrementAmountOfParticularOccupant("\uD83D\uDC3A");
                            case "boa" -> incrementAmountOfParticularOccupant("\uD83D\uDC0D");
                            case "fox" -> incrementAmountOfParticularOccupant("\uD83E\uDD8A");
                            case "bear" -> incrementAmountOfParticularOccupant("\uD83D\uDC3B");
                            case "eagle" -> incrementAmountOfParticularOccupant("\uD83E\uDD85");
                            case "horse" -> incrementAmountOfParticularOccupant("\uD83D\uDC0E");
                            case "deer" -> incrementAmountOfParticularOccupant("\uD83E\uDD8C");
                            case "rabbit" -> incrementAmountOfParticularOccupant("\uD83D\uDC07");
                            case "mouse" -> incrementAmountOfParticularOccupant("\uD83D\uDC01");
                            case "goat" -> incrementAmountOfParticularOccupant("\uD83D\uDC10");
                            case "sheep" -> incrementAmountOfParticularOccupant("\uD83D\uDC11");
                            case "boar" -> incrementAmountOfParticularOccupant("\uD83D\uDC17");
                            case "buffalo" -> incrementAmountOfParticularOccupant("\uD83D\uDC03");
                            case "duck" -> incrementAmountOfParticularOccupant("\uD83E\uDD86");
                            case "caterpillar" -> incrementAmountOfParticularOccupant("\uD83D\uDC1B");
                        }
                    }
                }
            }
        }
    }

    public static int getAmountOfAnimals() {
        return amountOfAnimals;
    }

    private static void incrementAmountOfParticularOccupant(String unicode) {
        mapOfOccupantsOnIsland.merge(unicode, currentAmountOfParticularOccupants, Integer::sum);
    }

}
