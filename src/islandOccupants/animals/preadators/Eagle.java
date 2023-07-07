package islandOccupants.animals.preadators;

import enums.AnimalCreationType;
import island.Location;


public class Eagle extends Predator {

    public Eagle(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(20);
        setIsPoisonProtected(true);
        setWeight(6.0);
        setBellySize(1.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
