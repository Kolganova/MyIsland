package islandOccupants.animals.herbivorous;

import enums.CreationType;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.animals.Animal;
import islandOccupants.plants.Plant;

public abstract class Herbivorous extends Animal {

    public Herbivorous(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
    }

    @Override
    public boolean eat(IslandOccupant occupant) {
        if (occupant instanceof Plant) {
            this.nutritionProcess(this, occupant);
            return true;
        }

        return false;
    } // перенести потом в класс Animal и сделать типо в зависимости от того,
    // в цикле где будем вызывать этот метод сделать while (!this.eat(occupant)), т.е. пока наш метод
    // не вернет значение, что он поел, он будет пытаться поесть
}
