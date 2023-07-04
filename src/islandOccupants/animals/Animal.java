package islandOccupants.animals;

import enums.AnimalAging;
import interfaces.*;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.herbivorous.Herbivorous;
import islandOccupants.animals.preadators.Predator;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Animal extends IslandOccupant implements Movable, Eatable, Multipliable {
    private static int maxAmountOfMoves;
    private double killingRate;
    private boolean isFemale;

    private AtomicBoolean hasEat = new AtomicBoolean();

    public Animal(Location location) {
        super(location);
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

    @Override
    public synchronized void eat(IslandOccupant occupant) {
        if (!(occupant instanceof DeadAnimal || occupant instanceof Herbivorous)) {
            if (occupant instanceof Predator) {
                // то его едят скорее всего
            }
            else if (occupant instanceof Plant) {
                // то он его ест
            }
        }
    }

    @Override
    public AnimalAging checkAgingPhase(int age) {
        for (AnimalAging temp:AnimalAging.values()) {
            if (age >= temp.getMin() && age <= temp.getMax())
                return temp;
        }

        return null;
    }

    @Override
    public boolean isReadyToMultiply() {

        return (checkAgingPhase(this.getAge()) == AnimalAging.YOUNG ||
                checkAgingPhase(this.getAge()) == AnimalAging.ADULT);
        // проверить зрелость и мб чота еще, надо карту посмотреть
    }

    @Override
    public void multiply(String type) {
        // сделать размножение после проверки условий
    }
}
