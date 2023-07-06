package islandOccupants.animals.herbivorous;

import island.Location;

public class Duck extends Herbivorous {

    public Duck(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(200);
        setWeight(1.0);
        setBellySize(0.15);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }

}
