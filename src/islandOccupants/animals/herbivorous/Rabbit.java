package islandOccupants.animals.herbivorous;

import island.Location;

public class Rabbit extends Herbivorous {

    public Rabbit(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(150);
        setWeight(2.0);
        setBellySize(0.45);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
