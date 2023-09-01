package behavior.eatable;

import model.IslandOccupant;

public interface Eatable {
    boolean eat(IslandOccupant occupant);

    void nutritionProcess(IslandOccupant occupant);
}
