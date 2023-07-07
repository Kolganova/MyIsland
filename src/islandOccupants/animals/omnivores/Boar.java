package islandOccupants.animals.omnivores;

import enums.AnimalCreationType;
import island.Location;

public class Boar extends Omnivores {

    public Boar(Location location, String type, AnimalCreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(50);
        setIsPoisonProtected(true);
        setWeight(400.0);
        setBellySize(50.0);
        setSatietyCostOnMove(getBellySize().get() / 5);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
