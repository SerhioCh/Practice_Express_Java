package CleanCode.practice_2.homework.facade.Task1;

public class DoorFacade {
    OpenDoor openDoor;
    CloseDoor closeDoor;
    BlockDoor blockDoor;

    public DoorFacade(OpenDoor openDoor, CloseDoor closeDoor, BlockDoor blockDoor) {
        this.openDoor = openDoor;
        this.closeDoor = closeDoor;
        this.blockDoor = blockDoor;
    }

    public void openDoor(){
        openDoor.open();
    }

    public  void  closeDoor(){
        closeDoor.close();
    }
    public  void blockDoor(){
        blockDoor.block();
    }

    public  void fullCycle(){
        openDoor.open();
        closeDoor.close();
        blockDoor.block();
    }
}
