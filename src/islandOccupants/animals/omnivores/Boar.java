package islandOccupants.animals.omnivores;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Boar extends Omnivores {

    public Boar(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(50);
        setIsPoisonProtected(true);
        setWeight(400.0);
        setBellySize(50.0);
        setCurrentSatiety(ThreadLocalRandom.current().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
