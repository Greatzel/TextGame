import java.util.ArrayList;
import java.util.HashMap;

public class Player {

    private Room playerLocation;
    private ArrayList<Item> inventory;
    HashMap<String, String> visitedRooms = new HashMap();
    Map map = new Map();

    public Player(){
        this.playerLocation = new Room();
    }

    public Player(Room playerLocation, ArrayList<Item> inventory) {
        this.playerLocation = playerLocation;
        this.inventory = inventory;
    }

    public Room getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Room playerLocation) {
        this.playerLocation = playerLocation;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public Player movePlayer(String playerInput, Player player, Map rooms)  {

        try {
            if (playerInput.equalsIgnoreCase("North")) {
                moveNorth(player, rooms);
            }
            else if (playerInput.equalsIgnoreCase("West")) {
                moveWest(player, rooms);
            } else if (playerInput.equalsIgnoreCase("South")) {
                moveSouth(player, rooms);
            } else if (playerInput.equalsIgnoreCase("East")) {
                moveEast(player, rooms);

            }
        } catch (DeadEndFound e){
//            e.getMessage();
//            System.out.println("Error in moving player");
        }
        return  player;
    }

    public void moveNorth(Player player, Map rooms) throws DeadEndFound{
        Room newRoom;
        if(!player.getPlayerLocation().getNorthRoom().contentEquals("0")){
            newRoom = rooms.roomConnections(player.getPlayerLocation().getNorthRoom(), player.getPlayerLocation(), rooms);
            player.setPlayerLocation(newRoom);
            player.checkRoomFamiliarity(newRoom);
            newRoom.setVisited(true);
            visitedRooms.put(player.getPlayerLocation().getRoomID(), playerLocation.getRoomDescription());
            System.out.println("You are in Room " + newRoom.getRoomID() + ", " + newRoom.getRoomDescription());
        } else {
            throw new DeadEndFound();
        }
    }

    public void moveWest(Player player, Map rooms)  throws DeadEndFound{
        Room newRoom;
        if(!player.getPlayerLocation().getWestRoom().contentEquals("0")){
            newRoom = rooms.roomConnections(player.getPlayerLocation().getWestRoom(), player.getPlayerLocation(), rooms);
            player.setPlayerLocation(newRoom);
            player.checkRoomFamiliarity(newRoom);
            newRoom.setVisited(true);
            visitedRooms.put(player.getPlayerLocation().getRoomID(), playerLocation.getRoomDescription());
            System.out.println("You are in Room " + newRoom.getRoomID() + ", " + newRoom.getRoomDescription());
        } else {
            throw new DeadEndFound();
        }

    }

    public void moveSouth(Player player, Map rooms) throws DeadEndFound{
        Room newRoom;
        if(!player.getPlayerLocation().getSouthRoom().contentEquals("0")){
            newRoom = rooms.roomConnections(player.getPlayerLocation().getSouthRoom(), player.getPlayerLocation(), rooms);
            player.setPlayerLocation(newRoom);
            player.checkRoomFamiliarity(newRoom);
            newRoom.setVisited(true);
            visitedRooms.put(player.getPlayerLocation().getRoomID(), playerLocation.getRoomDescription());
            System.out.println("You are in Room " + newRoom.getRoomID() + ", " + newRoom.getRoomDescription());
        } else {
            throw new DeadEndFound();
        }

    }

    public void moveEast(Player player, Map map)  throws DeadEndFound{
        Room newRoom;

        //player.getPlayerLocation().checkPuzzle(player.getPlayerLocation());

        if(!player.getPlayerLocation().getEastRoom().contentEquals("0")){

            newRoom = map.roomConnections(player.getPlayerLocation().getEastRoom(), player.getPlayerLocation(), map);
            player.setPlayerLocation(newRoom);
            player.checkRoomFamiliarity(newRoom);
            newRoom.setVisited(true);
            visitedRooms.put(player.getPlayerLocation().getRoomID(), playerLocation.getRoomDescription());
            System.out.println("You are in Room " + newRoom.getRoomID() + ", " + newRoom.getRoomDescription());

        } else {
            throw new DeadEndFound();
        }
    }

    public Room playerExplore(Player player, Map map){

        if(!player.getPlayerLocation().getRoomInventory().isEmpty()){
            System.out.println(" You found something! " + player.getPlayerLocation().getRoomInventory().toString());
            //map.getRoomsList().remove(player.getInventory());
        } else {
            System.out.println("Nothing new here.");
        }
        return  player.getPlayerLocation();
    }

    public void addItemToPlayerInventory (Player player, Map map){
        if(!player.getPlayerLocation().getRoomInventory().isEmpty()){
            player.setInventory(player.getPlayerLocation().getRoomInventory());
            System.out.println("Obtained " + player.getInventory());
           //player.playerLocation.getRoomInventory().remove(playerLocation.getRoomInventory().get(0));
//            player.getPlayerLocation().getRoomInventory().remove(player.getInventory());
            map.getRoomsList().remove(player.getInventory());
        } else {
            System.out.println("There's nothing in this room to pick up. ");
        }
    }

    public void dropItem(Player player){
        if(!player.getPlayerLocation().getRoomInventory().isEmpty()){
            playerLocation.addRoomInventory(player.getInventory().get(0));
            System.out.println("Dropped " + player.getInventory());
            player.getInventory().remove(playerLocation.getRoomInventory());
        } else {
            System.out.println("You have no item in your inventory.");
        }
    }

    public void checkRoomFamiliarity(Room room){
        //      System.out.println(" ROOM IN FAMILIARITY " +  room.getRoomID());
        if(visitedRooms.containsKey(room.getRoomID())){
            System.out.println("This room is familiar. You've been here before.");
        } else {
            System.out.println("new room!");
        }
    }


    @Override
    public String toString() {
        return "Player{" +
                "playerLocation=" + playerLocation +
                ", inventory=" + inventory +
                '}';
    }
}
