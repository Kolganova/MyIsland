package islandOccupants.plants;

import enums.PlantAging;
import island.Location;
import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;

public abstract class Plant extends IslandOccupant {
    private static double nutritionalValue;
    private static int propagationFrequency;
    private static boolean isPoisonous;

    public Plant(Location location, String type) {
        super(location, type);
        isPoisonous = false;
    }

    @Override
    public PlantAging checkAgingPhase(int age) {
        for (PlantAging temp : PlantAging.values()) {
            if (age >= temp.getMin() && age <= temp.getMax())
                return temp;
        }

        return null;
    }

    public synchronized void multiply() {
        if (this.getLocation().getMapWithOccupantsOnLocation().get(this.getType()).get()
                < getMaxAmountOfOccupantsOnLocation() && checkAgingPhase(getAge()) == PlantAging.GROWN) {
            for (int i = 0; i < propagationFrequency; i++) {
                IslandOccupant currentOccupant = OccupantFactory.createOccupant(this.getType());
                this.getLocation().addOccupantInLocation(currentOccupant);
                this.getLocation().incrementAmountOfOccupantsOnLocation(this.getType());
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
         */

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

    public static boolean isIsPoisonous() {
        return isPoisonous;
    }

    public static void setIsPoisonous(boolean isPoisonous) {
        Plant.isPoisonous = isPoisonous;
    }
}
