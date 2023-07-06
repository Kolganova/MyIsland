package islandOccupants.deadAnimals;

import enums.DeadAnimalAging;
import island.Location;
import islandOccupants.IslandOccupant;

public class DeadAnimal extends IslandOccupant {
    private static boolean isPoisonous;

    static {
        isPoisonous = true;
    }
    public DeadAnimal(Location location, String type, Double weight) {
        super(location, type);
        setWeight(weight);
        location.addOccupantInLocation(this);
    }

    @Override
    public DeadAnimalAging checkAgingPhase() {
        for (DeadAnimalAging temp:DeadAnimalAging.values()) {
            if (this.getAge() >= temp.getMin() && this.getAge() <= temp.getMax())
                return temp;
        }

        return null;
    }

    public static boolean isIsPoisonous() {
        return isPoisonous;
    }
}
