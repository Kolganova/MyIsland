package islandOccupants.animals.preadators;

import island.Location;

public class Boa extends Predator {

    public Boa(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(30);
        setIsPoisonProtected(true);
        setWeight(15.0);
        setBellySize(3.0);
        setMaxAmountOfMoves(1);
        location.addOccupantInLocation(this);
    }

}
