package islandOccupants.animals.preadators;

import enums.AnimalCreationType;
import island.Location;

public class Bear extends Predator {

    public Bear(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(5);
        setWeight(500.0);
        setBellySize(80.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
