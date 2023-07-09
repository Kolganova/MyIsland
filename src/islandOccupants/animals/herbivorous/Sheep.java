package islandOccupants.animals.herbivorous;

import enums.CreationType;
import island.Location;

public class Sheep extends Herbivorous {

    public Sheep(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(140);
        setWeight(70.0);
        setBellySize(15.0);
        setCurrentSatiety(getRandom().nextDouble(this.getBellySize().get()));
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(3);
        location.addOccupantInLocation(this);
    }

}
