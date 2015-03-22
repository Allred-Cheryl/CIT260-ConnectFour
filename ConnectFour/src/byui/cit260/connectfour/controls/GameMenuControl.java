/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.controls;


import byui.cit260.connectfour.models.Board;
import byui.cit260.connectfour.models.Game;
import byui.cit260.connectfour.models.Player;
import byui.cit260.connectfour.views.HelpMenuView;
import byui.cit260.connectfour.views.GetLocationView;
import byui.cit260.connectfour.views.GamePreferencesMenuView;
import byui.cit260.connectfour.views.BoardView;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Erin
 */
public class GameMenuControl {
    private final Game game;
    private final Board board;
    private GetLocationView getLocationView;
    private final BoardView boardView = new BoardView();

    public GameMenuControl(Game game) {
        this.game = game;
        this.board = game.board;
    }

       
    
   public void takeTurn() {
       
       int returnValue = 1;
       
       if(!this.game.status.equals(Game.NEW_GAME)&&
          !this.game.status.equals(Game.PLAYING)){
           new ConnectFourError().displayError("You must start a new game first.");
           return;
       }
       if (this.game.gameType.equals(Game.TWO_PLAYER)){
           returnValue = this.regularPlayerTurn(this.game.currentPlayer);
           if (returnValue < 0 || this.gameOver(this.game.currentPlayer)){
               return;
           }
           this.displayBoard();
           this.alternatePlayers();
           
           returnValue = this.regularPlayerTurn(this.game.currentPlayer);
           if (returnValue < 0 || this.gameOver(this.game.currentPlayer)){
               return;
           }
           this.displayBoard();
           this.alternatePlayers();
       }
       
       else {
           this.regularPlayerTurn(this.game.currentPlayer);
           if(returnValue < 0 || this.gameOver(this.game.currentPlayer)){
               return;
           }
           
           this.computerTakesTurn(this.game.otherPlayer);
           System.out.println("\n\tThe computer also took it's turn");
           this.displayBoard();
           if(returnValue < 0 || this.gameOver(this.game.otherPlayer)){
           }
       }
    }
   
       
   public void displayBoard() {
        boardView.displayBoard(this.board);
    }
   
   
    public void startNewGame() {
        this.game.start();
        this.displayBoard();
    }
    
    
            
    
    
    

    
    
    public void displayPreferencesMenu(){
        GamePreferencesMenuView gamePreferenceMenuView = new GamePreferencesMenuView(this.game);
        gamePreferenceMenuView.getInput();
    }
    
    public void displayHelpMenu() {
        HelpMenuView helpMenu;
        helpMenu = new HelpMenuView();
//        HelpMenuView.getInput();
    }

    private boolean gameOver(Player player){
        if (this.isWinner()){
            this.game.status = Game.WINNER;
            this.displayGameOverMessage(player, "Congratulations! You won the game");
            
            return true;
        }
        else if(this.isTie()){
            this.game.status = Game.TIE;
            this.displayGameOverMessage(player, "Better luck next time. The game is a tie");
            return true;
        }
        
        return false;
    }
    
    private void displayGameOverMessage(Player player, String message){
        System.out.println("\n\t-----------------------------------------------");
        System.out.println("\t " + player.name + ": " + message);
        System.out.println("\t------------------------------------------------");
    }
    
    private int regularPlayerTurn(Player player){
        
        if(!this.game.status.equals(Game.NEW_GAME) &&
           !this.game.status.equals(Game.PLAYING)){
           new ConnectFourError().displayError(
                    "There is no active game. You must start a new game before "
                    + "you can take a turn");
           return -1;
        }
        
        this.game.status = Game.PLAYING;
        
        GetLocationView getLocationView = new GetLocationView(this.game);
        Point location = getLocationView.getInput();
        if (location == null){
            return -1;
        }
        
        this.game.board.occupyLocation(player, location.x, location.y);
        
        return 0;
    }
    
