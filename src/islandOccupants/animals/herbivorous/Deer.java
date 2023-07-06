package islandOccupants.animals.herbivorous;

import island.Location;

public class Deer extends Herbivorous {

    public Deer(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(20);
        setWeight(300.0);
        setBellySize(50.0);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }

}
