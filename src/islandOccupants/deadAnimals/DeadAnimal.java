package islandOccupants.deadAnimals;

import island.Location;
import islandOccupants.IslandOccupant;

public class DeadAnimal extends IslandOccupant {

    public DeadAnimal(Location location, String type, double weight) {
        super(location, type);
        setAge(1);
        setWeight(weight);
        location.addOccupantInLocation(this);
    }

}
