/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;
import java.io.Serializable;
/**
 *
 * @author Cheryl Allred
 */
public class MainMenuControl implements Serializable {
    
    public void createPlayerList(){
        GetPlayersListView getPlayersListView = new GetPlayersListView();
        String[] listOfPlayersNames = getPlayersListView.getInput();
        
        Player[] playerList = new Player[listOfPlayersNames.length];
        
        for (int i = 0; i < playerList.length; i++){
            String playersName = listOfPlayersNames[i];
            Player newPlayer = new Player();
            newPlayer.name = playersName;
            playerList[i] = newPlayer;
        }
        
        ConnectFour.setPlayerList(playerList);
    }
     
    public void startGame(long noPlayers) {
                
        if (noPlayers != 1  &&  noPlayers != 2) {
            new ConnectFourError().displayError("startGame - invalid number of players specified.");
            return;
        }
        
        Game game;
        if (noPlayers == 1) {
            game = this.create("ONE_PLAYER");
        }
        else {
            game = this.create("TWO_PLAYER");
        }

        GameMenuView gameMenu = new GameMenuView(game);
        gameMenu.getInput();
    }

    
    
    public Game create(String gameType) {
        Game game = null;
        Player player1 = null;
        Player player2 = null;
        
        if (gameType == null) {
            new ConnectFourError().displayError("MainCommands - create: gameType is null");
            return null;
        }
        
        if (gameType.equals(Game.ONE_PLAYER)) {
            game = new Game(Game.ONE_PLAYER);
            player1 = new Player(Player.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_MARKER);
            player1.name= "Player 1";
            player2 = new Player(Player.COMPUTER_PLAYER, Game.PLAYER_B_DEFAULT_MARKER);
            player2.name= "Computer";
        }
        else if (gameType.equals(Game.TWO_PLAYER)) {
            game = new Game(Game.TWO_PLAYER);
            player1 = new Player(Player.REGULAR_PLAYER, Game.PLAYER_A_DEFAULT_MARKER);
            player1.name="Player 1";
            player2 = new Player(Player.REGULAR_PLAYER, Game.PLAYER_B_DEFAULT_MARKER);
            player2.name="Player 2";

        }
      
        game.playerA = player1;
        game.playerB = player2;
        
        return game;
    } 
    
    public void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.getInput();
    }
    
}