package islandOccupants.deadAnimals;

import island.Location;
import islandOccupants.IslandOccupant;

public class DeadAnimal extends IslandOccupant {
    private static final boolean IS_POISONOUS;

    static {
        IS_POISONOUS = true;
    }

    public DeadAnimal(Location location, String type, Double weight) {
        super(location, type);
        setWeight(weight);
        location.addOccupantInLocation(this);
    }

}
