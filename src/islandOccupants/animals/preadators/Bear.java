package islandOccupants.animals.preadators;

import island.Location;

public class Bear extends Predator {

    public Bear(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(5);
        setWeight(500.0);
        setBellySize(80.0);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
