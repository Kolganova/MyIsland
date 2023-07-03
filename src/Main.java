import constants.Constant;
import island.Island;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Island myIsland = new Island(1, 2);
        System.out.println(myIsland.getListOfLocations().get(0).get(0));
        System.out.println();
        System.out.println(Island.Location.getCounter());
        System.out.println(Constant.getListOfOccupantTypes());
//        System.out.println(myIsland.getListOfLocations().get(0).get(0).getListOfOccupants());

    }
}