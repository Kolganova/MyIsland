package islandOccupants.deadAnimals;

import island.Location;
import islandOccupants.IslandOccupant;

public class DeadAnimal extends IslandOccupant {

    public DeadAnimal(Location location, String type) {
        super(location, type);
        setAge(1);
        location.addOccupantInLocation(this);
    }

}
