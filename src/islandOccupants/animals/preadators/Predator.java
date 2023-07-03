package islandOccupants.animals.preadators;

import island.Island;
import islandOccupants.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(Island.Location location) {
        super(location);
    }

    @Override
    public synchronized void eat() {

    }

    @Override
    public synchronized void move() {

    }

    @Override
    public synchronized void multiply() {

    }

    @Override
    public void isReadyToMultiply() {

    }
}
