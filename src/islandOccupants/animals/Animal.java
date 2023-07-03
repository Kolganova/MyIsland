package islandOccupants.animals;

import enums.AnimalAging;
import interfaces.*;
import island.Island;
import islandOccupants.IslandOccupant;

public abstract class Animal extends IslandOccupant implements Movable, Eatable, Multipliable {
    private static int maxAmountOfMoves;
    private double killingRate;
    private AnimalAging agingPhase;
    private boolean isFemale;

    public Animal(Island.Location location) {
        super(location);
    }

    public abstract void die();

    public void setAgingPhase(AnimalAging agingPhase) {
        this.agingPhase = agingPhase;
    }

    private class Body {
        private static int satietyCostOnMovement;
        private static int satietyCostOnMultiply;
        private static boolean isPoisonProtected;
        private int moveCounter;
        private int bellySize;
        private int currentSatiety;
        private double hungerRate;
    }

}
