package islandOccupants.animals.omnivores;

import island.Island;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.animals.herbivorous.Herbivorous;
import islandOccupants.animals.preadators.Predator;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

public abstract class Omnivores extends Animal {

    public Omnivores(Island.Location location) {
        super(location);
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
    public void move() {

    }

    @Override
    public void isReadyToMultiply() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public void checkPhase(int age) {
        // потом удалить и имплементирвоать во всех классах-наследниках
    }

}
