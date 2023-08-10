package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Fox extends Predator {

    public Fox(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(30);
        setWeight(8.0);
        setBellySize(2.0);
        setCurrentSatiety(getRandom().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
