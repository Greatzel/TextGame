import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);
    Map map = new Map();
    Player player = new Player();
    ArrayList<Item> items = new ArrayList<>();


    public Game() {
        this.input = input;
        this.map = map;
        this.player = player;
       // this.rooms = rooms;
        this.items = items;
    }


    public Game(Scanner input, Map map, Player player, ArrayList<Room> rooms, ArrayList<Item> items) {
        this.input = input;
        this.map = map;
        this.player = player;
    }


    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public void start(ArrayList<Room> rooms){
        System.out.println("Welcome to the game, player. You are in room 1.");
        System.out.println(rooms.get(0).getRoomDescription());
    }

    public String gamePrompt(){

        System.out.println("To move type NORTH, WEST, SOUTH, or EAST");
        System.out.println("Player actions: Explore, Pick Up, Drop");
        String playerInput = input.nextLine();
        System.out.println(playerInput);
        //should be input parsing method instead of move method.
        //player.movePlayer(playerInput, player);
        //parsePlayerInput(playerInput, gamePromptGame.getPlayer(), gamePromptGame.getRooms());


        return playerInput;
    }

    public Player parsePlayerInput(String playerInput, Player player, Map map, ArrayList<Item> itemList){

       // System.out.println("PARSE INPUT REACHED");
       // Player currentPlayer = new Player();

        if(playerInput.equalsIgnoreCase("North") ||
            playerInput.equalsIgnoreCase("West") ||
                playerInput.equalsIgnoreCase("South") ||
                    playerInput.equalsIgnoreCase("East")){

            player.movePlayer(playerInput, player, map);
        } else if (playerInput.equalsIgnoreCase("Explore")){
            player.playerExplore(player, map);
        } else if (playerInput.equalsIgnoreCase("Pick Up")){
            player.addItemToPlayerInventory(player, map);
        } else if (playerInput.equalsIgnoreCase("Drop")){
            player.dropItem(player);
        }

        return player;
    }

    @Override
    public String toString() {
        return "Game{" +
                "input=" + input +
                ", map=" + map +
                ", player=" + player +
                //", rooms=" + rooms +
                //", items=" + items +
                '}';
    }
}
