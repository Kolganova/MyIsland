package islandOccupants.animals.omnivores;

import enums.AnimalCreationType;
import island.Location;

public class Caterpillar extends Omnivores {

    public Caterpillar(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(1000);
        setIsPoisonProtected(true);
        setWeight(0.01);
        setBellySize(0.0); // ?????
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(0);
        location.addOccupantInLocation(this);
    }
}
