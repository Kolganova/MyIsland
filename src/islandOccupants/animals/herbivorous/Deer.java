package islandOccupants.animals.herbivorous;

import enums.CreationType;
import island.Location;

public class Deer extends Herbivorous {

    public Deer(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(20);
        setWeight(300.0);
        setBellySize(50.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }

}
