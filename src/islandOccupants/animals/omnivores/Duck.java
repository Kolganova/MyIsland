package islandOccupants.animals.omnivores;

import enums.CreationType;
import island.Location;

public class Duck extends Omnivores {

    public Duck(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(200);
        setWeight(1.0);
        setBellySize(0.15);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(4);
        location.addOccupantInLocation(this);
    }

}
