package islandOccupants.plants;

import enums.CreationType;
import island.Location;

public class Grass extends Plant {

    public Grass(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(400);
        setIsPoisonous(false);
        setWeight(1.0);
        setPropagationFrequency(4);
        location.addOccupantInLocation(this);
    }
}
