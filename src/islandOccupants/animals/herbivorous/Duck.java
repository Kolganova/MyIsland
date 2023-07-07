package islandOccupants.animals.herbivorous;

import enums.AnimalCreationType;
import island.Location;

public class Duck extends Herbivorous {

    public Duck(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(200);
        setWeight(1.0);
        setBellySize(0.15);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }

}
