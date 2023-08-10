package islandOccupants.animals.herbivorous;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Caterpillar extends Herbivorous {

    public Caterpillar(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(1000);
        setIsPoisonProtected(true);
        setWeight(0.01);
        setBellySize(0.1);
        setCurrentSatiety(getRandom().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(0);
        location.addOccupantInLocation(this);
    }

}
