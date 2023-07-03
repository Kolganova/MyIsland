import constants.Constant;
import island.Island;
import islandOccupants.OccupantFactory;
import islandOccupants.plants.Bush;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Island myIsland = new Island(1, 3);
        System.out.println(myIsland.getListOfLocations().get(0).get(0).isDesert());
        System.out.println();
        System.out.println(Island.Location.getCounter());
        System.out.println(Constant.getListOfOccupantTypes());
//        System.out.println(myIsland.getListOfLocations().get(0).get(0).getListOfOccupants());

    }
}