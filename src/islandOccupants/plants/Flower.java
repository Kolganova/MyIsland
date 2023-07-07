package islandOccupants.plants;

import enums.CreationType;
import island.Location;

public class Flower extends Plant {

    public Flower(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(200);
        setIsPoisonous(false);
        setWeight(1.0);
        setPropagationFrequency(2);
        location.addOccupantInLocation(this);
    }

}
