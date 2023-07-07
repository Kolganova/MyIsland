package islandOccupants.animals.herbivorous;

import enums.AnimalCreationType;
import island.Location;

public class Sheep extends Herbivorous {

    public Sheep(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(140);
        setWeight(70.0);
        setBellySize(15.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }

}
