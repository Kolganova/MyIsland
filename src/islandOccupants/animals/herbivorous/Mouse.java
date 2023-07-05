package islandOccupants.animals.herbivorous;

import island.Location;

public class Mouse extends Herbivorous {

    public Mouse(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
    }

}
