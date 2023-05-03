package net.zhongli.dungeons;

import net.zhongli.random.WeightedChooser;

import java.util.Arrays;

public class DungeonRoomPicker {

    private DungeonRoom[] roomSet;
    private WeightedChooser<DungeonRoom> roomWeightedChooser;
    private DungeonRoomArray array;
    private final int MAX_DEPTH = 250;

    DungeonRoomPicker(DungeonRoomArray array, DungeonRoom[] roomSet) {
        this.roomSet = roomSet;
        this.roomWeightedChooser = new WeightedChooser<DungeonRoom>();
        this.array = array;

        for (DungeonRoom room : this.roomSet) {
            this.roomWeightedChooser.add(room, room.getRoomWeight());
        }
    }

    public void pick() {
        int width = this.array.getWidth();
        int height = this.array.getHeight();
        int INITIAL_X = width / 2;
        int INITIAL_Y = height / 2;

        this.array.set(INITIAL_X, INITIAL_Y, this.roomWeightedChooser.choose());
        boolean[][] visited = new boolean[width][height];
        visited[INITIAL_X][INITIAL_Y] = true;

        iterate(INITIAL_X, INITIAL_Y, 0, visited, new boolean[width][height]);
    }

    public void iterate(int INITIAL_X, int INITIAL_Y, int depth, boolean[][] visited, boolean[][] current) {
        int width = this.array.getWidth();
        int height = this.array.getHeight();

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(Arrays.toString(current[0]));
        System.out.println(Arrays.toString(current[1]));
        System.out.println(Arrays.toString(current[2]));
        System.out.println(Arrays.toString(current[3]));
        System.out.println(Arrays.toString(current[4]));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("============================================");
        System.out.println(Arrays.toString(visited[0]));
        System.out.println(Arrays.toString(visited[1]));
        System.out.println(Arrays.toString(visited[2]));
        System.out.println(Arrays.toString(visited[3]));
        System.out.println(Arrays.toString(visited[4]));
        System.out.println("============================================");

        int randomX = (int) (Math.random() * width-1);
        int randomY = (int) (Math.random() * height-1);

        DungeonRoom[] surrounding = new DungeonRoom[4];
        for (DoorSide side : DoorSide.values()) {
            int relativeX = side.getRelativeX();
            int relativeY = side.getRelativeY();
            int x = randomX + relativeX;
            int y = randomY + relativeY;

            if (x < 0 || x >= width || y < 0 || y >= height) {
                continue;
            }

            //current[x][y] = true;
            surrounding[side.ordinal()] = this.array.get(x, y);

            if (surrounding[side.ordinal()] == null) {
                INITIAL_X = x;
                INITIAL_Y = y;
                visited[x][y] = true;
                current[x][y] = false;

                this.array.set(INITIAL_X, INITIAL_Y, this.roomWeightedChooser.choose());
                break;
            } else {
                System.out.println("surrounding[" + side.ordinal() + "] = " + surrounding[side.ordinal()].getId());
            }
        }

        if (depth > MAX_DEPTH) {
            //Insert a random room into all null rooms.
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y ++) {
                    if (this.array.get(x, y) == null) {
                        this.array.set(x, y, this.roomWeightedChooser.choose());
                    }
                }
            }

            return;
        }

        if (!isArrayFull()) {
            iterate(INITIAL_X, INITIAL_Y, depth + 1, visited, current);
        }
    }

    public boolean isArrayFull() {
        int width = this.array.getWidth();
        int height = this.array.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y ++) {
                if (this.array.get(x, y) == null) {
                    return false;
                }
            }
        }

        return true;
    }

}
