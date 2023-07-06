package islandOccupants.animals.preadators;

import island.Location;


public class Eagle extends Predator {

    public Eagle(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(20);
        setIsPoisonProtected(true);
        setWeight(6.0);
        setBellySize(1.0);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
