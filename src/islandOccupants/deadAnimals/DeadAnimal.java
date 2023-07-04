package islandOccupants.deadAnimals;

import enums.DeadAnimalAging;
import island.Location;
import islandOccupants.IslandOccupant;

public class DeadAnimal extends IslandOccupant {
    public DeadAnimal(Location location) {
        super(location);
    }

    @Override
    public DeadAnimalAging checkAgingPhase(int age) {
        for (DeadAnimalAging temp:DeadAnimalAging.values()) {
            if (age >= temp.getMin() && age <= temp.getMax())
                return temp;
        }

        return null;
    }
}
