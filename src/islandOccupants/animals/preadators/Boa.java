package islandOccupants.animals.preadators;

import island.Location;

public class Boa extends Predator {
    public Boa(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
    }

}
