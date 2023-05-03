package net.zhongli.dungeons;

import net.zhongli.geometry.Voxel2D;

public class DungeonRoomArray {

    private DungeonRoom[][] rooms;
    private DungeonRoomGenerator generator;

    public DungeonRoomArray(int width, int height) {
        this.rooms = new DungeonRoom[width][height];
        this.generator = new DungeonRoomGenerator(this);
    }

    public DungeonRoom[][] getRooms() {
        return this.rooms;
    }

    public DungeonRoom get(int x, int y) {
        //If x or y is out of bounds, return null.
        if (!this.isValid(x, y)) {
            return null;
        }
        return this.rooms[x][y];
    }

    public Voxel2D[][] getRealWorldCoordinates(Voxel2D origin) {
        Voxel2D[][] coordinates = new Voxel2D[this.getWidth()][this.getHeight()];
        for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                coordinates[x][y] = origin.add(x * rooms[x][y].ROOM_DIAMETER_VOXELS, y * rooms[x][y].ROOM_DIAMETER_VOXELS);
            }
        }
        return coordinates;
    }

    public void set(int x, int y, DungeonRoom room) {
        //If x or y is out of bounds, return.
        if (!this.isValid(x, y)) {
            return;
        }
        this.rooms[x][y] = room;
    }

    public int getWidth() {
        return this.rooms.length;
    }

    public int getHeight() {
        return this.rooms[0].length;
    }

    /*
    Explanation: A voxel is valid if it is within the bounds of the dungeon.
     */
    public boolean isValid(int x, int y) {
        return x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight();
    }

    public boolean isValid(DoorSide side, int x, int y) {
        return switch (side) {
            case NORTH -> this.isValid(x, y - 1);
            case EAST -> this.isValid(x + 1, y);
            case SOUTH -> this.isValid(x, y + 1);
            case WEST -> this.isValid(x - 1, y);
            default -> false;
        };
    }

}
