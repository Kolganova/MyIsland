package islandOccupants.animals.herbivorous;

import island.Location;

public class Horse extends Herbivorous {

    public Horse(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(20);
        setWeight(400.0);
        setBellySize(60.0);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }
}
