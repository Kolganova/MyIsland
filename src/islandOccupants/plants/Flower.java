package islandOccupants.plants;

import island.Location;

public class Flower extends Plant {

    public Flower(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(200);
        setIsPoisonous(false);
        setWeight(1.0);
        setPropagationFrequency(2);
        location.addOccupantInLocation(this);
    }

}
