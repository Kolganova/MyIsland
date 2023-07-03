package islandOccupants.plants;

import island.Island;
import islandOccupants.IslandOccupant;

public abstract class Plant extends IslandOccupant {
    private static double nutritionalValue;
    private static int propagationFrequency;
    private boolean isAbleToGrowOnThisLocation;

    public Plant(Island.Location location) {
        super(location);
    }

    @Override
    public void checkPhase(int age) {
        // переделать для каждого наследника
    }
    public synchronized void propagation(Island.Location location, int propagationFrequency) {
        /* откуда его будут вызывать? аргументы тоже под вопросом
        должен вызываться в пуле потоков? для того что бы быстро обрабатывать все
        растения на локации
        в пуле "хода" можно просто понимать через instanceof что это за класс и исходя из этого
        выполнять определенные методы, которые этот класс должен делать в каждом ходу
        т.е. растение только распространяется и "стареет" (и мб меняет enums.PlantAging)
         в самой логике смысл такой:
         распространение растения на этой локации если может расти на этой локации +
         если на локации есть место
         */
    }

    public synchronized void vanish() {
        this.getLocation().getListOfOccupants().remove(this);
        //setCurrentAmountOfEntitiesOnLocation(getCurrentAmountOfEntitiesOnLocation().getAndDecrement());
        // пока в комменте т.к. текущее значение пока что null
    }
}
