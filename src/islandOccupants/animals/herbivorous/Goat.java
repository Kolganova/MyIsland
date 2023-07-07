package islandOccupants.animals.herbivorous;

import enums.AnimalCreationType;
import island.Location;

public class Goat extends Herbivorous {

    public Goat(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(140);
        setWeight(60.0);
        setBellySize(10.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }
}
