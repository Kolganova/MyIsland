package islandOccupants.animals.preadators;

import enums.AnimalCreationType;
import island.Location;

public class Boa extends Predator {

    public Boa(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(30);
        setIsPoisonProtected(true);
        setWeight(15.0);
        setBellySize(3.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(1);
        location.addOccupantInLocation(this);
    }

}
