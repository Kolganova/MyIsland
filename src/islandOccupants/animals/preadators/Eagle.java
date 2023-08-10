package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;


public class Eagle extends Predator {

    public Eagle(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(20);
        setIsPoisonProtected(true);
        setWeight(6.0);
        setBellySize(1.0);
        setCurrentSatiety(getRandom().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
