package islandOccupants.animals.preadators;

import island.Location;

public class Wolf extends Predator {

    public Wolf(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(30);
        setWeight(50.0);
        setBellySize(8.0);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
