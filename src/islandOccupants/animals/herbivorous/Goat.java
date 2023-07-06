package islandOccupants.animals.herbivorous;

import island.Location;

public class Goat extends Herbivorous {

    public Goat(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(140);
        setWeight(60.0);
        setBellySize(10.0);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
