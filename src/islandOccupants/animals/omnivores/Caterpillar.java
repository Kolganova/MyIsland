package islandOccupants.animals.omnivores;

import island.Location;

public class Caterpillar extends Omnivores {

    public Caterpillar(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
    }
}
