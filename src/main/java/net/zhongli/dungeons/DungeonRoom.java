package net.zhongli.dungeons;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class DungeonRoom {
    private String id;
    private DoorSide[] doorSides;
    //Might be customisable in the future, it's for upcoming generation features.
    public final int ROOM_DIAMETER_VOXELS = 32;
    private double roomWeight;

    public DungeonRoom(String id, double weight) {
        this.id = id;
        this.doorSides = new DoorSide[4];
        doorSides[0] = DoorSide.NORTH;
        //doorSides[1] = DoorSide.EAST;
        doorSides[2] = DoorSide.SOUTH;
        doorSides[3] = DoorSide.WEST;
        this.roomWeight = weight;
    }

    public DungeonRoom withSides(DoorSide... sides) {
        this.doorSides = sides;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public boolean isValidDoorside(DoorSide side) {
        return this.doorSides[side.ordinal()] == null;
    }

    public void setDoorside(DoorSide side) {
        this.doorSides[side.ordinal()] = side;
    }

    public DoorSide[] getDoorSides() {
        return this.doorSides;
    }

    public boolean canGenerateNextTo(DungeonRoom other, int prevX, int prevY, int nextX, int nextY) {
        if (other == null) return true;

        System.out.println(
                "Prev: " + prevX + " " + prevY + "\n" +
                "Next: " + nextX + " " + nextY
        );

        int relativeX = nextX - prevX;
        int relativeY = nextY - prevY;

        List<DoorSide> filteredSides = Stream.of(this.doorSides).filter(side -> {
            boolean isValid = true;

            if (side == null) return false;
            int sideRelX = side.getRelativeX();
            int sideRelY = side.getRelativeY();

            System.out.println("===================================");
            System.out.println("Side: " + side + " " + sideRelX + " " + sideRelY);
            System.out.println("Relative: " + relativeX + " " + relativeY);
            System.out.println("===================================");

            return isValid;
        }).toList();

        return false;
    }

    public double getRoomWeight() {
        return this.roomWeight;
    }

    public DoorSide getRandomNotNullDoorSide() {
        DoorSide[] filteredSides = Stream.of(this.doorSides).filter(Objects::nonNull).toArray(DoorSide[]::new);
        return filteredSides[(int) (Math.random() * filteredSides.length)];
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", doorSides='[" + getDoorSides()[0] + ", " + getDoorSides()[1] + ", " + getDoorSides()[2] + ", " + getDoorSides()[3] + "]'" +
                ", roomWeight='" + getRoomWeight() + "'" +
                "}";
    }
}
