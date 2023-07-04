import island.Location;
import island.Island;

import static island.Location.getCounter;

public class Main {
    public static void main(String[] args) {
        Island myIsland = new Island(1, 2);
        Location location = myIsland.getListOfLocations().get(0).get(0);
        System.out.println(location.getListOfOccupants());
        System.out.println();
        System.out.println(getCounter());
        System.out.println(location.getListWithNumberOfOccupantsOnLocation());
//        System.out.println(myIsland.getListOfLocations().get(0).get(0).getListOfOccupants());

    }
}