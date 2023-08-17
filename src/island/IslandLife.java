package island;

import java.util.concurrent.CopyOnWriteArrayList;

import static island.LocationLife.live10DaysAtLocation;

public class IslandLife {
    public static void live10DaysAtIsland() {
        for (CopyOnWriteArrayList<Location> list : Island.getIsland().getListOfLocations()) {
            list.forEach(e -> live10DaysAtLocation(e.getListOfOccupants()));
        }
    }
}
