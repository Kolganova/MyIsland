import island.Island;

public class Main {
    public static void main(String[] args) {
        Island creepyIsland = new Island(2, 5, "CreepyIsland");
        Menu.playInSimulation(creepyIsland);
    }
}