    private void computerTakesTurn(Player player){
        Point location = this.getComputersSelection();
        this.game.board.occupyLocation(player, location.x, location.y);
    }
    
    public void alternatePlayers(){
        if(this.game.currentPlayer == this.game.playerA){
            this.game.currentPlayer = this.game.playerB;
            this.game.otherPlayer = this.game.playerA;
        } else{
            this.game.currentPlayer = this.game.playerA;
            this.game.otherPlayer = this.game.playerB;
        }
    }
    
    private Point getComputersSelection(){
        Point coordinate;
        
        coordinate = this.findWinningLocation(game.currentPlayer);
        if(coordinate != null){
            return coordinate;
        }
        
        coordinate = this.findWinningLocation(game.otherPlayer);
        if(coordinate == null){
            coordinate = this.chooseRandomLocation();
            
            if (coordinate == null){
                new ConnectFourError().displayError("No empty locations found on the board");
                return null;
            }
        }
        
        return coordinate;
    }

    private boolean isTie(){
        
        Player[][] locations = this.board.getBoardLocations();
        
        for (Player[] rowLocations : locations) {
            for (int col = 0; col < rowLocations.length; col++) {
                Player location = rowLocations[col];
                if (rowLocations[col] == null) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isWinner(){
        
        Player[][]locations = this.board.getBoardLocations();
        
        for (int row =0; row < locations.length; row++){
            
            Player[] rowLocations = locations[row];
            
            for(int col = 0; col<rowLocations.length; col++){
                
                if(fourInARow(row,col,locations)){
                    return true;
                }
            }
        }
        
        return false;
    }
        private boolean fourInARow(int row, int col, Player[][] boardLocations) {
        boolean winner = false;

        int columnLength = boardLocations[row].length;
        int rowLength = boardLocations.length;

        // square not taken yet
        if (boardLocations[row][col] == null) {
            return false;
        } // search for three adjacent horizontally
        else if (row < rowLength && col < columnLength - 3
                && boardLocations[row][col] == boardLocations[row][col + 1]
                && boardLocations[row][col] == boardLocations[row][col + 2]
                && boardLocations[row][col] == boardLocations[row][col + 3]) {
            return true;
        } // search for three adjacent vertically
        else if (row < rowLength - 3 && col < columnLength
                && boardLocations[row][col] == boardLocations[row + 1][col]
                && boardLocations[row][col] == boardLocations[row + 2][col]
                && boardLocations[row][col] == boardLocations[row + 3][col]) {
            return true;
        } // search for three adjacent diagonally leaning backward
        else if (row < rowLength - 3 && col < columnLength - 3
                && boardLocations[row][col] == boardLocations[row + 1][col + 1]
                && boardLocations[row][col] == boardLocations[row + 2][col + 2]
                && boardLocations[row][col] == boardLocations[row+ 3][col + 3]) {
            return true;
        } // search for three adjacent diagonally learning forward
        else if (row < rowLength - 3 && col > 1
                && boardLocations[row][col] == boardLocations[row + 1][col - 1]
                && boardLocations[row][col] == boardLocations[row + 2][col - 2]
                && boardLocations[row][col] == boardLocations[row + 3][col - 3]) {
            return true;
        }

        return false;
    }
     private Point findWinningLocation(Player player) {
        Point coordinate = new Point();
        Player[][] locations = this.board.getBoardLocations();
        for (int row = 0; row < locations.length; row++) {
            Player[] rowLocations = locations[row];
            for (int col = 0; col < rowLocations.length; col++) {
                Player location = rowLocations[col];
                coordinate.setLocation(row, col);

                if (rowLocations[col] != null) { // location is occupied
                    continue;
                }

                // search for four adjacent horizontally
                if ((row < locations.length
                        && col < rowLocations.length - 2)
                        && (locations[row][col + 1] == player
                        && locations[row][col + 2] == player
                        && locations[row][col +3 ] == player)) {
                    return coordinate;
                } else if ((row < locations.length
                        && col > 0 && col < rowLocations.length - 1)
                        && (locations[row][col - 1] == player
                        && locations[row][col + 1] == player
                        && locations[row][col + 2] == player)) {
                    return coordinate;
                } else if ((row < locations.length && col > 1)
                        && (locations[row][col - 1] == player
                        && locations[row][col - 2] == player
                        && locations[row][col - 3] == player)) {
                    return coordinate;
                } // search for four adjacent vertically
                else if ((row < locations.length - 2
                        && col < rowLocations.length)
                        && (locations[row + 1][col] == player
                        && locations[row + 2][col] == player
                        && locations[row + 3][col] == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col < rowLocations.length)
                        && (locations[row - 1][col] == player
                        && locations[row + 1][col] == player
                        && locations[row + 2][col] == player)) {
                    return coordinate;
                } else if ((row > 1 && col < rowLocations.length)
                        && (locations[row - 1][col] == player
                        && locations[row - 2][col] == player
                        && locations[row -3][col] == player)) {
                    return coordinate;
                } // search for four adjacent diagonally leaning backward
                else if ((row < locations.length - 2
                        && col < rowLocations.length - 2)
                        && (locations[row + 1][col + 1] == player
                        && locations[row + 2][col + 2] == player
                        && locations[row + 3][col + 3] == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col > 0 && col < rowLocations.length - 1)
                        && (locations[row - 1][col + 1] == player
                        && locations[row + 1][col - 1] == player
                        && locations[row + 2][col - 2] == player)) {
                    return coordinate;
                } else if ((row > 1 && col > 1)
                        && (locations[row - 1][col - 1] == player
                        && locations[row - 2][col - 2] == player
                        && locations[row -3][col - 3] == player)) {
                    return coordinate;
                } // search for three adjacent diagonally learning forward
                else if ((row < locations.length - 2 && col > 1)
                        && (locations[row + 1][col - 1] == player
                        && locations[row + 2][col - 2] == player)) {
                    return coordinate;
                } else if ((row > 0 && row < locations.length - 1
                        && col > 0 && col < rowLocations.length - 1)
                        && (locations[row - 1][col + 1] == player
                        && locations[row + 1][col - 1] == player
                        && locations[row - 2][col - 2] == player)) {
                    return coordinate;
                } else if ((row > 1 && col < rowLocations.length - 2)
                        && (locations[row - 1][col + 1] == player
                        && locations[row - 2][col + 2] == player
                        && locations[row -3][col + 3] == player)) {
                    return coordinate;
                }
            }
        }

        return null;
    }
     
     private Point chooseRandomLocation(){
         Point randomLocation;
         
         ArrayList<Point> listOfEmptyLocations = new ArrayList<>();
         Player[][] locations = this.board.getBoardLocations();
         
         for (int row = 0; row<locations.length;row++){
             Player[] rowLocations = locations[row];
             for (int col = 0; col < rowLocations.length; col++){
                 Player location = rowLocations[col];
                 if (location == null){
                     listOfEmptyLocations.add(new Point(row, col));
                 }
             }
         }
         
         int noOfEmptyLocations = listOfEmptyLocations.size();
         
         if (noOfEmptyLocations == 0){
             return null;
             
         }
         else if (listOfEmptyLocations.size()== 1){
             randomLocation = listOfEmptyLocations.get(0);
             return randomLocation;
         }
         else {
             int randomNumber = new Random().nextInt(noOfEmptyLocations);
             randomLocation = listOfEmptyLocations.get(randomNumber);
             return randomLocation;
         }
     }
     
     public void clearTheBoard(){
         Player[][] locations = this.game.board.getBoardLocations();
         
         for (int i=0; i < this.board.getBoardLocations().length; i++){
             Player[] rowlocations = locations[i];
             for (int j=0; j< rowlocations.length;j++){
                 rowlocations[j] = null;
             }
         }
        }
   
        
    
}