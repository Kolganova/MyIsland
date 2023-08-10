package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Boa extends Predator {

    public Boa(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(30);
        setIsPoisonProtected(true);
        setWeight(15.0);
        setBellySize(3.0);
        setCurrentSatiety(getRandom().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(1);
        location.addOccupantInLocation(this);
    }

}
