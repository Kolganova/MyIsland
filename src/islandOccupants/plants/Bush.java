package islandOccupants.plants;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Bush extends Plant {

    static {
        setMaxAmountOfOccupantsOnLocation(100);
    }
    public Bush(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(3.0));

        /* нужно сделать для всех по 2 конструктора - 1 для инициализации острова,
        соответственно, он с параметрами. мы их передадим в фабрику. и второй пустой,
        для новорожденных, у них изначально будут параметры такие же или все таки
        каждый ход будем проверять фазу и менять параметры?
         */
    }
}
