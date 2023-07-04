package islandOccupants.plants;

import enums.PlantAging;
import interfaces.Multipliable;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;

public abstract class Plant extends IslandOccupant implements Multipliable {
    private static double nutritionalValue;
    private static int propagationFrequency;

    public Plant(Location location) {
        super(location);
    }

    @Override
    public PlantAging checkAgingPhase(int age) {
        for (PlantAging temp:PlantAging.values()) {
            if (age >= temp.getMin() && age <= temp.getMax())
                return temp;
        }

        return null;
    }

    @Override
    public synchronized void multiply(String type) {
        if (getCurrentAmountOfOccupantsOnLocation().get() < getMaxAmountOfOccupantsOnLocation()) {
            for (int i = 0; i < propagationFrequency; i++) {
                IslandOccupant currentOccupant = OccupantFactory.createOccupant(type);
                this.getLocation().addOccupantInLocation(currentOccupant);
                getCurrentAmountOfOccupantsOnLocation().getAndIncrement();
            }
        }
    }
    // сделать многопоточным?

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

    public synchronized void vanish() {
        this.getLocation().getListOfOccupants().remove(this);
        //setCurrentAmountOfEntitiesOnLocation(getCurrentAmountOfEntitiesOnLocation().getAndDecrement());
        // пока в комменте т.к. текущее значение пока что null
    }

    @Override
    public boolean isReadyToMultiply() {

        return checkAgingPhase(getAge()) == PlantAging.GROWN;
    }

    public static double getNutritionalValue() {
        return nutritionalValue;
    }

    public static void setNutritionalValue(double nutritionalValue) {
        Plant.nutritionalValue = nutritionalValue;
    }

    public static int getPropagationFrequency() {
        return propagationFrequency;
    }

    public static void setPropagationFrequency(int propagationFrequency) {
        Plant.propagationFrequency = propagationFrequency;
    }
}
