package islandOccupants.plants;

import enums.CreationType;
import island.Location;

public class Bush extends Plant {

    public Bush(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(50);
        setIsPoisonous(false);
        setWeight(3.0);
        setPropagationFrequency(1);
        location.addOccupantInLocation(this);

        /* нужно сделать для всех по 2 конструктора - 1 для инициализации острова,
        соответственно, он с параметрами. мы их передадим в фабрику. и второй пустой,
        для новорожденных, у них изначально будут параметры такие же или все таки
        каждый ход будем проверять фазу и менять параметры?
         */
    }
}
