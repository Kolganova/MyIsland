package islandOccupants.animals.omnivores;

import island.Location;

public class Boar extends Omnivores {

    public Boar(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(50);
        setIsPoisonProtected(true);
        setWeight(400.0);
        setBellySize(50.0);
        setMaxAmountOfMoves(2);
        location.addOccupantInLocation(this);
    }

}
