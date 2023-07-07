package islandOccupants.animals.preadators;

import enums.CreationType;
import island.Location;

public class Wolf extends Predator {

    public Wolf(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(30);
        setWeight(50.0);
        setBellySize(8.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
