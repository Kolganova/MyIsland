package islandOccupants.animals.herbivorous;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends Herbivorous {

    public Mouse(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(500);
        setIsPoisonProtected(true);
        setWeight(0.05);
        setBellySize(0.01);
        setCurrentSatiety(ThreadLocalRandom.current().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(1);
        location.addOccupantInLocation(this);
    }

}
