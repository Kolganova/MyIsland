package islandOccupants.animals.omnivores;

import island.Island;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;

public abstract class Omnivores extends Animal {

    public Omnivores(Island.Location location) {
        super(location);
    }

    @Override
    public void die() {

    }

    @Override
    public void eat() {

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
