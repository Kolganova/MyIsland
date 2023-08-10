package islandOccupants.animals.herbivorous;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Deer extends Herbivorous {

    public Deer(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(20);
        setWeight(300.0);
        setBellySize(50.0);
        setCurrentSatiety(getRandom().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }

}
