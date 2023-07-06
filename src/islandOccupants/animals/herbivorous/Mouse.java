package islandOccupants.animals.herbivorous;

import island.Location;

public class Mouse extends Herbivorous {

    public Mouse(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(500);
        setIsPoisonProtected(true);
        setWeight(0.05);
        setBellySize(0.01);
        setMaxAmountOfMoves(1);
        location.addOccupantInLocation(this);
    }

}
