package net.zhongli.dungeons;

public class DungeonRoomGenerator {

    private DungeonRoomArray array;
    private DungeonRoomPicker picker;

    public DungeonRoomGenerator(DungeonRoomArray array) {
        this.array = array;
        this.picker = new DungeonRoomPicker(array, new DungeonRoom[] { new DungeonRoom("test", 5.0d).withSides(
                DoorSide.NORTH,
                DoorSide.EAST,
                DoorSide.SOUTH,
                DoorSide.WEST
        ), new DungeonRoom("test2", 5.0d).withSides(
                null,
                null,
                null,
                DoorSide.WEST
        ) });
        this.picker.pick();
    }

    public DungeonRoomArray getArray() {
        return this.array;
    }

    public DungeonRoomPicker getPicker() {
        return this.picker;
    }

}
