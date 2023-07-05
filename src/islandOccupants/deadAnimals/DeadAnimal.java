package islandOccupants.deadAnimals;

import enums.DeadAnimalAging;
import island.Location;
import islandOccupants.IslandOccupant;

public class DeadAnimal extends IslandOccupant {
    private static boolean isPoisonous;
    public DeadAnimal(Location location, String type) {
        super(location, type);
        isPoisonous = true;
    }

    @Override
    public DeadAnimalAging checkAgingPhase(int age) {
        for (DeadAnimalAging temp:DeadAnimalAging.values()) {
            if (age >= temp.getMin() && age <= temp.getMax())
                return temp;
        }

        return null;
    }

    public static boolean isIsPoisonous() {
        return isPoisonous;
    }
}
