package islandOccupants.animals.herbivorous;

import island.Island;
import islandOccupants.animals.Animal;

public abstract class Herbivorous extends Animal {

    public Herbivorous(Island.Location location) {
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
