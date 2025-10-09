package CleanCode.practice_2.homework.facade.Task1;

public class Main {
    public static void main(String[] args) {
        OpenDoor openDoor = new OpenDoor();
        CloseDoor closeDoor = new CloseDoor();
        BlockDoor blockDoor = new BlockDoor();

        DoorFacade doorFacade = new DoorFacade(openDoor,closeDoor,blockDoor);

        doorFacade.openDoor();
        doorFacade.blockDoor();

        doorFacade.fullCycle();
    }
}
