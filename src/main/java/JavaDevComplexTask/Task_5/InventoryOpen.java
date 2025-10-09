package JavaDevComplexTask.Task_5;

public class InventoryOpen {
    private boolean isInventoryOpen;

    public InventoryOpen() {
        this.isInventoryOpen = true;
    }

    public InventoryOpen(boolean isInventoryOpen) {
        this.isInventoryOpen = isInventoryOpen;
    }

    public boolean isInventoryOpen() {
        return isInventoryOpen;
    }

    public void setInventoryOpen(boolean inventoryOpen) {
        isInventoryOpen = inventoryOpen;
    }
}
