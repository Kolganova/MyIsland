package islandOccupants.animals.herbivorous;

import enums.AnimalCreationType;
import island.Location;

public class Mouse extends Herbivorous {

    public Mouse(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(500);
        setIsPoisonProtected(true);
        setWeight(0.05);
        setBellySize(0.01);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(1);
        location.addOccupantInLocation(this);
    }

}
