package islandOccupants.animals.omnivores;

import island.Location;

public class Caterpillar extends Omnivores {

    public Caterpillar(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(1000);
        setIsPoisonProtected(true);
        setWeight(0.01);
        setBellySize(0.0); // ?????
        setMaxAmountOfMoves(0);
        location.addOccupantInLocation(this);
    }
}
