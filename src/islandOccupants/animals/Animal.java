package islandOccupants.animals;

import enums.AnimalAging;
import interfaces.*;
import island.Island;
import islandOccupants.IslandOccupant;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Animal extends IslandOccupant implements Movable, Eatable, Multipliable {
    private static int maxAmountOfMoves;
    private double killingRate;
    private AnimalAging agingPhase;
    private boolean isFemale;

    private AtomicBoolean hasEat = new AtomicBoolean();

    public Animal(Island.Location location) {
        super(location);
    }

    public void setAgingPhase(AnimalAging agingPhase) {
        this.agingPhase = agingPhase;
    }

    public AtomicBoolean getHasEat() {
        return hasEat;
    }

    public void setHasEat(AtomicBoolean hasEat) {
        this.hasEat = hasEat;
    }

    private static class Body {
        private static int satietyCostOnMovement;
        private static int satietyCostOnMultiply;
        private static boolean isPoisonProtected;
        private int moveCounter;
        private int bellySize;
        private int currentSatiety;
        private double hungerRate;
    }

}
