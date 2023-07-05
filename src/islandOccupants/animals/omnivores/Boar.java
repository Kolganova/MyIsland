package islandOccupants.animals.omnivores;

import island.Location;

public class Boar extends Omnivores {

    public Boar(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
    }

}
