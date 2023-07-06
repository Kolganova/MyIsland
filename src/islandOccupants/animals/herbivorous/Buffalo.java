package islandOccupants.animals.herbivorous;

import island.Location;

public class Buffalo extends Herbivorous {

    public Buffalo(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(10);
        setWeight(700.0);
        setBellySize(100.0);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }

}
