public class Launch {

    public static void main (String [] args){

        Map map = new Map();
        Player player = new Player();
        Game game = new Game();


        boolean gameRunning = true;

        map.setPuzzle(map.readPuzzleFile("src\\Puzzles.txt"));
        map.setItemsList(map.readItemFile("src\\Items.txt"));
        map.setRoomsList(map.readRoomsFile("src\\Rooms.txt"));

        game.start(map.getRoomsList());
        player.setPlayerLocation(map.getRoomsList().get(0));
        map.getRoomsList().get(0).setVisited(true);


        while(gameRunning){
            String playerInput = game.gamePrompt();

            // System.out.println(playerInput);
            // There was a problem getting the room list info from map.
            //I wanted to use game class to contain everything but it did not work so here we are!
            player = game.parsePlayerInput(playerInput, player, map, map.getItemsList());
            game.setPlayer(player);
            game.setMap(game.getMap());

        }

    }

}
