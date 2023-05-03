package net.zhongli;

import net.zhongli.dungeons.DungeonRoom;
import net.zhongli.dungeons.DungeonRoomArray;
import net.zhongli.geometry.Voxel2D;

import java.util.Arrays;

public class Main {

    /*
    A system to generate dungeons for use in other software.
    This is a common system which will take input from other software and generate a dungeon.
    This is a Voxel based system.
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");

        DungeonRoomArray array = new DungeonRoomArray(5, 5);
        System.out.println(array.get(0, 0));
        //System.out.println(Arrays.toString(array.get(0, 0).getDoorSides()));
        //Print out array using toString
        DungeonRoom[][] rooms = array.getRooms();
        for (DungeonRoom[] room : rooms) {
            System.out.println(Arrays.toString(room));
        }
        Voxel2D[][] coordinates = array.getRealWorldCoordinates(new Voxel2D(0, 0));
        for (Voxel2D[] coordinate : coordinates) {
            System.out.println(Arrays.toString(coordinate));
        }
    }

}