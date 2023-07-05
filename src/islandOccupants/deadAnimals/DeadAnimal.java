package islandOccupants.deadAnimals;

import enums.DeadAnimalAging;
import island.Location;
import islandOccupants.IslandOccupant;

import java.util.concurrent.atomic.AtomicReference;

public class DeadAnimal extends IslandOccupant {
    private static boolean isPoisonous;
    public DeadAnimal(Location location, String type, AtomicReference<Double> weight) {
        super(location, type);
        isPoisonous = true;
        setWeight(weight);
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
