import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    ArrayList<Room> roomsList = new ArrayList();
    ArrayList<Item> itemsList = new ArrayList<>();
    Puzzle puzzle;

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public ArrayList<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public ArrayList<Room> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(ArrayList<Room> roomsList) {
        this.roomsList = roomsList;
    }

    public ArrayList<Room> readRoomsFile(String file) {

        try {

            File textFile = new File(file);
            Scanner textFileReader = new Scanner(textFile);

            while (textFileReader.hasNextLine()) {
                Room room = new Room();
                room.setRoomDescription(textFileReader.nextLine());
                room.setRoomID(textFileReader.nextLine());
                room.setNorthRoom(textFileReader.nextLine());
                room.setWestRoom(textFileReader.nextLine());
                room.setSouthRoom(textFileReader.nextLine());
                room.setEastRoom(textFileReader.nextLine());


                for(int i =0; i < itemsList.size(); i++){
                    if(room.getRoomID().contentEquals(itemsList.get(i).getRoomID())){
                        room.addRoomInventory(itemsList.get(i));
                    }

                }
                roomsList.add(room);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Your file is not found!");
        }

        return roomsList;
    }

    public ArrayList<Item> readItemFile(String file){

        try {

            File textFile = new File(file);
            Scanner textFileReader = new Scanner(textFile);

            while (textFileReader.hasNextLine()) {
                Item item = new Item();
                item.setItemName(textFileReader.nextLine());
                item.setItemID(textFileReader.nextLine());
                item.setRoomID(textFileReader.nextLine());
                item.setItemDescription(textFileReader.nextLine());

                itemsList.add(item);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Your file is not found!");
        }

        return itemsList;
    }


    public Puzzle readPuzzleFile(String file){

        try {
            File textFile = new File(file);
            Scanner textFileReader = new Scanner(textFile);

                Puzzle puzzle = new Puzzle();
                puzzle.setDescription(textFileReader.nextLine());
                puzzle.setAnswer(textFileReader.nextLine());
                puzzle.setPuzzleID(textFileReader.nextLine());
                puzzle.setRoomID(textFileReader.nextLine());

        } catch (FileNotFoundException e) {
            System.out.println("Your file is not found!");
        }
        return puzzle;
    }

    public void printRoomList(ArrayList<Room> rooms) {
        System.out.println("Method Reached");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i).toString());
        }
    }

    public Room roomConnections(String roomDirectionValue, Room currentRoom, Map rooms){
        ArrayList<Room> newList = rooms.getRoomsList();
        Room newRoom = new Room();

        for(int i = 0; i < newList.size(); i++){
            Room holder;
            if(roomDirectionValue.contentEquals(newList.get(i).getRoomID())){
                holder = newList.get(i);
                return holder;
            }
           holder = newList.get(i);
           newRoom = holder;
    }
        return newRoom;
    }

}

