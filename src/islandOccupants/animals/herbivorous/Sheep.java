package islandOccupants.animals.herbivorous;

import island.Location;

public class Sheep extends Herbivorous {

    public Sheep(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(140);
        setWeight(70.0);
        setBellySize(15.0);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }

}
