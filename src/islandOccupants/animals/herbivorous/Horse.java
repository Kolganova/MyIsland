package islandOccupants.animals.herbivorous;

import enums.AnimalCreationType;
import island.Location;

public class Horse extends Herbivorous {

    public Horse(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(20);
        setWeight(400.0);
        setBellySize(60.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }
}
