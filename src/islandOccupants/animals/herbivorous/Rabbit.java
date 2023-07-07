package islandOccupants.animals.herbivorous;

import enums.CreationType;
import island.Location;

public class Rabbit extends Herbivorous {

    public Rabbit(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(150);
        setWeight(2.0);
        setBellySize(0.45);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
