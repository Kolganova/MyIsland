package islandOccupants.animals.preadators;

import enums.AnimalCreationType;
import island.Location;

public class Wolf extends Predator {

    public Wolf(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(30);
        setWeight(50.0);
        setBellySize(8.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
