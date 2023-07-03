package islandOccupants.animals.herbivorous;

import island.Island;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.animals.omnivores.Omnivores;
import islandOccupants.animals.preadators.Predator;
import islandOccupants.deadAnimals.DeadAnimal;
import islandOccupants.plants.Plant;

public abstract class Herbivorous extends Animal {

    public Herbivorous(Island.Location location) {
        super(location);
    }

    @Override
    public synchronized void eat(IslandOccupant occupant) {
        if (!(occupant instanceof DeadAnimal || occupant instanceof Omnivores)) {
            if (occupant instanceof Predator) {
                // то его едят
            } else if (occupant instanceof Plant) {
                // то он ест
            }
        }
    }

    // в общем логика такая же как и у улитки, мб модно как-то оптимизировать
    // мб общий класс родитель. не дохуя родителей?

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
