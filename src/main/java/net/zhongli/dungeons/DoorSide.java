package net.zhongli.dungeons;

public enum DoorSide {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private int relativeX;
    private int relativeY;

    DoorSide(int relativeX, int relativeY) {
        this.relativeX = relativeX;
        this.relativeY = relativeY;
    }

    public int getRelativeX() {
        return this.relativeX;
    }

    public int getRelativeY() {
        return this.relativeY;
    }

    public boolean canConnect(DoorSide other) {
        // A door side can connect when it is opposite to another door side.
        if (other == null) return false;
        return this.ordinal() == (other.ordinal() + 2) % 4;
    }

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "NORTH";
            case EAST -> "EAST";
            case SOUTH -> "SOUTH";
            case WEST -> "WEST";
        };
    }
}


