package islandOccupants.animals.herbivorous;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Herbivorous {

    public Horse(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(20);
        setWeight(400.0);
        setBellySize(60.0);
        setCurrentSatiety(ThreadLocalRandom.current().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }
}
