package JavaDev.sobes.oop;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    List <Room> rooms = new ArrayList<>();

    public  void addRoom (Room room){
        rooms.add(room);
    }
    public  void findRooms(){
        rooms.stream()
                .filter(r ->r.getStatus().equals("Available"))
                .forEach(r -> r.getCost());
    }
}
