import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    private String roomID;
    private String northRoom;
    private String westRoom;
    private String southRoom;
    private String eastRoom;
    private boolean isVisited;
    private int timesVisited;
    private String roomDescription;
    private ArrayList<Item> roomInventory;
    private Puzzle puzzle;

    public Room(){
        this.roomID = "0";
        this.northRoom = "0";
        this.westRoom = "0";
        this.southRoom = "0";
        this.eastRoom = "0";
        this.isVisited = false;
        this.timesVisited = 0;
        this.roomDescription = " NONE  ";
        this.roomInventory = new ArrayList<Item>();
        this.puzzle = new Puzzle();
    }

    public Room(String roomID, String northRoom, String westRoom, String southRoom, String eastRoom, boolean isVisited, String roomDescription, int timesVisited, ArrayList<Item> roomInventory, Puzzle puzzle) {
        this.roomID = roomID;
        this.northRoom = northRoom;
        this.westRoom = westRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.isVisited = isVisited;
        this.timesVisited = timesVisited;
        this.roomDescription = roomDescription;
        this.roomInventory = roomInventory;
        this.puzzle = puzzle;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(String northRoom) {
        this.northRoom = northRoom;
    }

    public String getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(String westRoom) {
        this.westRoom = westRoom;
    }

    public String getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(String southRoom) {
        this.southRoom = southRoom;
    }

    public String getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(String eastRoom) {
        this.eastRoom = eastRoom;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getTimesVisited() {
        return timesVisited;
    }

    public void setTimesVisited(int timesVisited) {
        this.timesVisited = timesVisited;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public ArrayList<Item> getRoomInventory() {
        return roomInventory;
    }

    public void addRoomInventory(Item item) {
        roomInventory.add(item);
    }

//    public void checkPuzzle(Room room){
//        Scanner input = new Scanner(System.in);
//        String playerAnswer;
//        boolean puzzleTime = true;
//
//        if(!room.getPuzzle().getDescription().isEmpty()) {
//
//            while (puzzleTime) {
//                room.getPuzzle().getDescription();
//                playerAnswer = input.nextLine();
//                if (playerAnswer.equalsIgnoreCase(puzzle.getAnswer())) {
//                    System.out.println("Correct!");
//                    puzzleTime = false;
//                } else {
//                    System.out.println("Try again!");
//                }
//            }
//        }
//    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID='" + roomID + '\'' +
                ", northRoom='" + northRoom + '\'' +
                ", westRoom='" + westRoom + '\'' +
                ", southRoom='" + southRoom + '\'' +
                ", eastRoom='" + eastRoom + '\'' +
                ", isVisited=" + isVisited +
                ", timesVisited=" + timesVisited +
                ", roomDescription='" + roomDescription + '\'' +
                ", roomInventory=" + roomInventory +
                '}';
    }
}


