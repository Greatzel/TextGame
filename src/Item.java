import java.util.ArrayList;


public class Item {

    private String itemName;
    private String itemID;
    private String roomID;
    private String itemDescription;
    private boolean isFound;


    public Item(String itemName, String itemID, String roomID, String itemDescription) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.roomID = roomID;
        this.itemDescription = itemDescription;
    }

    public Item() {
        this.itemName = "None";
        this.itemID = "None";
        this.roomID = "None";
        this.itemDescription = "None";
        this.isFound = false;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    public void printItemsList(ArrayList<Item> items) {
        System.out.println("Method Reached");
        for (int i = 0; i < items.size(); i++) {
            System.out.println( "ITEMS LIST: " + items.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return itemName+ ". " + itemDescription;
    }
}
