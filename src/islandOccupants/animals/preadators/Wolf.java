package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {

    public Wolf(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(30);
        setWeight(50.0);
        setBellySize(8.0);
        setCurrentSatiety(ThreadLocalRandom.current().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
