import island.Location;
import island.Island;
import islandOccupants.animals.herbivorous.Deer;

public class Main {
    public static void main(String[] args) {
        Island myIsland = new Island(2, 4);
        Location location = myIsland.getListOfLocations().get(0).get(0);
//        System.out.println(location.getListOfOccupants());
        System.out.println(location.getMapWithOccupantsOnLocation());
        System.out.println();
//        System.out.println(getCounter());
        Deer d = (Deer) location.getListOfOccupants().get(0);
        d.multiply();
        System.out.println(location.getMapWithOccupantsOnLocation());
        System.out.println(location.getListOfOccupants());

    }
}