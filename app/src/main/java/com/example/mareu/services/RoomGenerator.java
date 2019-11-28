package com.example.mareu.services;

import com.example.mareu.R;
import com.example.mareu.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomGenerator {


    public static List<Room> LIST_ROOM = Arrays.asList(

            new Room("Salle 1" , R.drawable.ic_room1 ),
            new Room("Salle 2" , R.drawable.ic_room2 ),
            new Room("Salle 3" , R.drawable.ic_room3 ),
            new Room("Salle 4" , R.drawable.ic_room4 ),
            new Room("Salle 5" , R.drawable.ic_room5 ),
            new Room("Salle 6" , R.drawable.ic_room6 ),
            new Room("Salle 7" , R.drawable.ic_room7 ),
            new Room("Salle 8" , R.drawable.ic_room8 ),
            new Room("Salle 9" , R.drawable.ic_room9 ),
            new Room("Salle 10" , R.drawable.ic_room10)

    );

     public static List<Room> generateRooms() {
        return new ArrayList<>(LIST_ROOM);
    }


}
