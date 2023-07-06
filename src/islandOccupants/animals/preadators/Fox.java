package islandOccupants.animals.preadators;

import island.Location;

public class Fox extends Predator {

    public Fox(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(30);
        setWeight(8.0);
        setBellySize(2.0);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
