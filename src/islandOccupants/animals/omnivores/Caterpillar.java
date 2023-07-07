package islandOccupants.animals.omnivores;

import enums.CreationType;
import island.Location;

public class Caterpillar extends Omnivores {

    public Caterpillar(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(1000);
        setIsPoisonProtected(true);
        setWeight(0.01);
        setBellySize(0.0); // ?????
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(0);
        location.addOccupantInLocation(this);
    }


    // ей нельзя есть кусты
}
