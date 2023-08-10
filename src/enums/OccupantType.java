package enums;

public enum OccupantType {
    BUFFALO("\uD83D\uDC03"),
    CATERPILLAR("\uD83D\uDC1B"),
    DEER("\uD83E\uDD8C"),
    GOAT("\uD83D\uDC10"),
    HORSE("\uD83D\uDC0E"),
    MOUSE("\uD83D\uDC01"),
    RABBIT("\uD83D\uDC07"),
    SHEEP("\uD83D\uDC11"),
    BOAR("\uD83D\uDC17"),
    DUCK("\uD83E\uDD86"),
    BEAR("\uD83D\uDC3B"),
    BOA("\uD83D\uDC0D"),
    EAGLE("\uD83E\uDD85"),
    FOX("\uD83E\uDD8A"),
    WOLF("\uD83D\uDC3A"),
    DEAD_ANIMAL("\uD83E\uDD69"),
    BUSH("\uD83C\uDF33"),
    FLOWER("\uD83C\uDF37"),
    GRASS("\uD83C\uDF31"),
    POISON_FLOWER("\uD83E\uDD40");

    private final String unicode;

    OccupantType(String unicode) {
        this.unicode = unicode;
    }

    public String getUnicode() {
        return unicode;
    }
}
