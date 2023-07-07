package islandOccupants.animals.herbivorous;

import enums.AnimalCreationType;
import island.Location;

public class Buffalo extends Herbivorous {

    public Buffalo(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(10);
        setWeight(700.0);
        setBellySize(100.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }

}
