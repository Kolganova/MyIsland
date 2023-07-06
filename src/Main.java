import island.Location;
import island.Island;
import islandOccupants.OccupantFactory;

import static island.Location.getCounter;

public class Main {
    public static void main(String[] args) {
        Island myIsland = new Island(1, 2);
        Location location = myIsland.getListOfLocations().get(0).get(0);
        System.out.println(location.getListOfOccupants());
        System.out.println();
        System.out.println(getCounter());
        System.out.println(location.getMapWithOccupantsOnLocation());
        System.out.println(location.getListOfOccupants().get(0));
        for (int i = 0; i < 300; i++) {
            location.addOccupantInLocation(OccupantFactory.createOccupant("deer"));
        }
        System.out.println(myIsland.getListOfLocations().get(0).get(1).getMapWithOccupantsOnLocation());
//        вот эта параша сверху не работает. не то что я :(
        System.out.println();

    }
}